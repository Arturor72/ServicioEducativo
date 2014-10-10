package pe.unfv.fiei.sistemat.constants;

public class SistemTConstants {

    /* Configuration file constants */
//	public static final String SISTEMAT_PROPERTIES_FILE = "src\\main\\java\\pe\\unfv\\fiei\\sistemat\\util\\properties.properties";
        /* IMPORTANT NOT CHANGE THIS LINE*/
    public static final String SISTEMAT_PROPERTIES_FILE = "";
    /* Connection Constants */
    public static final String SISTEMAT_BDNAME = "dbservicio";
    public static final String SISTEMAT_URL = "jdbc:mysql://localhost:3306/";
    public static final String SISTEMAT_DRIVER = "com.mysql.jdbc.Driver";
    public static final String SISTEMAT_USER = "root";
    public static final String SISTEMAT_PASSWORD = "root";
    /* Admin and Tutor Type Constants */
    public static final Integer TYPE_ADMIN = 1;
    public static final Integer TYPE_TUTOR = 2;

    /* LOGIN Constants */
    public static final String LOGIN_SELECT = "SELECT usr_id, usr_cod, tip_usr_id, usr_nom, usr_apat, usr_amat, usr_dni, usr_gen, usr_cel, usr_mail, usr_user, AES_DECRYPT(usr_pass, 'F1O2R3114'), usr_est, esp_id FROM tbl_usuario WHERE (usr_user=?) and (AES_DECRYPT(usr_pass,'F1O2R3114') = ?)";

    /* USUARIO Constants */
    public static final String USER_SELECT = "SELECT usr_id, usr_cod, tip_usr_id, usr_nom, usr_apat, usr_amat, usr_dni, usr_gen, usr_cel, usr_mail, usr_user, usr_pass, usr_est, esp_id FROM dbservicio.tbl_usuario WHERE tip_usr_id = ? AND esp_id = ? AND usr_est = 1";
    public static final String USER_INSERT = "INSERT INTO dbservicio.tbl_usuario (usr_cod, tip_usr_id, usr_nom, usr_apat, usr_amat, usr_dni, usr_gen, usr_cel, usr_mail, usr_user, usr_pass, usr_est, esp_id) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, AES_ENCRYPT(?,'F1O2R3114'), ?, ?)";
    public static final String USER_DELETE = "UDPATE dbservicio.tbl_usuario SET usr_est = 0 WHERE usr_id = ?";
    public static final String USER_GET = "SELECT usr_id, usr_cod, tip_usr_id, usr_nom, usr_apat, usr_amat, usr_dni, usr_gen, usr_cel, usr_mail, usr_user, usr_pass, usr_est, esp_id FROM dbservicio.tbl_usuario WHERE usr_id = ?";
    public static final String USER_UPDATE = "UDPATE dbservicio.tbl_usuario SET usr_cod = ?, tip_usr_id = ?, usr_nom = ?, usr_apat = ?, usr_amat = ?, usr_dni = ?, usr_gen = ?, usr_cel = ?, usr_mail = ?, usr_user = ?, usr_pass = ?, usr_est = ?, esp_id = ? FROM dbservicio.tbl_usuario WHERE usr_id = ?";

    /* CURSO Constants */
    public static final String CURSO_SELECT = "SELECT cur_id, cur_cod, cur_nom, esp_id, cur_est FROM tbl_curso WHERE esp_id = ? AND cur_est=TRUE ";
    public static final String CURSO_UPDATE = "UPDATE tbl_curso SET cur_cod=?, cur_nom=?, esp_id=?, cur_est=? WHERE cur_id = ?";
    public static final String CURSO_DELETE = "UPDATE tbl_curso SET cur_est=FALSE WHERE cur_id = ?";
    public static final String CURSO_GET = "SELECT cur_id, cur_cod, cur_nom, esp_id, cur_est FROM tbl_curso WHERE esp_id = ? AND cur_id=?";
    public static final String CURSO_INS = "INSERT INTO tbl_curso (cur_id, cur_cod, cur_nom, esp_id, cur_est) VALUES (DEFAULT, ?, ?, ?, ?)";

    /* ESPECIALIDAD Constants */
    public static final String ESPECIALIDAD_GET = "SELECT esp_id, esp_cod, esp_nom FROM tbl_especialidad WHERE esp_id = ?";

    /* SEDE Constants */
    public static final String SEDE_GET = "SELECT sed_id, sed_desc FROM tbl_sede WHERE sed_id = ?";

    /* AMBIENTE Constants */
    public static final String AMBIENTE_GET = "SELECT amb_id, sed_id, amb_den, tip_amb_id FROM tbl_ambiente WHERE amb_id = ?";

    /* TIPO AMBIENTE Constants */
    public static final String TIPO_AMBIENTE_GET = "SELECT tip_amb_id, tip_amb_den FROM tbl_tipo_ambiente WHERE tip_amb_id = ?";

    /* TIPO SERVICIO Constants */
    public static final String TIPO_SERVICIO_GET = "SELECT tip_serv_id, tip_serv_den, tip_serv_durac FROM tbl_tipo_servicio WHERE tip_serv_id = ?";

    /* SERVICIO Constants */
    public static final String SERVICIO_SELECT = "SELECT ser_edu_id, ser_edu_fec, ser_edu_hin, cur_id, amb_id, sed_id, tip_serv_id, usr_adm_id, usr_tut_id, ser_edu_asist, ser_edu_desc, ser_edu_est FROM dbservicio.tbl_servicio_educativo se, dbservicio.tbl_usuario u WHERE se.usr_adm_id=u.usr_id AND u.esp_id=? AND  se.ser_edu_est= 1";
    
    public static final String SERVICIO_INSERT = "INSERT INTO dbservicio.tbl_servicio_educativo (ser_edu_id, ser_edu_fec, ser_edu_hin, cur_id, amb_id, sed_id, tip_serv_id, usr_adm_id, usr_tut_id, ser_edu_asist, ser_edu_desc, ser_edu_est) VALUES (DEFAULT, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
    public static final String SERVICIO_DELETE = "UDPATE dbservicio.tbl_servicio_educativo SET ser_edu_est = 0 WHERE ser_edu_id = ?";
    public static final String SERVICIO_GET = "SELECT ser_edu_id, ser_edu_fec, ser_edu_hin, cur_id, amb_id, sed_id, tip_serv_id, usr_adm_id, usr_tut_id, ser_edu_asist, ser_edu_desc, ser_edu_est FROM dbservicio.tbl_servicio_educativo WHERE ser_edu_id=?  AND ser_edu_est= 1";
    public static final String SERVICIO_UPDATE = "UDPATE dbservicio.tbl_servicio_educativo SET ser_edu_fec=?, ser_edu_hin=?, cur_id=?, amb_id=?, sed_id=?, tip_serv_id=?, usr_adm_id=?, usr_tut_id=?, ser_edu_asist=?, ser_edu_desc=?, ser_edu_est=?  WHERE ser_edu_id = ?";

}
