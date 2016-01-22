package be.vdab.servlets.employees;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import be.vdab.entities.Employee;
import be.vdab.services.EmployeeService;

/**
 * Servlet implementation class ChangeBossServlet
 */
@WebServlet("/employees/changeboss.htm")
public class ChangeBossServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static final String VIEW = "/WEB-INF/JSP/employees/changeboss.jsp";
	private static final String REDIRECT_URL = "%s/employees/changeboss.htm?id=%s";
	private final transient EmployeeService employeeService = new EmployeeService();

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (request.getQueryString() != null){
			Map<String, String> errors = new HashMap<>();
			String id = request.getParameter("id");
			if (id != null){
				try {	
					Employee employee = employeeService.read(Long.parseLong(id));
					System.out.println("------------------------------------------------");
					System.out.println(employee.getStaff());
					request.setAttribute("employee",employee );
					request.setAttribute("bosses", employeeService.findBosses(Long.parseLong(id)));				
				} catch (NumberFormatException ex){					
					errors.put("id", "Wrong id!");
				}				
			}
			if (!errors.isEmpty()){
				request.setAttribute("errors", errors);
			}
		}
		request.getRequestDispatcher(VIEW).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if (request.getQueryString() != null){
			String bossId = request.getParameter("bossId");
			String id = request.getParameter("id");
			System.out.println(bossId);
			System.out.println(id);
			if (bossId != null && id != null){
				if (employeeService.changeBoss(Long.parseLong(id), Long.parseLong(bossId))){
					response.sendRedirect(response.encodeRedirectURL(String.format(
							REDIRECT_URL, request.getContextPath(), id)));
				} else {
					request.setAttribute("employee", employeeService.read(Long.parseLong(id)));
					request.setAttribute("error", "Could not change boss!!");
					request.setAttribute("bosses", employeeService.findBosses(Long.parseLong(id)));	
					request.getRequestDispatcher(VIEW).forward(request, response);
				}
				
			}			
		} else {
			request.getRequestDispatcher(VIEW).forward(request, response);
		}
	}

}
