package com.office.ex.member;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.office.ex.Config;


@WebServlet("*.mem")
public class MemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	MemberServeice memberServeice = new MemberServeice();

    public MemberController() {
        super();

    }

    // /firstpjt/signup.mem
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String RequestURI = request.getRequestURI();
		String contextPath = request.getContextPath();
		String command = RequestURI.substring(contextPath.length());

		String nextPage = null;
		
		switch (command) {
		case MemberConfig.MEMBER_SIGNUP:
			System.out.println("=====");
			nextPage = "view/member/signup_form.jsp";
			
			break;
			
		case MemberConfig.MEMBER_SIGNUP_CONFIRM:
//			memberServeice = new MemberServeice();
			
			int resultForSignUP = memberServeice.signupConfirm(request, response);
			
			if (resultForSignUP == MemberServeice.SIGN_UP_OK) {
				nextPage = "view/member/signup_ok.jsp";
				
			} else {
				nextPage = "view/member/signup_ng.jsp";
			}
			break;
			
		case MemberConfig.MEMBER_SIGNIN:
			nextPage = "view/member/signin_form.jsp";
			
			break;
			
		case MemberConfig.MEMBER_SIGNIN_CONFIRM:
//			memberServeice = new MemberServeice();
			int resultForSignIn = memberServeice.signinConfirm(request, response);
			
			if (resultForSignIn == MemberServeice.SIGN_IN_OK) {
				nextPage = "view/member/signin_ok.jsp";
			} else {
				nextPage = "view/member/signin_ng.jsp";
			}
			
			break;
			
			
		case MemberConfig.MEMBER_SIGNOUT_CONFIRM:
			
			memberServeice.signoutConfirm(request, response);
			
			nextPage = request.getContextPath().concat(Config.HOME);
			
			break;
		}
		
		RequestDispatcher requestDispatcher = request.getRequestDispatcher(nextPage);
		requestDispatcher.forward(request, response);
		
	}

	private String generateView(String viewName) {
		
		String view = MemberConfig.VIEW_PREFIX
				.concat(viewName)
				.concat(MemberConfig.VIEW_SURFIX);
		
		return view;
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		doGet(request, response);
	}

}
