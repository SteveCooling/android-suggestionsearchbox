package com.example.suggestionsearchbox;


import android.content.Context;
import android.util.AttributeSet;
import java.util.ArrayList;

/**
 * Created by mortenj on 02.05.2017.
 */

public class SuggestionSearchTextView<T> extends android.support.v7.widget.AppCompatAutoCompleteTextView {

    private SuggestionSearchRunner<T> searchRunner;
    private ArrayList<T> searchResult;
    private SuggestionSearchTextWatcher searchTextWatcher;

    //public List<T> = history;

    public SuggestionSearchTextView(Context context) {
        super(context);
        setup();
    }

    public SuggestionSearchTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        setup();
    }

    public SuggestionSearchTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setup();
    }

    private void setup() {
        SuggestionSearchTextWatcher tw = getTextWatcher();
        this.setSearchTextWatcher(tw);
        this.addTextChangedListener(tw);
    }

    public void cancelSearch() {
        getSearchTextWatcher().getSearchHandler().removeCallbacksAndMessages(null);
    }

    public SuggestionSearchRunner<T> getSearchRunner() {
        return searchRunner;
    }

    public void setSearchRunner(SuggestionSearchRunner<T> searchRunner) {
        this.searchRunner = searchRunner;
    }

    private SuggestionSearchTextWatcher getTextWatcher() {
        SuggestionSearchTextWatcher tw = new SuggestionSearchTextWatcher();
        tw.setView(this);
        return tw;
    }

    public ArrayList<T> getSearchResult() {
        return searchResult;
    }

    public void setSearchResult(ArrayList<T> searchResult) {
        this.searchResult = searchResult;
        this.showSearchResult();
    }

    public void showSearchResult() {
        this.setAdapter(getSearchRunner().getAdapter(getContext(), getSearchResult()));
        this.showDropDown();
    }

    public SuggestionSearchTextWatcher getSearchTextWatcher() {
        return searchTextWatcher;
    }

    public void setSearchTextWatcher(SuggestionSearchTextWatcher searchTextWatcher) {
        this.searchTextWatcher = searchTextWatcher;
    }
}
