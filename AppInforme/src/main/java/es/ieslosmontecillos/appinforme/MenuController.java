package es.ieslosmontecillos.appinforme;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Menu;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.ResourceBundle;

public class MenuController implements Initializable {


    @FXML
    private Menu sFacturas;
    @FXML
    private Menu vTotales;
    @FXML
    private Menu fClientes;
    @FXML
    private Menu lFactura;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }


    @FXML
    public void viewVentas(ActionEvent actionEvent) throws JRException {
        JasperReport jr = (JasperReport) JRLoader.loadObject(Objects.requireNonNull(App.class.getResource("reportes/Ventas_Totales.jasper")));
        JasperPrint jp = (JasperPrint) JasperFillManager.fillReport(jr, null, App.conexion);
        JasperViewer.viewReport(jp, false);
    }

    @FXML
    public void viewCliente(ActionEvent actionEvent) throws JRException, IOException {
        Map parametros = new HashMap();
        ClientIDController cic = new ClientIDController(App.stage);

        int id;
        try{
            id = Integer.parseInt(cic.showClientID());
        }catch(NumberFormatException e){
            System.out.println("Error al obtener el cliente ID");
            return;
        }
        parametros.put("ClientID", id);
        JasperReport jr = (JasperReport) JRLoader.loadObject(Objects.requireNonNull(App.class.getResource("reportes/Facturas_por_cliente.jasper")));
        JasperPrint jp = (JasperPrint) JasperFillManager.fillReport(jr, parametros, App.conexion);
        JasperViewer.viewReport(jp, false);
    }

    @FXML
    public void viewSubinforme(ActionEvent actionEvent) throws JRException {
        Map parametros = new HashMap();

        JasperReport subJR = (JasperReport) JRLoader.loadObject(Objects.requireNonNull(App.class.getResource("reportes/Facturas_por_cliente.jasper")));
        parametros.put("Subinforme_f", subJR);

        JasperReport jr = (JasperReport) JRLoader.loadObject(Objects.requireNonNull(App.class.getResource("reportes/Subinforme_listado_facturas.jasper")));
        JasperPrint jp = (JasperPrint) JasperFillManager.fillReport(jr, parametros, App.conexion);
        JasperViewer.viewReport(jp, false);
    }

    @FXML
    public void viewListado(ActionEvent actionEvent) throws JRException {
        JasperReport jr = (JasperReport) JRLoader.loadObject(Objects.requireNonNull(App.class.getResource("reportes/Lista_Facturas.jasper")));
        JasperPrint jp = (JasperPrint) JasperFillManager.fillReport(jr, null, App.conexion);
        JasperViewer.viewReport(jp, false);
    }
}