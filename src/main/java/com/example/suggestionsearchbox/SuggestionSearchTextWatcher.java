package com.example.suggestionsearchbox;

import android.os.Handler;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;

/**
 * Created by mortenj on 02.05.2017.
 */

public class SuggestionSearchTextWatcher implements TextWatcher {
    private SuggestionSearchTextView view;
    private Handler searchHandler = new Handler();
    private int searchDelay = 500;

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {
        final CharSequence search = s;
        getSearchHandler().removeCallbacksAndMessages(null);
        if(view.isEnabled()) {
            getSearchHandler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    if(search.length() > 0) {
                        SuggestionSearchRunner runner = getView().getSearchRunner();
                        if(runner != null) {
                            view.setSearchResult(runner.doSearch(search));
                        } else {
                            Log.d(this.getClass().toString(), "No SuggestionSearchRunner set!");
                        }
                    }
                }
            }, this.searchDelay);

        }

    }

    @Override
    public void afterTextChanged(Editable s) {

    }

    public SuggestionSearchTextView getView() {
        return view;
    }

    public void setView(SuggestionSearchTextView view) {
        this.view = view;
    }

    public int getSearchDelay() {
        return searchDelay;
    }

    public void setSearchDelay(int searchDelay) {
        this.searchDelay = searchDelay;
    }

    public Handler getSearchHandler() {
        return searchHandler;
    }

    public void setSearchHandler(Handler searchHandler) {
        this.searchHandler = searchHandler;
    }
}
