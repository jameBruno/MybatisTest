package com.boardPrograms.web.board.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.object.SqlQuery;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import com.boardPrograms.web.board.common.Pagination;
import com.boardPrograms.web.board.dao.AccessDAO;
import com.boardPrograms.web.board.model.AccessVO;
import com.boardPrograms.web.board.model.BoardVO;
import com.boardPrograms.web.board.model.Params;
import com.boardPrograms.web.board.service.AccessService;
import com.boardPrograms.web.board.service.AccessServiceImpl;

import com.boardPrograms.web.board.model.AccessVO;
import com.boardPrograms.web.board.model.BoardVO;
import com.boardPrograms.web.board.model.Params;

//@Repository

public interface AccessDAO {
	//public Map<String, Object> getAccessList(Params params);
	public void setAutoCommit(boolean autoCommit);

	public void commit();

	public void rollback();

	public List<AccessVO> getAccessList(Params params);
}
