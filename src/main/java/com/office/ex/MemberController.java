package com.office.ex;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("*.mem")
public class MemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public MemberController() {
        super();

    }

    // /firstpjt/signup.mem
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String RequestURI = request.getRequestURI();
		String contextPath = request.getContextPath();
		String command = RequestURI.substring(contextPath.length());
		
		MemberServeice memberServeice = null;
		String nextPage = null;
		
		switch (command) {
		case "/signup.mem":
			System.out.println("=-===");
			nextPage = "view/member/signup_form.jsp";
			
			break;
			
		case "/signup_confirm.mem":
			memberServeice = new MemberServeice();
			
			int resultForSignUP = memberServeice.signupConfirm(request, response);
			
			if (resultForSignUP == 1) {
				nextPage = "view/member/signup_ok.jsp";
				
			} else {
				nextPage = "view/member/signup_ng.jsp";
			}
			break;
			
		case "/signin.mem":
			
			break;
		}
		
		RequestDispatcher requestDispatcher = request.getRequestDispatcher(nextPage);
		requestDispatcher.forward(request, response);
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		doGet(request, response);
	}

}
