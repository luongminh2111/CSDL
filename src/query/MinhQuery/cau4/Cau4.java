package query.MinhQuery.cau4;

import DAO.minh.DatabaseConnectionQuery4;
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

public class Cau4 implements Initializable {

    @FXML
    private TableView<Class4> table4;

    @FXML
    private TableColumn<Class4, String> mNVColumn;

    @FXML
    private TableColumn<Class4, String> hoTenCoumn;

    @FXML
    private TableColumn<Class4, Date> ngaySinhColumn;

    @FXML
    private TableColumn<Class4, String> queQuanColumn;

    @FXML
    private TableColumn<Class4, String> tenCVColumn;

    @FXML
    private TableColumn<Class4, String> danTocColumn;

    @FXML
    private TableColumn<Class4, String> sdtColumn;

    @FXML
    private TableColumn<Class4, Date> ngayTTColumn;


    ObservableList<Class4> listInf4 = FXCollections.observableArrayList();
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        //manv,hoten,ngaysinh,quequan,gioitinh,dantoc,sdt;
        mNVColumn.setCellValueFactory(new PropertyValueFactory<>("manv"));

        hoTenCoumn.setCellValueFactory(new PropertyValueFactory<>("hoten"));

        ngaySinhColumn.setCellValueFactory(new PropertyValueFactory<>("ngaysinh"));

        queQuanColumn.setCellValueFactory(new PropertyValueFactory<>("quequan"));

        danTocColumn.setCellValueFactory(new PropertyValueFactory<>("dantoc"));

        sdtColumn.setCellValueFactory(new PropertyValueFactory<>("sdt"));

        tenCVColumn.setCellValueFactory(new PropertyValueFactory<>("tencv"));

        ngayTTColumn.setCellValueFactory(new PropertyValueFactory<>("ngaytiepnhan"));

        listInf4 = DatabaseConnectionQuery4.getInf4();
        table4.setItems(listInf4);
    }

}
