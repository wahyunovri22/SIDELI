package creative.can.com.suratpengantar.Activity;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

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

        ApiRequest api = RetrofitConfig.getRetrofit().create(ApiRequest.class);
        Call<ArrayList<RuleModel>> call = api.getRuleLogin();
        call.enqueue(new Callback<ArrayList<RuleModel>>() {
            @Override
            public void onResponse(Call<ArrayList<RuleModel>> call, Response<ArrayList<RuleModel>> response) {
                list = response.body();
                for (final RuleModel s : list) {
//                    if ((s.getUGROUPRULE() != null && s.getUGROUPRULE().contains("U_RT"))) {
//                        String rule = s.getUNAME().toString().trim();
//                        Toast.makeText(BantuanActivity.this, "Rule : " + rule , Toast.LENGTH_SHORT).show();
////                        LayoutInflater layoutInflater = (LayoutInflater) getBaseContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
////                        View addView = layoutInflater.inflate(R.layout.list_waiting, null);
////                        final TextView lurah = (TextView) addView.findViewById(R.id.txt_lurah);
////                        final TextView noLurah = (TextView) addView.findViewById(R.id.txt_nomor_lurah);
////                        final TextView rt = (TextView) addView.findViewById(R.id.txt_rt);
////                        final TextView noRt = (TextView) addView.findViewById(R.id.txt_nomor_rt);
////                        final TextView rw = (TextView) addView.findViewById(R.id.txt_rw);
////                        final TextView noRw = (TextView) addView.findViewById(R.id.txt_nomor_rw);
//
////                        lurah.setText(s.getWNAMA());
////                        noLurah.setText(s.getUMOBILE());
//
////                        div.addView(addView);
//
//                        txtLurah.setText(s.getWNAMA());
//                    }
                    if (s.getWRT().equals(posisiRT) && s.getWRW().equals(posisiRW) && s.getUGROUPRULE().equals("U_RT")){
                        //Toast.makeText(BantuanActivity.this, ""+s.getWNAMA(), Toast.LENGTH_SHORT).show();
                        txtRt.setText(s.getWNAMA());
                        txtNomorRt.setText(s.getUMOBILE());
                    }
                    if (s.getWRT().equals(posisiRT) && s.getWRW().equals(posisiRW) && s.getUGROUPRULE().equals("U_RW")){
                     //   Toast.makeText(BantuanActivity.this, ""+s.getWNAMA(), Toast.LENGTH_SHORT).show();
                        txtRw.setText(s.getWNAMA());
                        txtNomorRw.setText(s.getUMOBILE());
                    }

                    if (s.getUGROUPRULE().equals("U_LURAH")){
                        //Toast.makeText(BantuanActivity.this, ""+s.getWNAMA(), Toast.LENGTH_SHORT).show();
                        txtLurah.setText(s.getWNAMA());
                        txtLurah.setText(s.getUMOBILE());
                    }
                }
            }

            @Override
            public void onFailure(Call<ArrayList<RuleModel>> call, Throwable t) {

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
