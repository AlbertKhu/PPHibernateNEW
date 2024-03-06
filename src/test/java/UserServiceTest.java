//import jm.task.core.jdbc.model.User;
//import jm.task.core.jdbc.service.UserService;
//import jm.task.core.jdbc.service.UserServiceImpl;
//import org.junit.Assert;
//import org.junit.Test;
//
//import javax.persistence.Column;
//import javax.persistence.Id;
//import javax.persistence.Table;
//import java.io.IOException;
//import java.io.InputStream;
//import java.net.URISyntaxException;
//import java.nio.file.Files;
//import java.nio.file.Paths;
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.SQLException;
//import java.util.Properties;
//
//import java.util.List;
//
//public class UserServiceTest {
//    private final UserService userService = new UserServiceImpl();
//
//    private final String testName = "Ivan";
//    private final String testLastName = "Ivanov";
//    private final byte testAge = 5;
//}
//
//public interface UserDao {
//    void createUsersTable();
//    void dropUsersTable();
//    void saveUser(String name, String lastName, byte age);
//    void removeUserById(long id);
//    List<User> getAllUsers();
//    void cleanUsersTable();
//}
//
//public interface UserService {
//    void createUsersTable();
//    void dropUsersTable();
//    void saveUser(String name, String lastName, byte age);
//    void removeUserById(long id);
//    List<User> getAllUsers();
//    void cleanUsersTable();
//}
//
//@Table
//public class User {
//    @Id
//    private Long id;
//    @Column
//    private String name;
//    @Column
//    private String lastName;
//    @Column
//    private Byte age;
//    public User() {
//    }
//    public User(String name, String lastName, Byte age) {
//        this.name = name;
//        this.lastName = lastName;
//        this.age = age;
//    }
//    public Long getId() {
//        return id;
//    }
//    public void setId(Long id) {
//        this.id = id;
//    }
//    public String getName() {
//        return name;
//    }
//    public void setName(String name) {
//        this.name = name;
//    }
//    public String getLastName() {
//        return lastName;
//    }
//    public void setLastName(String lastName) {
//        this.lastName = lastName;
//    }
//    public Byte getAge() {
//        return age;
//    }
//    public void setAge(Byte age) {
//        this.age = age;
//    }
//    @Override
//    public String toString() {
//        return String.format("User {id = '%s', name = '%s', lastName = '%s', age = '%d'}", getId(), getName(), getLastName(), getAge());
//    }
//}
//public class Util {
//    private static Connection conn = null;
//    private static Util instance = null;
//
//    private Util() {
//        try {
//            if (null == conn || conn.isClosed()) {
//                Properties props = getProps();
//                conn = DriverManager
//                        .getConnection(props.getProperty("db.url"), props.getProperty("db.username"), props.getProperty("db.password"));
//            }
//        } catch (SQLException | IOException e) {
//            e.printStackTrace();
//        }
//    }
//    public static Util getInstance() {
//        if (null == instance) {
//            instance = new Util();
//        }
//        return instance;
//    }
//    public Connection getConnection() {
//        return conn;
//    }
//
//    private static Properties getProps() throws IOException {
//        Properties props = new Properties();
//        try (InputStream in = Files.newInputStream(Paths.get(Util.class.getResource("/database.properties").toURI()))) {
//            props.load(in);
//            return props;
//        } catch (IOException | URISyntaxException e) {
//            throw new IOException("Database config file not found", e);
//        }
//    }
//}
//
//public static void main(String[] args) {
//
//    @Test
//    public void dropUsersTable () {
//        try {
//            userService.dropUsersTable();
//            userService.dropUsersTable();
//        } catch (Exception e) {
//            Assert.fail("При тестировании удаления таблицы произошло исключение\n" + e);
//        }
//    }
//
//    @Test
//    public void createUsersTable () {
//        try {
//            userService.dropUsersTable();
//            userService.createUsersTable();
//        } catch (Exception e) {
//            Assert.fail("При тестировании создания таблицы пользователей произошло исключение\n" + e.getMessage());
//        }
//    }
//
//    @Test
//    public void saveUser () {
//        try {
//            userService.dropUsersTable();
//            userService.createUsersTable();
//            userService.saveUser(testName, testLastName, testAge);
//
//            User user = userService.getAllUsers().get(0);
//
//            if (!testName.equals(user.getName())
//                    || !testLastName.equals(user.getLastName())
//                    || testAge != user.getAge()
//            ) {
//                Assert.fail("User был некорректно добавлен в базу данных");
//            }
//
//        } catch (Exception e) {
//            Assert.fail("Во время тестирования сохранения пользователя произошло исключение\n" + e);
//        }
//    }
//
//    @Test
//    public void removeUserById () {
//        try {
//            userService.dropUsersTable();
//            userService.createUsersTable();
//            userService.saveUser(testName, testLastName, testAge);
//            userService.removeUserById(1L);
//        } catch (Exception e) {
//            Assert.fail("При тестировании удаления пользователя по id произошло исключение\n" + e);
//        }
//    }
//
//    @Test
//    public void getAllUsers () {
//        try {
//            userService.dropUsersTable();
//            userService.createUsersTable();
//            userService.saveUser(testName, testLastName, testAge);
//            List<User> userList = userService.getAllUsers();
//
//            if (userList.size() != 1) {
//                Assert.fail("Проверьте корректность работы метода сохранения пользователя/удаления или создания таблицы");
//            }
//        } catch (Exception e) {
//            Assert.fail("При попытке достать всех пользователей из базы данных произошло исключение\n" + e);
//        }
//    }
//
//    @Test
//    public void cleanUsersTable () {
//        try {
//            userService.dropUsersTable();
//            userService.createUsersTable();
//            userService.saveUser(testName, testLastName, testAge);
//            userService.cleanUsersTable();
//
//            if (userService.getAllUsers().size() != 0) {
//                Assert.fail("Метод очищения таблицы пользователей реализован не корректно");
//            }
//        } catch (Exception e) {
//            Assert.fail("При тестировании очистки таблицы пользователей произошло исключение\n" + e);
//        }
//    }
//}