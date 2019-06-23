package mainPackage;


import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ManageDisplay
 */
@WebServlet("/ManageDisplay")
public class ManageDisplay extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub		
		response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
		response.setHeader("Pragma", "no-cache");
		response.setDateHeader("Expires", 0);
		
		String username = null;
		String type_user = null;
		String tab = null;
		
		username = request.getParameter("username");
		type_user = request.getParameter("type_user");
		tab = request.getParameter("tab");
		
		if(type_user == null && tab == null) {
			username = (String)request.getAttribute("username");
			type_user = (String)request.getAttribute("type_user");
			tab = (String)request.getAttribute("tab");
		}
		try {
			username=username.trim();
			type_user=type_user.trim();
			tab=tab.trim();
			
			
		}
		catch(Exception e) {
			System.out.println(e);
		}
		
		if(tab.equals("MainPage")) {
			request.setAttribute("username", username);
			request.setAttribute("type_user", type_user);
			request.getRequestDispatcher("succeed.jsp").forward(request, response);
		}
		else if(type_user.equals("Admin")) {
			
			if(tab.equals("Restaurants")) {
				request.setAttribute("username", username);
				request.setAttribute("type_user", type_user);
				request.setAttribute("tab", tab);
				request.getRequestDispatcher("Restaurants.jsp").forward(request, response);
			}
			else if(tab.equals("Users")) {
				request.setAttribute("username", username);
				request.setAttribute("type_user", type_user);
				request.setAttribute("tab", tab);
				request.getRequestDispatcher("Users.jsp").forward(request, response);
			}
			else if(tab.equals("ManageCritics")) {
				request.setAttribute("username", username);
				request.setAttribute("type_user", type_user);
				request.setAttribute("tab", tab);
				request.getRequestDispatcher("ManageCritics.jsp").forward(request, response);
			}
			else if(tab.equals("Contact")) {
				request.setAttribute("username", username);
				request.setAttribute("type_user", type_user);
				request.setAttribute("tab", tab);
				request.getRequestDispatcher("Contact.jsp").forward(request, response);
			}

		}
		else if(type_user.equals("User")) {

			if(tab.equals("Restaurants")) {
				request.setAttribute("username", username);
				request.setAttribute("type_user", type_user);
				request.setAttribute("tab", tab);
				request.getRequestDispatcher("Restaurants.jsp").forward(request, response);
			}
			else if(tab.equals("ManageAccount")) {
				request.setAttribute("username", username);
				request.setAttribute("type_user", type_user);
				request.setAttribute("tab", tab);
				request.getRequestDispatcher("MyAccount.jsp").forward(request, response);
			}
			else if(tab.equals("MyCritics")) {
				request.setAttribute("username", username);
				request.setAttribute("type_user", type_user);
				request.setAttribute("tab", tab);
				request.getRequestDispatcher("MyCritics.jsp").forward(request, response);
			}
			else if(tab.equals("Contact")) {
				request.setAttribute("username", username);
				request.setAttribute("type_user", type_user);
				request.setAttribute("tab", tab);
				request.getRequestDispatcher("Contact.jsp").forward(request, response);
			}
			
			
			
		}
		else if(type_user.equals("Restaurant Owner")) {

			
			if(tab.equals("Restaurants")) {
				request.setAttribute("username", username);
				request.setAttribute("type_user", type_user);
				request.setAttribute("tab", tab);
				request.getRequestDispatcher("Restaurants.jsp").forward(request, response);
			}
			else if(tab.equals("ManageAccount")) {
				request.setAttribute("username", username);
				request.setAttribute("type_user", type_user);
				request.setAttribute("tab", tab);
				request.getRequestDispatcher("MyAccount.jsp").forward(request, response);
			}
			else if(tab.equals("Contact")) {
				request.setAttribute("username", username);
				request.setAttribute("type_user", type_user);
				request.setAttribute("tab", tab);
				request.getRequestDispatcher("Contact.jsp").forward(request, response);
			}
			else if(tab.equals("NewRestaurant")) {
				request.setAttribute("username", username);
				request.setAttribute("type_user", type_user);
				request.setAttribute("tab", tab);
				request.getRequestDispatcher("NewRestaurant.jsp").forward(request, response);
			}
		}
		else if(type_user.equals("Guest")) {
			

			if(tab.equals("Restaurants")) {
				request.setAttribute("type_user", type_user);
				request.setAttribute("tab", tab);
				request.getRequestDispatcher("Restaurants.jsp").forward(request, response);
			}
			else if(tab.equals("Contact")) {
				request.setAttribute("type_user", type_user);
				request.setAttribute("tab", tab);
				request.getRequestDispatcher("Contact.jsp").forward(request, response);
			}
		}
		else {
			request.setAttribute("fail_type", type_user);
			request.getRequestDispatcher("fail.jsp").forward(request, response);
		}
	}

}
