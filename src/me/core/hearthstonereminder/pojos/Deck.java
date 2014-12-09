package me.core.hearthstonereminder.pojos;

/**
 * Created by wandy-linux on 12/8/14.
 */
public class Deck {

    private long _id;
    private String _name;
    private String _className;

    /*
    Constructor
     */
    public Deck(){

    }

    public Deck(String name, String className){
        this._name = name;
        this._className = className;
    }

    /*
    Getter and Setter
     */
    public long getId() {
        return _id;
    }

    public void setId(long _id) {
        this._id = _id;
    }

    public String getClassName() {
        return _className;
    }

    public void setClassName(String _className) {
        this._className = _className;
    }

    public String getName() {
        return _name;
    }

    public void setName(String _name) {
        this._name = _name;
    }

}
