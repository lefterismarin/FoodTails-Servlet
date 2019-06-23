package mainPackage;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class del_critic
 */
@WebServlet("/del_critic")
public class del_critic extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public del_critic() {
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
		String juror_name = request.getParameter("juror_name");

		username= username.trim();
		type_user= type_user.trim();
		restaurant_name= restaurant_name.trim();
		juror_name= juror_name.trim();
		
		Contact2db.del_critic(juror_name, restaurant_name);
		
		int num_votes= Contact2db.get_num_votes(restaurant_name);
		int stars = Contact2db.get_stars_avg(restaurant_name);
		double Q =0;
		int M = 10;
		
		Q = -(M/(Math.log(0.5)));
		double weight = 0;
		double power_of_e = -(num_votes/Q);
		weight = stars +5*(1-Math.exp(power_of_e));
		weight = Math.round(weight*100.0)/100.0;
		
		Contact2db.update_restaurant_stars(restaurant_name,num_votes,stars,weight);
		request.setAttribute("username", username);
		request.setAttribute("type_user", type_user);
		request.getRequestDispatcher("ManageCritics.jsp").forward(request, response);

	}

}
