package creative.can.com.suratpengantar.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by cia on 12/12/2017.
 */

public class ResponseModel {
    String kode,pesan;

    @SerializedName("Surat Menunggu Diketahui")
    @Expose
    private List<SuratMenungguDiketahui> suratMenungguDiketahui = null;

    public List<SuratMenungguDiketahui> getSuratMenungguDiketahui() {
        return suratMenungguDiketahui;
    }

    public void setSuratMenungguDiketahui(List<SuratMenungguDiketahui> suratMenungguDiketahui) {
        this.suratMenungguDiketahui = suratMenungguDiketahui;
    }
    @SerializedName("error")
    @Expose
    private Boolean error;
    @SerializedName("error_msg")
    @Expose
    private String errorMsg;

    public Boolean getError() {
        return error;
    }

    public void setError(Boolean error) {
        this.error = error;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    @Expose
    private List<DataModel> news = null;

    public List<DataModel> getNews() {
        return news;
    }

    public void setNews(List<DataModel> news) {
        this.news = news;
    }
    List<ModelReadSurat> surat;

    public List<ModelReadSurat> getSurat() {
        return surat;
    }

    public void setSurat(List<ModelReadSurat> surat) {
        this.surat = surat;
    }


    public String getKode() {
        return kode;
    }

    public void setKode(String kode) {
        this.kode = kode;
    }

    public String getPesan() {
        return pesan;
    }

    public void setPesan(String pesan) {
        this.pesan = pesan;
    }
}
