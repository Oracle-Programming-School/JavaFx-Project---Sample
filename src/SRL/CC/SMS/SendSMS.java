/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SRL.CC.SMS;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;

/**
 * FXML Controller class
 *
 * @author M.Faisal1521
 */
public class SendSMS implements Initializable {

    @FXML
    ListView listV = new ListView();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        listV.getItems().add("111");
        listV.getItems().add("111");
        listV.getItems().add("111");
        listV.getItems().add("111");
    }

}
