package com.dhinesh;

import java.util.ArrayList;
import java.util.LinkedList;

public class Album {
    private String name;
    private String artist;
    private ArrayList<Song> songs;

    public Album(String name, String artist){
        this.name = name;
        this.artist = artist;
        this.songs = new ArrayList<Song>();
    }
    public Album(){

    }
    
    public boolean addSong(String title, double duration){
        
        if(findSong(title) == null){
            songs.add(new Song(title, duration));
            System.out.println(title + " is added to the list successfully!");
            return true;
        }
        else{
            System.out.println("Song with name " + title + " already exsits in the list!");
            return false;
        }
    }
    private Song findSong(String title) {
       for(Song checkedSong : songs){
            if(checkedSong.getSongTitle().equals(title)){
                return checkedSong;
            }
        }    
    return null;        
    }
    public boolean addToPlayList(int trackNumber, LinkedList<Song> Playlist){
        int index = trackNumber -1;
        if(index>0 && index <=this.songs.size()){
            Playlist.add(this.songs.get(index));
            return true;
        }

        System.out.println("This album does not have any song with track number" + trackNumber);
        return false;
        
    }
    public boolean addToPlayList(String title, LinkedList<Song> Playlist){
        for(Song checkedSong: this.songs){
            if(checkedSong.getSongTitle().equals(title)){
                Playlist.add(checkedSong);
                return true;
            }
        }
        System.out.println("This album does not have any song with title" + title);
        return false;
    }
    public String getName() {
        return name;
    }
    public String getArtist() {
        return artist;
    }
    public ArrayList<Song> getSongs() {
        return songs;
    }
    
}
