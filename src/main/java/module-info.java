module com.projeto.projeto {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.bootstrapfx.core;

    opens com.projeto.projeto to javafx.fxml;
    exports com.projeto.projeto;
}