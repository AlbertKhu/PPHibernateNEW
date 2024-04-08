package jm.task.core.jdbc;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.service.UserService;
import jm.task.core.jdbc.service.UserServiceImpl;

public class Main {

    private static final UserService userService = new UserServiceImpl();

    public static void main(String[] args) {

        userService.createUsersTable();

        User user = new User("Mikhail", "Malikov", (byte) 40);
        User user2 = new User("Michael", "Sitdikov", (byte) 45);
        User user3 = new User("Marsel", "Umerov", (byte) 35);
        User user4 = new User("Maksud", "Samatov", (byte) 40);

        userService.removeUserById(2);

        userService.getAllUsers();

        userService.cleanUsersTable();


    }
}