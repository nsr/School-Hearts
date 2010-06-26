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
import hearts.defs.state.LobbyTableInfo;
import hearts.maintenance.CreateTableMaintenance;
import hearts.maintenance.JoinTableMaintenance;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Arrays;
import javax.swing.DefaultListModel;
import javax.swing.ListSelectionModel;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

/**
 * Panel zawierający lobby.
 * @author Michał Charmas
 */
public class LobbyPanel extends javax.swing.JPanel implements IGUILobbyPanel, MouseListener, DocumentListener {

    IGUIState gui = null;
    LobbyTableModel model = new LobbyTableModel();
    
    /** Creates new form LobbyPanel */
    public LobbyPanel() {
        initComponents();
        table.setModel(model);
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        table.addMouseListener(this);

        //TableRowSorter<LobbyTableModel> sorter = new TableRowSorter<LobbyTableModel>();
        //table.setRowSorter(sorter);

        tableNameEdit.getDocument().addDocumentListener(this);
        
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
        createTableButton = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        tableNameEdit = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        playerList = new javax.swing.JList();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        playerCountField = new javax.swing.JTextField();

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(table);

        jLabel1.setText("Lista dostępnych stołów:");

        createTableButton.setText("Utwórz stół i usiądź");
        createTableButton.setEnabled(false);
        createTableButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createTableButtonActionPerformed(evt);
            }
        });

        jLabel2.setText("Nazwa stołu: ");

        jScrollPane2.setViewportView(playerList);

        jLabel3.setText("Gracze na serwerze:");

        jLabel4.setText("Liczba graczy:");

        playerCountField.setEditable(false);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel3)
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(playerCountField, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 172, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 436, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(playerCountField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel1)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addComponent(jLabel2)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(tableNameEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(createTableButton)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 431, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 436, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(tableNameEdit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(createTableButton))))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void createTableButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createTableButtonActionPerformed
        CreateTableMaintenance ct = new CreateTableMaintenance(tableNameEdit.getText());        
        gui.getSocket().maintenanceReceived(ct);
        tableNameEdit.setText("");
    }//GEN-LAST:event_createTableButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton createTableButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField playerCountField;
    private javax.swing.JList playerList;
    private javax.swing.JTable table;
    private javax.swing.JTextField tableNameEdit;
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

    public void insertUpdate(DocumentEvent e) {
        buttonUpdate();
    }

    public void removeUpdate(DocumentEvent e) {
        buttonUpdate();
    }

    public void changedUpdate(DocumentEvent e) {
        buttonUpdate();
    }

    private void buttonUpdate() {
        if (tableNameEdit.getText().equals("")) {
            createTableButton.setEnabled(false);
        } else {
            createTableButton.setEnabled(true);
        }
    }

    /**
     * Ustawia listę playerów w gui.
     * @param players
     */
    public void setPlayerList(String[] players) {
        DefaultListModel lModel = new DefaultListModel();
        Arrays.sort(players);
        for(String p: players) {
            lModel.addElement(p);
        }
        playerList.setModel(lModel);
        playerCountField.setText(String.valueOf((players.length)));
    }
}
