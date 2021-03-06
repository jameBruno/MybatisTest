package com.boardPrograms.web.board.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.boardPrograms.web.board.model.AccessVO;
import com.boardPrograms.web.board.model.Params;

@Repository("accessDAOImpl")
public class AccessDAOImpl implements AccessDAO {
	
	//@Resource(name = "sqlSession")
	@Autowired
	SqlSession sqlSession;
	
	private static final String namespace = "com.boardPrograms.web.board.dao.boardsMapper";
	
	public AccessDAOImpl(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	public void setAutoCommit(boolean autoCommit) { 
		try {
			sqlSession.getConnection().setAutoCommit(autoCommit);
		} catch (SQLException e) { 
			// TODO Auto-generated catch block 
			e.printStackTrace(); 
		} 
	}
	 
	public void commit() {
		sqlSession.commit();
	}
	
	public void rollback() {
		sqlSession.rollback();
	}
	
	@Override
	public List<AccessVO> getAccessList(Params params) {
		return sqlSession.selectList(namespace + ".getAccessList", params);
		//return sqlSession.selectList(namespace + ".getAccessList", params);
		//return sqlSession.selectList("com.boardPrograms.web.board.boarsMapper.getAccessList", params);
	}
	 
	public SqlSession getSqlSession() {
		return sqlSession;
	}
	
	@Autowired
	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	
	/*
	@Override
	public Map<String, Object> getAccessList(Params params) {
		// TODO Auto-generated method stub
		System.out.println(params.getCampID());
		
		List<Params> list = new ArrayList<Params>();
		Map<String, Object> map = new HashMap<String, Object>();
		
		map.put("CampID", params.getCampID());
		
		sqlSession.selectOne("getAccessList", map);
		
		
		return null;
	}
	*/
	
}
