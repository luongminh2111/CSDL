package HungQuery.cau9;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.*;

public class DatabaseConnectionQuery9 {
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

    public static ObservableList<class9> getInf9()
    {
        DatabaseConnectionQuery9 connectionNow = new DatabaseConnectionQuery9();
        Connection connectDB = connectionNow.ConnectionDb();
        ObservableList<class9> listInf9 = FXCollections.observableArrayList();
        try
        {
            PreparedStatement preparedStatement = connectDB.prepareStatement
                    ("SELECT nv.manv, nv.hoten, nv.ngaysinh,nv.mapb\n" +
                            "from nhanvien nv\n" +
                            "where extract (month from now()) = extract(month from ngaysinh)");
            ResultSet resultSet=preparedStatement.executeQuery();
            while (resultSet.next())
            {
                listInf9.add(new class9(
                        resultSet.getString("manv"),
                        resultSet.getString("hoten"),
                        Date.valueOf(resultSet.getString("ngaysinh")),
                        resultSet.getString("mapb")));
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
            e.getCause();
        }
        return  listInf9;
    }
}
