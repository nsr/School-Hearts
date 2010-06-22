/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package hearts.server;

import hearts.defs.actions.AAction;
import hearts.defs.actions.IActionListener;
import hearts.defs.actions.IActionNotifier;
import hearts.defs.protocol.IMaintenaceListener;
import hearts.defs.protocol.IMaintenance;
import hearts.defs.protocol.IUserSocket;
import hearts.defs.state.GameStateException;
import hearts.maintenance.CreateTableMaintenance;
import hearts.maintenance.JoinTableMaintenance;
import hearts.maintenance.answers.CreateTableAnswer;
import hearts.maintenance.answers.JoinTableAnswer;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author orbit
 */
public class Lobby implements IMaintenaceListener{

    private HashMap<String, StateGuard> tables = new HashMap<String, StateGuard>();
    private Server server;

    public Lobby(Server server) {
        this.server = server;
    }

    /**
     * Tworzy stół.
     * @param name nazwa stołu
     * @return czy się udało utworzyć. false - jeżeli stół o takiej nazwie już istniał
     */
    protected boolean createTable(String name) {
        if(tables.containsKey(name)) {
            return false;
        } else {           
            tables.put(name, new StateGuard(name, server));
            return true;
        }
    }

    /**
     * Dodaje użytkownika do stołu.
     * @param table nazwa stołu
     * @param user Socket użytkownika
     * @return Numer przy stole. Jeżeli stół jest pełny null.
     */
    protected Integer addUserToTable(String table, IUserSocket user) {
        try {
            return tables.get(table).addUser(user);
        } catch (GameStateException ex) {
            return null;
        }
    }

    public void maintenanceReceived(IMaintenance maintenance) {
        if ( maintenance instanceof JoinTableMaintenance ) {
            if (maintenance instanceof CreateTableMaintenance) {
                CreateTableMaintenance m = (CreateTableMaintenance)maintenance;
                CreateTableAnswer ans = new CreateTableAnswer(m.getTableName(), createTable(m.getTableName()));
                m.getUserSocket().actionReceived(ans); //wysłanie odpowiedzi do klienta tworzącego stół
            } else {
                JoinTableMaintenance m = (JoinTableMaintenance)maintenance;
                String tableName = m.getTableName();
                Integer place = addUserToTable(tableName, m.getUserSocket());
                boolean success = (place!=null)?true:false;
                JoinTableAnswer ans = new JoinTableAnswer(tableName, success, place);
                m.getUserSocket().actionReceived(ans);
            }
        }
    }

    /**
     * Wymusza na każdym stole, żeby wysłał do wszystkich informacje o sobie.
     */
    public void broadcastAllTables() {
        for(StateGuard table: tables.values()) {
            table.notifyAboutTableChange();
        }
    }

}
