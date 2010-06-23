/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package hearts.server;

import hearts.defs.protocol.IMaintenaceListener;
import hearts.defs.protocol.IMaintenance;
import hearts.defs.protocol.IUserSocket;
import hearts.defs.state.GameStateException;
import hearts.maintenance.CreateTableMaintenance;
import hearts.maintenance.JoinTableMaintenance;
import hearts.maintenance.answers.CreateTableAnswer;
import hearts.maintenance.answers.JoinTableAnswer;
import hearts.maintenance.answers.TableUpdate;
import hearts.maintenance.answers.TableUpdateList;
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
        //createTable("Asdf");
        //createTable("Asdf1");
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
                boolean creationSuccess=createTable(m.getTableName());
                Integer place = addUserToTable(m.getTableName(), m.getUserSocket());
                boolean success = (place!=null)?true:false;                                
                CreateTableAnswer ans = new CreateTableAnswer(m.getTableName(), creationSuccess&&success);
                m.getUserSocket().actionReceived(ans); //wysłanie odpowiedzi do klienta tworzącego stół
                m.getUserSocket().actionReceived(tables.get(m.getTableName()).getTableUpdate());
            } else {
                JoinTableMaintenance m = (JoinTableMaintenance)maintenance;
                String tableName = m.getTableName();
                Integer place = addUserToTable(tableName, m.getUserSocket());
                boolean success = (place!=null)?true:false;
                JoinTableAnswer ans = new JoinTableAnswer(tableName, success, place);
                m.getUserSocket().actionReceived(ans);
                m.getUserSocket().actionReceived(tables.get(m.getTableName()).getTableUpdate());
            }

        } else if (maintenance instanceof ClientDisconnectedMaintenance) {
            for(StateGuard s: tables.values()) {
                if(s.hasUser(maintenance.getUserSocket())) {
                    s.notifyCloseTable();
                    tables.remove(s.getName());
                    TableUpdate up = s.getTableUpdate();
                    up.setRemoved(true);
                    server.notifyListeners(up);
                }                
            }
        }
    }

   /**
    * Zwraca liste stołów z informacjami o graczach.
    * @return j.w.
    */
    public TableUpdateList getUpdateList() {
        TableUpdateList list = new TableUpdateList();
        for(StateGuard table: tables.values()) {
            list.addUpdate(table.getTableUpdate());
        }
        return list;
    }

}
