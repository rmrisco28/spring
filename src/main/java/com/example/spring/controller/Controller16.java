package com.example.spring.controller;

import com.example.spring.dto.CustomerDto;
import com.example.spring.dto.SupplierDto;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("main16")
public class Controller16 {

    @GetMapping("sub1")
    public String form1(Model model) throws Exception {
        // 고객 정보가 바로 보일 수 있도록
        String sql = """
                SELECT *
                FROM Customers
                ORDER BY CustomerID DESC
                """;
        String url = "jdbc:mysql://localhost:3306/w3schools";
        String username = "root";
        String password = "1234";
        Connection connection = DriverManager.getConnection(url, username, password);
        PreparedStatement statement = connection.prepareStatement(sql);
        ResultSet resultSet = statement.executeQuery();
        List<CustomerDto> customerDtoList = new ArrayList<>();
        while (resultSet.next()) {
            CustomerDto customerDto = new CustomerDto();
            customerDto.setId(resultSet.getInt("CustomerID"));
            customerDto.setName(resultSet.getString("CustomerName"));
            customerDto.setContactName(resultSet.getString("ContactName"));
            customerDto.setAddress(resultSet.getString("Address"));
            customerDto.setCity(resultSet.getString("City"));
            customerDto.setPostalCode(resultSet.getString("PostalCode"));
            customerDto.setCountry(resultSet.getString("Country"));
            customerDtoList.add(customerDto);
        }
        model.addAttribute("customerList", customerDtoList);

        return "main16/sub1";
    }

    // post 방식으로 받았기 때문에 주소창에 값이 적히지 않는다.
    @PostMapping("sub1")
    public String process(CustomerDto customer) throws Exception {
//        System.out.println(customerDto);

        String sql = """
                INSERT INTO Customers
                (CustomerName, ContactName, Address, City, PostalCode, Country)
                VALUES (?, ?, ?, ?, ?, ?)
                """;
        String url = "jdbc:mysql://localhost:3306/w3schools";
        String username = "root";
        String password = "1234";
        Connection connection = DriverManager.getConnection(url, username, password);
        PreparedStatement statement = connection.prepareStatement(sql);


        statement.setString(1, customer.getName());
        statement.setString(2, customer.getContactName());
        statement.setString(3, customer.getAddress());
        statement.setString(4, customer.getCity());
        statement.setString(5, customer.getPostalCode());
        statement.setString(6, customer.getCountry());

//        statement.executeQuery(); // select
        statement.executeUpdate(); // insert, delete, update

        return "redirect:/main16/sub1";
    }

    // 연습
    // 새 공급자 등록 로직을 작성
    // handler method*2 (get, post)
    // html *1

    @GetMapping("sub2")
    public String form2(Model model) throws Exception {
        String sql = """
                SELECT *
                FROM Suppliers
                ORDER BY SupplierID DESC
                """;
        String url = "jdbc:mysql://localhost:3306/w3schools";
        String username = "root";
        String password = "1234";
        Connection connection = DriverManager.getConnection(url, username, password);
        PreparedStatement statement = connection.prepareStatement(sql);
        ResultSet resultSet = statement.executeQuery();
        List<SupplierDto> supplierDtoList = new ArrayList<>();
        while (resultSet.next()) {
            SupplierDto supplierDto = new SupplierDto();
            supplierDto.setId(resultSet.getInt("SupplierID"));
            supplierDto.setName(resultSet.getString("SupplierName"));
            supplierDto.setContactName(resultSet.getString("ContactName"));
            supplierDto.setAddress(resultSet.getString("Address"));
            supplierDto.setPostalCode(resultSet.getString("PostalCode"));
            supplierDto.setCity(resultSet.getString("City"));
            supplierDto.setCountry(resultSet.getString("Country"));
            supplierDto.setPhone(resultSet.getString("Phone"));
            supplierDtoList.add(supplierDto);
        }
        model.addAttribute("supplierList", supplierDtoList);

        return "main16/sub2";
    }

    @PostMapping("sub2")
    public String process2(SupplierDto supplier) throws Exception {
        String sql = """
                INSERT INTO Suppliers
                (SupplierName, contactName, Address, City, PostalCode, Country, Phone)
                VALUES (?, ?, ?, ?, ?, ?, ?)
                """;
        String url = "jdbc:mysql://localhost:3306/w3schools";
        String username = "root";
        String password = "1234";
        Connection connection = DriverManager.getConnection(url, username, password);
        PreparedStatement statement = connection.prepareStatement(sql);

        statement.setString(1, supplier.getName());
        statement.setString(2, supplier.getContactName());
        statement.setString(3, supplier.getAddress());
        statement.setString(4, supplier.getCity());
        statement.setString(5, supplier.getPostalCode());
        statement.setString(6, supplier.getCountry());
        statement.setString(7, supplier.getPhone());
        statement.executeUpdate();

        return "redirect:/main16/sub2";
    }

    // 조회하고 postMapping에서 처리하는 식으로 코드 진행
    @GetMapping("sub3")
    public String form3(Integer id, // 고객 번호를 받아서 조회.
                        Model model) throws Exception {
        // id가 없을때도 실행되야하기 때문에,
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
            statement.setInt(1, id); // 첫번째 물음표에 id 값이 들어간다.
            ResultSet resultSet = statement.executeQuery(); // read할때는 executeQuery써야한다.
            // 조회한 값은 하나이기 때문에 list 안쓰고
            if (resultSet.next()) { //조회 결과가 있을때만 해당 코드 실행.
                CustomerDto customerDto = new CustomerDto();
                customerDto.setId(resultSet.getInt("CustomerID"));
                customerDto.setName(resultSet.getString("CustomerName"));
                customerDto.setContactName(resultSet.getString("ContactName"));
                customerDto.setAddress(resultSet.getString("Address"));
                customerDto.setCity(resultSet.getString("City"));
                customerDto.setPostalCode(resultSet.getString("PostalCode"));
                customerDto.setCountry(resultSet.getString("Country"));
                model.addAttribute("customer", customerDto);
            }
        }
        return "main16/sub3";
    }

    // 처리하는 방식
    @PostMapping("sub3")
    public String process3(Integer id, RedirectAttributes rttr) throws Exception {

        String sql = """
                DELETE 
                FROM Customers
                WHERE CustomerID = ?
                """;
        String url = "jdbc:mysql://localhost:3306/w3schools";
        String username = "root";
        String password = "1234";
        Connection connection = DriverManager.getConnection(url, username, password);
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, id);
        statement.executeUpdate(); // delete, update, insert

        // 사용한 이유는 삭제 후 새로고침할 경우 return의 id 값이 날아가기 때문에,
        // 내가 삭제 후 새로운 페이지로 이동하였다는것을 알릴때 사용한다.

        rttr.addAttribute("id", id);


        // 여러 delete요청을 받지 않기 위해  redirect 하면 됨
        return "redirect:/main16/sub3";
    }

    // 연습
    // 공급자 조회 후 삭제 로직 완성
    // request handler method *2, html1
    @GetMapping("sub4")
    public String sub4(Integer id, Model model) throws Exception {
        if (id != null) {
            String sql = """
                    SELECT *
                    FROM Suppliers
                    WHERE supplierID = ?
                    """;
            String url = "jdbc:mysql://localhost:3306/w3schools";
            String username = "root";
            String password = "1234";
            Connection connection = DriverManager.getConnection(url, username, password);
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                SupplierDto supplierDto = new SupplierDto();
                supplierDto.setId(resultSet.getInt("SupplierID"));
                supplierDto.setName(resultSet.getString("SupplierName"));
                supplierDto.setContactName(resultSet.getString("ContactName"));
                supplierDto.setAddress(resultSet.getString("Address"));
                supplierDto.setCity(resultSet.getString("City"));
                supplierDto.setPostalCode(resultSet.getString("PostalCode"));
                supplierDto.setCountry(resultSet.getString("Country"));
                supplierDto.setPhone(resultSet.getString("Phone"));
                model.addAttribute("supplier", supplierDto);
            }
        }
        return "main16/sub4";
    }

    @PostMapping("sub4")
    public String process4(Integer id, RedirectAttributes rttr) throws Exception {
        String sql = """
                DELETE
                FROM Suppliers
                WHERE SupplierID = ?
                """;
        String url = "jdbc:mysql://localhost:3306/w3schools";
        String username = "root";
        String password = "1234";
        Connection connection = DriverManager.getConnection(url, username, password);
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, id);
        statement.executeUpdate(); // delete, update, insert

        rttr.addAttribute("id", id);

        return "redirect:/main16/sub4";
    }

    // update
    // get
    @GetMapping("sub5")
    public String sub5(Integer id, Model model) throws Exception {
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
                customerDto.setContactName(resultSet.getString("ContactName"));
                customerDto.setAddress(resultSet.getString("Address"));
                customerDto.setPostalCode(resultSet.getString("PostalCode"));
                customerDto.setCity(resultSet.getString("City"));
                customerDto.setCountry(resultSet.getString("Country"));


                model.addAttribute("customer", customerDto);
            }
        }


        return "main16/sub5";
    }


    // post
    @PostMapping("sub5")
    public String process5(CustomerDto customer, RedirectAttributes rttr) throws Exception {
//        System.out.println("customer = " + customer);
        String sql = """
                UPDATE Customers
                SET CustomerName = ?,
                ContactName = ?,
                Address = ?,
                PostalCode = ?,
                City = ?,
                Country = ?
                WHERE CustomerID = ?
                """;
        String url = "jdbc:mysql://localhost:3306/w3schools";
        String username = "root";
        String password = "1234";
        Connection connection = DriverManager.getConnection(url, username, password);
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, customer.getName());
        statement.setString(2, customer.getContactName());
        statement.setString(3, customer.getAddress());
        statement.setString(4, customer.getPostalCode());
        statement.setString(5, customer.getCity());
        statement.setString(6, customer.getCountry());
        statement.setInt(7, customer.getId());

        statement.executeUpdate(); //update

        rttr.addAttribute("id", customer.getId());

        return "redirect:/main16/sub5";
    }

    // 연습
    // 공급자 정보 조회/ 수정
    // request handler method *2 html 1
    @GetMapping("sub6")
    public String sub6(Integer id, Model model) throws Exception {
        if (id != null) {
            String sql = """
                    SELECT *
                    FROM Suppliers
                    WHERE SupplierID = ?
                    """;
            String url = "jdbc:mysql://localhost:3306/w3schools";
            String username = "root";
            String password = "1234";
            Connection connection = DriverManager.getConnection(url, username, password);
            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                SupplierDto supplierDto = new SupplierDto();
                supplierDto.setId(resultSet.getInt("SupplierID"));
                supplierDto.setName(resultSet.getString("SupplierName"));
                supplierDto.setContactName(resultSet.getString("ContactName"));
                supplierDto.setAddress(resultSet.getString("Address"));
                supplierDto.setCity(resultSet.getString("City"));
                supplierDto.setPostalCode(resultSet.getString("PostalCode"));
                supplierDto.setCountry(resultSet.getString("Country"));
                supplierDto.setPhone(resultSet.getString("Phone"));

                model.addAttribute("supplier", supplierDto);
            }
        }

        return "main16/sub6";
    }

    @PostMapping("sub6")
    public String process6(SupplierDto supplierDto, RedirectAttributes rttr) throws Exception {
        String sql = """
                UPDATE Suppliers
                SET supplierName = ?,
                    ContactName = ?,
                    Address = ?,
                    PostalCode = ?,
                    City = ?,
                    Country = ?,
                    Phone = ?
                WHERE SupplierID = ?
                """;
        String url = "jdbc:mysql://localhost:3306/w3schools";
        String username = "root";
        String password = "1234";
        Connection connection = DriverManager.getConnection(url, username, password);
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, supplierDto.getName());
        statement.setString(2, supplierDto.getContactName());
        statement.setString(3, supplierDto.getAddress());
        statement.setString(4, supplierDto.getPostalCode());
        statement.setString(5, supplierDto.getCity());
        statement.setString(6, supplierDto.getCountry());
        statement.setString(7, supplierDto.getPhone());
        statement.setInt(8, supplierDto.getId());

        statement.executeUpdate(); //update

        rttr.addAttribute("id", supplierDto.getId());


        return "redirect:/main16/sub6";
    }
}
