package com.boardPrograms.web.board.service;

import com.boardPrograms.web.board.dao.AccessDAO;
import com.boardPrograms.web.board.model.AccessVO;
import com.boardPrograms.web.board.model.Params;
import com.sun.istack.internal.logging.Logger;

import sun.util.logging.resources.logging;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.logging.Log;
import org.apache.ibatis.logging.LogFactory;
import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.jsp.PageContext;

@Component
@Transactional(isolation = Isolation.READ_UNCOMMITTED, propagation=Propagation.REQUIRED, rollbackFor=SQLException.class)
public class AccessServiceImpl implements AccessService {
	
	private static final String namespace = "com.boardPrograms.web.board.dao.boardsMapper";
	
	@Autowired
	AccessDAO accessDAO;
	AccessVO accessVO;
	
	@Autowired
	private SqlSession sqlSession;
	
	@Autowired
	private DataSourceTransactionManager transactionManager;
	
	private Log log = LogFactory.getLog(getClass());
	
	public AccessServiceImpl(AccessDAO accessDAO, SqlSession sqlSession) {
		this.accessDAO = accessDAO;
		this.sqlSession = sqlSession;
	}
	
	@Transactional(isolation = Isolation.READ_UNCOMMITTED, propagation=Propagation.REQUIRED, rollbackFor=SQLException.class)
	public List<AccessVO> getAccessList(final Params params) {
		try {
			sqlSession.getConnection().setAutoCommit(false);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		try {
			System.out.println(params.toString()); 
			accessDAO.getAccessList(params);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return params.getRef_result();
		
		
		/*
		 * final AccessDAO accessDAO = sqlSession.getMapper(AccessDAO.class);
		 * System.out.println(params.toString()); accessDAO.getAccessList(params);
		 * return params.getRef_result();
		 */
		
		/*
		 * DefaultTransactionDefinition def = new DefaultTransactionDefinition();
		 * def.setName("transaction");
		 * def.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);
		 * def.setPropagationBehavior(TransactionDefinition.ISOLATION_READ_UNCOMMITTED);
		 * 
		 * TransactionStatus status = transactionManager.getTransaction(def);
		 */

		
		/*
		 * System.out.println(params.toString()); accessDAO.getAccessList(params);
		 */
		
		/*
		 * try { //sqlSession.getConnection().setAutoCommit(false);
		 * //accessDAO.setAutoCommit(false); //final AccessDAO accessDAO =
		 * sqlSession.getMapper(AccessDAO.class);
		 * 
		 * } catch (Exception e) { accessDAO.rollback(); } finally {
		 * accessDAO.setAutoCommit(true); }
		 */
		
	
		
		/*
		 * final AccessDAO accessDAO = sqlSession.getMapper(AccessDAO.class);
		 * accessDAO.getAccessList(params); System.out.println(params.toString());
		 */
		
		//transactionManager.commit(status);
		
	}
	
	public AccessDAO getAccessDAO() {
		return accessDAO;
	}
	
	public void setAccessDAO(AccessDAO accessDAO) {
		this.accessDAO = accessDAO;
	}

	
	/*
	@Override
	public Map<String, Object> getAccessList(Params params) {
		// TODO Auto-generated method stub
		Map<String, Object> list = accessDAO.getAccessList(params);
		
		return null;
	}
	*/
	
	/*
	@Override
	public List<AccessVO> listAccessList() {
		return sqlSession.selectList(namespace+".listAccessList");
	}
	*/
	
	/*
	public AccessServiceImpl(AccessDAO accessDAO, SqlSession sqlSession) {
		this.accessDAO = accessDAO;
		//this.sqlSession = sqlSession;
	}
	*/
	
	/*
	@Override
	public List<AccessVO> listAccessList() {
		return sqlSession.selectList(namespace+".listAccessList");
	}
	*/
	
	/*
	@Override
	public List<AccessVO> getAccessList(final Params params) {
		return accessDAO.getAccessList(params);
	}
	*/
	
}
