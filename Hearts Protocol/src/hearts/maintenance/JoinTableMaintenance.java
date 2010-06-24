/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package hearts.maintenance;

import hearts.defs.protocol.IMaintenance;
import hearts.defs.protocol.IUserSocket;

/**
 * Akcja łączenia do stołu.
 * @author Michał Charmas
 */
public class JoinTableMaintenance implements IMaintenance{

    transient private IUserSocket userSocket = null;
    private String tableName;
    int place;

    /**
     * Tworzy obiekt łączenia do stołu.
     * @param tableName - nazwa stołu do którego chcemy się połączyć
     * @param place - miejsce na które chcemy usiąść - NIE DZIAŁA i NIE BĘDZIE
     */
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
