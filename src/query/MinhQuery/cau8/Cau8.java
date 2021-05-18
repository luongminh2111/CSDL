package query.MinhQuery.cau8;
import DAO.minh.DatabaseConnectionQuery8;
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

public class Cau8 implements Initializable {
    @FXML
    private TableView<Class8> table8;

    @FXML
    private TableColumn<Class8, String> mnvColumn;

    @FXML
    private TableColumn<Class8, String> tenCVColumn;

    @FXML
    private TableColumn<Class8, String> tenPBColumn;

    @FXML
    private TableColumn<Class8, Date> ngayBDColumn;

    @FXML
    private TableColumn<Class8, Date> ngayKTColumn;
    ObservableList<Class8> listInf8 = FXCollections.observableArrayList();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        //manv,hoten,ngaysinh,quequan,gioitinh,dantoc,sdt;
        mnvColumn.setCellValueFactory(new PropertyValueFactory<>("manv"));

        tenCVColumn.setCellValueFactory(new PropertyValueFactory<>("tencv"));

        tenPBColumn.setCellValueFactory(new PropertyValueFactory<>("tenpb"));

        ngayBDColumn.setCellValueFactory(new PropertyValueFactory<>("ngaytiepnhan"));

        ngayKTColumn.setCellValueFactory(new PropertyValueFactory<>("ngayketthuc"));

        listInf8 = DatabaseConnectionQuery8.getInf8();
        table8.setItems(listInf8);
    }
}
