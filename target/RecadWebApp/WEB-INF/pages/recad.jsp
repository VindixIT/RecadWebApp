<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<%@ page isELIgnored="false" %> 
<html>
<head>
    <title>Recadastramento de Usuários</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <style type="text/css">
body {
  font-family: sans-serif;
  font-size: 1em;
  color: #333;
  background-color: #ddd;
}

label {
  clear: both;
  display: block;
  font-size: 0.85em;
  font-weight: bold;
  padding: 0.8em 0 0.2em 0;
  user-select: none;
}

input, button {
  float: left;
  font-size: 1em;
  padding: 3px 6px;
  margin: 0;
  border: 1px solid #333;
  outline: 0;
  box-shadow: none;
}

::-moz-focus-inner { 
  padding: 0;
  border: 0;
}

.url {
  width: 40em;
  background-color: #fff;
  border-right: 0 none;
  border-radius: 3px 0 0 3px;
}

button {
  width: 5em;
  position: relative;
  background-color: #aaa;
  border-radius: 0 3px 3px 3px;
  cursor: pointer;
}

.copied::after {
  position: absolute;
  top: 12%;
  right: 110%;
  display: block;
  content: "copied";
  font-size: 0.75em;
  padding: 2px 3px;
  color: #fff;
  background-color: #000;
  border-radius: 3px;
  opacity: 0;
  will-change: opacity, transform;
  animation: showcopied 1.5s ease;
}

@keyframes showcopied {
  0% {
    opacity: 0;
    transform: translateX(100%);
  }
  70% {
    opacity: 1;
    transform: translateX(0);
  }
  100% {
    opacity: 0;
  }
}
</style>
</head>
<body onLoad="document.getElementById('id').focus()">
	<h1>Recadastramento de Usuários</h1>
    <form action="recad">
    	<label>URL da Planilha:</label>
    	<input type="text" size="120" name="id" id="id" value="" class="url"/><button type=submit>Gerar</button><button type=reset>Limpar</button>
    </form>
</body>
</html>