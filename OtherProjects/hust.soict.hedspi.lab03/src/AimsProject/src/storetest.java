package AimsProject.src;

public class storetest {
    public static void main (String [] args){
        store Store = new store();
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation","Roger Allers", 87, 19.95f);
        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars","Science Fiction","George Lucas", 87, 24.95f);

        Store.addDVD(dvd1);
        Store.addDVD(dvd2);

        Store.removeDVD(dvd1);
        Store.removeDVD(dvd1);

    }
}
