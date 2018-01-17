package creative.can.com.suratpengantar;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.rengwuxian.materialedittext.MaterialEditText;

import java.util.ArrayList;

import creative.can.com.suratpengantar.Activity.DaftarWargaActivity;
import creative.can.com.suratpengantar.Activity.UserActivity;
import creative.can.com.suratpengantar.ActivityRT.HomeRTctivity;
import creative.can.com.suratpengantar.ActivityRW.HomeRWActivity;
import creative.can.com.suratpengantar.Model.ResponseModel;
import creative.can.com.suratpengantar.Model.RuleModel;
import creative.can.com.suratpengantar.helper.Config;
import creative.can.com.suratpengantar.retrofit.ApiRequest;
import creative.can.com.suratpengantar.retrofit.RetrofitConfig;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {

    private Button mBtnLogin;
    private TextView txtDaftar;
    private MaterialEditText edtUsername;
    private MaterialEditText edtPassword;

    private ArrayList<RuleModel> list;
    private String rulestatus, username, password,id,nama,status,posisiRT,posisiRW,alamat,tempat_lahir,ttl,agama,pekerjaan,
    kk,kelurahan,rt,rw,kecamatan,kabupaten,provinsi,status_nikah,status_kk,pendidikan,jk;
    Config config;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initView();

        list = new ArrayList<>();
        config = new Config(this);

        if (config.getSPSudahLogin() && config.getSpStatus().equalsIgnoreCase("U_WARGA")){
            startActivity(new Intent(LoginActivity.this, UserActivity.class)
                    .addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK));
            finish();
        } else if (config.getSPSudahLogin() && config.getSpStatus().equalsIgnoreCase("U_RT")) {
            startActivity(new Intent(LoginActivity.this, HomeRTctivity.class)
                    .addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK));
            finish();
        }else if (config.getSPSudahLogin() && config.getSpStatus().equalsIgnoreCase("U_RW")) {
            startActivity(new Intent(LoginActivity.this, HomeRWActivity.class)
                    .addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK));
            finish();
        }


        mBtnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (edtUsername.getText().toString().isEmpty()){
                    edtUsername.setError("Isi Username");
                } else if (edtPassword.getText().toString().isEmpty()) {
                    edtPassword.setError("Isi Password");
                }else if (edtUsername.length() < 16){
                    edtUsername.setError("nik anda kurang harus 16 digit");
                } else {
                    Login();
                }
            }
        });
        txtDaftar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), DaftarWargaActivity.class);
                startActivity(intent);
            }
        });
    }
    public void Login(){
            final ProgressDialog loading = ProgressDialog.show(LoginActivity.this, "Loading", "Harap tunggu...", false, false);
            ApiRequest api = RetrofitConfig.getRetrofit().create(ApiRequest.class);
            retrofit2.Call<ArrayList<RuleModel>> call = api.getRuleLogin();
            call.enqueue(new Callback<ArrayList<RuleModel>>() {
                @Override
                public void onResponse(Call<ArrayList<RuleModel>> call, Response<ArrayList<RuleModel>> response) {
                    list = response.body();
                    for (final RuleModel s : list){
                        rulestatus = s.getUGROUPRULE();
                        username = s.getUNIK();
                        password = s.getUPASSWORD();
                        id = s.getWNIK();
                        nama = s.getWNAMA();
                        alamat = s.getWALAMAT();
                        tempat_lahir = s.getWTMPLAHIR();
                        ttl = s.getWTGLLAHIR();
                        jk = s.getWJK();
                        pekerjaan = s.getWPEKERJAAN();
                        agama = s.getWAGAMA();
                        status = s.getUSTATUS();
                        posisiRT = s.getWRT();
                        posisiRW = s.getWRW();
                        kk = s.getWKK();
                        kelurahan = s.getWKELURAHAN();
                        rt = s.getWRT();
                        rw = s.getWRW();
                        kecamatan = s.getWKECAMATAN();
                        kabupaten = s.getWKABUPATEN();
                        provinsi = s.getWPROVINSI();
                        status_nikah = s.getWSTATUS();
                        status_kk = s.getWSTATUSKK();
                        pendidikan = s.getWPENDIDIKAN();
                        if (edtUsername.getText().toString().equalsIgnoreCase(username) &&
                                edtPassword.getText().toString().equalsIgnoreCase(password) && status.equalsIgnoreCase("1")) {
                            if (rulestatus.equalsIgnoreCase("U_WARGA")) {
                                config.saveSPString(config.SP_EMAIL, username);
                                config.saveSPString(config.SP_STATUS, rulestatus);
                                config.saveSPString(config.SP_ID, id);
                                config.saveSPString(config.SP_NAMA, nama);
                                config.saveSPString(config.SP_ALAMAT, alamat);
                                config.saveSPString(config.SP_TEMPAT_LAHIR, tempat_lahir);
                                config.saveSPString(config.SP_TTL, ttl);
                                config.saveSPString(config.SP_PEKERJAAN, pekerjaan);
                                config.saveSPString(config.SP_AGAMa, agama);
                                config.saveSPString(config.SP_NO_KK, kk);
                                config.saveSPString(config.SP_KELURAHAN, kelurahan);
                                config.saveSPString(config.SP_RT, rt);
                                config.saveSPString(config.SP_RW, rw);
                                config.saveSPString(config.SP_JK, jk);
                                config.saveSPString(config.SP_KECAMATAN, kecamatan);
                                config.saveSPString(config.SP_KABUPATEN, kabupaten);
                                config.saveSPString(config.SP_PROVINSI, provinsi);
                                config.saveSPString(config.SP_STATUS_NIKAH, status_nikah);
                                config.saveSPString(config.SP_STATUS_KK, status_kk);
                                config.saveSPString(config.SP_PENDIDIKAN, pendidikan);
                                // Shared Pref ini berfungsi untuk menjadi trigger session login
                                config.saveSPBoolean(config.SP_SUDAH_LOGIN, true);
                                Intent intent = new Intent(getApplicationContext(), UserActivity.class)
                                        .addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
                                intent.putExtra("nama", nama);
                                intent.putExtra("id", id);
                                startActivity(intent);
                                finish();
                            } else if (rulestatus.equalsIgnoreCase("U_RT")) {
                                config.saveSPString(config.SP_EMAIL, username);
                                config.saveSPString(config.SP_STATUS, rulestatus);
                                config.saveSPString(config.SP_ID, id);
                                config.saveSPString(config.SP_NAMA, nama);
                                config.saveSPString(config.SP_POSISIRT, posisiRT);
                                config.saveSPString(config.SP_POSISIRW, posisiRW);
                                config.saveSPString(config.SP_ALAMAT, alamat);
                                config.saveSPString(config.SP_TEMPAT_LAHIR, tempat_lahir);
                                config.saveSPString(config.SP_TTL, ttl);
                                config.saveSPString(config.SP_PEKERJAAN, pekerjaan);
                                config.saveSPString(config.SP_AGAMa, agama);
                                config.saveSPString(config.SP_NO_KK, kk);
                                config.saveSPString(config.SP_KELURAHAN, kelurahan);
                                config.saveSPString(config.SP_RT, rt);
                                config.saveSPString(config.SP_RW, rw);
                                config.saveSPString(config.SP_JK, jk);
                                config.saveSPString(config.SP_KECAMATAN, kecamatan);
                                config.saveSPString(config.SP_KABUPATEN, kabupaten);
                                config.saveSPString(config.SP_PROVINSI, provinsi);
                                config.saveSPString(config.SP_STATUS_NIKAH, status_nikah);
                                config.saveSPString(config.SP_STATUS_KK, status_kk);
                                config.saveSPString(config.SP_PENDIDIKAN, pendidikan);
                                // Shared Pref ini berfungsi untuk menjadi trigger session login
                                config.saveSPBoolean(config.SP_SUDAH_LOGIN, true);
                                Intent intent = new Intent(getApplicationContext(), HomeRTctivity.class)
                                        .addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
                                intent.putExtra("nama", nama);
                                intent.putExtra("id", id);
                                startActivity(intent);
                                finish();
                            } else if (rulestatus.equalsIgnoreCase("U_RW")) {
                                config.saveSPString(config.SP_EMAIL, username);
                                config.saveSPString(config.SP_STATUS, rulestatus);
                                config.saveSPString(config.SP_ID, id);
                                config.saveSPString(config.SP_NAMA, nama);
                                config.saveSPString(config.SP_POSISIRW, posisiRW);
                                config.saveSPString(config.SP_ALAMAT, alamat);
                                config.saveSPString(config.SP_TEMPAT_LAHIR, tempat_lahir);
                                config.saveSPString(config.SP_TTL, ttl);
                                config.saveSPString(config.SP_PEKERJAAN, pekerjaan);
                                config.saveSPString(config.SP_AGAMa, agama);
                                config.saveSPString(config.SP_NO_KK, kk);
                                config.saveSPString(config.SP_KELURAHAN, kelurahan);
                                config.saveSPString(config.SP_RT, rt);
                                config.saveSPString(config.SP_RW, rw);
                                config.saveSPString(config.SP_JK, jk);
                                config.saveSPString(config.SP_KECAMATAN, kecamatan);
                                config.saveSPString(config.SP_KABUPATEN, kabupaten);
                                config.saveSPString(config.SP_PROVINSI, provinsi);
                                config.saveSPString(config.SP_STATUS_NIKAH, status_nikah);
                                config.saveSPString(config.SP_STATUS_KK, status_kk);
                                config.saveSPString(config.SP_PENDIDIKAN, pendidikan);
                                // Shared Pref ini berfungsi untuk menjadi trigger session login
                                config.saveSPBoolean(config.SP_SUDAH_LOGIN, true);
                                Intent intent = new Intent(getApplicationContext(), HomeRWActivity.class)
                                        .addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
                                intent.putExtra("nama", nama);
                                intent.putExtra("id", id);
                                startActivity(intent);
                                finish();
                            }
                            loading.dismiss();
                        }else {
                            loading.dismiss();
                            edtUsername.setError("cek username atau password anda");
                            edtPassword.setError("cek username atau password anda");

                        }
                    }
                }

                @Override
                public void onFailure(Call<ArrayList<RuleModel>> call, Throwable t) {
                    Toast.makeText(LoginActivity.this, "Cek koneksi anda", Toast.LENGTH_SHORT).show();
                    loading.dismiss();
                }
            });
    }

    private void initView() {
        mBtnLogin = (Button) findViewById(R.id.btn_login);
        txtDaftar = (TextView) findViewById(R.id.txt_daftar);
        edtUsername = (MaterialEditText) findViewById(R.id.edt_username);
        edtPassword = (MaterialEditText) findViewById(R.id.edt_password);
    }
}
