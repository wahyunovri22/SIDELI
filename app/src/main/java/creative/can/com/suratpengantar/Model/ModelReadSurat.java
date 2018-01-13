package creative.can.com.suratpengantar.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by cia on 12/12/2017.
 */

public class ModelReadSurat {

    @SerializedName("nik")
    @Expose
    private String nik;
    @SerializedName("nama")
    @Expose
    private String nama;
    //    @SerializedName("pekerjaan")
//    @Expose
//    private String pekerjaan;
//    @SerializedName("tempat_lahir")
//    @Expose
//    private String tempatLahir;
//    @SerializedName("agama")
//    @Expose
//    private String agama;
    @SerializedName("tanggal")
    @Expose
    private String tgl;
    //    @SerializedName("kelamin")
//    @Expose
//    private String kelamin;
    @SerializedName("alamat")
    @Expose
    private String alamat;
    //    @SerializedName("desa")
//    @Expose
//    private String desa;
//    @SerializedName("kampung")
//    @Expose
//    private String kampung;
//    @SerializedName("rt")
//    @Expose
//    private String rt;
//    @SerializedName("rw")
//    @Expose
//    private String rw;
    @SerializedName("surat")
    @Expose
    private String surat;

    @SerializedName("keterangan")
    @Expose
    private String keterangan;

    public String getKeterangan() {
        return keterangan;
    }

    public void setKeterangan(String keterangan) {
        this.keterangan = keterangan;
    }

    public String getNik() {
        return nik;
    }

    public void setNik(String nik) {
        this.nik = nik;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getTgl() {
        return tgl;
    }

    public void setTgl(String tgl) {
        this.tgl = tgl;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getSurat() {
        return surat;
    }

    public void setSurat(String surat) {
        this.surat = surat;
    }
}
