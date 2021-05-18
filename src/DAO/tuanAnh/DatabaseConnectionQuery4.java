package DAO.tuanAnh;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import query.TuanAnhQuery.cau4.Class4;

import java.sql.*;

public class DatabaseConnectionQuery4 {
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
    public static ObservableList<Class4> getInf4()
    {
        DatabaseConnectionQuery4 connectionNow = new DatabaseConnectionQuery4();
        Connection connectDB = connectionNow.ConnectionDb();
        ObservableList<Class4> listInf4 = FXCollections.observableArrayList();
        try
        {
            PreparedStatement preparedStatement = connectDB.prepareStatement
                    ("DELETE FROM thangtien\n" +
                            "WHERE EXISTS(SELECT nv.manv  FROM nhanvien nv\n" +
                            " WHERE nv.manv= thangtien.manv AND nv.hoten='Phạm Diễm Quỳnh')");
            PreparedStatement preparedStatement1=connectDB.prepareStatement(
                    "DELETE FROM hopdonglaodong\n" +
                    "WHERE EXISTS(SELECT nv.manv  FROM nhanvien nv\n" +
                    "WHERE nv.manv= hopdonglaodong.manv AND nv.hoten='Phạm Diễm Quỳnh')");
            PreparedStatement preparedStatement2=connectDB.prepareStatement(
                    "DELETE FROM nhanvien WHERE hoten='Phạm Diễm Quỳnh'");
            preparedStatement.execute();
            preparedStatement1.execute();
            preparedStatement2.execute();
        }
        catch (Exception e)
        {
            e.printStackTrace();
            e.getCause();
        }
        return  listInf4;
    }
}
