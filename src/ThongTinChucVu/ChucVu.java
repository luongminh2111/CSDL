package ThongTinChucVu;

public class ChucVu {
    private  String macv,tencv;

    public ChucVu(String macv, String tencv) {
        this.macv = macv;
        this.tencv = tencv;
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
        return "ChucVu{" +
                "macv='" + macv + '\'' +
                ", tencv='" + tencv + '\'' +
                '}';
    }
}
