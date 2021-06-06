/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.talk;
import java.sql.*;  
import java.util.List;
import java.util.Set;
/**
 *
 * @author 
 */
public class DbConnectivity {
   Statement stmt;
public DbConnectivity(){  
            try{  
                Class.forName("com.mysql.jdbc.Driver");  
            Connection con=DriverManager.getConnection(  
            "jdbc:mysql://localhost:3306/chatApp","root","MyNewPass");  

            stmt=con.createStatement();  
            }catch(Exception e){ System.out.println(e);}  
}
        boolean checkPass(String username,String pass) throws SQLException{
            String query="select password from Login where username= "+"\""+username+"\"";
            ResultSet rs=stmt.executeQuery(query); 
            if(rs.getString(1)==pass)
                return true;
            return false;

        }
        void getFriends(String username,Set<String>p) throws SQLException{
        String query="select userfriend"+" from Friends where username= "+"\""+username+"\"";
        ResultSet rs=stmt.executeQuery(query);  
        while(rs.next())  
              p.add(rs.getString(1));  
        }
}

