package kr.or.ddit.hello.web;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.junit.Test;

import org.springframework.test.web.servlet.MvcResult;

import org.springframework.web.servlet.ModelAndView;

import kr.or.ddit.config.test.WebTestConfig;



public class HelloControllerTest extends WebTestConfig {
	
	// server(tomcat)가 없는 환경에서 테스트 가능하다

	@Test
	public void helloTest() throws Exception {
		/***Given***/
		

		/***When***/
		MvcResult mvcResult = mockMvc.perform(get("/hello/hello.do").param("userId", "brown")).andReturn();
		ModelAndView mav = mvcResult.getModelAndView();
		String msg = (String)mav.getModel().get("msg");
		String userId = (String)mav.getModelMap().get("userId");
		
		// controller viewName(String)을 리턴하지만,
		// 스프링 프레임워크 내부에서는 viewName을 ModelAndView 객체로 변환해서 사용
		// 또한 컨트롤러 메서드에서는 viewName뿐만 아니라 ModelAndView 객체, View 객체 리턴하는게 가능
		// 리턴타입이 void인 경우도 존재(response객체를 통해 개발자가 직접 응답을 생성하는 것이 가능)

		/***Then***/
		assertEquals("hello/hello", mav.getViewName());
		assertEquals("hello, World", msg);
		assertEquals("brown_helloController", userId);
	}
	
	@Test
	public void helloTest2() throws Exception {
		mockMvc.perform(get("/hello/hello.do").param("userId", "sally"))
			.andExpect(status().isOk())
			.andExpect(view().name("hello/hello")) // name 안에는 예상되는 값
//			.andExpect(model().attributeExists("msg"))	// msg라는 속성이 있는지
//			.andExpect(model().attributeExists("userId")) // userId라는 속성이 있는지
			.andExpect(model().attribute("msg", "hello, World"))
			.andExpect(model().attribute("userId", "sally_helloController"));
	}
	
}
