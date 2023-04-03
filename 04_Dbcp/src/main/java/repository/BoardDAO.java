package repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import javax.sql.DataSource;

import domain.BoardDTO;

public class BoardDAO {

	// 모든 메소드가 사용할 공통 필드
	private Connection con;
	private PreparedStatement ps;
	private ResultSet rs;
	private String sql;
	
	// Connection 관리를 위한 DataSource 필드
	private DataSource dataSource;
	
	
	
	// 게시글 목록 반환하기
	public List<BoardDTO> selectBoardList() {
	
		return null;
	}
	
	// 게시글 반환하기
	public BoardDTO selectBoardByNo(int board_no) {
		
		return null;
	}
	
	// 게시글 삽입하기
	public int insertBoard(BoardDTO board) {
		
		return 0;
	}
	
	// 게시글 수정하기
	public int updateBoard(BoardDTO board) {
		
		return 0;
	}
	
	// 게시글 삭제하기
	public int deleteBoard(int board_no) {
		
		return 0;
	}
	
}
