package com.gdu.prj.service;

import java.util.List;

import com.gdu.prj.common.ActionForward;
import com.gdu.prj.dao.BoardDao;
import com.gdu.prj.dao.BoardDaoImpl;
import com.gdu.prj.dto.BoardDto;

import jakarta.servlet.http.HttpServletRequest;

/*
 * view - controller - service - dao - db
 */

public class BoardServiceImpl implements BoardService {

  // service 는 dao 를 호출한다.
  private BoardDao boardDao = BoardDaoImpl.getInstance();
  
  @Override
  public ActionForward addBoard(HttpServletRequest request) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public ActionForward getBoardList(HttpServletRequest request) {
    int boardCount = boardDao.getBoardCount();
    List<BoardDto> boardList = boardDao.selectBoardList(null);
    request.setAttribute("boardCount", boardCount);
    request.setAttribute("boardList", boardList);
    return new ActionForward("/board/list.jsp", false);
  }

  @Override
  public ActionForward getBoardByNo(HttpServletRequest request) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public ActionForward editBoard(HttpServletRequest request) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public ActionForward modifyBoard(HttpServletRequest request) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public ActionForward removeBoard(HttpServletRequest request) {
    // TODO Auto-generated method stub
    return null;
  }

}
