package com.dhinesh;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

public class Main {
    private static ArrayList<Album> albums = new ArrayList<>();
    public static void main(String[] args) {

        
        Album album = new Album("album1", "Anirudh");

        album.addSong("Kaavala", 3.5);
        album.addSong("Vandha Edam", 4);
        album.addSong("Badass", 3);
        albums.add(album);
        
        album = new Album("album2", "A R Rahman");
        
        album.addSong("Sandhosa kaneere", 5);
        album.addSong("Vennilave vennilave", 5.5);
        album.addSong("Namma Satham", 4);
        albums.add(album);

        LinkedList<Song> playList_1 = new LinkedList<>();

        albums.get(0).addToPlayList("Kaavala", playList_1);
        albums.get(0).addToPlayList("Vandha Edam", playList_1);
        albums.get(1).addToPlayList("Sandhosa kaneere", playList_1);
        

        play(playList_1);
    }

    private static void play(LinkedList<Song> playList){
        Scanner sc = new Scanner(System.in);
        boolean quit = false;
        boolean forward = true;

        ListIterator<Song> listIterator = playList.listIterator();

        if(playList.size() == 0){
            System.out.println("This playlist have no song");
        }
        else{
            System.out.println("Now playing" + listIterator.next().toString());
            printMenu();
        }

        while(!quit){
            int action = sc.nextInt();
            
            switch(action){

                case 0: 
                    System.out.println("Playlist complete");
                    quit = true;
                    break;

                case 1:
                    if(playList.isEmpty())  {System.out.println("No Songs are Available"); break;} 
                    if(!forward){
                        if(listIterator.hasNext()){
                            listIterator.next();
                        }
                        forward = true;
                    }
                    if(listIterator.hasNext()){
                        System.out.println("Now playing " + listIterator.next().toString());
                    }else{
                        System.out.println("No songs available, reached end of the list");
                        forward = false;
                    }
                    break;

                case 2: 
                if(playList.isEmpty())  {System.out.println("No Songs are Available"); break;} 
                    if(forward){
                        if(listIterator.hasPrevious()){
                            listIterator.previous();
                        }
                        forward = false;
                    }
                    if(listIterator.hasPrevious()){
                        System.out.println("Now playing " + listIterator.previous().toString());
                    }
                    else{
                        System.out.println("We are at the first song");
                        forward = false;
                    }
                    break; 
                case 3:
                    if(forward){
                        if(listIterator.hasPrevious()){
                            System.out.println("Now playing " + listIterator.previous().toString());
                        }else{
                            System.out.println("we are at the start of the list");
                        }
                    }else{
                        if(listIterator.hasNext()){
                            System.out.println("Now playing " + listIterator.next().toString());
                            forward = true;
                        }else{
                            System.out.println("we have reached to the end of the list");
                        }
                    }
                    break;
                case 4: 
                    printList(playList);
                    break;
                case 5: 
                    printMenu();
                    break;
                case 6: 
                    if(playList.size()>0){
                        listIterator.remove();
                        if(listIterator.hasNext()){
                            if(listIterator.hasNext()){
                                System.out.println("Now playing " + listIterator.next().toString());
                            }else{
                                if(listIterator.hasPrevious()){
                                    System.out.println("now playing " + listIterator.previous().toString());
                                }
                            }
                        }
                    }
                    break;
            }
        }
        sc.close();
    }
    

    private static void printMenu(){
        System.out.println("Available options\n press");
        System.out.println("0 - to quit\n" + 
                            "1 - to play next song\n" +
                            "2 - to play previous song\n" + "3 - to replay current song\n" + "4 - list of all songs\n" + "5 - print all available options\n" + "6 - delete current song");
    }

    private static void printList(LinkedList<Song> playList){
        Iterator<Song> iterator = playList.iterator();
        System.out.println("----------------------");

        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }

        System.out.println("----------------------");
    }
}
