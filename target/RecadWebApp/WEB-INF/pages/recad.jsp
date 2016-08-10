<!DOCTYPE HTML>
<html>
<head>
    <title>Recadastramento de Usuários</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
</head>
<body>
	<h1>Recadastramento de Usuários</h1>
    <form action="recad" method="POST">
    	<p>Google Sheet ssID: <input type="text" name="id" /></p>
        <p>SQL: <br/>
        <textarea name="content" rows="30" cols="50" readonly="readonly"></textarea></p>
        <p><input type="submit" value="Gerar" /> <input type="reset" value="Limpar" /></p>
    </form>
</body>
</html>