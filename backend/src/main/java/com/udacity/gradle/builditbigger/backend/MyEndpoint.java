package com.udacity.gradle.builditbigger.backend;

import com.android.example.builditbigger.Jokes;
import com.android.example.builditbigger.model.Joke;
import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiNamespace;

/**
 * An endpoint class we are exposing
 */
@Api(
        name = "myApi",
        version = "v1",
        namespace = @ApiNamespace(
                ownerDomain = "backend.builditbigger.gradle.udacity.com",
                ownerName = "backend.builditbigger.gradle.udacity.com",
                packagePath = ""
        )
)
public class MyEndpoint {

    /**
     * A simple endpoint method that gets a joke from jokeslib and returns to user
     *
     * @return a joke
     */
    @ApiMethod(name = "getJoke")
    public Joke getJoke() {
        return Jokes.getJoke();
    }

}
