package service;

import vo.HireInfoVo;
import vo.UsersVo;

public interface ArriService {
	public void insertUser(UsersVo p);						// ȸ�� ����(��ü�� �޾� �������� ���� Users ���̺�, HireInfo ���̺��� �Ӽ� ���� )
	public void updateUser(UsersVo p1,HireInfoVo p2);		// ȸ�� ����(������ �� ���� ��ü�� �޾� ���� ���� ��ü���� ����write �� db���� ���� ���̺� ������Ʈ ����)
	public void deleteUser(String id, String pw);			// ȸ�� Ż��(id,pw)
	public void loginUser(String id, String pw);			// �α��� ���
	
	public Object[] prints(HireInfoVo p);					// ��Ģ�� ���		���� �Է¹޴� HireInfoVo�� �޾� �������� ���� HireInfoVo ������Ʈ 
															// [list<LawInfoVo>,list<LawyerVo>..,int(�� ��Ģ��)] ��ȯ
	public int getMoney();									// �޾ƾ� �� ���� �ݾ�
															// ���� �� ��Ģ�� ��� ��� ���� ���� �Ǵ� �ʿ�
	
}
