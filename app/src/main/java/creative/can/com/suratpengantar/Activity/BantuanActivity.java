package creative.can.com.suratpengantar.Activity;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import creative.can.com.suratpengantar.LoginActivity;
import creative.can.com.suratpengantar.Model.RuleModel;
import creative.can.com.suratpengantar.R;
import creative.can.com.suratpengantar.helper.Config;
import creative.can.com.suratpengantar.retrofit.ApiRequest;
import creative.can.com.suratpengantar.retrofit.RetrofitConfig;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class BantuanActivity extends AppCompatActivity {

    private ArrayList<RuleModel> list;
    String posisiRT, posisiRW;
    Config config;
    private LinearLayout div;
    private TextView txtLurah;
    private TextView txtNomorLurah;
    private TextView txtRt;
    private TextView txtNomorRt;
    private TextView txtRw;
    private TextView txtNomorRw;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bantuan);
        initView();
        config = new Config(this);

        posisiRT = config.getSpPosisirt();
        posisiRW = config.getSpPosisirw();

        final ProgressDialog loading = ProgressDialog.show(BantuanActivity.this, "Loading", "Harap tunggu...", false, false);
        ApiRequest api = RetrofitConfig.getRetrofit().create(ApiRequest.class);
        Call<ArrayList<RuleModel>> call = api.getRuleLogin();
        call.enqueue(new Callback<ArrayList<RuleModel>>() {
            @Override
            public void onResponse(Call<ArrayList<RuleModel>> call, Response<ArrayList<RuleModel>> response) {
                list = response.body();
                for (final RuleModel s : list) {
                    if (s.getWRT().equals(posisiRT) && s.getWRW().equals(posisiRW) && s.getUGROUPRULE().equals("U_RT")){
                        txtRt.setText(s.getWNAMA());
                        txtNomorRt.setText(s.getUMOBILE());
                    }
                    if (s.getWRT().equals(posisiRT) && s.getWRW().equals(posisiRW) && s.getUGROUPRULE().equals("U_RW")){
                        txtRw.setText(s.getWNAMA());
                        txtNomorRw.setText(s.getUMOBILE());
                    }

                    if (s.getUGROUPRULE().equals("U_LURAH")){
                        txtLurah.setText(s.getWNAMA());
                        txtNomorLurah.setText(s.getUMOBILE());
                    }
                }
                loading.dismiss();
            }

            @Override
            public void onFailure(Call<ArrayList<RuleModel>> call, Throwable t) {
                loading.dismiss();
                Toast.makeText(BantuanActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

    }

    private void initView() {
        div = (LinearLayout) findViewById(R.id.div);
        txtLurah = (TextView) findViewById(R.id.txt_lurah);
        txtNomorLurah = (TextView) findViewById(R.id.txt_nomor_lurah);
        txtRt = (TextView) findViewById(R.id.txt_rt);
        txtNomorRt = (TextView) findViewById(R.id.txt_nomor_rt);
        txtRw = (TextView) findViewById(R.id.txt_rw);
        txtNomorRw = (TextView) findViewById(R.id.txt_nomor_rw);
    }
}
