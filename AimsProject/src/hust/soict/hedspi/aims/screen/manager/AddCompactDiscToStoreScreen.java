package AimsProject.src.hust.soict.hedspi.aims.screen.manager;

import javax.swing.*;
import java.awt.*;
import AimsProject.src.hust.soict.hedspi.aims.store.Store;
import AimsProject.src.hust.soict.hedspi.aims.media.CompactDisc;
import AimsProject.src.hust.soict.hedspi.aims.media.Track;

public class AddCompactDiscToStoreScreen extends AddItemToStoreScreen {
    
    public AddCompactDiscToStoreScreen(Store store) {
        super(store, "Add Compact Disc (CD) to Store");
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
        JLabel formTitle = new JLabel("ADD CD TO STORE");
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
        
        // ID field
        gbc.gridx = 0; gbc.gridy = 1;
        center.add(new JLabel("ID:"), gbc);
        JTextField tfId = new JTextField(20);
        gbc.gridx = 1;
        center.add(tfId, gbc);
        
        // Title field
        gbc.gridx = 0; gbc.gridy = 2;
        center.add(new JLabel("Title:"), gbc);
        JTextField tfTitle = new JTextField(20);
        gbc.gridx = 1;
        center.add(tfTitle, gbc);
        
        // Category field
        gbc.gridx = 0; gbc.gridy = 3;
        center.add(new JLabel("Category:"), gbc);
        JTextField tfCategory = new JTextField(20);
        gbc.gridx = 1;
        center.add(tfCategory, gbc);
        
        // Cost field
        gbc.gridx = 0; gbc.gridy = 4;
        center.add(new JLabel("Cost ($):"), gbc);
        JTextField tfCost = new JTextField(20);
        gbc.gridx = 1;
        center.add(tfCost, gbc);
        
        // Director field
        gbc.gridx = 0; gbc.gridy = 5;
        center.add(new JLabel("Director:"), gbc);
        JTextField tfDirector = new JTextField(20);
        gbc.gridx = 1;
        center.add(tfDirector, gbc);
        
        // Artist field
        gbc.gridx = 0; gbc.gridy = 6;
        center.add(new JLabel("Artist:"), gbc);
        JTextField tfArtist = new JTextField(20);
        gbc.gridx = 1;
        center.add(tfArtist, gbc);
        
        // Tracks field
        gbc.gridx = 0; gbc.gridy = 7;
        center.add(new JLabel("Tracks (e.g. Song A:3, Song B:4):"), gbc);
        JTextField tfTracks = new JTextField(20);
        gbc.gridx = 1;
        center.add(tfTracks, gbc);
        
        // Add Button
        JButton btnAdd = new JButton("Add CD");
        btnAdd.setBackground(Color.CYAN);
        btnAdd.setFont(new Font("SansSerif", Font.BOLD, 14));
        gbc.gridx = 0; gbc.gridy = 8;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        center.add(btnAdd, gbc);
        
        btnAdd.addActionListener(e -> {
            try {
                int id = Integer.parseInt(tfId.getText().trim());
                String title = tfTitle.getText().trim();
                String category = tfCategory.getText().trim();
                float cost = Float.parseFloat(tfCost.getText().trim());
                String director = tfDirector.getText().trim();
                String artist = tfArtist.getText().trim();
                
                CompactDisc cd = new CompactDisc(id, title, category, cost, director, artist);
                
                String trackInput = tfTracks.getText().trim();
                if (!trackInput.isEmpty()) {
                    String[] trackTokens = trackInput.split(",");
                    for (String token : trackTokens) {
                        String[] parts = token.split(":");
                        String trackTitle = parts[0].trim();
                        int trackLength = 0;
                        if (parts.length > 1) {
                            try {
                                trackLength = Integer.parseInt(parts[1].trim());
                            } catch (NumberFormatException ignored) {}
                        }
                        cd.addTrack(new Track(trackTitle, trackLength));
                    }
                }
                
                store.addMedia(cd);
                JOptionPane.showMessageDialog(this, "Compact Disc '" + title + "' added successfully!");
                new StoreManagerScreen(store);
                this.dispose();
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Please enter valid numbers for ID and Cost.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });
        
        return center;
    }
}
