package com.arri.biz.server.service;

import java.sql.Date;
import java.util.List;

import com.arri.biz.server.dao.DAOImpl;
import com.arri.biz.server.vo.BoardVo;
import com.arri.biz.server.vo.HireInfoVo;
import com.arri.biz.server.vo.UsersVo;

public class ArriServerService implements Service{
	DAOImpl dao = new DAOImpl();

	@Override
	public Boolean login(String id, String pw) {
		if (dao.login(id,pw)) 
			return true;
		else
			return false;
	}

	@Override
	public Boolean sign(UsersVo user) {
		return dao.insertUser(user);
	}

	@Override
	public void modify_pwCheck() {
	}

	@Override
	public void modify() {
	}

	@Override
	public void dropOut() {
	}

	@Override
	public String idfind(String name, Date date) {
		return dao.idfind(name, date);
	}

	@Override
	public String pwfind(String id, String name, Date date) {
		return dao.pwfind(id, name, date);
	}

	@Override
	public Boolean  inserHireInfo(HireInfoVo p2) {
		return dao.inserHireInfo(p2);
	}

	@Override
	public Object[] prints(String id) {
		return dao.prints(id);
	}

	@Override
	public void chat() {
	}

	@Override
	public void sendModify() {
	}

	@Override
	public List<BoardVo> printsBoard() {
		return dao.printsBoard();
	}

	@Override
	public Boolean updateBoard(BoardVo bv) {
		return dao.updateBoard(bv);
	}

	@Override
	public Boolean inserBoard(BoardVo bv) {
		return dao.inserBoard(bv);
	}

	@Override
	public Boolean deleteBoard(BoardVo bv) {
		return dao.deleteBoard(bv);
	}

	@Override
	public BoardVo printBoard(int seq) {
		return dao.printBoard(seq);
	}

	@Override
	public List<BoardVo> searchBoard(String condition, String keyword) {
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

	@Override
	public Boolean updateUser(UsersVo p1) {
		return dao.updateUser(p1);
	}

	@Override
	public Boolean deleteUser(String id) {
		return dao.deleteUser(id);
	}


	
	
	
	
	
	/*@Override
	public void sign() {
		System.out.println("ȸ������ ����");
		if (user != null) {
			if (dao.idCheck(((UsersVo) user).getId())) {
				prw.println("Exist ID");
				prw.flush();
			} else {
				if (dao.insertUser((UsersVo) user)) {
					System.out.println(user);
					prw.println("success");
					prw.flush();
					System.out.println("ȸ������ �Ϸ�");
				}
				else {
					System.out.println(user);
					prw.println("fail");
					prw.flush();
				}
			}
		} else {
			System.out.println(user);
			prw.println("fail");
			prw.flush();
		}
	}

	@Override
	public void modify_pwCheck() {
		System.out.println("��й�ȣ üũ ����");
		if (user != null) {
			if (dao.login(((UsersVo) user).getId(), ((UsersVo) user).getPw())) {
				System.out.println(user);
				prw.println("success");
				prw.flush();
				System.out.println("��й�ȣ üũ �Ϸ�");
			} else {
				prw.println("fail");
				prw.flush();
			}
		} else {
			prw.println("fail");
			prw.flush();
		}
	}

	@Override
	public void modify() {
		System.out.println("ȸ�� ���� ���� ����");
		if (user != null) {
			if (dao.updateUser((UsersVo) user)) {
				System.out.println((UsersVo) user);
				prw.println("success");
				prw.flush();
				System.out.println("ȸ�� ���� ���� �Ϸ�");
			}
		} else {
			prw.println("fail");
			prw.flush();
		}
	}

	@Override
	public void dropOut() {
		System.out.println("ȸ��Ż�� ����");
		if (user != null) {
			if (dao.login(((UsersVo) user).getId(), ((UsersVo) user).getPw())) {
				if (dao.deleteUser(((UsersVo) user).getId())) {
					prw.println("success");
					prw.flush();
				}
			} else {
				prw.println("fail");
				prw.flush();
			}
		} else {
			prw.println("fail");
			prw.flush();
		}
	}

	@Override
	public void idfind() {
		System.out.println("id ã�� ����");
		if (user != null) {
			if (!(dao.idfind(((UsersVo) user).getName(), ((UsersVo) user).getDate())).equals("")) {
				prw.println(dao.idfind(((UsersVo) user).getName(), ((UsersVo) user).getDate()));
				prw.flush();
			} else {
				prw.println("fail");
				prw.flush();
			}
		} else {
			prw.println("fail");
			prw.flush();
		}
	}

	@Override
	public void pwfind() {
		System.out.println("��й�ȣ ã�� ����");
		if (user != null) {
			String pw = dao.pwfind(((UsersVo) user).getId(), ((UsersVo) user).getName(), ((UsersVo) user).getDate());
			if (!pw.equals("")) {
				System.out.println("���: " + pw);
				prw.println(pw);
				prw.flush();
			} else {
				prw.println("fail");
				prw.flush();
			}
		} else {
			prw.println("fail");
			prw.flush();
		}
	}

	@Override
	public void hireInfo() {
		System.out.println("������� �Է� ����");
		if (user != null) {
			if (dao.inserHireInfo((HireInfoVo) user)) {
				System.out.println((HireInfoVo) user);
				prw.println("success");
				prw.flush();
				System.out.println("������� �Է� �Ϸ�");
			}
		} else {
			prw.println("fail");
			prw.flush();
		}
	}

	@Override
	public void prints() {
		System.out.println("����Ʈ ����");
		if (user != null) {
			if (dao.prints(((UsersVo) user).getId()) != null) {
				try {
					oos.writeObject(dao.prints(((UsersVo) user).getId()));
					System.out.println("����Ʈ �Ϸ�");
				} catch (IOException e) {
					e.printStackTrace();
				}
			} else {
				try {
					oos.writeObject(null);
					prw.println("fail");
					prw.flush();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		} else {
			try {
				oos.writeObject(null);
				prw.println("fail");
				prw.flush();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	@Override
	public void chat() {
		System.out.println("chat ����");
		if (user != null) {
			String id = ((UsersVo) user).getId();
			int num = (dao.Jobs_chat(((UsersVo) user).getId()));
			if (num != -1) {
				try {
					oos.writeObject(new UsersVo(id,num));
					System.out.println("chat �Ϸ�");
				} catch (IOException e) {
					e.printStackTrace();
				}
			} else {
				try {
					oos.writeObject(null);
					prw.println("fail");
					prw.flush();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		} else {
			try {
				oos.writeObject(null);
				prw.println("fail");
				prw.flush();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	@Override
	public void sendModify() {
		System.out.println("���� ���� ����");
		if (user != null) {
			if (dao.sendModify(((UsersVo) user).getId()) != null) {
				try {
					oos.writeObject(dao.sendModify(((UsersVo) user).getId()));
					System.out.println("���� ���� �Ϸ�");
				} catch (IOException e) {
					e.printStackTrace();
				}
			} else {
				try {
					oos.writeObject(null);
					prw.println("fail");
					prw.flush();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		} else {
			try {
				oos.writeObject(null);
				prw.println("fail");
				prw.flush();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}*/
}
