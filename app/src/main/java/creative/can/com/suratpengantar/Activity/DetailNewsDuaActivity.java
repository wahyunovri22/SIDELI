package creative.can.com.suratpengantar.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import creative.can.com.suratpengantar.R;

public class DetailNewsDuaActivity extends AppCompatActivity {

    private TextView txtDetailTanggal;
    private TextView txtDetailPembuat;
    private TextView txtDetailIsi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_news_dua);
        initView();

        Intent tampilData = getIntent();
        txtDetailTanggal.setText(tampilData.getStringExtra("tanggal"));
        txtDetailPembuat.setText(tampilData.getStringExtra("pembuat"));
        txtDetailIsi.setText(tampilData.getStringExtra("isi"));
    }

    private void initView() {
        txtDetailTanggal = (TextView) findViewById(R.id.txt_detail_tanggal);
        txtDetailPembuat = (TextView) findViewById(R.id.txt_detail_pembuat);
        txtDetailIsi = (TextView) findViewById(R.id.txt_detail_isi);
    }
}
