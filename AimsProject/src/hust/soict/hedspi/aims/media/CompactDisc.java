package AimsProject.src.hust.soict.hedspi.aims.media;

import java.util.ArrayList;

public class CompactDisc extends Disc implements Playable {
    private String artist;
    private ArrayList<Track> tracks = new ArrayList<Track>();

    public CompacDisc(int id, String title, String category, float cost, String director, String artist){
        super(id, title, category, cost, 0, director);
        this.artist = artist;
    }

    public String getArtist(){
        return artist;
    }

    public void addTrack(Track track){
        if (!tracks.contains(track)){
            tracks.add(track);
            System.out.println("Added");
        }
        else {
            System.out.println("Already in the list");
        }
    }

    public void removeTrack(Track track){
        if (tracks.contains(track)){
            tracks.remove(track);
            System.out.println("Removed");
        }
        else{
            System.out.println("Not in the list");
        }
    }

    @Override
    public int getLength(){
        int totalLength = 0;
        for (Track track : tracks){
            totalLength += track.getLength();
        }
        return totalLength;
    }

    public void play(){
        System.out.println("Playing CD: " + this.getTitle());
        System.out.println("CD length: " + this.getLength());

        for (Track track : tracks){
            track.play();
        }
    }
}
