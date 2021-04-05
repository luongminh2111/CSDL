package TuanAnhQuery.cau3;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.sql.Date;
import java.util.ResourceBundle;

public class Cau3 implements Initializable {
    @FXML
    private TableView<class3> table3;

    @FXML
    private TableColumn<class3, String> maNVColumn;

    @FXML
    private TableColumn<class3, String> hoTenColumn;

    @FXML
    private TableColumn<class3, Date> ngaySinhColumn;

    @FXML
    private TableColumn<class3, String> queQuanColumn;

    @FXML
    private TableColumn<class3, String> sdtColumn;

    @FXML
    private TableColumn<class3, Double> luongColumn;

    ObservableList<class3> listInf3 = FXCollections.observableArrayList();
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        maNVColumn.setCellValueFactory(new PropertyValueFactory<>("manv"));

        hoTenColumn.setCellValueFactory(new PropertyValueFactory<>("hoten"));

        ngaySinhColumn.setCellValueFactory(new PropertyValueFactory<>("ngaysinh"));

        queQuanColumn.setCellValueFactory(new PropertyValueFactory<>("quequan"));

        sdtColumn.setCellValueFactory(new PropertyValueFactory<>("sdt"));

        luongColumn.setCellValueFactory(new PropertyValueFactory<>("salary"));

        listInf3 = DatabaseConnectionQuery3.getInf3();
        table3.setItems(listInf3);
    }
}
