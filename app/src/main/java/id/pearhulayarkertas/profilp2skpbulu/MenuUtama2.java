package id.pearhulayarkertas.profilp2skpbulu;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MenuUtama2 extends AppCompatActivity {

    private boolean doubleBackToExitPressedOnce;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_utama2);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        profilpelabuhan();
        fasilitas();
        beritapipp();
        cuaca();
        tentangku();
        keluarappku();
    }

    private void cuaca() {
        final Context context = this;
        Button button = (Button) findViewById(R.id.cuaca);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                Intent intent = new Intent(context, PrakiraanCuaca.class);
                MenuUtama2.this.finish();
                startActivity(intent);

            }

        });
    }

    private void keluarappku() {
        final Context context = this;
        Button button = (Button) findViewById(R.id.Keluar);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                keluarapp();

            }

        });
    }

    private void tentangku() {
        final Context context = this;
        Button button = (Button) findViewById(R.id.tentangappku);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                Intent intent = new Intent(context, TentangAplikasi.class);
                MenuUtama2.this.finish();
                startActivity(intent);

            }

        });
    }

    private void fasilitas() {
        final Context context = this;
        Button button = (Button) findViewById(R.id.fasilitas);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                Intent intent = new Intent(context, FasilitasPelabuhan.class);
                MenuUtama2.this.finish();
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
                MenuUtama2.this.finish();
                startActivity(intent);

            }

        });
    }

    private void profilpelabuhan() {
        final Context context = this;
        Button button = (Button) findViewById(R.id.profil);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                Intent intent = new Intent(context, KataPengantar.class);
                MenuUtama2.this.finish();
                startActivity(intent);

            }

        });


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
                                MenuUtama2.this.finish();

                            }
                        })
                .setNegativeButton("Tidak", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog,
                                        int id) {
                        dialog.cancel();

                    }
                }).show();
    }

        @Override
        public void onBackPressed () {
            DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
            if (drawer.isDrawerOpen(GravityCompat.START)) {
                drawer.closeDrawer(GravityCompat.START);
            } else if (doubleBackToExitPressedOnce) {
                super.onBackPressed();
                return;
            }

            this.doubleBackToExitPressedOnce = true;
            Toast.makeText(this, "Tekan Kembali Untuk Keluar", Toast.LENGTH_SHORT).show();
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    doubleBackToExitPressedOnce = false;
                }
            }, 2000);
        }

    }


