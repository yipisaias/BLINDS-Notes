package com.example.blindnotes20.data;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

@Dao
public interface NoteDao {
    @Query("SELECT * FROM note_table")
    LiveData<List<Note>> getAll();

    @Query("SELECT * FROM note_table WHERE uid IN (:userIds)")
    LiveData<List<Note>> loadAllByIds(int[] userIds);

    @Query("SELECT * FROM note_table WHERE texto_nota LIKE :texto ")
    Note findByText(String texto);

    @Query("SELECT * FROM note_table WHERE cor_nota LIKE :cor ")
    Note findByColor(String cor);

    @Insert
    void insertAll(Note... users);

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(Note note);

    @Delete
    void delete(Note user);

    @Query("DELETE FROM note_table")
    void deleteAll();

}
