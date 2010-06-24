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
    static private String configFile = "config";
    static private Properties config = null;

    public static void setConfig(String config) throws Exception {
        if(config!=null) {
            ConfigReader.configFile = config;
        } else {
            ConfigReader.configFile = "config";
        }

        File cfile = new File(ConfigReader.configFile);
        if(cfile.isDirectory()) {
            throw new Exception("Plik konfiguracyjny nie może być katalogiem.");
        }
    }


    /**
     * Zwraca hosta.
     * @return
     */
    public static String getHost() {
        if(config == null) {
            loadConfigFile();
        }
        return config.getProperty("host");
    }

    /**
     * Zwraca port;
     * @return
     */
    public static int getPort() {
        if(config == null) {
            loadConfigFile();
        }
        return  Integer.valueOf(config.getProperty("port"));
    }

    /**
     * Zwraca sciezke listy uzytkownikow.
     * @return
     */
    public static String getUserList() {
        if(config == null) {
            loadConfigFile();
        }
        return config.getProperty("userList", "config");
    }


    /**
     * Ładuje plik konfiguracyjny. W razie gdy go nie ma wywołuje metodę tworzącą go.
     */
    private static void loadConfigFile() {
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
    private static void createDefaultConfigFile() {
        try {
            FileOutputStream fos = new FileOutputStream(new File(configFile));
            config = new Properties();
            config.setProperty("host", "localhost");
            config.setProperty("port", "9999");
            config.setProperty("userList", System.getProperty("user.dir") + System.getProperty("file.separator")+"userList");
            config.store(fos, "-------------");
            fos.close();
        } catch (IOException ex) {
            Logger.getLogger(ConfigReader.class.getName()).log(Level.SEVERE, "Błąd tworzenia domyślnego pliku konfiguracyjnego.", ex);
        }
    }

}
