package query.HungQuery.cau4;
import DAO.hung.DatabaseConnectionQuery4;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;

import java.net.URL;
import java.util.ResourceBundle;

public class Cau4 implements Initializable {

    ObservableList<Class4> listInf4 = FXCollections.observableArrayList();
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        listInf4 = DatabaseConnectionQuery4.getInf4();
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
