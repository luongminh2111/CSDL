package DAO.tuanAnh;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import query.TuanAnhQuery.cau3.Class3;

import java.sql.*;

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
                    ("SELECT NV.MANV,NV.HOTEN,NV.ngaysinh,NV.quequan,NV.SDT,(L.luongcb*L.hsluong*(1+L.hsphucap)) AS SALARY " +
                            "FROM NHANVIEN NV, LUONG AS L,PHONGBAN PB " +
                            "WHERE PB.MAPB = NV.MAPB AND PB.MAPB='101' " +
                            "AND NV.BACLUONG = L.BACLUONG " +
                            "GROUP BY NV.MANV,NV.HOTEN,NV.ngaysinh,NV.quequan,NV.SDT,SALARY " +
                            "ORDER BY SALARY DESC\n" +
                            "\n");
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next())
            {
                listInf3.add(new Class3(
                        resultSet.getString("manv"),
                        resultSet.getString("hoten"),
                        Date.valueOf(resultSet.getString("ngaysinh")),
                        resultSet.getString("quequan"),
                        resultSet.getString("sdt"),
                        Double.valueOf(resultSet.getString("salary"))));
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
            e.getCause();
        }
        return  listInf3;
    }
}
