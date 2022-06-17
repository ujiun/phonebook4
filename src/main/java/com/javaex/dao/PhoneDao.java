package com.javaex.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.PersonVo;

@Repository
public class PhoneDao {
	
	@Autowired
	private SqlSession sqlSession;
	
	
	
	//전체리스트 가져오기
	public List<PersonVo> getPersonList() {
		/*
		System.out.println("PhoneDao>getPersonList");
		
		List<PersonVo> personList = sqlSession.selectList("phonebook.selectList");
		System.out.println(personList);
		*/
		
		return sqlSession.selectList("phonebook.selectList");
	}
	
	
	//사람추가
	public int personInsert(PersonVo vo) {
		System.out.println("PhoneDao>personInsert");
		
		int count = sqlSession.insert("phonebook.personInsert", vo);
		
		return 1;
		
	}
	
	
	// 사람 삭제
	public int personDelete(int no) {
		System.out.println("PhoneDao>personDelete");
		int count = sqlSession.delete("phonebook.personDelete", no);
		
		return count;
	}
	
	
	
	//1명 정보 가져오기
	public PersonVo getPerson(int no) {
		System.out.println("PhoneDao>getPerson()");
		
		PersonVo personVo = sqlSession.selectOne("phonebook.getPerson", no);
		
		System.out.println(personVo);
		
		return personVo;
	}
	
	
	//사람 수정
	public int personUpdate(PersonVo vo) {
		System.out.println("PhoneDao>personUpdate()");
		int count = sqlSession.update("phonebook.personUpdate", vo);
		
		return count;
		
	}
	
	
}