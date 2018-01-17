package creative.can.com.suratpengantar.helper;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by cia on 19/12/2017.
 */

public class Config {

    public static final String SP_MAHASISWA_APP = "spSurat";

    public static final String SP_NAMA = "spNama";
    public static final String SP_EMAIL = "spEmail";
    public static final String SP_STATUS = "spStatus";
    public static final String SP_STATUS_WARGA = "spStatusWarga";
    public static final String SP_POSISIRT = "sPosisirt";
    public static final String SP_POSISIRW = "sPosisirw";
    public static final String SP_ALAMAT = "sAlamat";
    public static final String SP_TEMPAT_LAHIR = "sTempat";
    public static final String SP_TTL = "sTtl";
    public static final String SP_JK = "jk";
    public static final String SP_AGAMa = "sAgama";
    public static final String SP_PEKERJAAN = "sPekerjaan";
    public static final String SP_NO_KK = "sNoKK";
    public static final String SP_KELURAHAN = "sKelurahan";
    public static final String SP_RT = "sRT";
    public static final String SP_RW = "sRW";
    public static final String SP_KECAMATAN = "sKecamatan";
    public static final String SP_KABUPATEN = "sKabupaten";
    public static final String SP_PROVINSI = "sProvinsi";
    public static final String SP_STATUS_NIKAH = "sStatusNikah";
    public static final String SP_STATUS_KK = "sStatusKK";
    public static final String SP_PENDUDUK = "sPenduduk";
    public static final String SP_PENDIDIKAN = "sPendidikan";
    public static final String SP_ID = "spId";
    public static final String SP_SUDAH_LOGIN = "spSudahLogin";

    SharedPreferences sp;
    SharedPreferences.Editor spEditor;

    public Config (Context context){
        sp = context.getSharedPreferences(SP_MAHASISWA_APP, Context.MODE_PRIVATE);
        spEditor = sp.edit();
    }

    public void saveSPString(String keySP, String value){
        spEditor.putString(keySP, value);
        spEditor.commit();
    }

    public void saveSPInt(String keySP, int value){
        spEditor.putInt(keySP, value);
        spEditor.commit();
    }

    public void saveSPBoolean(String keySP, boolean value){
        spEditor.putBoolean(keySP, value);
        spEditor.commit();
    }

    public String getSPNama(){
        return sp.getString(SP_NAMA, "");
    }

    public  String getSpId() {
        return sp.getString(SP_ID, "");
    }
    public  String getSpStatusWarga() {
        return sp.getString(SP_STATUS_WARGA, "");
    }

    public String getSPEmail(){
        return sp.getString(SP_EMAIL, "");
    }

    public String getSpStatus() {
        return sp.getString(SP_STATUS, "");
    }
    public  String getSpAlamat() {
        return sp.getString(SP_ALAMAT, "");
    }

    public String getSpTempatLahir() {
        return sp.getString(SP_TEMPAT_LAHIR, "");
    }

    public  String getSpTtl() {
        return sp.getString(SP_TTL, "");
    }

    public  String getSP_AGAMa() {
        return sp.getString(SP_AGAMa, "");
    }

    public  String getSpPekerjaan() {
        return sp.getString(SP_PEKERJAAN, "");
    }

    public String getSpNoKk() {
        return sp.getString(SP_NO_KK, "");
    }

    public String getSpKelurahan() {
        return sp.getString(SP_KELURAHAN, "");
    }

    public String getSpRt() {
        return sp.getString(SP_RT, "");
    }

    public String getSpRw() {
        return sp.getString(SP_RW, "");
    }

    public String getSpKecamatan() {
        return sp.getString(SP_KECAMATAN, "");
    }

    public String getSpKabupaten() {
        return sp.getString(SP_KABUPATEN, "");
    }

    public String getSpProvinsi() {
        return sp.getString(SP_PROVINSI, "");
    }

    public String getSpStatusNikah() {
        return sp.getString(SP_STATUS_NIKAH, "");
    }

    public String getSpStatusKk() {
        return sp.getString(SP_STATUS_KK, "");
    }

    public String getSpPendidikan() {
        return sp.getString(SP_PENDIDIKAN, "");
    }

    public String getSpPenduduk() {
        return sp.getString(SP_PENDUDUK, "");
    }

    public String getSpJk() {
        return sp.getString(SP_JK, "");
    }

    public String getSpPosisirt() {
        return sp.getString(SP_POSISIRT, "");
    }
    public String getSpPosisirw() {
        return sp.getString(SP_POSISIRW, "");
    }

    public Boolean getSPSudahLogin() {
        return sp.getBoolean(SP_SUDAH_LOGIN, false);
    }
}
