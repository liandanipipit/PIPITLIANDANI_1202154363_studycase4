package com.pipitliandani.android.pipitliandani_1202154363_studycase4;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;


public class ListNamaMahasiswa extends AppCompatActivity {
    private TextView mTextView;     //mendeklarasikan variabel mTextView
    private ListView mahasiswa;     //mendeklarasikan variabel mMahasiswa
    private Button button;          //mendeklarasikan variabel button
    public static Context context;  //mendeklarasikan variabel context
    private ProgressDialog pd;      //mendeklarasikan variabel pd
    private ListAsyncTask task;     //mendeklarasikan variabel task

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_nama_mahasiswa);
        ListNamaMahasiswa.context = getApplicationContext();    //membuat context
        mTextView = (TextView)findViewById(R.id.textView);      //mencari textview dengan id textview
        mahasiswa = (ListView)findViewById(R.id.mahasiswa);     //mencari ListView dengan id mahasiswa
        pd = new ProgressDialog(this);                  //menginisiasi progress dialog sesuai dengan activity context
        button = (Button) findViewById(R.id.button);            //mencari Button dengan id button
        pd.setCancelable(false);                                //mengatur tombol cancel pada progress dialog bernilai false
        pd.setButton(DialogInterface.BUTTON_NEGATIVE, "Cancel", new DialogInterface.OnClickListener() {     //mengatur event saat tombol false diklik
            @Override
            public void onClick(DialogInterface dialog, int which) {
                task.cancel(true);  //meng- cancel AsincTask
                pd.dismiss();       //menghilangkan progress dialog
            }
        });
        button.setOnClickListener(new View.OnClickListener() {   //membuat event ketika button diklik
            @Override
            public void onClick(View v) {
                //membuat objek AsyncTask
                task = new ListAsyncTask(mahasiswa, pd);
                //mengeksekusi AsyncTask dari String mahasiswa_list
                task.execute(getResources().getStringArray(R.array.mahasiswa_list));
            }
        });
    }
}
