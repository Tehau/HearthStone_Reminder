package me.core.hearthstonereminder.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import com.example.HearthStone_Reminder.R;

/**
 * Created by wandy-linux on 12/8/14.
 */
public class MainScreen extends Activity {

    private Button _button_MyDecks;
    // TODO : after the builder do the reminder
    private Button _button_Start;

    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        _button_MyDecks = (Button) findViewById(R.id.button_myDecks);
        _button_Start = (Button) findViewById(R.id.button_start);

        _button_MyDecks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainScreen.this, MyDecksScreen.class);
                startActivity(intent);
            }
        });

    }
}
