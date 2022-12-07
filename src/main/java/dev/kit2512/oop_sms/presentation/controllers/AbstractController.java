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
        System.out.println(this.getClass() + " is adding model" + model.getClass());
        model.addPropertyChangeListener(this);
        registeredModels.add(model);
    }

    public void removeModel(AbstractModel model) {
        System.out.println(this.getClass() + " is removing model" + model.getClass());

        model.removePropertyChangeListener(this);
        registeredModels.remove(model);
    }

    public void addView(AbstractView view) {

        System.out.println(this.getClass() + " is adding view" + view.getClass());

        registeredViews.add(view);
    }

    public void removeView(AbstractView view) {
        System.out.println(this.getClass() + " is removing view " + view.getClass());
        registeredViews.remove(view);
    }

    @Override
    public void propertyChange(PropertyChangeEvent event) {
        for (AbstractView view : registeredViews) {
            view.modelPropertyChange(event);
        }
    }

    protected void setModelProperty(String propertyName, Object newValue) {
        System.out.println("Calling " + propertyName + " : " + newValue);
        for (AbstractModel model : registeredModels) {
            final String methodName = "set" + propertyName;
            try {
                Method method = model.getClass()
                        .getMethod(methodName, newValue.getClass());
                method.invoke(model, newValue);
            } catch (NoSuchMethodException | SecurityException | IllegalAccessException | InvocationTargetException ex) {
                System.out.println("Error: " + ex.getMessage());
            }
        }
    }
}
