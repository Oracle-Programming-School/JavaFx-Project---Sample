/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SRL.FND.common;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author M.Faisal1521
 */
public class Constant {

    private static String ApplicationName = null;
    private static String ApplicationVersion = null;
    private static int ApplicationID = 0;
    private static String ApplicationExpiry = null;
    private static String Allowed_Mac = null;
    private static String LoggerName = null;
    private static String ApplicationDir = null;
    private static String LogDir = new String("log\\");
    private static String DataDir = new String("Data\\");
    private static String ReportDir = new String("Reports\\");
    private static String DateFormat = new String("dd-MM-yyyy");


    /**
     * @return the DataDir
     */
    public static String getDataDir() {
        return getApplicationDir() + DataDir;
    }

    /**
     * @return the ApplicationDir
     */
    public static String getApplicationDir() {

        return System.getenv("OraDigitals") + "\\" + ApplicationDir;
    }

    /**
     * @return the DateFormat
     */
    public static String getDateFormat() {
        return DateFormat;
    }

    /**
     * @return the LogDir
     */
    public static String getLogDir() {
        return getApplicationDir() + LogDir;
    }

    /**
     * @return the LoggerName
     */
    public static String getLoggerName() {
        return LoggerName;
    }

    /**
     * @param aDateFormat the DateFormat to set
     */
    public static void setDateFormat(String aDateFormat) {
        DateFormat = aDateFormat;
    }

    private static HashMap<String, Object> listOfObjects = new HashMap<String, Object>();

    // get form name from hashmap
    public static Object getParameters(String p) {
        return getListOfObjects().get(p);
    }

    // get form name from hashmap
    public static void setParameters(String p, Object k) {
        getListOfObjects().put(p, k);
    }

    public static void getPath() {
        Map<String, String> env = System.getenv();
        for (String envName : env.keySet()) {
            System.out.format("%s=%s%n",
                    envName,
                    env.get(envName));
        }
    }

    /**
     * @param aLoggerName the LoggerName to set
     */
    public static void setLoggerName(String aLoggerName) {
        LoggerName = aLoggerName;
    }

    /**
     * @param aApplicationDir the ApplicationDir to set
     */
    public static void setApplicationDir(String aApplicationDir) {
        ApplicationDir = aApplicationDir;
    }

    /**
     * @param aLogDir the LogDir to set
     */
    public static void setLogDir(String aLogDir) {
        LogDir = aLogDir;
    }

    /**
     * @param aDataDir the DataDir to set
     */
    public static void setDataDir(String aDataDir) {
        DataDir = aDataDir;
    }

    /**
     * @return the listOfObjects
     */
    public static HashMap<String, Object> getListOfObjects() {
        return listOfObjects;
    }

    /**
     * @param aListOfObjects the listOfObjects to set
     */
    public static void setListOfObjects(HashMap<String, Object> aListOfObjects) {
        listOfObjects = aListOfObjects;
    }

    /**
     * @return the ApplicationName
     */
    public static String getApplicationName() {
        return ApplicationName;
    }

    /**
     * @param aApplicationName the ApplicationName to set
     */
    public static void setApplicationName(String aApplicationName) {
        ApplicationName = aApplicationName;
    }

    /**
     * @return the ApplicationVersion
     */
    public static String getApplicationVersion() {
        return ApplicationVersion;
    }

    /**
     * @param aApplicationVersion the ApplicationVersion to set
     */
    public static void setApplicationVersion(String aApplicationVersion) {
        ApplicationVersion = aApplicationVersion;
    }

    /**
     * @return the ReportDir
     */
    public static String getReportDir() {
        return getApplicationDir() + ReportDir;
    }

    /**
     * @param aReportDir the ReportDir to set
     */
    public static void setReportDir(String aReportDir) {
        ReportDir = aReportDir;
    }

    /**
     * @return the XmlDbName
     */
    public static String getXmlDbName() {
        return getDataDir() + ApplicationName + ".xml";
    }


    /**
     * @return the SQLiteDbName
     */
    public static String getSQLiteDbName() {
        return getDataDir() + ApplicationName + ".db";
    }

    /**
     * @return the ApplicationID
     */
    public static int getApplicationID() {
        return ApplicationID;
    }

    /**
     * @return the ApplicationExpiry
     */
    public static String getApplicationExpiry() {
        return ApplicationExpiry;
    }

    /**
     * @return the Allowed_Mac
     */
    public static String getAllowed_Mac() {
        return Allowed_Mac;
    }

    /**
     * @param aApplicationID the ApplicationID to set
     */
    public static void setApplicationID(int aApplicationID) {
        ApplicationID = aApplicationID;
    }

    /**
     * @param aApplicationExpiry the ApplicationExpiry to set
     */
    public static void setApplicationExpiry(String aApplicationExpiry) {
        ApplicationExpiry = aApplicationExpiry;
    }

    /**
     * @param aAllowed_Mac the Allowed_Mac to set
     */
    public static void setAllowed_Mac(String aAllowed_Mac) {
        Allowed_Mac = aAllowed_Mac;
    }
}
