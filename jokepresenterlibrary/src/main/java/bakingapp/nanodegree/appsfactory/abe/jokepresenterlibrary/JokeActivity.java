package bakingapp.nanodegree.appsfactory.abe.jokepresenterlibrary;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import bakingapp.nanodegree.appsfactory.abe.jokepresenterlibrary.databinding.ActivityJokeBinding;
import bakingapp.nanodegree.appsfactory.abe.jokepresenterlibrary.presenter.JokePresenter;

public class JokeActivity extends AppCompatActivity {

    public static final String EXTRA_JOKE = "extra.joke";
    private JokePresenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_joke);
        String joke = "";

        Intent intent = getIntent();
        if (intent != null && intent.hasExtra(EXTRA_JOKE)){
            joke = intent.getExtras().getString(EXTRA_JOKE);
        }

        mPresenter = new JokePresenter(joke);

        ActivityJokeBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_joke);
        binding.setPresenter(mPresenter);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        mPresenter.saveState(outState);
    }
}
