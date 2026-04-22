package br.com.acme.logging;

import java.io.IOException;
import java.util.Properties;
import java.util.logging.FileHandler;
import java.util.logging.Handler;
import java.util.logging.Logger;

public class FileHandlerLog {

    private static Logger logger = Logger.getLogger( FileHandlerLog.class.getName() );
    
    
    
    public static void main(String[] args) {
        try {
            Properties conf = getLogConf();

            Handler fh = new FileHandler( conf.getProperty("file"), Boolean.parseBoolean( conf.getProperty("append") ));
            Logger.getLogger("").addHandler(fh);

            logger.info("Testing log system");
            logger.info("sample log system");
            
            System.out.println( logger.getHandlers().length) ;
            
        } catch (IOException | SecurityException ex) {
            System.out.println(ex);
        }
    }
    
    

    private static Properties getLogConf() {
        Properties conf = new Properties();

        conf.setProperty("file", "example.log");
        conf.setProperty("append", "false");

        return conf;
    }
}
