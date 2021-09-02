package com.arri.biz.server.dao;

import java.sql.Date;
import java.util.List;

import org.apache.log4j.Logger;

import com.arri.biz.server.vo.BoardVo;
import com.arri.biz.server.vo.HireInfoVo;
import com.arri.biz.server.vo.UsersVo;

public class DAOImpl implements DAO{
	ArriDAO dao = new ArriDAO();
	private Logger logger = Logger.getLogger(getClass());
	
	@Override
	public Boolean login(String id, String pw) {
		logger.info(id+" login");
		return dao.login(id, pw);
	}

	@Override
	public Boolean idCheck(String id) {
		logger.info(id+" Check");
		return dao.idCheck(id);
	}

	@Override
	public Boolean insertUser(UsersVo p) {
		logger.info(p.getId()+" ����");
		return dao.insertUser(p);		
	}

	@Override
	public Boolean updateUser(UsersVo p1) {
		logger.info(p1.getId()+" ���� ����");
		return dao.updateUser(p1);
	}

	@Override
	public Boolean deleteUser(String id) {
		logger.info(id+" ����");
		return dao.deleteUser(id);
	}

	@Override
	public String idfind(String name, Date day) {
		logger.info(dao.idfind(name, day) + " ã�ƿ���");
		return dao.idfind(name, day);
	}

	@Override
	public String pwfind(String id, String name, Date day) {
		logger.info(id + " ��й�ȣ ã��");
		return dao.pwfind(id, name, day);
	}

	@Override
	public int Jobs_chat(String id) {
		logger.info(id + " ä�� ����");
		return dao.Jobs_chat(id);
	}

	@Override
	public Boolean inserHireInfo(HireInfoVo p2) {
		logger.info(p2.getId() + " ��� ���� �Է�");
		return dao.inserHireInfo(p2);
	}

	@Override
	public Object[] prints(String id) {
		logger.info(id + " �������� ���");
		return dao.prints(id);
	}

	@Override
	public Object sendModify(String id) {
		logger.info(id + " ���� ����");
		return dao.sendModify(id);
	}

	@Override
	public int getMoney(int num) {
		return dao.getMoney(num);
	}

	@Override
	public List<BoardVo> printsBoard() {
		logger.info("보드 리스트 출력");
		return dao.printsBoard();
	}

	@Override
	public Boolean updateBoard(BoardVo bv) {
		logger.info(bv.getSeq() + " 번 보드 수정");
		return dao.updateBoard(bv);
	}

	@Override
	public Boolean inserBoard(BoardVo bv) {
		logger.info("보드 등록");
		return dao.inserBoard(bv);
	}

	@Override
	public Boolean deleteBoard(BoardVo bv) {
		logger.info(bv.getSeq() + " 번 보드 삭제");
		return dao.deleteBoard(bv);
	}

	@Override
	public BoardVo printBoard(int seq) {
		logger.info(seq + " 번 보드 출력");
		return dao.printBoard(seq);
	}

	@Override
	public List<BoardVo> searchBoard(String condition, String keyword) {
		logger.info(condition +" : "+ keyword + " --> 보드 리스트 출력");
		return dao.searchBoard(condition, keyword);
	}

	@Override
	public UsersVo getUser(String id) {
		return dao.getUser(id);
	}

	@Override
	public HireInfoVo getInfo(String id) {
		return dao.getInfo(id);
	}


}
