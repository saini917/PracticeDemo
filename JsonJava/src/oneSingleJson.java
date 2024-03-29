
import java.io.File;
import java.io.FileWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import org.apache.commons.text.StringEscapeUtils;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;

public class oneSingleJson {
	static String mysqlDriver = "com.mysql.cj.jdbc.Driver";
	static String mysqlURL = "jdbc:mysql://localhost:3306/Business";
	static String username = "root";
	static String password = "Reema@1994";
	static Connection conn;
	static Statement stmt;
	static ResultSet rs;
	static CustomerDetials c;
	static ArrayList<CustomerDetials> ac;
	static JSONArray ja;

	public static void main(String str[]) throws ClassNotFoundException, SQLException {
		try {
			Class.forName(mysqlDriver);
			conn = DriverManager.getConnection(mysqlURL, username, password);
			stmt = conn.createStatement();
			// this is for single record
			// rs = stmt.executeQuery("select * from CustomerInfo where Location
			// ='Asia' and purchasedDate=curdate() limit 1;");
			// this is for multiple record
			rs = stmt.executeQuery("select * from CustomerInfo where Location ='Asia' and purchasedDate=curdate();");
			System.out.println(rs);

			ac = new ArrayList<CustomerDetials>();
			ja = new JSONArray();

			while (rs.next()) {
				/*
				 * System.out.println(rs.getString(1));
				 * System.out.println(rs.getString(2));
				 * System.out.println(rs.getInt(3));
				 * System.out.println(rs.getString(4));
				 */

				// 3 different json files, 3 diff java objects
				c = new CustomerDetials();
				c.setCourseName(rs.getString(1));
				c.setPurchaseDate(rs.getString(2));
				c.setAmount(rs.getInt(3));
				c.setLocation(rs.getString(4));
				ac.add(c);
				/*
				 * System.out.println(c.getCourseName());
				 * System.out.println(c.getPurchaseDate());
				 * System.out.println(c.getAmount());
				 * System.out.println(c.getLocation());
				 */
			}
			// https://jsonformatter.org/
			for (int i = 0; i < ac.size(); i++) {
				ObjectMapper om = new ObjectMapper();
				om.writeValue(new File("D:\\Workspace_NRDA\\JsonJava\\customerInfo" + i + ".json"), ac.get(i));
				// create java String from java objectS
				Gson gson = new Gson();
				String jsonString = gson.toJson(ac.get(i));
				ja.add(jsonString);
			}

			// json simple
			JSONObject jo = new JSONObject();
			jo.put("data", ja);
			//System.out.println(jo.toJSONString());
			String unescapeString=StringEscapeUtils.unescapeJson(jo.toJSONString());
			//System.out.println(unescapeString);
			String s1 =unescapeString.replace("\"{", "{");
			String finalString=s1.replace("}\"", "}");
			//System.out.println(finalString);
			
			//convert json string into json file 
			try (FileWriter file = new FileWriter("D:\\Workspace_NRDA\\JsonJava\\SingleJson.json")){
			      file.write(finalString);
			    }
			

			conn.close();
		} catch (Exception e) {
			System.out.println("Got an exception!");
			System.out.println(e.getMessage());
		}

	}
}
