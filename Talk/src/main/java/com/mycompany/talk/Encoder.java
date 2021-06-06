package com.mycompany.talk;


import com.google.gson.Gson;
import javax.json.Json;
import javax.websocket.EncodeException;
import javax.websocket.EndpointConfig;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author gulraiz
 */
public class Encoder implements javax.websocket.Encoder.Text<Message>  {

    
    static Gson gson=new Gson();
    public String encode(Message message) throws EncodeException {
       
       
        return gson.toJson(message);
        
        /*return Json.createObjectBuilder()
                .add("message", message.getContent())
                .add("sender", message.getFrom())
                .add("received", "")
                .build().toString();*/
       // return msg;
        //return message.getContent();
    }

    @Override
    public void init(EndpointConfig config) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void destroy() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
