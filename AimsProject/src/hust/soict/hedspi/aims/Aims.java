package AimsProject.src.hust.soict.hedspi.aims;

import java.util.Scanner;
import AimsProject.src.hust.soict.hedspi.aims.cart.Cart;
import AimsProject.src.hust.soict.hedspi.aims.store.Store;
import AimsProject.src.hust.soict.hedspi.aims.media.Media;
import AimsProject.src.hust.soict.hedspi.aims.media.Playable;
import AimsProject.src.hust.soict.hedspi.aims.media.DigitalVideoDisc;
// assuming CompactDisc and Track are there if needed to be added to store

public class Aims {
    private static Store store = new Store();
    private static Cart cart = new Cart();
    private static Scanner scanner = new Scanner(System.in);

    public static void showMenu() {
        System.out.println("AIMS: ");
        System.out.println("--------------------------------");
        System.out.println("1. View store");
        System.out.println("2. Update store");
        System.out.println("3. See current cart");
        System.out.println("0. Exit");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2-3");
    }

    public static void storeMenu() {
        System.out.println("Options: ");
        System.out.println("--------------------------------");
        System.out.println("1. See a media's details");
        System.out.println("2. Add a media to cart");
        System.out.println("3. Play a media");
        System.out.println("4. See current cart");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2-3-4");
    }

    public static void mediaDetailsMenu() {
        System.out.println("Options: ");
        System.out.println("--------------------------------");
        System.out.println("1. Add to cart");
        System.out.println("2. Play");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2");
    }

    public static void cartMenu() {
        System.out.println("Options: ");
        System.out.println("--------------------------------");
        System.out.println("1. Filter media in cart");
        System.out.println("2. Sort media in cart");
        System.out.println("3. Remove media from cart");
        System.out.println("4. Play a media");
        System.out.println("5. Place order");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2-3-4-5");
    }

    public static void main(String[] args) {
        // init some medias
        store.addMedia(new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f));
        store.addMedia(new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 87, 24.95f));
        store.addMedia(new DigitalVideoDisc("Aladin", "Animation", 18.99f));

        int choice;
        do {
            showMenu();
            choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    handleViewStore();
                    break;
                case 2:
                    handleUpdateStore();
                    break;
                case 3:
                    handleSeeCart();
                    break;
                case 0:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        } while (choice != 0);
    }

    private static void handleViewStore() {
        store.print();
        int choice;
        do {
            storeMenu();
            choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    System.out.print("Enter media title: ");
                    String title = scanner.nextLine();
                    Media media = store.searchByTitle(title);
                    if (media != null) {
                        System.out.println(media.toString());
                        handleMediaDetails(media);
                    } else {
                        System.out.println("Media not found.");
                    }
                    break;
                case 2:
                    System.out.print("Enter media title to add to cart: ");
                    String titleAdd = scanner.nextLine();
                    Media mediaAdd = store.searchByTitle(titleAdd);
                    if (mediaAdd != null) {
                        cart.addMedia(mediaAdd);
                    } else {
                        System.out.println("Media not found.");
                    }
                    break;
                case 3:
                    System.out.print("Enter media title to play: ");
                    String titlePlay = scanner.nextLine();
                    Media mediaPlay = store.searchByTitle(titlePlay);
                    if (mediaPlay != null) {
                        if (mediaPlay instanceof Playable) {
                            ((Playable) mediaPlay).play();
                        } else {
                            System.out.println("This media cannot be played.");
                        }
                    } else {
                        System.out.println("Media not found.");
                    }
                    break;
                case 4:
                    handleSeeCart();
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        } while (choice != 0);
    }

    private static void handleMediaDetails(Media media) {
        int choice;
        do {
            mediaDetailsMenu();
            choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    cart.addMedia(media);
                    break;
                case 2:
                    if (media instanceof Playable) {
                        ((Playable) media).play();
                    } else {
                        System.out.println("This media cannot be played.");
                    }
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        } while (choice != 0 && choice != 1); // Go back if chosen 1 (add to cart) or 0
    }

    private static void handleUpdateStore() {
        System.out.println("1. Add a media");
        System.out.println("2. Remove a media");
        System.out.print("Choose option: ");
        int choice = scanner.nextInt();
        scanner.nextLine();
        if (choice == 1) {
            System.out.println("Enter title for new DVD (for simplicity): ");
            String title = scanner.nextLine();
            store.addMedia(new DigitalVideoDisc(title, "Unknown", 0.0f));
        } else if (choice == 2) {
            System.out.println("Enter title of media to remove: ");
            String title = scanner.nextLine();
            Media media = store.searchByTitle(title);
            if (media != null) {
                store.removeMedia(media);
            } else {
                System.out.println("Media not found in store.");
            }
        }
    }

    private static void handleSeeCart() {
        cart.print();
        int choice;
        do {
            cartMenu();
            choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    System.out.println("1. Filter by id");
                    System.out.println("2. Filter by title");
                    int filterOpt = scanner.nextInt();
                    scanner.nextLine();
                    if (filterOpt == 1) {
                        System.out.print("Enter id: ");
                        int id = scanner.nextInt();
                        cart.searchById(id);
                    } else if (filterOpt == 2) {
                        System.out.print("Enter title: ");
                        String t = scanner.nextLine();
                        cart.searchByTitle(t);
                    }
                    break;
                case 2:
                    System.out.println("1. Sort by title then cost");
                    System.out.println("2. Sort by cost then title");
                    int sortOpt = scanner.nextInt();
                    scanner.nextLine();
                    if (sortOpt == 1) {
                        cart.sortByTitleCost();
                        cart.print();
                    } else if (sortOpt == 2) {
                        cart.sortByCostTitle();
                        cart.print();
                    }
                    break;
                case 3:
                    System.out.print("Enter title to remove: ");
                    String removeTitle = scanner.nextLine();
                    Media mRemove = cart.searchMediaByTitle(removeTitle);
                    if (mRemove != null) {
                        cart.removeMedia(mRemove);
                    } else {
                        System.out.println("Media not found in cart.");
                    }
                    break;
                case 4:
                    System.out.print("Enter title to play: ");
                    String playTitle = scanner.nextLine();
                    Media mPlay = cart.searchMediaByTitle(playTitle);
                    if (mPlay != null) {
                        if (mPlay instanceof Playable) {
                            ((Playable) mPlay).play();
                        } else {
                            System.out.println("This media cannot be played.");
                        }
                    } else {
                        System.out.println("Media not found in cart.");
                    }
                    break;
                case 5:
                    System.out.println("An order is created.");
                    cart.emptyCart();
                    choice = 0; // go back
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        } while (choice != 0);
    }
}
