create procedure HorasTrabajadasTutor()
select usr_cod, usr_nom, usr_apat, usr_amat, sum(tip_serv_durac) as HorasTrabajadas
from tbl_usuario U, tbl_servicio_educativo SE, tbl_tipo_servicio TS
where U.usr_id = SE.usr_tut_id and TS.tip_serv_id = SE.tip_serv_id
and SE.ser_edu_asist = 1
group by U.usr_id;

call HorasTrabajadasTutor;