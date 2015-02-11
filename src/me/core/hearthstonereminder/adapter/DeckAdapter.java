package me.core.hearthstonereminder.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.HearthStone_Reminder.R;
import me.core.hearthstonereminder.events.DeckDeleted;
import me.core.hearthstonereminder.pojos.Deck;
import me.core.hearthstonereminder.pojos.DeckDataSource;

import java.util.ArrayList;

/**
 * Created by wandy-linux on 12/8/14.
 */
public class DeckAdapter extends ArrayAdapter<Deck> {

    private ArrayList<Deck> _listDeck;
    private LayoutInflater _layoutInflater;
    private Context _context;

    private ImageView imageView;
    private TextView deckName;
    private Button buttonDelete;

    private Deck deck;
    private DeckDataSource deckDataSource;

    public DeckAdapter(Context context, int resource, ArrayList<Deck> listDeck, DeckDataSource deckDataSource) {
        super(context, resource, listDeck);
        this._listDeck = listDeck;
        this._context = context;
        this.deckDataSource = deckDataSource;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        deck = _listDeck.get(position);

        if (convertView == null){
            _layoutInflater = LayoutInflater.from(_context);
            convertView = _layoutInflater.inflate(R.layout.deckadapter, null);
        }

        //initialization all objects of the adapter
        imageView = (ImageView) convertView.findViewById(R.id.imageClass);
        deckName = (TextView) convertView.findViewById(R.id.deckName);
        buttonDelete = (Button) convertView.findViewById(R.id.button_delete_deck);

        //variable assignment
        switch (deck.getClassName()){
            case "Druid": imageView.setImageResource(R.drawable.icon_druid_64);
                break;
            case "Hunter": imageView.setImageResource(R.drawable.icon_hunter_64);
                break;
            case "Mage": imageView.setImageResource(R.drawable.icon_mage_64);
                break;
            case "Paladin": imageView.setImageResource(R.drawable.icon_paladin_64);
                break;
            case "Priest": imageView.setImageResource(R.drawable.icon_priest_64);
                break;
            case "Rogue": imageView.setImageResource(R.drawable.icon_rogue_64);
                break;
            case "Shaman": imageView.setImageResource(R.drawable.icon_shaman_64);
                break;
            case "Warlock": imageView.setImageResource(R.drawable.icon_warlock_64);
                break;
            case "Warrior": imageView.setImageResource(R.drawable.icon_warrior_64);
                break;
        }

        deckName.setText(deck.getName());

        //events
        buttonDelete.setOnClickListener(new DeckDeleted(deckDataSource,this));

        return convertView;
    }

    // Refresh the adapter.
    // This has to be called every time the database is altered.
    // Otherwise, the modifications will be effective, but not visible
    // on screen.
    public void refreshAdapter() {
        ArrayList<Deck> updatedList = deckDataSource.getAllDecks();

        // This may look dumb, but notifyDataSetChanged() only works
        // after a CRUD operation on the list, and clear() isn't one of them
        this._listDeck.clear();
        this._listDeck.addAll(updatedList);
        notifyDataSetChanged();
    }

    public Button getButtonDelete() {
        return buttonDelete;
    }

    public Deck getDeck(){
        return deck;
    }
}
