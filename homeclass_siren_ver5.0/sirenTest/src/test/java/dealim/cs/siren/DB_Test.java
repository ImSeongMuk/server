package dealim.cs.siren;

import java.sql.Connection;
import java.sql.DriverManager;
import org.junit.Test;

public class DB_Test {
	@Test
	public void test() throws Exception {
	    Class.forName("org.mariadb.jdbc.Driver"); // 마리아DB
	    // Class.forName("com.mysql.jdbc.Driver"); MySQL

	    Connection con = DriverManager.getConnection("jdbc:mariadb://127.0.0.1:3306/siren","root", "201530231");// 마리아DB siren db 컨택
	    // Connection con =     DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/db이름","root","passwd"); MySQL
	    System.out.println(con);
	    }
}

