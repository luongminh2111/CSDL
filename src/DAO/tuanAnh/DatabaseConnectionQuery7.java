package DAO.tuanAnh;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import query.TuanAnhQuery.cau7.Class7;

import java.sql.*;

public class DatabaseConnectionQuery7 {
    public Connection DatabaseLink;
    public Connection ConnectionDb()
    {
        String DatabaseName="QLNS";
        String DatabaseUser="postgres";
        String Databasepass="luongminh";
        String url= "jdbc:postgresql://localhost:5432/" + DatabaseName;
        try
        {
            Class.forName("org.postgresql.Driver");
            DatabaseLink= DriverManager.getConnection(url,DatabaseUser,Databasepass);

        }catch (Exception e)
        {
            e.printStackTrace();
            e.getCause();
        }
        return DatabaseLink;
    }
    public static ObservableList<Class7> getInf7()
    {
        DatabaseConnectionQuery7 connectionNow = new DatabaseConnectionQuery7();
        Connection connectDB = connectionNow.ConnectionDb();
        ObservableList<Class7> listInf7 = FXCollections.observableArrayList();
        try
        {
            PreparedStatement preparedStatement = connectDB.prepareStatement
                    ("select nv.manv, nv.hoten, nv.ngaysinh,nv.gioitinh, nv.quequan, nv.sdt, pb.tenpb " +
                            "from nhanvien nv, phongban pb " +
                            "where nv.mapb=pb.mapb " +
                            "and pb.tenpb='Kế Toán' and nv.gioitinh='F'");
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next())
            {
                listInf7.add(new Class7(
                        resultSet.getString("manv"),
                        resultSet.getString("hoten"),
                        Date.valueOf(resultSet.getString("ngaysinh")),
                        resultSet.getString("gioitinh"),
                        resultSet.getString("quequan"),
                        resultSet.getString("sdt"),
                        resultSet.getString("tenpb")));

            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
            e.getCause();
        }
        return  listInf7;
    }
}
