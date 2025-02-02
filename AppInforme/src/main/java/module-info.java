module es.ieslosmontecillos.appinforme {
    requires javafx.controls;
    requires javafx.fxml;
    requires jasperreports;
    requires org.hsqldb;
    requires java.sql;


    opens es.ieslosmontecillos.appinforme to javafx.fxml;
    exports es.ieslosmontecillos.appinforme;
}