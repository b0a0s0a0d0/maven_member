package random;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.apache.commons.text.RandomStringGenerator;

import bean.MemberBasicBean;
import bean.MemberInfoHope;

public class randominsert {

	public static void main(String[] args) {
		char[][] num = { { 'a', 'z' }, { 'A', 'Z' }, { '0', '9' } };
		int row = 100000;
		String[] city = { "臺北市 ", "新北市", "基隆市", "桃園市", "新竹市", "新竹縣", "苗栗縣", "臺中市", "彰化縣", "南投縣", "雲林縣", "嘉義市", "嘉義縣",
				"臺南市", "高雄市", "屏東縣", "宜蘭縣", "花蓮縣", "臺東縣", "澎湖縣", "金門縣", "連江縣" };
		String name = "劉士凱、林詩惟、蘇逸樺、馮姿婷、黃惠珠、江仕希、" + "林依婷、楊石一、陳晉清、懷京夢、林彥季、崔惠玲、程雅帆、" + "趙育菁、蔡孟妹、黃怡婷、吳美慧、錢晴鴻、李孟名、孫炳弘、"
				+ "程常湖、楊雅男、蔡惠君、黃郁郁、劉家春、倪克琳、許淑芬、" + "謝華珊、吳柏成、蔡瑜凌、晏子揚、游慧娟、謝浩江、許怡君、" + "林婉妍、黃筱玲、傅建火、楊雅宜、張家佑、陳志翰、孫俊宏、"
				+ "陳嘉偉、陳秋一、蔡寶松、張堅霖、林俊玫、陳君侑、裘合士、" + "盧興韋、謝詠人、張定一、方靜怡、林美漢、李慈恆、賴剛佳、" + "廖盛綺、張儒峰、吳淑君、沈姿睿、黃旻信、林堯昆、郭雅映、"
				+ "林木男、傅慧玲、張仁翰、馮冠傑、許家欣、詹兆育、連麗君、" + "蘇崇玫、黃偉舜、林秋吉、許莉宸、林介琴、羅姿伶、李國偉、" + "黃承翰、黃郁云、吳柏修、周怡君、王明能、汪千芬、錢科燦、"
				+ "許雅芬、陳心紋、蔡慧茹、丁柔仁、羅俐花、何玉梅、黃靖念、" + "劉慧娟、陳建德、陳柏怡、林倍緯、葉淑婷、林千惠、陳語廷、" + "陳怡君、張家旺、林玉惠、姚耀德、胡琬仰、葉佩君、黃嘉秋、"
				+ "廖家瑜、郭雅萍、魏柏青、周怡珊、陳逸琬、林羽伶、陳歡延、" + "陳雅容、陳美妃、林柏映、黎麗萍、黃宗翰、劉俊傑、李佐俐、" + "蔣重星、何佳卉、邱健銘、賴淑貞、劉世賢、吳威宇、劉巧屏、"
				+ "馬鎮蓉、吳佩城、李寶玫、王欣穎、張瑞昇、廖柔儀、邱怡君、" + "鄧憶堯、陳俞辛、庾靜雯、黃怡怡、黃旭延、王淑惟、謝允孝、" + "林玉啟、趙正齊、陳建輝、章佳純、黎貴恩、藍枝慈、王慈南、"
				+ "姚怡孜、吳俊甫、涂雅茹、宋彥廷、張科儀、林宗文、柳惠珠、" + "吳雅萍、邱惠文、唐舒婷、張佩珊、王偉江、李雅江、趙沛凱、" + "馮玲迪、林雅萍、沈佑菁、陳豪書、李桂心、李彥憲、陳玟淑、"
				+ "王法妃、林均禎、藍俊諺、陳琪禮、林建霖、彭聿盈、陳品治、" + "杜詩涵、陳昇泰、周志瑋、邱軒豪、張景珊、陳心怡、賴群緯、" + "張瑞輝、陳國然、吳姿君、張怡孜、陳佳宸、陳乃鑫、陳宜一、"
				+ "柯雅雯、雷麗華、黎育堅、林宜坤、謝依軍、鐘士凱、劉怡靜、" + "李岱玫、蔡怡靜、曾亭合、張逸生、陳惠玲";
		String[] namearray = name.split("、");
		String[] email = { "@yahoo.com", "@google.com", "@outlook.com", "@aol.com" };
		RandomStringGenerator rsgnum = new RandomStringGenerator.Builder().withinRange(num).build();
		MemberBasicBean mb = new MemberBasicBean();
		final String sqlstr1 = "Insert Into member(memberEmail,memberPassword,memberName,memberBirth,"
				+ "memberSex,memberCity,vipstatus)Values(?,?,?,?,?,?,?)";

		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			Connection conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;database=friends", "sa",
					"password");
			System.out.println("連線狀態: " + !conn.isClosed());
			PreparedStatement state = conn.prepareStatement(sqlstr1);
			for (int i = 0; i < row; i++) {
				String date = (int) (Math.random() * (2012 - 1900) + 1900) + "-" + (int) (Math.random() * (12 - 1) + 1)
						+ "-" + (int) (Math.random() * (28 - 1) + 1);
				mb.setMemberEmail(rsgnum.generate(10) + email[(int) (Math.random() * email.length)]);
				mb.setMemberPassword(rsgnum.generate(10));
				mb.setMemberName(namearray[(int) (Math.random() * namearray.length)]);
				mb.setMemberBirth(Date.valueOf(date));
				mb.setMemberSex((int) (Math.random() * 2));
				mb.setMemberCity(city[(int) (Math.random() * city.length)]);
				mb.setVipStatus((int) (Math.random() * 2));

				state.setString(1, mb.getMemberEmail());
				state.setString(2, mb.getMemberPassword());
				state.setString(3, mb.getMemberName());
				state.setDate(4, mb.getMemberBirth());
				state.setInt(5, mb.getMemberSex());
				state.setString(6, mb.getMemberCity());
				state.setInt(7, mb.getVipStatus());
				state.addBatch();
			}
			int[] staterow = state.executeBatch();
			state.close();
			System.out.println("member_Table 新增: " + staterow.length + "筆");
//-------------------------------------------------------------------------------------------

			String[] intereststr = { "棒球", "籃球", "健身", "游泳", "爬山", "賞鳥", "音樂", "美食", "逛街", "電玩", };
			final String sqlstr2 = "Insert Into memberInterest(insterest)Values(?)";
			PreparedStatement state2 = conn.prepareStatement(sqlstr2);

			MemberInfoHope mh = new MemberInfoHope();

			for (int i = 0; i < intereststr.length; i++) {
				mh.setInsterest(intereststr[i]);
				state2.setString(1, mh.getInsterest());
				state2.addBatch();
			}
			int[] state2row = state2.executeBatch();
			state2.close();
			System.out.println("interest_Table 新增: " + state2row.length + "筆");
//-------------------------------------------------------------------------------------------

			String[] bodytype = { "胖", "壯", "平凡", "瘦" };
			String[] education = { "博士", "碩士", "學士", "高中", "國中", "國小", "文盲" };
			String[] drink = { "酗酒", "小酌", "滴酒不沾", "交際應酬" };
			String[] ethnicity = { "白種人", "黑種人", "黃種人" };
			String[] religion = { "天主教", "基督教", "道教", "佛教", "傳統信仰", "無神論", "其他" };
			final String sqlstr3 = "Insert Into memberInfo(memberId,interestId,bodyType,"
					+ "marriage,education,smoking,drink,ethnicity,religion,salary)" + "Values(?,?,?,?,?,?,?,?,?,?)";
			final String sqlstr4 = "Insert Into memberHope(memberId,bodyType,"
					+ "marriage,education,smoking,drink,ethnicity,religion,salary)" + "Values(?,?,?,?,?,?,?,?,?)";
			final String sqlstr5 = "Select TOP 1 interestId From memberInterest Order By interestId DESC";
			PreparedStatement state5 = conn.prepareStatement(sqlstr5);
			ResultSet rs = state5.executeQuery();
			rs.next();
			int interestId = rs.getInt(1);
			rs.close();
			System.out.println("interest_Id共: " + interestId + "筆");
			state5.close();
			PreparedStatement state3 = conn.prepareStatement(sqlstr3);
			for (int i = 0; i < row; i++) {
				mh.setMemberId(i + 1);
				mh.setInterestId((int) (Math.random() * interestId + 1));
				mh.setBodyType(bodytype[(int) (Math.random() * bodytype.length)]);
				mh.setMarriage((int) (Math.random() * 2));
				mh.setEducation(education[(int) (Math.random() * education.length)]);
				mh.setSmoking((int) (Math.random() * 2));
				mh.setDrink(drink[(int) (Math.random() * drink.length)]);
				mh.setEthnicity(ethnicity[(int) (Math.random() * ethnicity.length)]);
				mh.setReligion(religion[(int) (Math.random() * religion.length)]);
				mh.setSalary((int) (Math.random() * (100000 - 22000) + 22000));
				state3.setInt(1, mh.getMemberId());
				state3.setInt(2, mh.getInterestId());
				state3.setString(3, mh.getBodyType());
				state3.setInt(4, mh.isMarriage());
				state3.setString(5, mh.getEducation());
				state3.setInt(6, mh.isSmoking());
				state3.setString(7, mh.getDrink());
				state3.setString(8, mh.getEthnicity());
				state3.setString(9, mh.getReligion());
				state3.setInt(10, mh.getSalary());
				state3.addBatch();
			}
			int[] state3row = state3.executeBatch();
			state3.close();
			System.out.println("member_info 新增: " + state3row.length + "筆");
			PreparedStatement state4 = conn.prepareStatement(sqlstr4);
			for (int i = 0; i < row; i++) {
				mh.setMemberId(i + 1);
				mh.setBodyType(bodytype[(int) (Math.random() * bodytype.length)]);
				mh.setMarriage((int) (Math.random() * 2));
				mh.setEducation(education[(int) (Math.random() * education.length)]);
				mh.setSmoking((int) (Math.random() * 2));
				mh.setDrink(drink[(int) (Math.random() * drink.length)]);
				mh.setEthnicity(ethnicity[(int) (Math.random() * ethnicity.length)]);
				mh.setReligion(religion[(int) (Math.random() * religion.length)]);
				mh.setSalary((int) (Math.random() * (100000 - 22000) + 22000));
				state4.setInt(1, mh.getMemberId());
				state4.setString(2, mh.getBodyType());
				state4.setInt(3, mh.isMarriage());
				state4.setString(4, mh.getEducation());
				state4.setInt(5, mh.isSmoking());
				state4.setString(6, mh.getDrink());
				state4.setString(7, mh.getEthnicity());
				state4.setString(8, mh.getReligion());
				state4.setInt(9, mh.getSalary());
				state4.addBatch();
			}
			int[] state4row = state4.executeBatch();
			state4.close();
			System.out.println("member_Hope 新增: " + state4row.length + "筆");
			conn.close();
			System.out.println("連線狀態: " + !conn.isClosed());

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
