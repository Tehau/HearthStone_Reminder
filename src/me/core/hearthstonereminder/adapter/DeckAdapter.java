package me.core.hearthstonereminder.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.HearthStone_Reminder.R;
import me.core.hearthstonereminder.pojos.Deck;

import java.util.ArrayList;

/**
 * Created by wandy-linux on 12/8/14.
 */
public class DeckAdapter extends ArrayAdapter<Deck> {

    private ArrayList<Deck> listDeck;
    private LayoutInflater layoutInflater;
    private Context context;

    public DeckAdapter(Context context, int resource, ArrayList<Deck> listDeck) {
        super(context, resource, listDeck);
        this.listDeck = listDeck;
        this.context = context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //return super.getView(position, convertView, parent);
        Deck deck = listDeck.get(position);

        if (convertView == null){
            layoutInflater = LayoutInflater.from(context);
            convertView = layoutInflater.inflate(R.layout.deck_adapter, null);
        }

        //initialization all objects of the adapter
        ImageView imageView = (ImageView) convertView.findViewById(R.id.imageClass);
        TextView className = (TextView) convertView.findViewById(R.id.deckName);

        //variable assignment
        // TODO : faire une switch pour chaque nom de class
        imageView.setImageResource(R.drawable.ic_launcher);
        className.setText(deck.get_name());

        return convertView;
    }
}