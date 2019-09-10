package kr.or.ddit.test.ioc;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

public class CollectionBean {
	// 객체 생성
	private List list;
	private Set set;
	private Map map;
	private Properties properties;
	
	// 주입을 하기 위한 getter setter
	public List getList() {
		return list;
	}
	public void setList(List list) {
		this.list = list;
	}
	public Set getSet() {
		return set;
	}
	public void setSet(Set set) {
		this.set = set;
	}
	public Map getMap() {
		return map;
	}
	public void setMap(Map map) {
		this.map = map;
	}
	public Properties getProperties() {
		return properties;
	}
	public void setProperties(Properties properties) {
		this.properties = properties;
	}
	
	
	
}
