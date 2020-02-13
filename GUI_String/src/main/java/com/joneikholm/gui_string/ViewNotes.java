package com.joneikholm.gui_string;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class ViewNotes extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_notes);
        TextView textView = findViewById(R.id.textView2);
        Intent intent = getIntent();
        textView.setText(intent.getStringExtra(MainActivity.messageKey1));
        
    }
}
