package query.TuanAnhQuery.cau7;
import DAO.tuanAnh.DatabaseConnectionQuery7;
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

public class Cau7 implements Initializable {
    @FXML
    private TableView<Class7> table5;

    @FXML
    private TableColumn<Class7, String> mNVColumn;

    @FXML
    private TableColumn<Class7, String> hoTenColumn;

    @FXML
    private TableColumn<Class7, Date> ngaySinhColumn;

    @FXML
    private TableColumn<Class7, String> gioiTinhColumn;

    @FXML
    private TableColumn<Class7, String> queQuanColumn;

    @FXML
    private TableColumn<Class7, String> sdtColumn;

    @FXML
    private TableColumn<Class7, String> tenPBColumn;

    ObservableList<Class7> listInf7 = FXCollections.observableArrayList();
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        //manv, hoten,quequan,gioitinh,dantoc,sdt,mapb,macv,matdhv,bacluong,loaihd;
        mNVColumn.setCellValueFactory(new PropertyValueFactory<>("manv"));

        hoTenColumn.setCellValueFactory(new PropertyValueFactory<>("hoten"));

        ngaySinhColumn.setCellValueFactory(new PropertyValueFactory<>("ngaysinh"));

        gioiTinhColumn.setCellValueFactory(new PropertyValueFactory<>("gioitinh"));

        queQuanColumn.setCellValueFactory(new PropertyValueFactory<>("quequan"));

        sdtColumn.setCellValueFactory(new PropertyValueFactory<>("sdt"));

        tenPBColumn.setCellValueFactory(new PropertyValueFactory<>("tenpb"));

        listInf7 = DatabaseConnectionQuery7.getInf7();
        table5.setItems(listInf7);
    }
}
