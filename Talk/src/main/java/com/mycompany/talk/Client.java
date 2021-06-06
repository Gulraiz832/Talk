package com.mycompany.talk;


import java.text.SimpleDateFormat;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javax.websocket.ClientEndpoint;
import javax.websocket.OnMessage;
import javax.websocket.Session;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author gulraiz
 * encoders = Encoder.class, decoders = M_Decoder.class
 */

//@ClientEndpoint(encoders = Encoder.class, decoders = M_Decoder.class)
public class Client {
     //private SimpleDateFormat simpleDateFormat = new SimpleDateFormat();
    @FXML
    private TextField msg=new TextField();
    boolean singleState;
    Session sessionId;

    @OnMessage
    public void onMessage(Message message) {
       
//        msg.setText("war gaye bhai");
     //    msg.setText(message.getContent());
        System.out.println("        "+message.getContent());
    }
    
    
    
    public void connectToOneClient(){
        
    }
}
