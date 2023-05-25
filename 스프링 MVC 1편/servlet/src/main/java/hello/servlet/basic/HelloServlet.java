package hello.servlet.basic;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "helloServlet", urlPatterns = "/hello") // name과 url은 겹치면 안된다.
public class HelloServlet extends HttpServlet{
    // 서블릿 http 요청이 오면 was 서블릿 컨테이너가 response 객체를 서버가 만들어서 제공
    @Override // http 요청을 통해 매핑된 url이 호출되면 서블릿 컨테이너는 해당 메서드를 실행
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("HelloServlet.service");
        System.out.println(request);
        System.out.println(response);

        String username = request.getParameter("username");
        System.out.println(username);

        response.setContentType("text/plain");
        response.setCharacterEncoding("utf-8");
        response.getWriter().write("hello " + username);
    }
}
