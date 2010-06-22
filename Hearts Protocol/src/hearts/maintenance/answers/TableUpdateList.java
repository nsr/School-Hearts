/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package hearts.maintenance.answers;

import hearts.defs.state.GUIStateException;
import hearts.defs.state.IGUILobbyPanel;
import hearts.defs.state.IGUIPanel;
import hearts.defs.state.IGUIState;
import java.util.ArrayList;

/**
 *
 * @author orbit
 */
public class TableUpdateList extends AMaintenaceAction{
    
    private ArrayList<TableUpdate> updates = new ArrayList<TableUpdate>();
    
    public void addUpdate(TableUpdate update) {
        updates.add(update);
    }

    @Override
    public void perform(IGUIState gui) throws GUIStateException {
        //IGUILobbyPanel lobbyPanel = gui.getLobbyPanel();
        gui.setPanel(IGUIPanel.Panel.LOBBY);
        for(TableUpdate update: updates) {
            update.perform(gui);
        }
    }

}
