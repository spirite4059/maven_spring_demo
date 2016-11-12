package org.apache.jsp.WEB_002dINF.view;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.*;

public final class user_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List _jspx_dependants;

  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fshiro_005fauthenticated;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fshiro_005fhasRole_0026_005fname;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fshiro_005flacksPermission_0026_005fname;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.AnnotationProcessor _jsp_annotationprocessor;

  public Object getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _005fjspx_005ftagPool_005fshiro_005fauthenticated = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005fshiro_005fhasRole_0026_005fname = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005fshiro_005flacksPermission_0026_005fname = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_annotationprocessor = (org.apache.AnnotationProcessor) getServletConfig().getServletContext().getAttribute(org.apache.AnnotationProcessor.class.getName());
  }

  public void _jspDestroy() {
    _005fjspx_005ftagPool_005fshiro_005fauthenticated.release();
    _005fjspx_005ftagPool_005fshiro_005fhasRole_0026_005fname.release();
    _005fjspx_005ftagPool_005fshiro_005flacksPermission_0026_005fname.release();
    _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems.release();
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

      out.write("  \r\n");
      out.write("  \r\n");
      out.write("  \r\n");
      out.write("\r\n");
      out.write("    <!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">  \r\n");
      out.write("    <html>  \r\n");
      out.write("      <head>  \r\n");
      out.write("        <title>用户列表</title>  \r\n");
      out.write("      </head>  \r\n");
      out.write("      <body>  \r\n");
      out.write("        <h1>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${message }", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("</h1>  \r\n");
      out.write("        <h1>用户列表--<a href=\"/user/add\">添加用户</a>---<a href=\"/logout\">退出登录</a>    </h1> \r\n");
      out.write("        <h2>权限列表</h2>  \r\n");
      out.write("\t        ");
      if (_jspx_meth_shiro_005fauthenticated_005f0(_jspx_page_context))
        return;
      out.write("   <br>\r\n");
      out.write("\t        ");
      if (_jspx_meth_shiro_005fhasRole_005f0(_jspx_page_context))
        return;
      out.write("   <br>\r\n");
      out.write("\t        ");
      if (_jspx_meth_shiro_005fhasRole_005f1(_jspx_page_context))
        return;
      out.write("  <br>\r\n");
      out.write("\t        ");
      if (_jspx_meth_shiro_005fhasRole_005f2(_jspx_page_context))
        return;
      out.write("  <br>\r\n");
      out.write("\r\n");
      out.write("\t        ");
      if (_jspx_meth_shiro_005flacksPermission_005f0(_jspx_page_context))
        return;
      out.write("  <br>\r\n");
      out.write("        <ul>  \r\n");
      out.write("            ");
      if (_jspx_meth_c_005fforEach_005f0(_jspx_page_context))
        return;
      out.write("  \r\n");
      out.write("        </ul>  \r\n");
      out.write("        <img alt=\"\" src=\"/static/img/1.jpg\">  \r\n");
      out.write("        <script type=\"text/javascript\" src=\"http://cdn.staticfile.org/jquery/1.9.1/jquery.min.js\"></script>  \r\n");
      out.write("        <script>  \r\n");
      out.write("            $(function(){  \r\n");
      out.write("                $(\".del\").click(function(){  \r\n");
      out.write("                    var id=$(this).attr(\"ref\");  \r\n");
      out.write("                    $.ajax({  \r\n");
      out.write("                        type:\"delete\",  \r\n");
      out.write("                        url:\"/user/del/\"+id,  \r\n");
      out.write("                        success:function(e){  \r\n");
      out.write("                              \r\n");
      out.write("                        }  \r\n");
      out.write("                    });  \r\n");
      out.write("                });  \r\n");
      out.write("            });  \r\n");
      out.write("        </script>  \r\n");
      out.write("      </body>  \r\n");
      out.write("    </html>  \r\n");
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

  private boolean _jspx_meth_shiro_005fauthenticated_005f0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  shiro:authenticated
    org.apache.shiro.web.tags.AuthenticatedTag _jspx_th_shiro_005fauthenticated_005f0 = (org.apache.shiro.web.tags.AuthenticatedTag) _005fjspx_005ftagPool_005fshiro_005fauthenticated.get(org.apache.shiro.web.tags.AuthenticatedTag.class);
    _jspx_th_shiro_005fauthenticated_005f0.setPageContext(_jspx_page_context);
    _jspx_th_shiro_005fauthenticated_005f0.setParent(null);
    int _jspx_eval_shiro_005fauthenticated_005f0 = _jspx_th_shiro_005fauthenticated_005f0.doStartTag();
    if (_jspx_eval_shiro_005fauthenticated_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("用户已经登录显示此内容");
        int evalDoAfterBody = _jspx_th_shiro_005fauthenticated_005f0.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_shiro_005fauthenticated_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fshiro_005fauthenticated.reuse(_jspx_th_shiro_005fauthenticated_005f0);
      return true;
    }
    _005fjspx_005ftagPool_005fshiro_005fauthenticated.reuse(_jspx_th_shiro_005fauthenticated_005f0);
    return false;
  }

  private boolean _jspx_meth_shiro_005fhasRole_005f0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  shiro:hasRole
    org.apache.shiro.web.tags.HasRoleTag _jspx_th_shiro_005fhasRole_005f0 = (org.apache.shiro.web.tags.HasRoleTag) _005fjspx_005ftagPool_005fshiro_005fhasRole_0026_005fname.get(org.apache.shiro.web.tags.HasRoleTag.class);
    _jspx_th_shiro_005fhasRole_005f0.setPageContext(_jspx_page_context);
    _jspx_th_shiro_005fhasRole_005f0.setParent(null);
    // /WEB-INF/view/user.jsp(15,9) name = name type = null reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_shiro_005fhasRole_005f0.setName("manager");
    int _jspx_eval_shiro_005fhasRole_005f0 = _jspx_th_shiro_005fhasRole_005f0.doStartTag();
    if (_jspx_eval_shiro_005fhasRole_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("manager角色登录显示此内容");
        int evalDoAfterBody = _jspx_th_shiro_005fhasRole_005f0.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_shiro_005fhasRole_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fshiro_005fhasRole_0026_005fname.reuse(_jspx_th_shiro_005fhasRole_005f0);
      return true;
    }
    _005fjspx_005ftagPool_005fshiro_005fhasRole_0026_005fname.reuse(_jspx_th_shiro_005fhasRole_005f0);
    return false;
  }

  private boolean _jspx_meth_shiro_005fhasRole_005f1(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  shiro:hasRole
    org.apache.shiro.web.tags.HasRoleTag _jspx_th_shiro_005fhasRole_005f1 = (org.apache.shiro.web.tags.HasRoleTag) _005fjspx_005ftagPool_005fshiro_005fhasRole_0026_005fname.get(org.apache.shiro.web.tags.HasRoleTag.class);
    _jspx_th_shiro_005fhasRole_005f1.setPageContext(_jspx_page_context);
    _jspx_th_shiro_005fhasRole_005f1.setParent(null);
    // /WEB-INF/view/user.jsp(16,9) name = name type = null reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_shiro_005fhasRole_005f1.setName("admin");
    int _jspx_eval_shiro_005fhasRole_005f1 = _jspx_th_shiro_005fhasRole_005f1.doStartTag();
    if (_jspx_eval_shiro_005fhasRole_005f1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("admin角色登录显示此内容");
        int evalDoAfterBody = _jspx_th_shiro_005fhasRole_005f1.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_shiro_005fhasRole_005f1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fshiro_005fhasRole_0026_005fname.reuse(_jspx_th_shiro_005fhasRole_005f1);
      return true;
    }
    _005fjspx_005ftagPool_005fshiro_005fhasRole_0026_005fname.reuse(_jspx_th_shiro_005fhasRole_005f1);
    return false;
  }

  private boolean _jspx_meth_shiro_005fhasRole_005f2(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  shiro:hasRole
    org.apache.shiro.web.tags.HasRoleTag _jspx_th_shiro_005fhasRole_005f2 = (org.apache.shiro.web.tags.HasRoleTag) _005fjspx_005ftagPool_005fshiro_005fhasRole_0026_005fname.get(org.apache.shiro.web.tags.HasRoleTag.class);
    _jspx_th_shiro_005fhasRole_005f2.setPageContext(_jspx_page_context);
    _jspx_th_shiro_005fhasRole_005f2.setParent(null);
    // /WEB-INF/view/user.jsp(17,9) name = name type = null reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_shiro_005fhasRole_005f2.setName("normal");
    int _jspx_eval_shiro_005fhasRole_005f2 = _jspx_th_shiro_005fhasRole_005f2.doStartTag();
    if (_jspx_eval_shiro_005fhasRole_005f2 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("normal角色登录显示此内容");
        int evalDoAfterBody = _jspx_th_shiro_005fhasRole_005f2.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_shiro_005fhasRole_005f2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fshiro_005fhasRole_0026_005fname.reuse(_jspx_th_shiro_005fhasRole_005f2);
      return true;
    }
    _005fjspx_005ftagPool_005fshiro_005fhasRole_0026_005fname.reuse(_jspx_th_shiro_005fhasRole_005f2);
    return false;
  }

  private boolean _jspx_meth_shiro_005flacksPermission_005f0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  shiro:lacksPermission
    org.apache.shiro.web.tags.LacksPermissionTag _jspx_th_shiro_005flacksPermission_005f0 = (org.apache.shiro.web.tags.LacksPermissionTag) _005fjspx_005ftagPool_005fshiro_005flacksPermission_0026_005fname.get(org.apache.shiro.web.tags.LacksPermissionTag.class);
    _jspx_th_shiro_005flacksPermission_005f0.setPageContext(_jspx_page_context);
    _jspx_th_shiro_005flacksPermission_005f0.setParent(null);
    // /WEB-INF/view/user.jsp(19,9) name = name type = null reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_shiro_005flacksPermission_005f0.setName("user:del");
    int _jspx_eval_shiro_005flacksPermission_005f0 = _jspx_th_shiro_005flacksPermission_005f0.doStartTag();
    if (_jspx_eval_shiro_005flacksPermission_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write(" 不具有user:del权限的用户显示此内容 ");
        int evalDoAfterBody = _jspx_th_shiro_005flacksPermission_005f0.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_shiro_005flacksPermission_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fshiro_005flacksPermission_0026_005fname.reuse(_jspx_th_shiro_005flacksPermission_005f0);
      return true;
    }
    _005fjspx_005ftagPool_005fshiro_005flacksPermission_0026_005fname.reuse(_jspx_th_shiro_005flacksPermission_005f0);
    return false;
  }

  private boolean _jspx_meth_c_005fforEach_005f0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:forEach
    org.apache.taglibs.standard.tag.rt.core.ForEachTag _jspx_th_c_005fforEach_005f0 = (org.apache.taglibs.standard.tag.rt.core.ForEachTag) _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems.get(org.apache.taglibs.standard.tag.rt.core.ForEachTag.class);
    _jspx_th_c_005fforEach_005f0.setPageContext(_jspx_page_context);
    _jspx_th_c_005fforEach_005f0.setParent(null);
    // /WEB-INF/view/user.jsp(21,12) name = items type = javax.el.ValueExpression reqTime = true required = false fragment = false deferredValue = true expectedTypeName = java.lang.Object deferredMethod = false methodSignature = null
    _jspx_th_c_005fforEach_005f0.setItems(new org.apache.jasper.el.JspValueExpression("/WEB-INF/view/user.jsp(21,12) '${userList }'",_el_expressionfactory.createValueExpression(_jspx_page_context.getELContext(),"${userList }",java.lang.Object.class)).getValue(_jspx_page_context.getELContext()));
    // /WEB-INF/view/user.jsp(21,12) name = var type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fforEach_005f0.setVar("user");
    int[] _jspx_push_body_count_c_005fforEach_005f0 = new int[] { 0 };
    try {
      int _jspx_eval_c_005fforEach_005f0 = _jspx_th_c_005fforEach_005f0.doStartTag();
      if (_jspx_eval_c_005fforEach_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("  \r\n");
          out.write("                <li>用户名：");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${user.username }", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
          out.write("----密码：");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${user.password }", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
          out.write("----<a href=\"/user/edit/");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${user.id}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
          out.write("\">修改用户</a>----<a href=\"javascript:;\" class=\"del\" ref=\"");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${user.id }", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
          out.write("\">删除用户</a></li>  \r\n");
          out.write("            ");
          int evalDoAfterBody = _jspx_th_c_005fforEach_005f0.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_c_005fforEach_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (Throwable _jspx_exception) {
      while (_jspx_push_body_count_c_005fforEach_005f0[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_c_005fforEach_005f0.doCatch(_jspx_exception);
    } finally {
      _jspx_th_c_005fforEach_005f0.doFinally();
      _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems.reuse(_jspx_th_c_005fforEach_005f0);
    }
    return false;
  }
}
