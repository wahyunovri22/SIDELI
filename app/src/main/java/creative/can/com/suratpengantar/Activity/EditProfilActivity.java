package creative.can.com.suratpengantar.Activity;

import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.Toast;

import com.rengwuxian.materialedittext.MaterialEditText;

import java.util.Calendar;

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
        edtTtl.setFocusable(false);
        edtAgama.setFocusable(false);
        edtPekerjaan.setFocusable(false);


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


//        btnUpdate.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                final String nama = edtEditNama.getText().toString();
//                final String alamat = edtAlamat.getText().toString();
//                final String tempat = edtTempatLahir.getText().toString();
//                final String ttl = edtTtl.getText().toString();
//                final String pekerjaan = edtPekerjaan.getText().toString();
//                final String agama = edtAgama.getText().toString();
//                ApiRequest api = RetrofitConfig.getRetrofit().create(ApiRequest.class);
//                Call<ResponseModel> update = api.updateProfil(nik, nama,alamat,tempat,ttl,pekerjaan,agama);
//                update.enqueue(new Callback<ResponseModel>() {
//                    @Override
//                    public void onResponse(Call<ResponseModel> call, Response<ResponseModel> response) {
//                        Log.d("retro", "response" + response.body().getPesan());
//                        String kode = response.body().getKode();
//                        String pesan = response.body().getPesan();
//                        if (kode.equals("1")){
//                            Toast.makeText(EditProfilActivity.this, pesan, Toast.LENGTH_SHORT).show();
//                            config.saveSPString(config.SP_NAMA, nama);
//                            config.saveSPString(config.SP_ALAMAT, alamat);
//                            config.saveSPString(config.SP_TEMPAT_LAHIR, tempat);
//                            config.saveSPString(config.SP_TTL, ttl);
//                            config.saveSPString(config.SP_PEKERJAAN, pekerjaan);
//                            config.saveSPString(config.SP_AGAMa, agama);
//                            Fragment fragment = null;
//                            fragment = ProfilFragment.newInstance();
//                            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
//                            transaction.replace(R.id.content, fragment);
//                            transaction.commit();
//                            finish();
//                        }else {
//                            Toast.makeText(getApplicationContext(), response.body().getPesan(), Toast.LENGTH_SHORT).show();
//                        }
//
//
//                    }
//
//                    @Override
//                    public void onFailure(Call<ResponseModel> call, Throwable t) {
//                        Log.d("retro", "response" + t.getMessage());
//                        Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_SHORT).show();
//                    }
//                });
//            }
//        });

        btnUpdate2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String nama = edtEditNama.getText().toString();
                final String alamat = edtAlamat.getText().toString();
                final String tempat = edtTempatLahir.getText().toString();
                final String ttl = edtTtl.getText().toString();
                final String pekerjaan = edtPekerjaan.getText().toString();
                final String agama = edtAgama.getText().toString();
                ApiRequest api = RetrofitConfig.getRetrofit().create(ApiRequest.class);
                Call<ResponseModel> update = api.updateProfil(nik, nama,alamat,tempat,ttl,pekerjaan,agama);
                update.enqueue(new Callback<ResponseModel>() {
                    @Override
                    public void onResponse(Call<ResponseModel> call, Response<ResponseModel> response) {
                        Log.d("retro", "response" + response.body().getPesan());
                        String kode = response.body().getKode();
                        String pesan = response.body().getPesan();
                        if (kode.equals("1")){
                            Toast.makeText(EditProfilActivity.this, pesan, Toast.LENGTH_SHORT).show();
                            config.saveSPString(config.SP_NAMA, nama);
                            config.saveSPString(config.SP_ALAMAT, alamat);
                            config.saveSPString(config.SP_TEMPAT_LAHIR, tempat);
                            config.saveSPString(config.SP_TTL, ttl);
                            config.saveSPString(config.SP_PEKERJAAN, pekerjaan);
                            config.saveSPString(config.SP_AGAMa, agama);
//                            Fragment fragment = null;
//                            fragment = ProfilFragment.newInstance();
//                            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
//                            transaction.replace(R.id.content, fragment);
//                            transaction.commit();
//                            finish();
                        }else {
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
                        if (kode.equals("1")){
                            Toast.makeText(EditProfilActivity.this, pesan, Toast.LENGTH_SHORT).show();
//                            config.saveSPString(config.SP_NAMA, nama);
//                            config.saveSPString(config.SP_ALAMAT, alamat);
//                            config.saveSPString(config.SP_TEMPAT_LAHIR, tempat);
//                            config.saveSPString(config.SP_TTL, ttl);
//                            config.saveSPString(config.SP_PEKERJAAN, pekerjaan);
//                            config.saveSPString(config.SP_AGAMa, agama);
                            Fragment fragment = null;
                            fragment = ProfilFragment.newInstance();
                            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                            transaction.replace(R.id.content, fragment);
                            transaction.commit();
                            finish();
                        }else {
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
        btnUpdate2 = (FloatingActionButton)findViewById(R.id.btn_update2);
    }
}
