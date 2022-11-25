/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package dev.kit2512.oop_sms.presentation.views.InfoView;

import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author h
 */
public final class UserImagePanel extends javax.swing.JPanel {

    ImageIcon imageIcon;

    /**
     * Creates new form ImageView
     */
    public UserImagePanel(int width, int height) {
        super();
        initComponents();
        imageIcon = new ImageIcon("./src/res/dummy_user_img.png");
            final ImageIcon scaledImage = getScaledImage(imageIcon, width, height);
        final JLabel label = new JLabel(scaledImage);
        this.add(label);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setMaximumSize(new java.awt.Dimension(182, 246));
        setMinimumSize(new java.awt.Dimension(182, 246));
        setPreferredSize(new java.awt.Dimension(184, 246));
        setLayout(new javax.swing.BoxLayout(this, javax.swing.BoxLayout.LINE_AXIS));
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
    public ImageIcon getScaledImage(ImageIcon icon, int w, int h)
    {
        int nw = icon.getIconWidth();
        int nh = icon.getIconHeight();

        if(icon.getIconWidth() > w)
        {
          nw = w;
          nh = (nw * icon.getIconHeight()) / icon.getIconWidth();
        }

        if(nh > h)
        {
          nh = h;
          nw = (icon.getIconWidth() * nh) / icon.getIconHeight();
        }

        return new ImageIcon(icon.getImage().getScaledInstance(nw, nh, Image.SCALE_DEFAULT));
    }
    
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.pack();
        frame.setVisible(true);
    }
}