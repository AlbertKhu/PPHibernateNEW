package jm.task.core.jdbc;

import jm.task.core.jdbc.service.UserService;
import jm.task.core.jdbc.service.UserServiceImpl;
import jm.task.core.jdbc.util.Util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {


    public static void main(String[] args) throws SQLException {
        UserService userService = new UserServiceImpl();
        userService.saveUser("Alex", "Beduinov", (byte) 30);
        }
    }
