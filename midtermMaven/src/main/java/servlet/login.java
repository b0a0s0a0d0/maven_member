package servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import bean.MemberBasicBean;
import logindao.IloginDaoImpl;
import logindao.loginDao;

/**
 * Servlet implementation class login
 */
@WebServlet("/login")
public class login extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Resource(name="jdbc/friends")
	private DataSource ds;
	private Connection conn;

	public void init() {
		try {
			conn = ds.getConnection();
		} catch (SQLException e) {
			System.out.print("error");
		}
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		MemberBasicBean mb = new MemberBasicBean();
		mb.setMemberEmail(request.getParameter("email"));
		mb.setMemberPassword(request.getParameter("password"));
		loginDao mbdao = new IloginDaoImpl(conn);
		
		if (mbdao.login(mb).getMemberId() != null) {
			response.getWriter().print(mbdao.login(mb).getMemberId());
		} else {
			response.getWriter().print("error");
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
