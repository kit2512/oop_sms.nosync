/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package dev.kit2512.oop_sms.presentation.views.DashboardView;

import dev.kit2512.oop_sms.presentation.controllers.AbstractController;
import dev.kit2512.oop_sms.presentation.controllers.DashboardController;
import dev.kit2512.oop_sms.presentation.views.AbstractView;
import java.beans.PropertyChangeEvent;
import javax.inject.Inject;

/**
 *
 * @author macpro13
 */
public class StaffListPanel extends javax.swing.JPanel implements AbstractView {

    private final AbstractController controller;

    /**
     * Creates new form StaffListPanel
     *
     * @param controller
     */
    @Inject
    public StaffListPanel(DashboardController controller) {
        this.controller = controller;
        initComponents();
        addView();

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setName("Staff"); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void addView() {
        controller.addView(this);
    }

    @Override
    public void modelPropertyChange(PropertyChangeEvent event) {
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
