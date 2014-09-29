create procedure NumTalleres()
select cur_cod, count(ser_edu_id) as DemandaTalleres
from tbl_curso C, tbl_servicio_educativo SE
where C.cur_id=SE.cur_id and tip_serv_id=1
group by cur_cod;

create procedure NumTutorias()
select cur_cod, count(ser_edu_id) as DemandaTutorias
from tbl_curso C, tbl_servicio_educativo SE
where C.cur_id=SE.cur_id and tip_serv_id=2
group by cur_cod;

create procedure CursosDemandados()
select cur_cod, cur_nom, count(ser_edu_id) as DemandaTotal
from tbl_curso C, tbl_servicio_educativo SE
where C.cur_id=SE.cur_id
group by cur_cod;



call NumTalleres;
call NumTutorias;
call CursosDemandados;
