/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package hearts.maintenance.answers;

import hearts.defs.state.GUIStateException;
import hearts.defs.state.IGUIState;

/**
 * Klasa zawierająca listę użytkowników zalogowanych na serwerze.
 * @author Michał Charmas
 */
public class UserListUpdated extends AMaintenaceAction{

    String[] players;

    public UserListUpdated(String[] players) {
        this.players = players;
    }

    /**
     * Uaktualnia listę użytkowników w GUI.
     * @param gui
     * @throws GUIStateException
     */
    @Override
    public void perform(IGUIState gui) throws GUIStateException {
        gui.getLobbyPanel().setPlayerList(players);
    }

}
