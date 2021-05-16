package com.example.blindnotes20.data;

import android.app.Application;

import androidx.lifecycle.LiveData;

import java.util.List;

public class NoteRepository {
    private NoteDao mNoteDao;
    private LiveData<List<Note>> mAllNotes;

    NoteRepository(Application application) {
        AppDatabase db =  AppDatabase.getDatabase(application);
        mNoteDao = db.noteDao();
        mAllNotes = mNoteDao.getAll();
    }

    LiveData<List<Note>> getAllNotes() {
        return mAllNotes;
    }

    void insert(Note note) {
        AppDatabase.databaseWriteExecutor.execute(() -> {
            mNoteDao.insert(note);
        });
    }
}
