package me.core.hearthstonereminder.events;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import me.core.hearthstonereminder.activities.DeckBuilderScreen;
import me.core.hearthstonereminder.activities.MyDecksScreen;

/**
 * Created by wandy-linux on 12/10/14.
 */
public class GoToDeckBuilder implements View.OnClickListener  {

    private MyDecksScreen _activity;

    public GoToDeckBuilder(){

    }

    public GoToDeckBuilder(MyDecksScreen activity){
        this._activity = activity;
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(_activity, DeckBuilderScreen.class);
        _activity.startActivityForResult(intent, 0);
        //_activity.startActivity(intent);
    }
}
