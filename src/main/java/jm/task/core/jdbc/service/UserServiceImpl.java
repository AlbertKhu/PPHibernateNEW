package jm.task.core.jdbc.service;

import jm.task.core.jdbc.dao.UserDao;
import jm.task.core.jdbc.dao.UserDaoJDBCImpl;
import jm.task.core.jdbc.model.User;

import java.sql.SQLException;
import java.util.List;

public class UserServiceImpl implements UserService {
    private UserDao userDao = new UserDaoJDBCImpl();
    public void createUsersTable() throws SQLException {
userDao.createUsersTable();
    }

    public void dropUsersTable() {

    }

    public void saveUser(String name, String lastName, byte age) throws SQLException {
userDao.saveUser(name, lastName, age);
    }

    public void removeUserById(long id) {

    }

    public List<User> getAllUsers() {
        return null;
    }

    public void cleanUsersTable() {

    }
}
