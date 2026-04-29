package AimsProject.src.hust.soict.hedspi.aims.cart;
import java.util.ArrayList;
import AimsProject.src.hust.soict.hedspi.aims.media.Media;
public class Cart {
    public static final int MAX_NUMBERS_ORDERED = 20;
    private ArrayList<Media> itemsOrdered = new ArrayList<Media>();
    public void addMedia(Media media){
        if (itemsOrdered.size() < MAX_NUMBERS_ORDERED){
            if (!itemsOrdered.contains(media)) {
                itemsOrdered.add(media);
                System.out.println("The media " + media.getTitle() + " has been added");
            } else {
                System.out.println("The media " + media.getTitle() + " is already in the cart");
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
}