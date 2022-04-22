/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SRL.FND.common.Message;

import SRL.FND.Application.App;
import SRL.FND.common.EventFailure;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Modality;

/**
 *
 * @author M.Faisal1521
 */
public class Message {

    //pop message of information
    private static void info(String infoMessage, String titleBar) {
        // create a alert
        Alert a = new Alert(AlertType.INFORMATION);
        a.setContentText(infoMessage);
        a.setHeaderText(titleBar);
        a.initModality(Modality.APPLICATION_MODAL);
        a.initOwner(App.getDecorator().getStage());
        a.showAndWait();
        //JOptionPane.showMessageDialog(null, infoMessage, titleBar, JOptionPane.INFORMATION_MESSAGE);
    }

    //pop message of information
    public static void info(String infoMessage) {
        info(infoMessage, "System Information");
        write("System Information / " + infoMessage);
    }

    //pop message of error
    private static void error(String infoMessage, String titleBar) {
        Alert a = new Alert(AlertType.ERROR);
        a.setContentText(infoMessage);
        a.setHeaderText(titleBar);
        a.initModality(Modality.APPLICATION_MODAL);
        a.initOwner(App.getDecorator().getStage());
        a.showAndWait();
        //JOptionPane.showMessageDialog(null, infoMessage, titleBar, JOptionPane.ERROR_MESSAGE);
    }

    //pop message of error
    public static void error(String infoMessage) {
        error(infoMessage, "System Error");
        write("System Error / " + infoMessage);
    }

    //pop message of error
    public static void error(String infoMessage, boolean Faliure) throws EventFailure {
        error(infoMessage, "System Error");
        write("System Error / " + infoMessage);
        if (Faliure) {
            throw new EventFailure(infoMessage);
        }
    }

    //pop message of error
    public static void error(String infoMessage, Exception e) {
        error(infoMessage);
        String Trace = null;
        // print element of stktrace
        for (int i = 0; i < e.getStackTrace().length; i++) {

            Trace = Trace + ("\n " + e.getStackTrace()[i].toString());
        }
        write(e.getMessage());
        write(Trace);
    }

    public static void error(String infoMessage, Exception e, boolean failure) throws EventFailure {
        error(infoMessage);
        String Trace = null;
        // print element of stktrace
        for (int i = 0; i < e.getStackTrace().length; i++) {

            Trace = Trace + ("\n " + e.getStackTrace()[i].toString());
        }
        write(e.getMessage());
        write(Trace);
        if (failure) {
            throw new EventFailure(infoMessage);
        }
    }

    //pop message of warning
    private static void warning(String infoMessage, String titleBar) {
        Alert a = new Alert(AlertType.WARNING);
        a.setContentText(infoMessage);
        a.setHeaderText(titleBar);
        a.showAndWait();
        //JOptionPane.showMessageDialog(null, infoMessage, titleBar, JOptionPane.WARNING_MESSAGE);
    }

    //pop message of warning
    public static void warning(String infoMessage) {
        warning(infoMessage, "System Warning");
        write("System Warning / " + infoMessage);
    }

    //Static call for raise error
    private static void RaiseError(String p) throws EventFailure {
        throw new EventFailure(p);
    }

    //Close application after error
    public static void write(String p) {
        ConsoleLogger.write(p);
    }

    //Close application after error
    public static void write(String p, Exception e) {
        write(p);
        String Trace = null;
        // print element of stktrace
        for (int i = 0; i < e.getStackTrace().length; i++) {

            Trace = Trace + ("\n " + e.getStackTrace()[i].toString());
        }
        write(e.getMessage());
        write(Trace);
    }
}
