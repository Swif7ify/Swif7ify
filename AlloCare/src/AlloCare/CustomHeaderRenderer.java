package AlloCare;

import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;

public class CustomHeaderRenderer implements TableCellRenderer {
    DefaultTableCellRenderer renderer;

    public CustomHeaderRenderer(JTable table) {
        renderer = (DefaultTableCellRenderer) table.getTableHeader().getDefaultRenderer();
        renderer.setHorizontalAlignment(JLabel.CENTER);
    }

    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        JLabel label = (JLabel) renderer.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        label.setForeground(Color.WHITE); // Set header text color
        label.setFont(new Font("Tahoma", Font.PLAIN, 25));
        label.setBackground(new Color(46, 66, 77)); // Set header background color
        label.setOpaque(true);

        // Add padding (insets) to header cells
        label.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20)); // Top, Left, Bottom, Right padding

        return label;
    }
}