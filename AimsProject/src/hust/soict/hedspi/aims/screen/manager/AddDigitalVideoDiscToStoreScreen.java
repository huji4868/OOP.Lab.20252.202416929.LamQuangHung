package AimsProject.src.hust.soict.hedspi.aims.screen.manager;

import javax.swing.*;
import java.awt.*;
import AimsProject.src.hust.soict.hedspi.aims.store.Store;
import AimsProject.src.hust.soict.hedspi.aims.media.DigitalVideoDisc;

public class AddDigitalVideoDiscToStoreScreen extends AddItemToStoreScreen {
    
    public AddDigitalVideoDiscToStoreScreen(Store store) {
        super(store, "Add Digital Video Disc (DVD) to Store");
        setVisible(true);
    }

    @Override
    protected JPanel createCenter() {
        JPanel center = new JPanel();
        center.setLayout(new GridBagLayout());
        center.setBackground(new Color(245, 245, 245));
        
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(10, 10, 10, 10);
        
        // Form Title
        JLabel formTitle = new JLabel("ADD DVD TO STORE");
        formTitle.setFont(new Font("SansSerif", Font.BOLD, 24));
        formTitle.setForeground(new Color(33, 33, 33));
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        center.add(formTitle, gbc);
        
        // Form Fields
        gbc.gridwidth = 1;
        gbc.anchor = GridBagConstraints.WEST;
        
        // Title field
        gbc.gridx = 0; gbc.gridy = 1;
        center.add(new JLabel("Title:"), gbc);
        JTextField tfTitle = new JTextField(20);
        gbc.gridx = 1;
        center.add(tfTitle, gbc);
        
        // Category field
        gbc.gridx = 0; gbc.gridy = 2;
        center.add(new JLabel("Category:"), gbc);
        JTextField tfCategory = new JTextField(20);
        gbc.gridx = 1;
        center.add(tfCategory, gbc);
        
        // Director field
        gbc.gridx = 0; gbc.gridy = 3;
        center.add(new JLabel("Director:"), gbc);
        JTextField tfDirector = new JTextField(20);
        gbc.gridx = 1;
        center.add(tfDirector, gbc);
        
        // Length field
        gbc.gridx = 0; gbc.gridy = 4;
        center.add(new JLabel("Length (mins):"), gbc);
        JTextField tfLength = new JTextField(20);
        gbc.gridx = 1;
        center.add(tfLength, gbc);
        
        // Cost field
        gbc.gridx = 0; gbc.gridy = 5;
        center.add(new JLabel("Cost ($):"), gbc);
        JTextField tfCost = new JTextField(20);
        gbc.gridx = 1;
        center.add(tfCost, gbc);
        
        // Add Button
        JButton btnAdd = new JButton("Add DVD");
        btnAdd.setBackground(Color.CYAN);
        btnAdd.setFont(new Font("SansSerif", Font.BOLD, 14));
        gbc.gridx = 0; gbc.gridy = 6;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        center.add(btnAdd, gbc);
        
        btnAdd.addActionListener(e -> {
            try {
                String title = tfTitle.getText().trim();
                String category = tfCategory.getText().trim();
                String director = tfDirector.getText().trim();
                int length = Integer.parseInt(tfLength.getText().trim());
                float cost = Float.parseFloat(tfCost.getText().trim());
                
                DigitalVideoDisc dvd = new DigitalVideoDisc(title, category, director, length, cost);
                
                store.addMedia(dvd);
                JOptionPane.showMessageDialog(this, "Digital Video Disc '" + title + "' added successfully!");
                new StoreManagerScreen(store);
                this.dispose();
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Please enter valid numbers for Length and Cost.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });
        
        return center;
    }
}
