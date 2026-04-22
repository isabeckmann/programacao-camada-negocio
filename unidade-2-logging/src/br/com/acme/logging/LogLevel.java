package br.com.acme.logging;

import java.io.IOException;
import java.util.Properties;
import java.util.logging.ConsoleHandler;
import java.util.logging.FileHandler;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;
import java.util.logging.XMLFormatter;

public class LogLevel {

    private static Logger logger = Logger.getLogger(LogLevel.class.getName());

    public static void main(String[] args) {
        try {
            Properties conf = getLogConf();

            Handler fh = new FileHandler(conf.getProperty("file"), Boolean.parseBoolean(conf.getProperty("append")));
            Logger.getLogger("").addHandler(fh);

            // ------------------------------------------

            if (conf.getProperty("output-format").equalsIgnoreCase("XML")) {
                fh.setFormatter(new XMLFormatter());
            } else if (conf.getProperty("output-format").equalsIgnoreCase("SIMPLE")) {
                fh.setFormatter(new SimpleFormatter());
            }

            // ------------------------------------------

            if (Boolean.parseBoolean(conf.getProperty("suppress-console-output"))) {
                Logger l = Logger.getLogger("");

                Handler[] handlers = l.getHandlers();

                if (handlers[0] instanceof ConsoleHandler) {
                    l.removeHandler(handlers[0]);
                }
            }

            // ------------------------------------------

            String level = conf.getProperty("level");
            
            Level lv = null;
            if (level.equalsIgnoreCase("SEVERE")) {
                lv = Level.SEVERE;
            } else if (level.equalsIgnoreCase("WARNING")) {
                lv = Level.WARNING;
            } else if (level.equalsIgnoreCase("INFO")) {
                lv = Level.INFO;
            } else if (level.equalsIgnoreCase("CONFIG")) {
                lv = Level.CONFIG;
            } else if (level.equalsIgnoreCase("FINE")) {
                lv = Level.FINE;
            } else if (level.equalsIgnoreCase("FINER")) {
                lv = Level.FINER;
            } else if (level.equalsIgnoreCase("FINEST")) {
                lv = Level.FINEST;
            } else if (level.equalsIgnoreCase("ALL")) {
                lv = Level.ALL;
            } else if (level.equalsIgnoreCase("OFF")) {
                lv = Level.OFF;
            }

            Logger.getLogger("").setLevel(lv);
                    
            
            logger.severe("Severe log message");
            logger.warning("Warning log message");
            logger.info("Info log message");
            logger.config("Config log message");
            logger.fine("Fine log message");
            logger.finer("Finer log message");
            logger.finest("Finest log message");
            
            String s = null;
            s.length();
            
        } catch (IOException | SecurityException ex) {
            logger.log(Level.SEVERE, ex.getMessage() );
        } catch(NullPointerException ex) {
            logger.log(Level.WARNING, ex.getMessage() );
        }
       

    }

    private static Properties getLogConf() {
        Properties conf = new Properties();

        conf.setProperty("file", "example.log");
        conf.setProperty("append", "false");
        conf.setProperty("suppress-console-output", "true");
        conf.setProperty("level", "WARNING");
        conf.setProperty("output-format", "SIMPLE");      

        return conf;
    }
}
