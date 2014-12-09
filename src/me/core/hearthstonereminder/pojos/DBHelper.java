package me.core.hearthstonereminder.pojos;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by wandy-linux on 12/9/14.
 */
public class DBHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "decklist.db";
    private static final int DATABASE_VERSION = 1;

    //Table Deck
    public static final String TABLE_DECK ="decks";
    public static final String DECK_C_ID = "id";
    public static final String DECK_C_CLASS = "class";

    public static final String DECK_C_NAME = "name";

    public static final String TABLE_DECK_CREATE = "create table" +
            TABLE_DECK + "(" +
            DECK_C_ID + " integer primary key autoincrement, " +
            DECK_C_NAME + " text"+
            DECK_C_CLASS + " text not null);";

    public DBHelper(Context context)
    {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(TABLE_DECK_CREATE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.w(DBHelper.class.getName(),
                "Upgrading database from version " + oldVersion + " to "
                        + newVersion + ", which will destroy all old data");
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_DECK);
        onCreate(db);
    }
}
