package com.ruoyi.tmp;

import java.sql.*;
import java.util.Arrays;

/**
 * @Author: Jia Yuning
 * @Description:
 * @Date: 2024/04/22 20:54:03
 * @Version: 1.0.0
 */
public class TmpTest {
    public static void main(String[] args) {
        Long[] ll = {1L, 2L, 3L};
        System.out.println(Arrays.toString(ll));
    }

    public static void tryDatabase() {
        String driver = "com.mysql.cj.jdbc.Driver";
//        String url = "jdbc:mysql://localhost:3306/ry-vue";
        String url = "jdbc:mysql://localhost:3306/ry-vue?useUnicode=true&characterEncoding=utf8&zeroDateTimeBehavior=convertToNull&useSSL=false&serverTimezone=GMT%2B8";
        String username = "root";
        String password = "123";

        try {
            // Load and register the driver
            Class.forName(driver);

            try (Connection connection = DriverManager.getConnection(url, username, password)) {
                System.out.println("Database connected successfully.");

                // Perform SQL operations here...
                PreparedStatement preparedStatement = connection.prepareStatement("select 111 from dual;");
                ResultSet resultSet = preparedStatement.executeQuery();
                while (resultSet.next()) {
                    int anInt = resultSet.getInt(1);
                    System.out.println(anInt);
                }

            } catch (SQLException ex) {
                System.out.println("Failed to connect to the database: " + ex.getMessage());
            }
        } catch (ClassNotFoundException e) {
            System.out.println("Could not find the database driver: " + e.getMessage());
        }
    }
}
