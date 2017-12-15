/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 *
 * @author maxkirchgesner
 */

// Code from Discussion Week 8 JDBC example: DatabaseConfig
public final class DatabaseConfig {

    static Properties properties;

    static {

        properties = new Properties();

        String resourceName = "db.config.properties";

        InputStream inputStream = DatabaseConfig.class.getClassLoader().getResourceAsStream("../" + resourceName);

        try {
            properties.load(inputStream);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }

    public static String getDatabaseName() {
        return properties.getProperty("jdbc.db.databasename");
    }

    public static String getUser() {
        return properties.getProperty("jdbc.db.user");
    }

    public static String getPassword() {
        return properties.getProperty("jdbc.db.password");
    }

    public static String getHost() {
        return properties.getProperty("jdbc.db.host");
    }


}

