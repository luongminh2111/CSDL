package query.MinhQuery.cau9;
import DAO.minh.DatabaseConnectionQuery9;
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

public class Cau9 implements Initializable {
    @FXML
    private TableView<Class9> table9;

    @FXML
    private TableColumn<Class9, String> mnvColumn;

    @FXML
    private TableColumn<Class9, String> hotenColumn;

    @FXML
    private TableColumn<Class9, String> sdtColumn;

    @FXML
    private TableColumn<Class9, String> tenCVColumn;

    @FXML
    private TableColumn<Class9, String> tenPBColumn;

    @FXML
    private TableColumn<Class9, Date> ngayBDColumn;

    @FXML
    private TableColumn<Class9, Float> thoiGianColumn;
    ObservableList<Class9> listInf9 = FXCollections.observableArrayList();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        //manv,hoten,ngaysinh,quequan,gioitinh,dantoc,sdt;
        mnvColumn.setCellValueFactory(new PropertyValueFactory<>("manv"));

        hotenColumn.setCellValueFactory(new PropertyValueFactory<>("hoten"));

        sdtColumn.setCellValueFactory(new PropertyValueFactory<>("sdt"));

        tenCVColumn.setCellValueFactory(new PropertyValueFactory<>("tencv"));

        tenPBColumn.setCellValueFactory(new PropertyValueFactory<>("tenpb"));

        ngayBDColumn.setCellValueFactory(new PropertyValueFactory<>("ngaybd"));

        thoiGianColumn.setCellValueFactory(new PropertyValueFactory<>("thoigian"));

        listInf9 = DatabaseConnectionQuery9.getInf9();
        table9.setItems(listInf9);
    }
}

