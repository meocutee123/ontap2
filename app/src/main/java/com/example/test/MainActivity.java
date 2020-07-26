package com.example.test;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.test.controller.Icontroller;
import com.example.test.controller.controller;

public class MainActivity extends AppCompatActivity {

    Icontroller controller;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        controller = new controller();
        controller = (Icontroller) getApplication();
    }
}