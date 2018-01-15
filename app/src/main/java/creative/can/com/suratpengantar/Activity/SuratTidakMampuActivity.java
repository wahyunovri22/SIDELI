package creative.can.com.suratpengantar.Activity;

import android.app.DatePickerDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import com.rengwuxian.materialedittext.MaterialEditText;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import creative.can.com.suratpengantar.Fragment.PermintaanSuratFragment;
import creative.can.com.suratpengantar.Fragment.ProfilFragment;
import creative.can.com.suratpengantar.Model.ResponseModel;
import creative.can.com.suratpengantar.R;
import creative.can.com.suratpengantar.helper.Config;
import creative.can.com.suratpengantar.retrofit.ApiRequest;
import creative.can.com.suratpengantar.retrofit.RetrofitConfig;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SuratTidakMampuActivity extends AppCompatActivity {

    private MaterialEditText edtNamaSurat;
    private MaterialEditText edtNik;
    private MaterialEditText edtNama;
    private MaterialEditText edtPekerjaan;
    private MaterialEditText edtTempatLahir;
    private MaterialEditText edtAgama;
    private MaterialEditText edtTanggal;
    private MaterialEditText edtAlamat;
    private MaterialEditText edtKeperluan;
    private MaterialEditText tglKirim;
    private Button btnDaftar;
    ProgressDialog pd;
    String jk, ambil_jk;

    DatePickerDialog datePickerDialog, datePickerDialog2;
    int mYear;
    int mMonth;
    int mDay;

    Config config;
    private MaterialEditText edtIdSurat;
    private MaterialEditText edtKk;
    private MaterialEditText edtKecamatan;
    private MaterialEditText edtKabupaten;
    private MaterialEditText edtProvinsi;
    private MaterialEditText edtStatusNikah;
    private MaterialEditText edtWarganegara;
    private MaterialEditText edtStatusKk;
    private MaterialEditText edtPendidikan;
    private MaterialEditText edtKelurahan;
    private MaterialEditText edtRt;
    private MaterialEditText edtRw;
    private RadioGroup rbgKelamin;
    private RadioButton rbPria;
    private RadioButton rbWanita;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_surat_tidak_mampu);
        initView();

        pd = new ProgressDialog(this);
        config = new Config(this);

        awal();

        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);

        // datePicker
//        datePickerDialog = new
//                DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
//            @Override
//            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
//                mYear = year;
//                mMonth = month;
//                mDay = dayOfMonth;
//
//                GregorianCalendar c = new GregorianCalendar(mYear, mMonth, mDay);
//                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");
//
//                edtTanggal.setText(sdf.format(c.getTime()));
//
//                edtTanggal.setFocusable(false);
//                edtTanggal.setCursorVisible(false);
//                //edtTanggal.setText(tanggal);
//
//            }
//        }, year, month, day);
        datePickerDialog = new
                DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {

                String tanggal = year + "-" + (month + 1) + "-" + dayOfMonth;
                edtTanggal.setFocusable(false);
                edtTanggal.setCursorVisible(false);
                edtTanggal.setText(tanggal);
            }
        }, year, month, day);

        Thread thread = new Thread() {
            @Override
            public void run() {
                try {
                    while (!isInterrupted()) {
                        Thread.sleep(1000);
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                long date = System.currentTimeMillis();
                                long time = System.currentTimeMillis();
                                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
                                SimpleDateFormat simpleDateFormat1 = new SimpleDateFormat("HH:mm");
                                String dateString = simpleDateFormat.format(date);
                                String timeString = simpleDateFormat1.format(time);
                                tglKirim.setText(dateString + "   " + timeString);
                                ;
                                tglKirim.setFocusable(false);
                                tglKirim.setCursorVisible(false);
                            }
                        });
                    }
                } catch (InterruptedException e) {
                }
            }
        };
        thread.start();

        edtTanggal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                datePickerDialog.show();
            }
        });

        btnDaftar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                daftar();
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

//        edtKelurahan.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                final CharSequence[] dialogItem = {"Krajankulon", "Plantaran"};
//                AlertDialog.Builder builder = new AlertDialog.Builder(view.getContext());
//                builder.setTitle("Pilih Kelurahan");
//                builder.setItems(dialogItem, new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialogInterface, int i) {
//
//                        switch (i) {
//                            case 0:
//                                edtKelurahan.setText("Krajankulon");
//                                break;
//                            case 1:
//                                edtKelurahan.setText("Plantaran");
//                                break;
//                        }
//                    }
//                });
//                builder.create().show();
//            }
//        });

//        edtRt.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                final CharSequence[] dialogItem = {"1", "2", "3", "4", "5", "6"};
//                AlertDialog.Builder builder = new AlertDialog.Builder(view.getContext());
//                builder.setTitle("Pilih RT");
//                builder.setItems(dialogItem, new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialogInterface, int i) {
//
//                        switch (i) {
//                            case 0:
//                                edtRt.setText("1");
//                                break;
//                            case 1:
//                                edtRt.setText("2");
//                                break;
//                            case 2:
//                                edtRt.setText("3");
//                                break;
//                            case 3:
//                                edtRt.setText("4");
//                                break;
//                            case 4:
//                                edtRt.setText("5");
//                                break;
//                            case 5:
//                                edtRt.setText("6");
//                                break;
//                        }
//                    }
//                });
//                builder.create().show();
//            }
//        });
//
//        edtRw.setOnClickListener(new View.OnClickListener() {
//
//            @Override
//            public void onClick(View view) {
//                final CharSequence[] dialogItem = {"1", "2", "3", "4", "5", "6"};
//                AlertDialog.Builder builder = new AlertDialog.Builder(view.getContext());
//                builder.setTitle("Pilih RW");
//                builder.setItems(dialogItem, new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialogInterface, int i) {
//
//                        switch (i) {
//                            case 0:
//                                edtRw.setText("1");
//                                break;
//                            case 1:
//                                edtRw.setText("2");
//                                break;
//                            case 2:
//                                edtRw.setText("3");
//                                break;
//                            case 3:
//                                edtRw.setText("4");
//                                break;
//                            case 4:
//                                edtRw.setText("5");
//                                break;
//                            case 5:
//                                edtRw.setText("6");
//                                break;
//                        }
//                    }
//                });
//                builder.create().show();
//            }
//        });

//        edtKecamatan.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                final CharSequence[] dialogItem = {"Kaliwungu", "Kaliwungu Selatan"};
//                AlertDialog.Builder builder = new AlertDialog.Builder(view.getContext());
//                builder.setTitle("Pilih Kecamatan");
//                builder.setItems(dialogItem, new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialogInterface, int i) {
//
//                        switch (i) {
//                            case 0:
//                                edtKecamatan.setText("Kaliwungu");
//                                break;
//                            case 1:
//                                edtKecamatan.setText("Kaliwungu Selatan");
//                                break;
//                        }
//                    }
//                });
//                builder.create().show();
//            }
//        });
    }

    public void daftar() {
        if(!validasi()){
            return;
        }
        if(!validasi()){
            return;
        }
        if(!validasi()){
            return;
        }
        if(!validasi()){
            return;
        }
        if(!validasi()){
            return;
        }
        if(!validasi()){
            return;
        }
        if(!validasi()){
            return;
        }
        if(!validasi()){
            return;
        }
        if(!validasi()){
            return;
        }
        if(!validasi()){
            return;
        }
        if(!validasi()){
            return;
        }
        if(!validasi()){
            return;
        }
        if(!validasi()){
            return;
        }
        if(!validasi()){
            return;
        }
        if(!validasi()){
            return;
        }
        if(!validasi()){
            return;
        }
        if(!validasi()){
            return;
        }

        String id = edtIdSurat.getText().toString();
        String keperluan = edtKeperluan.getText().toString();
        String status = "WAITING";
        String nik2 = edtNik.getText().toString();
        String kk = edtKk.getText().toString();
        String nama = edtNama.getText().toString();
        String tempatlahir = edtTempatLahir.getText().toString();
        String tgl = edtTanggal.getText().toString();
        if (rbPria.isChecked()){
            jk = "1";
        }else {
            jk = "2";
        }
        String rw = edtRw.getText().toString();
        String rt = edtRt.getText().toString();
        String alamat = edtAlamat.getText().toString();
        String kelurahan = edtKelurahan.getText().toString();
        String kecamatan = edtKecamatan.getText().toString();
        String kabupaten = edtKabupaten.getText().toString();
        String provinsi = edtProvinsi.getText().toString();
        String agama = edtAgama.getText().toString();
        String status_nikah = edtStatusNikah.getText().toString();
        String status_kk = edtStatusKk.getText().toString();
        String pendidikan = edtPendidikan.getText().toString();
        String pekerjaan = edtPekerjaan.getText().toString();
        String penduduk = edtWarganegara.getText().toString();
        pd.setMessage("loading");
        pd.setCancelable(false);
        pd.show();

        ApiRequest apiRequest = RetrofitConfig.getRetrofit().create(ApiRequest.class);
        Call<ResponseModel> get = apiRequest.insertSurat(id, keperluan, status, nik2, kk, nama, tempatlahir, tgl,
                jk, alamat, rt, rw, kelurahan, kecamatan, kabupaten, provinsi, agama, status_nikah, status_kk, pendidikan,
                pekerjaan, penduduk);
        get.enqueue(new Callback<ResponseModel>() {
            @Override
            public void onResponse(Call<ResponseModel> call, Response<ResponseModel> response) {
                pd.dismiss();
                String kode = response.body().getKode();
                String pesan = response.body().getPesan();
                if (kode.equals("1")) {
                    Toast.makeText(SuratTidakMampuActivity.this, pesan, Toast.LENGTH_SHORT).show();
//                    Fragment fragment = null;
//                    fragment = PermintaanSuratFragment.newInstance();
//                    FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
//                    transaction.replace(R.id.content2, fragment);
//                    transaction.commit();
                    finish();
                } else {
                    Toast.makeText(SuratTidakMampuActivity.this, pesan, Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<ResponseModel> call, Throwable t) {
                pd.dismiss();
                Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void initView() {
        edtNamaSurat = (MaterialEditText) findViewById(R.id.edt_nama_surat);
        edtNik = (MaterialEditText) findViewById(R.id.edt_nik);
        edtNama = (MaterialEditText) findViewById(R.id.edt_nama);
        edtPekerjaan = (MaterialEditText) findViewById(R.id.edt_pekerjaan);
        edtTempatLahir = (MaterialEditText) findViewById(R.id.edt_tempat_lahir);
        edtAgama = (MaterialEditText) findViewById(R.id.edt_agama);
        edtTanggal = (MaterialEditText) findViewById(R.id.edt_tanggal);
        edtAlamat = (MaterialEditText) findViewById(R.id.edt_alamat);
        edtKeperluan = (MaterialEditText) findViewById(R.id.edt_keperluan);
        tglKirim = (MaterialEditText) findViewById(R.id.tgl_kirim);
        btnDaftar = (Button) findViewById(R.id.btn_daftar);
        edtIdSurat = (MaterialEditText) findViewById(R.id.edt_id_surat);
        edtKk = (MaterialEditText) findViewById(R.id.edt_kk);
        edtKecamatan = (MaterialEditText) findViewById(R.id.edt_kecamatan);
        edtKabupaten = (MaterialEditText) findViewById(R.id.edt_kabupaten);
        edtProvinsi = (MaterialEditText) findViewById(R.id.edt_provinsi);
        edtStatusNikah = (MaterialEditText) findViewById(R.id.edt_status_nikah);
        edtWarganegara = (MaterialEditText) findViewById(R.id.edt_warganegara);
        edtStatusKk = (MaterialEditText) findViewById(R.id.edt_status_kk);
        edtPendidikan = (MaterialEditText) findViewById(R.id.edt_pendidikan);
        edtKelurahan = (MaterialEditText) findViewById(R.id.edt_kelurahan);
        edtRt = (MaterialEditText) findViewById(R.id.edt_rt);
        edtRw = (MaterialEditText) findViewById(R.id.edt_rw);
        rbgKelamin = (RadioGroup) findViewById(R.id.rbg_kelamin);
        rbPria = (RadioButton) findViewById(R.id.rb_pria);
        rbWanita = (RadioButton) findViewById(R.id.rb_wanita);
    }

    public void awal() {
        edtAlamat.setText(config.getSpAlamat());
        edtAgama.setText(config.getSP_AGAMa());
        edtPekerjaan.setText(config.getSpPekerjaan());
        edtTempatLahir.setText(config.getSpTempatLahir());
        edtTanggal.setText(config.getSpTtl());
        edtKk.setText(config.getSpNoKk());
        edtKelurahan.setText(config.getSpKelurahan());
        edtRt.setText(config.getSpRt());
        edtRw.setText(config.getSpRw());
        edtKecamatan.setText(config.getSpKecamatan());
        edtKabupaten.setText(config.getSpKabupaten());
        edtProvinsi.setText(config.getSpProvinsi());
        edtStatusNikah.setText(config.getSpStatusNikah());
        edtStatusKk.setText(config.getSpStatusKk());
        edtPendidikan.setText(config.getSpPendidikan());

        ambil_jk = config.getSpJk();
        if (ambil_jk.contains("1")){
            rbPria.setChecked(true);
        }else {
            rbWanita.setChecked(true);
        }

        edtNik.setFocusable(false);
        edtKk.setFocusable(false);
        edtNama.setText(config.getSPNama());
        edtNik.setText(config.getSpId());
        edtNamaSurat.setText("Surat Keterangan Tidak Mampu");
        edtNamaSurat.setFocusable(false);
        edtIdSurat.setText("3");
        edtIdSurat.setFocusable(false);
        edtWarganegara.setText("WNI");
        edtTanggal.setFocusable(false);
        tglKirim.setFocusable(false);
        edtStatusNikah.setFocusable(false);
        edtStatusKk.setFocusable(false);
        edtAgama.setFocusable(false);
        edtPekerjaan.setFocusable(false);
        edtPendidikan.setFocusable(false);
        //edtKelurahan.setFocusable(false);
        edtRt.setFocusable(false);
        edtRw.setFocusable(false);
        //edtKecamatan.setFocusable(false);
    }

    public Boolean validasi(){
        if (edtNama.getText().toString().isEmpty()){
            edtNama.setError("Harus diisi");
            edtNama.requestFocus();
            return false;
        }
        if (edtPekerjaan.getText().toString().isEmpty()){
            edtPekerjaan.setError("Harus diisi");
            edtPekerjaan.requestFocus();
            return false;
        }
        if (edtTempatLahir.getText().toString().isEmpty()){
            edtTempatLahir.setError("Harus diisi");
            edtTempatLahir.requestFocus();
            return false;
        }
        if (edtAgama.getText().toString().isEmpty()){
            edtAgama.setError("Harus diisi");
            edtAgama.requestFocus();
            return false;
        }
        if (edtTanggal.getText().toString().isEmpty()){
            edtTanggal.setError("Harus diisi");
            edtTanggal.requestFocus();
            return false;
        }
        if (edtAlamat.getText().toString().isEmpty()){
            edtAlamat.setError("Harus diisi");
            edtAlamat.requestFocus();
            return false;
        }
        if (edtKelurahan.getText().toString().isEmpty()){
            edtKelurahan.setError("Harus diisi");
            edtKelurahan.requestFocus();
            return false;
        }
        if (edtRt.getText().toString().isEmpty()){
            edtRt.setError("Harus diisi");
            edtRt.requestFocus();
            return false;
        }
        if (edtRw.getText().toString().isEmpty()){
            edtRw.setError("Harus diisi");
            edtRw.requestFocus();
            return false;
        }
        if (edtKecamatan.getText().toString().isEmpty()){
            edtKecamatan.setError("Harus diisi");
            edtKecamatan.requestFocus();
            return false;
        }
        if (edtKabupaten.getText().toString().isEmpty()){
            edtKabupaten.setError("Harus diisi");
            edtKabupaten.requestFocus();
            return false;
        }
        if (edtProvinsi.getText().toString().isEmpty()){
            edtProvinsi.setError("Harus diisi");
            edtProvinsi.requestFocus();
            return false;
        }
        if (edtStatusNikah.getText().toString().isEmpty()){
            edtStatusNikah.setError("Harus diisi");
            edtStatusNikah.requestFocus();
            return false;
        }
        if (edtWarganegara.getText().toString().isEmpty()){
            edtWarganegara.setError("Harus diisi");
            edtWarganegara.requestFocus();
            return false;
        }
        if (edtStatusKk.getText().toString().isEmpty()){
            edtStatusKk.setError("Harus diisi");
            edtStatusKk.requestFocus();
            return false;
        }
        if (edtPendidikan.getText().toString().isEmpty()){
            edtPendidikan.setError("Harus diisi");
            edtPendidikan.requestFocus();
            return false;
        }
        if (edtKeperluan.getText().toString().isEmpty()){
            edtKeperluan.setError("Harus diisi");
            edtKeperluan.requestFocus();
            return false;
        }
        return true;
    }
}
