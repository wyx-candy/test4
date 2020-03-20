package wyx;
import java.util.Date;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class manage {
   //查询全部疫情信息
  public void queryall() {
  	System.out.println("\n学号" + "\t\t" + "姓名" + "\t\t" + "学院" + "\t\t" + "是否确诊"+"\t\t"+"日期" );  
      System.out.println("**************************************************************************************"); 
      String sql = "select * from test";
      Connection con =mysqldemo.getCon();
      Statement state = null;
      ResultSet rs = null;

      try {
          state = con.createStatement();
          rs = state.executeQuery(sql);
        
          while (rs.next()) {
              int id = rs.getInt("id");
              String name = rs.getString("name");
            
              String academy = rs.getString("academy");
              String ill = rs.getString("ill");
              Date date=rs.getDate("date");
              
              System.out.println(id + "\t" + name +  "\t\t" + academy + "\t\t" + ill+ "\t\t"  + date );
              System.out.println();
          }
      } catch (SQLException e) {
          e.printStackTrace();
      } finally {
          mysqldemo.close(rs, state, con);
      }
  }
  
  //查询个人疫情信息
  public void query(int id,String date) {
      System.out.println("\n学号\t\t姓名\t\t学院\t\t是否确诊\t\t日期");
      String sql = "select * from test where id ='" + id + "' and DATE_FORMAT(date,'%Y%m%d') = "+date;
      Connection con = mysqldemo.getCon();
      Statement state = null;
      ResultSet rs = null;
      
      try {
          state = con.createStatement();
          rs = state.executeQuery(sql);
          while (rs.next()) {
              String name = rs.getString("name");
              String academy = rs.getString("academy");
              String ill = rs.getString("ill");
              
              System.out.println(id + "\t" + name +  "\t\t" + academy + "\t\t" + ill + "\t\t"  + date);
              System.out.println();
          }
      } catch (Exception e) {
          e.printStackTrace();
      } finally {
      	mysqldemo.close(rs, state, con);
      }
  }
}


