package com.udacity.gradle.builditbigger;

import android.text.TextUtils;

import androidx.test.ext.junit.runners.AndroidJUnit4;

import com.udacity.gradle.builditbigger.backend.myApi.model.Joke;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.platform.app.InstrumentationRegistry.getInstrumentation;

@RunWith(AndroidJUnit4.class)
public class EndpointsAsyncTaskTest implements EndpointsAsyncTask.AsyncResponse {
    private Joke joke;

    @Test
    public void testAsyncTask() {
        joke = null;
        final EndpointsAsyncTask asyncTask = new EndpointsAsyncTask(this);

        // start the activity on the main thread
        getInstrumentation().runOnMainSync(asyncTask::execute);

        // sleep for 10 seconds
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // check if the joke landed
        synchronized (this) {
            Assert.assertFalse("The content is not empty", TextUtils.isEmpty(joke.getContent()));
            Assert.assertFalse("The author is not empty", TextUtils.isEmpty(joke.getAuthor()));
        }
    }

    @Override
    public void processFinish(Joke output) {
        joke = output;
    }
}