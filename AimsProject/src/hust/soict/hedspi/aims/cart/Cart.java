package hust.soict.hedspi.aims.cart;
import java.util.ArrayList;
import hust.soict.hedspi.aims.media.Media;
public class Cart {
    public static final int MAX_NUMBERS_ORDERED = 20;
    private ArrayList<Media> itemsOrdered = new ArrayList<Media>();
    public void addMedia(Media media){
        if (itemsOrdered.size() < MAX_NUMBERS_ORDERED){
            if (!itemsOrdered.contains(media)) {
                itemsOrdered.add(media);
                System.out.println("The media " + media.getTitle() + " has been added");
            } else {
                System.out.println("The media "  + media.getTitle() + " is already in the cart");
            }
        }
        else {
            System.out.println("The cart is almost full");
        }
    }
    public void removeMedia(Media media){
        if (itemsOrdered.contains(media)){
            itemsOrdered.remove(media);
            System.out.println("The media " + media.getTitle() + " has been removed");
        }
        else {
            System.out.println("The media " + media.getTitle() + " is not in the cart");
        }
    }
    public float totalCost(){
        float total = 0.0f;
        for (Media media : itemsOrdered){
            total += media.getCost();
        }
        return total;
    }

    public void print() {
        System.out.println("***********************CART***********************");
        System.out.println("Ordered Items:");
        for (int i = 0; i < itemsOrdered.size(); i++) {
            System.out.println((i + 1) + ". " + itemsOrdered.get(i).toString());
        }
        System.out.println("Total cost: " + totalCost());
        System.out.println("***************************************************");
    }

    public void searchById(int id) {
        boolean found = false;
        for (Media media : itemsOrdered) {
            if (media.getId() == id) {
                System.out.println("Found media: " + media.toString());
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("No media found with id: " + id);
        }
    }

    public void searchByTitle(String title) {
        boolean found = false;
        for (Media media : itemsOrdered) {
            if (media.getTitle().equalsIgnoreCase(title)) {
                System.out.println("Found media: " + media.toString());
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("No media found with title: " + title);
        }
    }

    public Media searchMediaByTitle(String title) {
        for (Media media : itemsOrdered) {
            if (media.getTitle().equalsIgnoreCase(title)) {
                return media;
            }
        }
        return null;
    }

    public void sortByTitleCost() {
        java.util.Collections.sort(itemsOrdered, Media.COMPARE_BY_TITLE_COST);
        System.out.println("Cart sorted by Title then Cost.");
    }

    public void sortByCostTitle() {
        java.util.Collections.sort(itemsOrdered, Media.COMPARE_BY_COST_TITLE);
        System.out.println("Cart sorted by Cost then Title.");
    }

    public void emptyCart() {
        itemsOrdered.clear();
        System.out.println("Cart has been emptied.");
    }
}