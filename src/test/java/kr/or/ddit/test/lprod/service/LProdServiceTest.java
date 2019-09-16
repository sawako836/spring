package kr.or.ddit.test.lprod.service;

import static org.junit.Assert.assertEquals;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.or.ddit.common.model.Page;
import kr.or.ddit.config.test.RootTestConfig;
import kr.or.ddit.lprod.dao.ILprodDao;
import kr.or.ddit.lprod.model.Lprod;

public class LProdServiceTest extends RootTestConfig {
	private static final Logger logger = LoggerFactory.getLogger(LProdServiceTest.class);
	
	@Resource(name="lprodDao")
	private ILprodDao lprodDao;
	
	@Before
	public void setup() {
		logger.debug("before");
		
	}
	
	//테스트에 공통적으로 사용한 자원을 해제
	@After
	public void tearDown() {
		logger.debug("after");
	}
	
	@Test
	public void getLprodPagingList(Page page) {
		/***Given***/

		/***When***/
//		Map<String, Object> resultMap = lprodService.getUserPagingList(page);
		List<Lprod> lprodList = lprodDao.getLprodPagingList(page);

		/***Then***/
		assertEquals(5, lprodList.size());
		assertEquals(1, lprodList.get(0).getLprod_id());
	}
	
}
