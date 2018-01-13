package creative.can.com.suratpengantar.Activity;

import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import com.rengwuxian.materialedittext.MaterialEditText;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

import creative.can.com.suratpengantar.R;
import creative.can.com.suratpengantar.helper.Config;

public class SuratKetNikahActivity extends AppCompatActivity {

    String ambil_jk;


    DatePickerDialog datePickerDialog, datePickerDialog2;
    int mYear;
    int mMonth;
    int mDay;

    Config config;
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
    private LinearLayout layoutNikah;
    private MaterialEditText edtNik2;
    private MaterialEditText edtKk2;
    private MaterialEditText edtNama2;
    private MaterialEditText edtPekerjaan2;
    private MaterialEditText edtTempatLahir2;
    private MaterialEditText edtAgama2;
    private MaterialEditText edtTanggal2;
    private RadioGroup rbgKelamin2;
    private RadioButton rbPria2;
    private RadioButton rbWanita2;
    private MaterialEditText edtAlamat2;
    private MaterialEditText edtKelurahan2;
    private MaterialEditText edtRt2;
    private MaterialEditText edtRw2;
    private MaterialEditText edtKecamatan2;
    private MaterialEditText edtKabupaten2;
    private MaterialEditText edtProvinsi2;
    private MaterialEditText edtStatusNikah2;
    private MaterialEditText edtWarganegara2;
    private MaterialEditText edtStatusKk2;
    private MaterialEditText edtPendidikan2;
    private MaterialEditText tglKirim;
    private Button btnDaftar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_surat_ket_nikah);
        initView();

        config = new Config(this);
        awal();

        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);

        // datePicker
        datePickerDialog = new
                DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                mYear = year;
                mMonth = month;
                mDay = dayOfMonth;

                GregorianCalendar c = new GregorianCalendar(mYear, mMonth, mDay);
                SimpleDateFormat sdf = new SimpleDateFormat("dd MMMM yyyy");

                edtTanggal.setText(sdf.format(c.getTime()));

                edtTanggal.setFocusable(false);
                edtTanggal.setCursorVisible(false);
                //edtTanggal.setText(tanggal);

            }
        }, year, month, day);

        datePickerDialog2 = new
                DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                mYear = year;
                mMonth = month;
                mDay = dayOfMonth;

                GregorianCalendar c = new GregorianCalendar(mYear, mMonth, mDay);
                SimpleDateFormat sdf = new SimpleDateFormat("dd MMMM yyyy");

                edtTanggal2.setText(sdf.format(c.getTime()));

                edtTanggal2.setFocusable(false);
                edtTanggal2.setCursorVisible(false);
                //edtTanggal.setText(tanggal);

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
                                tglKirim.setHint(dateString + "   " + timeString);
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
        edtTanggal2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                datePickerDialog2.show();
            }
        });

        btnDaftar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

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
                if(!validasi()){
                    return;
                }
                Toast.makeText(getApplicationContext(), "Fitur Belum ada", Toast.LENGTH_SHORT).show();
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

        edtRt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final CharSequence[] dialogItem = {"1", "2", "3", "4", "5", "6"};
                AlertDialog.Builder builder = new AlertDialog.Builder(view.getContext());
                builder.setTitle("Pilih RT");
                builder.setItems(dialogItem, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                        switch (i) {
                            case 0:
                                edtRt.setText("1");
                                break;
                            case 1:
                                edtRt.setText("2");
                                break;
                            case 2:
                                edtRt.setText("3");
                                break;
                            case 3:
                                edtRt.setText("4");
                                break;
                            case 4:
                                edtRt.setText("5");
                                break;
                            case 5:
                                edtRt.setText("6");
                                break;
                        }
                    }
                });
                builder.create().show();
            }
        });

        edtRw.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                final CharSequence[] dialogItem = {"1", "2", "3", "4", "5", "6"};
                AlertDialog.Builder builder = new AlertDialog.Builder(view.getContext());
                builder.setTitle("Pilih RW");
                builder.setItems(dialogItem, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                        switch (i) {
                            case 0:
                                edtRw.setText("1");
                                break;
                            case 1:
                                edtRw.setText("2");
                                break;
                            case 2:
                                edtRw.setText("3");
                                break;
                            case 3:
                                edtRw.setText("4");
                                break;
                            case 4:
                                edtRw.setText("5");
                                break;
                            case 5:
                                edtRw.setText("6");
                                break;
                        }
                    }
                });
                builder.create().show();
            }
        });

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

        edtPekerjaan2.setOnClickListener(new View.OnClickListener() {
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
                                edtPekerjaan2.setText("PNS");
                                break;
                            case 1:
                                edtPekerjaan2.setText("Wirausaha");
                                break;
                            case 2:
                                edtPekerjaan2.setText("Swasta");
                                break;
                            case 3:
                                edtPekerjaan2.setText("Buruh");
                                break;
                            case 4:
                                edtPekerjaan2.setText("Lainnya");
                                break;
                        }
                    }
                });
                builder.create().show();
            }
        });

        edtAgama2.setOnClickListener(new View.OnClickListener() {
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
                                edtAgama2.setText("Islam");
                                break;
                            case 1:
                                edtAgama2.setText("Kristen");
                                break;
                            case 2:
                                edtAgama2.setText("Katolik");
                                break;
                            case 3:
                                edtAgama2.setText("Hindu");
                                break;
                            case 4:
                                edtAgama2.setText("Budha");
                                break;
                        }
                    }
                });
                builder.create().show();
            }
        });

        edtStatusNikah2.setOnClickListener(new View.OnClickListener() {
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
                                edtStatusNikah2.setText("Nikah");
                                break;
                            case 1:
                                edtStatusNikah2.setText("Lajang");
                                break;
                            case 2:
                                edtStatusNikah2.setText("Cerai Hidup");
                                break;
                            case 3:
                                edtStatusNikah2.setText("Cerai Mati");
                                break;
                        }
                    }
                });
                builder.create().show();
            }
        });

        edtStatusKk2.setOnClickListener(new View.OnClickListener() {
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
                                edtStatusKk2.setText("Anak");
                                break;
                            case 1:
                                edtStatusKk2.setText("Suami");
                                break;
                            case 2:
                                edtStatusKk2.setText("Isteri");
                                break;
                            case 3:
                                edtStatusKk2.setText("Cucu");
                                break;
                        }
                    }
                });
                builder.create().show();
            }
        });

        edtPendidikan2.setOnClickListener(new View.OnClickListener() {
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
                                edtPendidikan2.setText("SD");
                                break;
                            case 1:
                                edtPendidikan2.setText("SMP");
                                break;
                            case 2:
                                edtPendidikan2.setText("SMA");
                                break;
                            case 3:
                                edtPendidikan2.setText("D3");
                                break;
                            case 4:
                                edtPendidikan2.setText("Sarjana");
                                break;
                            case 5:
                                edtPendidikan2.setText("Lainnya");
                                break;
                        }
                    }
                });
                builder.create().show();
            }
        });

//        edtKelurahan2.setOnClickListener(new View.OnClickListener() {
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

        edtRt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final CharSequence[] dialogItem = {"1", "2", "3", "4", "5", "6"};
                AlertDialog.Builder builder = new AlertDialog.Builder(view.getContext());
                builder.setTitle("Pilih RT");
                builder.setItems(dialogItem, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                        switch (i) {
                            case 0:
                                edtRt2.setText("1");
                                break;
                            case 1:
                                edtRt2.setText("2");
                                break;
                            case 2:
                                edtRt2.setText("3");
                                break;
                            case 3:
                                edtRt2.setText("4");
                                break;
                            case 4:
                                edtRt2.setText("5");
                                break;
                            case 5:
                                edtRt2.setText("6");
                                break;
                        }
                    }
                });
                builder.create().show();
            }
        });

        edtRw2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                final CharSequence[] dialogItem = {"1", "2", "3", "4", "5", "6"};
                AlertDialog.Builder builder = new AlertDialog.Builder(view.getContext());
                builder.setTitle("Pilih RW");
                builder.setItems(dialogItem, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                        switch (i) {
                            case 0:
                                edtRw2.setText("1");
                                break;
                            case 1:
                                edtRw2.setText("2");
                                break;
                            case 2:
                                edtRw2.setText("3");
                                break;
                            case 3:
                                edtRw2.setText("4");
                                break;
                            case 4:
                                edtRw2.setText("5");
                                break;
                            case 5:
                                edtRw2.setText("6");
                                break;
                        }
                    }
                });
                builder.create().show();
            }
        });

//        edtKecamatan2.setOnClickListener(new View.OnClickListener() {
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

    private void initView() {
        edtNamaSurat = (MaterialEditText) findViewById(R.id.edt_nama_surat);
        edtNik = (MaterialEditText) findViewById(R.id.edt_nik);
        edtNama = (MaterialEditText) findViewById(R.id.edt_nama);
        edtPekerjaan = (MaterialEditText) findViewById(R.id.edt_pekerjaan);
        edtTempatLahir = (MaterialEditText) findViewById(R.id.edt_tempat_lahir);
        edtAgama = (MaterialEditText) findViewById(R.id.edt_agama);
        edtTanggal = (MaterialEditText) findViewById(R.id.edt_tanggal);
        edtAlamat = (MaterialEditText) findViewById(R.id.edt_alamat);
        layoutNikah = (LinearLayout) findViewById(R.id.layout_nikah);
        edtNik2 = (MaterialEditText) findViewById(R.id.edt_nik2);
        edtNama2 = (MaterialEditText) findViewById(R.id.edt_nama2);
        edtTempatLahir2 = (MaterialEditText) findViewById(R.id.edt_tempat_lahir2);
        edtPekerjaan2 = (MaterialEditText) findViewById(R.id.edt_pekerjaan2);
        edtAgama2 = (MaterialEditText) findViewById(R.id.edt_agama2);
        edtAlamat2 = (MaterialEditText) findViewById(R.id.edt_alamat2);
        tglKirim = (MaterialEditText) findViewById(R.id.tgl_kirim);
        btnDaftar = (Button) findViewById(R.id.btn_daftar);
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
        layoutNikah = (LinearLayout) findViewById(R.id.layout_nikah);
        edtNik2 = (MaterialEditText) findViewById(R.id.edt_nik2);
        edtKk2 = (MaterialEditText) findViewById(R.id.edt_kk2);
        edtNama2 = (MaterialEditText) findViewById(R.id.edt_nama2);
        edtPekerjaan2 = (MaterialEditText) findViewById(R.id.edt_pekerjaan2);
        edtTempatLahir2 = (MaterialEditText) findViewById(R.id.edt_tempat_lahir2);
        edtAgama2 = (MaterialEditText) findViewById(R.id.edt_agama2);
        edtTanggal2 = (MaterialEditText) findViewById(R.id.edt_tanggal2);
        rbgKelamin2 = (RadioGroup) findViewById(R.id.rbg_kelamin2);
        rbPria2 = (RadioButton) findViewById(R.id.rb_pria2);
        rbWanita2 = (RadioButton) findViewById(R.id.rb_wanita2);
        edtAlamat2 = (MaterialEditText) findViewById(R.id.edt_alamat2);
        edtKelurahan2 = (MaterialEditText) findViewById(R.id.edt_kelurahan2);
        edtRt2 = (MaterialEditText) findViewById(R.id.edt_rt2);
        edtRw2 = (MaterialEditText) findViewById(R.id.edt_rw2);
        edtKecamatan2 = (MaterialEditText) findViewById(R.id.edt_kecamatan2);
        edtKabupaten2 = (MaterialEditText) findViewById(R.id.edt_kabupaten2);
        edtProvinsi2 = (MaterialEditText) findViewById(R.id.edt_provinsi2);
        edtStatusNikah2 = (MaterialEditText) findViewById(R.id.edt_status_nikah2);
        edtWarganegara2 = (MaterialEditText) findViewById(R.id.edt_warganegara2);
        edtStatusKk2 = (MaterialEditText) findViewById(R.id.edt_status_kk2);
        edtPendidikan2 = (MaterialEditText) findViewById(R.id.edt_pendidikan2);
        tglKirim = (MaterialEditText) findViewById(R.id.tgl_kirim);
        btnDaftar = (Button) findViewById(R.id.btn_daftar);
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
        edtNama.setText(config.getSPNama());
        edtNik.setText(config.getSpId());
        rbPria2.setChecked(true);

        ambil_jk = config.getSpJk();
        if (ambil_jk.contains("1")){
            rbPria.setChecked(true);
        }else {
            rbWanita.setChecked(true);
        }

        //edtIdSurat.setText("2");
        edtNamaSurat.setText("Surat Keterangan Nikah");
        edtWarganegara.setText("WNI");
        edtIdSurat.setFocusable(false);
        edtNamaSurat.setFocusable(false);
        edtNik.setFocusable(false);
        edtKk.setFocusable(false);

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

        edtTanggal2.setFocusable(false);
        edtStatusNikah2.setFocusable(false);
        edtStatusKk2.setFocusable(false);
        edtAgama2.setFocusable(false);
        edtPekerjaan2.setFocusable(false);
        edtPendidikan2.setFocusable(false);
        //edtKelurahan2.setFocusable(false);
        edtRt2.setFocusable(false);
        edtRw2.setFocusable(false);
        //edtKecamatan2.setFocusable(false);
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

        if (edtNik2.getText().toString().isEmpty()){
            edtNik2.setError("Harus diisi");
            edtNik2.requestFocus();
            return false;
        }
        if (edtKk2.getText().toString().isEmpty()){
            edtKk2.setError("Harus diisi");
            edtKk2.requestFocus();
            return false;
        }
        if (edtNama2.getText().toString().isEmpty()){
            edtNama2.setError("Harus diisi");
            edtNama2.requestFocus();
            return false;
        }

        if (edtPekerjaan2.getText().toString().isEmpty()){
            edtPekerjaan2.setError("Harus diisi");
            edtPekerjaan2.requestFocus();
            return false;
        }
        if (edtTempatLahir2.getText().toString().isEmpty()){
            edtTempatLahir2.setError("Harus diisi");
            edtTempatLahir2.requestFocus();
            return false;
        }
        if (edtAgama2.getText().toString().isEmpty()){
            edtAgama2.setError("Harus diisi");
            edtAgama2.requestFocus();
            return false;
        }
        if (edtTanggal2.getText().toString().isEmpty()){
            edtTanggal2.setError("Harus diisi");
            edtTanggal2.requestFocus();
            return false;
        }
        if (edtAlamat2.getText().toString().isEmpty()){
            edtAlamat2.setError("Harus diisi");
            edtAlamat2.requestFocus();
            return false;
        }
        if (edtKelurahan2.getText().toString().isEmpty()){
            edtKelurahan2.setError("Harus diisi");
            edtKelurahan2.requestFocus();
            return false;
        }
        if (edtRt2.getText().toString().isEmpty()){
            edtRt2.setError("Harus diisi");
            edtRt2.requestFocus();
            return false;
        }
        if (edtRw2.getText().toString().isEmpty()){
            edtRw2.setError("Harus diisi");
            edtRw2.requestFocus();
            return false;
        }
        if (edtKecamatan2.getText().toString().isEmpty()){
            edtKecamatan2.setError("Harus diisi");
            edtKecamatan2.requestFocus();
            return false;
        }
        if (edtKabupaten2.getText().toString().isEmpty()){
            edtKabupaten2.setError("Harus diisi");
            edtKabupaten2.requestFocus();
            return false;
        }
        if (edtProvinsi2.getText().toString().isEmpty()){
            edtProvinsi2.setError("Harus diisi");
            edtProvinsi2.requestFocus();
            return false;
        }
        if (edtStatusNikah2.getText().toString().isEmpty()){
            edtStatusNikah2.setError("Harus diisi");
            edtStatusNikah2.requestFocus();
            return false;
        }
        if (edtWarganegara2.getText().toString().isEmpty()){
            edtWarganegara2.setError("Harus diisi");
            edtWarganegara2.requestFocus();
            return false;
        }
        if (edtStatusKk2.getText().toString().isEmpty()){
            edtStatusKk2.setError("Harus diisi");
            edtStatusKk2.requestFocus();
            return false;
        }
        if (edtPendidikan2.getText().toString().isEmpty()){
            edtPendidikan2.setError("Harus diisi");
            edtPendidikan2.requestFocus();
            return false;
        }
        return true;
    }
}
