package kr.or.ddit.user.web;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.mock.web.MockHttpSession;

import kr.or.ddit.common.model.Page;
import kr.or.ddit.config.test.WebTestConfig;

public class UserControllerTest extends WebTestConfig{
	private static final Logger logger = LoggerFactory.getLogger(UserControllerTest.class);

	/**
	 * 
	* Method : userListTest
	* 작성자 : PC-04
	* 변경이력 :
	* Method 설명 : 사용자 전체 리스트 조회 테스트
	 * @throws Exception 
	 */
	@Test
	public void userListTest() throws Exception {
		/***Given***/
		
		/***When***/
		mockMvc.perform(get("/user/userList"))
			.andExpect(model().attributeExists("userList"))
			.andExpect(view().name("user/userList"));

		/***Then***/
	}
	
	/**
	 * 
	* Method : userListOnlyHalfTest
	* 작성자 : PC-04
	* 변경이력 :
	* @throws Exception
	* Method 설명 : 사용자 정보 절반 조회
	 */
	@Test
	public void userListOnlyHalfTest() throws Exception {
		mockMvc.perform(get("/user/userListOnlyHalf"))
			   .andExpect(view().name("user/userListOnlyHalf"));
	}
	
	/**
	 * 
	* Method : userPagingListTest
	* 작성자 : PC-04
	* 변경이력 :
	* @throws Exception
	* Method 설명 : 사용자 페이징 리스트 조회(파라미터x)
	 */
	@Test
	public void userPagingListTest() throws Exception {
		mockMvc.perform(get("/user/userPagingList"))
		       .andExpect(status().isOk())
		       .andExpect(model().attributeExists("userList"))
		       .andExpect(view().name("user/userPagingList"));
	}
	
	@Test
	public void pageTest() {
		Page page = new Page();
		logger.debug("page : {}", page);
	}

}
