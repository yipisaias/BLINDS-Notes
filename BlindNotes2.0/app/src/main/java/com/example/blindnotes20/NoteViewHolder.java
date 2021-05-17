package com.example.blindnotes20;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.blindnotes20.data.Note;

public class NoteViewHolder extends RecyclerView.ViewHolder {
    private final TextView noteTextView;


    private  NoteViewHolder(View itemView) {
        super(itemView);
        noteTextView = itemView.findViewById(R.id.preview_nota1);


    }

    public void bind(Note note) {
        noteTextView.setText(note.getTextoNota());
    }

    static  NoteViewHolder create(ViewGroup parent) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recyclerview_note, parent, false);
        return new NoteViewHolder(view);
    }
}
