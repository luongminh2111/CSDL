package DAO.tuanAnh;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import query.TuanAnhQuery.cau8.Class8;

import java.sql.*;

public class DatabaseConnectionQuery8 {
    public Connection DatabaseLink;

    public Connection ConnectionDb() {
        String DatabaseName = "QLNS";
        String DatabaseUser = "postgres";
        String Databasepass = "luongminh";
        String url = "jdbc:postgresql://localhost:5432/" + DatabaseName;
        try {
            Class.forName("org.postgresql.Driver");
            DatabaseLink = DriverManager.getConnection(url, DatabaseUser, Databasepass);

        } catch (Exception e) {
            e.printStackTrace();
            e.getCause();
        }
        return DatabaseLink;
    }
    public static ObservableList<Class8> getInf8()
    {
        DatabaseConnectionQuery8 connectionNow = new DatabaseConnectionQuery8();
        Connection connectDB = connectionNow.ConnectionDb();
        ObservableList<Class8> listInf8 = FXCollections.observableArrayList();
        try
        {
            PreparedStatement preparedStatement = connectDB.prepareStatement
                    ("select nv.manv,nv.hoten,nv.ngaysinh,nv.quequan,nv.sdt,nv.bacluong\n" +
                            "from nhanvien nv\n" +
                            "where nv.bacluong = 'B6'\n" +
                            "group by nv.manv,nv.hoten,nv.ngaysinh,nv.quequan,nv.sdt,nv.bacluong\n" +
                            "order by ngaysinh desc limit(5)");
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next())
            {
                listInf8.add(new Class8(
                        resultSet.getString("manv"),
                        resultSet.getString("hoten"),
                        Date.valueOf(resultSet.getString("ngaysinh")),
                        resultSet.getString("quequan"),
                        resultSet.getString("sdt"),
                        resultSet.getString("bacluong")));
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
            e.getCause();
        }
        return  listInf8;
    }
}
