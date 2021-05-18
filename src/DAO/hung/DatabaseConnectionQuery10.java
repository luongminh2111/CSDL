package DAO.hung;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import query.HungQuery.cau10.Class10;

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
            DatabaseConnectionQuery9 connectionNow = new DatabaseConnectionQuery9();
            Connection connectDB = connectionNow.ConnectionDb();
            ObservableList<Class10> listInf10 = FXCollections.observableArrayList();
            try
            {
                PreparedStatement preparedStatement = connectDB.prepareStatement
                        ("select nv.manv,nv.hoten,nv.quequan,pb.tenpb,tdhv.tentdhv\n" +
                                "from nhanvien nv\n" +
                                "\tinner join phongban pb on nv.mapb = pb.mapb\n" +
                                "\tinner join trinhdohocvan tdhv on nv.matdhv=tdhv.matdhv\n" +
                                "where quequan='vĩnh phúc' and tenpb='Kế Toán' and hoten like 'vũ%' ");
                ResultSet resultSet=preparedStatement.executeQuery();
                while (resultSet.next())
                {
                    listInf10.add(new Class10(
                            resultSet.getString("manv"),
                            resultSet.getString("hoten"),
                            resultSet.getString("quequan"),
                            resultSet.getString("tenpb"),
                            resultSet.getString("tentdhv")));
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
