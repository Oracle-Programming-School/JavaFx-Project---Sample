/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SRL.FND.common.calendar;

import SRL.FND.common.Constant;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.format.ResolverStyle;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author M.Faisal1521
 */
public class SysDate {

    //Get Current Date in Date format
    public static Date getCurrentDate() {
        return new java.util.Date();
    }

    //Get Date in String Format
    public static String getCurrentDateStr() {
        String pattern = Constant.getDateFormat();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        return (String) simpleDateFormat.format(new Date());
    }

    /// Convert String to Date format
    public static Date StringToDate(String pDate)
            throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat(Constant.getDateFormat());
        return sdf.parse(pDate);
    }

    //Find days between two dates
    public static float DaysBetween(String pStartDate, String pEndDate) {
        try {
            //first Date
            Date startDate = StringToDate(pStartDate);
            //Second Date
            Date endDate = StringToDate(pEndDate);
            //check Duration  between dates 
            long difference_In_Time = endDate.getTime() - startDate.getTime();
            return (float) (difference_In_Time
                    / (1000 * 60 * 60 * 24));
        } catch (ParseException ex) {
            Logger.getLogger(SysDate.class.getName()).log(Level.SEVERE, null, ex);
            return -999;
        }
    }

    public static float DaysBetween(String pDate) {
        return DaysBetween(getCurrentDateStr(), pDate);
    }
}
