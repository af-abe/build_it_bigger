package abe.appsfactory.nanodegree.bib.ui;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import abe.appsfactory.nanodegree.bib.R;
import abe.appsfactory.nanodegree.bib.databinding.ActivityMainBinding;
import abe.appsfactory.nanodegree.bib.presenter.MainPresenter;

public class MainActivity extends AppCompatActivity {

    private MainPresenter mPresenter;
    ActivityMainBinding mBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mPresenter = new MainPresenter();

        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        mBinding.setPresenter(mPresenter);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        mPresenter.saveState(outState);
    }
}
