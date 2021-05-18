package DAO.tuanAnh;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import query.TuanAnhQuery.cau10.Class10;

import java.sql.*;

public class DatabaseConnectionQuery10 {
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
    public static ObservableList<Class10> getInf10()
    {
        DatabaseConnectionQuery10 connectionNow = new DatabaseConnectionQuery10();
        Connection connectDB = connectionNow.ConnectionDb();
        ObservableList<Class10> listInf10 = FXCollections.observableArrayList();
        try
        {
            PreparedStatement preparedStatement = connectDB.prepareStatement
                    ("select nv.*, hdld.ngaybd from nhanvien nv, hopdonglaodong hdld\n" +
                            "where nv.manv=hdld.manv and hdld.ngaybd ='2017-12-28'");
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next())
            {
                listInf10.add(new Class10(
                        resultSet.getString("manv"),
                        resultSet.getString("hoten"),
                        Date.valueOf(resultSet.getString("ngaysinh")),
                        resultSet.getString("quequan"),
                        resultSet.getString("gioitinh"),
                        resultSet.getString("dantoc"),
                        resultSet.getString("sdt"),
                        resultSet.getString("mapb"),
                        resultSet.getString("macv"),
                        resultSet.getString("matdhv"),
                        resultSet.getString("bacluong"),
                        Date.valueOf(resultSet.getString("ngaybd"))));
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
            e.getCause();
        }
        return  listInf10;
    }
}
