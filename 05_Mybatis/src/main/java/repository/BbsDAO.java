package repository;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import domain.BbsDTO;

public class BbsDAO {

	// field
	private SqlSessionFactory factory;
	
	// Singleton Pattern
	private static BbsDAO dao = new BbsDAO();
	private BbsDAO() {
		try {
			String resource = "mybatis/config/mybatis-config.xml";
			InputStream inputStream = Resources.getResourceAsStream(resource);
			factory = new SqlSessionFactoryBuilder().build(inputStream);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	public static BbsDAO getInstance() {
		return dao;
	}
	
	/* 메소드명과 쿼리문의 id를 맞추자. */
	
	// mapper의 namespace
	private final String NS = "mybatis.mapper.bbs.";
	
	// 1. 목록
	public List<BbsDTO> selectAllBbsList() {
		SqlSession ss = factory.openSession();
		List<BbsDTO> bbsList = ss.selectList(NS + "selectAllBbsList");
		ss.close();
		return bbsList;
	}
	
	// 2. 상세
	public BbsDTO selectBbsByNo(int bbsNo) {
		SqlSession ss = factory.openSession();
		BbsDTO bbs = ss.selectOne(NS + "selectBbsByNo", bbsNo);
		ss.close();
		return bbs;
	}
	
	
	
	
	
	
	
	
	
	
	
}
