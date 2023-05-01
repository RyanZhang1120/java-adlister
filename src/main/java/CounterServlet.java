import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name="CounterServlet", urlPatterns = "/count")
public class CounterServlet extends HttpServlet {
    private int counter = 0;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        // Check if the reset parameter is present in the query string
        String reset = request.getParameter("reset");

        if (reset != null) {
            // Reset the counter
            counter = 0;
        } else {
            // Increment the counter
            counter++;
        }

        PrintWriter out = response.getWriter();
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Counter</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>Page View Count: " + counter + "</h1>");
        out.println("</body>");
        out.println("</html>");
    }
}


