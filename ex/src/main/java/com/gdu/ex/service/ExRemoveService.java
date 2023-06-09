package com.gdu.ex.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gdu.ex.common.ActionForward;
import com.gdu.ex.repository.ExDao;

public class ExRemoveService implements ExService {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		
		int exNo = Integer.parseInt(request.getParameter("exNo"));
		
		int result = ExDao.getInstance().remove(exNo);
		
		// Delete 이후에는 redirect 하자!
		// redirect 경로 : mapping을 작성한다. ContextPath부터 시작하는 경로로 작성한다.
		return new ActionForward(request.getContextPath() + "/list.do", true);
		
	}

}
