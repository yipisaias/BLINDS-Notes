package com.example.blindnotes20;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class CriarNota extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_criar_nota);
    }
    public void irParaMain(View view){
        Intent intent1 = new Intent(this, MainActivity.class);
        startActivity(intent1);
    }
}