package be.vdab.servlets.customers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import be.vdab.services.CountryService;

/**
 * Servlet implementation class ByCountryServlet
 */
@WebServlet("/customers/bycountry.htm")
public class ByCountryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static final String VIEW = "/WEB-INF/JSP/customers/bycountry.jsp";	
	
	private final transient CountryService countryService = new CountryService();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String countryId = request.getParameter("id");
		if ( countryId != null){
			try {
				request.setAttribute("country", countryService.read(Long.parseLong(countryId)));
			} catch (NumberFormatException ex){
				ex.printStackTrace();
			}
		}
		request.getRequestDispatcher(VIEW).forward(request, response);
	}

}
