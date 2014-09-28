CREATE PROCEDURE Faltas_tutor()
SELECT U.usr_cod , U.usr_nom, U.usr_apat, U.usr_amat, count(ser_edu_id) as Faltas, sum(tip_serv_durac) as NHoras
FROM tbl_usuario U, tbl_servicio_educativo SE, tbl_tipo_servicio TS
where U.usr_id= SE.usr_tut_id and ser_edu_asist=0 and TS.tip_serv_id = SE.tip_serv_id
group by SE.usr_tut_id;
