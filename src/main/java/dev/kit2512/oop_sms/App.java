/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */
package dev.kit2512.oop_sms;

import com.j256.ormlite.jdbc.JdbcConnectionSource;
import dev.kit2512.oop_sms.config.AppConstants;
import dev.kit2512.oop_sms.config.injectors.AppGraph;
import dev.kit2512.oop_sms.config.injectors.DaggerAppGraph;
import dev.kit2512.oop_sms.config.injectors.UserDaoModule;
import dev.kit2512.oop_sms.data.database.UserDaoImpl;
import dev.kit2512.oop_sms.presentation.controllers.LoginController;
import dev.kit2512.oop_sms.presentation.models.AbstractModel;
import dev.kit2512.oop_sms.presentation.models.LoginModel;
import dev.kit2512.oop_sms.presentation.views.LoginView;


import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author macpro13
 */
public class App {

    public static void main(String[] args) {
        new App().setUp();
    }
    
    private void setUp() {
        UserDaoImpl userDaoImpl;
        
        try {
            JdbcConnectionSource connectionSource = new JdbcConnectionSource(AppConstants.DatabasePath.usersDatabase);
            userDaoImpl = new UserDaoImpl(connectionSource);
            AppGraph appGraph = DaggerAppGraph.builder().userDaoModule(new UserDaoModule(userDaoImpl)).build();
            LoginController loginController = appGraph.getLoginController();
            LoginView loginView = appGraph.getLoginView();
            loginController.addView(loginView);
            loginView.setVisible(true);
        } catch (SQLException ex) {
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
