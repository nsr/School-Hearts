/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * LobbyPanel.java
 *
 * Created on 2010-06-22, 15:09:07
 */
package hearts.client.hui;

import hearts.client.hui.details.LobbyTableModel;
import hearts.defs.state.IGUILobbyPanel;
import hearts.defs.state.IGUIState;
import hearts.defs.state.IGameState.Mode;
import hearts.defs.state.LobbyTableInfo;
import hearts.maintenance.JoinTableMaintenance;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import javax.swing.ListSelectionModel;

/**
 *
 * @author orbit
 */
public class LobbyPanel extends javax.swing.JPanel implements IGUILobbyPanel, MouseListener {

    IGUIState gui = null;
    LobbyTableModel model = new LobbyTableModel();

    /** Creates new form LobbyPanel */
    public LobbyPanel() {
        initComponents();
        table.setModel(model);
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        table.addMouseListener(this);
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(table);

        jLabel1.setText("Lista dostępnych stołów:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 775, Short.MAX_VALUE)
                    .addComponent(jLabel1))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 445, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable table;
    // End of variables declaration//GEN-END:variables

    public Panel getPanelType() {
        return Panel.LOBBY;
    }

    public void setGui(IGUIState gui) {
        this.gui = gui;
    }

    public void updateTable(LobbyTableInfo info) {
        model.update(info);
    }

    public void mouseClicked(MouseEvent e) {
        if (e.getClickCount() == 2) {
            TableDetails details = new TableDetails(this, (LobbyTableInfo) model.getInfo(table.getSelectedRow()));
            details.showInFrame();
        }        
    }

    public void mousePressed(MouseEvent e) {
    }

    public void mouseReleased(MouseEvent e) {
    }

    public void mouseEntered(MouseEvent e) {
    }

    public void mouseExited(MouseEvent e) {
    }

    void joinToTable(String tableName) {
        gui.getSocket().maintenanceReceived(new JoinTableMaintenance(tableName, 0));
    }
}
