package com.example.blindnotes20;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

public class NoteViewHolder extends RecyclerView.ViewHolder {
    private final TextView noteTextView;

    private  NoteViewHolder(View itemView) {
        super(itemView);
        noteTextView = itemView.findViewById(R.id.textView);
    }

    public void bind(String text) {
        noteTextView.setText(text);
    }

    static  NoteViewHolder create(ViewGroup parent) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recyclerview_note, parent, false);
        return new NoteViewHolder(view);
    }
}
