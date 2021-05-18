package resource.PhongBan;

public class PB {
    private String mapb,tenpb,sdtpb,diachipb;

    public PB(String mapb, String tenpb, String sdtpb, String diachipb) {
        this.mapb = mapb;
        this.tenpb = tenpb;
        this.sdtpb = sdtpb;
        this.diachipb = diachipb;
    }

    public String getMapb() {
        return mapb;
    }

    public void setMapb(String mapb) {
        this.mapb = mapb;
    }

    public String getTenpb() {
        return tenpb;
    }

    public void setTenpb(String tenpb) {
        this.tenpb = tenpb;
    }

    public String getSdtpb() {
        return sdtpb;
    }

    public void setSdtpb(String sdtpb) {
        this.sdtpb = sdtpb;
    }

    public String getDiachipb() {
        return diachipb;
    }

    public void setDiachipb(String diachipb) {
        this.diachipb = diachipb;
    }

    @Override
    public String toString() {
        return "PB{" +
                "mapb='" + mapb + '\'' +
                ", tenpb='" + tenpb + '\'' +
                ", sdtpb='" + sdtpb + '\'' +
                ", diachipb='" + diachipb + '\'' +
                '}';
    }
}
