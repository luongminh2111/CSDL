package query.TuanAnhQuery.cau6;
import DAO.tuanAnh.DatabaseConnectionQuery6;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ResourceBundle;

public class Cau6 implements Initializable {

    @FXML
    private TableView<class6> table6;

    @FXML
    private TableColumn<class6, String> hoTenColumn;

    @FXML
    private TableColumn<class6, String> tenCVColumn;

    @FXML
    private TableColumn<class6, String> tenPBColumn;


    ObservableList<class6> listInf6 = FXCollections.observableArrayList();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        hoTenColumn.setCellValueFactory(new PropertyValueFactory<>("hoten"));

        tenCVColumn.setCellValueFactory(new PropertyValueFactory<>("tencv"));

        tenPBColumn.setCellValueFactory(new PropertyValueFactory<>("tenpb"));
        listInf6 = DatabaseConnectionQuery6.getInf6();
        table6.setItems(listInf6);
    }
}
