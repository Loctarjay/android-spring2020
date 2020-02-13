package com.joneikholm.gui_string;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    public static final String messageKey1 = "MESSAGE_KEY";
    private String message = "";
    private EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText = findViewById(R.id.editText);
    }

    public void savePressed(View v){
        message = editText.getText().toString();
        Log.i("all", "saved: " + message);
    }

    public void goToViewTexts(View view){
        Intent intent = new Intent(this, ViewNotes.class);
        intent.putExtra(messageKey1, message);
        startActivity(intent);
    }
}
