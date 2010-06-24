/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hearts.server;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Głowna klasa odpalająca serwer.
 * @author Michał Charmas
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            if (args.length == 1) {
               ConfigReader.setConfig(args[0]);
            }

            Server s = new Server(ConfigReader.getPort(), ConfigReader.getHost());
            Thread th = new Thread(s);
            th.start();
        } catch (NumberFormatException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, "Błąd startowania serwera.\nBłędny port w konfiguracji.");
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, "Błąd startowania serwera", ex);
        } catch (Exception ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, "Błąd startowania serwera.\nPlik konfiguracyjny nie może być katalogiem.");
        }

    }
}
