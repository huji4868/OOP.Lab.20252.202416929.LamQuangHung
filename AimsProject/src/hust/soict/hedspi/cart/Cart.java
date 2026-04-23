package AimsProject.src.hust.soict.hedspi.cart;

import AimsProject.src.hust.soict.hedspi.digitalvideodisc.DigitalVideoDisc;

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

    public void print(){
        System.out.println("***********************CART***********************");
        System.out.println("Ordered Items:");
        for (int i = 0; i < qtyOrdered; i++){
            System.out.println((i+1) + ". " + itemsOrdered[i].toString());
        }
        System.out.println("Total cost: " + totalCost() + " $");
        System.out.println("***************************************************");
    }

    public void findID(int id){
        boolean found = false;
        for (int i = 0; i < qtyOrdered; i++){
            if (itemsOrdered[i].getId() == id){
                System.out.println("Found: " + itemsOrdered[i].toString());
                found = true;
                break;
            }
        }
        if (!found){
            System.out.println("Cannot find");
        }
    }

    public void findtitle(String title){
        boolean found = false;
        for (int i = 0; i < qtyOrdered; i++){
            if (itemsOrdered[i].isMatch(title)){
                System.out.println("Foudn: " + itemsOrdered[i].toString());
                found = true;
            }
        }
        if (!found){
            System.out.println("Cannot find");
        }
    }

}
