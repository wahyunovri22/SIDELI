package creative.can.com.suratpengantar.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by cia on 12/12/2017.
 */

public class DataModel {

    @SerializedName("N_ID")
    @Expose
    private String nID;
    @SerializedName("N_TANGGAL")
    @Expose
    private String nTANGGAL;
    @SerializedName("N_ISI_NEWS")
    @Expose
    private String nISINEWS;
    @SerializedName("N_CREATED_BY")
    @Expose
    private String nCREATEDBY;

    public String getNID() {
        return nID;
    }

    public void setNID(String nID) {
        this.nID = nID;
    }

    public String getNTANGGAL() {
        return nTANGGAL;
    }

    public void setNTANGGAL(String nTANGGAL) {
        this.nTANGGAL = nTANGGAL;
    }

    public String getNISINEWS() {
        return nISINEWS;
    }

    public void setNISINEWS(String nISINEWS) {
        this.nISINEWS = nISINEWS;
    }

    public String getNCREATEDBY() {
        return nCREATEDBY;
    }

    public void setNCREATEDBY(String nCREATEDBY) {
        this.nCREATEDBY = nCREATEDBY;
    }
}
