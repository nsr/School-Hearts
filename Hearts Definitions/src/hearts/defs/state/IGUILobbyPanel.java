/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package hearts.defs.state;

/**
 * Interfejst Panelu Lobby w GUI
 * @author Michał Charmas
 */
public interface IGUILobbyPanel extends IGUIPanel {
    public void updateTable(LobbyTableInfo info);
    public void setPlayerList(String[] players);
}
