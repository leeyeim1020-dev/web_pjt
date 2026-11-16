package com.office.ex;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class MemberServeice {
	
	final public static int SIGN_UP_OK = 1;
	final public static int SIGN_UP_NG = 0;
	
	final public static int SIGN_IN_OK = 1;
	final public static int SIGN_IN_NG = 0;
	
	MemberDao memberDao = new MemberDao();

	public int signupConfirm(HttpServletRequest request, HttpServletResponse response) {
		
		String memId = request.getParameter("memId");
		String memPw = request.getParameter("memPw");
		String memMail = request.getParameter("memMail");
		String memPhone = request.getParameter("memPhone");
		
		MemberDto memberDto = new MemberDto(memId, memPw, memMail, memPhone);
		
		int result = memberDao.insertNewMember(memberDto);		
		
		return result;
	}

	public int signinConfirm(HttpServletRequest request, HttpServletResponse response) {

		String mamId = request.getParameter("memId");
		String mamPw = request.getParameter("memPw");
		
		MemberDto selectedMemberDto = memberDao.selectMemberByMemIdAndMemPw(mamId);
		/*
		if (selectedMemberDto != null && selectedMemberDto.getMemPw().equals(mamPw)) {
			return SIGN_IN_OK;
	
		} else {
			return SIGN_IN_NG;
		}
		*/
		
		if (selectedMemberDto != null && selectedMemberDto.getMemPw().equals(mamPw))
			return SIGN_IN_OK;
		
		return SIGN_IN_NG;
	}

}
