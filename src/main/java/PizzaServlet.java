import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "PizzaServlet", urlPatterns = "/pizza-order")
public class PizzaServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.getRequestDispatcher("/pizza-order.jsp").forward(request, response);
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String crust = request.getParameter("crust");
        String sauce = request.getParameter("sauce");
        String size = request.getParameter("size");
        String[] toppings = request.getParameterValues("toppings");
        String address = request.getParameter("address");

        System.out.println("Crust: " + crust);
        System.out.println("Sauce: " + sauce);
        System.out.println("Size: " + size);
        System.out.print("Toppings: ");
        if(toppings != null) {
            for (String topping : toppings) {
                System.out.print(topping + " ");
            }
        }
        System.out.println();
        System.out.println("Delivery Address: " + address);

        response.sendRedirect("pizza-order.jsp");
    }
}
