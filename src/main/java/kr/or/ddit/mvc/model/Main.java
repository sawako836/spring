package kr.or.ddit.mvc.model;

import java.util.List;

public class Main {
	private List<String> userId;	// input name = userId
	private Addr addr;				// input name = addr.addr1

	public List<String> getUserId() {
		return userId;
	}

	public void setUserId(List<String> userId) {
		this.userId = userId;
	}

	public Addr getAddr() {
		return addr;
	}

	public void setAddr(Addr addr) {
		this.addr = addr;
	}

	@Override
	public String toString() {
		return "Main [userId=" + userId + ", addr=" + addr + "]";
	}

}
