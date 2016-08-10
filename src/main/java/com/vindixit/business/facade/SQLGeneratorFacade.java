package com.vindixit.business.facade;

import java.util.List;

public class SQLGeneratorFacade {

	private static String SENHA = "CRIPT_12be54caff3f32809ef5251120e8b5f1";

	public String cadastroUsuarios(List row) {
		String s;
		String cpf = ((String) row.get(0));
		String nome = ((String) row.get(1)).replace("'", "");
		String email = (String) row.get(4);
		String matricula = (String) row.get(6);

		s = "INSERT\r\n" + "INTO SIAFE_RIO.SEG_USUARIO\r\n" + "  (\r\n" + "    COD_CLIENTE_CTX,\r\n"
				+ "    COD_USUARIO,\r\n" + "    NOM_USUARIO,\r\n" + "    TXT_SENHA,\r\n" + "    DSC_EMAIL,\r\n"
				+ "    COD_MATRICULA,\r\n" + "    DAT_ATUALIZACAO,\r\n" + "    FLG_ATIVO,\r\n" + "    NUM_TELEFONE,\r\n"
				+ "    NUM_TELEFONE2,\r\n" + "    NUM_CELULAR,\r\n" + "    NUM_FAX,\r\n" + "    FLG_IMPORTACAO,\r\n"
				+ "    FLG_MULTIPLAS_CONEXOES\r\n" + "  )\r\n" + "VALUES\r\n"
						+ " (\r\n";
		s += "    '00001'," + "\n";
		s += "    LPAD('" + cpf + "',11,0)," + "\n";
		s += "    TRIM('" + nome + "')," + "\n";
		s += "    '" + SENHA + "'," + "\n";
		s += "    TRIM('" + email + "')," + "\n";
		s += "    TRIM('" + matricula + "')," + "\n";
		s += "    sysdate," + "\n";
		s += "    '1','',null,null,null,'0','0'\r\n"
				+ "  );" + "\n\n\n";
		return s;
	}

	public String cadastroPerfilInstitucionalUG(List row) {

		String cpf = ((String) row.get(0));
		String ugLotacao = (String) row.get(2);
		String ugExecucao = (String) row.get(3);

		// (Se a UG de Lotação <E> não for: 999900, 200700, 200800, 200299
		// E Se a UG de Lotação <E> não iniciar por 299)
		// OU Se a UG de Lotação for a 299004
		// ENTÃO o usuário pode executar na UG de Execução cadastrada.

		String s = "";
		if (null != ugLotacao
				&& (ugLotacao.equals("299004") || !"999900, 200700, 200800, 200299".contains(ugLotacao))) {

			s = "INSERT\r\n" + "INTO SIAFE_RIO_2016.SPA_PERFIL_INSTITUCIONAL_UG\r\n" + "  (\r\n"
					+ "    ANO_EXERCICIO_CTX,\r\n" + "    COD_CLIENTE_CTX,\r\n" + "    COD_USUARIO,\r\n" + "    COD_UG,\r\n"
					+ "    IND_NIVEL_ACESSO,\r\n" + "    COD_UG_PRINCIPAL\r\n" + "  )\r\n" + "  VALUES\r\n" + "  (\r\n"
					+ "    '2016', \r\n"
					+ "    '00001', \r\n" + "    LPAD('" + cpf + "',11,0), \r\n" + "    LPAD('" + ugExecucao + "', 6, 0), \r\n"
					+ "    1, \r\n" + "    LPAD('" + ugExecucao + "', 6, 0)\r\n"
					+ "  );\r\n\n\n";
		} else {

			String ugPrincipal = ugLotacao;

			if (ugLotacao.equals("299009")) {
				ugPrincipal = "999900";
			} else if (ugLotacao.equals("299005")) {
				ugPrincipal = "200299";
			} else if (ugLotacao.equals("299006")) {
				ugPrincipal = "200700";
			} else if (ugLotacao.equals("299007")) {
				ugPrincipal = "200800";
			}

			s = "INSERT\r\n" + "INTO SIAFE_RIO_2016.SPA_PERFIL_INSTITUCIONAL_UG\r\n" + "  (\r\n"
					+ "    ANO_EXERCICIO_CTX,\r\n" + "    COD_CLIENTE_CTX,\r\n" + "    COD_USUARIO,\r\n"
					+ "    COD_UG,\r\n" + "    IND_NIVEL_ACESSO,\r\n" + "    COD_UG_PRINCIPAL\r\n" + ")\r\n"
					+ "SELECT '2016' ANO_EXERCICIO_CTX,'00001' COD_CLIENTE_CTX,LPAD(A.COD_USUARIO,11,0) COD_USUARIO, LPAD(B.COD_UG, 6, 0) COD_UG, 1 IND_NIVEL_ACESSO,\r\n"
					+ "LPAD('"+ugPrincipal+"',6,0)\r\n"
					+ "FROM SIAFE_RIO.SEG_USUARIO A, SIAFE_RIO_2016.SPA_UG B\r\n" + "    WHERE A.COD_USUARIO = LPAD('"
					+ cpf + "',6,0) \r\n" + "    AND NOT EXISTS (\r\n"
					+ "        SELECT 1 FROM SIAFE_RIO_2016.SPA_UG C \r\n" + "        WHERE B.COD_UG = C.COD_UG\r\n"
					+ "        AND C.COD_UG <> LPAD('" + ugLotacao + "', 6, 0)\r\n"
					+ "        AND (COD_UG LIKE '299%' OR COD_UG IN ('200299','200700','200800'))\r\n"
					+ "        AND LPAD('" + ugLotacao + "', 6, 0) NOT IN ('299005','299006','299007')\r\n" + "  )\r\n"
					+ "ORDER BY B.COD_UG;\n\n\n";

		}

		return s;
	}
	
	/*
	 * =IF(OR(TRIM(E2)="299004";TRIM(E2)="299005";TRIM(E2)="299006";TRIM(E2)="299007";TRIM(E2)="299009");"Insert into SIAFE_RIO_2016.SPA_PERFIL_INSTITUCIONAL_CONF (ANO_EXERCICIO_CTX, COD_CLIENTE_CTX,COD_USUARIO,COD_UG,FLG_GESTOR) values ('2016', '00001', LPAD('"&C2&"',11,0),LPAD('"&E2&"',6,0),'0');";"-- SEM CONFORMIDADE")
	 */
	public String cadastroPerfilInstitucionalCONF(List row) {

		String cpf = ((String) row.get(0));
		String ugLotacao = (String) row.get(2);
		String ugExecucao = (String) row.get(3);
		return ugExecucao;
	}
}
