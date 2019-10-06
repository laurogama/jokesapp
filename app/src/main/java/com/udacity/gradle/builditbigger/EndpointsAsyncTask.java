package com.udacity.gradle.builditbigger;

import android.os.AsyncTask;

import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.udacity.gradle.builditbigger.backend.myApi.MyApi;
import com.udacity.gradle.builditbigger.backend.myApi.model.Joke;

import java.io.IOException;

class EndpointsAsyncTask extends AsyncTask<Void, Void, Joke> {
    private static MyApi myApiService = null;
    private AsyncResponse delegate;

    public EndpointsAsyncTask(AsyncResponse delegate) {
        this.delegate = delegate;
    }

    @Override
    protected final Joke doInBackground(Void... params) {
        if (myApiService == null) {  // Only do this once
            MyApi.Builder builder = new MyApi.Builder(AndroidHttp.newCompatibleTransport(),
                    new AndroidJsonFactory(), null)
                    // options for running against local devappserver
                    // - 10.0.2.2 is localhost's IP address in Android emulator
                    // - turn off compression when running against local devappserver
                    .setRootUrl(BuildConfig.API_URL)
                    .setGoogleClientRequestInitializer(
                            abstractGoogleClientRequest -> abstractGoogleClientRequest.setDisableGZipContent(true));
            myApiService = builder.build();
        }
        try {
            return myApiService.getJoke().execute();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    protected void onPostExecute(Joke result) {
        delegate.processFinish(result);
    }

    public interface AsyncResponse {
        void processFinish(Joke output);
    }
}