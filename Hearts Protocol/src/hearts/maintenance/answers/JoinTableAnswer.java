/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hearts.maintenance.answers;

import hearts.defs.state.GUIStateException;
import hearts.defs.state.IGUIGameTable;
import hearts.defs.state.IGUIPanel.Panel;
import hearts.defs.state.IGUIState;
import javax.swing.JOptionPane;

/**
 * Odpowiedź na dołączenie do stołu.
 * @author Michał Charmas
 */
public class JoinTableAnswer extends AMaintenaceAction {

    private String tableName;
    private Boolean success;
    private int place;

    /**
     * Odpowiedź na połączenie do stołu.
     * Klasa utworzona na potrzeby lobby.
     * @param tableName - nazwa stołu którego dotyczy odpowiedź
     * @param success - czy się udało
     * @param place - miejsce na które posadziło użytkownika
     */
    public JoinTableAnswer(String tableName, Boolean success, int place) {
        this.tableName = tableName;
        this.success = success;
        this.place = place;
    }

    /**
     * Ta metoda inicjalizuje stół i zmienia główny panel w GUI na panel gry.
     * @param gui
     * @throws GUIStateException
     */
    @Override
    public void perform(IGUIState gui) throws GUIStateException {
        if (success) {
            IGUIGameTable table = gui.getGameTable();
            if (table.getTableName() == null) {
                table.setTableName(tableName);
                table.setLocalUserId(place);
                gui.setPanel(Panel.GAME);
            } else {
                gui.showMessage("Błąd", JOptionPane.ERROR_MESSAGE, "Serwer chciał Cię wrzucić na stół " + tableName + " ale już grasz na innym");
            }
        } else {
            gui.showMessage("Błąd", JOptionPane.ERROR_MESSAGE, "Nie zostałeś przyjęty na stół " + tableName + ".");
        }
    }
}
