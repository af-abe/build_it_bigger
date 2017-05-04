package bakingapp.nanodegree.appsfactory.abe.jokepresenterlibrary.presenter;

import android.databinding.BaseObservable;
import android.databinding.ObservableField;
import android.os.Bundle;

/**
 * Created by André on 04.05.2017.
 */

public class JokePresenter extends BaseObservable {
    public final ObservableField<String> mJoke;

    public JokePresenter(String joke) {
        mJoke = new ObservableField<>(joke);
    }

    public void saveState(Bundle outState) {

    }
}
