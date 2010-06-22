/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package hearts.defs.state;

import hearts.defs.state.IGameState.Mode;

/**
 * Ta klasa jest troche bez sensu.
 * Wszystkie informacje ktore tu sa zawarte sa w TableUpdate.
 * GUI Niestety nie ma dostępu.
 */
public class LobbyTableInfo {
    private String tableName;
    private String owner;
    private String[] players;
    private IGameState.Mode gameMode;
    private boolean removed;

    public LobbyTableInfo(String tableName, String owner, String[] players, Mode gameMode, boolean removed) {
        this.tableName = tableName;
        this.owner = owner;
        this.players = players;
        this.gameMode = gameMode;
        this.removed = removed;
    }

    public boolean isRemoved() {
        return removed;
    }

    public Mode getGameMode() {
        return gameMode;
    }

    public String getOwner() {
        return owner;
    }

    public String getPlayer(int i) {
        return players[i];
    }

    public int getPlayerCount() {
        return players.length;
    }

    public String getTableName() {
        return tableName;
    }



}
