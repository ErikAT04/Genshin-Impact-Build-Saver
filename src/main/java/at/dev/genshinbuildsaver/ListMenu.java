package at.dev.genshinbuildsaver;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import java.net.URL;
import java.util.ResourceBundle;

public class ListMenu implements Initializable {

    @FXML
    private TableView<?> listTView;

    @FXML
    private TableColumn<?, ?> nameTCol;

    @FXML
    private Button selectBtt;

    @FXML
    void onAddAction(ActionEvent event) {

    }

    @FXML
    void onDropAction(ActionEvent event) {

    }

    @FXML
    void onSelectAction(ActionEvent event) {

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}

