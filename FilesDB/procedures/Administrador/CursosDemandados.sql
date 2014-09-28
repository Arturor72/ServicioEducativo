create procedure CursosDemandados()
select cur_cod, cur_nom, count(ser_edu_id) as DemandaTotal
from tbl_curso C, tbl_servicio_educativo SE
where C.cur_id=SE.cur_id
group by cur_cod;


call CursosDemandados