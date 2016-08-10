<!DOCTYPE HTML>
<html>
<head>
    <title>Recadastramento de Usuários</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
</head>
<body>
	<h1>Resultado</h1>
	<form action="recad" method="POST">
    	<p>Id: <input type="text" name="id" value="${recad.id}"/></p>
        <p>SQL: </p>
        <p><textarea name="content" rows="10" cols="50">${recad.content}</textarea></p>
    	<p><a href="recad">Ler de uma nova planilha</a></p>
    </form>
</body>
</html>