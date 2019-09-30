package com.example.onthigk;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.util.SparseBooleanArray;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import java.util.ArrayList;


public class Main2Activity extends AppCompatActivity {

    Button btn_thoat;
    private static final String TAG = "ListViewMultiple";
    ListView list;
   // TextView select;
   String arr[];



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        btn_thoat=(Button)findViewById(R.id.btn_thoat);
        eventexit();
        list();

    }

    private void list() {

        //1. Khởi tạo dữ liệu cho mảng arr (còn gọi là data source)
         arr=getResources().getStringArray(R.array.myarray);
        //2. Lấy đối tượng Listview dựa vào id
        ListView lv=(ListView) findViewById(R.id.list);

        final ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_multiple_choice,arr);
        lv.setAdapter(adapter);
        lv.setChoiceMode(AbsListView.CHOICE_MODE_MULTIPLE);

        /*3. Gán Data source vào ArrayAdapter
        ArrayAdapter<String> adapter=new ArrayAdapter<String>
               (this, android.R.layout.simple_list_item_1, arr);
        4. Đưa Data source vào ListView
        lv.setAdapter(adapter);*/

    }

    private void eventexit() {
        btn_thoat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Main2Activity.this,MainActivity.class);
               // ListView list = getlistview
                ListView lv=(ListView) findViewById(R.id.list);
                String itemSelected = "";
                for (int i = 0; i < lv.getCount(); i++){
                    if(lv.isItemChecked(i)){
                        itemSelected += "\n" + arr[i];
                        intent.putExtra("arr",itemSelected);
                        startActivity(intent);
                    }
                }
              /*  SparseBooleanArray sparseBooleanArray = list.getCheckedItemPositions();

                String itemsSelected = "";
                Log.e(TAG, "Total Number Selected: " + list.getCheckedItemCount());
                for (int i = 0; i < sparseBooleanArray.size(); i++) {
                    int position = sparseBooleanArray.keyAt(i);
                    itemsSelected += "item " + position + ",";
                }
                Toast.makeText(Main2Activity.this, itemsSelected, Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(Main2Activity.this,MainActivity.class);
              startActivity(intent);*/
            }
        });
    }
}
