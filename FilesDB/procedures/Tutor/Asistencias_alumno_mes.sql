CREATE PROCEDURE Asistencias_alumno_mes()
SELECT A.al_cod , al_nom, al_apat, al_amat, tip_serv_den, cur_nom, count(AST.ser_edu_id)
FROM tbl_alumno A, tbl_tipo_servicio TS, tbl_curso C, tbl_servicio_educativo SE, tbl_asistencia AST
where C.cur_id=SE.cur_id and TS.tip_serv_id=SE.tip_serv_id
and A.al_id=AST.al_id and SE.ser_edu_id=AST.ser_edu_id
and ast_asist=1
group by A.al_cod
;


call Asistencias_alumno_mes