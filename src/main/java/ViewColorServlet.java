import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name="ViewColorServlet", urlPatterns = "/viewcolor")
public class ViewColorServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String color = request.getParameter("color");
        String redirectUrl = String.format("/viewcolor.jsp?color=%s", color);
        response.sendRedirect(redirectUrl);
    }
}

