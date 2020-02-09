package sample;

import javafx.fxml.FXML;
import sample.client.client;

import javax.swing.text.TabableView;
import java.sql.Connection;
import java.sql.SQLException;

public class Controller {

    TabableView tableview;

    ClientDoaImpl clientDoa = new ClientDoaImpl();
    MedecinDoaImpl medecinDoa = new MedecinDoaImpl();

    @FXML
    void initialize(){
        try{
           Connection con = singleCon.getConnection();
        }catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void AddClient() {
     //clientDoa.AddClient();
    }

    public void UpdateClient(){

    }

    public void  DeleteClient(){

    }

    public void ListClient(){

    }
    public void AddM(){

    }

    public void UpdateM(){

    }

    public void  DeleteM(){

    }

    public void ListM(){

    }



}
