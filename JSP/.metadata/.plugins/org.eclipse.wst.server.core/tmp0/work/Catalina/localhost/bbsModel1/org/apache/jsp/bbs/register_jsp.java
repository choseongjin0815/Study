/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/10.1.29
 * Generated at: 2024-10-08 04:51:28 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.bbs;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.jsp.*;
import model1.bbs.BbsDTO;
import model1.bbs.BbsDAO;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

public final class register_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports,
                 org.apache.jasper.runtime.JspSourceDirectives {

  private static final jakarta.servlet.jsp.JspFactory _jspxFactory =
          jakarta.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(2);
    _jspx_dependants.put("/common/queryString.jsp", Long.valueOf(1728362801467L));
    _jspx_dependants.put("/common/header.jsp", Long.valueOf(1728362801448L));
  }

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.LinkedHashSet<>(4);
    _jspx_imports_packages.add("jakarta.servlet");
    _jspx_imports_packages.add("jakarta.servlet.http");
    _jspx_imports_packages.add("jakarta.servlet.jsp");
    _jspx_imports_classes = new java.util.LinkedHashSet<>(7);
    _jspx_imports_classes.add("java.util.List");
    _jspx_imports_classes.add("model1.bbs.BbsDTO");
    _jspx_imports_classes.add("java.util.Map");
    _jspx_imports_classes.add("model1.bbs.BbsDAO");
    _jspx_imports_classes.add("java.util.HashMap");
  }

  private volatile jakarta.el.ExpressionFactory _el_expressionfactory;
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

  public boolean getErrorOnELNotFound() {
    return false;
  }

  public jakarta.el.ExpressionFactory _jsp_getExpressionFactory() {
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

  public void _jspService(final jakarta.servlet.http.HttpServletRequest request, final jakarta.servlet.http.HttpServletResponse response)
      throws java.io.IOException, jakarta.servlet.ServletException {

    if (!jakarta.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      final java.lang.String _jspx_method = request.getMethod();
      if ("OPTIONS".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        return;
      }
      if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSP들은 오직 GET, POST 또는 HEAD 메소드만을 허용합니다. Jasper는 OPTIONS 메소드 또한 허용합니다.");
        return;
      }
    }

    final jakarta.servlet.jsp.PageContext pageContext;
    jakarta.servlet.http.HttpSession session = null;
    final jakarta.servlet.ServletContext application;
    final jakarta.servlet.ServletConfig config;
    jakarta.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    jakarta.servlet.jsp.JspWriter _jspx_out = null;
    jakarta.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("<head>\n");
      out.write("<meta charset=\"UTF-8\">\n");
      out.write("<title>Insert title here</title>\n");
      out.write("<style>\n");
      out.write("main input.btn_login {margin : 10px 0; background: #fff;}\n");
      out.write("#header {text-align : right;}\n");
      out.write("</style>\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("<main id=\"header\">\n");

// 세션에서 로그인 정보 유무 체크
String sessionId = "";
if (session.getAttribute("user_id") == null) {
	// 로그인 정보 없을 경우 [로그인] 버튼 표시

      out.write("<input type=\"button\" id=\"btn_login\" name=\"btn_login\" class=\"btn_login\" value=\"로그인\" />\n");
      out.write("	<script>\n");
      out.write("	const btn_login = document.querySelector(\"#btn_login\");\n");
      out.write("	btn_login.addEventListener(\"click\", (e)=> {\n");
      out.write("		location.href = \"/bbsModel1/login/login.jsp\";\n");
      out.write("	})\n");
      out.write("	</script>\n");
	
} else {
	// 로그인 정보 없을 경우 [로그아웃] 버튼 표시 + sessionId 값 저장
	sessionId = (String) session.getAttribute("user_id");

      out.write("<input type=\"button\" id=\"btn_logOut\" name=\"btn_logOut\" class=\"btn_login\" value=\"로그아웃\" />\n");
      out.write("	<script>\n");
      out.write("	const btn_logOut = document.querySelector(\"#btn_logOut\");\n");
      out.write("	btn_logOut.addEventListener(\"click\", (e)=> {\n");
      out.write("		location.href = \"/bbsModel1/login/logout.jsp\";\n");
      out.write("	})\n");
      out.write("	</script>\n");

}

      out.write("</main>\n");
      out.write("\n");
      out.write("</body>\n");
      out.write("</html>");

// 값 초기화
String search_category = "";
String search_word = "";
int page_selected = 1;

// 값 할당
if (request.getParameter("search_category") != null) {
	search_category = request.getParameter("search_category");
}
if(request.getParameter("search_word") != null) {
	search_word = request.getParameter("search_word");
}
if (request.getParameter("page_selected") != null) {
	page_selected = Integer.parseInt(request.getParameter("page_selected"));
}

//QreryString 만들
String queryStringPCW = "page_selected=" + page_selected + "&search_category=" + search_category + "&search_word=" + search_word;
String queryStringCW = "search_category=" + search_category + "&search_word=" + search_word;

      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("<head>\n");
      out.write("<meta charset=\"UTF-8\">\n");
      out.write("<title>게시판 리스트</title>\n");
      out.write("<style>\n");
      out.write("	* {margin : 0; padding : 0;}\n");
      out.write("	body {\n");
      out.write("		width : 100%;\n");
      out.write("		margin : 0 auto;\n");
      out.write("	}\n");
      out.write("	main {\n");
      out.write("		width : 1000px;\n");
      out.write("		margin : 0 auto;\n");
      out.write("	}\n");
      out.write("	h2 {\n");
      out.write("		padding : 20px;\n");
      out.write("		text-align : center;\n");
      out.write("	}\n");
      out.write("	table, tr, td, th {\n");
      out.write("		border-collapse:collapse;\n");
      out.write("		padding : 10px;\n");
      out.write("	}\n");
      out.write("	table {\n");
      out.write("		width : 100%;\n");
      out.write("		margin : 10px 0;\n");
      out.write("	}\n");
      out.write("	.border, .border tr, border th {\n");
      out.write("		border: 1px solid #aaa;		\n");
      out.write("	}\n");
      out.write("	.border td:nth-child(1), td:nth-child(3), td:nth-child(4){\n");
      out.write("		text-align : center;\n");
      out.write("	}\n");
      out.write("	.search_area {\n");
      out.write("		border: 1px solid #bbdbff;\n");
      out.write("		background : #bbdbff;\n");
      out.write("		text-align : center;\n");
      out.write("		height : 80px;\n");
      out.write("	}\n");
      out.write("	th {\n");
      out.write("		background : #e3f0ff;\n");
      out.write("	}\n");
      out.write("	input, select {\n");
      out.write("		box-sizing : border-box;\n");
      out.write("		height : 30px;\n");
      out.write("	}\n");
      out.write("	#search_word {\n");
      out.write("		width : 200px;\n");
      out.write("	}\n");
      out.write("	input[type = \"button\"], input[type = \"submit\"], input[type = \"reset\"] {\n");
      out.write("		background : #e3f0ff;\n");
      out.write("		border : 1px solid #aaa;\n");
      out.write("		padding : 0 10px;\n");
      out.write("	}\n");
      out.write("	table th:nth-child(1), table td:nth-child(1) {\n");
      out.write("		border: 1px solid #aaa;		\n");
      out.write("		background : #eee;\n");
      out.write("	}\n");
      out.write("	#btn_submit, #btn_cancel {\n");
      out.write("		float : right;\n");
      out.write("		margin-left : 5px;\n");
      out.write("	}\n");
      out.write("	a, a:link, a:hover, a:active, a:visited {\n");
      out.write("		color : #000;\n");
      out.write("		text-decoration : none;\n");
      out.write("	}\n");
      out.write("	a:hover {\n");
      out.write("		text-decoration : underline !important;\n");
      out.write("	}\n");
      out.write("	.warnning {\n");
      out.write("		color : red;\n");
      out.write("		text-align : center;\n");
      out.write("		font-weight : 800;\n");
      out.write("	}\n");
      out.write("</style>\n");
      out.write("</head>\n");
      out.write("<body>\n");

// 값 초기화
String user_id = "";
String title = "";
String content = "";
String fail = "";

// 로그인 여부 체크
if (sessionId.equals("")) {
	response.sendRedirect("/bbsModel1/login/login_fail.jsp");
} else {
	user_id = sessionId;
	if (request.getParameter("result") != null) {
		fail = "등록이 실패하였습니다 ㅜ ㅜ";
	}
	if (request.getParameter("title") != null) {
		title = request.getParameter("title");
	}
	if (request.getParameter("content") != null) {
		content = request.getParameter("content");
	}
}


      out.write("<main>\n");
      out.write("<h2><a href=\"list.jsp\">게시판 등록 페이지</a></h2>\n");
      out.write("<p class=\"warnning\">");
      out.print( fail );
      out.write("</p>\n");
      out.write("<form name=\"frmRegist\" id=\"frmRegist\" action=\"register_ok.jsp\" method=\"post\">\n");
      out.write("<table  class=\"border\">\n");
      out.write("	<tr>\n");
      out.write("		<td width=\"200\">작성자 :</td>\n");
      out.write("		<td width=\"600\"><input type=\"text\" name=\"user_id\" id=\"user_id\" value=\"");
      out.print( user_id );
      out.write("\" readonly/></td> \n");
      out.write("	</tr>\n");
      out.write("	<tr>\n");
      out.write("		<td width=\"200\">제목</td>\n");
      out.write("		<td colspan=\"3\"><input type=\"text\" name=\"title\" id=\"title\" value=\"");
      out.print( title );
      out.write("\"  maxlength=\"100\"/></td>\n");
      out.write("	</tr>\n");
      out.write("	<tr>\n");
      out.write("		<td width=\"200\">내용</td>\n");
      out.write("		<td colspan=\"3\">\n");
      out.write("			<textarea name=\"content\" id=\"content\" rows=\"10\" cols=\"80\">");
      out.print( content );
      out.write("</textarea>\n");
      out.write("		</td>\n");
      out.write("	</tr>\n");
      out.write("</table>\n");
      out.write("	<input type=\"submit\" name=\"btn_submit\" id=\"btn_submit\" value=\"글등록\" />\n");
      out.write("	<input type=\"reset\" name=\"btn_cancel\" id=\"btn_cancel\" value=\"초기화\" />\n");
      out.write("	<input type=\"button\" name=\"btn_list\" id=\"btn_list\" value=\"목록으로\" />\n");
      out.write("</form>\n");
      out.write("\n");
      out.write("</main>\n");
      out.write("<script>\n");
      out.write("const btn_list = document.querySelector(\"#btn_list\");\n");
      out.write("btn_list.addEventListener(\"click\", (e) => {\n");
      out.write("	window.location.replace(\"list.jsp?");
      out.print(queryStringPCW);
      out.write("\");\n");
      out.write("})\n");
      out.write("\n");
      out.write("const btn_submit = document.querySelector(\"#btn_submit\");\n");
      out.write("const frmRegist = document.querySelector(\"#frmRegist\");\n");
      out.write("frmRegist.addEventListener(\"submit\", (e)=> {\n");
      out.write("	e.preventDefault();\n");
      out.write("	let user_id = document.querySelector(\"#user_id\").value;\n");
      out.write("	let title = document.querySelector(\"#title\").value;\n");
      out.write("	let content = document.querySelector(\"#content\").value;\n");
      out.write("	\n");
      out.write("	\n");
      out.write("	if(user_id == null) return alert(\"작성자는 필수 입력사항 입니다.\");\n");
      out.write("	if(user_id != null) {\n");
      out.write("		user_id = user_id.trim();\n");
      out.write("		if(user_id == \"\") return alert(\"작성자는 필수 입력사항 입니다.\");\n");
      out.write("	}\n");
      out.write("	if(title == null) return alert(\"제목은 필수 입력사항 입니다.\");\n");
      out.write("	if(title != null) {\n");
      out.write("		title = title.trim();\n");
      out.write("		if(title == \"\") return alert(\"제목은 필수 입력사항 입니다.\");\n");
      out.write("	}\n");
      out.write("	if(content == null) return alert(\"내용은 필수 입력사항 입니다.\");\n");
      out.write("	if(content != null) {\n");
      out.write("		content = content.trim();\n");
      out.write("		if(content == \"\") return alert(\"내용은 필수 입력사항 입니다.\");\n");
      out.write("	}\n");
      out.write("	frmRegist.submit();\n");
      out.write("})\n");
      out.write("</script>\n");
      out.write("</body>\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof jakarta.servlet.jsp.SkipPageException)){
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
