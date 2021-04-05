package NhanVien;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import sample.DatabaseConnection;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ThemThongTinNhanVien {
    @FXML
    private TextField mnvText;

    @FXML
    private TextField nsText;

    @FXML
    private TextField htText;

    @FXML
    private TextField qqText;

    @FXML
    private TextField gtText;

    @FXML
    private TextField dtText;

    @FXML
    private TextField sdtText;

    @FXML
    private TextField mpbText;

    @FXML
    private TextField mcvText;

    @FXML
    private TextField mtdhvText;

    @FXML
    private TextField blText;

    @FXML
    private TextField mhdText;

    @FXML
    private TextField lhdText;

    @FXML
    private  TextField nbdText;

    @FXML
    private  TextField nktText;

    @FXML
    private TextField lcbText;

    @FXML
    private TextField hslText;

    @FXML
    private TextField hspcText;

    @FXML
    private Button addButton;

    @FXML
    private Button cancelButton;

    @FXML
    private Text Acount1;

    @FXML
    private Text Acount2;

    @FXML
    private Text Acount3;

    public void ADD() throws SQLException {
        DatabaseConnection connectionNow = new DatabaseConnection();
        Connection connectDB = connectionNow.ConnectionDb();
        if(mnvText.getText().isEmpty() || htText.getText().isEmpty() || nsText.getText().isEmpty()
        || qqText.getText().isEmpty() || gtText.getText().isEmpty() || dtText.getText().isEmpty()
        ||sdtText.getText().isEmpty() || mpbText.getText().isEmpty() || mcvText.getText().isEmpty()
        || mtdhvText.getText().isEmpty() || blText.getText().isEmpty() ) {
            Acount1.setText("bạn chưa nhập đủ thông tin");
        }
        else
            {
            String verify1 = " INSERT INTO nhanvien(manv, hoten, ngaysinh, quequan, gioitinh, dantoc, sdt, mapb, macv, matdhv, bacLuong) values(?,?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement preparedStatement1 = connectDB.prepareStatement(verify1);
            try {
                preparedStatement1.setString(1, mnvText.getText());
                preparedStatement1.setString(2, htText.getText());
                preparedStatement1.setDate(3, Date.valueOf(nsText.getText()));
                preparedStatement1.setString(4, qqText.getText());
                preparedStatement1.setString(5, gtText.getText());
                preparedStatement1.setString(6, dtText.getText());
                preparedStatement1.setString(7, sdtText.getText());
                preparedStatement1.setString(8, mpbText.getText());
                preparedStatement1.setString(9, mcvText.getText());
                preparedStatement1.setString(10, mtdhvText.getText());
                preparedStatement1.setString(11, blText.getText());
                preparedStatement1.execute();

            } catch (Exception e) {
                e.printStackTrace();
                e.getCause();
            }
        }
        if(mhdText.getText().isEmpty() || mnvText.getText().isEmpty() || lhdText.getText().isEmpty()
                || nbdText.getText().isEmpty()  ){
            Acount2.setText("bạn chưa nhập đủ thông tin");
        }
        else {
            if(!nktText.getText().isEmpty()) {
                String verify2 = " INSERT INTO hopdonglaodong(mahd, manv, loaihd, ngaybd, ngaykt)values(?,?,?,?,?)";
                PreparedStatement preparedStatement2 = connectDB.prepareStatement(verify2);
                try {
                    preparedStatement2.setString(1, mhdText.getText());
                    preparedStatement2.setString(2, mnvText.getText());
                    preparedStatement2.setString(3, lhdText.getText());
                    preparedStatement2.setDate(4, Date.valueOf(nbdText.getText()));
                    preparedStatement2.setDate(5, Date.valueOf(nktText.getText()));
                    preparedStatement2.execute();
                } catch (Exception e) {
                    e.printStackTrace();
                    e.getCause();
                }
            }
            else {
                String verify3 = " INSERT INTO hopdonglaodong(mahd, manv, loaihd, ngaybd)values(?,?,?,?)";
                PreparedStatement preparedStatement3 = connectDB.prepareStatement(verify3);
                try {
                    preparedStatement3.setString(1, mhdText.getText());
                    preparedStatement3.setString(2, mnvText.getText());
                    preparedStatement3.setString(3, lhdText.getText());
                    preparedStatement3.setDate(4, Date.valueOf(nbdText.getText()));
                    preparedStatement3.execute();
                } catch (Exception e) {
                    e.printStackTrace();
                    e.getCause();
                }

            }
        }

        if(blText.getText().isEmpty() && lcbText.getText().isEmpty() && hslText.getText().isEmpty() && hspcText.getText().isEmpty()) {
            String verify4 = " INSERT INTO luong(bacluong, luongcb, hsluong, hsphucap)values(?,?,?,?)";
            PreparedStatement preparedStatement4 = connectDB.prepareStatement(verify4);
            try {
                preparedStatement4.setString(1, blText.getText());
                preparedStatement4.setDouble(2, Double.parseDouble(lcbText.getText()));
                preparedStatement4.setDouble(3, Double.parseDouble(hslText.getText()));
                preparedStatement4.setDouble(4, Double.parseDouble(hspcText.getText()));
                preparedStatement4.execute();
            } catch (Exception e) {
                e.printStackTrace();
                e.getCause();
            }
        }
        if(Acount1.getText().isEmpty() && Acount2.getText().isEmpty()) {
            Acount3.setText("THÊM THÀNH CÔNG");
        }
    }
    public void cancelButtonOnAction()
    {
        Stage stage = (Stage) cancelButton.getScene().getWindow();
        stage.close();
    }

}
