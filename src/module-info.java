module A {
    requires javafx.graphics;
    requires javafx.fxml;
    requires javafx.controls;
    requires java.sql;
    requires org.postgresql.jdbc;
    opens DAO.controll;
    opens DAO.hung;
    opens DAO.minh;
    opens DAO.tuanAnh;
    opens Display.controll;
    opens Display.Hung;
    opens Display.Minh;
    opens Display.TuanAnh;
    opens resource.Login;
    opens resource.BangLuong;
    opens resource.HopDongLaoDong;
    opens resource.NhanVien;
    opens resource.QuanLi;
    opens resource.ThongTinChucVu;
    opens resource.TrinhDoNhanVien;
    opens resource.ThangTien;
    opens resource.PhongBan;
    opens query.MinhQuery.cau1;
    opens query.MinhQuery.cau2;
    opens query.MinhQuery.cau3;
    opens query.MinhQuery.cau4;
    opens query.MinhQuery.cau5;
    opens query.MinhQuery.cau6;
    opens query.MinhQuery.cau7;
    opens query.MinhQuery.cau8;
    opens query.MinhQuery.cau9;
    opens query.MinhQuery.cau10;
    opens query.HungQuery.cau1;
    opens query.HungQuery.cau2;
    opens query.HungQuery.cau3;
    opens query.HungQuery.cau4;
    opens query.HungQuery.cau5;
    opens query.HungQuery.cau6;
    opens query.HungQuery.cau7;
    opens query.HungQuery.cau8;
    opens query.HungQuery.cau9;
    opens query.HungQuery.cau10;
    opens query.TuanAnhQuery.cau1;
    opens query.TuanAnhQuery.cau2;
    opens query.TuanAnhQuery.cau3;
    opens query.TuanAnhQuery.cau4;
    opens query.TuanAnhQuery.cau5;
    opens query.TuanAnhQuery.cau6;
    opens query.TuanAnhQuery.cau7;
    opens query.TuanAnhQuery.cau8;
    opens query.TuanAnhQuery.cau9;
    opens query.TuanAnhQuery.cau10;
}