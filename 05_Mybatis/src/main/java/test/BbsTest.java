package test;

import static org.junit.Assert.*;

import org.junit.Test;

import repository.BbsDAO;

public class BbsTest {

	// BbsDAO의 메소드 단위로 테스트를 진행한다.
	private BbsDAO dao = BbsDAO.getInstance();
	
	@Test
	public void 목록테스트() {
		assertEquals(2, dao.selectAllBbsList().size());
	}

}
