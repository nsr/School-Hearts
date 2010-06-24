/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package hearts.maintenance.answers;

import hearts.defs.state.GUIStateException;
import hearts.defs.state.IGUIState;

/**
 *
 * @author orbit
 */
public class UserListUpdated extends AMaintenaceAction{

    String[] players;

    public UserListUpdated(String[] players) {
        this.players = players;
    }

    @Override
    public void perform(IGUIState gui) throws GUIStateException {
        gui.getLobbyPanel().setPlayerList(players);
    }

}
