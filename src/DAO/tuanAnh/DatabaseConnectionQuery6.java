package DAO.tuanAnh;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import query.TuanAnhQuery.cau6.class6;

import java.sql.*;

public class DatabaseConnectionQuery6{
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
    public static ObservableList<class6> getInf6()
    {
        DatabaseConnectionQuery6 connectionNow = new DatabaseConnectionQuery6();
        Connection connectDB = connectionNow.ConnectionDb();
        ObservableList<class6> listInf6 = FXCollections.observableArrayList();
        try {
            PreparedStatement preparedStatement = connectDB.prepareStatement
                    ("SELECT nv.hoten, cv.tencv,pb.tenpb\n" +
                            "FROM nhanvien nv, chucvu cv, phongban pb\n" +
                            "WHERE nv.macv=cv.macv AND nv.mapb=pb.mapb\n");
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                listInf6.add(new class6(
                        resultSet.getString("hoten"),
                        resultSet.getString("tencv"),
                        resultSet.getString("tenpb")));
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
            e.getCause();
        }
        return  listInf6;
    }
}
