package com.example.bembeng.tugas_listview;

import android.support.v4.util.SimpleArrayMap;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import java.util.*;


public class MainActivity extends ActionBarActivity {

    Button butSimpan;
    ListView listBuku;
    EditText editInput;

    ArrayList<String> ListBook= new ArrayList<>();

    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listBuku=(ListView) findViewById(R.id.list_output);
        butSimpan=(Button) findViewById(R.id.btn_simpan);
        editText = (EditText) findViewById(R.id.editText_input);

        ListBook.add("Laskar Pelangi");
        ListBook.add(" 5 cm");
        ListBook.add("Ayat ayat cinta");
        ListBook.add("Lima Menara");
        ListBook.add("Tutorial Pemrograman Android");

        adapter= new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,ListBook);
        ListBook.setAdapter(adapter);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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
}
