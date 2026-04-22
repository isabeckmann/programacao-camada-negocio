package br.com.acme.logging;

import java.io.IOException;
import java.util.Properties;
import java.util.logging.FileHandler;
import java.util.logging.Handler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;
import java.util.logging.XMLFormatter;

public class LogFormat {

    private static Logger logger = Logger.getLogger(LogFormat.class.getName());

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

            logger.info("Test log format");
            logger.info("testing log system...");

        } catch (IOException | SecurityException ex) {
            System.out.println(ex);
        }

    }

    private static Properties getLogConf() {
        Properties conf = new Properties();

        conf.setProperty("file", "example.log");
        conf.setProperty("append", "false");
        conf.setProperty("output-format", "SIMPLE");

        return conf;
    }
}
