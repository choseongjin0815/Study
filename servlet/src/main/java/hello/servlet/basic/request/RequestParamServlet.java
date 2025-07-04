package hello.servlet.basic.request;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Enumeration;

/**
 * 1. 파라미터 전송기능
 *
 */

@WebServlet(name = "requestParamServlet", urlPatterns = "/request-param")
public class RequestParamServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("[전체 파라미터 조회] start");

        request.getParameterNames().asIterator().forEachRemaining(
                paramName -> System.out.println(paramName + " = " + request.getParameter(paramName))
        );
        System.out.println("[전체 파라미터 조회] end");
//        Enumeration<String> request.getParameterNames();

        System.out.println("[단일 파라미터 조회] start");
        String name = request.getParameter("username");
        String age = request.getParameter("age");

        System.out.println("username = " + name);
        System.out.println("age = " + age);

        System.out.println("[단일 파라미터 조회] end");

        System.out.println("이름이 같은 복수 파라미터 조회");
        String[] usernames = request.getParameterValues("username");

        for(String s : usernames) {
            System.out.println(s);
        }

        System.out.println("이름이 같은 복수 파라미터 조회 end");
    }


}
