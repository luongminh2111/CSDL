package HopDongLaoDong;

import static HopDongLaoDong.DatabaseConnectionHDLD.getHDLD;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Date;
import java.util.ResourceBundle;

public class HopDongLaoDong implements Initializable {
    @FXML
    private Button cancelBtn;
    @FXML
    private Button updateBtn;
    @FXML
    private Button deleteBtn;
    @FXML
    private TableView<HDLD> tableHDLD;
    @FXML
    private TableColumn<HDLD,String> mhdColum;
    @FXML
    private TableColumn<HDLD,String> mnvColum;
    @FXML
    private TableColumn<HDLD,String>  lhdColum;
    @FXML
    private TableColumn<HDLD, Date> nbdColum;
    @FXML
    private TableColumn<HDLD, Date>  nktColum;
    @FXML
    private TextField maHDText;
    @FXML
    private TextField maNVText;
    @FXML
    private TextField loaiHDText;
    @FXML
    private TextField ngayBDDate;
    @FXML
    private TextField ngayKTDate;
    @FXML
    private TextField searchText;

    ObservableList<HDLD> listHDLD = FXCollections.observableArrayList();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        //string la ten bien dat trong TDNV
        mhdColum.setCellValueFactory(new PropertyValueFactory<>("maHD"));
        mnvColum.setCellValueFactory(new PropertyValueFactory<>("maNV"));
        lhdColum.setCellValueFactory(new PropertyValueFactory<>("loaiHD"));
        nbdColum.setCellValueFactory(new PropertyValueFactory<>("ngayBD"));
        nktColum.setCellValueFactory(new PropertyValueFactory<>("ngayKT"));
        listHDLD = getHDLD();
        tableHDLD.setItems(listHDLD);
        searchUser();
    }

    int indexHDLD=-1;
    @FXML
    void getSelectedHDLD (MouseEvent event)
    {
        indexHDLD=tableHDLD.getSelectionModel().getSelectedIndex();
        if(indexHDLD<-1) {
            return;
        }
        maHDText.setText(mhdColum.getCellData(indexHDLD));
        maNVText.setText(mnvColum.getCellData(indexHDLD));
        loaiHDText.setText(lhdColum.getCellData(indexHDLD));
        ngayBDDate.setText(String.valueOf(nbdColum.getCellData(indexHDLD)));
        ngayKTDate.setText(String.valueOf(nktColum.getCellData(indexHDLD)));
    }
    public void edit()
    {
        DatabaseConnectionHDLD connectionNow = new DatabaseConnectionHDLD();
        Connection connectDB = connectionNow.ConnectionDb();
        try
        {
            String value1=maHDText.getText();
            String value2=maNVText.getText();
            String value3= loaiHDText.getText();
            String value4= ngayBDDate.getText();
            String value5= ngayKTDate.getText();
            String sql = "UPDATE hopdonglaodong SET mahd='" + value1 + "',manv='" + value2 +
                       "',loaihd='" + value3 + "',ngaybd='" + value4 + "',ngaykt='" + value5 +
                       "'WHERE mahd= '" + value1 + "'";
            String sql1 = "UPDATE hopdonglaodong SET mahd='" + value1 + "',manv='" + value2 +
                    "',loaihd='" + value3 + "',ngaybd='" + value4 +
                    "'WHERE mahd= '" + value1 + "'and loaihd='Khongthoihan'" ;
            if(value3.equals("Khongthoihan")) {
                PreparedStatement preparedStatement = connectDB.prepareStatement(sql1);
                preparedStatement.execute();
                listHDLD = getHDLD();
                tableHDLD.setItems(listHDLD);
            }
            if(value3.equals("Thoihan") && !value5.isEmpty())
            {
                PreparedStatement preparedStatement1 = connectDB.prepareStatement(sql);
                preparedStatement1.execute();
                listHDLD = getHDLD();
                tableHDLD.setItems(listHDLD);
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
            e.getCause();
        }
    }
    public void delete()
    {
        DatabaseConnectionHDLD connectionNow = new DatabaseConnectionHDLD();
        Connection connectDB = connectionNow.ConnectionDb();
        try
        {
            String value1=maHDText.getText();
            String sql="DELETE FROM hopdonglaodong WHERE mahd= '"+value1+ "'";
            PreparedStatement preparedStatement= connectDB.prepareStatement(sql);
            preparedStatement.execute();
            listHDLD = getHDLD();
            tableHDLD.setItems(listHDLD);
        }
        catch (Exception e)
        {
            e.printStackTrace();
            e.getCause();
        }
    }
    public void cancelButtonOnAction()
    {
        Stage stage = (Stage) cancelBtn.getScene().getWindow();
        stage.close();
    }
    ObservableList<HDLD> dataList = FXCollections.observableArrayList();
    @FXML
    void searchUser()
    {
        mhdColum.setCellValueFactory(new PropertyValueFactory<>("maHD"));
        mnvColum.setCellValueFactory(new PropertyValueFactory<>("maNV"));
        lhdColum.setCellValueFactory(new PropertyValueFactory<>("loaiHD"));
        nbdColum.setCellValueFactory(new PropertyValueFactory<>("ngayBD"));
        nktColum.setCellValueFactory(new PropertyValueFactory<>("ngayKT"));
        dataList = DatabaseConnectionHDLD.getHDLD();
        tableHDLD.setItems(dataList);
        FilteredList<HDLD> filteredData = new FilteredList<>(dataList, b -> true);
        //maNV,name,dob,address,gender,nation,phonenumber,maPB,maCV,maTDHV,bacLuong;

        searchText.textProperty().addListener((observable, oldValue, newValue) -> filteredData.setPredicate(person -> {
            if (newValue == null || newValue.isEmpty()) {
                return true;
            }
            String lowerCaseFilter = newValue.toLowerCase();

            if (person.getMaHD().toLowerCase().contains(lowerCaseFilter)) {
                return true;
            }else
            if (person.getMaNV().toLowerCase().contains(lowerCaseFilter)) {
                return true;
            }else
              return person.getLoaiHD().toLowerCase().contains(lowerCaseFilter);

        }));
        SortedList<HDLD> sortedData = new SortedList<>(filteredData);
        sortedData.comparatorProperty().bind(tableHDLD.comparatorProperty());
        tableHDLD.setItems(sortedData);
    }
}
