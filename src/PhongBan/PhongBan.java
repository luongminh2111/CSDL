package PhongBan;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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
import java.sql.SQLException;
import java.util.ResourceBundle;


public class PhongBan implements Initializable {
    @FXML
    private TableView<PB> tablePhongBan;

    @FXML
    private TableColumn<PB, String> maPBColum;

    @FXML
    private TableColumn<PB, String> tenPBColum;

    @FXML
    private TableColumn<PB, String> sdtPBColum;

    @FXML
    private TableColumn<PB, String> diachiPBColum;

    @FXML
    private Button addBtn;

    @FXML
    private Button deleteBtn;

    @FXML
    private Button updateBtn;

    @FXML
    private TextField maPBText;

    @FXML
    private TextField tenPBText;

    @FXML
    private TextField sdtPBText;

    @FXML
    private TextField diachiPBText;

    @FXML
    private Button cancelButton;


    ObservableList<PB> listPB = FXCollections.observableArrayList();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        maPBColum.setCellValueFactory(new PropertyValueFactory<>("mapb"));
        tenPBColum.setCellValueFactory(new PropertyValueFactory<>("tenpb"));
        sdtPBColum.setCellValueFactory(new PropertyValueFactory<>("sdtpb"));
        diachiPBColum.setCellValueFactory(new PropertyValueFactory<>("diachipb"));

        listPB = DatabaseConnectionPB.getPB();
        tablePhongBan.setItems(listPB);
    }
    public void ADD() throws SQLException {
        DatabaseConnectionPB connectionNow = new DatabaseConnectionPB();
        Connection connectDB = connectionNow.ConnectionDb();
        String verify = " INSERT INTO phongban(mapb,tenpb,sdtpb,diachipb) values (?,?,?,?)";
        PreparedStatement preparedStatement = connectDB.prepareStatement(verify);
        try {
            preparedStatement.setString(1,maPBText.getText());
            preparedStatement.setString(2, (tenPBText.getText()));
            preparedStatement.setString(3, (sdtPBText.getText()));
            preparedStatement.setString(4,(diachiPBText.getText()));
            preparedStatement.execute();
            listPB = DatabaseConnectionPB.getPB();
            tablePhongBan.setItems(listPB);

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    int index = -1;
    @FXML
    void getSelectedPB(MouseEvent event){
        index = tablePhongBan.getSelectionModel().getSelectedIndex();
        if(index<-1){
            return;
        }
        maPBText.setText(maPBColum.getCellData(index));
        tenPBText.setText(String.valueOf(tenPBColum.getCellData(index)));
        sdtPBText.setText(String.valueOf(sdtPBColum.getCellData(index)));
        diachiPBText.setText(String.valueOf(diachiPBColum.getCellData(index)));
    }
    public  void edit(){
        DatabaseConnectionPB connectionNow = new DatabaseConnectionPB();
        Connection connectDB = connectionNow.ConnectionDb();
        try{
            String value1=maPBText.getText();
            String value2= (tenPBText.getText());
            String value3= (sdtPBText.getText());
            String value4= (diachiPBText.getText());

            String sql="UPDATE phongban SET  mapb = '"+ value1+"',tenpb = '"
                    +value2+"',sdtpb = '"+value3+"',diachipb ='"+value4+"'WHERE mapb='"+value1+"'";
            PreparedStatement preparedStatement = connectDB.prepareStatement(sql);
            preparedStatement.execute();
            listPB = DatabaseConnectionPB.getPB();
            tablePhongBan.setItems(listPB);
        }
        catch (Exception e)
        {
            e.printStackTrace();
            e.getCause();
        }

    }
    public void delete(){
        DatabaseConnectionPB connectionNow = new DatabaseConnectionPB();
        Connection connectDB = connectionNow.ConnectionDb();
        try{
            String value1=maPBText.getText();
            String value2= (tenPBText.getText());
            String value3= (sdtPBText.getText());
            String value4= (diachiPBText.getText());
            String sql = "DELETE FROM phongban WHERE mapb = '"+value1+"'and tenpb ='"+value2+"'and sdtpb = '"+value3+"'and diachipb='"+value4+"'";
            PreparedStatement preparedStatement = connectDB.prepareStatement(sql);
            preparedStatement.execute();
            listPB = DatabaseConnectionPB.getPB();
            tablePhongBan.setItems(listPB);
        }catch (Exception e)
        {
            e.printStackTrace();
            e.getCause();
        }
    }
    public void cancelButtonOnAction()
    {
        Stage stage = (Stage) cancelButton.getScene().getWindow();
        stage.close();
    }


}
