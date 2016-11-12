package org.apache.jsp.WEB_002dINF.view;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class login_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List _jspx_dependants;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.AnnotationProcessor _jsp_annotationprocessor;

  public Object getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_annotationprocessor = (org.apache.AnnotationProcessor) getServletConfig().getServletContext().getAttribute(org.apache.AnnotationProcessor.class.getName());
  }

  public void _jspDestroy() {
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("\r\n");

  String path = request.getContextPath();
  String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";

      out.write("\r\n");
      out.write("\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("  <title></title>\r\n");
      out.write("  <base href=\"");
      out.print(basePath);
      out.write("\"/>\r\n");
      out.write("  <link rel=\"stylesheet\" type=\"text/css\" href=\"resources/style/subPage.css\"/>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\r\n");
      out.write("<div style=\"...\">\r\n");
      out.write("        <img alt=\"\" src=\"/static/img/2.jpg\">  \r\n");
      out.write("  <div style=\"...\">\r\n");
      out.write("    <form id=\"loginForm\" action=\"login\" method=\"post\">\r\n");
      out.write("      <div class=\"login_header\">智慧人生</div>\r\n");
      out.write("      <div style=\"...\">\r\n");
      out.write("        <div style=\"...\">\r\n");
      out.write("          <div style=\"...\">\r\n");
      out.write("            账&nbsp;&nbsp;号:\r\n");
      out.write("          </div>\r\n");
      out.write("          <!-- 特别注意  name=\"username\" 这个必须写死,不能做更改-->\r\n");
      out.write("          <input type=\"text\" name=\"username\" style=\"...\"/>\r\n");
      out.write("          <div style=\"...\">\r\n");
      out.write("            密&nbsp;&nbsp;码:\r\n");
      out.write("          </div>\r\n");
      out.write("          <!-- 特别注意  name=\"password\" 这个必须写死,不能做更改-->\r\n");
      out.write("          <input type=\"password\" name=\"password\" style=\"...\"/>\r\n");
      out.write("        </div>\r\n");
      out.write("      </div>\r\n");
      out.write("      <div style=\"...\">\r\n");
      out.write("        <input type=\"submit\" style=\"...\" value=\"登&nbsp;&nbsp;录\" />\r\n");
      out.write("      </div>\r\n");
      out.write("      <div style=\"...\">\r\n");
      out.write("        ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${message}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("\r\n");
      out.write("      </div>\r\n");
      out.write("    </form>\r\n");
      out.write("  </div>\r\n");
      out.write("</div>\r\n");
      out.write("\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
