package com.pipitliandani.android.pipitliandani_1202154363_studycase4;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Collections;

public class MainActivity extends AppCompatActivity {
    private String[] menu = {"Daftar Mahasiswa", "Cari Gambar"};    //membuat String Array
    private ArrayList data;     //mendeklarasikan arraylist

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListView listView = (ListView)findViewById(R.id.listView);      //mencari listView dengan id listView
        data = new ArrayList(); //menginisialisasi arrayList
        getData();              //mendapatkan data
        //membuat variabel array adapter
        ArrayAdapter adapter = new ArrayAdapter(this, R.layout.support_simple_spinner_dropdown_item, data);
        //mengatur adapter listView
        listView.setAdapter(adapter);
        //membuat event ketika list di klik
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position==0){   //jika position sama dengan nol
                    //maka akan berpindah ke class ListMahasiswa
                    Intent intent = new Intent(MainActivity.this, ListNamaMahasiswa.class);
                    //memulai aktivitas intent
                    startActivity(intent);

                }else { //jika position tidak sama nol
                    //maka akan berpindah ke class cari gambar
                    Intent intent = new Intent(MainActivity.this, CariGambar.class);
                    //memulai aktivitas intent
                    startActivity(intent);
                }
            }
        });
    }
    //membuat method get data untuk mengambil data dari variabel menu
    private void getData(){
        Collections.addAll(data, menu);
    }
}
