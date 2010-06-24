/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package hearts.server;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Klasa do obsługi pliku konfiguracyjnego.
 * @author Michał Charmas
 */
public class ConfigReader {
    private String configFile;
    private Properties config = null;

    /**
     * Tworzy obiekt Config readera.
     * Domyślny host = localhost
     * Domyślny port = 9999
     * @param configFile ścieżka do pliku z konfiguracją. Jeśli null to domyślnie "config"
     */
    public ConfigReader(String configFile) {
        if(configFile!=null) {
            this.configFile = configFile;
        } else {
            this.configFile = "config";
        }
    }

    /**
     * Zwraca hosta.
     * @return
     */
    public String getHost() {
        if(config == null) {
            loadConfigFile();
        }
        return config.getProperty("host");
    }

    /**
     * Zwraca port;
     * @return
     */
    public int getPort() {
        if(config == null) {
            loadConfigFile();
        }
        return  Integer.valueOf(config.getProperty("port"));
    }

    /**
     * Ładuje plik konfiguracyjny. W razie gdy go nie ma wywołuje metodę tworzącą go.
     */
    private void loadConfigFile() {
        try {
            FileInputStream fis = new FileInputStream(new File(configFile));
            config = new Properties();
            config.load(fis);
            fis.close();
        } catch (IOException ex) {
            createDefaultConfigFile();
            loadConfigFile();
        }
    }

    /**
     * Metoda tworząca domyślny plik konfiguracyjny.
     * Domyślny host = localhost
     * Domyślny port = 9999
     */
    private void createDefaultConfigFile() {
        try {
            FileOutputStream fos = new FileOutputStream(new File(configFile));
            config = new Properties();
            config.setProperty("host", "localhost");
            config.setProperty("port", "9999");
            config.store(fos, "-------------");
            fos.close();
        } catch (IOException ex) {
            Logger.getLogger(ConfigReader.class.getName()).log(Level.SEVERE, "Błąd tworzenia domyślnego pliku konfiguracyjnego.", ex);
        }
    }

}
