package logindao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import bean.MemberBasicBean;

public class IloginDaoImpl implements loginDao {
	private DataSource ds;
	private Connection conn;


	public IloginDaoImpl(Connection conn){
		this.conn=conn;
		
	}

	@Override
	public MemberBasicBean login(MemberBasicBean mb) {
		String sqlstr="Select memberId From member Where memberEmail=? And memberPassword=?";
		try {
			conn=ds.getConnection();
			PreparedStatement state = conn.prepareStatement(sqlstr);
			state.setString(1, mb.getMemberEmail());
			state.setString(2, mb.getMemberPassword());
			ResultSet rs = state.executeQuery();
			rs.next();
			mb.setMemberId(rs.getInt("memberId"));
			rs.close();
			state.close();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return mb;
		
		
		
	}

}
