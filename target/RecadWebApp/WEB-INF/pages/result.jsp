<!DOCTYPE HTML>
<html>
<head>
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

input {
  width: 15em;
  background-color: #fff;
  border-right: 0 none;
  border-radius: 3px 0 0 3px;
}

button {
  position: relative;
  background-color: #aaa;
  border-radius: 0 3px 3px 0;
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

<SCRIPT LANGUAGE="JavaScript">
	function ClipBoard() {
		alert(content.selectionStart + ' ' + content.selectionEnd);
		alert(content.innerText);
	}
</SCRIPT>
<title>Recadastramento de Usuários</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
</head>
<body>
	<h1>Resultado SQL</h1>
	<form action="service.do" method="POST">
		<p>
			ssID da Planilha: <input type="text" name="id" size="120"
				value="${recad.id}" />
		</p>
		<p>
			SQL: <br />
			<textarea name="content" id="content" rows="30" cols="100">${recad.content}</textarea>
			<br />
			<button type=button data-copytarget="#content">copiar</button>
		</p>
		<p>
			<a href="service.do">Ler de uma nova planilha</a>
		</p>
	</form>
</body>

<SCRIPT LANGUAGE="JavaScript">
	(function() {

		'use strict';

		// click events
		document.body.addEventListener('click', copiar, true);

		// event handler
		function copiar(e) {

			// find target element
			var t = e.target, c = t.dataset.copytarget, inp = (c ? document
					.querySelector(c) : null);

			// is element selectable?
			if (inp && inp.select) {

				// select text
				inp.select();

				try {
					// copy text
					document.execCommand('copy');
					inp.blur();

					// copied animation
					t.classList.add('copied');
					setTimeout(function() {
						t.classList.remove('copied');
					}, 1500);
				} catch (err) {
					alert('please press Ctrl/Cmd+C to copy');
				}

			}

		}

	})();
</SCRIPT>

</html>