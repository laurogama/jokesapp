package com.android.example.builditbigger.model;

import java.io.Serializable;

public class Joke implements Serializable {
    private String author;
    private String content;

    public Joke(String author, String content) {
        this.author = author;
        this.content = content;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
