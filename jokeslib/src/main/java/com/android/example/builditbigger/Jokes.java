package com.android.example.builditbigger;

import com.android.example.builditbigger.model.Joke;

import java.util.Random;

public class Jokes {

    private static Joke[] jokeList =
            {
                    new Joke("http://rd.com",
                            "Why do we tell actors to 'break a leg?'" +
                                    "\nBecause every play has a cast."),
                    new Joke("https://short-funny.com", "I used to breed rabbits. Then I realized they can handle it themselves."),
                    new Joke("https://short-funny.com", "My dog is an awesome fashion adviser. Every time I ask him what I look like in my clothes, he says “WOW!” "),
                    new Joke("https://short-funny.com", "Why are eggs not very much into jokes? Because they could crack up. ")
            };


    public static Joke getJoke() {
        return jokeList[new Random().nextInt(jokeList.length)];
    }
}
