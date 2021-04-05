package TuanAnhQuery.cau3;

import java.sql.Date;

public class class3 {
    private String manv,hoten;
    private Date ngaysinh;
    private String quequan,sdt;
    private Double salary;

    public class3(String manv, String hoten, Date ngaysinh, String quequan, String sdt, Double salary) {
        this.manv = manv;
        this.hoten = hoten;
        this.ngaysinh = ngaysinh;
        this.quequan = quequan;
        this.sdt = sdt;
        this.salary = salary;
    }

    public String getManv() {
        return manv;
    }

    public void setManv(String manv) {
        this.manv = manv;
    }

    public String getHoten() {
        return hoten;
    }

    public void setHoten(String hoten) {
        this.hoten = hoten;
    }

    public Date getNgaysinh() {
        return ngaysinh;
    }

    public void setNgaysinh(Date ngaysinh) {
        this.ngaysinh = ngaysinh;
    }

    public String getQuequan() {
        return quequan;
    }

    public void setQuequan(String quequan) {
        this.quequan = quequan;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "class3{" +
                "manv='" + manv + '\'' +
                ", hoten='" + hoten + '\'' +
                ", ngaysinh=" + ngaysinh +
                ", quequan='" + quequan + '\'' +
                ", sdt='" + sdt + '\'' +
                ", salary=" + salary +
                '}';
    }
}
