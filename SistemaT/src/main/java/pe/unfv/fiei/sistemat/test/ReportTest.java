/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pe.unfv.fiei.sistemat.test;

import java.util.List;
import pe.unfv.fiei.sistemat.model.dao.DaoReportes;
import pe.unfv.fiei.sistemat.model.dao.impl.DaoReportesImpl;
import pe.unfv.fiei.sistemat.model.dto.report.ReportACE;
import pe.unfv.fiei.sistemat.model.dto.report.ReportTC;

/**
 *
 * @author Arturo
 */
public class ReportTest {
    public static void main(String[] args) {
//        List<ReportTC> list=new DaoReportesImpl().ReportTCQry(1, 1);
//        for (ReportTC reportTC : list) {
//            System.out.println(""+reportTC.getUser_tutor().getUsr_nom());
//            System.out.println(""+reportTC.getCurso().getCur_nom());
//             
//        }
        
//        List<ReportACE> list=new DaoReportesImpl().ReportACEQry(1);
//        for (ReportACE reportACE : list) {
//            System.out.println(""+reportACE.getCurso().getCur_nom());
//            System.out.println(""+reportACE.getTotal());
//        }
        DaoReportes daoReportes=new DaoReportesImpl();
        System.out.println(""+daoReportes.ReportATQry(47, 5)  );
    }
    
    
}
