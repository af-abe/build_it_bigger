package abe.appsfactory.nanodegree.bib.presenter;

import android.content.Context;
import android.content.Intent;
import android.databinding.ObservableBoolean;

import abe.appsfactory.nanodegree.bib.network.JokeLoader;
import bakingapp.nanodegree.appsfactory.abe.jokepresenterlibrary.JokeActivity;

public class MainPresenter extends BasePresenter implements JokeLoader.JokeListener {

    public ObservableBoolean isLoading = new ObservableBoolean(false);

    public void tellJoke(Context context) {
        isLoading.set(true);
        new JokeLoader(context).execute(this);
    }

    @Override
    public void jokeLoaded(Context context, String joke) {
        isLoading.set(false);
        Intent i = new Intent(context, JokeActivity.class);
        i.putExtra(JokeActivity.EXTRA_JOKE, joke);
        context.startActivity(i);
    }
}
