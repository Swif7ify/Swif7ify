package AlloCare;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;

public class CustomTableCellRenderer extends DefaultTableCellRenderer {
    private static final long serialVersionUID = 1L;
    private static final Color ODD_ROW_COLOR = new Color(0xE6E6E6); // #E6E6E6
    public CustomTableCellRenderer() {
        setHorizontalAlignment(SwingConstants.CENTER); // Center align the text
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        Component rendererComponent = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

        // Set custom font for table cells
        rendererComponent.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 20));

        if (!isSelected) {
            // Check if the row index is odd
            if (row % 2 == 1) {
                rendererComponent.setBackground(ODD_ROW_COLOR);
            } else {
                // Reset background color for even rows
                rendererComponent.setBackground(table.getBackground());
            }
        }

        // Add padding (insets)
        if (rendererComponent instanceof JComponent) {
            ((JComponent) rendererComponent).setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15)); // Top, Left, Bottom, Right padding
        }

        return rendererComponent;
    }
}