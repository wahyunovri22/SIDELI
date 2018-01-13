package creative.can.com.suratpengantar.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.rengwuxian.materialedittext.MaterialEditText;

import creative.can.com.suratpengantar.R;

public class DetailSuratTidakMampuActivity extends AppCompatActivity {

    private MaterialEditText edtIdSurat;
    private MaterialEditText edtNamaSurat;
    private MaterialEditText edtNik;
    private MaterialEditText edtKk;
    private MaterialEditText edtNama;
    private MaterialEditText edtPekerjaan;
    private MaterialEditText edtTempatLahir;
    private MaterialEditText edtAgama;
    private MaterialEditText edtTanggal;
    private RadioGroup rbgKelamin;
    private RadioButton rbPria;
    private RadioButton rbWanita;
    private MaterialEditText edtAlamat;
    private MaterialEditText edtKelurahan;
    private MaterialEditText edtRt;
    private MaterialEditText edtRw;
    private MaterialEditText edtKecamatan;
    private MaterialEditText edtKabupaten;
    private MaterialEditText edtProvinsi;
    private MaterialEditText edtStatusNikah;
    private MaterialEditText edtWarganegara;
    private MaterialEditText edtStatusKk;
    private MaterialEditText edtPendidikan;
    private MaterialEditText edtKeperluan;
    private MaterialEditText tglKirim;
    private Button btnDaftar;
    private MaterialEditText edtJk;
    String jk;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_surat_tidak_mampu);
        initView();

        Intent getData = getIntent();


        edtNamaSurat.setText(getData.getStringExtra("nama_surat"));
        edtNik.setText(getData.getStringExtra("nik"));
        edtKk.setText(getData.getStringExtra("no_kk"));
        edtNama.setText(getData.getStringExtra("nama"));
        edtPekerjaan.setText(getData.getStringExtra("pekerjaan"));
        edtTempatLahir.setText(getData.getStringExtra("tempat_lahir"));
        edtAgama.setText(getData.getStringExtra("agama"));
        edtTanggal.setText(getData.getStringExtra("tgl_lahir"));
        jk = getData.getStringExtra("jk");
        if (jk.equals("1")){
            edtJk.setText("Pria");
        }else {
            edtJk.setText("Wanita");
        }
        edtAlamat.setText(getData.getStringExtra("alamat"));
        edtKelurahan.setText(getData.getStringExtra("kelurahan"));
        edtRt.setText(getData.getStringExtra("rt"));
        edtRw.setText(getData.getStringExtra("rw"));
        edtKecamatan.setText(getData.getStringExtra("kecamatan"));
        edtKabupaten.setText(getData.getStringExtra("kabupaten"));
        edtProvinsi.setText(getData.getStringExtra("provinsi"));
        edtStatusNikah.setText(getData.getStringExtra("status_nikah"));
        edtWarganegara.setText(getData.getStringExtra("warganegara"));
        edtStatusKk.setText(getData.getStringExtra("status_kk"));
        edtPendidikan.setText(getData.getStringExtra("pendidikan"));
        edtKeperluan.setText(getData.getStringExtra("keperluan"));
        tglKirim.setText(getData.getStringExtra("dibuat"));

        awal();
    }

    private void initView() {
        edtIdSurat = (MaterialEditText) findViewById(R.id.edt_id_surat);
        edtNamaSurat = (MaterialEditText) findViewById(R.id.edt_nama_surat);
        edtNik = (MaterialEditText) findViewById(R.id.edt_nik);
        edtKk = (MaterialEditText) findViewById(R.id.edt_kk);
        edtNama = (MaterialEditText) findViewById(R.id.edt_nama);
        edtPekerjaan = (MaterialEditText) findViewById(R.id.edt_pekerjaan);
        edtTempatLahir = (MaterialEditText) findViewById(R.id.edt_tempat_lahir);
        edtAgama = (MaterialEditText) findViewById(R.id.edt_agama);
        edtTanggal = (MaterialEditText) findViewById(R.id.edt_tanggal);
        rbgKelamin = (RadioGroup) findViewById(R.id.rbg_kelamin);
        rbPria = (RadioButton) findViewById(R.id.rb_pria);
        rbWanita = (RadioButton) findViewById(R.id.rb_wanita);
        edtAlamat = (MaterialEditText) findViewById(R.id.edt_alamat);
        edtKelurahan = (MaterialEditText) findViewById(R.id.edt_kelurahan);
        edtRt = (MaterialEditText) findViewById(R.id.edt_rt);
        edtRw = (MaterialEditText) findViewById(R.id.edt_rw);
        edtKecamatan = (MaterialEditText) findViewById(R.id.edt_kecamatan);
        edtKabupaten = (MaterialEditText) findViewById(R.id.edt_kabupaten);
        edtProvinsi = (MaterialEditText) findViewById(R.id.edt_provinsi);
        edtStatusNikah = (MaterialEditText) findViewById(R.id.edt_status_nikah);
        edtWarganegara = (MaterialEditText) findViewById(R.id.edt_warganegara);
        edtStatusKk = (MaterialEditText) findViewById(R.id.edt_status_kk);
        edtPendidikan = (MaterialEditText) findViewById(R.id.edt_pendidikan);
        edtKeperluan = (MaterialEditText) findViewById(R.id.edt_keperluan);
        tglKirim = (MaterialEditText) findViewById(R.id.tgl_kirim);
        btnDaftar = (Button) findViewById(R.id.btn_daftar);
        edtJk = (MaterialEditText) findViewById(R.id.edt_jk);
    }

    public void awal(){
        edtNik.setFocusable(false);
        edtKk.setFocusable(false);
        edtNama.setFocusable(false);
        edtNik.setFocusable(false);
        edtNamaSurat.setFocusable(false);
        edtNamaSurat.setFocusable(false);
        edtIdSurat.setFocusable(false);
        edtIdSurat.setFocusable(false);
        edtWarganegara.setFocusable(false);
        edtTanggal.setFocusable(false);
        tglKirim.setFocusable(false);
        edtStatusNikah.setFocusable(false);
        edtStatusKk.setFocusable(false);
        edtAgama.setFocusable(false);
        edtPekerjaan.setFocusable(false);
        edtPendidikan.setFocusable(false);
        edtKelurahan.setFocusable(false);
        edtRt.setFocusable(false);
        edtRw.setFocusable(false);
        edtKecamatan.setFocusable(false);
        edtKeperluan.setFocusable(false);
        edtTempatLahir.setFocusable(false);
        edtJk.setFocusable(false);
        edtAlamat.setFocusable(false);
    }
}
