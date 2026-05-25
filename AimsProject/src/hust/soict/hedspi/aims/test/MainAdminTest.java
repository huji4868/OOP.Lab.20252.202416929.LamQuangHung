package hust.soict.hedspi.aims.test;

import hust.soict.hedspi.aims.store.Store;
import hust.soict.hedspi.aims.media.Book;
import hust.soict.hedspi.aims.media.DigitalVideoDisc;
import hust.soict.hedspi.aims.media.CompactDisc;
import hust.soict.hedspi.aims.screen.manager.StoreManagerScreen;

public class MainAdminTest {
        public static void main(String[] args) {
                Store store = new Store();
                DigitalVideoDisc dvd1 = new DigitalVideoDisc("Harry Potter and the Philosopher's Stone", "Adventure",
                                "Chris Columbus", 152, 3.0f);
                DigitalVideoDisc dvd2 = new DigitalVideoDisc("Harry Potter and the Chamber of Secrets", "Adventure",
                                "Chris Columbus", 161, 3.5f);
                DigitalVideoDisc dvd3 = new DigitalVideoDisc("Harry Potter and the Prisoner of Azkaban", "Adventure",
                                "Alfonso Cuarón", 142, 5.0f);
                DigitalVideoDisc dvd4 = new DigitalVideoDisc("Harry Potter and the Goblet of Fire", "Adventure",
                                "Mike Newell",
                                157, 4.5f);

                Book book1 = new Book(1, "The Hunger Games", "Sci-Fi", 5.5f);
                Book book2 = new Book(2, "Catching Fire", "Sci-Fi", 4.9f);
                Book book3 = new Book(3, "Mockingjay", "Sci-Fi", 5.1f);

                CompactDisc cd1 = new CompactDisc(4, "Fetch the Bolt Cutters", "Alternative", 10.39f, "Unknown",
                                "Fiona Apple");
                CompactDisc cd2 = new CompactDisc(5, "Future Nostalgia", "Pop", 9.60f, "Unknown", "Dua Lipa");

                store.addMedia(dvd1);
                store.addMedia(dvd2);
                store.addMedia(dvd3);
                store.addMedia(dvd4);
                store.addMedia(cd1);
                store.addMedia(cd2);
                store.addMedia(book1);
                store.addMedia(book2);
                store.addMedia(book3);
                new StoreManagerScreen(store);
        }
}
