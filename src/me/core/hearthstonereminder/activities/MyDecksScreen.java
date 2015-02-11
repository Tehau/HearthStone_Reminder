package me.core.hearthstonereminder.activities;

import android.app.Activity;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;
import com.example.HearthStone_Reminder.R;
import me.core.hearthstonereminder.adapter.DeckAdapter;
import me.core.hearthstonereminder.events.DeckDeleted;
import me.core.hearthstonereminder.events.GoToDeckBuilder;
import me.core.hearthstonereminder.pojos.DBHelper;
import me.core.hearthstonereminder.pojos.Deck;
import me.core.hearthstonereminder.pojos.DeckDataSource;

import java.util.ArrayList;

/**
 * Created by wandy-linux on 12/7/14.
 */
public class MyDecksScreen extends Activity {

    private Button _addButton;

    private ListView _listView;
    private ArrayList<Deck> _decks;
    private DeckAdapter _deckAdapter;

    private Toast _toaster;

    //events
    private GoToDeckBuilder _goToDeckBuilder;

    //Data base
    private DBHelper _dbHelper;
    private SQLiteDatabase _dataBase;
    private DeckDataSource _deckDataSource;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mydecks);

        _addButton = (Button) findViewById(R.id.button_add_new_deck);
        _listView = (ListView) findViewById(R.id.listView_myDecks);

        _dbHelper = new DBHelper(this);
        _dataBase = _dbHelper.getReadableDatabase();

        _deckDataSource = new DeckDataSource(_dataBase);

        // get all decks and link to the adapters
        _decks = _deckDataSource.getAllDecks();
        _deckAdapter = new DeckAdapter(this,R.layout.deckadapter,_decks,_deckDataSource);

        // Set the adapter to display the decks
        _listView.setAdapter(_deckAdapter);
        //events
        _goToDeckBuilder = new GoToDeckBuilder(this);
        _addButton.setOnClickListener(_goToDeckBuilder);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode == 0 && resultCode == RESULT_OK){
            _deckAdapter.refreshAdapter();
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);

    }

    public DeckAdapter getDeckAdapter(){
        return _deckAdapter;
    }

    public DeckDataSource getDeckDataSource(){
        return _deckDataSource;
    }

    public void toastify(String text) {
        _toaster = Toast.makeText(this, text, Toast.LENGTH_SHORT);
        _toaster.show();
    }
}
