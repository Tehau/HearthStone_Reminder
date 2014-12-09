package me.core.hearthstonereminder.pojos;

/**
 * Created by wandy-linux on 12/8/14.
 */
public class Deck {

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
    public String get_className() {
        return _className;
    }

    public void set_className(String _className) {
        this._className = _className;
    }

    public String get_name() {
        return _name;
    }

    public void set_name(String _name) {
        this._name = _name;
    }

}
