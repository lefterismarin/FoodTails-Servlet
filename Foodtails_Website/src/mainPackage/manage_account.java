package mainPackage;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class manage_account
 */
@WebServlet("/manage_account")
public class manage_account extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public manage_account() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String old_pass = request.getParameter("old_pass");
		String new_pass = request.getParameter("new_pass");
		String type = request.getParameter("type");
		String type_user = request.getParameter("type_user");
		String username = request.getParameter("username");
		try {
			old_pass=old_pass.trim();
			new_pass=new_pass.trim();
		}
		catch(Exception e) {
			System.out.println(e);
			 
		}
		type=type.trim();
		type_user=type_user.trim();
		username=username.trim();

		
		if(type.equals("Delete")) {
			Contact2db.del_rowS_restaurants(username);
			Contact2db.del_row_users(username);
			Contact2db.del_user_critics(username);
			response.sendRedirect("Login.html");
		}
		else {
			if(Contact2db.get_pass_from_username(username).equals(old_pass)) {
				Contact2db.change_pass(username, new_pass);
				response.sendRedirect("Login.html");
			}
			else {
				request.setAttribute("error", "error");
				request.setAttribute("username", username);
				request.setAttribute("type_user", type_user);
				request.getRequestDispatcher("MyAccount.jsp").forward(request, response);
				
			}
			
		}
	}

}
