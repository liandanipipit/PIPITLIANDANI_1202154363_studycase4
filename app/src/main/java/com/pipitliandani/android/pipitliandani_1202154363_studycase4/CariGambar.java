package com.pipitliandani.android.pipitliandani_1202154363_studycase4;


import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

public class CariGambar extends AppCompatActivity {
    EditText mUrl;  //mendeklarasikan variabel url
    Button mfind;   //mendeklarasikan variabel button
    ImageView img;  //mendeklarasikan variabel image
    private ImageAsyncTask task;
    ProgressDialog progressDialog;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cari_gambar);
        mUrl = (EditText) findViewById(R.id.url);       //mencari EditText dengan nilai url
        mfind = (Button) findViewById(R.id.cariGambar); //mencari EditText dengan nilai cariGambar
        progressDialog = new ProgressDialog(this);
        img = (ImageView) findViewById(R.id.imageView); //mencari EditText dengan nilai imageView
        mfind.setOnClickListener(new View.OnClickListener() {   //membuat method ketika button mFind diklik
            @Override
            public void onClick(View v) {
                task = new ImageAsyncTask(img, progressDialog);
                task.execute(mUrl.getText().toString());
                //memanggil class ImageAsyncTask dan mengeksekusi AsyncTask dari String mUrl
            }
        });
    }
}
