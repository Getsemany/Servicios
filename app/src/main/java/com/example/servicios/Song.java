package com.example.servicios;

public class Song {
    private  int id;
    private String name;
    private String audio;


    public Song(int id, String name, String audio) {
        this.id = id;
        this.name = name;
        this.audio = audio;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAudio() {
        return audio;
    }

    public void setAudio(String audio) {
        this.audio = audio;
    }
}
