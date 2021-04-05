package TuanAnhQuery.cau5;

public class class5 {
    private String manv,hoten,matdhv,tentdhv,cnganh;

    public class5(String manv, String hoten, String matdhv, String tentdhv, String cnganh) {
        this.manv = manv;
        this.hoten = hoten;
        this.matdhv = matdhv;
        this.tentdhv = tentdhv;
        this.cnganh = cnganh;
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

    public String getMatdhv() {
        return matdhv;
    }

    public void setMatdhv(String matdhv) {
        this.matdhv = matdhv;
    }

    public String getTentdhv() {
        return tentdhv;
    }

    public void setTentdhv(String tentdhv) {
        this.tentdhv = tentdhv;
    }

    public String getCnganh() {
        return cnganh;
    }

    public void setCnganh(String cnganh) {
        this.cnganh = cnganh;
    }

    @Override
    public String toString() {
        return "class5{" +
                "manv='" + manv + '\'' +
                ", hoten='" + hoten + '\'' +
                ", matdhv='" + matdhv + '\'' +
                ", tentdhv='" + tentdhv + '\'' +
                ", cnganh='" + cnganh + '\'' +
                '}';
    }
}
