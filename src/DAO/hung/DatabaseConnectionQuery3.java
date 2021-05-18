package DAO.hung;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import query.HungQuery.cau3.Class3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class DatabaseConnectionQuery3 {
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

    public static ObservableList<Class3> getInf3()
    {
        DatabaseConnectionQuery3 connectionNow = new DatabaseConnectionQuery3();
        Connection connectDB = connectionNow.ConnectionDb();
        ObservableList<Class3> listInf3 = FXCollections.observableArrayList();
        try
        {
            PreparedStatement preparedStatement = connectDB.prepareStatement
                    ("update nhanvien\n" +
                            "set matdhv = (select matdhv from trinhdohocvan where tentdhv = 'Đại Học'and cnganh = 'Kinh Tế'),\n" +
                            "\tbacluong = 'B5'\n" +
                            "where nhanvien.manv = '20184108' ");
            preparedStatement.execute();
        }
        catch (Exception e)
        {
            e.printStackTrace();
            e.getCause();
        }
        return  listInf3;
    }
}
