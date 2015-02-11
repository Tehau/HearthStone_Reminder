package me.core.hearthstonereminder.events;

import android.content.Intent;
import android.view.View;
import android.widget.EditText;
import me.core.hearthstonereminder.activities.DeckBuilderScreen;
import me.core.hearthstonereminder.pojos.Deck;

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

    @Override
    public void onClick(View v) {
        if(v.equals(this._activity.getSaveButton())){

            // Get Deck Name
            EditText input = this._activity.getTextDeckName();
            String deckName = input.getText().toString();
            if(deckName.isEmpty())
                deckName = NEW_DECK_NAME;

            // Get Selected Class
            String className = (String) this._activity.getSpinnerClassName().getSelectedItem();

            // Store deck
            Deck deck = new Deck(className,deckName);
            _activity.getDeckDataSource().store(deck);

            // return result for previous activity (MyDecksScreen)
            Intent result = new Intent();
            _activity.setResult(_activity.RESULT_OK,result);
            _activity.finish();

            this._activity.toastify(DECK_SAVE);
        }
    }
}
