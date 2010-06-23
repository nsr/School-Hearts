/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package hearts.maintenance.answers;

import hearts.defs.state.GUIStateException;
import hearts.defs.state.IGUIPanel.Panel;
import hearts.defs.state.IGUIState;
import javax.swing.JOptionPane;

/**
 *
 * @author orbit
 */
public class TableClosedAction extends AMaintenaceAction {

    @Override
    public void perform(IGUIState gui) throws GUIStateException {
        gui.setPanel(Panel.LOBBY);
        gui.newGamePanel();
        JOptionPane.showMessageDialog(null, "Któryś z graczy rozłączył się. Rozgrywka została przerwana.", "Koniec rozgrywki", JOptionPane.INFORMATION_MESSAGE);
    }

}
