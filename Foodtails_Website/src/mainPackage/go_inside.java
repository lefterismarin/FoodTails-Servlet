package mainPackage;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class go_inside
 */
@WebServlet("/go_inside")
public class go_inside extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public go_inside() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String type_user = request.getParameter("type_user");
		String restaurant_name = request.getParameter("restaurant_name");
		
		username=username.trim();
		type_user=type_user.trim();
		restaurant_name=restaurant_name.trim();
		
		request.setAttribute("username", username);
		request.setAttribute("type_user", type_user);
		request.setAttribute("restaurant_name", restaurant_name);
		request.getRequestDispatcher("Critics.jsp").forward(request, response);
	}

}
