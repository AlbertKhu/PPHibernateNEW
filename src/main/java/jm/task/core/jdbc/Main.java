package jm.task.core.jdbc;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.service.UserService;
import jm.task.core.jdbc.service.UserServiceImpl;
import jm.task.core.jdbc.util.Util;

import java.sql.*;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.Executor;

import static jm.task.core.jdbc.model.User.getName;



public class Main {

    private static final UserService userService = new UserServiceImpl();
    public static void main(String[] args) {
        userService.createUsersTable();

        userService.saveUser("Alex", "Beduinov", (byte) 30);
        userService.saveUser("Ivan", "Bashirov", (byte) 35);
        userService.saveUser("Petr", "Firsov", (byte) 25);
        userService.saveUser("Alan", "Gagloev", (byte) 40);

        userService.removeUserById(2);

        userService.getAllUsers();

        userService.cleanUsersTable();

        userService.dropUsersTable();

    }
}