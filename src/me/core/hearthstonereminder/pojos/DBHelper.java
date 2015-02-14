package me.core.hearthstonereminder.pojos;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import me.core.hearthstonereminder.parser.ParserJSON;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * Created by wandy-linux on 12/9/14.
 */
public class DBHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "decklist.db";
    private static final int DATABASE_VERSION = 1;

    //Table Deck
    public static final String TABLE_DECKS ="decks";
    public static final String DECK_C_ID = "_id";
    public static final String DECK_C_CLASS = "class";
    public static final String DECK_C_NAME = "name";

    public static final String TABLE_DECK_CREATE = "create table if not exists " +
            TABLE_DECKS + "(" +
            DECK_C_ID + " integer primary key autoincrement, " +
            DECK_C_NAME + " text not null, "+
            DECK_C_CLASS + " text not null);";

    //Table Cards
    public static final String TABLE_CARDS = "cards";
    public static final String CARD_C_ID = "_id";
    public static final String CARD_C_NAME = "name";
    public static final String CARD_C_COST = "cost";

    public static final String TABLE_CARD_CREATE = "create table if not exists " +
            TABLE_CARDS + "(" +
            CARD_C_ID + " integer primary key, " +
            CARD_C_NAME + " text not null, " +
            CARD_C_COST + " text not null);";

    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(TABLE_DECK_CREATE);
        db.execSQL(TABLE_CARD_CREATE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.w(DBHelper.class.getName(),
                "Upgrading database from version " + oldVersion + " to "
                        + newVersion + ", which will destroy all old data");
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_DECKS);
        db.execSQL("DROP TABLE IF ExISTS " + TABLE_CARDS);
        onCreate(db);
    }
}
