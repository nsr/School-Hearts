package hearts.client.hui;

import hearts.defs.actions.AAction;
import hearts.defs.actions.gui.AGUIAction;
import hearts.defs.protocol.IServerSocket;
import hearts.defs.state.GUIStateException;
import hearts.defs.state.IGUIGameTable;
import hearts.defs.state.IGUIPanel;
import hearts.defs.state.IGUIState;
import hearts.defs.state.IGameState;
import hearts.defs.state.IGameState.Mode;
import hearts.defs.state.ILoginPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.util.EnumMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;

/**
 *
 * @author szymon
 */
public class MainFrame
        extends javax.swing.JFrame
        implements IGUIState {

    public static final String TITLE = "Hearts Client";
    protected Map<IGUIPanel.Panel, JPanel> panels =
            new EnumMap<IGUIPanel.Panel, JPanel>(IGUIPanel.Panel.class);
    protected IServerSocket socket;
    protected Thread socketThread;

    /** Creates new form MainFrame */
    public MainFrame() {
        initComponents();

        IGUIPanel[] panelsToAdd = {loginPanel, gameTable, lobbyPanel};
        for (IGUIPanel p : panelsToAdd) {
            panels.put(p.getPanelType(), (JPanel) p);
        }
        //System.out.println(panels);
        //System.out.println(((IGUIPanel)getCentralPanel()).getPanelType());
        //this.setPanel(Panel.GAME);
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        gameTable = new hearts.client.hui.GameTable();
        lobbyPanel = new hearts.client.hui.LobbyPanel();
        loginPanel = new hearts.client.hui.LoginPanel();
        mainMenuBar = new javax.swing.JMenuBar();
        gameMenu = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        helpMenu = new javax.swing.JMenu();
        aboutItem = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JSeparator();
        showDeck = new javax.swing.JMenuItem();
        runTest1Item = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();

        gameTable.setGui(this);

        lobbyPanel.setGui(this);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle(TITLE);
        setBounds(new java.awt.Rectangle(0, 0, 0, 0));
        setMinimumSize(new java.awt.Dimension(700, 600));

        loginPanel.setGui(this);
        getContentPane().add(loginPanel, java.awt.BorderLayout.CENTER);

        gameMenu.setText("Gra");

        jMenuItem1.setText("jMenuItem1");
        gameMenu.add(jMenuItem1);

        mainMenuBar.add(gameMenu);

        helpMenu.setText("Pomoc");

        aboutItem.setText("O grze...");
        helpMenu.add(aboutItem);
        helpMenu.add(jSeparator1);

        showDeck.setText("Zaprezentuj talię kart");
        showDeck.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showDeckActionPerformed(evt);
            }
        });
        helpMenu.add(showDeck);

        runTest1Item.setText("Pierwszy test stołu");
        runTest1Item.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                runTest1ItemActionPerformed(evt);
            }
        });
        helpMenu.add(runTest1Item);

        jMenuItem2.setText("Pokaż dialog wyboru Trumpa");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        helpMenu.add(jMenuItem2);

        jMenuItem3.setText("Pokaz aukcje");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        helpMenu.add(jMenuItem3);

        mainMenuBar.add(helpMenu);

        setJMenuBar(mainMenuBar);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void showDeckActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showDeckActionPerformed
        new DeckTester().setVisible(true);
    }//GEN-LAST:event_showDeckActionPerformed

    private void runTest1ItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_runTest1ItemActionPerformed
        gameTable.uglyTest();
    }//GEN-LAST:event_runTest1ItemActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        new ChooseTrumpDialog(this, true).setVisible(true);
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        gameTable.showAuction(true);
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        try {
            UIManager.put("control", new Color(183, 215, 143));
            UIManager.put("nimbusBase", new Color(16, 96, 12));
            UIManager.put("nimbusSelectionBackground", new Color(16, 96, 12));

            UIManager.put("nimbusLightBackground", new Color(245, 245, 229));
            UIManager.put("text", new Color(10, 78, 42));
            UIManager.put("nimbusDisabledText", new Color(120, 150, 100));
            UIManager.put("nimbusFocus", new Color(236, 241, 162));

            for (LookAndFeelInfo laf :
                    UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(laf.getName())) {
                    UIManager.setLookAndFeel(laf.getClassName());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new MainFrame().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem aboutItem;
    private javax.swing.JMenu gameMenu;
    private hearts.client.hui.GameTable gameTable;
    private javax.swing.JMenu helpMenu;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JSeparator jSeparator1;
    private hearts.client.hui.LobbyPanel lobbyPanel;
    private hearts.client.hui.LoginPanel loginPanel;
    private javax.swing.JMenuBar mainMenuBar;
    private javax.swing.JMenuItem runTest1Item;
    private javax.swing.JMenuItem showDeck;
    // End of variables declaration//GEN-END:variables

    public void setSocket(IServerSocket socket) {
        this.socket = socket;
        this.socketThread = new Thread(socket);
        socket.addActionListener(this);
        socketThread.start();
    }

    public IServerSocket getSocket() {
        return socket;
    }

    public void actionReceived(AAction a) {
        if (a instanceof AGUIAction) {
            AGUIAction guiAction = (AGUIAction) a;
            try {
                guiAction.perform(this);
            } catch (GUIStateException ex) {
                Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
                showMessage("Blad", JOptionPane.ERROR_MESSAGE, ex.getMessage());
            }
        }
    }

    public void showMessage(String title, int type, String message) {
        JOptionPane.showMessageDialog(this, message, title, type);
    }

    public ILoginPanel getLoginPanel() {
        return loginPanel;
    }

    public Panel getPanelType() {
        Component c = getCentralPanel();
        if (c instanceof IGUIPanel) {
            return ((IGUIPanel) c).getPanelType();
        } else {
            return null;
        }
    }

    private Component getCentralPanel() {
        return ((BorderLayout) this.getContentPane().getLayout()).getLayoutComponent(BorderLayout.CENTER);
    }

    public synchronized void setPanel(final Panel p) {
        SwingUtilities.invokeLater(new Runnable() {

            public void run() {
                getContentPane().remove(getCentralPanel());
                JPanel jp = panels.get(p);
                getContentPane().add(jp, BorderLayout.CENTER);
                validate();
                repaint();
            }
        });
    }

    /**
     * Nie nie robi
     * @param gui
     */
    public void setGui(IGUIState gui) {
        //
    }

    public IGUIGameTable getGameTable() {
        return gameTable;
    }

    @Override
    public void setTitle(String title) {
        super.setTitle(TITLE + " : " + title);
    }

    public LobbyPanel getLobbyPanel() {
        return lobbyPanel;
    }
   
}
