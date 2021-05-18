package query.TuanAnhQuery.cau6;

public class class6 {
    private String hoten,tencv,tenpb;

    public class6(String hoten, String tencv, String tenpb) {
        this.hoten = hoten;
        this.tencv = tencv;
        this.tenpb = tenpb;
    }

    public String getHoten() {
        return hoten;
    }

    public void setHoten(String hoten) {
        this.hoten = hoten;
    }

    public String getTencv() {
        return tencv;
    }

    public void setTencv(String tencv) {
        this.tencv = tencv;
    }

    public String getTenpb() {
        return tenpb;
    }

    public void setTenpb(String tenpb) {
        this.tenpb = tenpb;
    }

    @Override
    public String toString() {
        return "class6{" +
                "hoten='" + hoten + '\'' +
                ", tencv='" + tencv + '\'' +
                ", tenpb='" + tenpb + '\'' +
                '}';
    }
}
