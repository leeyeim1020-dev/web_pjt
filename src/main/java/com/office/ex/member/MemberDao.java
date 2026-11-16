package com.office.ex.member;

import java.util.HashMap;
import java.util.Map;

public class MemberDao {
	
	Map<String, MemberDto> memDB = new HashMap<String, MemberDto>();

	public int insertNewMember(MemberDto memberDto) {
		
		memDB.put(memberDto.getMemId(), memberDto);
		
		return memDB.get(memberDto.getMemId()) != null 
				? 
				MemberServeice.SIGN_UP_OK
				:
				MemberServeice.SIGN_UP_NG;
		
	}
	
	public MemberDto selectMemberByMemIdAndMemPw(String memId) {
		
		System.out.println("memDB.get(memId): " + memDB.get(memId));
		
		return memDB.get(memId);
		
	}

}
