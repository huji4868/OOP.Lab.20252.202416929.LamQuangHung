package AimsProject.src.hust.soict.hedspi.aims.media;

public class DigitalVideoDisc extends Disc implements Playable {
    private static int nbDigitalVideoDiscs = 0;

    public String getDirector() {
        return director;
    }

    public int getLength() {
        return length;
    }

    private static int nextId(){
        nbDigitalVideoDiscs++;
        return nbDigitalVideoDiscs;
    }

    public DigitalVideoDisc(String title){
        super(nextId(), title, null, 0, 0, null);
    }

    public DigitalVideoDisc(String category, String title, float cost){
        super(nextId(), title, category, cost, 0, null);
    }

    public DigitalVideoDisc(String director, String category, String title, float cost){
        super(nextId(), title, category, cost, 0, director);
    }

    public DigitalVideoDisc(String title, String category, String director, int length, float cost){
        super(nextId(), title, category, cost, length, director);
    }

    public void play(){
        System.out.println("Playing DVD: " + this.getTitle());
        System.out.println("DVD length: " + this.getLength());
    }
}
