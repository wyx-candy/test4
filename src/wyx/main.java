package wyx;

import java.sql.SQLException;
import java.util.Scanner;

public class main {
	
	static Scanner input=new Scanner(System.in);
	
	public static void main(String[] args) throws SQLException{
		
		int op;	
	
		manage ope=new manage();	//创建操作类对象
		   
		do{
			
			System.out.println("*****************************************************************************");
			System.out.println("\n===========================欢迎进入西北师范大学学生疫情填报系统===========================");
			System.out.println("\n*****************************************************************************");
			System.out.println("\n 1.查询全部 疫情信息");
			System.out.println(" 2.查询个人疫情信息");
			System.out.println(" 3.查询一周疫情信息");
			System.out.println(" 4.退出");
			//System.out.println("*****************************************************************************");
			System.out.println("\n请选择（1-4）");
			
	
			op=input.nextInt(); 
			
			if(op==1)	//查询全部疫情信息
				ope.queryall();
			if(op==2)	//查询个人疫情信息
			{
				String date;
				int id;
				System.out.print("请输入id；");
				id=input.nextInt(); 
				System.out.print("请输入日期:");
				date = input.next(); 
				
				ope.query(id,date);
			}
				
		}while(op!=4);
		   
	}

	

}

