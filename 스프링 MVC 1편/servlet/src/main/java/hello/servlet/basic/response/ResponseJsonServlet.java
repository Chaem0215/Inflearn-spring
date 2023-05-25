package hello.servlet.basic.response;

import com.fasterxml.jackson.databind.ObjectMapper;
import hello.servlet.basic.HelloData;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "responseJsonServlet", urlPatterns = "/response-json")
public class ResponseJsonServlet extends HttpServlet {
    private ObjectMapper objectMapper = new ObjectMapper();
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Content-type: application/json
        response.setContentType("application/json"); // HTTP 응답으로 JSON 반환할 때는 content-type을 "application/json"
        response.setCharacterEncoding("utf-8"); // "application/json" 은 스펙상 utf-8 사용하도록 정의되어 있음, 굳이 사용하지 않아도 됌.

        HelloData helloData = new HelloData();
        helloData.setUserName("kim");
        helloData.setAge(20);

        String result = objectMapper.writeValueAsString(helloData); // 객체를 문자로
        response.getWriter().write(result);
        // jackson 라이브러리가 제공하는 objectMapper.writeValueAsString 를 사용하면 객체를 JSON 문자로 변경 가능
    }
}
