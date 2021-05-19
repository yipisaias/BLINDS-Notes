package com.example.blindnotes20;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import static android.graphics.Color.BLUE;

public class CriarNota extends AppCompatActivity {
    public static final String TEXTO = "com.example.android.notelistsql.TEXTO";
    private EditText mEditNoteView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_criar_nota);
        mEditNoteView = findViewById(R.id.edit_note);
        ////Spinner spinner = (Spinner) findViewById(R.id.colors_spinner);
        //ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
        ////        R.array.colors_array, android.R.layout.simple_spinner_item);

        //  adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        //// spinner.setAdapter(adapter);
        final Button button = findViewById(R.id.button_save);
        button.setOnClickListener(view -> {
            Intent replyIntent = new Intent();
            if (TextUtils.isEmpty(mEditNoteView.getText())) {
                setResult(RESULT_CANCELED, replyIntent);
            } else {
                String word = mEditNoteView.getText().toString();

                    replyIntent.putExtra(TEXTO, word);



                setResult(RESULT_OK, replyIntent);
            }
            finish();
        });
    }

}