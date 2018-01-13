package creative.can.com.suratpengantar.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by cia on 15/12/2017.
 */

public class RuleModel {

    @SerializedName("ID_USER")
    @Expose
    private String iDUSER;
    @SerializedName("U_NAME")
    @Expose
    private String uNAME;
    @SerializedName("U_FULLNAME")
    @Expose
    private String uFULLNAME;
    @SerializedName("U_NIK")
    @Expose
    private String uNIK;
    @SerializedName("U_EMAIL")
    @Expose
    private String uEMAIL;
    @SerializedName("U_PASSWORD")
    @Expose
    private String uPASSWORD;
    @SerializedName("U_MOBILE")
    @Expose
    private String uMOBILE;
    @SerializedName("U_P_ID")
    @Expose
    private Object uPID;
    @SerializedName("U_GROUP_RULE")
    @Expose
    private String uGROUPRULE;
    @SerializedName("U_POSISI")
    @Expose
    private String uPOSISI;
    @SerializedName("U_WARGA_ID")
    @Expose
    private Object uWARGAID;
    @SerializedName("U_STATUS")
    @Expose
    private String uSTATUS;
    @SerializedName("U_CREATED_AT")
    @Expose
    private String uCREATEDAT;
    @SerializedName("U_UPDATED_AT")
    @Expose
    private String uUPDATEDAT;
    @SerializedName("ID_WARGA")
    @Expose
    private String iDWARGA;
    @SerializedName("W_NIK")
    @Expose
    private String wNIK;
    @SerializedName("W_KK")
    @Expose
    private String wKK;
    @SerializedName("W_NAMA")
    @Expose
    private String wNAMA;
    @SerializedName("W_TMP_LAHIR")
    @Expose
    private String wTMPLAHIR;
    @SerializedName("W_TGL_LAHIR")
    @Expose
    private String wTGLLAHIR;
    @SerializedName("W_JK")
    @Expose
    private String wJK;
    @SerializedName("W_ALAMAT")
    @Expose
    private String wALAMAT;
    @SerializedName("W_RT")
    @Expose
    private String wRT;
    @SerializedName("W_RW")
    @Expose
    private String wRW;
    @SerializedName("W_KELURAHAN")
    @Expose
    private String wKELURAHAN;
    @SerializedName("W_KECAMATAN")
    @Expose
    private String wKECAMATAN;
    @SerializedName("W_KABUPATEN")
    @Expose
    private String wKABUPATEN;
    @SerializedName("W_PROVINSI")
    @Expose
    private String wPROVINSI;
    @SerializedName("W_AGAMA")
    @Expose
    private String wAGAMA;
    @SerializedName("W_STATUS")
    @Expose
    private String wSTATUS;
    @SerializedName("W_STATUS_KK")
    @Expose
    private String wSTATUSKK;
    @SerializedName("W_PENDIDIKAN")
    @Expose
    private String wPENDIDIKAN;
    @SerializedName("W_PEKERJAAN")
    @Expose
    private String wPEKERJAAN;
    @SerializedName("W_STATUS_PENDUDUK")
    @Expose
    private String wSTATUSPENDUDUK;
    @SerializedName("W_CREATED_BY")
    @Expose
    private String wCREATEDBY;
    @SerializedName("W_CREATED_AT")
    @Expose
    private String wCREATEDAT;
    @SerializedName("W_UPDATE_AT")
    @Expose
    private String wUPDATEAT;

    public String getIDUSER() {
        return iDUSER;
    }

    public void setIDUSER(String iDUSER) {
        this.iDUSER = iDUSER;
    }

    public String getUNAME() {
        return uNAME;
    }

    public void setUNAME(String uNAME) {
        this.uNAME = uNAME;
    }

    public String getUFULLNAME() {
        return uFULLNAME;
    }

    public void setUFULLNAME(String uFULLNAME) {
        this.uFULLNAME = uFULLNAME;
    }

    public String getUNIK() {
        return uNIK;
    }

    public void setUNIK(String uNIK) {
        this.uNIK = uNIK;
    }

    public String getUEMAIL() {
        return uEMAIL;
    }

    public void setUEMAIL(String uEMAIL) {
        this.uEMAIL = uEMAIL;
    }

    public String getUPASSWORD() {
        return uPASSWORD;
    }

    public void setUPASSWORD(String uPASSWORD) {
        this.uPASSWORD = uPASSWORD;
    }

    public String getUMOBILE() {
        return uMOBILE;
    }

    public void setUMOBILE(String uMOBILE) {
        this.uMOBILE = uMOBILE;
    }

    public Object getUPID() {
        return uPID;
    }

    public void setUPID(Object uPID) {
        this.uPID = uPID;
    }

    public String getUGROUPRULE() {
        return uGROUPRULE;
    }

    public void setUGROUPRULE(String uGROUPRULE) {
        this.uGROUPRULE = uGROUPRULE;
    }

    public String getUPOSISI() {
        return uPOSISI;
    }

    public void setUPOSISI(String uPOSISI) {
        this.uPOSISI = uPOSISI;
    }

    public Object getUWARGAID() {
        return uWARGAID;
    }

    public void setUWARGAID(Object uWARGAID) {
        this.uWARGAID = uWARGAID;
    }

    public String getUSTATUS() {
        return uSTATUS;
    }

    public void setUSTATUS(String uSTATUS) {
        this.uSTATUS = uSTATUS;
    }

    public String getUCREATEDAT() {
        return uCREATEDAT;
    }

    public void setUCREATEDAT(String uCREATEDAT) {
        this.uCREATEDAT = uCREATEDAT;
    }

    public String getUUPDATEDAT() {
        return uUPDATEDAT;
    }

    public void setUUPDATEDAT(String uUPDATEDAT) {
        this.uUPDATEDAT = uUPDATEDAT;
    }

    public String getIDWARGA() {
        return iDWARGA;
    }

    public void setIDWARGA(String iDWARGA) {
        this.iDWARGA = iDWARGA;
    }

    public String getWNIK() {
        return wNIK;
    }

    public void setWNIK(String wNIK) {
        this.wNIK = wNIK;
    }

    public String getWKK() {
        return wKK;
    }

    public void setWKK(String wKK) {
        this.wKK = wKK;
    }

    public String getWNAMA() {
        return wNAMA;
    }

    public void setWNAMA(String wNAMA) {
        this.wNAMA = wNAMA;
    }

    public String getWTMPLAHIR() {
        return wTMPLAHIR;
    }

    public void setWTMPLAHIR(String wTMPLAHIR) {
        this.wTMPLAHIR = wTMPLAHIR;
    }

    public String getWTGLLAHIR() {
        return wTGLLAHIR;
    }

    public void setWTGLLAHIR(String wTGLLAHIR) {
        this.wTGLLAHIR = wTGLLAHIR;
    }

    public String getWJK() {
        return wJK;
    }

    public void setWJK(String wJK) {
        this.wJK = wJK;
    }

    public String getWALAMAT() {
        return wALAMAT;
    }

    public void setWALAMAT(String wALAMAT) {
        this.wALAMAT = wALAMAT;
    }

    public String getWRT() {
        return wRT;
    }

    public void setWRT(String wRT) {
        this.wRT = wRT;
    }

    public String getWRW() {
        return wRW;
    }

    public void setWRW(String wRW) {
        this.wRW = wRW;
    }

    public String getWKELURAHAN() {
        return wKELURAHAN;
    }

    public void setWKELURAHAN(String wKELURAHAN) {
        this.wKELURAHAN = wKELURAHAN;
    }

    public String getWKECAMATAN() {
        return wKECAMATAN;
    }

    public void setWKECAMATAN(String wKECAMATAN) {
        this.wKECAMATAN = wKECAMATAN;
    }

    public String getWKABUPATEN() {
        return wKABUPATEN;
    }

    public void setWKABUPATEN(String wKABUPATEN) {
        this.wKABUPATEN = wKABUPATEN;
    }

    public String getWPROVINSI() {
        return wPROVINSI;
    }

    public void setWPROVINSI(String wPROVINSI) {
        this.wPROVINSI = wPROVINSI;
    }

    public String getWAGAMA() {
        return wAGAMA;
    }

    public void setWAGAMA(String wAGAMA) {
        this.wAGAMA = wAGAMA;
    }

    public String getWSTATUS() {
        return wSTATUS;
    }

    public void setWSTATUS(String wSTATUS) {
        this.wSTATUS = wSTATUS;
    }

    public String getWSTATUSKK() {
        return wSTATUSKK;
    }

    public void setWSTATUSKK(String wSTATUSKK) {
        this.wSTATUSKK = wSTATUSKK;
    }

    public String getWPENDIDIKAN() {
        return wPENDIDIKAN;
    }

    public void setWPENDIDIKAN(String wPENDIDIKAN) {
        this.wPENDIDIKAN = wPENDIDIKAN;
    }

    public String getWPEKERJAAN() {
        return wPEKERJAAN;
    }

    public void setWPEKERJAAN(String wPEKERJAAN) {
        this.wPEKERJAAN = wPEKERJAAN;
    }

    public String getWSTATUSPENDUDUK() {
        return wSTATUSPENDUDUK;
    }

    public void setWSTATUSPENDUDUK(String wSTATUSPENDUDUK) {
        this.wSTATUSPENDUDUK = wSTATUSPENDUDUK;
    }

    public String getWCREATEDBY() {
        return wCREATEDBY;
    }

    public void setWCREATEDBY(String wCREATEDBY) {
        this.wCREATEDBY = wCREATEDBY;
    }

    public String getWCREATEDAT() {
        return wCREATEDAT;
    }

    public void setWCREATEDAT(String wCREATEDAT) {
        this.wCREATEDAT = wCREATEDAT;
    }

    public String getWUPDATEAT() {
        return wUPDATEAT;
    }

    public void setWUPDATEAT(String wUPDATEAT) {
        this.wUPDATEAT = wUPDATEAT;
    }
}
