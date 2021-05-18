package query.TuanAnhQuery.cau8;
import DAO.tuanAnh.DatabaseConnectionQuery8;
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
    private TableColumn<Class8, String> hotenColumn;

    @FXML
    private TableColumn<Class8, Date> ngaysinhColumn;

    @FXML
    private TableColumn<Class8, String> quequanColumn;

    @FXML
    private TableColumn<Class8, String> sdtColumn;

    @FXML
    private TableColumn<Class8, String> bacluongColumn;

    ObservableList<Class8> listInf8 = FXCollections.observableArrayList();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        //manv,hoten,ngaysinh,quequan,gioitinh,dantoc,sdt;
        mnvColumn.setCellValueFactory(new PropertyValueFactory<>("manv"));

        hotenColumn.setCellValueFactory(new PropertyValueFactory<>("hoten"));

        ngaysinhColumn.setCellValueFactory(new PropertyValueFactory<>("ngaysinh"));

        quequanColumn.setCellValueFactory(new PropertyValueFactory<>("quequan"));

        sdtColumn.setCellValueFactory(new PropertyValueFactory<>("sdt"));

        bacluongColumn.setCellValueFactory(new PropertyValueFactory<>("bacluong"));

        listInf8 = DatabaseConnectionQuery8.getInf8();
        table8.setItems(listInf8);
    }
}
