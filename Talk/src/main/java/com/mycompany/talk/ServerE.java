package com.mycompany.talk;


import static com.mycompany.talk.FXMLController.client;
import java.io.IOException;
import java.util.*;
import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author 
 */
@ServerEndpoint(value="/chat/{username}",encoders = Encoder.class, decoders = M_Decoder.class )
public class ServerE {
   
    
    Session session;
    
    //change
    static List<Session> store=new ArrayList<>();
    static Map<String, Session> single=new HashMap<>();
     static List<ClientData> clients=new ArrayList<>();
     
    Map<Session, String> user=new HashMap<>();
    @OnOpen
    public void connection(Session sess,@PathParam("username") String user_name) throws IOException, EncodeException{
       System.out.println("Connection Established !!!");
        session=sess;
        store.add(sess);
        ClientData m=new ClientData();
        System.out.println(user_name);
        m.username=user_name;
        m.sess=sess;
        clients.add(m);
        single.put(user_name, sess);
        System.out.println(clients.size());
        user.put(sess,user_name);
        Message message=new Message();
        message.setFrom(user_name);
        message.setContent("ConnectionSuccessfull432");
        send_message(message);
        
       
        
    }
    public static void changeValue(String user,String reciver){
        for(ClientData m:ServerE.clients){
             if(m.username==user){
                 System.out.println(m.username);
                 m.recivername=reciver;
                 m.singleState=true;
             }
             System.out.println(m.username);
         }
        
    }
    
    @OnMessage
    public void onmessage(Session sess,Message message) throws IOException, EncodeException{
        message.setFrom(user.get(sess));
        if(message.getTo().contentEquals("Global Chat")){
            send_message(message);
        }
        else
            single.get(message.getTo()).getBasicRemote().sendObject(message);
       /* if(message.getTo()==null){
            for(String s:message.recp){
                if(single.get(s)!=null)
                single.get(s).getBasicRemote().sendObject(message);
            }
        }
        else if(single.get(message.getTo())!=null){
       
           single.get(message.getTo()).getBasicRemote().sendObject(message);
        }*/
                
          
        
    }
    public  void send_message(Message message) throws IOException, EncodeException{
        for(Session s:store){
          if(s.getId()!= session.getId())
            s.getBasicRemote().sendObject(message);
        }
    }
    public void sendSingleMessage(Message message,String name) throws IOException, EncodeException{
        for(ClientData s:clients){
            if(s.username.equalsIgnoreCase(name)){
                s.sess.getBasicRemote().sendObject(message);
                
            }
        }
    }
    @OnClose
    public void endConnection(Session sess){
        store.remove(sess);
    }
    
    
    
    
}
