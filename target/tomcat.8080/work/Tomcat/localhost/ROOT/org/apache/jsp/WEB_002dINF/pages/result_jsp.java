/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.0.30
 * Generated at: 2016-08-14 01:50:40 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.pages;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class result_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = null;
  }

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

final java.lang.String _jspx_method = request.getMethod();
if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method) && !javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSPs only permit GET POST or HEAD");
return;
}

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("<!DOCTYPE HTML>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<style type=\"text/css\">\r\n");
      out.write("body {\r\n");
      out.write("\tfont-family: sans-serif;\r\n");
      out.write("\tfont-size: 1em;\r\n");
      out.write("\tcolor: #333;\r\n");
      out.write("\tbackground-color: #ddd;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("label {\r\n");
      out.write("\tclear: both;\r\n");
      out.write("\tdisplay: block;\r\n");
      out.write("\tfont-size: 0.85em;\r\n");
      out.write("\tfont-weight: bold;\r\n");
      out.write("\tpadding: 0.8em 0 0.2em 0;\r\n");
      out.write("\tuser-select: none;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("textarea {\r\n");
      out.write("\tfloat: left;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("input, button {\r\n");
      out.write("\tfloat: center;\r\n");
      out.write("\tfont-size: 1em;\r\n");
      out.write("\tpadding: 3px 6px;\r\n");
      out.write("\tmargin: 0;\r\n");
      out.write("\tborder: 1px solid #333;\r\n");
      out.write("\toutline: 0;\r\n");
      out.write("\tbox-shadow: none;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("::-moz-focus-inner {\r\n");
      out.write("\tpadding: 0;\r\n");
      out.write("\tborder: 0;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".url {\r\n");
      out.write("\twidth: 40em;\r\n");
      out.write("\tbackground-color: #fff;\r\n");
      out.write("\tborder-right: 0 none;\r\n");
      out.write("\tborder-radius: 3px 0 0 3px;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("button {\r\n");
      out.write("\twidth: 5em;\r\n");
      out.write("\tposition: relative;\r\n");
      out.write("\tbackground-color: #aaa;\r\n");
      out.write("\tborder-radius: 0 3px 3px 3px;\r\n");
      out.write("\tcursor: pointer;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".copied::after {\r\n");
      out.write("  position: absolute;\r\n");
      out.write("  top: 12%;\r\n");
      out.write("  right: 110%;\r\n");
      out.write("  display: block;\r\n");
      out.write("  content: \"copiado\";\r\n");
      out.write("  font-size: 0.75em;\r\n");
      out.write("  padding: 2px 3px;\r\n");
      out.write("  color: #fff;\r\n");
      out.write("  background-color: #22a;\r\n");
      out.write("  border-radius: 3px;\r\n");
      out.write("  opacity: 0;\r\n");
      out.write("  will-change: opacity, transform;\r\n");
      out.write("  animation: showcopied 1.5s ease;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("@keyframes showcopied {\r\n");
      out.write("  0% {\r\n");
      out.write("    opacity: 0;\r\n");
      out.write("    transform: translateX(100%);\r\n");
      out.write("  }\r\n");
      out.write("  70% {\r\n");
      out.write("    opacity: 1;\r\n");
      out.write("    transform: translateX(0);\r\n");
      out.write("  }\r\n");
      out.write("  100% {\r\n");
      out.write("    opacity: 0;\r\n");
      out.write("  }\r\n");
      out.write("}\r\n");
      out.write("</style>\r\n");
      out.write("\r\n");
      out.write("<SCRIPT LANGUAGE=\"JavaScript\">\r\n");
      out.write("\tfunction ClipBoard() {\r\n");
      out.write("\t\talert(content.selectionStart + ' ' + content.selectionEnd);\r\n");
      out.write("\t\talert(content.innerText);\r\n");
      out.write("\t}\r\n");
      out.write("</SCRIPT>\r\n");
      out.write("<title>Recadastramento de Usuários</title>\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\" />\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\t<h1>Resultado SQL</h1>\r\n");
      out.write("\t<form action=\"service.do\" method=\"#\">\r\n");
      out.write("\t\t<fieldset>\r\n");
      out.write("\t\t\t<dl>\r\n");
      out.write("\t\t\t\t<dt>\r\n");
      out.write("\t\t\t\t\t<label>ssID da Planilha:</label>\r\n");
      out.write("\t\t\t\t</dt>\r\n");
      out.write("\t\t\t\t<dd>\r\n");
      out.write("\t\t\t\t\t<input type=\"text\" name=\"id\" size=\"84\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${recad.id}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("\" />\r\n");
      out.write("\t\t\t\t</dd>\r\n");
      out.write("\t\t\t\t<dt>\r\n");
      out.write("\t\t\t\t\t<label>SQL:</label>\r\n");
      out.write("\t\t\t\t</dt>\r\n");
      out.write("\t\t\t\t<dd>\r\n");
      out.write("\t\t\t\t\t<button type=button data-copytarget=\"#content\">Copiar</button>\r\n");
      out.write("\t\t\t\t\t<button type=button onClick=\"window.location='service.do'\">Novo</button>\r\n");
      out.write("\t\t\t\t</dd>\r\n");
      out.write("\t\t\t\t<dd>\r\n");
      out.write("\t\t\t\t\t<textarea name=\"content\" id=\"content\" rows=\"30\" cols=\"100\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${recad.content}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("</textarea>\r\n");
      out.write("\t\t\t\t</dd>\r\n");
      out.write("\t\t\t</dl>\r\n");
      out.write("\t\t</fieldset>\r\n");
      out.write("\t</form>\r\n");
      out.write("</body>\r\n");
      out.write("\r\n");
      out.write("<SCRIPT LANGUAGE=\"JavaScript\">\r\n");
      out.write("\t(function() {\r\n");
      out.write("\r\n");
      out.write("\t\t'use strict';\r\n");
      out.write("\r\n");
      out.write("\t\t// click events\r\n");
      out.write("\t\tdocument.body.addEventListener('click', copy, true);\r\n");
      out.write("\r\n");
      out.write("\t\t// event handler\r\n");
      out.write("\t\tfunction copy(e) {\r\n");
      out.write("\r\n");
      out.write("\t\t\t// find target element\r\n");
      out.write("\t\t\tvar t = e.target, c = t.dataset.copytarget, inp = (c ? document\r\n");
      out.write("\t\t\t\t\t.querySelector(c) : null);\r\n");
      out.write("\r\n");
      out.write("\t\t\t// is element selectable?\r\n");
      out.write("\t\t\tif (inp && inp.select) {\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t// select text\r\n");
      out.write("\t\t\t\tinp.select();\r\n");
      out.write("\r\n");
      out.write("\t\t\t\ttry {\r\n");
      out.write("\t\t\t\t\t// copy text\r\n");
      out.write("\t\t\t\t\tdocument.execCommand('copy');\r\n");
      out.write("\t\t\t\t\tinp.blur();\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t// copied animation\r\n");
      out.write("\t\t\t\t\tt.classList.add('copied');\r\n");
      out.write("\t\t\t\t\tsetTimeout(function() {\r\n");
      out.write("\t\t\t\t\t\tt.classList.remove('copied');\r\n");
      out.write("\t\t\t\t\t}, 1500);\r\n");
      out.write("\t\t\t\t} catch (err) {\r\n");
      out.write("\t\t\t\t\talert('please press Ctrl/Cmd+C to copy');\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\r\n");
      out.write("\t\t}\r\n");
      out.write("\r\n");
      out.write("\t})();\r\n");
      out.write("</SCRIPT>\r\n");
      out.write("\r\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
