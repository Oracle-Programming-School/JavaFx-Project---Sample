/*
 * Copyright (C) Gleidson Neves da Silveira
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package SRL.FND.Application.login;

import animatefx.animation.*;
import SRL.FND.Application.App;
import SRL.FND.Application.global.plugin.ViewManager;
import SRL.FND.Application.global.util.Mask;
import com.gn.GNAvatarView;
import javafx.animation.RotateTransition;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.util.Duration;

import java.io.*;
import java.net.URL;
import java.util.ResourceBundle;
import javax.annotation.processing.SupportedSourceVersion;
import javax.lang.model.SourceVersion;

/**
 * @author Gleidson Neves da Silveira | gleidisonmt@gmail.com
 * Create on  22/11/2018
 */
public class Account implements Initializable {

    @FXML private GNAvatarView avatar;

    @FXML private HBox box_fullname;
    @FXML private HBox box_username;
    @FXML private HBox box_email;
    @FXML private HBox box_password;

    @FXML private TextField fullname;
    @FXML private TextField username;
    @FXML private TextField email;
    @FXML private TextField password;

    @FXML private Label lbl_password;
    @FXML private Label lbl_fullname;
    @FXML private Label lbl_email;
    @FXML private Label lbl_username;

    @FXML private Label lbl_error;

    @FXML private Button register;

    private RotateTransition rotateTransition = new RotateTransition();

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        rotateTransition.setNode(avatar);
        rotateTransition.setByAngle(360);
        rotateTransition.setDuration(Duration.seconds(1));
        rotateTransition.setAutoReverse(true);

        addEffect(email);
        addEffect(fullname);
        addEffect(username);
        addEffect(password);

        Mask.nameField(fullname);
        Mask.noInitSpace(username);
        Mask.noSpaces(username);
        setupListeners();
    }

    @FXML
    private void register() throws Exception {
        Pulse pulse = new Pulse(register);
        pulse.setDelay(Duration.millis(20));
        pulse.play();

        if (validEmail() && validFullName() && validFullName() && validUsername() && validPassword()) {

            String user = username.getText();
            String extension = "properties";

            File directory = new File("user/");
            File file = new File("user/" + user + "." + extension);

            if (!directory.exists()) {
                directory.mkdir();
                file.createNewFile();
                setProperties();
            } else if (!file.exists()) {
                file.createNewFile();
                setProperties();
            } else {
                lbl_error.setVisible(true);
            }
        } else if (!validUsername()){
            lbl_username.setVisible(true);
        } else if (!validFullName()) {
            lbl_fullname.setVisible(true);
        } else if (!validEmail()){
            lbl_email.setVisible(true);
        } else {
            lbl_password.setVisible(true);
        }
    }

    private void setProperties() {

            App.decorator.setContent(ViewManager.getInstance().get("main"));
    }

    @FXML
    private void back(){
        App.decorator.setContent(ViewManager.getInstance().get("login"));
    }

    private void addEffect(Node node){
        node.addEventFilter(MouseEvent.MOUSE_PRESSED, event -> {
            rotateTransition.play();
            Pulse pulse = new Pulse(node.getParent());
            pulse.setDelay(Duration.millis(100));
            pulse.setSpeed(5);
            pulse.play();
            node.getParent().setStyle("-icon-color : -success; -fx-border-color : -success");
        });

        node.focusedProperty().addListener((observable, oldValue, newValue) -> {
            if(!node.isFocused())
            node.getParent().setStyle("-icon-color : -dark-gray; -fx-border-color : transparent");
            else node.getParent().setStyle("-icon-color : -success; -fx-border-color : -success");
        });
    }

    private boolean validPassword(){
        return !password.getText().isEmpty() && password.getLength() > 3 ;
    }

    private boolean validUsername(){
        return !username.getText().isEmpty() && username.getLength() > 3 ;
    }

    private boolean validFullName(){
        return !fullname.getText().isEmpty() && fullname.getLength() > 3 ;
    }

    private boolean validEmail(){
        return Mask.isEmail(email);
    }


    private void setupListeners(){
        password.focusedProperty().addListener((observable, oldValue, newValue) -> {
            if(!validPassword()){
                if(!newValue){
                    Flash swing = new Flash(box_password);
                    lbl_password.setVisible(true);
                    new SlideInLeft(lbl_password).play();
                    swing.setDelay(Duration.millis(100));
                    swing.play();
                    box_password.setStyle("-icon-color : -danger; -fx-border-color : -danger");
                } else {
                    lbl_password.setVisible(false);
                }
            } else {
                lbl_error.setVisible(false);
            }
        });

        username.focusedProperty().addListener((observable, oldValue, newValue) -> {
            if(!validUsername()){
                if(!newValue){
                    Flash swing = new Flash(box_username);
                    lbl_username.setVisible(true);
                    new SlideInLeft(lbl_username).play();
                    swing.setDelay(Duration.millis(100));
                    swing.play();
                    box_username.setStyle("-icon-color : -danger; -fx-border-color : -danger");
                } else {
                    lbl_username.setVisible(false);
                }
            } else {
                lbl_error.setVisible(false);
            }
        });

        email.focusedProperty().addListener((observable, oldValue, newValue) -> {
            if(!validEmail()){
                if(!newValue){
                    Flash swing = new Flash(box_email);
                    lbl_email.setVisible(true);
                    new SlideInLeft(lbl_email).play();
                    swing.setDelay(Duration.millis(100));
                    swing.play();
                    box_email.setStyle("-icon-color : -danger; -fx-border-color : -danger");
                } else {
                    lbl_email.setVisible(false);
                }
            }  else {
                lbl_error.setVisible(false);
            }
        });

        fullname.focusedProperty().addListener((observable, oldValue, newValue) -> {
            if(!validFullName()){
                if(!newValue){
                    Flash swing = new Flash(box_fullname);
                    lbl_fullname.setVisible(true);
                    new SlideInLeft(lbl_fullname).play();
                    swing.setDelay(Duration.millis(100));
                    swing.play();
                    box_fullname.setStyle("-icon-color : -danger; -fx-border-color : -danger");
                } else {
                    lbl_fullname.setVisible(false);
                }
            } else {
                lbl_error.setVisible(false);
            }
        });
    }

}
