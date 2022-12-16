package masai.project.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.mysql.cj.protocol.Resultset;

import masai.project.Bean.Accountant;
import masai.project.Bean.Customer;
import masai.project.Exception.CustomerException;
import masai.project.utility.DBUtil;

public class daoImpl implements dao{

	boolean flag = false;
	int c=0;
	int actnum=0;
	
	
	public boolean isFlag() {
		return flag;
	}

	public void setFlag(boolean flag) {
		this.flag = flag;
	}

	public int getC() {
		return c;
	}

	public void setC(int c) {
		this.c = c;
	}

	public int getActnum() {
		return actnum;
	}

	public void setActnum(int actnum) {
		this.actnum = actnum;
	}

	@Override
	public void registerCustomer(int cusId, String name, String cusEmail, int pass, int bal) {
		
		if(flag) {
			Connection conn = DBUtil.provideConnection();
			
			try {
				PreparedStatement ps = conn.prepareStatement("insert into customer values(?,?,?,?,?)");
				
				ps.setString(1, name);
				ps.setString(2, cusEmail);
				ps.setInt(3, pass);
				ps.setInt(4, bal);
				ps.setInt(5, cusId);
				
				int x = ps.executeUpdate();
				System.out.println(x+" added successfully.");
				
			} catch (SQLException e) {
				// TODO: handle exception
			}
		}
		else {
			System.out.println("Please First Login.");
		}
		
	}

	@Override
	public void loginCustomer(String emailid, int password) {
		c++;
		
		Connection conn = DBUtil.provideConnection();
		
		try {
			PreparedStatement ps = conn.prepareStatement("select * from customer");
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				String email = rs.getString("email");
				int pass = rs.getInt("pass");
				
				if(emailid.equalsIgnoreCase(email) && password==pass) {
					flag = true;
					this.actnum = rs.getInt("actNo");
					System.out.println("Login successfull from Customer id ");
					return;
				}
			}
			
			if(this.c==0)
				System.out.println("Invalid Customer details.");
			
		} catch (SQLException e) {
			e.getMessage();
		}
	}

	public void setMoneyTodata(int actNo, int money) {
		
		Connection conn = DBUtil.provideConnection();
		
		try {
			PreparedStatement ps = conn.prepareStatement("insert into data values(?,?)");
			ps.setInt(1, actNo);
			ps.setInt(2, money);
			int x = ps.executeUpdate();
			
			if(x>0) {
				System.out.println("Transaction Successfull.");
			}
			
		} catch (SQLException e) {
			// TODO: handle exception
		}
		
	}
	@Override
	public void withdrwalAmount(int actNo, int money) {
		
		Connection conn = DBUtil.provideConnection();
		
		try {
			PreparedStatement ps1 = conn.prepareStatement("select * from customer where actNo=?");
			ps1.setInt(1, actNo);
			
			ResultSet rs = ps1.executeQuery();
			
			int rupee = 0;
			
			while(rs.next()) {
				rupee = rs.getInt("bal");
			}
			
			if(rupee<money) {
				System.out.println("Insufficient Balance.");
				return;
			}
			
			int newmoney = rupee-money;
			
			PreparedStatement ps2 = conn.prepareStatement("update customer set bal=? where ActNo=?");
			ps2.setInt(1, newmoney);
			ps2.setInt(2, actNo);
			
			int x= ps2.executeUpdate();
			
			if(x>0) {
				setMoneyTodata(actNo, newmoney);
			}
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			System.out.println("Not updated successfully.");
			System.out.println("Try Again!");
		}
		
	}

	@Override
	public void depositAmount(int actNo, int money) {
		
		Connection conn = DBUtil.provideConnection();
		
		try {

			PreparedStatement ps1 = conn.prepareStatement("select * from customer where actNo=?");
			
			ps1.setInt(1, actNo);
			
			ResultSet rs = ps1.executeQuery();
			
			int rupee = 0;
			
			while(rs.next()) {
				rupee = rs.getInt("bal");
			}
			
			int newmoney = rupee-money;
			
			PreparedStatement ps2 = conn.prepareStatement("update customer set bal=? where ActNo=?");
			
			ps2.setInt(1, newmoney);
			ps2.setInt(2, actNo);
			
			int x= ps2.executeUpdate();
			
			if(x>0) {
				setMoneyTodata(actNo, newmoney);
			}
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			System.out.println("Not updated successfully.");
			System.out.println("Try Again!");
		}
		
	}

	@Override
	public void showTransaction(int actn) {
		
		Connection conn = DBUtil.provideConnection();
		
		try {
			
			PreparedStatement ps = conn.prepareStatement("select * from data where custAct=?");
			ps.setInt(1, actn);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				System.out.println("Transaction History-->");
				System.out.println("Account Number: "+rs.getInt("custAct"));
				System.out.println("Transaction Amount: "+rs.getInt("balance"));
				
			}
			
			
		} catch (SQLException e) {
			System.out.println("No transaction found!");
		}
		
	}

}
