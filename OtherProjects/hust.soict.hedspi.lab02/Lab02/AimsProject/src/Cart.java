package Lab02.AimsProject.src;

import AimsProject.src.DigitalVideoDisc;

public class Cart {
    public static final int MAX_NUMBERS_ORDERED = 20;
    private DigitalVideoDisc itemsOrdered[] = new DigitalVideoDisc[MAX_NUMBERS_ORDERED];
    private int qtyOrdered = 0;

    public void addDigitalVideoDisc(DigitalVideoDisc disc){
        if (qtyOrdered < MAX_NUMBERS_ORDERED){
            itemsOrdered[qtyOrdered] = disc;
            qtyOrdered++;
            System.out.println("The disc has been added");
        }
        else{
            System.out.println("The cart is almost full");
        }
    }

    public void addDigitalVideoDisc(DigitalVideoDisc [] dvdList){
        for (DigitalVideoDisc disc : dvdList){
            if (qtyOrdered < MAX_NUMBERS_ORDERED){
                addDigitalVideoDisc(disc);
            }
            else{
                System.out.println("The cart is almost full. Cannot add: " + disc.getTitle());
                break;
            }
        }
    }

    public void addDigitalVideoDisc(DigitalVideoDisc dvd1, DigitalVideoDisc dvd2){
        if (qtyOrdered + 1 < MAX_NUMBERS_ORDERED){
            addDigitalVideoDisc(dvd1);
            addDigitalVideoDisc(dvd2);
        }
        else{
            System.out.println("Not enough space in cart for 2 discs");
        }
    }

    public void removeDigitalVideoDisc(DigitalVideoDisc disc){
        boolean found = false;
        for (int i = 0; i < qtyOrdered; i++){
            if (itemsOrdered[i] == disc){
                for (int j = i; j < qtyOrdered - 1; j++){
                    itemsOrdered[j] = itemsOrdered[j+1];
                }
                itemsOrdered[qtyOrdered-1] = null;
                qtyOrdered--;
                System.out.println("Removed");
                found = true;
                break;
            }
        }
        if (!found){
            System.out.println("Cannot found");
        }
    }

    public float totalCost(){
        float total = 0.0f;
        for (int i = 0;i < qtyOrdered; i++){
            total += itemsOrdered[i].getCost();
        }
        return total;
    }
}
