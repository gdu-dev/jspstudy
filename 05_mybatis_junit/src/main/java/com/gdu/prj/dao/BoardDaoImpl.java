package com.gdu.prj.dao;

import java.io.InputStream;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.gdu.prj.dto.BoardDto;

public class BoardDaoImpl implements BoardDao {

  // SqlSession (Connection/PreparedStatement/ResultSet 처리) 만드는 SqlSessionFactory 객체 선언
  private SqlSessionFactory factory = null;
  
  // SingletonPattern
  private static BoardDao boardDao = new BoardDaoImpl();
  private BoardDaoImpl() {
    // mybatis-config.xml 파일을 이용한 SqlSessionFactory 객체 생성
    try {
      String resource = "com/gdu/prj/config/mybatis-config.xml";
      InputStream in = Resources.getResourceAsStream(resource);
      factory = new SqlSessionFactoryBuilder().build(in);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
  public static BoardDao getInstance() {
    return boardDao;
  }
  
  @Override
  public int insertBoard(BoardDto board) {
    // TODO Auto-generated method stub
    return 0;
  }

  @Override
  public int updateBoard(BoardDto board) {
    // TODO Auto-generated method stub
    return 0;
  }

  @Override
  public int deleteBoard(int board_no) {
    // TODO Auto-generated method stub
    return 0;
  }

  @Override
  public List<BoardDto> selectBoardList(Map<String, Object> params) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public int getBoardCount() {
    // TODO Auto-generated method stub
    return 0;
  }

  @Override
  public BoardDto selectBoardByNo(int board_no) {
    // TODO Auto-generated method stub
    return null;
  }

}
