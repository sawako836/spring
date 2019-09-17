package kr.or.ddit.lprod.web;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.web.servlet.MockMvc;

import kr.or.ddit.common.model.Page;
import kr.or.ddit.config.test.WebTestConfig;

public class LprodControllerTest extends WebTestConfig{
	private static final Logger logger = LoggerFactory.getLogger(LprodControllerTest.class);

	/**
	 * 
	* Method : lprodTest
	* 작성자 : PC-04
	* 변경이력 :
	* @throws Exception
	* Method 설명 : 제품 그룹 리스트 조회 테스트
	 */
	@Test
	public void lprodTest() throws Exception {
		mockMvc.perform(get("/lprodList"))
			.andExpect(model().attributeExists("lprodList"))
			.andExpect(view().name("lprod/lprodList"));
	}
	
	/**
	 * 
	* Method : lprodPagingListTest
	* 작성자 : PC-04
	* 변경이력 :
	* @throws Exception
	* Method 설명 : 제품 그룹 페이징 리스트 조회 테스트
	 */
	@Test
	public void lprodPagingListTest() throws Exception {
		mockMvc.perform(get("/lprodPagingList")
						.param("page", "1")
						.param("pageSize", "5"))
			   .andExpect(model().attributeExists("resultMap"))	
			   .andExpect(view().name("lprod/lprodPagingList"));
	}
	
	/**
	 * 
	* Method : lprodPagingListTest
	* 작성자 : PC-04
	* 변경이력 :
	* @throws Exception
	* Method 설명 : 제품 그룹 페이징 리스트 조회 테스트 (param x)
	 */
	@Test
	public void lprodPagingList_NoParam_Test() throws Exception {
		mockMvc.perform(get("/lprodPagingList"))
			.andExpect(model().attributeExists("resultMap"))	
			.andExpect(view().name("lprod/lprodPagingList"));
	}
	
	@Test
	public void pageTest() {
		Page page = new Page();
		logger.debug("page : {}", page);
	}

}
