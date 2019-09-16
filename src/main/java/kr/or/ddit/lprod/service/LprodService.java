package kr.or.ddit.lprod.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;


import kr.or.ddit.common.model.Page;
import kr.or.ddit.lprod.dao.ILprodDao;

import kr.or.ddit.lprod.model.Lprod;


public class LprodService implements ILprodService{
	
	@Resource(name="lprodDao")
	private ILprodDao lprodDao;
	
	public LprodService() {
		
	}
	
	public LprodService(ILprodDao lprodDao) {
		this.lprodDao = lprodDao;
	}
	
	/**
	 * 
	* Method : getLprodPagingList
	* 작성자 : PC-04
	* 변경이력 :
	* @param page
	* @return
	* Method 설명 : 제품그룹 페이징 리스트 조회
	 */
	@Override
	public Map<String, Object> getLprodPagingList(Page page) {
		Map<String, Object> map = new HashMap<String, Object>();
		
		List<Lprod> lprodList = lprodDao.getLprodPagingList(page);
		int totalCnt = lprodDao.getLprodTotalCnt();
		
		map.put("lprodList", lprodList);
		map.put("paginationSize", (int)Math.ceil((double)totalCnt / page.getPagesize()));
		
		return map;
		
	}

}
