package TuanAnhQuery.cau2;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

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

    public static ObservableList<class2> getInf2()
    {
        DatabaseConnectionQuery2 connectionNow = new DatabaseConnectionQuery2();
        Connection connectDB = connectionNow.ConnectionDb();
        ObservableList<class2> listInf2 = FXCollections.observableArrayList();
        try {
            PreparedStatement preparedStatement = connectDB.prepareStatement
                    ("UPDATE luong SET luongcb=luongcb*0.9 ");
            preparedStatement.execute();
        }
        catch (Exception e)
        {
            e.printStackTrace();
            e.getCause();
        }
        return  listInf2;
    }
}
