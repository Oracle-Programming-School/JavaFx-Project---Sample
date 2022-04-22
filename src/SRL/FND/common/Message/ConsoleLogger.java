/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SRL.FND.common.Message;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import SRL.FND.common.Constant;
import SRL.FND.common.calendar.SysDate;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

/**
 *
 * @author M.Faisal1521
 */
public class ConsoleLogger {

    private static int sequence;
    private static Logger allLog = null;
    private static boolean ConsoleEnabled = false;

    /**
     * @return the ConsoleEnabled
     */
    public static boolean isConsoleEnabled() {
        return ConsoleEnabled;
    }

    /**
     * @param aConsoleEnabled the ConsoleEnabled to set
     */
    public static void setConsoleEnabled(boolean aConsoleEnabled) throws IOException {
        StartConsoleLogger();
        write("Application Start At : " + SysDate.getCurrentDateStr());
    }

    private static void StartConsoleLogger() throws IOException {
        //ConsoleObject
        //get File with CurrentDateTime
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd_MM_yyyy");
        String logfileName = dtf.format(LocalDateTime.now());
            //All-Console 
            allLog = (Logger) Logger.getLogger(Constant.getLoggerName());
            FileHandler fh = new FileHandler(Constant.getLogDir() + logfileName + ".log");
        allLog.addHandler(fh);
        fh.setFormatter(new SimpleFormatter());
        //Enable Console
        ConsoleEnabled = true;
    }

    //write application Log
    public static void write(String pText) {
        if (isConsoleEnabled()) {
            String logText = (sequence++) + ") " + pText + "\n";
            allLog.log(Level.SEVERE, logText);
        }
    }

}
