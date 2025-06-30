package com.example.spring.controller;

import com.example.spring.dto.CustomerDto;
import com.example.spring.dto.ProductsDto;
import com.example.spring.dto.SupplierDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("main15")
public class Controller15 {
    // paging

    @RequestMapping("sub1")
    public String sub1(
            @RequestParam(defaultValue = "1")
            Integer page,
            Model model) throws SQLException {
        // 페이즈 8을 보고있을때 page번호를 8, 사용자에게 받아옴
        // 한페이지에 10개씩 보여준다면
        String sql = """
                SELECT *
                FROM Customers
                ORDER BY CustomerID
                LIMIT ? , ?
                """;
        // 총 고객 수
        String countSql = """
                SELECT COUNT(*) AS count
                FROM Customers
                """;

        String url = "jdbc:mysql://localhost:3306/w3schools";
        String username = "root";
        String password = "1234";
        Connection connection = DriverManager.getConnection(url, username, password);
        PreparedStatement statement = connection.prepareStatement(sql);
        // limit ?에서부터 /개까지
        // offset: (page -1) * 10
//        statement.setInt(1, 0); // 1page
//        statement.setInt(2, 10); // 2page
//        statement.seeInt(1, 20); // 3page
//        statement.seeInt(2, 20); // 3page
        int offset = (page - 1) * 10;
        statement.setInt(1, offset);
        statement.setInt(2, 10);

        ResultSet rs2 = connection.prepareStatement(countSql).executeQuery();
        rs2.next();
        int count = rs2.getInt("count");// 총 고객수
        int lastPage = (count - 1) / 10 + 1; // 마지막 페이지 번호

        model.addAttribute("lastPage", lastPage);

        ResultSet rs = statement.executeQuery();
        List<CustomerDto> list = new ArrayList<>();
        while (rs.next()) {
            CustomerDto customerDto = new CustomerDto();
            customerDto.setId(rs.getInt("CustomerId"));
            customerDto.setName(rs.getString("CustomerName"));
            customerDto.setContactName(rs.getString("ContactName"));
            customerDto.setAddress(rs.getString("Address"));
            customerDto.setCity(rs.getString("City"));
            customerDto.setPostalCode(rs.getString("PostalCode"));
            customerDto.setCountry(rs.getString("Country"));
            list.add(customerDto);
        }
        model.addAttribute("customersList", list);


        return "main15/sub14";
    }

    // 연습
    // 한 페이지에 5개의 공급자가 출력되도록 코드 작성(정렬은 공급자 번호순)
    // request handelr method, html
    @RequestMapping("sub2")
    public String sub2(
            // 없을경우 값을 1로 준다는 뜻.
            @RequestParam(defaultValue = "1")
            Integer page,
            Model model) throws SQLException {
        String sql = """
                SELECT *
                FROM Suppliers
                ORDER BY SupplierID
                LIMIT ? , ?;
                """;
        String countSql = """
                SELECT COUNT(*) AS count
                FROM Suppliers
                """;
        String url = "jdbc:mysql://localhost:3306/w3schools";
        String username = "root";
        String password = "1234";
        Connection connection = DriverManager.getConnection(url, username, password);
        PreparedStatement statement = connection.prepareStatement(sql);
        int offset = (page - 1) * 5;
        statement.setInt(1, offset);
        statement.setInt(2, 5);

        ResultSet rs2 = connection.prepareStatement(countSql).executeQuery();
        rs2.next();
        int count = rs2.getInt("count");// 총 레코드 수
        int lastPage = (count - 1) / 5 + 1; // 마지막 페이지 번호

        model.addAttribute("lastPage", lastPage);

        ResultSet rs = statement.executeQuery();
        List<SupplierDto> list = new ArrayList<>();
        while (rs.next()) {
            SupplierDto supplierDto = new SupplierDto();
            supplierDto.setId(rs.getInt("SupplierID"));
            supplierDto.setName(rs.getString("SupplierName"));
            supplierDto.setAddress(rs.getString("Address"));
            supplierDto.setContactName(rs.getString("ContactName"));
            supplierDto.setCity(rs.getString("City"));
            supplierDto.setPostalCode(rs.getString("PostalCode"));
            supplierDto.setCountry(rs.getString("Country"));
            list.add(supplierDto);
        }
        model.addAttribute("suppliersList", list);

        return "main15/sub2";
    }

    // 검색한 이후에 페이지 수 변경
    // 검색 + 페이징
    // 데이터가 아주 많을 경우,
    // 현재 페이지가 1~10 일 경우, 왼쪽은 1페이지, 오른쪽은 10페이지
    // 현재 페이지가 11~20 일 경우, 왼쪽은 11페이지, 오른쪽은 20페이지
    // 현재 페이지가 21~30 일 경우, 왼쪽은 21페이지, 오른쪽은 30페이지
    // ---
    // 현재 페이지가 71~80 일 경우, 왼쪽은 71페이지, 오른쪽은 80페이지
    // 오른쪽 값을 먼저 구하고 -9하면 됨. integer 연산
    // (n-1)/10+1*10
    // 왼쪽값은 (n-1)/10+1*10 -9
    @RequestMapping("sub3")
    public String sub3(
            @RequestParam(defaultValue = "1")
            Integer page,
            @RequestParam(defaultValue = "") // 하지 않을 경우 null이 들어가짐,
            String keyword,
            // 근데 또 null을 넣으면 null을 검색한것처럼 되어서 ""으로 작성
            Model model) throws Exception {
        String countSql = """
                SELECT COUNT(*) AS count
                FROM Customers
                WHERE CustomerName LIKE ?
                OR ContactName LIKE ?
                """;
        String sql = """
                SELECT *
                FROM Customers
                WHERE CustomerName LIKE ?
                   OR ContactName LIKE ?
                ORDER BY CustomerID
                LIMIT ?, ?
                """;
        // 특정 키워드가
        String url = "jdbc:mysql://localhost:3306/w3schools";
        String username = "root";
        String password = "1234";
        Connection connection = DriverManager.getConnection(url, username, password);
        PreparedStatement countStmt = connection.prepareStatement(countSql);
        countStmt.setString(1, "%" + keyword + "%");
        countStmt.setString(2, "%" + keyword + "%");
        PreparedStatement selectStmt = connection.prepareStatement(sql);
        selectStmt.setString(1, "%" + keyword + "%");
        selectStmt.setString(2, "%" + keyword + "%");

        int offset = (page - 1) * 5;

        selectStmt.setInt(3, offset);
        selectStmt.setInt(4, 5);

        ResultSet rs1 = countStmt.executeQuery();
        rs1.next();
        int count = rs1.getInt("count"); // 총 레코드 수
        int lastPage = (count - 1) / 5 + 1; // 마지막 페이지
        int rightPage = ((page - 1) / 10 + 1) * 10; // 오른쪽 페이지
        int leftPage = rightPage - 9; // 왼쪽 페이지 번호

        // 만약 다음버튼, 이전버튼 눌렀을대 가는곳.
        int prevPage = leftPage - 10;
        int nextPage = rightPage + 1;
        rightPage = Math.min(rightPage, lastPage); // 오른쪽 페이지 번호는 마지막보다 클 수 없다.


        model.addAttribute("lastPage", lastPage); // 마지막 페이지
        model.addAttribute("rightPage", rightPage);
        model.addAttribute("leftPage", leftPage);
        model.addAttribute("prevPage", prevPage); // 이전페이지
        model.addAttribute("nextPage", nextPage); // 다음 페이지

        ResultSet rs2 = selectStmt.executeQuery();
        List<CustomerDto> list = new ArrayList<>();
        while (rs2.next()) {
            CustomerDto customerDto = new CustomerDto();
            customerDto.setId(rs2.getInt("CustomerID"));
            customerDto.setName(rs2.getString("CustomerName"));
            customerDto.setContactName(rs2.getString("ContactName"));
            customerDto.setAddress(rs2.getString("Address"));
            customerDto.setCity(rs2.getString("City"));
            customerDto.setPostalCode(rs2.getString("PostalCode"));
            customerDto.setCountry(rs2.getString("Country"));
            list.add(customerDto);
        }
        model.addAttribute("customerList", list);


        return "main15/sub3";
    }

    // 연습
    // 상품명 조회 로직 작성(w/ paging)
    @RequestMapping("sub4")
    public String sub4(
            @RequestParam(defaultValue = "1") Integer page,
            @RequestParam(defaultValue = "") String keyword,
            Model model) throws Exception {

        String countSql = """
                SELECT COUNT(*) AS count
                FROM Products
                WHERE ProductName LIKE ?
                """;

        String sql = """
                SELECT *
                FROM Products
                WHERE ProductName LIKE ?
                ORDER BY ProductID
                LIMIT ?, ?
                """;
        String url = "jdbc:mysql://localhost:3306/w3schools";
        String username = "root";
        String password = "1234";
        Connection connection = DriverManager.getConnection(url, username, password);
        PreparedStatement countStmt = connection.prepareStatement(countSql);
        PreparedStatement selectStmt = connection.prepareStatement(sql);
        countStmt.setString(1, "%" + keyword + "%");
        selectStmt.setString(1, "%" + keyword + "%");
        int offset = (page - 1) * 5;
        selectStmt.setInt(2, offset);
        selectStmt.setInt(3, 5);

        ResultSet rs1 = countStmt.executeQuery();
        rs1.next();
        int count = rs1.getInt("count");
        int lastPage = (count - 1) / 5 + 1;
        int rightPage = ((page - 1) / 10 + 1) * 10; // 오른쪽 페이지
        int leftPage = rightPage - 9;

        // 만약 다음버튼, 이전버튼 눌렀을대 가는곳.
        int prevPage = leftPage - 10;
        int nextPage = rightPage + 1;
        rightPage = Math.min(rightPage, lastPage);
        int firstPage = 1;
        int nowPage = page;


        model.addAttribute("lastPage", lastPage);
        model.addAttribute("rightPage", rightPage);
        model.addAttribute("leftPage", leftPage);
        model.addAttribute("prevPage", prevPage);
        model.addAttribute("nextPage", nextPage);
        model.addAttribute("firstPage", firstPage);
        model.addAttribute("nowPage", nowPage);


        ResultSet rs2 = selectStmt.executeQuery();
        List<ProductsDto> list = new ArrayList<>();
        while (rs2.next()) {
            ProductsDto productsDto = new ProductsDto();
            productsDto.setId(rs2.getInt("ProductID"));
            productsDto.setName(rs2.getString("ProductName"));
            productsDto.setSupplier(rs2.getInt("SupplierID"));
            productsDto.setCategory(rs2.getInt("CategoryID"));
            productsDto.setUnit(rs2.getString("Unit"));
            productsDto.setPrice(rs2.getDouble("Price"));
            list.add(productsDto);
        }
        model.addAttribute("productList", list);

        return "main15/sub4";
    }

}
