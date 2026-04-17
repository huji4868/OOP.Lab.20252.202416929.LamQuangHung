package Lab02.AimsProject.src;

import AimsProject.src.DigitalVideoDisc;

public class TestPassingParameter {
    public static void main(String[] args) {
        AimsProject.src.DigitalVideoDisc jungleDVD = new AimsProject.src.DigitalVideoDisc("Jungle");
        AimsProject.src.DigitalVideoDisc cinderellaDVD = new AimsProject.src.DigitalVideoDisc("Cinderella");

        swap(jungleDVD, cinderellaDVD);
        System.out.println("jungle dvd title: " + jungleDVD.getTitle());
        System.out.println("cinderella dvd title: " + cinderellaDVD.getTitle());

        changeTitle(jungleDVD, cinderellaDVD.getTitle());
        System.out.println("jungle dvd title: " + jungleDVD.getTitle());
    }

    public static void swap(Object o1, Object o2) {
        Object tmp = o1;
        o1 = o2;
        o2 = tmp;
    }

    public static void changeTitle(AimsProject.src.DigitalVideoDisc dvd, String title) {
        String oldTitle = dvd.getTitle();
        dvd.setTitle(title);
        dvd = new DigitalVideoDisc(oldTitle);
    }
}