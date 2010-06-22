/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package hearts.maintenance;

import hearts.defs.protocol.IMaintenance;
import hearts.defs.protocol.IUserSocket;

/**
 *
 * @author orbit
 */
public class JoinTableMaintenance implements IMaintenance{

    transient private IUserSocket userSocket = null;
    private String tableName;
    int place;

    public JoinTableMaintenance(String tableName, int place) {
        this.tableName = tableName;
        this.place = place;
    }


    public void setUserSocket(IUserSocket userSocket) {
        this.userSocket = userSocket;
    }

    public IUserSocket getUserSocket() {
        return this.userSocket;
    }

    public int getPlace() {
        return place;
    }

    public String getTableName() {
        return tableName;
    }

}
