package com.example.spring.controller;

import lombok.Data;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.sql.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;

@Controller
@RequestMapping("main17")
public class Controller17 {
    @GetMapping("sub1")
    public String sub1() throws Exception {
        String sql = """
                INSERT INTO table12
                    (col1, col2, col3, col4, col5, col6, col7)
                VALUES (?, ?, ?, ?, ?, ?, ?);
                
                """;
        String url = "jdbc:mysql://localhost:3306/mydatabase"; // schema 이름이 나중에 들어감.
        String username = "root";
        String password = "1234";
        Connection connection = DriverManager.getConnection(url, username, password);
        PreparedStatement statement = connection.prepareStatement(sql);

        statement.setString(1, "한글");
        statement.setString(2, "123456");
        statement.setString(3, "456789");
        statement.setString(4, "789123");
        statement.setString(5, "1998-10-11");
        statement.setString(6, "15:35:27");
        statement.setString(7, "2009-01-31 12:18:35");
        statement.executeUpdate();

        return null;
    }

    @GetMapping("sub2")
    public String sub2() throws Exception {
        String sql = """
                INSERT INTO table12
                    (col1, col2, col3, col4, col5, col6, col7)
                VALUES (?, ?, ?, ?, ?, ?, ?);
                """;
        String url = "jdbc:mysql://localhost:3306/mydatabase"; // schema 이름이 나중에 들어감.
        String username = "root";
        String password = "1234";
        Connection connection = DriverManager.getConnection(url, username, password);
        PreparedStatement statement = connection.prepareStatement(sql);

        statement.setString(1, "한글");
        statement.setInt(2, 1234567);
        statement.setLong(3, 1234789);
        statement.setDouble(4, 12349.14);
        statement.setDate(5, Date.valueOf("1998-10-11"));
        statement.setTime(6, Time.valueOf("16:42:18"));
        statement.setTimestamp(7, Timestamp.valueOf("2009-01-31 12:18:35"));
        statement.executeUpdate();

        return null;
    }

    @GetMapping("sub3")
    public String sub3() throws Exception {
        String sql = """
                SELECT *
                FROM table12
                LIMIT 1
                """;
        String url = "jdbc:mysql://localhost:3306/mydatabase";
        String username = "root";
        String password = "1234";
        Connection connection = DriverManager.getConnection(url, username, password);
        PreparedStatement statement = connection.prepareStatement(sql);
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()) {
            System.out.println(resultSet.getString("col1")); // VARCHAR
            System.out.println(resultSet.getInt("col2")); // INT
            System.out.println(resultSet.getLong("col3")); // BIGINT
            System.out.println(resultSet.getDouble("col4")); // DEC
            System.out.println(resultSet.getDate("col5")); // DATE
            System.out.println(resultSet.getTime("col6")); // TIME
            System.out.println(resultSet.getTimestamp("col7")); // DATETIME
        }
        return null;
    }

    @GetMapping("sub4")
    public String sub4() throws Exception {
        String sql = """
                SELECT *
                FROM table12
                LIMIT 1
                """;
        String url = "jdbc:mysql://localhost:3306/mydatabase";
        String username = "root";
        String password = "1234";
        Connection connection = DriverManager.getConnection(url, username, password);
        PreparedStatement statement = connection.prepareStatement(sql);
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()) {
            System.out.println(resultSet.getString("col1")); // VARCHAR
            System.out.println(resultSet.getInt("col2")); // INT
            System.out.println(resultSet.getLong("col3")); // BIGINT
            System.out.println(resultSet.getDouble("col4")); // DEC
            System.out.println(resultSet.getDate("col5")); // DATE
            System.out.println(resultSet.getTime("col6")); // TIME
            System.out.println(resultSet.getTimestamp("col7")); // DATETIME
            System.out.println();
        }
        return null;
    }

    @Data
    static class Dto5 {
        private String col1; // VARCHAR
        private Integer col2; // INT
        private Long col3; // BIGINT
        private Double col4; // DEC
        private LocalDate col5; // DATE (업데이트 되서 LocalDate로 받기)
        private LocalTime col6; //TIME 마찬가지로 업데이트 되서 LocalTime
        private LocalDateTime col7;
    }

    @GetMapping("sub5")
    public String sub5(Model model) throws Exception {
        String sql = """
                SELECT *
                FROM table12
                LIMIT 1
                """;
        String url = "jdbc:mysql://localhost:3306/mydatabase";
        String username = "root";
        String password = "1234";
        Connection connection = DriverManager.getConnection(url, username, password);
        PreparedStatement statement = connection.prepareStatement(sql);
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()) {
            Dto5 dto5 = new Dto5();
            dto5.setCol1(resultSet.getString("col1")); // VARCHAR
            dto5.setCol2(resultSet.getInt("col2")); // INT
            dto5.setCol3(resultSet.getLong("col3")); // BIGINT
            dto5.setCol4(resultSet.getDouble("col4")); // DEC
            dto5.setCol5(resultSet.getDate("col5").toLocalDate()); // DATE
            dto5.setCol6(resultSet.getTime("col6").toLocalTime()); // TIME
            dto5.setCol7(resultSet.getTimestamp("col7").toLocalDateTime()); // DATETIME
            model.addAttribute("data", dto5);
        }
        return "main17/sub5";
    }

    @GetMapping("sub6")
    public String sub6(Model model) throws Exception {
        return "main17/sub6";
    }

    @PostMapping("sub6")
    public String process6(Dto5 dto5) throws Exception {
//        System.out.println("dto5 = " + dto5);
        String sql = """
                INSERT INTO table12
                    (col1, col2, col3, col4, col5, col6, col7)
                VALUES (?, ?, ?, ?, ?, ?, ?);
                """;
        String url = "jdbc:mysql://localhost:3306/mydatabase";
        String username = "root";
        String password = "1234";
        Connection connection = DriverManager.getConnection(url, username, password);
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, dto5.getCol1());
        statement.setInt(2, dto5.getCol2());
        statement.setLong(3, dto5.getCol3());
        statement.setDouble(4, dto5.getCol4());
        statement.setDate(5, Date.valueOf(dto5.getCol5()));
        statement.setTime(6, Time.valueOf(dto5.getCol6()));
        statement.setTimestamp(7, Timestamp.valueOf(dto5.getCol7()));
        statement.executeUpdate();

        return "main17/sub6";
    }

    // 연습
    // name(텍스트), birth_date(날짜), score(소숫점2까지), born_at(날짜시간) table13만들기
    // html *1
    // request handler method *2 (get, post)
    // get /main17/sub7
    // post /main17/sub7

    @Data
    static class Dto6 {
        private String name;
        private LocalDate birth_date;
        private Double score;
        private LocalDateTime born_at;
    }

    @GetMapping("sub7")
    public String sub7(Model model) throws Exception {
        String sql = """
                SELECT *
                FROM table13
                """;
        String url = "jdbc:mysql://localhost:3306/mydatabase";
        String username = "root";
        String password = "1234";
        Connection connection = DriverManager.getConnection(url, username, password);
        PreparedStatement statement = connection.prepareStatement(sql);
        ResultSet resultSet = statement.executeQuery();
        var list = new ArrayList<Dto6>();
        while (resultSet.next()) {
            Dto6 dto6 = new Dto6();
            dto6.setName(resultSet.getString("name"));
            dto6.setBirth_date(resultSet.getDate("birth_date").toLocalDate());
            dto6.setScore(resultSet.getDouble("score"));
            dto6.setBorn_at(resultSet.getTimestamp("born_at").toLocalDateTime());
            list.add(dto6);
        }
        model.addAttribute("list", list);
        return "main17/sub7";
    }

    @PostMapping("sub7")
    public String process7(Dto6 dto6) throws Exception {
//        System.out.println("dto6 = " + dto6);
        String sql = """
                INSERT INTO table13
                    (name, birth_date, score, born_at)
                VALUES (?, ?, ?, ?);
                """;
        String url = "jdbc:mysql://localhost:3306/mydatabase";
        String username = "root";
        String password = "1234";
        Connection connection = DriverManager.getConnection(url, username, password);
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, dto6.getName());
        statement.setDate(2, Date.valueOf(dto6.getBirth_date()));
        statement.setDouble(3, dto6.getScore());
        statement.setTimestamp(4, Timestamp.valueOf(dto6.getBorn_at()));
        statement.executeUpdate();

        return "redirect:/main17/sub7";
    }
}
