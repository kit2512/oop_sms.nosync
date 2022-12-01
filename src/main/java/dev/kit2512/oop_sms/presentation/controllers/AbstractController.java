/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dev.kit2512.oop_sms.presentation.controllers;

import dev.kit2512.oop_sms.presentation.models.AbstractModel;
import dev.kit2512.oop_sms.presentation.views.AbstractView;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Nguyen Huu Hung
 */
public abstract class AbstractController implements PropertyChangeListener {

    protected ArrayList<AbstractModel> registeredModels;
    protected ArrayList<AbstractView> registeredViews;

    public AbstractController() {
        this.registeredViews = new ArrayList<>();
        this.registeredModels = new ArrayList<>();
    }

    public void addModel(AbstractModel model) {
        model.addPropertyChangeListener(this);
        registeredModels.add(model);
    }

    public void removeModel(AbstractModel model) {
        model.removePropertyChangeListener(this);
        registeredModels.remove(model);
    }

    public void addView(AbstractView view) {
        registeredViews.add(view);
    }

    public void removeView(AbstractView view) {
        registeredViews.remove(view);
    }

    @Override
    public void propertyChange(PropertyChangeEvent event) {
        for (AbstractView view : registeredViews) {
            view.modelPropertyChange(event);
        }
    }

    protected void setModelProperty(String propertyName, Object newValue) {
        for (AbstractModel model : registeredModels) {
            try {
                final String methodName = "set" + propertyName;
                Method method = model.getClass()
                        .getMethod(methodName, newValue.getClass());
                method.invoke(model, newValue);
            } catch (NoSuchMethodException | SecurityException | IllegalAccessException | InvocationTargetException ex) {
                Logger.getLogger(AbstractController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
