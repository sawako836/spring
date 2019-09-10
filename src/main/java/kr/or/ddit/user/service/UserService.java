package kr.or.ddit.user.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import kr.or.ddit.user.dao.IUserDao;
import kr.or.ddit.user.model.User;

@Service
public class UserService implements IUserService {

	@Resource(name="userDao")
	private IUserDao userDao;
	
	// 기본 생성자 생성
	public UserService() {
		
	}
	
	// 인자가 있는 생성자 생성
	public UserService(IUserDao userDao) {
		this.userDao = userDao;
	}
	
	/**
	 * 
	* Method : getUserList
	* 작성자 : PC-04
	* 변경이력 :
	* @return
	* Method 설명 : 사용자 전체 리스트 조회
	 */
	@Override
	public List<User> getUserList() {
		return userDao.getUserList();
	}
	
}
