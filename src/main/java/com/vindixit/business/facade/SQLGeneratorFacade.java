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
				+ "    FLG_MULTIPLAS_CONEXOES\r\n" + "  )\r\n" + "VALUES\r\n" + " (\r\n";
		s += "    '00001'," + "\n";
		s += "    LPAD('" + cpf + "',11,0)," + "\n";
		s += "    TRIM('" + nome + "')," + "\n";
		s += "    '" + SENHA + "'," + "\n";
		s += "    TRIM('" + email + "')," + "\n";
		s += "    TRIM('" + matricula + "')," + "\n";
		s += "    sysdate," + "\n";
		s += "    '1','',null,null,null,'0','0'\r\n" + "  );" + "\n\n\n";
		return s;
	}

	public String cadastroPerfilInstitucionalUG(List row, String anoExercicio) {

		String cpf = ((String) row.get(0));
		String ugLotacao = (String) row.get(2);
		String ugExecucao = (String) row.get(3);

		// (Se a UG de Lotação <E> não for: 999900, 200700, 200800, 200299
		// E Se a UG de Lotação <E> não iniciar por 299)
		// OU Se a UG de Lotação for a 299004
		// ENTÃO o usuário pode executar na UG de Execução cadastrada.

		String s = "";
		if (null != ugLotacao
				&& (ugLotacao.equals("299004") || (!"999900, 200700, 200800, 200299".contains(ugLotacao)) && !"200299".equals(ugExecucao))) {

			s = "INSERT\r\n" + "INTO SIAFE_RIO_"+anoExercicio+".SPA_PERFIL_INSTITUCIONAL_UG\r\n" + "  (\r\n"
					+ "    ANO_EXERCICIO_CTX,\r\n" + "    COD_CLIENTE_CTX,\r\n" + "    COD_USUARIO,\r\n"
					+ "    COD_UG,\r\n" + "    IND_NIVEL_ACESSO,\r\n" + "    COD_UG_PRINCIPAL\r\n" + "  )\r\n"
					+ "  VALUES\r\n" + "  (\r\n" + "    '"+anoExercicio+"', \r\n" + "    '00001', \r\n" + "    LPAD('" + cpf
					+ "',11,0), \r\n" + "    LPAD('" + ugExecucao + "', 6, 0), \r\n" + "    1, \r\n" + "    LPAD('"
					+ ugExecucao + "', 6, 0)\r\n" + "  );\r\n\n\n";
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

			s = "INSERT\r\n" + "INTO SIAFE_RIO_"+anoExercicio+".SPA_PERFIL_INSTITUCIONAL_UG\r\n" + "  (\r\n"
					+ "    ANO_EXERCICIO_CTX,\r\n" + "    COD_CLIENTE_CTX,\r\n" + "    COD_USUARIO,\r\n"
					+ "    COD_UG,\r\n" + "    IND_NIVEL_ACESSO,\r\n" + "    COD_UG_PRINCIPAL\r\n" + ")\r\n"
					+ "SELECT '"+anoExercicio+"' ANO_EXERCICIO_CTX,'00001' COD_CLIENTE_CTX,LPAD(A.COD_USUARIO,11,0) COD_USUARIO, LPAD(B.COD_UG, 6, 0) COD_UG, 1 IND_NIVEL_ACESSO,\r\n"
					+ "LPAD('" + ugPrincipal + "',6,0)\r\n"
					+ "FROM SIAFE_RIO.SEG_USUARIO A, SIAFE_RIO_"+anoExercicio+".SPA_UG B\r\n" + "    WHERE A.COD_USUARIO = LPAD('"
					+ cpf + "',6,0) \r\n" + "    AND NOT EXISTS (\r\n"
					+ "        SELECT 1 FROM SIAFE_RIO_"+anoExercicio+".SPA_UG C \r\n" + "        WHERE B.COD_UG = C.COD_UG\r\n"
					+ "        AND C.COD_UG <> LPAD('" + ugLotacao + "', 6, 0)\r\n"
					+ "        AND (COD_UG LIKE '299%' OR COD_UG IN ('200299','200700','200800'))\r\n"
					+ "        AND LPAD('" + ugLotacao + "', 6, 0) NOT IN ('299005','299006','299007')\r\n" + "  )\r\n"
					+ "ORDER BY B.COD_UG;\n\n\n";

		}

		return s;
	}

	public String cadastroPerfilInstitucionalCONF(List row, String anoExercicio) {

		String cpf = ((String) row.get(0));
		String ugLotacao = (String) row.get(2);

		String s = "";
		if (null != ugLotacao && ("299004, 299005, 299006, 299007, 299009".contains(ugLotacao))) {
			s = "INSERT\r\n";
			s += "INTO SIAFE_RIO_"+anoExercicio+".SPA_PERFIL_INSTITUCIONAL_CONF\n\r" + " (\n\r" + "    ANO_EXERCICIO_CTX,\n\r"
					+ "    COD_CLIENTE_CTX,\n\r" + "    COD_USUARIO,\n\r" + "    COD_UG,\n\r" + "    FLG_GESTOR\n\r"
					+ "  )\n\r" + "  VALUES\n\r" + "  ('"+anoExercicio+"', '00001', LPAD('" + cpf + "',11,0),LPAD('" + ugLotacao
					+ "',6,0),'0');\n";

		} else {
			s = "-- SEM CONFORMIDADE\n\r";
		}

		return s;
	}

	public String cadastroGrupos(List row) {

		String cpf = ((String) row.get(0));
		String grupos = "";
		for (int i = 10; i < row.size(); i++) {
			String g = ((String) row.get(i)).trim();
			if(!g.equals("")){
				grupos += g + "', '";
			}
		}

		String s = "";
			s += "INSERT\n";
			s += "INTO SIAFE_RIO.SEG_USUARIO_GRUPO\n";
			s += "  SELECT '00001',LPAD('" + cpf + "',11,0),COD_GRUPO FROM (\n";
			s += "    SELECT COD_CLIENTE_CTX, COD_GRUPO, CASE WHEN INSTR(DSC_GRUPO,'/') > 0 \n";
			s += "    THEN SUBSTR(DSC_GRUPO,1,INSTR(DSC_GRUPO,'/')-1) \n";
			s += "    ELSE DSC_GRUPO END AS DSC_GRUPO, FLG_ADMIN FROM SIAFE_RIO.SEG_GRUPO\n";
			s += "  ) \n";
			s += "  WHERE DSC_GRUPO IN ('" + grupos + "');\n\r";
			s = s.replaceAll("(, '')", "");

		return s;
	}
	
	
	public String cadastroGrupoFlexvision(){
		String s = "";
		s +="INSERT INTO SIAFE_RIO.SEG_USUARIO_GRUPO\n";
		s +="  SELECT '00001',\n";
		s +="	 A.cod_usuario,\n";
		s +="	 '70007'\n";
		s +="  FROM SIAFE_RIO.SEG_USUARIO A\n";
		s +="  WHERE NOT EXISTS\n";
		s +="	 (SELECT NULL\n";
		s +="	 FROM SIAFE_RIO.SEG_USUARIO_GRUPO B\n";
		s +="	 WHERE A.COD_USUARIO = B.COD_USUARIO\n";
		s +="	 AND B.COD_GRUPO     = '70007'\n";
		s +="	);\n";
		return s;
	}

}
