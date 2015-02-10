package me.core.hearthstonereminder.events;

import android.view.View;
import me.core.hearthstonereminder.adapter.DeckAdapter;
import me.core.hearthstonereminder.pojos.Deck;
import me.core.hearthstonereminder.pojos.DeckDataSource;

/**
 * Created by wandy-linux on 2/6/15.
 */
public class DeckDeleted implements View.OnClickListener {

    private static String DECK_DELETE = "Deck delete";

    private Deck deck;
    private DeckDataSource deckDataSource;
    private DeckAdapter deckAdapter;

    public DeckDeleted() {
    }

    public DeckDeleted(DeckDataSource deckDataSource, DeckAdapter deckAdapter) {
        this.deckDataSource = deckDataSource;
        this.deck = deckAdapter.getDeck();
        this.deckAdapter = deckAdapter;
    }

    @Override
    public void onClick(View v) {
        deckDataSource.delete(deck);
        deckAdapter.refreshAdapter();
    }
}
