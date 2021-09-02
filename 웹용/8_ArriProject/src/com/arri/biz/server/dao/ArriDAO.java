package com.arri.biz.server.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import org.apache.log4j.Logger;

import com.arri.biz.server.vo.BoardVo;
import com.arri.biz.server.vo.HireInfoVo;
import com.arri.biz.server.vo.LawInfoVo;
import com.arri.biz.server.vo.LawyerVo;
import com.arri.biz.server.vo.UsersVo;
import com.arri.util.DataSourceUtil;

public class ArriDAO implements DAO{
	Connection con;
	ResultSet rs;
	PreparedStatement ps;
	private Logger logger = Logger.getLogger(getClass());

	@Override
	public Boolean login(String id, String pw) {
		String sql = "select pw from users where id = ?";
		try {
			con = DataSourceUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, id);
			rs = ps.executeQuery();
			while (rs.next()) {
				if (pw.equals(rs.getString("pw"))) {
					System.out.println(rs.getString("pw"));
					return true;
				}
			}
		} catch (SQLException e) {
			logger.error(e + " ����");
		} finally {
			DataSourceUtil.close(rs, ps, con);
		}
		return false;
	}

	@Override
	public Boolean idCheck(String id) {
		String sql = "select id from users where id = ?";
		try {
			con = DataSourceUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, id);
			rs = ps.executeQuery();
			if (rs.next()) {
				id.equals(rs.getString("id"));
				return true;
			}
		} catch (SQLException e) {
			logger.error(e + " ����");
		} finally {
			DataSourceUtil.close(rs, ps, con);
		}
		return false;
	}

	@Override
	public Boolean insertUser(UsersVo p) {
		String sql1 = "select nvl2(max(num),max(num)+1,1) usernumber from users";
		String sql2 = "insert into HireInfo values(?,0,'N','N','N/N/N/N/N',0,0,0,0,0,1,'N/N/N/N/N/N','N','N/N/N','N/N/N/N/N/0')";
		String sql3 = "insert into users values(?,?,?,?,?,?)";
		int usernumber = -1;
		try {
			con = DataSourceUtil.getConnection();
			ps = con.prepareStatement(sql1);
			rs = ps.executeQuery();
			while (rs.next()) {
				usernumber = rs.getInt("usernumber");
			}
			con.close();

			con = DataSourceUtil.getConnection();
			ps = con.prepareStatement(sql2);
			ps.setInt(1, usernumber);
			ps.executeUpdate();
			con.close();

			con = DataSourceUtil.getConnection();
			ps = con.prepareStatement(sql3);
			ps.setString(1, p.getId());
			ps.setString(2, p.getPw());
			ps.setString(3, p.getName());
			ps.setString(4, p.getGender());
			ps.setDate(5, p.getDate());
			ps.setInt(6, usernumber);
			System.out.println(ps.toString());
			ps.executeUpdate();
			con.close();

			return true;
		} catch (SQLException e) {
			logger.error(e + " ����");
		} finally {
			DataSourceUtil.close(rs, ps, con);
		}
		return false;
	}

	@Override
	public Boolean updateUser(UsersVo p1) {
		UsersVo u = p1;
		int usernumber = -1;
		try {
			String sql1 = "select num from users where id=?";
			String sql2 = "update users set name=?,gender=?,birthDate=?,pw = ? where num = ?";

			con = DataSourceUtil.getConnection();
			ps = con.prepareStatement(sql1);
			ps.setString(1, u.getId());
			rs = ps.executeQuery();
			while (rs.next()) {
				usernumber = rs.getInt("num");
			}
			con.close();
			con = DataSourceUtil.getConnection();
			ps = con.prepareStatement(sql2);
			ps.setString(1, u.getName());
			ps.setString(2, u.getGender());
			ps.setDate(3, u.getDate());
			ps.setString(4, u.getPw());
			ps.setInt(5, usernumber);
			int rows = ps.executeUpdate();
			con.close();

			if (rows >= 1) {
				System.out.println("update ����");
				return true;
			}
		} catch (SQLException e) {
			logger.error(e + " ����");
		} finally {
			DataSourceUtil.close(rs, ps, con);
		}
		return false;
	}

	@Override
	public Boolean inserHireInfo(HireInfoVo p2) {
		try {
			int usernumber = -1;
			String sql = "select num from users where id = ?";
			String sql2 = "update hireInfo set wage=?,insuCheck=?,vioCheck=?,fireCheck=?,payMoney=?,d_day=?,e_day=?,d_time=?,n_time = ?, jobNum = ?, disPay = ?, getMoney = ?, docCheck = ?, sal = ? where num = ?";

			con = DataSourceUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, p2.getId());
			rs = ps.executeQuery();
			while (rs.next()) {
				usernumber = rs.getInt("num");
			}
			con.close();

			con = DataSourceUtil.getConnection();
			ps = con.prepareStatement(sql2);
			ps.setInt(1, p2.getWage());
			ps.setString(2, p2.getInsuCheck());
			ps.setString(3, p2.getVioCheck());
			ps.setString(4, p2.getFireCheck());
			ps.setInt(5, p2.getPayMoney());
			ps.setInt(6, p2.getD_day());
			ps.setInt(7, p2.getE_day());
			ps.setInt(8, p2.getD_time());
			ps.setInt(9, p2.getN_time());
			ps.setInt(10, p2.getJobNum());
			ps.setString(11, p2.getDisPay());
			ps.setString(12, p2.getGetMoney());
			ps.setString(13, p2.getDocCheck());
			ps.setString(14, p2.getSal());
			ps.setInt(15, usernumber);
			ps.executeUpdate();
			con.close();
			return true;
		} catch (SQLException e) {
			logger.error(e + " ����");
		} finally {
			DataSourceUtil.close(rs, ps, con);
		}
		return false;
	} // ���� �Ķ������ ��� �� �ش� id,pw ��Ī �� �ش� �Ӽ�(���� ��)�� �� �÷��� ������Ʈ

	@Override
	public Boolean deleteUser(String id) {
		try {
			String sql1 = "select num from users where id=?";
			String sql1_= "delete from board where userid = ?";
			String sql2 = "delete from users where num = ?";
			String sql3 = "delete from hireInfo where num = ?";

			int usernumber = -1;
			con = DataSourceUtil.getConnection();
			ps = con.prepareStatement(sql1);
			ps.setString(1, id);
			rs = ps.executeQuery();
			while (rs.next()) {
				usernumber = rs.getInt("num");
			}
			con.close();

			con = DataSourceUtil.getConnection();
			ps = con.prepareStatement(sql1_);
			ps.setString(1, id);
			ps.executeUpdate();
			con.close();
			
			con = DataSourceUtil.getConnection();
			ps = con.prepareStatement(sql2);
			ps.setInt(1, usernumber);
			int rows = ps.executeUpdate();
			con.close();

			con = DataSourceUtil.getConnection();
			ps = con.prepareStatement(sql3);
			ps.setInt(1, usernumber);
			rows += ps.executeUpdate();
			con.close();

			if (rows == 2) {
				System.out.println("id���� ȸ�� Ż�� �Ǿ����ϴ�.");
				return true;
			}
		} catch (SQLException e) {
			logger.error(e + " ����");
		} finally {
			DataSourceUtil.close(rs, ps, con);
		}
		return false; // where���� pw Ȯ�� �� delete ���� -> ���� ���� �Ӽ� ���� + ��� ���� ����
	}

	@Override
	public String idfind(String name, Date day) {
		String sql1 = "select id from users where name=? and birthDate = ?";
		String result = "";
		try {
			con = DataSourceUtil.getConnection();
			ps = con.prepareStatement(sql1);
			ps.setString(1, name);
			ps.setDate(2, day);
			rs = ps.executeQuery();

			while (rs.next()) {
				result = rs.getString("id");
			}

		} catch (SQLException e) {
			logger.error(e + " ����");
		} finally {
			DataSourceUtil.close(rs, ps, con);
		}
		return result;
	}

	@Override
	public String pwfind(String id, String name, Date day) {
		String sql1 = "select pw from users where name=? and birthDate = ? and id = ?";
		String result = "";
		try {
			con = DataSourceUtil.getConnection();
			ps = con.prepareStatement(sql1);
			ps.setString(1, name);
			ps.setDate(2, day);
			ps.setString(3, id);
			rs = ps.executeQuery();

			while (rs.next()) {
				result = rs.getString("pw");
			}
			return result;
			
		} catch (SQLException e) {
			logger.error(e + " ����");
		} finally {
			DataSourceUtil.close(rs, ps, con);
		}
		return result;
	}

	@Override
	public Object[] prints(String id) {
		Object[] result = new Object[5]; // [���� ����,��ȣ�� ����, ��Ģ��,���� �� ���ɾ�, �Ǽ��ɾ�]
		String[] disPay = new String[6]; // �ӱݻ谨
		String[] getMoney = new String[1]; // ���غ���
		String[] vioCheck = new String[1]; // ��������
		String[] docCheck = new String[3]; // �ٷΰ�༭
		String[] fireCheck = new String[5]; // �δ��ذ�
		String[] sal = new String[6]; // �ӱ�ü��
		int wage = 0; // �ñ�
		String[] article = new String[21]; // ���� ��ȣ
		int[] fine = new int[21]; // ����
		Vector<LawInfoVo> law = new Vector<LawInfoVo>(); // ���� ����(�۽� �� ��)
		Vector<LawyerVo> lawyer = new Vector<LawyerVo>(); // ��ȣ�� ����(�۽� �� ��)
		int[] lc_number = { 0, 0, 0, 0, 0, 0, 0, 0 }; // �ش� �з� id üũ
		int resultPay = 0; // ��Ģ��
		int d_day = 0, e_day = 0, d_time = 0, n_time = 0;
		int comPay = 0; // ���� �� ���ɾ�
		int payMoney = 0; // �Ǽ��ɾ�
		int usernumber = -1; // ���� number
		int avgSal = 0; // �� ��� �ӱ�

		String set_num_sql = "select num from users where id = ?";
		String set_hire_sql = "select * from hireInfo where num = ?";
		String set_article_sql = "select article, fine from LawInfo";
		String set_law_sql = "select * from LawInfo where article = ?";
		String set_Lawyer_sql = "select * from Lawcategory lc, Lawyer lw where lc.lcNumber=lw.lcNumber and lc.lcNumber = ?";

		try {
			con = DataSourceUtil.getConnection();
			ps = con.prepareStatement(set_num_sql);
			ps.setString(1, id);
			rs = ps.executeQuery();
			while (rs.next()) {
				usernumber = rs.getInt("num");
			}
			con.close();

			avgSal = this.getMoney(usernumber);

			con = DataSourceUtil.getConnection();
			ps = con.prepareStatement(set_hire_sql);
			ps.setInt(1, usernumber);
			rs = ps.executeQuery();
			while (rs.next()) {
				disPay = (rs.getString("disPay")).split("/");
				getMoney = (rs.getString("getMoney")).split("/");
				vioCheck = (rs.getString("vioCheck")).split("/");
				docCheck = (rs.getString("docCheck")).split("/");
				fireCheck = (rs.getString("fireCheck")).split("/");
				sal = (rs.getString("sal")).split("/");
				d_day = rs.getInt("d_day");
				e_day = rs.getInt("e_day");
				d_time = rs.getInt("d_time");
				n_time = rs.getInt("n_time");
				wage = rs.getInt("wage");
				payMoney = rs.getInt("payMoney");
			}
			con.close();

			con = DataSourceUtil.getConnection();
			ps = con.prepareStatement(set_article_sql);
			rs = ps.executeQuery();
			int count = 0;
			while (rs.next()) {
				article[count] = rs.getString("article");
				fine[count] = rs.getInt("fine");
				count++;
			}

		} catch (SQLException e) {
			logger.error(e + " ����");
		} finally {
			DataSourceUtil.close(rs, ps, con);
		}

		/**
		 * dispay(�ӱݻ谨 ���� üũ) article[0] = 74�� 2�� article[1] = 74�� 6��
		 */
		if (disPay[0].equals("N") || disPay[1].equals("N")) {
			article[0] = " ";
			article[1] = " ";
		} else {
			if (disPay[2].equals("Y") && disPay[3].equals("N")) {
				article[0] = " ";
			}
			if (disPay[4].equals("N") || disPay[5].equals("Y")) {
				article[1] = " ";
			}
		}

		// article[2] üũ �ʿ� = 56��
		/**
		 * 
		 * article[2] = 56��
		 */
		comPay = (int) ((((d_time * wage) + (n_time * wage * 1.5)) * d_day)
				+ (((d_time * wage) + (n_time * wage * 1.5)) * e_day * 1.5));

		if (((avgSal / 30) * (d_day + e_day)) <= payMoney) {
			article[2] = " ";
		}

		/**
		 * getMoney(���غ��� ���� üũ) article[3] = 79�� 1��
		 */
		if (getMoney[0].equals("N")) {
			article[3] = " ";
		}

		/**
		 * vioCheck(�������� üũ) article[4] = 7�� article[5] = 8��
		 */
		if (vioCheck[0].equals("N")) {
			article[4] = " ";
			article[5] = " ";
		}

		/**
		 * docCheck(�ٷΰ�༭ üũ) article[6] = 17�� article[7] = 67�� 2�� article[8] =
		 * 67�� 3��
		 */
		for (int i = 0; i < 3; i++) {
			if (docCheck[i].equals("N")) {
				article[i + 6] = " ";
			}
		}

		/**
		 * fireCheck(�δ��ذ�) article[9] = 23�� 2�� article[10] = 24�� 3�� article[11]
		 * = 26�� article[12] = 27�� article[13] = 28��
		 */
		for (int i = 0; i < 5; i++) {
			if (fireCheck[i].equals("Y")) {
				article[i + 9] = " ";
			}
		}

		/**
		 * sal(�ӱ�ü��) article[14] = 34�� article[15] = 36�� article[16] = 45��
		 * article[17] = 44�� article[18] = 60�� article[19] = 46�� 1����
		 */
		if (sal[0].equals("Y")) {
			article[14] = " ";
			article[15] = " ";
		} else if (sal[1].equals("Y")) {
			article[16] = " ";
		} else if (sal[2].equals("Y")) {
			article[17] = " ";
		} else if (sal[3].equals("Y")) {
			article[18] = " ";
		} else if (sal[4].equals("N")) {
			article[19] = " ";
		}
		if (sal[4].equals("Y")) { // �޾� �޿� �߰�
			comPay += (Integer.parseInt(sal[5])) * ((avgSal / 30) * 0.7);
		}

		/**
		 * �����ӱ� ���� �� article[20] = 6�� 1�� // �����ӱ�
		 */
		if (wage >= 7530) {
			article[20] = " ";
		}

		try {
			for (int i = 0; i < 21; i++) {
				con = DataSourceUtil.getConnection();
				ps = con.prepareStatement(set_law_sql);
				ps.setString(1, article[i]);
				rs = ps.executeQuery();
				while (rs.next()) {
					law.add(new LawInfoVo(rs.getString("article"), rs.getString("explain"), rs.getInt("fine"),
							rs.getString("penalty"), rs.getInt("lcNumber")));
					lc_number[rs.getInt("lcnumber") - 1]++;
				}
				con.close();

			}
			for (int i = 0; i < 8; i++) {
				if (lc_number[i] != 0) {
					con = DataSourceUtil.getConnection();
					ps = con.prepareStatement(set_Lawyer_sql);
					ps.setInt(1, i + 1);
					rs = ps.executeQuery();
					while (rs.next()) {
						lawyer.add(new LawyerVo(rs.getString("phonenum"), rs.getString("lawyerName"),
								rs.getString("phrase"), rs.getString("workPlace"), rs.getString("lcName"),
								rs.getInt("lcnumber")));
					}
					con.close();
				}
			}
		} catch (SQLException e) {
			logger.error(e + " ����");
		} finally {
			DataSourceUtil.close(rs, ps, con);
		}

		for (int i = 0; i < 21; i++) {
			if (!article[i].equals(" ")) {
				if (fine[i] == 60) {
					resultPay += (int) ((comPay - wage) * 0.6);
				} else if (fine[i] == 1) {
					resultPay += avgSal;
				} else {
					resultPay += fine[i];
				}
			}
		}

		result[0] = law; // ���� ���� ����Ʈ
		result[1] = lawyer; // ��ȣ�� ���� ����Ʈ
		result[2] = resultPay; // �� ��Ģ��
		result[3] = comPay; // ���� �� ���ɾ�
		result[4] = payMoney; // �� ���ɾ�

		return result;
	}

	@Override
	public int getMoney(int num) {

		int d_day = 0, e_day = 0, d_time = 0, n_time = 0, wage = 0;
		int result;
		try {
			String sql1 = "select d_day, e_day, d_time, n_time, wage from hireInfo where num=?";
			con = DataSourceUtil.getConnection();
			ps = con.prepareStatement(sql1);
			ps.setInt(1, num);
			rs = ps.executeQuery();
			while (rs.next()) {
				d_day = rs.getInt("d_day");
				e_day = rs.getInt("e_day");
				d_time = rs.getInt("d_time");
				n_time = rs.getInt("n_time");
				wage = rs.getInt("wage");
			}
		} catch (SQLException e) {
			logger.error(e + " ����");
		} catch (Exception e) {
			logger.error(e + " ����");
		} finally {
			DataSourceUtil.close(rs, ps, con);
		}
		result = (int) ((((wage * (d_time + n_time))) / (d_day + e_day)) * 30); // ��
																				// ���
																				// �ӱ�
		return result;
	}

	@Override
	public int Jobs_chat(String id) {
		int result = 0;
		int usernum = -1;

		String sql1 = "select num from users where id = ?";
		String sql2 = "select jobNum from hireInfo where num = ?";

		try {
			con = DataSourceUtil.getConnection();
			ps = con.prepareStatement(sql1);
			ps.setString(1, id);
			rs = ps.executeQuery();
			while (rs.next()) {
				usernum = rs.getInt("num");
			}
			con.close();

			con = DataSourceUtil.getConnection();
			ps = con.prepareStatement(sql2);
			ps.setInt(1, usernum);
			rs = ps.executeQuery();
			while (rs.next()) {
				result = rs.getInt("jobNum");
			}
			return result;
		} catch (SQLException e) {
			logger.error(e + " ����");
		} finally {
			DataSourceUtil.close(rs, ps, con);
		}
		return -1;
	}
	
	@Override
	public Object sendModify(String id) {
		String sql1 = "select * from users where id = ?";
		UsersVo result = new UsersVo();
		try {
			con = DataSourceUtil.getConnection();
			ps = con.prepareStatement(sql1);
			ps.setString(1, id);
			rs = ps.executeQuery();

			while (rs.next()) {
				result.setId(rs.getString("id"));
				result.setName(rs.getString("name"));
				result.setGender(rs.getString("gender"));
				result.setDate(rs.getDate("birthdate"));
			}

			return result;
		} catch (SQLException e) {
			logger.error(e + " ����");
		} finally {
			DataSourceUtil.close(rs, ps, con);
		}
		return null;
	}

	/// 보드 ~~
	@Override
	public List<BoardVo> printsBoard() {
		String sql = "select * from board order by seq desc";
		BoardVo bv = null;
		List<BoardVo> list = new ArrayList<BoardVo>();
		
		try {
			con=DataSourceUtil.getConnection();
			ps=con.prepareStatement(sql);
			rs=ps.executeQuery();
			while(rs.next()) {
				bv=new BoardVo();
				bv.setSeq(rs.getInt("seq"));
				bv.setTitle(rs.getString("title"));
				bv.setWriter(rs.getString("writer"));
				bv.setComent(rs.getString("coment").trim());
				bv.setRegdate(rs.getDate("regdate"));
				bv.setUserid(rs.getString("userid"));
				bv.setCnt(rs.getInt("cnt"));
				bv.setPart(rs.getString("part"));
				list.add(bv);
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}finally {
			DataSourceUtil.close(rs, ps, con);
		}
		
		return list;
	}

	@Override
	public Boolean updateBoard(BoardVo bv) {		//좀더 고민 해봐야 함 뭐뭐를 수정 할 것인지
		String sql = "update board set part = ?,title = ?,coment = ? where seq = ?";
		int flag = -1;
		
		try {
			con = DataSourceUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, bv.getPart());
			ps.setString(2, bv.getTitle());
			ps.setString(3, bv.getComent().trim());
			ps.setInt(4, bv.getSeq());
			flag = ps.executeUpdate();
		} catch (SQLException e) {
			logger.error(e + " ����");
		} finally {
			DataSourceUtil.close(rs, ps, con);
		}
		if(flag == -1) {
			return false;
		}
		return true;
		
	}

	@Override
	public Boolean inserBoard(BoardVo bv) {
		String sql = "insert into board (seq, title, writer, coment, regdate, cnt, userid, part) "
				+ "values((select nvl(max(seq),0)+1 from board),?,?,?,sysdate,0,?,?)";
		int flag = -1;
		
		try {
			con = DataSourceUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, bv.getTitle());
			ps.setString(2, bv.getWriter());
			ps.setString(3, bv.getComent().trim());
			ps.setString(4, bv.getUserid());
			ps.setString(5, bv.getPart());
			flag = ps.executeUpdate();
		} catch (SQLException e) {
			logger.error(e + " ����");
		} finally {
			DataSourceUtil.close(rs, ps, con);
		}
		if(flag == -1) {
			return false;
		}
		return true;
	}

	@Override
	public Boolean deleteBoard(BoardVo bv) {
		String sql = "delete from board where seq = ? ";
		int flag = -1;
		
		try {
			con = DataSourceUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, bv.getSeq());
			flag = ps.executeUpdate();
			
		} catch (SQLException e) {
			logger.error(e + " ����");
		} finally {
			DataSourceUtil.close(rs, ps, con);
		}
		if(flag == -1) {
			return false;
		}
		return true;
	}

	@Override
	public BoardVo printBoard(int seq) {
		String sql = "select * from board where seq = ? ";
		BoardVo bv = null;
		
		try {
			con = DataSourceUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, seq);
			rs = ps.executeQuery();
				while(rs.next()) {
					bv = new BoardVo();
					bv.setSeq(rs.getInt("seq"));
					bv.setPart(rs.getString("part"));
					bv.setTitle(rs.getString("title"));
					bv.setWriter(rs.getString("writer"));
					bv.setComent(rs.getString("coment").trim());
					bv.setRegdate(rs.getDate("regdate"));
					bv.setCnt(rs.getInt("cnt"));
					bv.setUserid(rs.getString("userid"));
				}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DataSourceUtil.close(rs, ps, con);
		}		
		cntUpBoard(bv.getCnt(),bv.getSeq());
		bv.setCnt(bv.getCnt()+1);
		return bv;
	}

	@Override
	public List<BoardVo> searchBoard(String condition, String keyword) {
		String sql = "";
		BoardVo bv = null;
		List<BoardVo> list = new ArrayList<BoardVo>();

		if (condition.equals("seq")) {
			sql = "select * from board where seq like '%'|| ? ||'%' ";
		} else if (condition.equals("part")) {
			sql = "select * from board where part like '%'|| ? ||'%' ";	
		} else if (condition.equals("title")) {
			sql = "select * from board where title like '%'|| ? ||'%' ";		
		} else if (condition.equals("coment")) {
			sql = "select * from board where coment like '%'|| ? ||'%' ";
		} else if (condition.equals("writer")) {
			sql = "select * from board where writer like '%'|| ? ||'%' ";
		}
		try {
			con = DataSourceUtil.getConnection();
			ps = con.prepareStatement(sql);
			if(condition.equals("seq")) {
				ps.setInt(1,Integer.parseInt(keyword));
			}else {
				ps.setString(1, keyword);
			}
			rs = ps.executeQuery();
			while (rs.next()) {
				bv = new BoardVo();
				bv.setSeq(rs.getInt("seq"));
				bv.setPart(rs.getString("part"));
				bv.setTitle(rs.getString("title"));
				bv.setWriter(rs.getString("writer"));
				bv.setComent(rs.getString("coment"));
				bv.setRegdate(rs.getDate("regdate"));
				bv.setCnt(rs.getInt("cnt"));
				list.add(bv);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DataSourceUtil.close(rs, ps, con);
		}
		return list;
	}
	
	@Override
	public UsersVo getUser(String id) {
		String sql = "select * from users where id = ?";
		UsersVo user = new UsersVo();
		try {
			con = DataSourceUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, id);
			rs = ps.executeQuery();
			while (rs.next()) {
				user.setId(id);
				user.setName(rs.getString("name"));
				user.setPw(rs.getString("pw"));
				user.setDate(rs.getDate("birthdate"));
				user.setGender(rs.getString("gender"));
			}
		} catch (SQLException e) {
			logger.error(e + " ����");
		} finally {
			DataSourceUtil.close(rs, ps, con);
		}
		return user;
	}

	@Override
	public HireInfoVo getInfo(String id) {
		String sql1 = "select num from users where id = ?";
		String sql2 = "select *from hireinfo where num = ?";
		int usernumber = -1;
		HireInfoVo userinfo = new HireInfoVo();
		
		try {
			con = DataSourceUtil.getConnection();
			ps = con.prepareStatement(sql1);
			ps.setString(1, id);
			rs = ps.executeQuery();
			while (rs.next()) {
				usernumber = rs.getInt("num");
			}
			
			con.close();

			con = DataSourceUtil.getConnection();
			ps = con.prepareStatement(sql2);
			ps.setInt(1, usernumber);
			rs = ps.executeQuery();
			while(rs.next()) {
				userinfo.setWage(rs.getInt("wage"));
				userinfo.setInsuCheck(rs.getString("insuCheck"));
				userinfo.setVioCheck(rs.getString("vioCheck"));
				userinfo.setFireCheck(rs.getString("fireCheck"));
				userinfo.setPayMoney(rs.getInt("payMoney"));
				userinfo.setD_day(rs.getInt("d_day"));
				userinfo.setE_day(rs.getInt("e_day"));
				userinfo.setD_time(rs.getInt("d_time"));
				userinfo.setN_time(rs.getInt("n_time"));
				userinfo.setJobNum(rs.getInt("jobNum"));
				userinfo.setDisPay(rs.getString("disPay"));
				userinfo.setGetMoney(rs.getString("getMoney"));
				userinfo.setDocCheck(rs.getString("docCheck"));
				userinfo.setSal(rs.getString("sal"));
			}
			
		} catch (SQLException e) {
			logger.error(e + " ����");
		} finally {
			DataSourceUtil.close(rs, ps, con);
		}
		return userinfo;
	}
	
	public void cntUpBoard(int cnt , int seq) {
		String sql = "update board set cnt=? where seq=?";
		
		try {
		con = DataSourceUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1,cnt+1);
			ps.setInt(2,seq);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DataSourceUtil.close(rs, ps, con);
		}
	}


}
