package com.org.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.org.dto.User;

public class UserDao {
 public void saveUser(User user) {
	 
	 try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/user_mgmt","root","root");
			PreparedStatement pst=	con.prepareStatement("insert into user(name,age,email,password,mobile) values(?,?,?,?,?)");
		
			pst.setString(1, user.getName());
			pst.setInt(2, user.getAge());
			pst.setString(3, user.getEmail());
			pst.setString(4, user.getPassword());
			pst.setLong(5, user.getMobile());
		
			pst.executeUpdate();

			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
 }
public User fetchUserByEmailAndPassword(String email,String password) {
	try
	{
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/user_mgmt","root","root");
		PreparedStatement pst=	con.prepareStatement("select * from user where email=? and password=?");
	
		pst.setString(1,email);
		pst.setString(2,password);
	
	   ResultSet rst=pst.executeQuery();
	   
	   if(rst.next()) {
		   User user=new User();
           String name=rst.getString("name");
           int age=rst.getInt("age");
           String em=rst.getString("email");
           String pwd=rst.getString("password");
           long mobile =rst.getLong("mobile");
           
           user.setName(name);
           user.setAge(age);
           user.setEmail(email);
           user.setPassword(password);
           user.setMobile(mobile);
           
           return user;
	   } 
           
		con.close();
	} catch (Exception e) {
		e.printStackTrace();
	}
	return null;
}
public User fetchUserById(int id) {
	try
	{
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/user_mgmt","root","root");
		PreparedStatement pst=	con.prepareStatement("select * from user where id=?");
	
		pst.setInt(1,id);
	
	
	   ResultSet rst=pst.executeQuery();
	   
	   if(rst.next()) {
		   User user=new User();
		   
		   int Id=rst.getInt("id");
           String name=rst.getString("name");
           int age=rst.getInt("age");
           String email=rst.getString("email");
           String pwd=rst.getString("password");
           long mobile =rst.getLong("mobile");
           
           user.setId(id);
           user.setName(name);
           user.setAge(age);
           user.setEmail(email);
           user.setPassword(pwd);
           user.setMobile(mobile);
           
           return user;
	   } 
           
		con.close();
	} catch (Exception e) {
		e.printStackTrace();
	}
	return null;
}
public List<User> fetchAllUsers(){
	List<User> list=new ArrayList<>();
	try
	{
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/user_mgmt","root","root");
		PreparedStatement pst=	con.prepareStatement("select * from user ");
	
	   ResultSet rst=pst.executeQuery();
	   
	   while(rst.next()) {
		   User user=new User();
           String name=rst.getString("name");
           int age=rst.getInt("age");
           String email=rst.getString("email");
           String pwd=rst.getString("password");
           long mobile =rst.getLong("mobile");
           int id=rst.getInt("id");
           
           
           user.setId(id);
           user.setName(name);
           user.setAge(age);
           user.setEmail(email);
           user.setPassword(pwd);
           user.setMobile(mobile);
           
           list.add(user);
	   } 
           
		con.close();
	} catch (Exception e) {
		e.printStackTrace();
	}
return list;
}
	public void updateUser(User user) {
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/user_mgmt","root","root");
			PreparedStatement pst=	con.prepareStatement("update user set name=?,age=?,mobile=?,email=?");
		
			pst.setString(1,user.getName());
		    pst.setInt(2, user.getAge());
		    pst.setLong(3, user.getMobile());
		    pst.setString(4, user.getEmail());
		
		   	           
	
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	}

 

