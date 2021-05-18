package query.MinhQuery.cau10;

public class Class10 {
    private String manv, hoten, macv, tencv;

    public Class10(String manv, String hoten, String macv, String tencv) {
        this.manv = manv;
        this.hoten = hoten;
        this.macv = macv;
        this.tencv = tencv;
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

    public String getMacv() {
        return macv;
    }

    public void setMacv(String macv) {
        this.macv = macv;
    }

    public String getTencv() {
        return tencv;
    }

    public void setTencv(String tencv) {
        this.tencv = tencv;
    }

    @Override
    public String toString() {
        return "class10{" +
                "manv='" + manv + '\'' +
                ", hoten='" + hoten + '\'' +
                ", macv='" + macv + '\'' +
                ", tencv='" + tencv + '\'' +
                '}';
    }
}
