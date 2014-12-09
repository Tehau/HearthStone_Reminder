package me.core.hearthstonereminder.activities;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;
import com.example.HearthStone_Reminder.R;
import me.core.hearthstonereminder.pojos.Deck;

import java.util.ArrayList;

/**
 * Created by wandy-linux on 12/7/14.
 */
public class MyDecksScreen extends Activity {

    private ListView listView;
    private ArrayList<Deck> Decks;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mydecks);

        //TODO : finir avec les adapters
        listView = (ListView) findViewById(R.id.listView_myDecks);
    }
}
