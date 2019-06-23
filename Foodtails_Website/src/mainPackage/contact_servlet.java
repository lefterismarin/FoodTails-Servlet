package mainPackage;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class contact_servlet
 */
@WebServlet("/contact_servlet")
public class contact_servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public contact_servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String type_user = request.getParameter("type_user");
		String text = request.getParameter("text");
		
		text = text.trim();
		type_user = type_user.trim();
		
		if(type_user.equals("Guest")) {
			username="Guest";
		}
		try {
			username = username.trim();
			
		}
		catch(Exception e) {
			System.out.println(e);
		}
		sendmail.ContactMailFunc(username, text);
		request.setAttribute("type_user", type_user);
		request.setAttribute("username", username);
		request.getRequestDispatcher("Contact.jsp").forward(request, response);
	}

}
