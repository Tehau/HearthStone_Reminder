package me.core.hearthstonereminder.activities;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import com.example.HearthStone_Reminder.R;
import me.core.hearthstonereminder.events.GoToMyDecks;

/**
 * Created by wandy-linux on 12/8/14.
 */
public class MainScreen extends Activity {

    // objects
    private Button _button_MyDecks;
    // TODO : after the builder do the reminder
    private Button _button_Start;

    // events
    private GoToMyDecks _goToMyDecks;

    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        _button_MyDecks = (Button) findViewById(R.id.button_myDecks);
        _button_Start = (Button) findViewById(R.id.button_start);

        _goToMyDecks = new GoToMyDecks(this);
        _button_MyDecks.setOnClickListener(_goToMyDecks);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

}
