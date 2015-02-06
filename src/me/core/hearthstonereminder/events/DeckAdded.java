package me.core.hearthstonereminder.events;

import android.app.Activity;
import android.view.View;
import android.widget.EditText;
import me.core.hearthstonereminder.activities.DeckBuilderScreen;
import me.core.hearthstonereminder.activities.MainScreen;
import me.core.hearthstonereminder.pojos.Deck;
import me.core.hearthstonereminder.pojos.DeckDataSource;

/**
 * Created by wandy-linux on 12/12/14.
 */
public class DeckAdded implements View.OnClickListener {

    /**
     * NOTE : Test with the other package of OnClickListener
     */
    private static String NEW_DECK_NAME = "New deck";
    private static String DECK_SAVE = "Deck save";
    private static String DECK_UPDATE = "Deck updated";

    private DeckBuilderScreen _activity;

    public DeckAdded(){

    }

    public DeckAdded(DeckBuilderScreen activity){
        this._activity = activity;
    }

    /*
    @Override
    public void onClick(DialogInterface dialog, int which) {

    }
    */

    @Override
    public void onClick(View v) {
        //TODO : faire la persistence
        if(v.equals(this._activity.getSaveButton())){

            //Get Deck Name
            EditText input = this._activity.getTextDeckName();
            String deckName = input.getText().toString();
            if(deckName.isEmpty())
                deckName = NEW_DECK_NAME;

            //Get Selected Class
            String className = (String) this._activity.getSpinnerClassName().getSelectedItem();

            Deck deck = new Deck(deckName,className);
            _activity.getDeckDataSource().store(deck);

            this._activity.toastify(DECK_SAVE);
        }
    }
}
