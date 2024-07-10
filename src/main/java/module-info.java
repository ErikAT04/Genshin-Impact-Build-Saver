module at.dev.genshinbuildsaver {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires java.sql;

    opens at.dev.genshinbuildsaver to javafx.fxml;
    exports at.dev.genshinbuildsaver;
}