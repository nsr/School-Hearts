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

    protected CardPlaceHolder[] placeHolders;
    protected int userId = 0;
    protected int activeUser = 0;

    /** Creates new form GUITrick */
    public GUITrick() {
        initComponents();
        CardPlaceHolder[] tmp = {cardPlaceHolder1,
            cardPlaceHolder2, cardPlaceHolder3, cardPlaceHolder4};
        this.placeHolders = tmp;
    }

    /**
     * Id lokalnego gracza
     * @return
     */
    public int getUserId() {
        return userId;
    }

    public int getPlace(int forreignId) {
        return (4 - this.userId + forreignId) % 4;
    }

    /**
     * Id lokalnego gracza
     * @param userId
     */
    public void setUserId(int userId) {
        this.userId = userId;
    }

    /**
     * Aktywny gracz
     * @return
     */
    public int getActiveUser() {
        return activeUser;
    }

    /**
     * Aktywny gracz
     * @param activeUser
     */
    public void setActiveUser(int activeUser) {
        this.activeUser = activeUser;
        for (CardPlaceHolder placeHolder : placeHolders) {
            placeHolder.setArrow(false);
        }
        // ustawia strzałkę na aktywnego usera względem id lokalnego
        placeHolders[getPlace(activeUser)].setArrow(true);
    }

    public void addCard(ICard c, int userId) throws TrickException {
        int place = getPlace(userId);
        if (this.placeHolders[place].getCardIcon() != null) {
            throw new TrickException("dwa razy dodane do wziatki", userId, new ICard[0]);
        }
        this.placeHolders[place].setCardIcon(new CardIcon(c));
    }

    public void clear() {
        for (CardPlaceHolder placeHolder : placeHolders) {
            placeHolder.setCardIcon(null);
        }
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
        cardPlaceHolder1.setArrowOrientation(Arrow.DOWN);
        cardPlaceHolder1.setFlipped(false);

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
        cardPlaceHolder2.setArrowOrientation(Arrow.LEFT);
        cardPlaceHolder2.setFlipped(false);

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
        cardPlaceHolder3.setArrowOrientation(Arrow.UP);
        cardPlaceHolder3.setFlipped(false);

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
        cardPlaceHolder4.setArrowOrientation(Arrow.RIGHT);
        cardPlaceHolder4.setFlipped(false);

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

    /**
     * Nieuzywane
     * @return
     */
    public int getFirst() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    /**
     * Nieuzywane
     * @return
     */
    public void setFirst(int user) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    /**
     * Nieuzywane
     * @return
     */
    public boolean ends() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
