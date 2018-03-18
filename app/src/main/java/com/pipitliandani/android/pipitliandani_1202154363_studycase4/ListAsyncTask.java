package com.pipitliandani.android.pipitliandani_1202154363_studycase4;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Created by User on 17/03/2018.
 */

public class ListAsyncTask extends AsyncTask<String, Integer, ArrayList> {
    private ListView listView;  //variabel untuk menampung listView
    private ProgressDialog pd;  //variabel untuk menampung ProgressDialog pd
    private int listTotal;  //variabel untuk menampung keseluruhan list

    public ListAsyncTask(ListView listView, ProgressDialog pd) {
        this.listView = listView;   //this.listView = listView
        this.pd = pd;              //this.pd = pd
    }

    @Override
    protected void onPreExecute() {     //membuat method untuk melakukan proses sebelum proses background dimulai
        pd.setMessage("0%");            //menginisiasi dan mengatur message sama dengan 0%
        pd.show();                      //menampilkan pesan
    }

    @Override
    protected void onPostExecute(ArrayList list) {
        //membuat variabel ArrayAdapter bernama array, berjenis string, context ListNamaMahasiswa, layout simple_listitem_1, sesuai dengan list yang ditampilkan
        ArrayAdapter<String> array = new ArrayAdapter<String>(ListNamaMahasiswa.context, android.R.layout.simple_list_item_1, list);
        //mangatur adapter listView dengan adapter array
        listView.setAdapter(array);
        //menutup progress dialog
        pd.dismiss();
    }

    @Override
    protected ArrayList<String> doInBackground(String... strings) {  //membuat method untuk process background
        int total = strings.length;     //membuat variabel untuk menampung total panjang array
        ArrayList<String> list = new ArrayList<>(); //menginisiasi arraylist
        this.listTotal = total;
        for (int i = 0; i < total; i ++) {      //membuat perulangan
            list.add(strings[i]);   //menampung string yang sudah di load ke variabel list
            publishProgress(i);   //mempublish progress index
            if(isCancelled()) break;        //menghentikan perulangan
        }
        return list;     //mengembalikan nilai string
    }

    @Override
    protected void onProgressUpdate(Integer... values) {    //membuat method untuk menampilkan proses update
        int progres = (int)((values[0]/(float) this.listTotal) * 100);  //memmbuat progress dalam bentuk persen
        pd.setMessage(progres+"%");                       //menampilkan pesan progress dalam bentuk persen
    }
}
