/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package hearts.client.hui.details;

import javax.swing.table.DefaultTableModel;

/**
 *
 * @author szymon
 */
public class PointsTableModel extends DefaultTableModel{

    public PointsTableModel() {
        super(new String[4], 0);
    }
    @Override
    public boolean isCellEditable(int row, int column) {
        return false;
    }

    public void setUserName(int id, String name) {

    }

}