package query.TuanAnhQuery.cau10;
import DAO.tuanAnh.DatabaseConnectionQuery10;
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

public class Cau10 implements Initializable {
    @FXML
    private TableView<Class10> table10;

    @FXML
    private TableColumn<Class10, String> mNVColumn;

    @FXML
    private TableColumn<Class10, String> hoTenColumn;

    @FXML
    private TableColumn<Class10, Date> ngaySinhColumn;

    @FXML
    private TableColumn<Class10, String> queQuanColumn;

    @FXML
    private TableColumn<Class10, String> gioiTinhColumn;

    @FXML
    private TableColumn<Class10, String> danTocColumn;

    @FXML
    private TableColumn<Class10, String> sdtColumn;

    @FXML
    private TableColumn<Class10, String> maPBColumn;

    @FXML
    private TableColumn<Class10, String> maCVColumn;

    @FXML
    private TableColumn<Class10, String> maTDHVColumn;

    @FXML
    private TableColumn<Class10, String> bacLuongColumn;

    @FXML
    private TableColumn<Class10, Date> ngayBDColumn;

    ObservableList<Class10> listInf10 = FXCollections.observableArrayList();
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        //manv, hoten,quequan,gioitinh,dantoc,sdt,mapb,macv,matdhv,bacluong,loaihd;
        mNVColumn.setCellValueFactory(new PropertyValueFactory<>("manv"));

        hoTenColumn.setCellValueFactory(new PropertyValueFactory<>("hoten"));

        ngaySinhColumn.setCellValueFactory(new PropertyValueFactory<>("ngaysinh"));

        queQuanColumn.setCellValueFactory(new PropertyValueFactory<>("quequan"));

        gioiTinhColumn.setCellValueFactory(new PropertyValueFactory<>("gioitinh"));

        danTocColumn.setCellValueFactory(new PropertyValueFactory<>("dantoc"));

        sdtColumn.setCellValueFactory(new PropertyValueFactory<>("sdt"));

        maPBColumn.setCellValueFactory(new PropertyValueFactory<>("mapb"));

        maCVColumn.setCellValueFactory(new PropertyValueFactory<>("macv"));

        maTDHVColumn.setCellValueFactory(new PropertyValueFactory<>("matdhv"));

        bacLuongColumn.setCellValueFactory(new PropertyValueFactory<>("bacluong"));

        ngayBDColumn.setCellValueFactory(new PropertyValueFactory<>("ngaybd"));

        listInf10 = DatabaseConnectionQuery10.getInf10();
        table10.setItems(listInf10);
    }
}
