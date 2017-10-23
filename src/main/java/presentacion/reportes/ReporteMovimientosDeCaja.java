package presentacion.reportes;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import dto.MovimientoDeCajaDTO;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

public class ReporteMovimientosDeCaja {

    private JasperReport reporte;
    private JasperViewer reporteViewer;
    private JasperPrint	reporteLleno;

    private final static String jasperTemplate = "reportesJasper"+File.separatorChar+"MovimientosDeCaja.jrxml";
    private final static String reporteLocation = "reportesJasper"+File.separatorChar+"MovimientosDECaja.jasper";

    //Recibe la lista de PagosDeALquileres para armar el reporte
    public ReporteMovimientosDeCaja(List<MovimientoDeCajaDTO> movimientosDeCaja){
        //Hardcodeado
        Map<String, Object> parametersMap = new HashMap<String, Object>();
        parametersMap.put("Fecha", new SimpleDateFormat("dd/MM/yyyy").format(new Date()));

        try		{
            if (! new File(reporteLocation).exists())JasperCompileManager.compileReportToFile(
                    jasperTemplate,
                    reporteLocation);

            this.reporte = (JasperReport) JRLoader.loadObjectFromFile(reporteLocation);
            this.reporteLleno = JasperFillManager.fillReport(this.reporte, parametersMap,
                    new JRBeanCollectionDataSource(movimientosDeCaja));
        }
        catch( JRException ex )
        {
            ex.printStackTrace();
        }
    }

    public void mostrar(){
        this.reporteViewer = new JasperViewer(this.reporteLleno,false);
        this.reporteViewer.setTitle("Reporte de Movimientos de ingresos/egresos");
        this.reporteViewer.setVisible(true);
    }

}