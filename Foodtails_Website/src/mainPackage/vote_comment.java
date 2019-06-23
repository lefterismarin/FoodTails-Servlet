package mainPackage;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.lang.Math;

/**
 * Servlet implementation class vote_comment
 */
@WebServlet("/vote_comment")
public class vote_comment extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public vote_comment() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String type_user = request.getParameter("type_user");
		String vote = request.getParameter("vote");
		String critic = request.getParameter("critic");
		String restaurant_name = request.getParameter("restaurant_name");
		
		username = username.trim();
		type_user = type_user.trim();
		vote = vote.trim();
		restaurant_name = restaurant_name.trim();
		try {
			critic = critic.trim();
		}
		
		catch(Exception e) {
			System.out.print(e);
		}
		
		try {
			if(Contact2db.critic_exists(username,restaurant_name)) {
				
				Contact2db.update_critics(username,restaurant_name,Integer.parseInt(vote),critic);
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
				request.getRequestDispatcher("Restaurants.jsp").forward(request, response);
			}
			else {
				Contact2db.insertdb_critics(username,restaurant_name,Integer.parseInt(vote),critic);
				
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
				request.getRequestDispatcher("Restaurants.jsp").forward(request, response);
			}
			
			
			
		}
		catch(Exception e) {
			System.out.print(e);
		}
	}

}
