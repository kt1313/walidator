package pl.javastart.validator;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/verify")
public class PasswordController extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String password = request.getParameter("pass");
        String invalidPassword = PasswordValidator.validation(password);
        sendResponse(response, invalidPassword, password);
    }

    private void sendResponse(HttpServletResponse response, String invalidPassword, String password) throws IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        PrintWriter writer = response.getWriter();
        writer.println("<!DOCTYPE html>");
        writer.println("<html>");
        writer.println("<body>");
        writer.println("<h2>Twoje hasło to: " + password + "</h2>");
        if (invalidPassword.isEmpty()) {
            writer.println("<p>Hasło spełnia wszystkie kryteria bezpieczeństwa</p>");
        } else {
            writer.println("<ul>");
            writer.println(invalidPassword);
            writer.println("</ul>");
        }
        writer.println("</body>");
        writer.println("</html>");
    }
}