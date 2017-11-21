package presentacion.reportes;

import dto.CobrosDeAlquileresDTO;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ReporteContable {

    private JasperReport reporte;
    private JasperViewer reporteViewer;
    private JasperPrint	reporteLleno;

    private final static String jasperTemplate = "reportesJasper"+File.separatorChar+"Contable.jrxml";
    private final static String reporteLocation = "reportesJasper"+File.separatorChar+"Contable.jasper";

    //Recibe la lista de Datos contables para armar el reporte
    public ReporteContable(List<CobrosDeAlquileresDTO> contables){
        //Hardcodeado
        Map<String, Object> parametersMap = new HashMap<String, Object>();
        parametersMap.put("Fecha", new SimpleDateFormat("dd/MM/yyyy").format(new Date()));

        try		{
            if (! new File(reporteLocation).exists())JasperCompileManager.compileReportToFile(
                    jasperTemplate,
                    reporteLocation);

            this.reporte = (JasperReport) JRLoader.loadObjectFromFile(reporteLocation);
            this.reporteLleno = JasperFillManager.fillReport(this.reporte, parametersMap,
                    new JRBeanCollectionDataSource(contables));
        }
        catch( JRException ex )
        {
            ex.printStackTrace();
        }
    }

    public void mostrar(){
        this.reporteViewer = new JasperViewer(this.reporteLleno,false);
        this.reporteViewer.setTitle("Reporte de Carteles");
        this.reporteViewer.setVisible(true);
    }

}