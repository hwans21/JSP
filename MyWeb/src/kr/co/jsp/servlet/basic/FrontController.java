package kr.co.jsp.servlet.basic;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("*.action")
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public FrontController() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("요청이 들어옴!");
		System.out.println("요청 URI: " + request.getRequestURI());
		
		String uri = request.getRequestURI();
		String conPath = request.getContextPath(); // /MyWeb
		
		uri = uri.substring(conPath.length() + 1, uri.lastIndexOf("."));
		
		System.out.println("정제된 uri: " + uri);
		
		switch(uri) {
		
		case "write":
			
		case "list":
			
		case "update":
			
		case "delete":
			
		}
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}






