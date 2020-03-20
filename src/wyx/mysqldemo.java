package wyx;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class mysqldemo {
	
	
	/* public static void main(String[] args) {
         //声明Connection对象
         Connection con;
         //驱动程序名
         String driver = "com.mysql.jdbc.Driver";
         //URL指向要访问的数据库名mydata
         String url = "jdbc:mysql://localhost:3306/wyx";
         //MySQL配置时的用户名
         String user = "root";
         //MySQL配置时的密码
         String password = "wyx40223";
         //遍历查询结果集
         try {
             //加载驱动程序
             Class.forName(driver);
             //1.getConnection()方法，连接MySQL数据库！！
             con = DriverManager.getConnection(url,user,password);
           
             //2.创建statement类对象，用来执行SQL语句！！
             Statement state = con.createStatement();
            
             //3.ResultSet类，用来存放获取的结果集！！
             ResultSet rs =null;  
   
         } catch(ClassNotFoundException e) {   
             //数据库驱动类异常处理
             //System.out.println("Sorry,can`t find the Driver!");   
             e.printStackTrace();   
             } catch(SQLException e) {
             //数据库连接失败异常处理
             e.printStackTrace();  
             }catch (Exception e) {
             // TODO: handle exception
             e.printStackTrace();
         }
     }*/
	 


  //URL指向要访问的数据库名
  public static String url = "jdbc:mysql://localhost:3306/wyx"
  		+ "?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
  		
  public static String user = "root";	//mysql配置时的用户名
  public static String password = "wyx40223";	//mysql配置时的用户密码
  
  //连接数据库
  public static Connection getCon () {
	  //声明Connection对象
      Connection con = null;
      
      try {
          
      	Class.forName("com.mysql.jdbc.Driver");//加载驱动
      	
          con = DriverManager.getConnection(url, user, password);
      } catch (Exception e) {
          e.printStackTrace();
      }
      
      return con;
  }
  
  //关闭连接
  public static void close (ResultSet rs, Statement state, Connection con) {
      if (rs != null) {
          try {
              rs.close();
          } catch (SQLException e) {
              e.printStackTrace();
          }
      }
      
      if (state != null) {
          try {
              state.close();
          } catch (SQLException e) {
              e.printStackTrace();
          }
      }
      
      if (con != null) {
          try {
              con.close();
          } catch (SQLException e) {
              e.printStackTrace();
          }
      }
  }
}
