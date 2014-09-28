create procedure AlumnosSuspendidos()

select al_cod, al_nom, al_apat, al_amat
from tbl_alumno
where al_susp=1;


call AlumnosSuspendidos