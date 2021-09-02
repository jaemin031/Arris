package com.arri.biz.server.service;

import java.sql.Date;
import java.util.List;

import com.arri.biz.server.vo.BoardVo;
import com.arri.biz.server.vo.HireInfoVo;
import com.arri.biz.server.vo.UsersVo;

public interface Service {
	public Boolean login(String id, String pw);
	public Boolean sign(UsersVo user);
	public void modify_pwCheck();
	public void modify();
	public void dropOut();
	public String idfind(String name, Date date);
	public String pwfind(String id, String name, Date date);
	public Boolean  inserHireInfo(HireInfoVo p2);
	public Object[] prints(String id);
	public void chat();
	public void sendModify();
	public UsersVo getUser(String id);
	public HireInfoVo getInfo(String id);
	public Boolean updateUser(UsersVo p1);
	public Boolean deleteUser(String id);
	
	/////보드~
	public List<BoardVo> printsBoard();
	public Boolean updateBoard(BoardVo bv);
	public Boolean inserBoard(BoardVo bv);
	public Boolean deleteBoard(BoardVo bv);
	public BoardVo printBoard(int seq);
	public List<BoardVo> searchBoard(String condition, String keyword);
}
