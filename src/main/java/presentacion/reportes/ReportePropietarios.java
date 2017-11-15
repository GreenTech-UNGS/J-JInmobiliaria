package presentacion.reportes;

import dto.PropietariosDTO;
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

public class ReportePropietarios {

    private JasperReport reporte;
    private JasperViewer reporteViewer;
    private JasperPrint	reporteLleno;

    private final static String jasperTemplate = "reportesJasper"+File.separatorChar+"Propietarios.jrxml";
    private final static String reporteLocation = "reportesJasper"+File.separatorChar+"Propietarios.jasper";

    //Recibe la lista de Propietarios para armar el reporte
    public ReportePropietarios(List<PropietariosDTO> propietarios){
        //Hardcodeado
        Map<String, Object> parametersMap = new HashMap<String, Object>();
        parametersMap.put("Fecha", new SimpleDateFormat("dd/MM/yyyy").format(new Date()));

        try		{
            if (! new File(reporteLocation).exists())JasperCompileManager.compileReportToFile(
                    jasperTemplate,
                    reporteLocation);

            this.reporte = (JasperReport) JRLoader.loadObjectFromFile(reporteLocation);
            this.reporteLleno = JasperFillManager.fillReport(this.reporte, parametersMap,
                    new JRBeanCollectionDataSource(propietarios));
        }
        catch( JRException ex )
        {
            ex.printStackTrace();
        }
    }

    public void mostrar(){
        this.reporteViewer = new JasperViewer(this.reporteLleno,false);
        this.reporteViewer.setTitle("Reporte de Pagos Pendientes de Propietarios");
        this.reporteViewer.setVisible(true);
    }

}