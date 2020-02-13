package com.joneikholm.stringfile;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.joneikholm.stringfile.storage.FileStorage;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class MainActivity extends AppCompatActivity {

    private TextView textView;
    private final String file = "text.dat";
    private FileStorage fileStorage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        fileStorage = new FileStorage(this);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.textView);
        fileStorage.saveToFile("hello there", file);
        Object object = fileStorage.readObject(file);
        String text = (String)object;
        textView.setText(text);
    }


}
