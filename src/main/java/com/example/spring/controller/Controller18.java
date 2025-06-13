package com.example.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("main18")
public class Controller18 {
    @GetMapping("sub1")
    public String sub1(Model model) throws Exception {
        String sql = """
                SELECT *
                FROM table53
                """;
        String url = "jdbc:mysql://localhost:3306/mydatabase";
        String username = "root";
        String password = "1234";
        Connection connection = DriverManager.getConnection(url, username, password);
        PreparedStatement statement = connection.prepareStatement(sql);
        ResultSet resultSet = statement.executeQuery();
        List<Map<String, Object>> list = new ArrayList<>();
        while (resultSet.next()) {
            Map<String, Object> map = new HashMap<>();
            map.put("user", resultSet.getString("user"));
            map.put("money", resultSet.getInt("money"));
            list.add(map);
        }
        model.addAttribute("list", list);

        return "main18/sub1";
    }

    @PostMapping("sub2")
    public String sub2(Model model) throws Exception {
        String sql = """
                UPDATE table53
                SET money = money -500
                WHERE user = 'a'
                """;
        String sql2 = """
                UPDATE table53
                SET money = money + 500
                WHERE user = 'b'
                """;
        String url = "jdbc:mysql://localhost:3306/mydatabase";
        String username = "root";
        String password = "1234";
        Connection connection = DriverManager.getConnection(url, username, password);
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.executeUpdate();
        PreparedStatement statement2 = connection.prepareStatement(sql2);
        statement2.executeUpdate();

        return "redirect:/main18/sub1";
    }

    @PostMapping("sub3")
    public String fails1(Model model) throws Exception {
        String sql = """
                UPDATE table53
                SET money = money -500
                WHERE user = 'a'
                """;
        String sql2 = """
                UPDATE table53
                SET money = money + 500
                WHERE user = 'b'
                """;
        String url = "jdbc:mysql://localhost:3306/mydatabase";
        String username = "root";
        String password = "1234";
        Connection connection = DriverManager.getConnection(url, username, password);
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.executeUpdate();

        if (true) {
            throw new Exception("네트워크 연결 끊어짐");
        }

        PreparedStatement statement2 = connection.prepareStatement(sql2);
        statement2.executeUpdate();

        return "redirect:/main18/sub1";
    }

    @PostMapping("sub4")
    public String sucss2(Model model) throws Exception {
        String sql = """
                UPDATE table53
                SET money = money -500
                WHERE user = 'a'
                """;
        String sql2 = """
                UPDATE table53
                SET money = money + 500
                WHERE user = 'b'
                """;
        String url = "jdbc:mysql://localhost:3306/mydatabase";
        String username = "root";
        String password = "1234";
        Connection connection = DriverManager.getConnection(url, username, password);
        connection.setAutoCommit(false);
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.executeUpdate();

        PreparedStatement statement2 = connection.prepareStatement(sql2);
        statement2.executeUpdate();

        connection.commit();

        return "redirect:/main18/sub1";
    }

    @PostMapping("sub5")
    public String fail2(Model model) {
        String sql = """
                UPDATE table53
                SET money = money -500
                WHERE user = 'a'
                """;
        String sql2 = """
                UPDATE table53
                SET money = money + 500
                WHERE user = 'b'
                """;
        String url = "jdbc:mysql://localhost:3306/mydatabase";
        String username = "root";
        String password = "1234";
        try {
            Connection connection = DriverManager.getConnection(url, username, password);
            try (connection) {
                connection.setAutoCommit(false);
                try {
                    PreparedStatement statement = connection.prepareStatement(sql);
                    PreparedStatement statement2 = connection.prepareStatement(sql2);
                    try (statement; statement2) {
                        statement.executeUpdate();
                        if (true) {
                            throw new Exception("네트워크 오류");
                        }
                        statement2.executeUpdate();
                    }
                    connection.commit();
                } catch (Exception e) {
                    connection.rollback();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return "redirect:/main18/sub1";
    }

    @GetMapping("sub6")
    public String sub6(Model model) throws Exception {
        String sql = """
                SELECT *
                FROM table53
                """;
        String url = "jdbc:mysql://localhost:3306/mydatabase";
        String username = "root";
        String password = "1234";
        Connection connection = DriverManager.getConnection(url, username, password);
        PreparedStatement statement = connection.prepareStatement(sql);
        ResultSet resultSet = statement.executeQuery();
        List<Map<String, Object>> list = new ArrayList<>();
        while (resultSet.next()) {
            Map<String, Object> map = new HashMap<>();
            map.put("user", resultSet.getString("user"));
            map.put("money", resultSet.getInt("money"));
            list.add(map);
        }
        model.addAttribute("list", list);

        return "main18/sub6";
    }

    @PostMapping("sub7")
    public String sub7(Model model, RedirectAttributes rttr) {
        // b -> a(500원 송금)
        // 50% 확률로 성공 or 실패
        String sql = """
                UPDATE table53
                SET money = money -500
                WHERE user = 'b'
                """;
        String sql2 = """
                UPDATE table53
                SET money = money + 500
                WHERE user = 'a'
                """;
        String url = "jdbc:mysql://localhost:3306/mydatabase";
        String username = "root";
        String password = "1234";
        try {
            Connection connection = DriverManager.getConnection(url, username, password);
            connection.setAutoCommit(false);
            try (connection) {
                PreparedStatement statement1 = connection.prepareStatement(sql);
                PreparedStatement statement2 = connection.prepareStatement(sql2);
                try (statement1; statement2) {
                    try {
                        // b의 돈 500원 차감
                        statement1.executeUpdate();

                        double random = Math.random();
                        if (random < 0.5) {
                            throw new Exception("네트워크 오류");
                        }
                        // a의 돈 500원 차감
                        statement2.executeUpdate();

                        connection.commit();
                        rttr.addFlashAttribute("message", "(b -> a) 500원 송금 성공");
                    } catch (Exception e) {
                        connection.rollback();
                        rttr.addFlashAttribute("message", "(b -> a) 500원 송금 실패");
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return "redirect:/main18/sub6";
    }
}
