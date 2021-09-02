package com.arri.biz.server.dao;

import java.sql.Date;
import java.util.List;

import com.arri.biz.server.vo.BoardVo;
import com.arri.biz.server.vo.HireInfoVo;
import com.arri.biz.server.vo.UsersVo;

public interface DAO {
	public Boolean login(String id, String pw);
	public Boolean idCheck(String id);
	public Boolean insertUser(UsersVo p);
	public Boolean inserHireInfo(HireInfoVo p2);
	public Boolean updateUser(UsersVo p1);
	public Boolean deleteUser(String id);
	public String idfind(String name,Date day);
	public String pwfind(String id, String name, Date day);
	public int Jobs_chat(String id);
	public Object[] prints(String id);
	public Object sendModify(String id);
	public int getMoney(int num);
	public UsersVo getUser(String id);
	public HireInfoVo getInfo(String id);
	
	/////보드~
	public List<BoardVo> printsBoard();
	public Boolean updateBoard(BoardVo bv);
	public Boolean inserBoard(BoardVo bv);
	public Boolean deleteBoard(BoardVo bv);
	public BoardVo printBoard(int seq);
	public List<BoardVo> searchBoard(String condition, String keyword);	
}
