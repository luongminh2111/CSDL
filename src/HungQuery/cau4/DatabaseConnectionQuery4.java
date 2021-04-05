package HungQuery.cau4;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class DatabaseConnectionQuery4 {
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


     public static ObservableList<class4> getInf4() {
         DatabaseConnectionQuery4 connectionNow = new DatabaseConnectionQuery4();
         Connection connectDB = connectionNow.ConnectionDb();
         ObservableList<class4> listInf4 = FXCollections.observableArrayList();
         try {
             PreparedStatement preparedStatement = connectDB.prepareStatement
                     ("update nhanvien\n" +
                             "set mapb = (select mapb from phongban where tenpb = 'Sản Xuất')\n" +
                             "where nhanvien.manv = '20184033'");
             preparedStatement.execute();

         } catch (Exception e) {
             e.printStackTrace();
             e.getCause();
         }
         return listInf4;
     }
}
