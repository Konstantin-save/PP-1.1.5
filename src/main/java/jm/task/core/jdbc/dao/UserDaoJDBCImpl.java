//package jm.task.core.jdbc.dao;
//
//import jm.task.core.jdbc.model.User;
//import jm.task.core.jdbc.util.Util;
//import org.hibernate.StaleStateException;
//
//import java.sql.*;
//import java.util.ArrayList;
//import java.util.List;
//
//import static javax.swing.UIManager.getString;
//
/////////////////////Функция классов из пакета dao – непосредственная работа с базой данных/////////////////////////
//
//public class UserDaoJDBCImpl implements UserDao {
//    private static final ; //Connection с помощью статического метода класса Util, который находится в пакете util. Задача классов из этого пакета – непосредственно конфигурировать соединение с базой
//
//    public UserDaoJDBCImpl() {
//    }
//
//    public void createUsersTable() {      //создание табл
//        try (Connection connection = Util.getConnection(); Statement statement = connection.createStatement()) {
//            statement.execute("CREATE TABLE IF NOT EXISTS users " +
//                    "(id BIGINT PRIMARY KEY AUTO_INCREMENT NOT NULL, name VARCHAR(255), last_name VARCHAR(255), age TINYINT)");
//        } catch (SQLException e) {
//            System.err.println("An SQLException was thrown: " + e.getMessage());
//        }
//    }
//
//    public void dropUsersTable() {                                    //Удаление таблицы User(ов)
//        try (Connection connection = Util.getConnection(); Statement statement = connection.createStatement()) {
//            statement.execute("DROP TABLE IF EXISTS users");
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
//
//    public void saveUser(String name, String lastName, byte age) {    //Сохранение пользователя
//        try (Connection connection = Util.getConnection(); PreparedStatement prepareStatement = connection.prepareStatement("INSERT INTO users(name, last_name, age) VALUES (?, ?, ?)")) {
//            prepareStatement.setString(1, name);
//            prepareStatement.setString(2, lastName);
//            prepareStatement.setInt(3, age);
//            prepareStatement.executeUpdate();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
//
//    public void removeUserById(long id) {    //Удаляет user из таблицы по ID
//        try (Connection connection = Util.getConnection(); PreparedStatement prepareStatement = connection.prepareStatement("DELETE FROM users WHERE id = ?")) {
//            prepareStatement.setLong(1, id);
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
//
//    public List<User> getAllUsers() {
//                                                             //Получает список всех user
//        List<User> userList = new ArrayList<>();
//        try (Connection connection = Util.getConnection(); Statement statement = connection.createStatement()) {
//
//            ResultSet resultSet = statement.executeQuery("select * from users");
//            while (resultSet.next()) {
//                User user = new User();
//                user.setId(resultSet.getLong("id"));
//                user.setName(resultSet.getString("name"));
//                user.setLastName(resultSet.getString("last_name"));
//                user.setAge(resultSet.getByte("age"));
//                userList.add(user);
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return userList;
//    }
//
//    public void cleanUsersTable() {                         //очистка содержания табл
//        try (Connection connection = Util.getConnection(); PreparedStatement prepareStatement = connection.prepareStatement( "DELETE FROM users")) {
//            prepareStatement.executeUpdate();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
//}
//
