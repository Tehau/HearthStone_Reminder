package me.core.hearthstonereminder.pojos;

/**
 * Created by wandy-linux on 2/12/15.
 */
public class Card {

    // 20 attributes
    private String name;
    private int cost;
    private String minion;
    private String legendary;
    private String faction;
    private String race;
    private String playerClass;
    private String text;
    private String inPlayText;
    private String mechanics;
    private String flavor;
    private String artist;
    private int attack;
    private int health;
    private int durability;
    private String id;
    private boolean collectible;
    private boolean elite;
    private String howToGet;
    private String howToGetGold;

    public final String KEY_NAME = "name";
    public final String KEY_COST = "cost";
    public final String KEY_MINION = "minion";
    public final String KEY_LEGENDARY = "legendary";
    public final String KEY_FACTION = "faction";
    public final String KEY_RACE = "race";
    public final String KEY_PLAYERCLASS = "playerc=Class";
    public final String KEY_TEXT = "text";
    public final String KEY_INPLAYTEXT = "inPlayText";
    public final String KEY_MECHANICS = "mechanics";
    public final String KEY_FLAVOR = "flavor";
    public final String KEY_ARTIST = "artist";
    public final String KEY_ATTACK = "attack";
    public final String KEY_HEALTH = "health";
    public final String KEY_DURABILITY = "durability";
    public final String KEY_ID = "id";
    public final String KEY_COLLECTIBLE = "collectible";
    public final String KEY_ELITE = "elite";
    public final String KEY_HOWTOGET = "howToGet";
    public final String KEY_HOWTOGETGOLD = "howToGetGold";

     /*
    Constructor
     */

    public Card(){

    }

    public Card(String name,
                int cost,
                String minion,
                String legendary,
                String faction,
                String race,
                String playerClass,
                String text,
                String inPlayText,
                String mechanics,
                String flavor,
                String artist,
                int attack,
                int health,
                int durability,
                String id,
                boolean collectible,
                boolean elite,
                String howToGet,
                String howToGetGold) {

        this.name = name;
        this.cost = cost;
        this.minion = minion;
        this.legendary = legendary;
        this.faction = faction;
        this.race = race;
        this.playerClass = playerClass;
        this.text = text;
        this.inPlayText = inPlayText;
        this.mechanics = mechanics;
        this.flavor = flavor;
        this.artist = artist;
        this.attack = attack;
        this.health = health;
        this.durability = durability;
        this.id = id;
        this.collectible = collectible;
        this.elite = elite;
        this.howToGet = howToGet;
        this.howToGetGold = howToGetGold;
    }

    /*
    Getter and Setter
     */

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public String getMinion() {
        return minion;
    }

    public void setMinion(String minion) {
        this.minion = minion;
    }

    public String getLegendary() {
        return legendary;
    }

    public void setLegendary(String legendary) {
        this.legendary = legendary;
    }

    public String getFaction() {
        return faction;
    }

    public void setFaction(String faction) {
        this.faction = faction;
    }

    public String getRace() {
        return race;
    }

    public void setRace(String race) {
        this.race = race;
    }

    public String getPlayerClass() {
        return playerClass;
    }

    public void setPlayerClass(String playerClass) {
        this.playerClass = playerClass;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getInPlayText() {
        return inPlayText;
    }

    public void setInPlayText(String inPlayText) {
        this.inPlayText = inPlayText;
    }

    public String getMechanics() {
        return mechanics;
    }

    public void setMechanics(String mechanics) {
        this.mechanics = mechanics;
    }

    public String getFlavor() {
        return flavor;
    }

    public void setFlavor(String flavor) {
        this.flavor = flavor;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getDurability() {
        return durability;
    }

    public void setDurability(int durability) {
        this.durability = durability;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public boolean isCollectible() {
        return collectible;
    }

    public void setCollectible(boolean collectible) {
        this.collectible = collectible;
    }

    public boolean isElite() {
        return elite;
    }

    public void setElite(boolean elite) {
        this.elite = elite;
    }

    public String getHowToGet() {
        return howToGet;
    }

    public void setHowToGet(String howToGet) {
        this.howToGet = howToGet;
    }

    public String getHowToGetGold() {
        return howToGetGold;
    }

    public void setHowToGetGold(String howToGetGold) {
        this.howToGetGold = howToGetGold;
    }
}
