package com.example.blindnotes20.data;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "note_table")
public class Note {
    @PrimaryKey
    @ColumnInfo(name = "uid")
    public int uid;

    @ColumnInfo(name = "texto_nota")
    public String textoNota;

    @ColumnInfo(name = "cor_nota")
    public String corNota;

    public Note(@NonNull int uid, @NonNull String textoNota, @NonNull String corNota) {
        this.uid = uid;
        this.corNota = corNota;
        this.textoNota = textoNota;
    }

    @NonNull
    public String getTextoNota(){return this.textoNota;}

}
