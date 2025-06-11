package com.example.spring.controller;

import com.example.spring.dto.CustomerDto;
import lombok.Data;
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
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("preparation16")
public class Controllerx16 {

    @GetMapping("sub1")
    public String sub1(Integer id, Model model) throws Exception {
        if (id != null) {

            String sql = """
                    SELECT *
                    FROM Customers
                    WHERE CustomerID = ?
                    """;
            String url = "jdbc:mysql://localhost:3306/w3schools";
            String username = "root";
            String password = "1234";
            Connection connection = DriverManager.getConnection(url, username, password);
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                CustomerDto customerDto = new CustomerDto();
                customerDto.setId(resultSet.getInt("CustomerID"));
                customerDto.setName(resultSet.getString("CustomerName"));
                customerDto.setContactName(resultSet.getString("contactName"));
                customerDto.setAddress(resultSet.getString("address"));
                customerDto.setCity(resultSet.getString("city"));
                customerDto.setPostalCode(resultSet.getString("postalCode"));
                customerDto.setCountry(resultSet.getString("country"));

                model.addAttribute("customer", customerDto);
            }
        }

        return "preparation16/sub1";
    }

    @PostMapping("sub1")
    public String post1(CustomerDto customerDto, RedirectAttributes rttr) throws Exception {
        String sql = """
                UPDATE Customers
                SET CustomerName = ?,
                    ContactName = ?,
                    Address = ?,
                    City = ?,
                    PostalCode = ?,
                    Country = ?
                WHERE CustomerID = ?;
                """;
        String url = "jdbc:mysql://localhost:3306/w3schools";
        String username = "root";
        String password = "1234";
        Connection connection = DriverManager.getConnection(url, username, password);
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, customerDto.getName());
        statement.setString(2, customerDto.getContactName());
        statement.setString(3, customerDto.getAddress());
        statement.setString(4, customerDto.getCity());
        statement.setString(5, customerDto.getPostalCode());
        statement.setString(6, customerDto.getCountry());
        statement.setInt(7, customerDto.getId());

        statement.executeUpdate();

        rttr.addAttribute("id", customerDto.getId());

        return "redirect:/preparation16/sub1";
    }

    @Data
    static class Dto6 {
        private String name;
        private LocalDate birth_date;
        private Double score;
        private LocalDateTime born_at;
    }

    @GetMapping("sub2")
    public String sub2(Model model) throws Exception {
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
        if (resultSet.next()) {
            Dto6 dto6 = new Dto6();
            dto6.setName(resultSet.getString("name"));
            dto6.setBirth_date(resultSet.getDate("birth_date").toLocalDate());
            dto6.setScore(resultSet.getDouble("score"));
            dto6.setBorn_at(resultSet.getTimestamp("born_at").toLocalDateTime());
            list.add(dto6);
        }
        model.addAttribute("list", list);

        return "preparation16/sub2";

    }

}
