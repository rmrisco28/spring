package com.example.spring.controller;

import com.example.spring.dto.CustomerDto;
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
    public String sub2(CustomerDto customerDto, RedirectAttributes rttr) throws Exception {
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

}
