package com.dhinesh;

public class Song {
    String songTitle;
    double duration;

    
    public Song(String songTitle, double duration){
        this.songTitle = songTitle;
        this.duration = duration;
    }
    public Song(){
        
    }
    public String getSongTitle() {
        return songTitle;
    }
    public double getDuration() {
        return duration;
    }
    @Override
    public String toString() {
        return "Song { title = " + songTitle + ", duration = " + duration + " }";
    }
}
