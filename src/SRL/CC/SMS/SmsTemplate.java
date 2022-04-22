/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SRL.CC.SMS;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.VBox;

/**
 * FXML Controller class
 *
 * @author Muhammad Sufzan
 */
public class SmsTemplate implements Initializable {

    @FXML
    private TableView<SmsModel> T1_MessageTemplateView;
    @FXML
    private TableColumn<SmsModel, String> T1_TemplateName;
    @FXML
    private TableColumn<SmsModel, String> T1_TemplateMessage;
    @FXML
    private TableColumn<SmsModel, String> T1_TemplateAttribute1;
    @FXML
    private TableColumn<SmsModel, String> T1_TemplateAttribute2;
    @FXML
    private TableColumn<SmsModel, String> T1_TemplateAttribute3;
    @FXML
    private TableColumn<SmsModel, Integer> T1_Sequence;

    @FXML
    private VBox Vbox1;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO  -- Mapping of Columns 
        T1_TemplateName.setCellValueFactory(new PropertyValueFactory<>("TemplateName"));
        T1_TemplateMessage.setCellValueFactory(new PropertyValueFactory<>("TemplateMessage"));
        T1_TemplateAttribute1.setCellValueFactory(new PropertyValueFactory<>("Attribute1"));
        T1_TemplateAttribute2.setCellValueFactory(new PropertyValueFactory<>("Attribute2"));
        T1_TemplateAttribute3.setCellValueFactory(new PropertyValueFactory<>("Attribute3"));
        T1_Sequence.setCellValueFactory(new PropertyValueFactory<>("Sequence"));

        T1_TemplateName.setCellFactory(TextFieldTableCell.forTableColumn());
        T1_TemplateName.setOnEditCommit(new EventHandler<CellEditEvent<SmsModel, String>>() {
            @Override
            public void handle(CellEditEvent<SmsModel, String> event) {
                SmsModel person = event.getRowValue();
                person.setTemplateName(event.getNewValue());
            }
        });

        T1_MessageTemplateView.setEditable(true);
    }

    @FXML
    public void addTemplate() {
        T1_MessageTemplateView.getItems().add(new SmsModel(1));
    }
}
