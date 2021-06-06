package com.mycompany.talk;


import com.google.gson.Gson;
import java.io.StringReader;
import java.util.Date;
import javax.json.Json;
import javax.json.JsonObject;
import javax.websocket.DecodeException;
import javax.websocket.EndpointConfig;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import javax.websocket.Decoder;

/**
 *
 * @author gulraiz
 */
public class M_Decoder implements Decoder.Text<Message>{
      static Gson gson=new Gson();
    @Override
    public void init(EndpointConfig ec) {
        ////throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void destroy() {
      //  throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Message decode(final String string) throws DecodeException {
        
       
       /* Message message = new Message();
        
       
        message.setContent(string);
       
       
        
        return message;*/
    return gson.fromJson(string, Message.class);
          }

    @Override
    public boolean willDecode(String string) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        return true;
    }
    
}
