package com.example.mrenaud.mesrecettesdecrepes;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.SyncStateContract;
import android.provider.SyncStateContract.Constants;
import android.util.Log;

public class DBOpenHelper  {
//

    // METHODE COMPLEXE  a remplacer par singleton
//    // db name
//    public static final String DATABASE_NAME =" myData.db";
//    //db version
//    public static final int DATABASE_VERSION = 1;
//    // table name
//    public static final String MY_TABLE = "Recipe";
//
//    // columns name
//
//    public static final String KEY_COL_ID ="_id";
//
//    public static final String KEY_COL_NAME ="name";
//
//    public static final String KEY_COL_IMAGE_URL ="imageURL";
//
//    // columns id
//
//    public static final int ID_COLUMN = 1;
//
//    public static final int ID_NAME = 2;
//
//    public static final int ID_IMAGE_URL =3 ;
//
//    private static final String DATABASE_CREATE = "CREATE TABLE "
//            + MY_TABLE + "(" + KEY_COL_ID
//            + " INTEGER PRIMARY KEY AUTOINCREMENT, " + KEY_COL_IMAGE_URL
//            + " TEXT, " + KEY_COL_NAME + " TEXT)";
//
//
//    public DBOpenHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version ){
//        super(context,name,factory,version);
//    }
//
//
//
//    @Override
//    public void onCreate(SQLiteDatabase db) {
//        db.execSQL(DATABASE_CREATE);
//    }
//
//    @Override
//    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
//        Log.w("dbOpenHelper", " Mise a jour de la version " + oldVersion + "vers la verison " + newVersion + ", les anciennes données seront détruites");
//        db.execSQL(MY_TABLE);
//        onCreate(db);
//
//    }
}
