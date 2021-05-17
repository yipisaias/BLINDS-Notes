package com.example.blindnotes20;

import android.content.Intent;
import android.os.Bundle;

import com.example.blindnotes20.data.Note;
import com.example.blindnotes20.data.NoteViewModel;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.util.Log;
import android.view.View;

import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.blindnotes20.databinding.ActivityMainBinding;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private AppBarConfiguration appBarConfiguration;
    private ActivityMainBinding binding;
    private NoteViewModel mNoteViewModel;
    public static final int NEW_WORD_ACTIVITY_REQUEST_CODE = 1;
    public static final int EDIT_WORD_ACTIVITY_REQUEST_CODE = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        RecyclerView recyclerView = findViewById(R.id.recyclerview);
        final NoteListAdapter adapter = new NoteListAdapter(new NoteListAdapter.NoteDiff());
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        mNoteViewModel = new ViewModelProvider(this).get(NoteViewModel.class);
        mNoteViewModel.getAllNotes().observe(this, notes -> {
            // Update the cached copy of the words in the adapter.
            adapter.submitList(notes);
        });

        ItemTouchHelper helper = new ItemTouchHelper(
                new ItemTouchHelper.SimpleCallback(0,
                        ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT) {
                    @Override
                    public boolean onMove(RecyclerView recyclerView,
                                          RecyclerView.ViewHolder viewHolder,
                                          RecyclerView.ViewHolder target) {
                        return false;
                    }

                    @Override
                    public void onSwiped(RecyclerView.ViewHolder viewHolder,
                                         int direction) {
                        int position = viewHolder.getAdapterPosition();
                        Note myNote = adapter.getCurrentList().get(position);
                        Toast.makeText(MainActivity.this, "Deleting " +
                                myNote.getTextoNota(), Toast.LENGTH_LONG).show();

                        // Delete the word
                       mNoteViewModel.delete(myNote);
                    }

                });

        helper.attachToRecyclerView(recyclerView);


    }

    public void irParaEditarNota(View view){
       // TextView textoAntigo = view.findViewById(R.id.preview_nota1);

        Intent intent1 = new Intent(this, EditarNota.class);
        //intent1.putExtra("TEXTO_ANTIGO", textoAntigo.getText());
        startActivity(intent1);
       // startActivityForResult(intent1, EDIT_WORD_ACTIVITY_REQUEST_CODE);
    }

    public void irParaCriarNota(View view){

        Intent intent = new Intent(MainActivity.this,  CriarNota.class);
        startActivityForResult(intent, NEW_WORD_ACTIVITY_REQUEST_CODE);
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == NEW_WORD_ACTIVITY_REQUEST_CODE && resultCode == RESULT_OK) {
            Note note = new Note();
            note.textoNota = data.getStringExtra(CriarNota.EXTRA_REPLY);
            note.corNota = "@android:color/white";
            mNoteViewModel.insert(note);
        } else
        if (requestCode == EDIT_WORD_ACTIVITY_REQUEST_CODE && resultCode == RESULT_OK) {
            //String textoAntigo =  data.getStringExtra(EditarNota.TEXTO_ANTIGO);
            //Note myNote = mNoteViewModel.

            //note.textoNota = data.getStringExtra(CriarNota.EXTRA_REPLY);
            //note.corNota = "@android:color/white";
           // mNoteViewModel.update(note);
        }
            else {
            Toast.makeText(
                    getApplicationContext(),
                    R.string.empty_not_saved,
                    Toast.LENGTH_LONG).show();
        }
    }

}