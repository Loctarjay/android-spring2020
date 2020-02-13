package com.joneikholm.gui_list;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private EditText editText;
    private ListView listView;
    private ArrayAdapter<String> adapter;
    private ArrayList<String> list = new ArrayList<>();
    private boolean isEditing = false;
    private int currentRow = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText = findViewById(R.id.editText);
        listView = findViewById(R.id.listView);
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, list);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                isEditing = true;
                editText.setText(list.get(i));
                currentRow = i;
            }
        });

        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                Log.i("all", "long pressed at " + i);
                return false;
            }
        });

    }

    public void save(View view){
        String s = editText.getText().toString();
        if(s.length() > 0){
            if(isEditing){
                   list.set(currentRow, s);
                   isEditing = false;
            }else {
                list.add(s);
            }
            adapter.notifyDataSetChanged();
            editText.getText().clear();
        }
    }
}
