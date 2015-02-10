package me.core.hearthstonereminder.activities;

import android.app.Activity;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;
import com.example.HearthStone_Reminder.R;
import me.core.hearthstonereminder.events.DeckAdded;
import me.core.hearthstonereminder.pojos.DBHelper;
import me.core.hearthstonereminder.pojos.DeckDataSource;

/**
 * Created by wandy-linux on 12/10/14.
 */
public class DeckBuilderScreen extends Activity {

    //screen objects
    private Spinner _spinnerClassName;
    private EditText _textDeckName;

    private Button _saveButton;

    private Toast _toaster;

    //events
    private DeckAdded _deckAdded;

    //Data base
    private DBHelper _dbHelper;
    private SQLiteDatabase _dataBase;
    private DeckDataSource _deckDataSource;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.deckbuilder);

        _spinnerClassName = (Spinner) findViewById(R.id.spinnerClassName);
        _textDeckName = (EditText) findViewById(R.id.editTextDeckName);
        _saveButton = (Button) findViewById(R.id.savebutton);

        //Data base
        _dbHelper = new DBHelper(this);
        _dataBase = _dbHelper.getReadableDatabase();
        _deckDataSource = new DeckDataSource(_dataBase);

        //events
        _deckAdded = new DeckAdded(this);
        _saveButton.setOnClickListener(_deckAdded);

    }

    /*
    Getters and Setters
     */

    public Spinner getSpinnerClassName() {
        return _spinnerClassName;
    }

    public void setSpinnerClassName(Spinner spinnerClassName) {
        this._spinnerClassName = spinnerClassName;
    }

    public EditText getTextDeckName() {
        return _textDeckName;
    }

    public void setTextDeckName(EditText textDeckName) {
        this._textDeckName = textDeckName;
    }

    public Button getSaveButton() {
        return _saveButton;
    }

    public void setSaveButton(Button saveButton) {
        this._saveButton = saveButton;
    }

    public void toastify(String text) {
        _toaster = Toast.makeText(this, text, Toast.LENGTH_SHORT);
        _toaster.show();
    }

    public DeckDataSource getDeckDataSource(){
        return _deckDataSource;
    }
}
