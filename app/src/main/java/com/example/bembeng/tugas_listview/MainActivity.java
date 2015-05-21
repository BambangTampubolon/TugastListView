package com.example.bembeng.tugas_listview;

import android.support.v4.util.SimpleArrayMap;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;
import java.util.*;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.app.AlertDialog;
import android.content.DialogInterface;


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
        editInput= (EditText) findViewById(R.id.editText_input);

        ListBook.add("Laskar Pelangi");
        ListBook.add(" 5 cm");
        ListBook.add("Ayat ayat cinta");
        ListBook.add("Lima Menara");
        ListBook.add("Tutorial Pemrograman Android");

        adapter= new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,ListBook);
        ListBook.setAdapter(adapter);

        ListBook.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void  onItemClick(AdapterView<?> parent, View view, int position, long id){
                String clickedItem= (String) parent.getAdapter().getItem(position);
                Log.d("booklogger", clickedItem);
            }
        });

        ListBook.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener(){
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id){
                String longClickedItem= (String) parent.getAdapter().getItem(position);
                Log.d("booklogger", longClickedItem);
                showDeleteDialog(longClickedItem);
                return false;
            }
        });

        butSimpan.setOnClickListener(new  View.OnClickListener(){
            @Override
            public void onClick(View v){
                String title = editInput.getText().toString();
                if(!title.isEmpty()){
                    ListBook.add(title);
                    adapter.notifyDataSetChanged();
                    editInput.setText("");
                }else{
                    Toast.makeText(getApplicationContext(),"judul buku wajib diisi", Toast.LENGTH_SHORT).show();
                }
            }
        });
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

    private  void showDeleteDialog(final String bookTitle){
        AlertDialog.Builder deleteDialog= new AlertDialog.Builder(this);
        deleteDialog.setMessage("anda yakin untuk menghapus \n"+bookTitle+"?");
        deleteDialog.setPositiveButton("Ya", new DialogInterface.OnClickListener(){
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
                ListBook.remove(bookTitle);
                adapter.notifyDataSetChanged();
            }
        });
        deleteDialog.setNegativeButton("Tidak", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        deleteDialog.show();
    }
}
