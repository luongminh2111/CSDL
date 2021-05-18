package DAO.controll;
import resource.PhongBan.PB;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DtbPB {
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

    public static ObservableList<PB> getPB()
    {
        DtbPB connectionNow = new DtbPB();
        Connection connectDB = connectionNow.ConnectionDb();
        ObservableList<PB> listPB = FXCollections.observableArrayList();
        try
        {
            PreparedStatement preparedStatement = connectDB.prepareStatement
                    ("SELECT * FROM phongban ");
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next())
            {
                listPB.add(new PB(
                                resultSet.getString("mapb"),
                                resultSet.getString("tenpb"),
                                resultSet.getString("sdtpb"),
                                resultSet.getString("diachipb")));
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
            e.getCause();
        }
        return  listPB;
    }

}
