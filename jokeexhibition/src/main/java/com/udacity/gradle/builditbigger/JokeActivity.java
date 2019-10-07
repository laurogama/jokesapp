package com.udacity.gradle.builditbigger;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.android.example.builditbigger.model.Joke;

public class JokeActivity extends AppCompatActivity {

    private static final String EXTRA_JOKE = "com.udacity.gradle.builditbigger.extra_joke";

    //private ActivityViewModel viewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_joke);
        Intent myIntent = getIntent();
        if (myIntent.hasExtra(EXTRA_JOKE)) {
            Joke joke = (Joke) myIntent.getSerializableExtra(EXTRA_JOKE);
            TextView tvJokeContent = findViewById(R.id.tv_joke);
            TextView tvJokeAuthor = findViewById(R.id.tv_author);

            tvJokeAuthor.setText(joke.getAuthor());
            tvJokeContent.setText(joke.getContent());
        }
        if (savedInstanceState == null) {

        }
    }
}
