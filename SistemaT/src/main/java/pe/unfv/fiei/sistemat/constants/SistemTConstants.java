package pe.unfv.fiei.sistemat.constants;

public class SistemTConstants {

	/* Configuration file constants */
//	public static final String SISTEMAT_PROPERTIES_FILE = "src\\main\\java\\pe\\unfv\\fiei\\sistemat\\util\\properties.properties";
        /* IMPORTANT NOT CHANGE THIS LINE*/
        public static final String SISTEMAT_PROPERTIES_FILE = "";
        /* Connection Constants */
	public static final String SISTEMAT_BDNAME = "dbservicio";
        public static final String SISTEMAT_URL = "jdbc:mysql://localhost:3306/";
        public static final String SISTEMAT_DRIVER ="com.mysql.jdbc.Driver";
        public static final String SISTEMAT_USER = "root";
        public static final String SISTEMAT_PASSWORD = "root";
        
        /* LOGIN Constants */        
        public static final String LOGIN_SELECT = "SELECT usr_id, usr_cod, tip_usr_id, usr_nom, usr_apat, usr_amat, usr_dni, usr_gen, usr_cel, usr_mail, usr_user, AES_DECRYPT(usr_pass, 'F1O2R3114'), usr_est, esp_id FROM tbl_usuario WHERE (usr_user=?) and (AES_DECRYPT(usr_pass,'F1O2R3114') = ?)";
        public static final String USER_SELECT = "SELECT usr_id, usr_cod, tip_usr_id, usr_nom, usr_apat, usr_amat, usr_dni, usr_gen, usr_cel, usr_mail, usr_user, usr_pass, usr_est, esp_id FROM dbservicio.tbl_usuario WHERE tip_usr_id = ? AND esp_id = ?";

        
}
