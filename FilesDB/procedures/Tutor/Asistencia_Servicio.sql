CREATE PROCEDURE Asistencia_servicio()
SELECT SE.ser_edu_id , TS.tip_serv_den , S.sed_desc , A.amb_den , SE.ser_edu_fec , SE.ser_edu_hin, count(al_id)
FROM tbl_servicio_educativo SE, tbl_tipo_servicio TS, tbl_sede S, tbl_ambiente A, tbl_asistencia AST
where TS.tip_serv_id=SE.tip_serv_id and S.sed_id=SE.sed_id and A.amb_id=SE.amb_id
and AST.ser_edu_id=SE.ser_edu_id and AST.ast_asist=1
group by SE.ser_edu_id;


call Asistencia_servicio