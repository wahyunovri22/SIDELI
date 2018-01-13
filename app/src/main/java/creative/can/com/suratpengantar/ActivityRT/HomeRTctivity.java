package creative.can.com.suratpengantar.ActivityRT;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentManager;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import creative.can.com.suratpengantar.Activity.SettingActivity;
import creative.can.com.suratpengantar.Activity.UserActivity;
import creative.can.com.suratpengantar.Fragment.HistoryFragment;
import creative.can.com.suratpengantar.Fragment.HistoryRTFragment;
import creative.can.com.suratpengantar.Fragment.NewsFragment;
import creative.can.com.suratpengantar.Fragment.PermintaanSuratMasukFragment;
import creative.can.com.suratpengantar.Fragment.ProfilFragment;
import creative.can.com.suratpengantar.Fragment.SuratMenungguDiketahuiFragment;
import creative.can.com.suratpengantar.Fragment.SuratPendingFragment;
import creative.can.com.suratpengantar.Fragment.SuratPendingRTFragment;
import creative.can.com.suratpengantar.Fragment.TambahWargaFragment;
import creative.can.com.suratpengantar.Fragment.WaitingFragment;
import creative.can.com.suratpengantar.LoginActivity;
import creative.can.com.suratpengantar.R;
import creative.can.com.suratpengantar.helper.Config;

public class HomeRTctivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    TextView nama,nik,posisiRT,posisiRW;
    Config config;
    Handler handler = new Handler();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_rtctivity);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Intent getData = getIntent();

        config = new Config(this);
        this.handler = new Handler();
        this.handler.postDelayed(runnable, 3000);


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        View header=navigationView.getHeaderView(0);
/*View view=navigationView.inflateHeaderView(R.layout.nav_header_main);*/
        nama = (TextView)header.findViewById(R.id.txt_nama_user);
        nik = (TextView)header.findViewById(R.id.txt_nik_user);
        posisiRT = (TextView)header.findViewById(R.id.txt_posisi_user);
        posisiRW = (TextView)header.findViewById(R.id.txt_posisi_RW);
        nama.setText(config.getSPNama());
        nik.setText(config.getSpId());
        posisiRT.setText(config.getSpPosisirt());
        posisiRW.setText(config.getSpPosisirw());

        FragmentManager manajer = getSupportFragmentManager();
        manajer.beginTransaction()
                .replace(R.id.layout_content_rt, new NewsFragment())
                .commit();
        getSupportActionBar().setTitle("News");
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            //super.onBackPressed();
            new AlertDialog.Builder(this)
                    .setMessage("Apakah Anda ingin keluar?")
                    .setCancelable(false)
                    .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            HomeRTctivity.this.finish();
                        }
                    })
                    .setNegativeButton("No", null)
                    .show();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.home_rtctivity, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_news){
            FragmentManager manajer = getSupportFragmentManager();
            manajer.beginTransaction()
                    .replace(R.id.layout_content_rt, new NewsFragment())
                    .commit();
            getSupportActionBar().setTitle("News");
        }
        if (id == R.id.nav_profil) {
            // Handle the camera action
            ProfilFragment mFragment = new ProfilFragment();
            Bundle nilai = new Bundle();
            String mNama = nama.getText().toString();
            String mNik = nik.getText().toString();
            nilai.putString("nama", mNama);
            nilai.putString("nik", mNik);
            mFragment.setArguments(nilai);
            FragmentManager manajer = getSupportFragmentManager();
            manajer.beginTransaction()
                    .replace(R.id.layout_content_rt, mFragment)
                    .commit();
            getSupportActionBar().setTitle("Profil");
        } else if (id == R.id.nav_surat_menunggu) {
            FragmentManager manajer = getSupportFragmentManager();
            manajer.beginTransaction()
                    .replace(R.id.layout_content_rt, new WaitingFragment())
                    .commit();
            getSupportActionBar().setTitle("Surat Menunggu Diketahui");
        } else if (id == R.id.nav_surat_masuk) {
            FragmentManager manajer = getSupportFragmentManager();
            manajer.beginTransaction()
                    .replace(R.id.layout_content_rt, new PermintaanSuratMasukFragment())
                    .commit();
            getSupportActionBar().setTitle("Surat Masuk");
        } else if (id == R.id.nav_pending) {
            FragmentManager manajer = getSupportFragmentManager();
            manajer.beginTransaction()
                    .replace(R.id.layout_content_rt, new SuratPendingRTFragment())
                    .commit();
            getSupportActionBar().setTitle("Surat Pending");
        }  else if (id == R.id.nav_tambah_warga) {
        FragmentManager manajer = getSupportFragmentManager();
        manajer.beginTransaction()
                .replace(R.id.layout_content_rt, new TambahWargaFragment())
                .commit();
        getSupportActionBar().setTitle("Tambah Warga");
    } else if (id == R.id.nav_history) {
            FragmentManager manajer = getSupportFragmentManager();
            manajer.beginTransaction()
                    .replace(R.id.layout_content_rt, new HistoryRTFragment())
                    .commit();
            getSupportActionBar().setTitle("History");
        } else if (id == R.id.nav_setting) {
            Intent intent = new Intent(getApplicationContext(), SettingActivity.class);
            startActivity(intent);
        } else if (id == R.id.nav_logut) {
            config.saveSPBoolean(config.SP_SUDAH_LOGIN, false);
            startActivity(new Intent(getApplicationContext(), LoginActivity.class)
                    .addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK));
            finish();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
    public final Runnable runnable = new Runnable() {
        @Override
        public void run() {
            nama.setText(config.getSPNama());
            nik.setText(config.getSpId());
            HomeRTctivity.this.handler.postDelayed(runnable, 3000);
        }
    };
}
