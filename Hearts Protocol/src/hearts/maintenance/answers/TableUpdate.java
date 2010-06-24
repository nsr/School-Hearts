/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hearts.maintenance.answers;

import hearts.defs.state.GUIStateException;
import hearts.defs.state.IGUIState;
import hearts.defs.state.IGameState;
import hearts.defs.state.IGameState.Mode;
import hearts.defs.state.LobbyTableInfo;

/**
 * Klasa zawierająca informacje o stole.
 * @author Michał Charmas
 */
public class TableUpdate extends AMaintenaceAction {

    private String tableName;
    private String owner;
    private String[] players = null;
    private IGameState.Mode gameMode = IGameState.Mode.WAITING_FOR_PLAYERS;
    private Boolean removed = Boolean.FALSE;

    /**
     * Konstruktor.
     * @param tableName nazwa stołów którego ta informacja dotyczy
     * @param owner właściciel stołu
     */
    public TableUpdate(String tableName, String owner) {
        this.tableName = tableName;
        this.owner = owner;
    }

    public void setGameMode(Mode gameMode) {
        this.gameMode = gameMode;
    }

    public void setPlayer(int place, String name) {
        if (players == null) {
            players = new String[4];
        }
        players[place] = name;
    }

    public void setRemoved(Boolean removed) {
        this.removed = removed;
    }

    /**
     * Gdy rozgrywka trwa i powiadomienie dotyczy stołu na którym aktualnie gra użytkownik:
     * - ustawianie informacji o graczach przy stole (kto gdzie siedzi)
     * - ustawienie aktualnego etapu rozgrywki
     *
     * Oprócz tego za każdym razem gdy dostaniemy ten obiekt uaktualniamy informacje w lobby o stołach.
     * @param gui
     * @throws GUIStateException
     */
    @Override
    public void perform(IGUIState gui) throws GUIStateException {
        String guiTableName = gui.getGameTable().getTableName();
        if (guiTableName != null && guiTableName.equals(tableName)) {
            for (int i = 0; i < players.length; ++i) {
                gui.getGameTable().setUser(i, players[i]);
            }
            gui.getGameTable().setMode(gameMode);
        }
        LobbyTableInfo info = new LobbyTableInfo(tableName, owner, players, gameMode, removed);
        gui.getLobbyPanel().updateTable(info);
    }
}
