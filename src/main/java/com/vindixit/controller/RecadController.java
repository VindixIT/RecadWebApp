package com.vindixit.controller;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.google.api.client.auth.oauth2.AuthorizationCodeRequestUrl;
import com.google.api.client.auth.oauth2.Credential;
import com.google.api.client.auth.oauth2.TokenResponse;
import com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeFlow;
import com.google.api.client.googleapis.auth.oauth2.GoogleClientSecrets;
import com.google.api.client.googleapis.auth.oauth2.GoogleClientSecrets.Details;
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.services.drive.DriveScopes;
import com.google.api.services.sheets.v4.Sheets;
import com.google.api.services.sheets.v4.Sheets.Spreadsheets;
import com.google.api.services.sheets.v4.model.ValueRange;
import com.vindixit.business.facade.SQLGeneratorFacade;
import com.vindixit.model.Recad;

@Controller
public class RecadController {

	private static HttpTransport HTTP_TRANSPORT;
	private static GoogleAuthorizationCodeFlow flow;
	private static Credential credential;
	private static String CLIENT_ID = "483811954263-92vval79jhbf232c5mogvmb7bna49rl7.apps.googleusercontent.com";
	private static String CLIENT_SECRET = "gOxKb9xx4_r9MukauIsH_CN-";
	private static String REDIRECT_URI = "http://localhost:8080/RecadWebApp/recad";
	private static final JsonFactory JSON_FACTORY = JacksonFactory.getDefaultInstance();
	private static final String APPLICATION_NAME = "RecadWebApp";
	private SQLGeneratorFacade sqlGeneratorFacade;

	@RequestMapping(value = "/service.do", method = RequestMethod.GET)
	public RedirectView service(Model model) {
		Recad recad = new Recad();
		model.addAttribute("recad", recad);
		if (credential != null) {
			return new RedirectView("recad");
		}
		return new RedirectView(authorize());
	}

	@RequestMapping(value = "/recad", method = RequestMethod.GET)
	public String recad(Model model) {
		return "recad";
	}

	@RequestMapping(value = "/recad", method = RequestMethod.GET, params = "code")
	public ModelAndView oauth2Callback(@RequestParam(value = "code") String code, ModelAndView mv) {
		TokenResponse response;
		try {
			response = flow.newTokenRequest(code).setRedirectUri(REDIRECT_URI).execute();
			credential = flow.createAndStoreCredential(response, "userID");
		} catch (IOException e) {
			e.printStackTrace();
		}
		return mv;
	}

	private String authorize() {
		AuthorizationCodeRequestUrl authorizationUrl;
		if (flow == null) {
			Details web = new Details();
			web.setClientId(CLIENT_ID);
			web.setClientSecret(CLIENT_SECRET);
			try {
				HTTP_TRANSPORT = GoogleNetHttpTransport.newTrustedTransport();
			} catch (GeneralSecurityException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			flow = new GoogleAuthorizationCodeFlow.Builder(HTTP_TRANSPORT,
					JSON_FACTORY, CLIENT_ID, CLIENT_SECRET, Arrays.asList(DriveScopes.DRIVE,
							"https://spreadsheets.google.com/feeds", "https://docs.google.com/feeds"))
									.setAccessType("online").setApprovalPrompt("auto").build();
		}
		authorizationUrl = flow.newAuthorizationUrl().setRedirectUri(REDIRECT_URI);
		return authorizationUrl.build();
	}

	@RequestMapping(value = "/recad", method = RequestMethod.POST)
	public String recadSubmit(@ModelAttribute Recad recad, Model model) {
		Sheets service;
		try {
			service = getSheetsService();
			String spreadsheetId = recad.getId();
			Spreadsheets spreadsheets = service.spreadsheets();
			String range = "Novos em 09_08_2016!A2:J";
			ValueRange response = service.spreadsheets().values().get(spreadsheetId, range).execute();
			List<List<Object>> values = response.getValues();
			String s = "";
			sqlGeneratorFacade = new SQLGeneratorFacade();
			for (List row : values) {
				s = s + sqlGeneratorFacade.cadastroUsuarios(row);
				s = s + sqlGeneratorFacade.cadastroPerfilInstitucionalUG(row);
			}
			recad.setContent(s);
		} catch (IOException e) {
			e.printStackTrace();
		}
		model.addAttribute("recad", recad);
		return "result";
	}

	public static Sheets getSheetsService() throws IOException {
		return new Sheets.Builder(HTTP_TRANSPORT, JSON_FACTORY, credential).setApplicationName(APPLICATION_NAME)
				.build();
	}

}