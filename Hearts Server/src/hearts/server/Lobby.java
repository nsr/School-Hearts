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
 * Klasa obsługująca lobby.
 * @author Michał Charmas
 */
public class Lobby implements IMaintenaceListener {

    /**
     * Mapa stołów po nazwach.
     */
    private final HashMap<String, StateGuard> tables = new HashMap<String, StateGuard>();
    private Server server;

    /**
     * Konstruktor.
     * @param server Referencja do serwera.
     */
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
        synchronized (tables) {
            if (tables.containsKey(name)) {
                return false;
            } else {
                tables.put(name, new StateGuard(name, server));
                return true;
            }
        }
    }

    /**
     * Dodaje użytkownika do stołu.
     * @param table nazwa stołu
     * @param user Socket użytkownika
     * @return Numer przy stole. Jeżeli stół jest pełny null.
     */
    protected Integer addUserToTable(String table, IUserSocket user) {
        synchronized (tables) {
            try {
                return tables.get(table).addUser(user);
            } catch (GameStateException ex) {
                return null;
            }
        }
    }

    /**
     * Bierze pod uwagę tylko Akcje typu:
     * - JoinTableMaintenance - stara się dołączyć użytkownika do stołu, wysyła odpowiedź czy się udało
     * - CreateTableMaintennace - stara się utworzyć stół o podanej nazwie, sadza użytkownika do danego stołu i wysyła odpowiedź czy się udało
     * - ClientDisconnectedMaintanence - rozłącza wszystkich użytkowników przy danym stole wracając ich do lobby, usuwa stół
     * @param maintenance
     */
    public void maintenanceReceived(IMaintenance maintenance) {
        if (maintenance instanceof JoinTableMaintenance) {
            if (maintenance instanceof CreateTableMaintenance) {
                CreateTableMaintenance m = (CreateTableMaintenance) maintenance;
                boolean creationSuccess = createTable(m.getTableName());
                Integer place = addUserToTable(m.getTableName(), m.getUserSocket());
                boolean success = (place != null) ? true : false;
                CreateTableAnswer ans = new CreateTableAnswer(m.getTableName(), creationSuccess && success);
                m.getUserSocket().actionReceived(ans); //wysłanie odpowiedzi do klienta tworzącego stół
                synchronized (tables) {
                    m.getUserSocket().actionReceived(tables.get(m.getTableName()).getTableUpdate());
                }
            } else {
                JoinTableMaintenance m = (JoinTableMaintenance) maintenance;
                String tableName = m.getTableName();
                Integer place = addUserToTable(tableName, m.getUserSocket());
                boolean success = (place != null) ? true : false;
                JoinTableAnswer ans = new JoinTableAnswer(tableName, success, place);
                m.getUserSocket().actionReceived(ans);
                synchronized (tables) {
                    m.getUserSocket().actionReceived(tables.get(m.getTableName()).getTableUpdate());
                }
            }

        } else if (maintenance instanceof ClientDisconnectedMaintenance) {
            synchronized (tables) {
                for (StateGuard s : tables.values()) {
                    if (s.hasUser(maintenance.getUserSocket())) {
                        s.notifyCloseTable();
                        tables.remove(s.getName());
                        TableUpdate up = s.getTableUpdate();
                        up.setRemoved(true);
                        server.notifyListeners(up);
                    }
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
        synchronized (tables) {
            for (StateGuard table : tables.values()) {
                list.addUpdate(table.getTableUpdate());
            }
        }
        return list;
    }
}
