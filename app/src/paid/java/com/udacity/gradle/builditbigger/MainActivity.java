package com.udacity.gradle.builditbigger;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.udacity.gradle.builditbigger.backend.myApi.model.Joke;


public class MainActivity extends AppCompatActivity {
    static final String ACTION_EXHIBIT_JOKE = "com.udacity.gradle.builditbigger.extra_joke";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void tellJoke(View view) {
        new EndpointsAsyncTask(
                this::showJoke
        ).execute();
    }

    private void showJoke(Joke output) {
        if (output != null) {
            com.android.example.builditbigger.model.Joke jokeSerializable =
                    new com.android.example.builditbigger.model.Joke(
                            output.getAuthor()
                            , output.getContent());
            startActivity(new Intent(this, JokeActivity.class).putExtra(ACTION_EXHIBIT_JOKE,
                    jokeSerializable));
        } else {
            Toast.makeText(
                    this,
                    getString(R.string.error_connecting),
                    Toast.LENGTH_SHORT).show();
        }
    }


}
