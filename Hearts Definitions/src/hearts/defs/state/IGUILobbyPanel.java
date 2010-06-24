/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package hearts.defs.state;

/**
 *
 * @author orbit
 */
public interface IGUILobbyPanel extends IGUIPanel {
    public void updateTable(LobbyTableInfo info);
    public void setPlayerList(String[] players);
}
