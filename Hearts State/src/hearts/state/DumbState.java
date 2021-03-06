package hearts.state;

import hearts.defs.state.AAuction;
import hearts.defs.state.CardColor;
import hearts.defs.state.GameStateException;
import hearts.defs.state.IGameState.Mode;
import hearts.defs.state.ITrick;
import hearts.defs.state.IUserState;

/**
 * Głupi stan gry. Dla StateGuarda do wykonywania na nim akcji typu ChatMessage
 * i poźniej rozsyłania efektu.
 * 
 * Implementuje tylko kolejkę (dziedziczy po AActionList)
 * @author szymon
 */
public class DumbState extends AActionList {

    public IUserState getUserState(int id) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void setUserState(int id, IUserState state) throws GameStateException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public int getActiveUser() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public int nextUser() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public Mode getMode() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public Mode nextMode() throws GameStateException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public CardColor getTrump() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void setTrump(CardColor c) throws GameStateException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public boolean isAuction() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void setAuction(boolean auction) throws GameStateException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public ITrick getTrick() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void clearTrick(boolean last) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public Mode addUser(IUserState user) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void setDealer(int dealer) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public int nextDealer() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public int getDealer() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void setAtiveUser(int user) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public boolean trickEnds() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public boolean dealEnds() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public int getNumTrick() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void setActiveUser(int user) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void clearMode() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void addMode(Mode mode) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void setNumTrick(int i) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void addCommence(int user) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public int removeCommence() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public int getCommence() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void setAuction(AAuction auction) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public AAuction getAuction() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
