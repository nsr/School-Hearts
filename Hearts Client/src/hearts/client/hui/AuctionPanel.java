/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * AuctionPanel.java
 *
 * Created on 2010-05-22, 21:43:27
 */
package hearts.client.hui;

import hearts.defs.state.IAuctionPanel;
import hearts.client.hui.details.GUITrick;
import hearts.defs.state.GameConstants;
import hearts.defs.state.IGUIState;
import hearts.state.actions.AuctionOfferAction;
import javax.swing.JLabel;

/**
 *
 * @author szymon
 */
public class AuctionPanel extends javax.swing.JPanel implements IAuctionPanel {

    protected static final String BID = "Postaw";
    protected static final String WITHDRAW = "Wycofaj się";
    protected IGUIState gui;
    protected JLabel[] bids;

    /** Creates new form AuctionPanel */
    public AuctionPanel() {
        initComponents();
        JLabel[] tmpbids = {null, jLabel1, jLabel2, jLabel3};
        bids = tmpbids;

    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        bidButton = new javax.swing.JButton();
        bidSpinner = new javax.swing.JSpinner();
        commenceLabel = new javax.swing.JLabel();
        commenceName = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Aukcja", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.BELOW_TOP));
        setLayout(new java.awt.GridBagLayout());

        bidButton.setText(WITHDRAW);
        bidButton.setToolTipText("Postawienie 0 oznacza wycofanie się z licytacji");
        bidButton.setEnabled(false);
        bidButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bidButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 4;
        add(bidButton, gridBagConstraints);

        bidSpinner.setModel(new javax.swing.SpinnerNumberModel(0, 0, 13, 1));
        bidSpinner.setToolTipText("Postawienie 0 oznacza wycofanie się z licytacji");
        bidSpinner.setEnabled(false);
        bidSpinner.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                bidSpinnerStateChanged(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        add(bidSpinner, gridBagConstraints);

        commenceLabel.setText("Uderz z ofertą do:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        add(commenceLabel, gridBagConstraints);

        commenceName.setFont(commenceName.getFont().deriveFont((float)17));
        commenceName.setText("Commence");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 7, 0);
        add(commenceName, gridBagConstraints);

        jLabel1.setFont(jLabel1.getFont().deriveFont((float)20));
        jLabel1.setText("0");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridheight = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 5);
        add(jLabel1, gridBagConstraints);

        jLabel2.setFont(jLabel2.getFont().deriveFont((float)20));
        jLabel2.setText("0");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTH;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 5, 0);
        add(jLabel2, gridBagConstraints);

        jLabel3.setFont(jLabel3.getFont().deriveFont((float)20));
        jLabel3.setText("0");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridheight = 5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 0, 0);
        add(jLabel3, gridBagConstraints);
    }// </editor-fold>//GEN-END:initComponents

    private void bidSpinnerStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_bidSpinnerStateChanged
        if (((int) (Integer) bidSpinner.getValue()) == 0) {
            bidButton.setText(WITHDRAW);
        } else {
            bidButton.setText(BID);
        }
    }//GEN-LAST:event_bidSpinnerStateChanged

    private void bidButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bidButtonActionPerformed
        AuctionOfferAction offer = new AuctionOfferAction(GameConstants.SERVER);
        offer.setQuotation((Integer) bidSpinner.getValue());
        gui.getSocket().actionReceived(offer);
    }//GEN-LAST:event_bidButtonActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bidButton;
    private javax.swing.JSpinner bidSpinner;
    private javax.swing.JLabel commenceLabel;
    private javax.swing.JLabel commenceName;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    // End of variables declaration//GEN-END:variables

    public IGUIState getGui() {
        return gui;
    }

    public void setGui(IGUIState gui) {
        this.gui = gui;
    }

    /**
     * Ustawia etykietę z ilością wziątek (bid) zaoferowanych przez użytkownika
     * id.
     * @param place
     * @param bid
     */
    public void setUserBid(int id, int bid) {
        int place = ((GUITrick) gui.getGameTable().getTrick()).getPlace(id);
        bids[place].setText(String.valueOf(bid));
    }

    public void setActive(boolean active) {
        bidButton.setEnabled(active);
        bidSpinner.setEnabled(active);
    }
}
