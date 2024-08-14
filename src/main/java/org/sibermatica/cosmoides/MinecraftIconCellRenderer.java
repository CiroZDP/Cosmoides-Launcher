package org.sibermatica.cosmoides;

import java.awt.*;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;
import javax.swing.border.LineBorder;

/**
 *
 * @author CiroZDP
 */
public class MinecraftIconCellRenderer extends JLabel implements ListCellRenderer {

    public MinecraftIconCellRenderer() {
        setOpaque(true);
    }

    @Override
    public Component getListCellRendererComponent(JList list, Object obj, int index, boolean isSelected, boolean cellHasFocus) {
        String iconPath = index == Cosmoides.BUILD_RELEASE ? "/icon/release.png" : "/icon/snapshot.png";
        ImageIcon imageIcon = new ImageIcon(new ImageIcon(getClass().getResource(iconPath)).getImage().getScaledInstance(32, 32, Image.SCALE_SMOOTH));

        setBackground(list.getBackground());
        if (isSelected) {
            //setBackground(list.getSelectionBackground());
            setForeground(Color.WHITE);
            setFont(new Font("Roboto", Font.BOLD, 15));
        } else {
            setForeground(list.getForeground());
            setFont(new Font("Roboto", Font.PLAIN, 15));
        }

        setSize(getPreferredSize().width, 48);
        setPreferredSize(getSize());

        setIcon(imageIcon);
        setText("  " + obj);

        return this;
    }

}
