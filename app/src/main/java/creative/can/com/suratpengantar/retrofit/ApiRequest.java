package creative.can.com.suratpengantar.retrofit;

import java.util.ArrayList;

import creative.can.com.suratpengantar.Model.ResponseModel;
import creative.can.com.suratpengantar.Model.RuleModel;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

/**
 * Created by cia on 12/12/2017.
 */

public interface ApiRequest {

//    @GET("readnews.php")
//    Call<ResponseModel> getNews();

    @GET("news.php")
    Call<ResponseModel> getApiNews();

    @FormUrlEncoded
    @POST("insertsurat.php")
    Call<ResponseModel> insertSurat(@Field("S_ID") String S_ID,
                                    @Field("PER_KEPERLUAN") String PER_KEPERLUAN,
                                    @Field("PER_STATUS") String PER_STATUS,
                                    @Field("NIK") String NIK,
                                    @Field("PER_KK") String PER_KK,
                                    @Field("PER_NAMA_WARGA") String PER_NAMA_WARGA,
                                    @Field("PER_TMP_LAHIR") String PER_TMP_LAHIR,
                                    @Field("PER_TGL_LAHIR") String PER_TGL_LAHIR,
                                    @Field("PER_JK") String PER_JK,
                                    @Field("PER_ALAMAT") String PER_ALAMAT,
                                    @Field("PER_RT") String PER_RT,
                                    @Field("PER_RW") String PER_RW,
                                    @Field("PER_KELURAHAN") String PER_KELURAHAN,
                                    @Field("PER_KECAMATAN") String PER_KECAMATAN,
                                    @Field("PER_KABUPATEN") String PER_KABUPATEN,
                                    @Field("PER_PROVINSI") String PER_PROVINSI,
                                    @Field("PER_AGAMA") String PER_AGAMA,
                                    @Field("PER_STATUS_NIKAH") String PER_STATUS_NIKAH,
                                    @Field("PER_STATUS_KK") String PER_STATUS_KK,
                                    @Field("PER_PENDIDIKAN") String PER_PENDIDIKAN,
                                    @Field("PER_PEKERJAAN") String PER_PEKERJAAN,
                                    @Field("PER_STATUS_PENDUDUK") String PER_STATUS_PENDUDUK);

    @FormUrlEncoded
    @POST("suratUsaha.php")
    Call<ResponseModel> insertSuratUsaha(@Field("S_ID") String S_ID,
                                         @Field("PER_KEPERLUAN") String PER_KEPERLUAN,
                                         @Field("PER_STATUS") String PER_STATUS,
                                         @Field("NIK") String NIK,
                                         @Field("PER_KK") String PER_KK,
                                         @Field("PER_NAMA_WARGA") String PER_NAMA_WARGA,
                                         @Field("PER_TMP_LAHIR") String PER_TMP_LAHIR,
                                         @Field("PER_TGL_LAHIR") String PER_TGL_LAHIR,
                                         @Field("PER_JK") String PER_JK,
                                         @Field("PER_ALAMAT") String PER_ALAMAT,
                                         @Field("PER_RT") String PER_RT,
                                         @Field("PER_RW") String PER_RW,
                                         @Field("PER_KELURAHAN") String PER_KELURAHAN,
                                         @Field("PER_KECAMATAN") String PER_KECAMATAN,
                                         @Field("PER_KABUPATEN") String PER_KABUPATEN,
                                         @Field("PER_PROVINSI") String PER_PROVINSI,
                                         @Field("PER_AGAMA") String PER_AGAMA,
                                         @Field("PER_STATUS_NIKAH") String PER_STATUS_NIKAH,
                                         @Field("PER_STATUS_KK") String PER_STATUS_KK,
                                         @Field("PER_PENDIDIKAN") String PER_PENDIDIKAN,
                                         @Field("PER_PEKERJAAN") String PER_PEKERJAAN,
                                         @Field("PER_STATUS_PENDUDUK") String PER_STATUS_PENDUDUK,
                                         @Field("SKU_JNS_USAHA") String SKU_JNS_USAHA,
                                         @Field("SKU_LOKASI_USAHA") String SKU_LOKASI_USAHA);

    @FormUrlEncoded
    @POST("insertwarga.php")
    Call<ResponseModel> insertWarga(@Field("W_NIK") String W_NIK,
                                    @Field("W_KK") String W_KK,
                                    @Field("W_NAMA") String W_NAMA,
                                    @Field("W_TMP_LAHIR") String W_TMP_LAHIR,
                                    @Field("W_TGL_LAHIR") String W_TGL_LAHIR,
                                    @Field("W_JK") String W_JK,
                                    @Field("W_ALAMAT") String W_ALAMAT,
                                    @Field("W_RT") String W_RT,
                                    @Field("W_RW") String PER_RW,
                                    @Field("W_KELURAHAN") String W_KELURAHAN,
                                    @Field("W_KECAMATAN") String W_KECAMATAN,
                                    @Field("W_KABUPATEN") String W_KABUPATEN,
                                    @Field("W_PROVINSI") String W_PROVINSI,
                                    @Field("W_AGAMA") String W_AGAMA,
                                    @Field("W_STATUS") String W_STATUS,
                                    @Field("W_STATUS_KK") String W_STATUS_KK,
                                    @Field("W_PENDIDIKAN") String W_PENDIDIKAN,
                                    @Field("W_PEKERJAAN") String W_PEKERJAAN,
                                    @Field("W_STATUS_PENDUDUK") String W_STATUS_PENDUDUK,
                                    @Field("W_CREATED_BY") String W_CREATED_BY);

    @FormUrlEncoded
    @POST("profil.php")
    Call<ResponseModel> updateProfil(@Field("W_NIK") String W_NIK,
                                     @Field("W_NAMA") String W_NAMA,
                                     @Field("W_ALAMAT") String W_ALAMAT,
                                     @Field("W_TMP_LAHIR") String W_TMP_LAHIR,
                                     @Field("W_TGL_LAHIR") String W_TGL_LAHIR,
                                     @Field("W_PEKERJAAN") String W_PEKERJAAN,
                                     @Field("W_AGAMA") String W_AGAMA);

    @FormUrlEncoded
    @POST("profil2.php")
    Call<ResponseModel> updateProfil2(@Field("U_NIK") String U_NIK,
                                      @Field("U_FULLNAME") String U_FULLNAME);


    @FormUrlEncoded
    @POST("insertuser.php")
    Call<ResponseModel> insertUser(@Field("U_NAME") String U_NAME,
                                   @Field("U_FULLNAME") String U_FULLNAME,
                                   @Field("U_NIK") String U_NIK,
                                   @Field("U_EMAIL") String U_EMAIL,
                                   @Field("U_PASSWORD") String U_PASSWORD,
                                   @Field("U_MOBILE") String U_MOBILE,
                                   @Field("U_GROUP_RULE") String U_GROUP_RULE,
                                   @Field("U_STATUS") String U_STATUS);

    @FormUrlEncoded
    @POST("accept2.php")
    Call<ResponseModel> postSuratMasuk(@Field("PER_ID") String PER_ID,
                                       @Field("PER_STATUS") String PER_STATUS);


    @FormUrlEncoded
    @POST("acceptrt.php")
    Call<ResponseModel> accetptRT(@Field("PER_ID") String PER_ID,
                                  @Field("PER_STATUS") String PER_STATUS,
                                  @Field("PER_ACC_RT") String PER_ACC_RT);

    @FormUrlEncoded
    @POST("acceptrw.php")
    Call<ResponseModel> acceptRW(@Field("PER_ID") String PER_ID,
                                 @Field("PER_STATUS") String PER_STATUS,
                                 @Field("PER_ACC_RW") String PER_ACC_RW);

    @FormUrlEncoded
    @POST("rejectsurat.php")
    Call<ResponseModel> rejectSurat(@Field("PER_ID") String PER_ID,
                                    @Field("PER_STATUS") String PER_STATUS,
                                    @Field("PER_ACC_RT") String PER_ACC_RT);

    @FormUrlEncoded
    @POST("setting.php")
    Call<ResponseModel> updatePassword(@Field("U_NIK") String U_NIK,
                                       @Field("U_PASSWORD") String U_PASSWORD);

    @GET("waitingApproveRt.php")
    Call<ResponseModel> getSurat();

    @GET("waiting.php")
    Call<ResponseModel> getSuratWaiting();

    @GET("history.php")
    Call<ResponseModel> history();

    @GET("waitingApproveRw.php")
    Call<ResponseModel> getSuratRW();

    @GET("reject.php")
    Call<ResponseModel> getDitolak();

    @GET("login.php")
    Call<ArrayList<RuleModel>> getRuleLogin();

//    @FormUrlEncoded
//    @POST("deletert.php")
//    Call<ResponseModel> deleteRT(@Field("nik") String nik);
}

