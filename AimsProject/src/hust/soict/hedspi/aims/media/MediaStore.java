package AimsProject.src.hust.soict.hedspi.aims.media;

import javax.swing.*;
import java.awt.*;

public class MediaStore extends JPanel {
    private Media media;
    public MediaStore(Media media){
        this.media = media;
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        JLabel title = new JLabel(media.getTitle());
        title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 15));
        title.setAlignmentX(CENTER_ALIGNMENT);

        JLabel cost = new JLabel(""+media.getCost()+" $");
        cost.setAlignmentX(CENTER_ALIGNMENT);

        JPanel container = new JPanel();
        container.setLayout(new FlowLayout(FlowLayout.CENTER));

        if (media instanceof Playable){
            JButton playButton = new JButton("Play");
            playButton.addActionListener(e -> {
                JDialog dialog = new JDialog((Frame) SwingUtilities.getWindowAncestor(this), "Playing " + media.getTitle(), true);
                dialog.setLayout(new BorderLayout());
                
                JPanel mainPanel = new JPanel();
                mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
                mainPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
                mainPanel.setBackground(new Color(30, 30, 30));
                
                JLabel titleLabel = new JLabel("Playing: " + media.getTitle());
                titleLabel.setFont(new Font("SansSerif", Font.BOLD, 18));
                titleLabel.setForeground(Color.CYAN);
                titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
                mainPanel.add(titleLabel);
                mainPanel.add(Box.createVerticalStrut(15));
                
                StringBuilder details = new StringBuilder();
                if (media instanceof DigitalVideoDisc) {
                    DigitalVideoDisc dvd = (DigitalVideoDisc) media;
                    details.append("Type: Digital Video Disc (DVD)\n");
                    details.append("Category: ").append(dvd.getCategory()).append("\n");
                    details.append("Director: ").append(dvd.getDirector()).append("\n");
                    details.append("Length: ").append(dvd.getLength()).append(" minutes\n");
                    details.append("Cost: ").append(dvd.getCost()).append(" $\n");
                    dvd.play();
                } else if (media instanceof CompactDisc) {
                    CompactDisc cd = (CompactDisc) media;
                    details.append("Type: Compact Disc (CD)\n");
                    details.append("Artist: ").append(cd.getArtist()).append("\n");
                    details.append("Category: ").append(cd.getCategory()).append("\n");
                    details.append("Director: ").append(cd.getDirector()).append("\n");
                    details.append("Length: ").append(cd.getLength()).append(" minutes\n");
                    details.append("Cost: ").append(cd.getCost()).append(" $\n");
                    details.append("\nTracks:\n");
                    for (Track track : cd.getTracks()) {
                        details.append("- ").append(track.getTitle()).append(" (").append(track.getLength()).append(" mins)\n");
                    }
                    cd.play();
                }
                
                JTextArea textArea = new JTextArea(details.toString());
                textArea.setEditable(false);
                textArea.setFont(new Font("Monospaced", Font.PLAIN, 13));
                textArea.setForeground(Color.WHITE);
                textArea.setBackground(new Color(45, 45, 45));
                textArea.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
                
                JScrollPane scrollPane = new JScrollPane(textArea);
                scrollPane.setPreferredSize(new Dimension(350, 200));
                scrollPane.setBorder(BorderFactory.createLineBorder(Color.GRAY));
                mainPanel.add(scrollPane);
                
                mainPanel.add(Box.createVerticalStrut(15));
                
                JButton closeButton = new JButton("Close");
                closeButton.setAlignmentX(Component.CENTER_ALIGNMENT);
                closeButton.setBackground(Color.CYAN);
                closeButton.setForeground(Color.BLACK);
                closeButton.setFocusPainted(false);
                closeButton.setFont(new Font("SansSerif", Font.BOLD, 12));
                closeButton.addActionListener(ev -> dialog.dispose());
                mainPanel.add(closeButton);
                
                dialog.add(mainPanel, BorderLayout.CENTER);
                dialog.pack();
                dialog.setLocationRelativeTo(SwingUtilities.getWindowAncestor(this));
                dialog.setVisible(true);
            });
            container.add(playButton);
        }
        this.add(Box.createVerticalStrut(10));
        this.add(title);
        this.add(cost);
        this.add(Box.createVerticalGlue());
        this.add(container);

        this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
    }
}
