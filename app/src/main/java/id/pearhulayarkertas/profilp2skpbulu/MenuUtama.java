package id.pearhulayarkertas.profilp2skpbulu;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import com.google.android.material.navigation.NavigationView;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MenuUtama extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private boolean doubleBackToExitPressedOnce;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_utama);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        profilpelabuhan();
        fasilitas();
        beritapipp();

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    private void fasilitas() {
        final Context context = this;
        Button button = (Button) findViewById(R.id.fasilitas);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                Intent intent = new Intent(context, FasilitasPelabuhan.class);
                MenuUtama.this.finish();
                startActivity(intent);

            }

        });
    }

    private void beritapipp() {
        final Context context = this;
        Button button = (Button) findViewById(R.id.pipp);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                Intent intent = new Intent(context, BeritaPIPP.class);
                MenuUtama.this.finish();
                startActivity(intent);

            }

        });
    }

    private void profilpelabuhan() {
        final Context context = this;
        Button button = (Button) findViewById(R.id.Profil);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                Intent intent = new Intent(context, KataPengantar.class);
                MenuUtama.this.finish();
                startActivity(intent);

            }

        });
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        }else if (doubleBackToExitPressedOnce) {
            super.onBackPressed();
            return;
        }

        this.doubleBackToExitPressedOnce = true;
        Toast.makeText(this, "Tekan Kembali Untuk Keluar", Toast.LENGTH_SHORT).show();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                doubleBackToExitPressedOnce=false;
            }
        }, 2000);
    }




    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
           profil();
        } else if (id == R.id.nav_gallery) {
            kepala();
        } else if (id == R.id.nav_manage) {
            tentang();
        }
    else if (id == R.id.Keluar) {
        keluarapp();
    }

    DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    private void kepala() {
        startActivity(new Intent(MenuUtama.this, KepalaUPT.class));
        MenuUtama.this.finish();
    }

    private void tentang() {
        startActivity(new Intent(MenuUtama.this, TentangAplikasi.class));
        MenuUtama.this.finish();
    }

    private void keluarapp() {
        AlertDialog.Builder builder;
        builder = new AlertDialog.Builder(this);
        AlertDialog show = builder.setMessage("Apakah Anda Ingin Keluar?")
                .setIcon(R.mipmap.logoappp2skp)
                .setCancelable(false)
                .setPositiveButton("Ya",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog,
                                                int id) {
                                MenuUtama.this.finish();

                            }
                        })
                .setNegativeButton("Tidak", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog,
                                        int id) {
                        dialog.cancel();

                    }
                }).show();
    }

    private void profil() {
        startActivity(new Intent(MenuUtama.this, KataPengantar.class));
        MenuUtama.this.finish();
    }
}
