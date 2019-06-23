package mainPackage;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class del_user
 */
@WebServlet("/del_user")
public class del_user extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public del_user() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String username = request.getParameter("username");
		String type_user = request.getParameter("type_user");
		String choosen_user = request.getParameter("choosen_user");
		String restaurant_name = request.getParameter("restaurant_name");
		String type_user_choosen = null;
		
		username = username.trim();
		type_user = type_user.trim();

		if(choosen_user != null) {
			choosen_user = choosen_user.trim();
			type_user_choosen = Contact2db.gettype(choosen_user);
		}
		else {
			restaurant_name = restaurant_name.trim();
		}
		
		
		
		if(type_user.equals("Admin") && choosen_user != null) {
			Contact2db.del_rowS_restaurants(choosen_user);
			Contact2db.del_row_users(choosen_user);
			Contact2db.del_user_critics(choosen_user);
			request.setAttribute("username", username);
			request.setAttribute("type_user", type_user);
			request.getRequestDispatcher("Users.jsp").forward(request, response);
		}
		else {
			Contact2db.del_row_restaurant(restaurant_name);
			Contact2db.del_restaurant_critics(restaurant_name);
			request.setAttribute("username", username);
			request.setAttribute("type_user", type_user);
			request.getRequestDispatcher("Restaurants.jsp").forward(request, response);
		}
			
		
	}

}
