package com.example.blindnotes20.data;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class NoteViewModel extends AndroidViewModel {

    private NoteRepository mRepository;

    private final LiveData<List<Note>> mAllNotes;

    public NoteViewModel (Application application) {
        super(application);
        mRepository = new NoteRepository(application);
        mAllNotes = mRepository.getAllNotes();
    }

    public LiveData<List<Note>> getAllNotes() { return mAllNotes; }

    //public Note getNoteByText(String texto) {  return mRepository.getNoteByText(texto); }

     public void insert(Note note) { mRepository.insert(note); }

    public void delete(Note note) { mRepository.delete(note); }

    public void update(Note note) { mRepository.update(note); }
}