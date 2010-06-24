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
 * Klasa potrzebna w momencie gdy któryś z graczy rozłączy się podczas rozgrywki.
 * @author Michał Charmas
 */
public class TableClosedAction extends AMaintenaceAction {

    /**
     * Metoda zmienia panel w GUI na Lobby i wyświetla powiadomienie użytkownikowi, że ktoś rozłącyzł się podczas rozgrywki.
     * @param gui
     * @throws GUIStateException
     */
    @Override
    public void perform(IGUIState gui) throws GUIStateException {
        gui.setPanel(Panel.LOBBY);
        gui.newGamePanel();
        JOptionPane.showMessageDialog(null, "Któryś z graczy rozłączył się. Rozgrywka została przerwana.", "Koniec rozgrywki", JOptionPane.INFORMATION_MESSAGE);
    }

}
