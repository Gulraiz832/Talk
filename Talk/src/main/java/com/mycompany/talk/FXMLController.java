package com.mycompany.talk;


import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.sql.SQLException;
import java.util.*;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.TreeMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javax.websocket.ClientEndpoint;
import javax.websocket.DeploymentException;
import javax.websocket.EncodeException;
import javax.websocket.OnMessage;
import sun.security.util.Password;


@ClientEndpoint(encoders = Encoder.class , decoders = M_Decoder.class)
public class FXMLController implements Initializable{
    static Map<String,VBox> chatStore=new TreeMap<String,VBox>();
    @FXML
    public static Button group1;
     @FXML
    public static Button Group2;
      @FXML
    public static Button Group3;
    @FXML
    public Label l1;
    @FXML
    public VBox group;
    @FXML
    AnchorPane log;
    @FXML
    public ImageView a1;
    @FXML
    public Image a1im;
    @FXML
    public Image a2im;
    @FXML
    public Image a3im;
    @FXML
    public Button ok;
    @FXML
    public Button button6;
    @FXML
    public Button button1;
    @FXML
    public Button button2;
    @FXML
    public Button button3;
    @FXML
    public Button button4;
    @FXML
    public Button button5;
    @FXML
    public Button button7;
    @FXML
    public Button button8;
    @FXML
    public PasswordField pass;
     @FXML
    public Button b1;
    @FXML
    public Button b2;
    @FXML
    public Button b3;
    @FXML
    public Button b4;
    @FXML
    public Button b5;
    @FXML
    public Button b6;
    @FXML
    public Button b7;
    @FXML
    public Button b8;
    public List<Button> gb;
    @FXML
    public  Image a4im;
    @FXML
    public Label label;
    @FXML
    public TextField msg;
    @FXML
    public TextField user;
    
    @FXML
    public AnchorPane subparent;
    public static String uname;
     @FXML
    private  Button send;
    public static VBox Display;
     @FXML
    private  TextField name;
    private static VBox save;
    static ClientMain client;
    String previous;
    static String current;
    int flag=0,change=0;
    int recieve=0;
    DbConnectivity db;
     List<Button> button;
     Set<String>members=new TreeSet<String>();
    
   
    static{
        
             
            client=new ClientMain();
            Display=new VBox(); 
            Display.setLayoutX(6.0);
            Display.setLayoutY(43.0);
            Display.setPrefHeight(571.0);
            Display.prefWidth(180.0);
           
           
            
            
        
    }
    
    public FXMLController() {
      
    }
     
    @FXML
    public void check(ActionEvent e) throws SQLException, URISyntaxException, DeploymentException, IOException, IOException, IOException{
         db=new DbConnectivity();
         
         button=new ArrayList<>();
         gb=new ArrayList<>();
         gb.add(b1);
         gb.add(b2);
         gb.add(b3);
         gb.add(b4);
         gb.add(b5);
         gb.add(b6);
         gb.add(b7);
         gb.add(b8);
         button.add(button1);
         button.add(button2);
         button.add(button3);
         button.add(button4);
         button.add(button5);
         button.add(button6);
         button.add(button7);
         button.add(button8);
        uname=user.getText();
        try {
            client.connectClient(uname);
        } catch (IOException ex) {
            Logger.getLogger(FXMLController.class.getName()).log(Level.SEVERE, null, ex);
        }
        log.setVisible(false);
        db.getFriends(uname,client.friends);
        int j=0;
        for(String i:client.friends){
            if(button.size()>j&&button.get(j)!=null&&!i.contentEquals(uname)&&j<6)
            {
                System.out.println(uname+i);
                //if(gb.get(j)!=null)
                //gb.get(j).setText(i);
                button.get(j).setVisible(true);
                button.get(j).setText(i);
                j++;
            }
            
        }
        button.get(j).setVisible(true);
        button.get(j).setText("Global Chat");
        System.out.println(client.friends);
        
    }
     public  void changeScene(String fxml) throws IOException{
     Parent pane = FXMLLoader.load(
           getClass().getResource(fxml));
   

      MainApp.stage.getScene().setRoot(pane);
      
  
}
     
      @OnMessage
    public void onMessage(final Message message) {
       

        System.out.println(message.getFrom()+"  "+message.getContent());
       
        if(message.getContent().contentEquals("#987#")||message.getContent().contentEquals("#988#")||message.getContent().contentEquals("#989#")||message.getContent().contentEquals("#990")||message.getContent().contentEquals("*9990*")){
            Platform.runLater(new Runnable() {
    @Override
    public void run() {
        DisplayEmoji(message.getContent(),false,false);
    }
      });
        }
        else
        {
        Platform.runLater(new Runnable() {
    @Override
    public void run() {
        displayReciveMsg(message);
    }
      });
        }
    }
    
    public  void displayReciveMsg(Message mess){
        
        Label recive=new Label();
       
        recive.setText(mess.getFrom()+": "+mess.getContent());
        recive.setAlignment(Pos.CENTER_RIGHT);
      
       if(current!=null)
       chatStore.get(current).getChildren().add(recive);
         else
        System.out.println("khuch to garbar hay daya in display");
    }
    int i=0;
     @FXML
     public void setSession(ActionEvent e){
       
          Button p=(Button)e.getSource();
          send.setDisable(false);
          current=p.getText();
          VBox temp=new VBox();
         
          AnchorPane.setTopAnchor(temp,100.0);
          temp.setLayoutX(196.0);
          temp.setLayoutY(3.0);
          temp.setPrefHeight(556.0);
          temp.setPrefWidth(601.0);
          temp.setVisible(false);
          for(Map.Entry<String,VBox> entry:chatStore.entrySet()){
              entry.getValue().setVisible(false);
          }
          if(chatStore!=null && chatStore.get(current)!=null)
          {
              chatStore.get(current).setVisible(true);
          }
          else
          {
              temp.setVisible(true);
              chatStore.put(current, temp);
              subparent.getChildren().add(temp);
          }
          client.singleState=true;
         client.recivername=p.getText();
         client.m.setTo(client.recivername);
        

      
    }

     @FXML
      public void sendmsg(ActionEvent e) throws IOException, EncodeException{
        
        client.m.setFrom(uname);
          client.m.setContent(msg.getText());
        // System.out.println(client.recivername);
        //System.out.println(client.m.getContent());
        msg.setText("");
        Label messag=new Label();
        messag.setAlignment(Pos.CENTER_RIGHT);
        messag.setText(client.m.getContent());
        messag.setTranslateX(540);
        if(current!=null)
       chatStore.get(current).getChildren().add(messag);
         else
            System.out.println("khuch to garbar hay daya");
       
        
        client.sendmessagetest();
         
        
         
         
     }
     
     public  void changeScene1(String fxml) throws IOException{
    Parent root = FXMLLoader.load(getClass().getResource("/fxml/chatScreen.fxml"));
        
        Scene scene = new Scene(root);
        scene.getStylesheets().add("/styles/Styles.css");
        
        MainApp.stage.setTitle("JavaFX and Maven");
        MainApp.stage.setScene(scene);
        MainApp.stage.show();
     }
      
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       
    }    
    @FXML
    public void sendEmoji(MouseEvent event) throws IOException, EncodeException{
        client.m.setContent("#987#");
        DisplayEmoji("#987#", true, false);
        client.sendmessagetest();
        }
     @FXML
    public void sendEmoji1(MouseEvent event) throws IOException, EncodeException{
        client.m.setContent("#988#");
        DisplayEmoji("#988#", true, false);
        client.sendmessagetest();
        }
     @FXML
    public void sendEmoji2(MouseEvent event) throws IOException, EncodeException{
        client.m.setContent("#989#");
        DisplayEmoji("#989#", true, false);
        client.sendmessagetest();
        
        }
     @FXML
    public void sendEmoji3(MouseEvent event) throws IOException, EncodeException{
        client.m.setContent("#990#");
         DisplayEmoji("#990#", true, false);

        client.sendmessagetest();
        }
    public void DisplayEmoji(String m,boolean x,boolean y){
        String url=null;
        ImageView n=null;
        Image mp;
        System.out.println("may agay hay");
        if(m.contentEquals("#987#")){
            System.out.println("may idhr bhi agay hay");
            mp=new Image("/fxml/a1.png");
          n=new ImageView(mp);
        }
         if(m.contentEquals("#988#")){
              mp=new Image("/fxml/b.png");
           n=new ImageView(mp);
        }
          if(m.contentEquals("#989#")){
             mp=new Image("/fxml/c.png");
            n=new ImageView(mp);
            System.out.println("may idhr bhi agay hay");
        }
           if(m.contentEquals("#990#")){
                mp=new Image("/fxml/d.png");
               
            n=new ImageView(mp);
        }
           
        
        
           
         
          
          
             
          
            
            
             if(x){
                n.setTranslateX(540);
                
               
            }
             n.setFitHeight(31.0);
                n.setFitWidth(38.0);
            if(current!=null){
             chatStore.get(current).getChildren().add(n);
            
            }

            
           
            
            
           
           
    }
    @FXML
    public void add(ActionEvent e) throws IOException, EncodeException{
        Button temp=(Button)e.getSource();
        temp.setDisable(true);
        members.add(temp.getText());
        client.m.setContent("*9990*");
        client.m.setTo(temp.getText());
        client.sendmessagetest();
    }
    @FXML
    public void addinList(ActionEvent e){
        ok.setVisible(false);
        int i=0;
        while(i<client.friends.size()&&i<7&&gb.get(i)!=null){
            gb.get(i).setVisible(false);
            i++;
        }
        if(!group1.isVisible()){
            group1.setVisible(true);
            
        }
        else if(!Group2.isVisible()){
            Group2.setVisible(true);
        }
        else if(!Group3.isVisible()){
            Group3.setVisible(true);
        }
            
    }
    @FXML
    public void setGroupSession(ActionEvent e){
        setSession(e);
        client.m.recp=(List)members;
        client.m.setTo(null);
    }
     @FXML
    public void createGroup(ActionEvent e){
        group.setVisible(true);
        ok.setVisible(true);
        int i=0;
        while(i<client.friends.size()&&i<7&&gb.get(i)!=null){
            gb.get(i).setVisible(true);
            i++;
        }
    }
    
    
    
}
