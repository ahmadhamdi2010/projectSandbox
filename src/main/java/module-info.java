module com.sde.passwordmanager {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.bootstrapfx.core;
    requires java.sql;

    opens com.sde.passwordmanager to javafx.fxml;
    exports com.sde.passwordmanager;
    exports com.sde.passwordmanager.controllers;
    opens com.sde.passwordmanager.controllers to javafx.fxml;
}