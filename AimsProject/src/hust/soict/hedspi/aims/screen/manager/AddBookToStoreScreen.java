package hust.soict.hedspi.aims.screen.manager;

import javax.swing.*;
import java.awt.*;
import hust.soict.hedspi.aims.store.Store;
import hust.soict.hedspi.aims.media.Book;

public class AddBookToStoreScreen extends AddItemToStoreScreen {
    
    public AddBookToStoreScreen(Store store) {
        super(store, "Add Book to Store");
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
        JLabel formTitle = new JLabel("ADD BOOK TO STORE");
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
        
        // Authors field
        gbc.gridx = 0; gbc.gridy = 5;
        center.add(new JLabel("Authors (comma-separated):"), gbc);
        JTextField tfAuthors = new JTextField(20);
        gbc.gridx = 1;
        center.add(tfAuthors, gbc);
        
        // Add Button
        JButton btnAdd = new JButton("Add Book");
        btnAdd.setBackground(Color.CYAN);
        btnAdd.setFont(new Font("SansSerif", Font.BOLD, 14));
        gbc.gridx = 0; gbc.gridy = 6;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        center.add(btnAdd, gbc);
        
        btnAdd.addActionListener(e -> {
            try {
                int id = Integer.parseInt(tfId.getText().trim());
                String title = tfTitle.getText().trim();
                String category = tfCategory.getText().trim();
                float cost = Float.parseFloat(tfCost.getText().trim());
                
                Book book = new Book(id, title, category, cost);
                String[] authors = tfAuthors.getText().split(",");
                for (String author : authors) {
                    if (!author.trim().isEmpty()) {
                        book.addAuthor(author.trim());
                    }
                }
                
                store.addMedia(book);
                JOptionPane.showMessageDialog(this, "Book '" + title + "' added successfully!");
                new StoreManagerScreen(store);
                this.dispose();
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Please enter valid numbers for ID and Cost.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });
        
        return center;
    }
}
