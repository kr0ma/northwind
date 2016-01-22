package be.vdab.servlets.customers;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import be.vdab.services.CustomerService;

/**
 * Servlet implementation class SearchByNameServlet
 */
@WebServlet("/customers/search.htm")
public class SearchByNameServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static final String VIEW = "/WEB-INF/JSP/customers/searchbyname.jsp";
	private final transient CustomerService customerService = new CustomerService();

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (request.getQueryString() != null){
			String name = request.getParameter("name");
			Map<String, String> errors = new HashMap<>();
			if (name != null && !name.isEmpty()){
				String method = request.getParameter("method");
				if (method != null){
					if (method.equals("2")){
						name = '%' + name + '%';
					}
					if (method.equals("3")){
						name = name + '%';
					}
					request.setAttribute("customers", customerService.findByName(name));
				}else {
					errors.put("method", "Missing option how to perform the search");
				}
			} else {
				errors.put("name", "Name missing");
			}
			if (!errors.isEmpty()){
				request.setAttribute("errors", errors);
			}
		}
		
		request.getRequestDispatcher(VIEW).forward(request, response);
	}

}
