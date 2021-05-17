package com.example.blindnotes20.data;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface NoteDao {
    @Query("SELECT * FROM note_table")
    public LiveData<List<Note>> getAll();

    @Query("SELECT * FROM note_table WHERE uid IN (:userIds)")
    public LiveData<List<Note>> loadAllByIds(int[] userIds);

    @Query("SELECT * FROM note_table WHERE texto_nota LIKE :texto ")
    public Note findByText(String texto);

    @Query("SELECT * FROM note_table WHERE cor_nota LIKE :cor ")
    public Note findByColor(String cor);

    @Insert
    public void insertAll(Note... users);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public void insert(Note note);

    @Delete
    public void delete(Note user);

    @Query("DELETE FROM note_table")
    public void deleteAll();

    @Update
    public void update(Note note);


}
