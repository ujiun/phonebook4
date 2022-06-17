package com.javaex.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaex.dao.PhoneDao;
import com.javaex.vo.PersonVo;


@Service
public class PhoneService {

	//필드
	@Autowired
	private PhoneDao phoneDao;
	//생성자
	
	//메소드-gs
	
	//메소드-일반
	
	// 전화번호 리스트
	public List<PersonVo> getPersonList() {
		System.out.println("PhoneService>getPersonList()");
		
		List<PersonVo> personList = phoneDao.getPersonList();
		
		return personList;
	}
	
	
	//전화번호 등록
	public int personInsert(PersonVo vo) {
		System.out.println("PhoneService>PersonInsert()");
		
		int count = phoneDao.personInsert(vo);
		
		return count;
	}
	
	
	//전화번호 등록(map을 사용하는 가상의 상황: 문법설명)
	public int personInsert2() {
		System.out.println("PhoneService>PersonInsert2()");
		
		//map을 만들어 사용한다* 1회성
		Map<String, String> pMap = new HashMap<String, String>();
		pMap.put("name", "황일영");
		pMap.put("hp", "010-8888-8888");
		pMap.put("company", "02");
		
		int count = phoneDao.personInsert2(pMap);
		
		return count;
		
	}
	
	//전화번호 삭제
	public int personDelete(int no) {
		System.out.println("PhoneService>personDelete()");
		int count = phoneDao.personDelete(no);
		
		return count;
	}
	
	
	//전화번호 수정폼(정보가져오기) 
	public PersonVo getPerson(int no) {
		System.out.println("PhoneService>getPerson()");
		
		PersonVo personVo = phoneDao.getPerson(no);
		
		return personVo;
		
	}
	
	
	//전화번호 수정폼2(정보가져오기)
	public Map<String, Object> getPerson2(int no) {
		System.out.println("PhoneService>getPerson2()");
		
		Map<String, Object> pMap = phoneDao.getPerson2(no);
		
		return pMap;
	}
	
	//전화번호 수정
	public int personUpdate(PersonVo vo) {
		System.out.println("PhoneService>personUpdate()");
		int count = phoneDao.personUpdate(vo);
		
		return count;
	}
	
}
