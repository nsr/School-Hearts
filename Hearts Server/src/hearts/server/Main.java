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
            ConfigReader reader;
            if (args.length == 1) {
                reader = new ConfigReader(args[0]);
            } else {
                reader = new ConfigReader(null);
            }

            Server s = new Server(reader.getPort(), reader.getHost());
            Thread th = new Thread(s);
            th.start();
        } catch (NumberFormatException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, "Błąd startowania serwera.\nBłędny port w konfiguracji.");
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, "Błąd startowania serwera", ex);
        }

    }
}
