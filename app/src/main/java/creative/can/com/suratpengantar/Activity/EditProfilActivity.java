package creative.can.com.suratpengantar.Activity;

import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.ScrollView;
import android.widget.Toast;

import com.rengwuxian.materialedittext.MaterialEditText;

import java.util.Calendar;

import creative.can.com.suratpengantar.Fragment.HistoryFragment;
import creative.can.com.suratpengantar.Fragment.ProfilFragment;
import creative.can.com.suratpengantar.Model.ResponseModel;
import creative.can.com.suratpengantar.R;
import creative.can.com.suratpengantar.helper.Config;
import creative.can.com.suratpengantar.retrofit.ApiRequest;
import creative.can.com.suratpengantar.retrofit.RetrofitConfig;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class EditProfilActivity extends AppCompatActivity {

    private MaterialEditText edtEditNama;

    String nik;
    private Button btnUpdate;
    Config config;
    private MaterialEditText edtAlamat;
    private MaterialEditText edtTempatLahir;
    private MaterialEditText edtTtl;
    private MaterialEditText edtPekerjaan;
    private MaterialEditText edtAgama;
    private FloatingActionButton btnUpdate2;
    DatePickerDialog datePickerDialog;
    String jk,mJk;
    private ScrollView contentku;
    private RadioGroup rbgKelamin;
    private RadioButton rbPria;
    private RadioButton rbWanita;
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profil);
        initView();

        config = new Config(this);
        Intent getData = getIntent();
        nik = config.getSpId();
        edtEditNama.setText(config.getSPNama());
        edtAlamat.setText(config.getSpAlamat());
        edtTempatLahir.setText(config.getSpTempatLahir());
        edtTtl.setText(config.getSpTtl());
        edtPekerjaan.setText(config.getSpPekerjaan());
        edtAgama.setText(config.getSP_AGAMa());
        jk = config.getSpJk();
        if (jk.equals("1")){
            rbPria.setChecked(true);
        }else {
            rbWanita.setChecked(true);
        }
        edtKelurahan.setText(config.getSpKelurahan());
        edtRt.setText(config.getSpRt());
        edtRw.setText(config.getSpRw());
        edtKecamatan.setText(config.getSpKecamatan());
        edtKabupaten.setText(config.getSpKabupaten());
        edtProvinsi.setText(config.getSpProvinsi());
        edtStatusNikah.setText(config.getSpStatusNikah());
        edtWarganegara.setText(config.getSpPenduduk());
        edtStatusKk.setText(config.getSpStatusKk());
        edtPendidikan.setText(config.getSpPendidikan());

        edtTtl.setFocusable(false);
        edtAgama.setFocusable(false);
        edtPekerjaan.setFocusable(false);
        edtStatusNikah.setFocusable(false);
        edtStatusKk.setFocusable(false);
        edtPendidikan.setFocusable(false);


        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);

        datePickerDialog = new
                DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {

                String tanggal = year + "-" + (month + 1) + "-" + dayOfMonth;
                edtTtl.setFocusable(false);
                edtTtl.setCursorVisible(false);
                edtTtl.setText(tanggal);
            }
        }, year, month, day);

        edtTtl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                datePickerDialog.show();
            }
        });

        edtPekerjaan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final CharSequence[] dialogItem = {"PNS", "Wirausaha", "Swasta", "Buruh", "Lainnya"};

                AlertDialog.Builder builder = new AlertDialog.Builder(view.getContext());
                builder.setTitle("Pilih Pekerjaan");
                builder.setItems(dialogItem, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                        switch (i) {
                            case 0:
                                edtPekerjaan.setText("PNS");
                                break;
                            case 1:
                                edtPekerjaan.setText("Wirausaha");
                                break;
                            case 2:
                                edtPekerjaan.setText("Swasta");
                                break;
                            case 3:
                                edtPekerjaan.setText("Buruh");
                                break;
                            case 4:
                                edtPekerjaan.setText("Lainnya");
                                break;
                        }
                    }
                });
                builder.create().show();
            }
        });


        edtAgama.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final CharSequence[] dialogItem = {"Islam", "Kristen", "Katolik", "Hindu", "Budha"};
                AlertDialog.Builder builder = new AlertDialog.Builder(view.getContext());
                builder.setTitle("Pilih Agama");
                builder.setItems(dialogItem, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                        switch (i) {
                            case 0:
                                edtAgama.setText("Islam");
                                break;
                            case 1:
                                edtAgama.setText("Kristen");
                                break;
                            case 2:
                                edtAgama.setText("Katolik");
                                break;
                            case 3:
                                edtAgama.setText("Hindu");
                                break;
                            case 4:
                                edtAgama.setText("Budha");
                                break;
                        }
                    }
                });
                builder.create().show();
            }
        });

        edtStatusNikah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final CharSequence[] dialogItem = {"Nikah", "Lajang", "Cerai Hidup", "Cerai Mati"};
                AlertDialog.Builder builder = new AlertDialog.Builder(view.getContext());
                builder.setTitle("Pilih Status");
                builder.setItems(dialogItem, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                        switch (i) {
                            case 0:
                                edtStatusNikah.setText("Nikah");
                                break;
                            case 1:
                                edtStatusNikah.setText("Lajang");
                                break;
                            case 2:
                                edtStatusNikah.setText("Cerai Hidup");
                                break;
                            case 3:
                                edtStatusNikah.setText("Cerai Mati");
                                break;
                        }
                    }
                });
                builder.create().show();
            }
        });

        edtStatusKk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final CharSequence[] dialogItem = {"Anak", "Suami", "Isteri", "Cucu"};
                AlertDialog.Builder builder = new AlertDialog.Builder(view.getContext());
                builder.setTitle("Pilih Status KK");
                builder.setItems(dialogItem, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                        switch (i) {
                            case 0:
                                edtStatusKk.setText("Anak");
                                break;
                            case 1:
                                edtStatusKk.setText("Suami");
                                break;
                            case 2:
                                edtStatusKk.setText("Isteri");
                                break;
                            case 3:
                                edtStatusKk.setText("Cucu");
                                break;
                        }
                    }
                });
                builder.create().show();
            }
        });

        edtPendidikan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final CharSequence[] dialogItem = {"SD", "SMP", "SMA", "D3", "Sarjana", "Lainnya"};
                AlertDialog.Builder builder = new AlertDialog.Builder(view.getContext());
                builder.setTitle("Pilih Pendidikan");
                builder.setItems(dialogItem, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                        switch (i) {
                            case 0:
                                edtPendidikan.setText("SD");
                                break;
                            case 1:
                                edtPendidikan.setText("SMP");
                                break;
                            case 2:
                                edtPendidikan.setText("SMA");
                                break;
                            case 3:
                                edtPendidikan.setText("D3");
                                break;
                            case 4:
                                edtPendidikan.setText("Sarjana");
                                break;
                            case 5:
                                edtPendidikan.setText("Lainnya");
                                break;
                        }
                    }
                });
                builder.create().show();
            }
        });

        btnUpdate2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String nama = edtEditNama.getText().toString();
                final String alamat = edtAlamat.getText().toString();
                final String tempat = edtTempatLahir.getText().toString();
                final String ttl = edtTtl.getText().toString();
                final String pekerjaan = edtPekerjaan.getText().toString();
                final String agama = edtAgama.getText().toString();
                if (rbPria.isChecked()){
                    mJk = "1";
                }else{
                    mJk = "2";
                }
                final String kelurahan = edtKelurahan.getText().toString();
                final String rt = edtRt.getText().toString();
                final String rw = edtRw.getText().toString();
                final String kecamatan= edtKecamatan.getText().toString();
                final String kabupaten = edtKabupaten.getText().toString();
                final String provinsi = edtProvinsi.getText().toString();
                final String status = edtStatusNikah.getText().toString();
                final String penduduk = edtWarganegara.getText().toString();
                final String sKK = edtStatusKk.getText().toString();
                final String pendidikan = edtPendidikan.getText().toString();
                ApiRequest api = RetrofitConfig.getRetrofit().create(ApiRequest.class);
                Call<ResponseModel> update = api.updateProfil(nik, nama, alamat, tempat, ttl, pekerjaan, agama,mJk,kelurahan,
                        rt,rw,kecamatan,kabupaten,provinsi,status,penduduk,sKK,pendidikan);
                update.enqueue(new Callback<ResponseModel>() {
                    @Override
                    public void onResponse(Call<ResponseModel> call, Response<ResponseModel> response) {
                        Log.d("retro", "response" + response.body().getPesan());
                        String kode = response.body().getKode();
                        String pesan = response.body().getPesan();
                        if (kode.equals("1")) {
                            Toast.makeText(EditProfilActivity.this, pesan, Toast.LENGTH_SHORT).show();
                            config.saveSPString(config.SP_NAMA, nama);
                            config.saveSPString(config.SP_ALAMAT, alamat);
                            config.saveSPString(config.SP_TEMPAT_LAHIR, tempat);
                            config.saveSPString(config.SP_TTL, ttl);
                            config.saveSPString(config.SP_PEKERJAAN, pekerjaan);
                            config.saveSPString(config.SP_AGAMa, agama);
                            config.saveSPString(config.SP_JK, mJk);
                            config.saveSPString(config.SP_KELURAHAN, kelurahan);
                            config.saveSPString(config.SP_RT, rt);
                            config.saveSPString(config.SP_RW, rw);
                            config.saveSPString(config.SP_KECAMATAN, kecamatan);
                            config.saveSPString(config.SP_KABUPATEN, kabupaten);
                            config.saveSPString(config.SP_PROVINSI, provinsi);
                            config.saveSPString(config.SP_STATUS_NIKAH, status);
                            config.saveSPString(config.SP_PENDUDUK, penduduk);
                            config.saveSPString(config.SP_STATUS_KK, sKK);
                            config.saveSPString(config.SP_PENDIDIKAN, pendidikan);
//                            Fragment fragment = null;
//                            fragment = ProfilFragment.newInstance();
//                            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
//                            transaction.replace(R.id.content, fragment);
//                            transaction.commit();
//                            finish();
                        } else {
                            Toast.makeText(getApplicationContext(), response.body().getPesan(), Toast.LENGTH_SHORT).show();
                        }


                    }

                    @Override
                    public void onFailure(Call<ResponseModel> call, Throwable t) {
                        Log.d("retro", "response" + t.getMessage());
                        Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });


                ApiRequest api2 = RetrofitConfig.getRetrofit().create(ApiRequest.class);
                Call<ResponseModel> update2 = api2.updateProfil2(nik, nama);
                update2.enqueue(new Callback<ResponseModel>() {
                    @Override
                    public void onResponse(Call<ResponseModel> call, Response<ResponseModel> response) {
                        Log.d("retro", "response" + response.body().getPesan());
                        String kode = response.body().getKode();
                        String pesan = response.body().getPesan();
                        if (kode.equals("1")) {
                            Toast.makeText(EditProfilActivity.this, pesan, Toast.LENGTH_SHORT).show();
                            Fragment fragment = null;
                            fragment = ProfilFragment.newInstance();
                            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                            transaction.replace(R.id.content, fragment);
                            transaction.commit();
                            finish();
                        } else {
                            Toast.makeText(getApplicationContext(), response.body().getPesan(), Toast.LENGTH_SHORT).show();
                        }


                    }

                    @Override
                    public void onFailure(Call<ResponseModel> call, Throwable t) {
                        Log.d("retro", "response" + t.getMessage());
                        Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
    }

    private void initView() {
        edtEditNama = (MaterialEditText) findViewById(R.id.edt_edit_nama);
        btnUpdate = (Button) findViewById(R.id.btn_update);
        edtAlamat = (MaterialEditText) findViewById(R.id.edt_alamat);
        edtTempatLahir = (MaterialEditText) findViewById(R.id.edt_tempat_lahir);
        edtTtl = (MaterialEditText) findViewById(R.id.edt_ttl);
        edtPekerjaan = (MaterialEditText) findViewById(R.id.edt_pekerjaan);
        edtAgama = (MaterialEditText) findViewById(R.id.edt_agama);
        btnUpdate2 = (FloatingActionButton) findViewById(R.id.btn_update2);
        //contentku = (ScrollView) findViewById(R.id.content);
        rbgKelamin = (RadioGroup) findViewById(R.id.rbg_kelamin);
        rbPria = (RadioButton) findViewById(R.id.rb_pria);
        rbWanita = (RadioButton) findViewById(R.id.rb_wanita);
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
    }
}
