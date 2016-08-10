<!DOCTYPE HTML>
<html>
<head>
    <title>Recadastramento de Usuários</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
</head>
<body>
	<h1>Resultado</h1>
	<form action="recad" method="POST">
    	<p>Google Sheet ssID: <input type="text" name="id" value="${recad.id}"/></p>
        <p>SQL: <br/>
        <textarea name="content" rows="30" cols="50" readonly="readonly">${recad.content}</textarea></p>
    	<p><a href="service.do">Ler de uma nova planilha</a></p>
    </form>
</body>
</html>