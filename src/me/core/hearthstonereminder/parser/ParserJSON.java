package me.core.hearthstonereminder.parser;

import android.util.JsonReader;
import me.core.hearthstonereminder.pojos.Card;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by wandy-linux on 2/12/15.
 */
public class ParserJSON {

    public ParserJSON(){

    }

    public List readJsonStream(InputStream in) throws IOException {
        JsonReader reader = new JsonReader(new InputStreamReader(in, "UTF-8"));
        try {
            return readMessagesArray(reader);
        }
        finally{
            reader.close();
        }
    }

    public List readMessagesArray(JsonReader reader) throws IOException {
        List cards = new ArrayList();

        reader.beginArray();
        while (reader.hasNext()) {
            cards.add(readMessage(reader));
        }
        reader.endArray();
        return cards;
    }

    public Card readMessage(JsonReader reader) throws IOException {

        Card card = new Card();

        reader.beginObject();
        while (reader.hasNext()) {
            String nameKey = reader.nextName();
            if(nameKey.equals(card.KEY_NAME)){
                card.setName(reader.nextString());
            }
            else if(nameKey.equals(card.KEY_COST)){
                card.setCost(reader.nextInt());
            }
            else if(nameKey.equals(card.KEY_MINION)){
                card.setMinion(reader.nextString());
            }
            else if(nameKey.equals(card.KEY_LEGENDARY)){
                card.setLegendary(reader.nextString());
            }
            else if(nameKey.equals(card.KEY_FACTION)){
                card.setFaction(reader.nextString());
            }
            else if(nameKey.equals(card.KEY_RACE)){
                card.setRace(reader.nextString());
            }
            else if(nameKey.equals(card.KEY_PLAYERCLASS)){
                card.setPlayerClass(reader.nextString());
            }
            else if(nameKey.equals(card.KEY_TEXT)){
                card.setText(reader.nextString());
            }
            else if(nameKey.equals(card.KEY_INPLAYTEXT)){
                card.setInPlayText(reader.nextString());
            }
            else if(nameKey.equals(card.KEY_MECHANICS)){
                card.setMechanics(reader.nextString());
            }
            else if(nameKey.equals(card.KEY_FLAVOR)){
                card.setFlavor(reader.nextString());
            }
            else if(nameKey.equals(card.KEY_ARTIST)){
                card.setArtist(reader.nextString());
            }
            else if(nameKey.equals(card.KEY_ATTACK)){
                card.setAttack(reader.nextInt());
            }
            else if(nameKey.equals(card.KEY_HEALTH)){
                card.setHealth(reader.nextInt());
            }
            else if(nameKey.equals(card.KEY_DURABILITY)){
                card.setDurability(reader.nextInt());
            }
            else if(nameKey.equals(card.KEY_ID)){
                card.setId(reader.nextString());
            }
            else if(nameKey.equals(card.KEY_COLLECTIBLE)){
                card.setCollectible(reader.nextBoolean());
            }
            else if(nameKey.equals(card.KEY_ELITE)){
                card.setElite(reader.nextBoolean());
            }
            else if(nameKey.equals(card.KEY_HOWTOGET)){
                card.setHowToGet(reader.nextString());
            }
            else if(nameKey.equals(card.KEY_HOWTOGETGOLD)){
                card.setHowToGetGold(reader.nextString());
            }
            else {
                reader.skipValue();
            }
        }

        reader.endObject();

        return card;
    }
}
