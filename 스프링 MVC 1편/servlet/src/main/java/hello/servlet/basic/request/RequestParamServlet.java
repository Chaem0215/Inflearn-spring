package hello.servlet.basic.request;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Enumeration;

/**
 * 1. 파라미터 전송 기능
 * http://localhost:8080/request-param?username=hello&age=20
 *
 */
@WebServlet(name = "requestParamServlet", urlPatterns = "/request-param")
public class RequestParamServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 전체 파라미터 조회
        System.out.println("[전체 파라미터 조회] - start");
        //Enumeration<String> parameterNames = request.getParameterNames(); // 모든 요청 파라미터 다 꺼냄
        request.getParameterNames().asIterator()
                        .forEachRemaining(paramName -> System.out.println(paramName + ": " + request.getParameter(paramName)));
        System.out.println("[전체 파라미터 조회] - end");

        // 단일 파라미터 조회
        System.out.println("[단일 파라미터 조회] - start");
        String userName = request.getParameter("userName");
        String age = request.getParameter("age");
        System.out.println("userName = "+ userName + ", age = " + age);
        System.out.println("[단일 파라미터 조회] - end");

        System.out.println("[이름이 같은 복수 파라미터 조회]");
        String[] userNames = request.getParameterValues("userName");
        for (String userName2 : userNames){
            System.out.println("userName2 = " + userName2);
        }
        response.getWriter().write("ok");
    }
}
