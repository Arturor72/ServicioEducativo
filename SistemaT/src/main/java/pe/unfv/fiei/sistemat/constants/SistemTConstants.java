package pe.unfv.fiei.sistemat.constants;

import pe.unfv.fiei.sistemat.util.Configuration;



public class SistemTConstants {

	/* Configuration file constants */
	public static final String SISTEMAT_PROPERTIES_FILE = "src\\main\\java\\pe\\unfv\\fiei\\sistemat\\util\\properties.properties";

        /* Connection Constants */
	public static final String SISTEMAT_BDNAME = Configuration.getInstance().getProperty("sistemat.bdname");
        public static final String SISTEMAT_URL = Configuration.getInstance().getProperty("sistemat.url");
        public static final String SISTEMAT_DRIVER = Configuration.getInstance().getProperty("sistemat.driver");
        public static final String SISTEMAT_USER = Configuration.getInstance().getProperty("sistemat.user");
        public static final String SISTEMAT_PASSWORD = Configuration.getInstance().getProperty("sistemat.password");
        
        /* LOGIN Constants */        
        public static final String LOGIN_SELECT = Configuration.getInstance().getProperty("login.select");
        
        
}
