package service;

import dao.ArriDao;
import vo.HireInfoVo;
import vo.JobInfoVo;
import vo.JobsVo;
import vo.LawCategoryVo;
import vo.LawInfoVo;
import vo.LawyerVo;
import vo.UsersVo;


public class ArriServiceImple implements ArriService{
	
	ArriDao dao;
	
	@Override
	public void loginUser(String id, String pw) {
		dao = new ArriDao(id,pw);
	}
	@Override
	public void insertUser(UsersVo p){
		dao.insertUser(p);
	}
	
	@Override
	public void updateUser(UsersVo p1,HireInfoVo p2){
		dao.updateUser(p1,p2);
	}
	
	@Override
	public void deleteUser(String id, String pw){
		dao.deleteUser(id,pw);
	}
	
	@Override
	public Object[] prints(HireInfoVo p){
		return dao.prints(p);
	}
	
	@Override
	public int getMoney(){
		return dao.getMoney();
	}
	
	
}
