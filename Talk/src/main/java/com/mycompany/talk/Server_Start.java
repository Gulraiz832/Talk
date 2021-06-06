package com.mycompany.talk;


import java.util.Scanner;
import javax.websocket.DeploymentException;
import org.glassfish.tyrus.server.Server;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author 
 */
public class Server_Start {
    public static void main(String [] abs) throws DeploymentException{
    Server se=new Server("localhost", 4832, "/ws",null, ServerE.class); 
    
   // Server server=new Server("localhost",4832,"/ws",ServerE.class);
  try{
    se.start();
    System.out.println("press f to stop");
    new Scanner(System.in).nextLine();
  }catch(Exception e){
      
  }
  finally{
      se.stop();
      System.out.println("Server Has stopped");
  }
    }
}
