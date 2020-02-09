package sample.rv;

public class Creneau {

    private int  HDebut;
    private int MDebut;
    private int HFin;
    private int MFin;
    private String Verstion;

    public Creneau(int HDebut, int MDebut, int HFin, int MFin, String verstion) {
        this.HDebut = HDebut;
        this.MDebut = MDebut;
        this.HFin = HFin;
        this.MFin = MFin;
        Verstion = verstion;
    }

    public int getHdebut() {
        return HDebut;
    }

    public void setHDebut(int HDebut) {
        this.HDebut = HDebut;
    }

    public int getMdebut() {
        return MDebut;
    }

    public void setMDebut(int MDebut) {
        this.MDebut = MDebut;
    }

    public int getHfin() {
        return HFin;
    }

    public void setHFin(int HFin) {
        this.HFin = HFin;
    }

    public int getMfin() {
        return MFin;
    }

    public void setMFin(int MFin) {
        this.MFin = MFin;
    }

    public String getVersion() {
        return Verstion;
    }

    public void setVerstion(String verstion) {
        Verstion = verstion;
    }
}
