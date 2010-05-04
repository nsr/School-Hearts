/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package hearts.state.actions.gui;

import hearts.defs.actions.gui.AGUIAction;
import hearts.defs.state.GUIStateException;
import hearts.defs.state.ICard;
import hearts.defs.state.IGUIState;
import hearts.defs.state.IGameState;
import hearts.defs.state.IGameState.Mode;
import java.util.List;

/**
 * Klasa przygotowana specjalnie z myślą o klijencie, zawiera nowe karty gracza i zaktualizowaną punktacje
 * oraz, nowy Typ rozgrywki.
 * @author Paweł Trynkiewicz
 */
public class NewDaelForUserAGUI extends AGUIAction {

    private ICard []cards=null;
    private List<Integer> listPoints=null;
    private IGameState.Mode mode;
    private int dealer;
    private int activeUser;

    public int getDealer() {
        return dealer;
    }

    public void setDealer(int dealer) {
        this.dealer = dealer;
    }

    public int getActiveUser() {
        return activeUser;
    }

    public void setActiveUser(int activeUser) {
        this.activeUser = activeUser;
    }
    
    public ICard[] getCards() {
        return cards;
    }

    public void setCards(ICard[] cards) {
        this.cards = cards;
    }

    public List<Integer> getListPoints() {
        return listPoints;
    }

    public void setListPoints(List<Integer> listPoints) {
        this.listPoints = listPoints;
    }

    

    

    public Mode getMode() {
        return mode;
    }

    public void setMode(Mode mode) {
        this.mode = mode;
    }

    



    
    public NewDaelForUserAGUI(int receiver) {
        super(receiver);
    }
    

   

    @Override
    public void perform(IGUIState gui) throws GUIStateException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
