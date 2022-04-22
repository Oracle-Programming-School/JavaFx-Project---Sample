/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SRL.FND.common.DB;
import SRL.FND.common.Message.Message;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author M.Faisal1521
 */
public class Databases {

    public Databases() {
    }


    public int getRowCount(ResultSet resultSet) {
        if (resultSet == null) {
            return 0;
        }
        try {
            resultSet.last();
            return resultSet.getRow();
        } catch (SQLException exp) {
            Message.write(" RowCount ", exp);
        }

        return 0;
    }

}

