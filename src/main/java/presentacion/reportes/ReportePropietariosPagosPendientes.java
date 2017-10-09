package presentacion.reportes;
import dto.PendientesPropietariosDTO;
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

public class ReportePropietariosPagosPendientes {

    private JasperReport reporte;
    private JasperViewer reporteViewer;
    private JasperPrint	reporteLleno;

    private final static String jasperTemplate = "reportesJasper"+File.separatorChar+"PropietariosPagosPendientes.jrxml";
    private final static String reporteLocation = "reportesJasper"+File.separatorChar+"PropietariosPagosPendientes.jasper";

    //Recibe la lista de PropietariosPagosPendientes para armar el reporte
    public ReportePropietariosPagosPendientes(List<PendientesPropietariosDTO> pendientesPropietarios){
        //Hardcodeado
        Map<String, Object> parametersMap = new HashMap<String, Object>();
        parametersMap.put("Fecha", new SimpleDateFormat("dd/MM/yyyy").format(new Date()));

        try		{
            if (! new File(reporteLocation).exists())JasperCompileManager.compileReportToFile(
                    jasperTemplate,
                    reporteLocation);

            this.reporte = (JasperReport) JRLoader.loadObjectFromFile(reporteLocation);
            this.reporteLleno = JasperFillManager.fillReport(this.reporte, parametersMap,
                    new JRBeanCollectionDataSource(pendientesPropietarios));
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