package query.MinhQuery.cau6;
import DAO.minh.DatabaseConnectionQuery6;
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
    private TableView<Class6> table6;

    @FXML
    private TableColumn<Class6, String > mnvColumn;

    @FXML
    private TableColumn<Class6, String> hotenColumn;

    @FXML
    private TableColumn<Class6, String> quequanColumn;

    @FXML
    private TableColumn<Class6, String> gioitinhColumn;

    @FXML
    private TableColumn<Class6, String> sdtColumn;

    @FXML
    private TableColumn<Class6, String> tenTDHVColumn;

    @FXML
    private TableColumn<Class6, String> chuyennganhColumn;
    ObservableList<Class6> listInf6 = FXCollections.observableArrayList();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        //manv,hoten,ngaysinh,quequan,gioitinh,dantoc,sdt;
        mnvColumn.setCellValueFactory(new PropertyValueFactory<>("manv"));

        hotenColumn.setCellValueFactory(new PropertyValueFactory<>("hoten"));

        quequanColumn.setCellValueFactory(new PropertyValueFactory<>("quequan"));

        gioitinhColumn.setCellValueFactory(new PropertyValueFactory<>("gioitinh"));

        sdtColumn.setCellValueFactory(new PropertyValueFactory<>("sdt"));

        tenTDHVColumn.setCellValueFactory(new PropertyValueFactory<>("tentdhv"));

        chuyennganhColumn.setCellValueFactory(new PropertyValueFactory<>("cnganh"));

        listInf6 = DatabaseConnectionQuery6.getInf6();
        table6.setItems(listInf6);
    }
}
