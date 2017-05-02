package com.example.suggestionsearchbox;

import android.content.Context;
import android.widget.ArrayAdapter;

import java.util.ArrayList;

/**
 * Created by mortenj on 02.05.2017.
 */

public interface SuggestionSearchRunner<T> {
    public ArrayList<T> doSearch(CharSequence c);
    public ArrayAdapter<T> getAdapter(Context c, ArrayList<T> results);
}
