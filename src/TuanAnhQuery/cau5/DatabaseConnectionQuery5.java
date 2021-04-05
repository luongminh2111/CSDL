package TuanAnhQuery.cau5;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.*;

public class DatabaseConnectionQuery5 {
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
    public static ObservableList<class5> getInf5()
    {
        DatabaseConnectionQuery5 connectionNow = new DatabaseConnectionQuery5();
        Connection connectDB = connectionNow.ConnectionDb();
        ObservableList<class5> listInf5 = FXCollections.observableArrayList();
        try
        {
            PreparedStatement preparedStatement = connectDB.prepareStatement
                    ("SELECT DISTINCT NV.manv, NV.HOTEN,TDHV.* \n" +
                            "FROM NHANVIEN NV, TRINHDOHOCVAN TDHV, THANGTIEN TT \n" +
                            " WHERE NV.MATDHV=TDHV.MATDHV AND TDHV.MATDHV='A00' \n" +
                            "AND NV.MANV NOT IN (SELECT TT.MANV FROM NHANVIEN NV, THANGTIEN TT\n" +
                            "WHERE TT.MANV=NV.MANV AND TT.MACV IN('01','02','03','04') );");
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next())
            {
                listInf5.add(new class5(
                        resultSet.getString("manv"),
                        resultSet.getString("hoten"),
                        resultSet.getString("matdhv"),
                        resultSet.getString("tentdhv"),
                        resultSet.getString("cnganh")));

            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
            e.getCause();
        }
        return  listInf5;
    }
}
