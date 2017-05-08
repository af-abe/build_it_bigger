package abe.appsfactory.nanodegree.bib.ui;

import android.content.Context;
import android.support.test.runner.AndroidJUnit4;
import android.test.mock.MockContext;


import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import abe.appsfactory.nanodegree.bib.network.JokeLoader;

@RunWith(AndroidJUnit4.class)
public class JokeTest {
    @Test
    public void testVerifyJokeTask() {
        new JokeLoader(new MockContext()).execute(new JokeLoader.JokeListener() {
            @Override
            public void jokeLoaded(Context context, String joke) {
                Assert.assertNotNull(joke);
                Assert.assertNotSame("", joke);
                Assert.assertNotSame("no backend reachable", joke);
            }
        });
    }
}