package com.example.onthigk;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.FileOutputStream;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    TextView id,danhmuc;
    EditText editText_id;
    Button btn_luu, btn_next;
  //  ArrayList<String> arrayList;
   // String filename="aa";
   // ArrayAdapter<String> arrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        connect();
        eventSave();
        eventClickViewFile();

                try {
                    String data = getIntent().getExtras().getString("arr");
                    danhmuc.setText("Danh Mục Mà Bạn Đã Chọn Là :"+"\n"+data);
                }catch (Exception e){
                    e.printStackTrace();
                }
    }

    private void eventClickViewFile() {
        btn_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(MainActivity.this,Main2Activity.class);

                startActivity(intent);
            }
        });
    }
    public void eventSave() {
        btn_luu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String maban = id.getText().toString();
                String danhmuc_luu = danhmuc.getText().toString();
                String thongtin ="Mã Bàn:"+""+maban +""+"Danh sách thức uống"+""+ danhmuc_luu;
                try {
                    //Internal Storage
                    FileOutputStream fout = openFileOutput(thongtin, Context.MODE_PRIVATE);
                    fout.write(thongtin.toString().getBytes());
                    fout.close();
                    Toast.makeText(MainActivity.this, "Save file successfully!", Toast.LENGTH_SHORT).show();
                    xoatrang();
                } catch (Exception e) {
                    Toast.makeText(MainActivity.this, "Error save file !", Toast.LENGTH_SHORT).show();
                    xoatrang();
                }
            }
        });

    }

    public void connect(){
        id=(TextView)findViewById(R.id.id);
        danhmuc=(TextView)findViewById(R.id.danhmuc);
        editText_id=(EditText)findViewById(R.id.editText_id);
        btn_luu=(Button)findViewById(R.id.btn_luu);
        btn_next=(Button)findViewById(R.id.btn_next);
    }
    public void xoatrang(){
        editText_id.setText("");
        danhmuc.setText("");
    }
}
