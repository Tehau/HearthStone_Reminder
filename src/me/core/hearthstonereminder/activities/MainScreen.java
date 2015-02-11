package me.core.hearthstonereminder.activities;

import android.app.Activity;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.Button;
import com.example.HearthStone_Reminder.R;
import me.core.hearthstonereminder.events.GoToMyDecks;
import me.core.hearthstonereminder.pojos.DBHelper;
import me.core.hearthstonereminder.pojos.DeckDataSource;

/**
 * Created by wandy-linux on 12/8/14.
 */
public class MainScreen extends Activity {

    // objects
    private Button myDecksButton;
    // TODO : after the builder do the reminder
    private Button startButton;

    // events
    private GoToMyDecks _goToMyDecks;

    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        myDecksButton = (Button) findViewById(R.id.button_myDecks);
        startButton = (Button) findViewById(R.id.button_start);

        _goToMyDecks = new GoToMyDecks(this);
        myDecksButton.setOnClickListener(_goToMyDecks);

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

}
