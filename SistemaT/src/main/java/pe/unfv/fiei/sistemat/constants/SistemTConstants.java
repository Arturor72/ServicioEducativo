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

    /*State for active and inactive registers */
    public static final String STATE_ON = "1";
    public static final String STATE_OFF = "0";
    
    /*State for active and inactive registers */
    
    public static final String STATE_SERVICE_OFF = "0"; //This state is when the service is delete
    public static final String STATE_SERVICE_CREATE = "1"; //This state is when the service is create
    public static final String STATE_SERVICE_TUTOR = "2"; //This state is when the tutor attended to service 
   public static final String STATE_SERVICE_STUDENT = "3"; //This state is when the tutor check the alumno's attended to service  
   public static final String STATE_SERVICE_PAST = "4"; //This state is when the service was store and tutor a
   public static final String STATE_SERVICE_PAST_AND_DSTUDENT = "5"; //This state is when the service was store 
    

    /*Errors for unique field*/
    public static final String ERROR_UNIQUE_FIELD = "1062";

    /* Admin and Tutor Type Constants */
    public static final Integer TYPE_ADMIN = 1;
    public static final Integer TYPE_TUTOR = 2;

    /* LOGIN Constants */
    public static final String LOGIN_SELECT = "SELECT usr_id, usr_cod, tip_usr_id, usr_nom, usr_apat, usr_amat, usr_dni, usr_gen, usr_cel, usr_mail, usr_user, AES_DECRYPT(usr_pass, 'F1O2R3114'), usr_est, esp_id FROM tbl_usuario WHERE (usr_user=?) and (AES_DECRYPT(usr_pass,'F1O2R3114') = ?)";

    /* USUARIO Constants */
    public static final String USER_SELECT = "SELECT usr_id, usr_cod, tip_usr_id, usr_nom, usr_apat, usr_amat, usr_dni, usr_gen, usr_cel, usr_mail, usr_user, usr_pass, usr_est, esp_id FROM dbservicio.tbl_usuario WHERE tip_usr_id = ? AND esp_id = ? AND usr_est = 1 ORDER BY usr_nom, usr_apat, usr_amat";
    public static final String USER_INSERT = "INSERT INTO dbservicio.tbl_usuario (usr_cod, tip_usr_id, usr_nom, usr_apat, usr_amat, usr_dni, usr_gen, usr_cel, usr_mail, usr_user, usr_pass, usr_est, esp_id) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, AES_ENCRYPT(?,'F1O2R3114'), ?, ?)";
    public static final String USER_DELETE = "UPDATE dbservicio.tbl_usuario SET usr_est = 0 WHERE usr_id = ?";
    public static final String USER_GET = "SELECT usr_id, usr_cod, tip_usr_id, usr_nom, usr_apat, usr_amat, usr_dni, usr_gen, usr_cel, usr_mail, usr_user, AES_DECRYPT(usr_pass, 'F1O2R3114'), usr_est, esp_id FROM dbservicio.tbl_usuario WHERE usr_id = ?";
    public static final String USER_UPDATE = "UPDATE dbservicio.tbl_usuario SET usr_cod = ?, tip_usr_id = ?, usr_nom = ?, usr_apat = ?, usr_amat = ?, usr_dni = ?, usr_gen = ?, usr_cel = ?, usr_mail = ?, usr_user = ?, usr_pass = AES_ENCRYPT(?,'F1O2R3114'), usr_est = ?, esp_id = ? WHERE usr_id = ?";
    public static final String USER_GET_LIST_DISPONIBLE = "{call tutoresDisp(?,?,?,?,?)}";

    /* ASISTENCIA Constants */
    public static final String ASISTENCIA_INSERT = "INSERT INTO tbl_asistencia (ser_edu_id, al_id, ast_asist) VALUES (?, ?, ?)";
    
    
    /* ALUMNO Constants */
    public static final String ALUMNO_SELECT = "SELECT al_id, al_cod, al_nom, al_apat, al_amat, al_cel, al_mail, al_susp FROM dbservicio.tbl_alumno";
    public static final String ALUMNO_CHANGE_STATE = " UPDATE dbservicio.tbl_alumno SET al_susp=? WHERE al_id=?";

    
    /* CURSO Constants */
    public static final String CURSO_SELECT = "SELECT cur_id, cur_cod, cur_nom, esp_id, cur_est FROM tbl_curso WHERE esp_id = ? AND cur_est=TRUE ";
    public static final String CURSO_UPDATE = "UPDATE tbl_curso SET cur_cod=?, cur_nom=?, esp_id=?, cur_est=? WHERE cur_id = ?";
    public static final String CURSO_DELETE = "UPDATE tbl_curso SET cur_est=FALSE WHERE cur_id = ?";
    public static final String CURSO_GET = "SELECT cur_id, cur_cod, cur_nom, esp_id, cur_est FROM tbl_curso WHERE esp_id = ? AND cur_id=?";
    public static final String CURSO_GET_ID = "SELECT cur_id, cur_cod, cur_nom, esp_id, cur_est FROM tbl_curso WHERE cur_id=?";
    public static final String CURSO_GET_SERVICIO = "SELECT cur_id, cur_cod, cur_nom, esp_id, cur_est FROM tbl_curso WHERE cur_id=?";
    public static final String CURSO_INS = "INSERT INTO tbl_curso (cur_id, cur_cod, cur_nom, esp_id, cur_est) VALUES (DEFAULT, ?, ?, ?, ?)";

    /* ESPECIALIDAD Constants */
    public static final String ESPECIALIDAD_GET = "SELECT esp_id, esp_cod, esp_nom FROM tbl_especialidad WHERE esp_id = ?";

    /* SEDE Constants */
    public static final String SEDE_GET = "SELECT sed_id, sed_desc FROM tbl_sede WHERE sed_id = ?";
    public static final String SEDE_QRY = "SELECT sed_id, sed_desc FROM tbl_sede ";

    /* AMBIENTE Constants */
    public static final String AMBIENTE_GET = "SELECT amb_id, sed_id, amb_den, tip_amb_id FROM tbl_ambiente WHERE amb_id = ?";
    public static final String AMBIENTE_GET_LIST_DISPONIBLE = "{call ambientesDisp(?,?,?,?)}";

    /* TIPO AMBIENTE Constants */
    public static final String TIPO_AMBIENTE_GET = "SELECT tip_amb_id, tip_amb_den FROM tbl_tipo_ambiente WHERE tip_amb_id = ?";

    /* TIPO SERVICIO Constants */
    public static final String TIPO_SERVICIO_GET = "SELECT tip_serv_id, tip_serv_den, tip_serv_durac FROM tbl_tipo_servicio WHERE tip_serv_id = ?";

    /* SERVICIO Constants */
    public static final String SERVICIO_SELECT = "SELECT ser_edu_id, ser_edu_fec, ser_edu_hin, cur_id, amb_id, sed_id, tip_serv_id, usr_adm_id, usr_tut_id, ser_edu_asist, ser_edu_desc, ser_edu_est FROM dbservicio.tbl_servicio_educativo se, dbservicio.tbl_usuario u WHERE se.usr_adm_id=u.usr_id AND u.esp_id=? AND  se.ser_edu_est <> 0 ORDER BY (ser_edu_fec) DESC";
    public static final String SERVICIO_SELECT_BY_DATE = "SELECT ser_edu_id, ser_edu_fec, ser_edu_hin, cur_id, amb_id, sed_id, tip_serv_id, usr_adm_id, usr_tut_id, ser_edu_asist, ser_edu_desc, ser_edu_est FROM dbservicio.tbl_servicio_educativo se, dbservicio.tbl_usuario u WHERE se.usr_adm_id=u.usr_id AND u.esp_id=? AND  se.ser_edu_fec= ? AND se.ser_edu_est <> 0 ORDER BY (ser_edu_fec) DESC";
    public static final String SERVICIO_SELECT_BY_SEDE = "SELECT ser_edu_id, ser_edu_fec, ser_edu_hin, cur_id, amb_id, sed_id, tip_serv_id, usr_adm_id, usr_tut_id, ser_edu_asist, ser_edu_desc, ser_edu_est FROM dbservicio.tbl_servicio_educativo se, dbservicio.tbl_usuario u WHERE se.usr_adm_id=u.usr_id AND u.esp_id=? AND  se.sed_id= ? AND se.ser_edu_est <> 0 ORDER BY (ser_edu_fec) DESC";
    public static final String SERVICIO_SELECT_BY_DATE_TUTOR = "SELECT ser_edu_id, ser_edu_fec, ser_edu_hin, cur_id, amb_id, sed_id, tip_serv_id, usr_adm_id, usr_tut_id, ser_edu_asist, ser_edu_desc, ser_edu_est FROM dbservicio.tbl_servicio_educativo se, dbservicio.tbl_usuario u WHERE se.usr_tut_id=u.usr_id AND u.esp_id=? AND  se.ser_edu_fec= ? AND se.ser_edu_est <> 0 AND se.usr_tut_id= ? ORDER BY (ser_edu_fec) DESC";
    public static final String SERVICIO_SELECT_BY_SEDE_TUTOR = "SELECT ser_edu_id, ser_edu_fec, ser_edu_hin, cur_id, amb_id, sed_id, tip_serv_id, usr_adm_id, usr_tut_id, ser_edu_asist, ser_edu_desc, ser_edu_est FROM dbservicio.tbl_servicio_educativo se, dbservicio.tbl_usuario u WHERE se.usr_tut_id=u.usr_id AND u.esp_id=? AND  se.sed_id= ? AND se.ser_edu_est <> 0 AND se.usr_tut_id= ? ORDER BY (ser_edu_fec) DESC";
    public static final String SERVICIO_SELECT_BY_TUTOR = "SELECT ser_edu_id, ser_edu_fec, ser_edu_hin, cur_id, amb_id, sed_id, tip_serv_id, usr_adm_id, usr_tut_id, ser_edu_asist, ser_edu_desc, ser_edu_est FROM dbservicio.tbl_servicio_educativo se, dbservicio.tbl_usuario u WHERE se.usr_tut_id= ? AND se.usr_tut_id=u.usr_id AND se.ser_edu_est <> 0 ORDER BY (ser_edu_fec) DESC";
    public static final String SERVICIO_INSERT = "INSERT INTO dbservicio.tbl_servicio_educativo (ser_edu_id, ser_edu_fec, ser_edu_hin, cur_id, amb_id, sed_id, tip_serv_id, usr_adm_id, usr_tut_id, ser_edu_asist, ser_edu_desc, ser_edu_est) VALUES (DEFAULT, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
    public static final String SERVICIO_CHANGE_STATE = "UPDATE dbservicio.tbl_servicio_educativo SET ser_edu_est = ? WHERE ser_edu_id = ? ";
    public static final String SERVICIO_GET = "SELECT ser_edu_id, ser_edu_fec, ser_edu_hin, cur_id, amb_id, sed_id, tip_serv_id, usr_adm_id, usr_tut_id, ser_edu_asist, ser_edu_desc, ser_edu_est FROM dbservicio.tbl_servicio_educativo WHERE ser_edu_id=?  AND ser_edu_est <> 0";
    public static final String SERVICIO_UPDATE = "UPDATE dbservicio.tbl_servicio_educativo SET ser_edu_fec=?, ser_edu_hin=?, cur_id=?, amb_id=?, sed_id=?, tip_serv_id=?, usr_adm_id=?, usr_tut_id=?, ser_edu_asist=?, ser_edu_desc=?, ser_edu_est=?  WHERE ser_edu_id = ?";
    public static final String SERVICIO_UPDATE_ASIST = "UPDATE dbservicio.tbl_servicio_educativo SET ser_edu_asist=1  WHERE ser_edu_id = ? ";
    public static final String SERVICIO_GET_PAST = "SELECT ser_edu_id, ser_edu_fec, ser_edu_hin, cur_id, amb_id, sed_id, tip_serv_id, usr_adm_id, usr_tut_id, ser_edu_asist, ser_edu_desc, ser_edu_est FROM tbl_servicio_educativo sa WHERE TIMESTAMP(CONCAT(CAST(sa.ser_edu_fec as CHAR ), ' ',CAST(sa.ser_edu_hin as CHAR))) < now() AND (sa.ser_edu_asist=0) AND  sa.ser_edu_id=?";
    public static final String SERVICIO_GET_PAST_ASIST = "SELECT  sa.* FROM tbl_servicio_educativo sa INNER JOIN tbl_asistencia asi ON sa.ser_edu_id=asi.ser_edu_id where TIMESTAMP(CONCAT(CAST(sa.ser_edu_fec as CHAR ), ' ',CAST(sa.ser_edu_hin as CHAR))) < now() AND  sa.ser_edu_id=?";
    
    
    /* REPORT CANTIDAD DE HORAS POR TUTOR SEGUN ESPECIALIDAD*/
    public static final String REPORT_THM = "{call reportTHM(?,?,?)}";
    /* REPORT CANTIDAD DE ASISTENCIA A UN TALLER X*/
    public static final String REPORT_AT = "{call reportAT(?,?)}";

}
