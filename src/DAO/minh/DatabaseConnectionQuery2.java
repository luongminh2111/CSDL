package DAO.minh;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import query.MinhQuery.cau2.Class2;

import java.sql.*;

public class DatabaseConnectionQuery2 {
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

    public static ObservableList<Class2> getInf2()
    {
        DatabaseConnectionQuery1 connectionNow = new DatabaseConnectionQuery1();
        Connection connectDB = connectionNow.ConnectionDb();
        ObservableList<Class2> listInf2 = FXCollections.observableArrayList();
        try
        {
            PreparedStatement preparedStatement = connectDB.prepareStatement
                    ("SELECT nv.manv,nv.hoten,nv.ngaysinh,nv.quequan,nv.gioitinh,nv.dantoc,nv.sdt,hdld.ngaybd" +
                            " FROM nhanvien nv,hopdonglaodong hdld" +
                            " WHERE nv.manv=hdld.manv AND EXTRACT(YEAR FROM hdld.ngaybd)='2020'");
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next())
            {
                listInf2.add(new Class2(
                        resultSet.getString("manv"),
                        resultSet.getString("hoten"),
                        resultSet.getString("ngaysinh"),
                        resultSet.getString("quequan"),
                        resultSet.getString("gioitinh"),
                        resultSet.getString("dantoc"),
                        resultSet.getString("sdt"),
                        Date.valueOf(resultSet.getString("ngaybd"))));
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
            e.getCause();
        }
        return  listInf2;
    }

}

