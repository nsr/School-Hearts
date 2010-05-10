/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * GUITrick.java
 *
 * Created on 2010-05-10, 21:21:18
 */
package hearts.client.hui.details;

import hearts.defs.state.ICard;
import hearts.defs.state.ITrick;
import hearts.defs.state.TrickException;

/**
 *
 * @author szymon
 */
public class GUITrick extends javax.swing.JPanel implements ITrick {

    /** Creates new form GUITrick */
    public GUITrick() {
        initComponents();
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public void addCard(ICard c, int userId) throws TrickException {
        if (this.placeHolders[userId].getCardIcon() != null) {
            throw new TrickException("dwa razy dodane do wziatki", userId, new ICard[0]);
        }
        this.placeHolders[userId].setCardIcon(new CardIcon(c));
    }

    public void clear() {
        for (CardPlaceHolder placeHolder : placeHolders) {
            placeHolder.setCardIcon(null);
        }
    }

    /**
     * Nieuzywane
     * @return
     */
    public ICard[] getCards() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    /**
     * Nieuzywane
     * @return
     */
    public boolean isLast() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    /**
     * Nieuzywane
     * @return
     */
    @Override
    public ITrick clone() {
        throw new UnsupportedOperationException("Not supported yet.");
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

        cardPlaceHolder1 = new hearts.client.hui.details.CardPlaceHolder();
        cardPlaceHolder2 = new hearts.client.hui.details.CardPlaceHolder();
        cardPlaceHolder3 = new hearts.client.hui.details.CardPlaceHolder();
        cardPlaceHolder4 = new hearts.client.hui.details.CardPlaceHolder();

        setLayout(new java.awt.GridBagLayout());

        cardPlaceHolder1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        javax.swing.GroupLayout cardPlaceHolder1Layout = new javax.swing.GroupLayout(cardPlaceHolder1);
        cardPlaceHolder1.setLayout(cardPlaceHolder1Layout);
        cardPlaceHolder1Layout.setHorizontalGroup(
            cardPlaceHolder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 57, Short.MAX_VALUE)
        );
        cardPlaceHolder1Layout.setVerticalGroup(
            cardPlaceHolder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 77, Short.MAX_VALUE)
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        add(cardPlaceHolder1, gridBagConstraints);

        cardPlaceHolder2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        javax.swing.GroupLayout cardPlaceHolder2Layout = new javax.swing.GroupLayout(cardPlaceHolder2);
        cardPlaceHolder2.setLayout(cardPlaceHolder2Layout);
        cardPlaceHolder2Layout.setHorizontalGroup(
            cardPlaceHolder2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 57, Short.MAX_VALUE)
        );
        cardPlaceHolder2Layout.setVerticalGroup(
            cardPlaceHolder2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 77, Short.MAX_VALUE)
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        add(cardPlaceHolder2, gridBagConstraints);

        cardPlaceHolder3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        javax.swing.GroupLayout cardPlaceHolder3Layout = new javax.swing.GroupLayout(cardPlaceHolder3);
        cardPlaceHolder3.setLayout(cardPlaceHolder3Layout);
        cardPlaceHolder3Layout.setHorizontalGroup(
            cardPlaceHolder3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 57, Short.MAX_VALUE)
        );
        cardPlaceHolder3Layout.setVerticalGroup(
            cardPlaceHolder3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 77, Short.MAX_VALUE)
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        add(cardPlaceHolder3, gridBagConstraints);

        cardPlaceHolder4.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        javax.swing.GroupLayout cardPlaceHolder4Layout = new javax.swing.GroupLayout(cardPlaceHolder4);
        cardPlaceHolder4.setLayout(cardPlaceHolder4Layout);
        cardPlaceHolder4Layout.setHorizontalGroup(
            cardPlaceHolder4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 57, Short.MAX_VALUE)
        );
        cardPlaceHolder4Layout.setVerticalGroup(
            cardPlaceHolder4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 77, Short.MAX_VALUE)
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        add(cardPlaceHolder4, gridBagConstraints);
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private hearts.client.hui.details.CardPlaceHolder cardPlaceHolder1;
    private hearts.client.hui.details.CardPlaceHolder cardPlaceHolder2;
    private hearts.client.hui.details.CardPlaceHolder cardPlaceHolder3;
    private hearts.client.hui.details.CardPlaceHolder cardPlaceHolder4;
    // End of variables declaration//GEN-END:variables
    protected CardPlaceHolder[] placeHolders = {cardPlaceHolder1,
        cardPlaceHolder2, cardPlaceHolder3, cardPlaceHolder4};
    protected int userId = 0;
}
