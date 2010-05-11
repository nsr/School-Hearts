/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hearts.defs.state;

/**
 * Stan stołu gui
 * @author szymon
 */
public interface IGUIGameTable extends IGUIPanel {

    /**
     * Ustaw karty
     * @param cards
     */
    public void setCards(ICard[] cards);

    /**
     * Ustaw, czy karty mają być odwrócone, czyli
     * pokazywać awers.
     * @param flipped
     */
    public void setFlipped(boolean flipped);

    /**
     * Pobierz obiekt wziątki na stole
     * @return
     */
    public ITrick getTrick();

    /**
     * Wyczyść wziątkę na stole
     */
    public void clearTrick();
}