package TuanAnhQuery.cau5;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ResourceBundle;

public class Cau5 implements Initializable {
    @FXML
    private TableView<class5> table5;

    @FXML
    private TableColumn<class5, String> mNVColumn;

    @FXML
    private TableColumn<class5, String> hoTenColumn;

    @FXML
    private TableColumn<class5, String> maTDHVColumn;

    @FXML
    private TableColumn<class5, String> tenTDHVColumn;

    @FXML
    private TableColumn<class5, String> cNganhColumn;



    ObservableList<class5> listInf5 = FXCollections.observableArrayList();
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        mNVColumn.setCellValueFactory(new PropertyValueFactory<>("manv"));

        hoTenColumn.setCellValueFactory(new PropertyValueFactory<>("hoten"));

        maTDHVColumn.setCellValueFactory(new PropertyValueFactory<>("matdhv"));

        tenTDHVColumn.setCellValueFactory(new PropertyValueFactory<>("tentdhv"));

        cNganhColumn.setCellValueFactory(new PropertyValueFactory<>("cnganh"));

        listInf5 = DatabaseConnectionQuery5.getInf5();
        table5.setItems(listInf5);
    }
}
