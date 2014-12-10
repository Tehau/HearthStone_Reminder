package me.core.hearthstonereminder.activities;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ListView;
import com.example.HearthStone_Reminder.R;
import me.core.hearthstonereminder.adapter.DeckAdapter;
import me.core.hearthstonereminder.events.GoToDeckBuilder;
import me.core.hearthstonereminder.pojos.Deck;
import me.core.hearthstonereminder.pojos.DeckDataSource;

import java.util.ArrayList;

/**
 * Created by wandy-linux on 12/7/14.
 */
public class MyDecksScreen extends Activity {

    private Button _but_add;

    private ListView _listView;
    private ArrayList<Deck> _decks;
    private DeckDataSource _deckDataSource;
    private DeckAdapter _deckAdapter;

    //events
    private GoToDeckBuilder _goToDeckBuilder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mydecks);

        _but_add = (Button) findViewById(R.id.button_add_new_deck);
        _listView = (ListView) findViewById(R.id.listView_myDecks);



        // get all decks and link to the adapter
        //TODO :
        //decks = deckDataSource.getAllDecks();
        _deckAdapter = new DeckAdapter(this,R.layout.deck_adapter,_decks);

        //events
        _goToDeckBuilder = new GoToDeckBuilder(this);
        _but_add.setOnClickListener(_goToDeckBuilder);
    }
}
