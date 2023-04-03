package com.demo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class StudentMain {
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException, NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Class.forName("com.mysql.cj.jdbc.Driver");            //Driver class loaded
		//Creating connection to database
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/studentreport?autoReconnect=true&useSSL=false","root","root");
		
		while(true) {
				System.out.println("Select Any option \n1.INSERT \n2.UPDATE \n3.DELETE \n4.SELECT \n5.EXIT");
				int ch =Integer.parseInt(br.readLine());
				if(ch==1) {
					PreparedStatement ps = con.prepareStatement("insert into student (id,name,classsection,rollno,phonenum) values(?,?,?,?,?); ");
					System.out.println("Enter the required field to insert into table");
					System.out.println("Student ID");
					int id1 = Integer.parseInt(br.readLine());
					System.out.println("Student NAME");
					String name1 = br.readLine();
					System.out.println("Student CLASS-SECTION");
					String classsection1 = br.readLine();
					System.out.println("Student ROLL NUMBER");
					int rollno1 = Integer.parseInt(br.readLine());
					System.out.println("Student CONTACT NUMBER");
					long phonenum1 = Long.parseLong(br.readLine());
					ps.setInt(1, id1);
					ps.setString(2, name1);
					ps.setString(3, classsection1);
					ps.setInt(4, rollno1);
					ps.setLong(5, phonenum1);
					
					
					int res = ps.executeUpdate();
					if(res == 1) {
						System.out.println("Student DATA INSERTED");
					}
					else {
						System.out.println("DATA NOT INSERTED");
					}
				}
				else if(ch==2) {
					while(true) {
						
					
					System.out.println("Select Which value you want to update \n1.NAME \n2.CLASS_SECTION \n3.ROLL NUMBER \n4.CONTACT NUMBER \n5.EXIT");
					int ch1 = Integer.parseInt(br.readLine());
					if(ch1 == 1) {
						PreparedStatement ps = con.prepareStatement("update student set name = ? where id = ?; ");
						System.out.println("Enter the required field to update into table");
						System.out.println("Student ID");
						int id1 = Integer.parseInt(br.readLine());
						System.out.println("Student NAME");
						String name1 = br.readLine();
						
						ps.setInt(2, id1);
						ps.setString(1, name1);
					
						
						
						int res = ps.executeUpdate();
						if(res == 1) {
							System.out.println("Student DATA UPDATED");
						}
						else {
							System.out.println("DATA NOT UPDATED");
						}
					}
					else if(ch1==2) {
						PreparedStatement ps = con.prepareStatement("update student set classsection = ? where id = ?; ");
						System.out.println("Enter the required field to update into table");
						System.out.println("Student ID");
						int id1 = Integer.parseInt(br.readLine());

						System.out.println("Student CLASS-SECTION");
						String classsection1 = br.readLine();
						
						ps.setInt(2, id1);
					
						ps.setString(1, classsection1);
					
						
						
						int res = ps.executeUpdate();
						if(res == 1) {
							System.out.println("Student DATA UPDATED");
						}
						else {
							System.out.println("DATA NOT UPDATED");
						}
					}
					else if(ch1 ==3) {
						PreparedStatement ps = con.prepareStatement("update student set rollno = ? where id = ?; ");
						System.out.println("Enter the required field to update into table");
						System.out.println("Student ID");
						int id1 = Integer.parseInt(br.readLine());
						
						
						System.out.println("Student ROLL NUMBER");
						int rollno1 = Integer.parseInt(br.readLine());
						
						ps.setInt(2, id1);
					
						ps.setInt(1, rollno1);
						
						
						int res = ps.executeUpdate();
						if(res == 1) {
							System.out.println("Student DATA UPDATED");
						}
						else {
							System.out.println("DATA NOT UPDATED");
						}
					}
					else if(ch1==4) {
						PreparedStatement ps = con.prepareStatement("update student set phonenum = ? where id = ?; ");
						System.out.println("Enter the required field to update into table");
						System.out.println("Student ID");
						int id1 = Integer.parseInt(br.readLine());
					
						
						System.out.println("Student CONTACT NUMBER");
						long phonenum1 = Long.parseLong(br.readLine());
						ps.setInt(2, id1);
						
						ps.setLong(1, phonenum1);
						
						
						int res = ps.executeUpdate();
						if(res == 1) {
							System.out.println("Student DATA UPDATED");
						}
						else {
							System.out.println("DATA NOT UPDATED");
						}
					}
					else if (ch1==5) {
						break;
					}
					else {
						break;
					}
					}	
				}
				else if(ch==3) {
					while(true) {
						
					
					System.out.println("Select any option \n1.To delete table \n2. To delete a row of a table \n3.EXIT");
					int ch1 = Integer.parseInt(br.readLine());
					if(ch1==1) {
						PreparedStatement ps = con.prepareStatement("delete from student");
						int res = ps.executeUpdate();
						if(res ==1) {
							System.out.println("  Table Deleted ");
						}
						else {
							System.out.println("  Table Not Deleted ");
						}
					}
					else if(ch1==2) {
						while(true) {
							System.out.println("Select any option to delete data \n1.ID \n2.Name \3.Class section \n4.Roll Number \n5.Contact Number \n6.Exit");
							int r = Integer.parseInt(br.readLine());
							if(r==1) {
								PreparedStatement ps = con.prepareStatement("delete from student where id = ?");
								System.out.println("Enter ID");
								int id = Integer.parseInt(br.readLine());
								ps.setInt(1, id);
								int res = ps.executeUpdate();
								if(res ==1) {
									System.out.println("  Table Deleted ");
								}
								else {
									System.out.println("  Table Not Deleted ");
								}
							}
							else if(r==2) {
								PreparedStatement ps = con.prepareStatement("delete from student where name = ?");
								System.out.println("Enter NAME");
								String namex = br.readLine();
								ps.setString(1, namex);
								int res = ps.executeUpdate();
								if(res ==1) {
									System.out.println("  Table Deleted ");
								}
								else {
									System.out.println("  Table Not Deleted ");
								}
							}
							else if(r==3) {
								PreparedStatement ps = con.prepareStatement("delete from student where classsection = ?");
								System.out.println("Enter ID");
								String sec = br.readLine();
								ps.setString(1, sec);
								int res = ps.executeUpdate();
								if(res ==1) {
									System.out.println("  Table Deleted ");
								}
								else {
									System.out.println("  Table Not Deleted ");
								}
							}
							else if(r==4) {
								PreparedStatement ps = con.prepareStatement("delete from student where rollno = ?");
								System.out.println("Enter Roll Number");
								int roll = Integer.parseInt(br.readLine());
								ps.setInt(1, roll);
								int res = ps.executeUpdate();
								if(res ==1) {
									System.out.println("  Table Deleted ");
								}
								else {
									System.out.println("  Table Not Deleted ");
								}
							}
							else if(r==5) {
								PreparedStatement ps = con.prepareStatement("delete from student where phonenum = ?");
								System.out.println("Enter Phone number");
								long roll = Long.parseLong(br.readLine());
								ps.setLong(1, roll);
								int res = ps.executeUpdate();
								if(res ==1) {
									System.out.println("  Table Deleted ");
								}
								else {
									System.out.println("  Table Not Deleted ");
								}
							}
							else if(r==6) {
								break;
							}
							else {
								break;
							}
							
							
						}
					
					}
					else if(ch1==3) {
						break;
					}
					else {
						break;
					}
					
				}
				}
				else if(ch==4) {
					String sql = "select * from  student;";
					Statement ps = con.createStatement();
					//Retrieve the data using ResultSet 'Object'
					ResultSet rs = ps.executeQuery(sql);     //ResultSet is an interface that provide method to retrieve data from database 
					while(rs.next()) {
						
						String name = rs.getString("name");
						String clss = rs.getString("classsection");
						
						
						System.out.println(" "+name+" "+clss);
						}
					rs.close();
					ps.close();
					con.close();
				}
				else if(ch==5) {
					break;
				}
				else {
					System.out.println("Thanks for Using this application");
					break;
				}
		}
		
		
		
				
		
				
		
	}

}
