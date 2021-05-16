package com.example.blindnotes20;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class CriarNota extends AppCompatActivity {
    public static final String EXTRA_REPLY = "com.example.android.notelistsql.REPLY";
    private EditText mEditNoteView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_criar_nota);
        mEditNoteView = findViewById(R.id.edit_note);
        final Button button = findViewById(R.id.button_save);
        button.setOnClickListener(view -> {
            Intent replyIntent = new Intent();
            if (TextUtils.isEmpty(mEditNoteView.getText())) {
                setResult(RESULT_CANCELED, replyIntent);
            } else {
                String word = mEditNoteView.getText().toString();
                replyIntent.putExtra(EXTRA_REPLY, word);
                setResult(RESULT_OK, replyIntent);
            }
            finish();
        });
    }

}