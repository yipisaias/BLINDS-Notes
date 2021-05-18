package com.example.blindnotes20.data;

import android.content.res.ColorStateList;
import android.graphics.Color;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "note_table")
public class Note {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "uid")
    public int uid;

    @ColumnInfo(name = "texto_nota")
    public String textoNota;

    @ColumnInfo(name = "cor_nota")
    public int corNota;

    @NonNull
    public String getTextoNota(){return this.textoNota;}

    @NonNull
    public int getId(){ return this.uid;}

    @NonNull
    public int getCorNota(){return this.corNota;}

}
