package com.javaex.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.PersonVo;

@Repository
public class PhoneDao {
	
	@Autowired
	private SqlSession sqlSession;
	
	
	@Autowired
	private DataSource dataSource;
	
	// 0. import java.sql.*;
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;

	/*
	private String driver = "oracle.jdbc.driver.OracleDriver";
	private String url = "jdbc:oracle:thin:@localhost:1521:xe";
	private String id = "phonedb";
	private String pw = "phonedb";
	*/
	
	private void getConnection() {
		try {
			// 1. JDBC 드라이버 (Oracle) 로딩
			//Class.forName(driver);

			// 2. Connection 얻어오기
			//conn = DriverManager.getConnection(url, id, pw);
			// System.out.println("접속성공");
			conn = dataSource.getConnection();
		
			
		} catch (SQLException e) {
			System.out.println("error:" + e);
		}
	}

	private void close() {
		// 5. 자원정리
		try {
			if (rs != null) {
				rs.close();
			}
			if (pstmt != null) {
				pstmt.close();
			}
			if (conn != null) {
				conn.close();
			}
		} catch (SQLException e) {
			System.out.println("error:" + e);
		}
	}
	
	
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