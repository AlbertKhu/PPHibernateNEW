package jm.task.core.jdbc;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.service.UserService;
import jm.task.core.jdbc.service.UserServiceImpl;
import org.hibernate.*;
import org.hibernate.boot.spi.SessionFactoryOptions;
import org.hibernate.cfg.Configuration;
import org.hibernate.engine.spi.FilterDefinition;
import org.hibernate.metadata.ClassMetadata;
import org.hibernate.metadata.CollectionMetadata;
import org.hibernate.stat.Statistics;
//import jm.task.core.jdbc.util.Util;

import javax.naming.NamingException;
import javax.naming.Reference;
import javax.persistence.EntityGraph;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceUnitUtil;
import javax.persistence.SynchronizationType;
import javax.persistence.criteria.CriteriaBuilder;
import java.sql.*;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.Executor;

import static jm.task.core.jdbc.model.User.getName;


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