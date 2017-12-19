package service;

import vo.HireInfoVo;
import vo.UsersVo;

public interface ArriService {
	public void insertUser(UsersVo p);						// 회원 가입(객체를 받아 쿼리문을 통해 Users 테이블, HireInfo 테이블의 속성 생성 )
	public void updateUser(UsersVo p1,HireInfoVo p2);		// 회원 수정(수정이 된 값의 객체를 받아 서버 딴의 객체에게 오버write 및 db문을 통해 테이블 업데이트 수행)
	public void deleteUser(String id, String pw);			// 회원 탈퇴(id,pw)
	public void loginUser(String id, String pw);			// 로그인 기능
	
	public Object[] prints(HireInfoVo p);					// 범칙금 계산		또한 입력받는 HireInfoVo를 받아 쿼리문을 통해 HireInfoVo 업데이트 
															// [list<LawInfoVo>,list<LawyerVo>..,int(총 범칙금)] 반환
	public int getMoney();									// 받아야 할 적정 금액
															// 수행 시 범칙금 계산 기능 수행 여부 판단 필요
	
}
