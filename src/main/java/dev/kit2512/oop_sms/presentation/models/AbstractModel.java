/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Beans/Bean.java to edit this template
 */
package dev.kit2512.oop_sms.presentation.models;

import java.beans.*;

/**
 *
 * @author macpro13
 */
public class AbstractModel {
    
    private final PropertyChangeSupport propertySupport;
    
    public AbstractModel() {
        propertySupport = new PropertyChangeSupport(this);
    }

    
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        propertySupport.addPropertyChangeListener(listener);
    }
    
    public void removePropertyChangeListener(PropertyChangeListener listener) {
        propertySupport.removePropertyChangeListener(listener);
    }
    
    public void firePropertyChange(String propertyName, Object oldValue, Object newValue) {
        propertySupport.firePropertyChange(propertyName, oldValue, newValue);
    }
    
}
