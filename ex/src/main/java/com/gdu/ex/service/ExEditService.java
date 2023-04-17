package com.gdu.ex.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gdu.ex.common.ActionForward;
import com.gdu.ex.domain.ExDto;
import com.gdu.ex.repository.ExDao;

public class ExEditService implements ExService {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		int exNo = Integer.parseInt(request.getParameter("exNo"));
		ExDto ex = ExDao.getInstance().detail(exNo);
		request.setAttribute("ex", ex);
		return new ActionForward("ex/modify.jsp", false);
		
	}

}