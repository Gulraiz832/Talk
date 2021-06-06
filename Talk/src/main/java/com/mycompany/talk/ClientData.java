/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.talk;

import java.util.*;
import javax.websocket.Session;

/**
 *
 * @author gulraiz
 */
public class ClientData {
    Session sess;
     boolean singleState;
    String username;
    String recivername;
    Set<String> friends=new TreeSet<>();
    ClientData(){
    friends.add("Ali");
    friends.add("Ahmed");
    friends.add("Salman");
    friends.add("Adnan");
    friends.add("Nawaz");
    friends.add("Sharif");

    }
    
    
}
