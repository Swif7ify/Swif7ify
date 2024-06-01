package AlloCare;

import javax.swing.*;
import java.awt.*;

public class PlaceholderTextField extends JTextField {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String placeholder;

    public PlaceholderTextField(String placeholder) {
        this.placeholder = placeholder;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (getText().isEmpty() && !hasFocus()) {
            Graphics2D g2 = (Graphics2D) g.create();
            g2.setColor(Color.GRAY); // Placeholder text color
            g2.setFont(getFont().deriveFont(Font.ITALIC));
            
            // Calculate the vertical position to center the text
            FontMetrics fontMetrics = g2.getFontMetrics();
            int textHeight = fontMetrics.getHeight();
            int textY = (getHeight() - textHeight) / 2 + fontMetrics.getAscent();

            g2.drawString(placeholder, getInsets().left, textY); // Draw the text centered vertically
            g2.dispose();
        }
    }

    public String getPlaceholder() {
        return placeholder;
    }

    public void setPlaceholder(String placeholder) {
        this.placeholder = placeholder;
        repaint();
    }
}
