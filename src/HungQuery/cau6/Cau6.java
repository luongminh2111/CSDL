package HungQuery.cau6;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;

import java.net.URL;
import java.util.ResourceBundle;

public class Cau6 implements Initializable {
    ObservableList<class6> listInf6 = FXCollections.observableArrayList();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        listInf6= DatabaseConnectionQuery6.getInf6();
        alert1();
    }
    public void alert1 ()
    {
        Alert alert =new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Alert");
        alert.setContentText("THÀNH CÔNG");
        alert.setHeaderText(null);
        alert.show();
        ButtonType buttonTypeYes  = new ButtonType("OK", ButtonBar.ButtonData.YES);

        alert.getButtonTypes().setAll(buttonTypeYes);

    }
}
