package net.fullstack7.filters;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.annotation.WebInitParam;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;

@WebFilter(
		filterName = "LoginCheckFilter2",
		urlPatterns = { "/bbs/view", "/bbs/modify", "/bbs/memberRegist"},     //"member/*....하위전부" 필터를 많이 걸게 될수록 느려짐
		initParams = {
				@WebInitParam(name = "FILTER_INIT_PARAM2", value="초기화 매개 변수 2")
		}
)

public class LoginCheckFilter2 extends HttpFilter implements Filter {
       
private FilterConfig filterConfig;
	
    public LoginCheckFilter2() {
        super();
        // TODO Auto-generated constructor stub
    }
    
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
		filterConfig = fConfig;
		String filterName = filterConfig.getFilterName();
		System.out.println("=====================");
		System.out.println("logincheckfilter2 start");
		System.out.println("초기화 시점에 한번만 호출합니다.");
		System.out.println("logincheckfilter2 >> init() >> filterName :" + filterName);
		
	}

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest)request;
		HttpServletResponse res = (HttpServletResponse)response;
		
		String filterInitName = filterConfig.getInitParameter("FILTER_INIT_PARAM2");
		String methodName = req.getMethod();
		HttpSession session = req.getSession();
		
		System.out.println("LoginCheckFilter2 >> doFilter() >> filerInitName" + filterInitName);
		System.out.println("LoginCheckFilter2 >> doFilter() >> methodName" + methodName);
//		if(methodName.equals("GET")) {}// get방식 혹은 post방식에서만할거
		if(session.getAttribute("LOGININFO") == null) {
			res.setContentType("text/html;charset=UTF-8");
			PrintWriter wrt = res.getWriter();
			StringBuilder sb = new StringBuilder();
			sb.append("<script>");
			sb.append("alert('로그인 후 사용 가능합니다.');");
			sb.append("window.location.href='/mvc/bbs/list';");
			sb.append("</script>");
			
			System.out.println("LoginCheckFilter1 >> doFilter() >> script : " + sb.toString());
			
			wrt.print(sb.toString());
			wrt.close();
			return;
		}else {
			chain.doFilter(request, response);
		}
	}
}
