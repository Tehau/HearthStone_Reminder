package me.core.hearthstonereminder.pojos;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Locale;

/**
 * Created by wandy-linux on 12/9/14.
 */
public class DeckDataSource {

    private SQLiteDatabase database;

    private String[] allColumns = {
            DBHelper.DECK_C_ID,
            DBHelper.DECK_C_NAME,
            DBHelper.DECK_C_CLASS
    };

    public DeckDataSource(){

    }

    public DeckDataSource(SQLiteDatabase database)
    {
        this.database = database;
    }

    public void store (Deck deck){
        ContentValues values = new ContentValues();
        DateFormat df = new SimpleDateFormat("EEEE, MMMM d, HH:mm:ss", Locale.FRENCH);

        // add values
        values.put(DBHelper.DECK_C_CLASS, deck.getClassName());
        values.put(DBHelper.DECK_C_NAME,deck.getName());

        // insert and generate ID
        database.insert(DBHelper.TABLE_DECK,null,values);
    }

    public void delete(Deck deck){
        long id = deck.getId();
        database.delete(DBHelper.TABLE_DECK, DBHelper.DECK_C_ID + "=" + id, null);
    }

    public ArrayList<Deck> getAllDecks(){
        ArrayList<Deck> decks = new ArrayList<Deck>();

        Cursor cursor = database.query(DBHelper.TABLE_DECK,
                allColumns, null, null, null, null, null);

        cursor.moveToFirst();
        while (!cursor.isAfterLast()){
            Deck currentDeck = deckAt(cursor);
            decks.add(currentDeck);
            cursor.moveToNext();
        }
        cursor.close();

        return decks;
    }

    private Deck deckAt(Cursor cursor) {
        Deck deck = new Deck();

        deck.setId(cursor.getLong(0)); // Id
        deck.setClassName(cursor.getString(1)); // Class name
        deck.setName(cursor.getString(2)); // Name

        return deck;
    }
}
