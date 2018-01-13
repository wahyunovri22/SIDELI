package creative.can.com.suratpengantar.Activity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.rengwuxian.materialedittext.MaterialEditText;

import java.util.ArrayList;

import creative.can.com.suratpengantar.LoginActivity;
import creative.can.com.suratpengantar.Model.ResponseModel;
import creative.can.com.suratpengantar.Model.RuleModel;
import creative.can.com.suratpengantar.R;
import creative.can.com.suratpengantar.helper.Config;
import creative.can.com.suratpengantar.retrofit.ApiRequest;
import creative.can.com.suratpengantar.retrofit.RetrofitConfig;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;

public class SettingActivity extends AppCompatActivity {

    private MaterialEditText edtUsername;
    private MaterialEditText edtPasswordBaru;
    private Button btnSave;
    private FloatingActionButton btnSave2;

    Config config;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        initView();
        config = new Config(this);
        edtUsername.setText(config.getSPEmail());
        //edtUsername.setClickable(false);
        edtUsername.setFocusable(false);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        edtUsername.setText(config.getSPEmail());
//        btnSave.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                final ProgressDialog loading = ProgressDialog.show(SettingActivity.this, "Loading", "Harap tunggu...", false, false);
//                ApiRequest api = RetrofitConfig.getRetrofit().create(ApiRequest.class);
//                retrofit2.Call<ResponseModel> ubah = api.updatePassword(edtUsername.getText().toString(), edtPasswordBaru.getText().toString());
//                ubah.enqueue(new Callback<ResponseModel>() {
//                    @Override
//                    public void onResponse(Call<ResponseModel> call, Response<ResponseModel> response) {
//
//                        String pesan = response.body().getPesan();
//                        String kode = response.body().getKode();
//
//                        loading.dismiss();
//
//                        if (kode.equals("1")){
//                            Toast.makeText(SettingActivity.this, pesan, Toast.LENGTH_SHORT).show();
//                            edtPasswordBaru.setText(null);
//                        }else{
//                            Toast.makeText(SettingActivity.this, pesan, Toast.LENGTH_SHORT).show();
//                        }
//
//                    }
//
//                    @Override
//                    public void onFailure(Call<ResponseModel> call, Throwable t) {
//                        loading.dismiss();
//                        Toast.makeText(SettingActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
//                    }
//                });
//            }
//        });

        btnSave2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final ProgressDialog loading = ProgressDialog.show(SettingActivity.this, "Loading", "Harap tunggu...", false, false);
                ApiRequest api = RetrofitConfig.getRetrofit().create(ApiRequest.class);
                retrofit2.Call<ResponseModel> ubah = api.updatePassword(edtUsername.getText().toString(), edtPasswordBaru.getText().toString());
                ubah.enqueue(new Callback<ResponseModel>() {
                    @Override
                    public void onResponse(Call<ResponseModel> call, Response<ResponseModel> response) {

                        String pesan = response.body().getPesan();
                        String kode = response.body().getKode();

                        loading.dismiss();

                        if (kode.equals("1")){
                            Toast.makeText(SettingActivity.this, pesan, Toast.LENGTH_SHORT).show();
                            edtPasswordBaru.setText(null);
                        }else{
                            Toast.makeText(SettingActivity.this, pesan, Toast.LENGTH_SHORT).show();
                        }

                    }

                    @Override
                    public void onFailure(Call<ResponseModel> call, Throwable t) {
                        loading.dismiss();
                        Toast.makeText(SettingActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
    }

    private void initView() {
        edtUsername = (MaterialEditText) findViewById(R.id.edt_username);
        edtPasswordBaru = (MaterialEditText) findViewById(R.id.edt_password_baru);
        btnSave = (Button) findViewById(R.id.btn_save);
        btnSave2 = (FloatingActionButton)findViewById(R.id.btn_save2);
    }
}
