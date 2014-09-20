package pe.unfv.fiei.sistemat.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.log4j.Logger;
import pe.unfv.fiei.sistemat.constants.SistemTConstants;


public final class Configuration {

	private Logger log4j = Logger.getLogger(Configuration.class);
	private static Configuration instance;
	private static Properties prop;
	public static synchronized Configuration getInstance() {
		if (instance == null) {
			instance = new Configuration();
		}
		return instance;
	}
	private Configuration() {
		InputStream in = null;
		try {
                    	log4j.info("INIT --->.");
			FileInputStream fis = new FileInputStream(SistemTConstants.SISTEMAT_PROPERTIES_FILE);
			in = fis;
			log4j.info("Setting configuration file successfully.");
			prop = new Properties();
			prop.load(in);
			
		} catch (IOException e) {
			log4j.error(e.getMessage(), e);
			throw new RuntimeException("Setting configuration file failed: no properties file found.");
		} finally {
			try {
				in.close();
			} catch (IOException e) {
				log4j.error(e.getMessage(), e);
			}
		}
	}

	public String getProperty(String key) {
		return prop.getProperty(key);
	}
}