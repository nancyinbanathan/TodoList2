package com.example.todolist2;

import android.arch.persistence.db.SupportSQLiteDatabase;
import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;
import android.os.AsyncTask;
import android.support.annotation.NonNull;

@Database(entities = {Note.class},version = 1)
public abstract class NoteDatabase extends RoomDatabase {

    private static NoteDatabase instance;

    public abstract NoteDao noteDao();

    public static synchronized NoteDatabase getInstance(Context context){
        if (instance ==null) {
            instance = Room.databaseBuilder(context.getApplicationContext(),
                    NoteDatabase.class, "note_database")
                    .fallbackToDestructiveMigration()
                 //   .addCallback(roomCallback)
                    .build();
            }
        return instance;
        }

        /*private static RoomDatabase.Callback roomCallback = new RoomDatabase.Callback(){
            @Override
            public void onCreate(@NonNull SupportSQLiteDatabase db) {
                super.onCreate(db);
                new PopulateAsyncTask(instance).execute();
            }
        };

        private static class PopulateAsyncTask extends AsyncTask<Void,Void,Void>{

            private NoteDao noteDao;
            private PopulateAsyncTask(NoteDatabase db){
                noteDao = db.noteDao();
            }

            @Override
            protected Void doInBackground(Void... voids) {
                noteDao.insert(new Note("Title1","Desciption1",1));
                noteDao.insert(new Note("Title2","Desciption2",2));
                noteDao.insert(new Note("Title3","Desciption3",3));
                return null;
            }
        }*/
    }



