package com.pipitliandani.android.pipitliandani_1202154363_studycase4;

import android.app.ProgressDialog;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.widget.ImageView;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

/**
 * Created by User on 18/03/2018.
 */

public class ImageAsyncTask extends AsyncTask<String, Void, Bitmap> {
    ImageView im = null;    //variabel untuk menampung imageView
    ProgressDialog progressDialog;
    private int bitTotal;  //variabel untuk menampung keseluruhan bit

    public ImageAsyncTask(ImageView im, ProgressDialog progressDialog){

        this.im = im;   //this im = im
        this.progressDialog = progressDialog;  //this.progressDialog = progressDialog
    }
    @Override
    protected void onPreExecute() {     //membuat method untuk melakukan proses sebelum proses background dimulai
        progressDialog.setMessage("Loading...");            //menginisiasi dan mengatur message sama dengan 0%
        progressDialog.show();                      //menampilkan pesan
    }
    @Override
    protected Bitmap doInBackground(String... url) {    //membuat method untuk menjalankan proses background
        //membuat variabel bitmap untuk menyimpan gambar berupa bitmap dari method download image
        Bitmap bm = downloadImage(url[0]);
        return bm; //mengembalikan nilai bm
    }

    private Bitmap downloadImage(String url) {  //membuat method untuk mendownload image
        Bitmap bm = null;   //menampung variabel Bitmap

        try{
            URL _url = new URL(url);    //membuat variabel untuk menyimpan url
            URLConnection urlCon = _url.openConnection();   //membuat koneksi dari url
            urlCon.connect();   //melakukan koneksi
            InputStream is = urlCon.getInputStream();   //membuat variabel input stream
            BufferedInputStream bis = new BufferedInputStream(is);  //membuat variabel BufferedInputStream dengan nilai is
            bm = BitmapFactory.decodeStream(bis);   //menyimpan variabel bis ke variabel bm
            bis.close();    //menutup BufferedInputStream
            is.close();     //menutup InputStream
        } catch (IOException e) {   //menangkap error berupa input output
            e.printStackTrace();    //menampilkan errornya
        }

        return bm; //mengembalikan nilai variabel bm
    }

    @Override
    protected void onPostExecute(Bitmap bitmap) {   //membuat method untuk menampilkan proses background

        im.setImageBitmap(bitmap);  //menampilkan gambar
        progressDialog.dismiss();
    }
}
