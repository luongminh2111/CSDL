package TuanAnhQuery.cau2;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;

import java.net.URL;
import java.util.ResourceBundle;

public class Cau2 implements Initializable {
    ObservableList<class2> listInf2 = FXCollections.observableArrayList();
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        //manv, hoten,quequan,gioitinh,dantoc,sdt,mapb,macv,matdhv,bacluong,loaihd;
        listInf2 = DatabaseConnectionQuery2.getInf2();
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
