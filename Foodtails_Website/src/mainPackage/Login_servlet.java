package mainPackage;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class Login_servlet
 */
@WebServlet("/Login_servlet")
public class Login_servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login_servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("user_login");
		String password = request.getParameter("pass_login");

		
		String user_register = request.getParameter("user_register");
		String surname = request.getParameter("surname");
		String name = request.getParameter("name");
		String pass_register = request.getParameter("pass_register");
		String email = request.getParameter("email");
		String type_register = request.getParameter("type_register");
		
		String recover_mail = request.getParameter("recover_mail");
		
		
		
		String guest = request.getParameter("guest");
		
		String type_user = null;
		
		
		response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
		response.setHeader("Pragma", "no-cache");
		response.setDateHeader("Expires", 0);
		
		if(user_register != null) {
			if(Contact2db.insertdb(user_register,surname,name,pass_register,email,type_register) == 1) {
				type_user=type_register;
				String tab ="MainPage";
				request.setAttribute("username", user_register);
				request.setAttribute("type_user", type_user);
				request.setAttribute("tab", tab);
				request.getRequestDispatcher("ManageDisplay").forward(request, response);
			}
			else {
				String fail_type="register";
				request.setAttribute("fail_type", fail_type);
				request.getRequestDispatcher("fail.jsp").forward(request, response);
			}
			
		}
		
		else if(recover_mail != null) {
			if(Contact2db.email_exists(recover_mail)) {
				String get_pass_from_mail = Contact2db.get_pass_from_mail(recover_mail);
				if(sendmail.sendMailFunc(recover_mail, get_pass_from_mail)) {
					response.sendRedirect("emailsent.html");
				}
			}
			else {
				String fail_type="recover";
				request.setAttribute("fail_type", fail_type);
				request.getRequestDispatcher("fail.jsp").forward(request, response);
			}
		}
		else if(guest != null) {
			type_user = "Guest";
			String tab ="MainPage";
			request.setAttribute("type_user", type_user);
			request.setAttribute("tab", tab);
			request.getRequestDispatcher("ManageDisplay").forward(request, response);
		}
		
		else{//login status
			if(Contact2db.login_connection(username, password)) {//succeed
				type_user = Contact2db.gettype(username);
				String tab ="MainPage";
				request.setAttribute("username", username);
				request.setAttribute("type_user", type_user);
				request.setAttribute("tab", tab);
				request.getRequestDispatcher("ManageDisplay").forward(request, response);
			}
			else {//failed
				String fail_type="login";
				request.setAttribute("fail_type", fail_type);
				request.getRequestDispatcher("fail.jsp").forward(request, response);
			}
		}

	}

}
