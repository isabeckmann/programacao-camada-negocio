package br.com.acme.logging;

import java.io.IOException;
import java.util.Properties;
import java.util.logging.ConsoleHandler;
import java.util.logging.FileHandler;
import java.util.logging.Handler;
import java.util.logging.Logger;

public class SupressConsole {

    private static Logger logger = Logger.getLogger(SupressConsole.class.getName());

    
    public static void main(String[] args) {
        try {
            Properties conf = getLogConf();

            Handler fh = new FileHandler(conf.getProperty("file"), Boolean.parseBoolean(conf.getProperty("append")));
            Logger.getLogger("").addHandler(fh);

            // ------------------------------------------

            if (Boolean.parseBoolean(conf.getProperty("suppress-console-output"))) {
                Logger l = Logger.getLogger("");

                Handler[] handlers = l.getHandlers();

                if (handlers[0] instanceof ConsoleHandler) {
                    l.removeHandler(handlers[0]);
                }
            }

            logger.info("Test log suppress console");

        } catch (IOException | SecurityException ex) {
            System.out.println(ex);
        }

    }

    private static Properties getLogConf() {
        Properties conf = new Properties();

        conf.setProperty("file", "example.log");
        conf.setProperty("append", "false");
        conf.setProperty("suppress-console-output", "true");
        

        return conf;
    }
}
