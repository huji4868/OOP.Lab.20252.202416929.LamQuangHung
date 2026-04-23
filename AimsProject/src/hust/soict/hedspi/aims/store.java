package AimsProject.src.hust.soict.hedspi.aims;

public class store {
    private DigitalVideoDisc[] itemInStore = new DigitalVideoDisc[100];
    private int qtyInStore = 0;
    public void addDVD(DigitalVideoDisc dvd){
        if (qtyInStore < itemInStore.length){
            itemInStore[qtyInStore] = dvd;
            qtyInStore++;
            System.out.println("DVD " + dvd.getTitle() + " added");
        }
        else{
            System.out.println("Full");
        }
    }
    public void removeDVD(DigitalVideoDisc dvd){
        boolean found = false;
        for (int i = 0; i <qtyInStore; i++){
            if (itemInStore[i] == dvd) {
                for (int j = 0; j < qtyInStore - 1; j++) {
                    itemInStore[j] = itemInStore[j + 1];
                }
                itemInStore[qtyInStore - 1] = null;
                qtyInStore--;
                System.out.println("DVD " + dvd.getTitle() + " is removed");
                found = true;
                break;
            }
        }
        if (!found){
            System.out.println("Not found");
        }
    }

}

