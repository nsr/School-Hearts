package hearts.defs.state;

import hearts.defs.protocol.IUserSocket;
import hearts.defs.actions.IActionListener;

/**
 * Klasa opiekująca się stanem gry, odpowiedzialna za:
 * <ol>
 * <li>przyporządkowaniu userom id na czas rozgrywki od 0 do 3.</li>
 * <li>rozpoczęcie gry jesli liczba userów == 4</li>
 * <li>rzucanie wyjątkiem jeśli liczba userów == 4 w addUser
 * <li>trzymanie obiektu stanu gry</li>
 * <li>nasłuchiwanie na UserSocketach, tzn. dodaje siebie jako ich Listener</li>
 * <li>przetwarzanie otrzymanych akcji przy pomocy Judge'a</li>
 * <li>Przetwarzenie akcji chatu z DubmState'a</li>
 * <li>każdorazowo po przetworzeniu stanu gry sprawdza listę
 * ze stanu gry i dumbstate'a
 * obiektów Action do rozesłania i rozsyła do adresatów albo ID usera albo
 * GameConstants.ALL_USER</li>
 * </ol>
 *
 * <p>Trzyma GameState i DumbState:
 * <ul>
 * <li>GameState dla akcji dziedziczących po AServerAction</li>
 * <li>DumbState dla akcji chatu, dziedziczących po AChatAction</li>
 * </ul>
 * </p>
 * @author szymon
 */
public interface IServerStateGuard extends IActionListener, Runnable {

    /**
     * <ol>
     * <li>Dodaje usera do tablicy userów.</li>
     * <li>Ustawia na sockecie id usera co by wiedział jakiego nadawcę ustawiać
     * akcjom w polu sender.</li>
     * <li>Dodaje siebie jako obiekt nasłuchujący na sockecie</li>
     * <li>Wysyła info wszystkim userom o nowoprzybyłym (id i nazwy)</li>
     * <li>startuje grę gdy komplet userów.</li>
     * </ol>
     * @param socket socket z połączeniem do klienta.
     * @throws GameStateException jeśli próbujemy dodać więcej userów niż 4.
     * @return id usera 0...3
     */
    public int addUser(IUserSocket socket) throws GameStateException;

    /**
     * Pobiera aktualny stan gry.
     * @return
     */
    public IGameState getState();
}
