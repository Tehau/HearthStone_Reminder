package me.core.hearthstonereminder.events;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import me.core.hearthstonereminder.activities.MainScreen;
import me.core.hearthstonereminder.activities.MyDecksScreen;

/**
 * Created by wandy-linux on 12/10/14.
 */
public class GoToMyDecks implements View.OnClickListener {

    private Activity _mainScreen;

    public GoToMyDecks(){

    }

    public GoToMyDecks(MainScreen mainScreen){
       this._mainScreen = mainScreen;
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(_mainScreen, MyDecksScreen.class);
        _mainScreen.startActivity(intent);
    }

}
