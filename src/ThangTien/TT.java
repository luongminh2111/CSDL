package ThangTien;

import java.sql.Date;

public class TT {
    private String manv,macv,mapb;
    private Date ngaytiepnhan, ngayketthuc;
    private Integer stt;

    public TT(String manv, String macv, String mapb, Date ngaytiepnhan, Date ngayketthuc, Integer stt) {
        this.manv = manv;
        this.macv = macv;
        this.mapb = mapb;
        this.ngaytiepnhan = ngaytiepnhan;
        this.ngayketthuc = ngayketthuc;
        this.stt = stt;
    }

    public String getManv() {
        return manv;
    }

    public void setManv(String manv) {
        this.manv = manv;
    }

    public String getMacv() {
        return macv;
    }

    public void setMacv(String macv) {
        this.macv = macv;
    }

    public String getMapb() {
        return mapb;
    }

    public void setMapb(String mapb) {
        this.mapb = mapb;
    }

    public Date getNgaytiepnhan() {
        return ngaytiepnhan;
    }

    public void setNgaytiepnhan(Date ngaytiepnhan) {
        this.ngaytiepnhan = ngaytiepnhan;
    }

    public Date getNgayketthuc() {
        return ngayketthuc;
    }

    public void setNgayketthuc(Date ngayketthuc) {
        this.ngayketthuc = ngayketthuc;
    }

    public Integer getStt() {
        return stt;
    }

    public void setStt(Integer stt) {
        this.stt = stt;
    }

    @Override
    public String toString() {
        return "TT{" +
                "manv='" + manv + '\'' +
                ", macv='" + macv + '\'' +
                ", mapb='" + mapb + '\'' +
                ", ngaytiepnhan=" + ngaytiepnhan +
                ", ngayketthuc=" + ngayketthuc +
                ", stt=" + stt +
                '}';
    }
}
