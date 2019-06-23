package mainPackage;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AddRestaurant
 */
@WebServlet("/AddRestaurant")
public class AddRestaurant extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddRestaurant() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String name = request.getParameter("name");
		String address = request.getParameter("address");
		String type_food = request.getParameter("type_food");
		String type_user = request.getParameter("type_user");
		String username = request.getParameter("username");
		String information = request.getParameter("information");
		
		name=name.trim();
		address=address.trim();
		type_food=type_food.trim();
		type_user=type_user.trim();
		username=username.trim();
		information=information.trim();
		
		try {
			String email = Contact2db.get_mail(username);
			Contact2db.insertdb_restaurant(name, address, username, email, type_food, information);
			request.setAttribute("username", username);
			request.setAttribute("type_user", type_user);
			request.getRequestDispatcher("Restaurants.jsp").forward(request, response);
		}
		catch(Exception e) {
			System.out.println(e);
			 
		}
	}

}
