package hearts.client.hui;

import hearts.defs.actions.AAction;
import hearts.defs.actions.gui.AGUIAction;
import hearts.defs.protocol.IServerSocket;
import hearts.defs.state.GUIStateException;
import hearts.defs.state.IGUIState;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author szymon
 */
public class MainFrame
        extends javax.swing.JFrame
        implements IGUIState {

    protected IServerSocket socket;
    protected Thread socketThread;
    
    /** Creates new form MainFrame */
    public MainFrame() {
        initComponents();
        loginPanel.setGui(this);
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        loginPanel = new hearts.client.hui.loginPanel();
        mainMenuBar = new javax.swing.JMenuBar();
        gameMenu = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        helpMenu = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().add(loginPanel, java.awt.BorderLayout.CENTER);

        gameMenu.setText("Gra");

        jMenuItem1.setText("jMenuItem1");
        gameMenu.add(jMenuItem1);

        mainMenuBar.add(gameMenu);

        helpMenu.setText("Pomoc");
        mainMenuBar.add(helpMenu);

        setJMenuBar(mainMenuBar);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
    * @param args the command line arguments
    */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu gameMenu;
    private javax.swing.JMenu helpMenu;
    private javax.swing.JMenuItem jMenuItem1;
    private hearts.client.hui.loginPanel loginPanel;
    private javax.swing.JMenuBar mainMenuBar;
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


}