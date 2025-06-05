package com.example.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("preparation12")
public class Controllerx12 {

    @GetMapping("hello")
    public String hello(Model model, @RequestParam("name") String name) {
        String a = name + "님 안녕하세요";
        model.addAttribute("message", a);


        return "preparation12/hello";
    }

    @RequestMapping("start")
    public String start(Model model) {
        model.addAttribute("message", "스프링 시작");

        return "preparation12/start";
    }

    @RequestMapping("greet")
    public String great(String name, Model model) {
        String message = name + "님, 안녕하세요!";
        model.addAttribute("message", message);
        return "preparation12/greet";
    }

    @RequestMapping("user")
    public String user(Model model, String name, Integer age) {
        String message = name + "님은" + age + "살 입니다.";
        model.addAttribute("message", message);
        System.out.println("message = " + message);
        return "preparation12/user";
    }

    @GetMapping("sub1")
    public String sub1(Model model) throws Exception {
        String sql = """
                SELECT *
                FROM Products
                """;
        String url = "jdbc:mysql://localhost:3306/w3schools";
        String username = "root";
        String password = "1234";
        Connection connection = DriverManager.getConnection(url, username, password);

        PreparedStatement statement = connection.prepareStatement(sql);
        ResultSet resultSet = statement.executeQuery();

        String product = "";

        if (resultSet.next()) {
            product = resultSet.getString("productName");
        }
        model.addAttribute("product", product);
        return "preparation12/sub1";
    }

    @GetMapping("sub2")
    public String sub2(Model model) throws Exception {
        String sql = """
                SELECT ProductName
                FROM Products
                """;
        String url = "jdbc:mysql://localhost:3306/w3schools";
        String username = "root";
        String password = "1234";
        Connection connection = DriverManager.getConnection(url, username, password);

        PreparedStatement statement = connection.prepareStatement(sql);
        ResultSet resultSet = statement.executeQuery();

        var list = new ArrayList<String>();

        while (resultSet.next()) {
            list.add(resultSet.getString("ProductName"));

        }
        model.addAttribute("products", list);
        return "preparation12/sub2";
    }

    @GetMapping("sub3")
    public String sub3(Model model) throws Exception {
        String sql = """
                SELECT CustomerName, Country, City
                FROM Customers
                WHERE Country IN ('uk', 'usa')
                ORDER BY Country, City
                """;
        String url = "jdbc:mysql://localhost:3306/w3schools";
        String username = "root";
        String password = "1234";
        Connection connection = DriverManager.getConnection(url, username, password);
        PreparedStatement statement = connection.prepareStatement(sql);
        ResultSet resultSet = statement.executeQuery();
        var list = new ArrayList<Map<String, String>>();
        while (resultSet.next()) {
            var map = new HashMap<String, String>();
            map.put("name", resultSet.getString("CustomerName"));
            map.put("country", resultSet.getString("Country"));
            map.put("city", resultSet.getString("City"));

            list.add(map);
        }
        model.addAttribute("customers", list);
        return "preparation12/sub3";
    }
}
