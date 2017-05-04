package abe.appsfactory.nanodegree.bib.network;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import com.example.andre.myapplication.backend.myApi.MyApi;
import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;

import java.io.IOException;

public class JokeLoader extends AsyncTask<JokeLoader.JokeListener, Void, String> {

    private static MyApi jokeApi = null;
    private Context mContext;

    private JokeListener mJokeListener;

    public JokeLoader(Context context) {
        mContext = context;
    }

    @Override
    protected String doInBackground(JokeListener... listeners) {
        if (jokeApi == null) {  // Only do this once
            MyApi.Builder builder = new MyApi.Builder(AndroidHttp.newCompatibleTransport(),
                    new AndroidJsonFactory(), null)
                    .setRootUrl("http://10.0.2.2:8080/_ah/api/") // 10.0.2.2 is localhost's IP address in Android emulator
                    .setGoogleClientRequestInitializer(abstractGoogleClientRequest -> abstractGoogleClientRequest.setDisableGZipContent(true));
            // end options for devappserver

            jokeApi = builder.build();
        }
        if (listeners != null && listeners.length > 0) {
            mJokeListener = listeners[0];
        }
        try {
            return jokeApi.getJoke().execute().getData();
        } catch (IOException e) {
            Log.e("JokeLoader", e.getMessage());
            return "no backend reachable";
        }
    }

    @Override
    protected void onPostExecute(String joke) {
        if (mJokeListener != null) {
            mJokeListener.jokeLoaded(mContext, joke);
            mJokeListener = null;
        }
        mContext = null;
    }

    public interface JokeListener {
        void jokeLoaded(Context context, String joke);
    }
}