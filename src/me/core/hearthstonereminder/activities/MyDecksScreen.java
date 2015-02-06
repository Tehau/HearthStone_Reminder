package me.core.hearthstonereminder.activities;

import android.app.Activity;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ListView;
import com.example.HearthStone_Reminder.R;
import me.core.hearthstonereminder.adapter.DeckAdapter;
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

    //events
    private GoToDeckBuilder _goToDeckBuilder;

    private DBHelper _dbHelper;
    private SQLiteDatabase _dataBase;
    private DeckDataSource _deckDataSource;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mydecks);

        _addButton = (Button) findViewById(R.id.button_add_new_deck);
        _listView = (ListView) findViewById(R.id.listView_myDecks);

        //TODO : finir la création de la data base, à faire passer le deckDataSource dans l'activité DeckBuilder
        _dbHelper = new DBHelper(this);
        _dataBase = _dbHelper.getReadableDatabase();

        _deckDataSource = new DeckDataSource(_dataBase);


        // get all decks and link to the adapters
        _decks = _deckDataSource.getAllDecks();
        _deckAdapter = new DeckAdapter(this,R.layout.deckadapter,_decks);
        // Set the adapter to display the tasks
        //lst = (ListView) fragView.findViewById(R.id.display_list);
        //adapter = new TaskAdapter(this, R.layout.item, taskDataSource.getTasksFromPage(page));
        _listView.setAdapter(_deckAdapter);
        //events
        _goToDeckBuilder = new GoToDeckBuilder(this);
        _addButton.setOnClickListener(_goToDeckBuilder);
    }

    private DeckDataSource getDeckDataSource(){
        return _deckDataSource;
    }
}
