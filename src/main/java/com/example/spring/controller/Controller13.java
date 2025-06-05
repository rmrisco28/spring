package com.example.spring.controller;

import com.example.spring.dto.CustomerDto;
import com.example.spring.dto.ProductsDto;
import com.example.spring.dto.SupplierDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.lang.model.element.ModuleElement;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("main13")
public class Controller13 {
    @GetMapping("sub1")
    public String sub1(Model model) throws Exception {
        // 하는 일
        // 1. request 분석/ 가공
        //      @ GetMapping, @PostMapping, @RequestParam
        // 2. request (요청)을 처리 (business logic)
        //      CRUD (수정 삭제 조회 입력)
        // 2.1 연결
        // 자바에서 db를 연결하고있는데, 클래스를 추가를 안했음.
        String url = "jdbc:mysql://localhost:3306/w3schools";
        String username = "root";
        String password = "1234";
        Connection connection = DriverManager.getConnection(url, username, password);
        // 2.2 쿼리(sql) 실행
        String sql = """
                SELECT CustomerName 
                FROM Customers 
                WHERE CustomerID = 1
                """;
        PreparedStatement Statement = connection.prepareStatement(sql);
        ResultSet resultSet = Statement.executeQuery();

        // 2.3 결과 처리 (한 값이 model에 담길 예정)
        String name = "";
        if (resultSet.next()) {
            name = resultSet.getString("CustomerName");
        }


        // 3. 결과를 Model(RedirectAttributes)에 담고
        //      model.addAttribute(), rttr.addFlashAttribute(), rttr.addAttribute()
        //      session.setAttribute()
        model.addAttribute("name", name);

        // 4. view로 forwarding
        //      다른 경로로 redirection

        return "main13/sub1";
    }

    // 연습: 상품 번호가 1번인 상품 조회/ 출력
    // get main13/sub2
    // /main13/sub2.html
    @GetMapping("sub2")
    public String sub2(Model model) throws Exception {
        // 연결
        String url = "jdbc:mysql://localhost:3306/w3schools";
        String username = "root";
        String password = "1234";
        Connection connection = DriverManager.getConnection(url, username, password);
        String sql = """
                SELECT ProductName
                FROM Products
                WHERE ProductID = 1
                """;
        // 실행 준비
        PreparedStatement statement = connection.prepareStatement(sql);
        // 실행
        ResultSet resultSet = statement.executeQuery();

        // 결과 처리
        String productName = "";

        if (resultSet.next()) {
            productName = resultSet.getString("ProductName");
        }

        model.addAttribute("productName", productName);

        return "main13/sub2";
    }

    // 결과처리에 대해 설명
    @GetMapping("sub3")
    public String sub3(Model model) throws Exception {
        // 연결
        String url = "jdbc:mysql://localhost:3306/w3schools";
        String username = "root";
        String password = "1234";
        Connection connection = DriverManager.getConnection(url, username, password);
        String sql = """
                SELECT LastName
                FROM Employees
                
                """;
        // 실행 준비
        PreparedStatement statement = connection.prepareStatement(sql);
        // 실행
        ResultSet resultSet = statement.executeQuery();

        // ResultSet?
        // 넥스트라는 내용을 만날때마다 다음 값을 가져오게 됨
        // 실행하면 resultSet을 실행함.
        // ResultSet:
        // table 형태의 결과
        // 내부에 행(row)를 가리키는 커서가 있음.
        // next() 호출 하면 다음 행으로 커서를 이동
        // get..() 커서가 가리키고 있는 컬럼 값을 얻는 메소드
        // 주요 메소드는 이 두개.
        // 첫 커서는 첫번째 이전의 값을 가리킴. next 메소드 실행시 첫번째 값을 가리킴.
        // next() 메소드는 boolean 값을 반환. 탐색할 수 있다면 true 탐색할 것이 없다면 false

        resultSet.next(); // 1번행을 가리킴 (true 리턴)
        // get...() 할때는 타입이 갖고있는 문자열을 넣어주면 된다.
        String name1 = resultSet.getString("LastName");
        resultSet.next(); // 2번행을 가리킴 (true 리턴)
        String name2 = resultSet.getString("LastName");
        resultSet.next(); // 3번행을 가리킴 (true 리턴)
        String name3 = resultSet.getString("LastName");
        resultSet.next(); // 4번행을 가리킴 (true 리턴)
        String name4 = resultSet.getString("LastName");
        resultSet.next(); // 5번행을 가리킴 (true 리턴)
        String name5 = resultSet.getString("LastName");
        resultSet.next(); // 6번행을 가리킴 (true 리턴)
        String name6 = resultSet.getString("LastName");
        resultSet.next(); // 7번행을 가리킴 (true 리턴)
        String name7 = resultSet.getString("LastName");
        resultSet.next(); // 8번행을 가리킴 (true 리턴)
        String name8 = resultSet.getString("LastName");
        resultSet.next(); // 9번행을 가리킴 (true 리턴)
        String name9 = resultSet.getString("LastName");
        resultSet.next(); // 10번행을 가리킴(없으니까 false 리턴)

        var list = List.<String>of(name1, name2, name3, name4, name5, name6, name7, name8, name9);

        model.addAttribute("nameList", list);

        return "main13/sub3";
    }

    @GetMapping("sub4")
    public String sub4(Model model) throws Exception {
        // 연결
        String url = "jdbc:mysql://localhost:3306/w3schools";
        String username = "root";
        String password = "1234";
        Connection connection = DriverManager.getConnection(url, username, password);
        String sql = """
                SELECT FirstName    
                FROM Employees
                """;
        // 실행 준비
        PreparedStatement statement = connection.prepareStatement(sql);
        // 실행
        ResultSet resultSet = statement.executeQuery();

        // ResultSet?
//        넥스트라는 내용을 만날때마다 다음 값을 가져오게 됨
// 실행하면 resultSet을 실행함.
        // ResultSet:
        // table 형태의 결과
        // 내부에 행(row)를 가리키는 커서가 있음.
        // next() 호출 하면 다음 행으로 커서를 이동
        // get..() 커서가 가리키고 있는 컬럼 값을 얻는 메소드
        // 주요 메소드는 이 두개.
        // 첫 커서는 첫번째 이전의 값을 가리킴. next 메소드 실행시 첫번째 값을 가리킴.
        // next() 메소드는 boolean 값을 반환. 탐색할 수 있다면 true 탐색할 것이 없다면 false

        var list = new ArrayList<String>();

        while (resultSet.next()) {
            String name = resultSet.getString("FirstName");
            list.add(name);
        }

        model.addAttribute("nameList", list);

        return "main13/sub3";
    }

    // 연습: get/main13/sub5
    // Categories 테이블의 CategoryName들을 조회해서
    // amin13/sub5.html 에서 출력하기
    @GetMapping("sub5")
    public String sub5(Model model) throws Exception {
        String url = "jdbc:mysql://localhost:3306/w3schools";
        String username = "root";
        String password = "1234";
        Connection connection = DriverManager.getConnection(url, username, password);
        String sql = """
                SELECT CategoryName
                FROM Categories
                
                """;
        PreparedStatement Statement = connection.prepareStatement(sql);
        ResultSet resultSet = Statement.executeQuery();
        var list = new ArrayList<String>();
        while (resultSet.next()) {
            String name = resultSet.getString("CategoryName");
            list.add(name);
        }
        model.addAttribute("categoryList", list);

        return "main13/sub5";
    }

    @GetMapping("sub6")
    public String sub6(Model model) throws Exception {
        String url = "jdbc:mysql://localhost:3306/w3schools";
        String username = "root";
        String password = "1234";
        Connection connection = DriverManager.getConnection(url, username, password);

        String sql = """
                SELECT Price
                FROM Products
                ORDER BY Price
                """;
        PreparedStatement Statement = connection.prepareStatement(sql);
        ResultSet resultSet = Statement.executeQuery();

//        var list = new ArrayList<String>();
//        while (resultSet.next()) {
//            String price = resultSet.getString("Price");
//            list.add(price);
//        }
//        이것도 가능하지만 , 되도록 형식을 맞춰주자
        // 모든 데이터는 String으로 얻어오는 것이 가능하지만
        // 특별한 이유가 없다면 type에 맞는 get... 메소드 사용하자.
        var list = new ArrayList<Double>();
        while (resultSet.next()) {
            double price = resultSet.getDouble("Price");
            list.add(price);
        }

        model.addAttribute("priceList", list);
        return "main13/sub6";
    }
    // 연습:
    // get /main13/sub7/
    // OrderDetails에서 수량(Quantity) 상위 5개 조회해서
    // main13/sub7에서 보여주기

    @GetMapping("sub7")
    public String sub7(Model model) throws Exception {
        String url = "jdbc:mysql://localhost:3306/w3schools";
        String username = "root";
        String password = "1234";
        Connection connection = DriverManager.getConnection(url, username, password);
        String sql = """
                SELECT Quantity
                FROM OrderDetails
                ORDER BY Quantity DESC
                LIMIT 5
                """;
        PreparedStatement Statement = connection.prepareStatement(sql);
        ResultSet resultSet = Statement.executeQuery();

        var list = new ArrayList<Integer>();
        while (resultSet.next()) {
            int quantity = resultSet.getInt("Quantity");
            list.add(quantity);
        }
        model.addAttribute("quantityList", list);
        return "main13/sub7";
    }

    // 컬럼도 여러개, 행도 여러개인 것해보기
    @GetMapping("sub8")
    public String sub8(Model model) throws Exception {
        String sql = """
                SELECT LastName, FirstName
                FROM Employees
                """;

        String url = "jdbc:mysql://localhost:3306/w3schools";
        String username = "root";
        String password = "1234";
        Connection connection = DriverManager.getConnection(url, username, password);
        PreparedStatement Statement = connection.prepareStatement(sql);
        ResultSet resultSet = Statement.executeQuery();

        var list = new ArrayList<Map<String, String>>();
        while (resultSet.next()) {
            String lastName = resultSet.getString("LastName");
            String firstName = resultSet.getString("FirstName");

            var name = new HashMap<String, String>();
            name.put("lastName", lastName);
            name.put("firstName", firstName);

            list.add(name);
        }
        model.addAttribute("nameList", list);

        return "main13/sub8";
    }
    // 연습
    // get /main13/sub9
    // 고객 테이블에서 미국, 영국에 사는고객 이름과 국가를 조회해서
    // main13/sub9.html에서 출력

    @GetMapping("sub9")
    public String sub9(Model model) throws Exception {
        String url = "jdbc:mysql://localhost:3306/w3schools";
        String username = "root";
        String password = "1234";
        Connection connection = DriverManager.getConnection(url, username, password);

        String sql = """
                
                SELECT  CustomerName, Country, City
                FROM Customers
                WHERE Country  IN ('uk','usa')
                ORDER BY Country, City
                """;
        PreparedStatement Statement = connection.prepareStatement(sql);
        ResultSet resultSet = Statement.executeQuery();
        var list = new ArrayList<Map<String, String>>();
        while (resultSet.next()) {
            String name = resultSet.getString("CustomerName");
            String country = resultSet.getString("Country");
            String city = resultSet.getString("City");

            var customersList = new HashMap<String, String>();
            customersList.put("name", name);
            customersList.put("country", country);
            customersList.put("city", city);

            list.add(customersList);
        }
        model.addAttribute("countryList", list);
        return "main13/sub9";
    }

    @GetMapping("sub10")
    public String sub10(Model model) throws Exception {
        String sql = """
                SELECT *
                FROM Products
                """;
        String url = "jdbc:mysql://localhost:3306/w3schools";
        String username = "root";
        String password = "1234";
        Connection connection = DriverManager.getConnection(url, username, password);
        PreparedStatement Statement = connection.prepareStatement(sql);
        ResultSet resultSet = Statement.executeQuery();

        var list = new ArrayList<Map<String, Object>>();
        while (resultSet.next()) {
            int productId = resultSet.getInt("ProductId");
            String productName = resultSet.getString("ProductName");
            int supplierID = resultSet.getInt("SupplierID");
            int categoryID = resultSet.getInt("CategoryID");
            String unit = resultSet.getString("Unit");
            double price = resultSet.getDouble("Price");

            Map<String, Object> map = new HashMap<>();
            map.put("productId", productId);
            map.put("productName", productName);
            map.put("supplierID", supplierID);
            map.put("categoryID", categoryID);
            map.put("unit", unit);
            map.put("price", price);
            list.add(map);
        }

        model.addAttribute("productList", list);
        return "main13/sub10";

    }

    // 연습
    // get/main13/sub11/
    // 모든 고객의 정보를 출력하는 코드 작성
    //  main13/ sub11.html 에서

    @GetMapping("sub11")
    public String sub11(Model model) throws Exception {
        String sql = """
                SELECT *
                FROM Customers
                """;
        String url = "jdbc:mysql://localhost:3306/w3schools";
        String username = "root";
        String password = "1234";
        Connection connection = DriverManager.getConnection(url, username, password);
        PreparedStatement Statement = connection.prepareStatement(sql);
        ResultSet resultSet = Statement.executeQuery();
        var list = new ArrayList<Map<String, Object>>();
        while (resultSet.next()) {
            int customerID = resultSet.getInt("CustomerID");
            String customerName = resultSet.getString("CustomerName");
            String contactName = resultSet.getString("ContactName");
            String address = resultSet.getString("Address");
            String city = resultSet.getString("City");
            String postalCode = resultSet.getString("PostalCode");
            String country = resultSet.getString("Country");

            Map<String, Object> map = new HashMap<>();
            map.put("customerID", customerID);
            map.put("customerName", customerName);
            map.put("contactName", contactName);
            map.put("address", address);
            map.put("city", city);
            map.put("postalCode", postalCode);
            map.put("country", country);
            list.add(map);
        }
        model.addAttribute("customerList", list);
        return "main13/sub11";
    }

    // 자바 빈
    @GetMapping("sub12")
    public String sub12(Model model) throws Exception {
        String sql = """
                    SELECT *
                FROM Customers
                """;
        String url = "jdbc:mysql://localhost:3306/w3schools";
        String username = "root";
        String password = "1234";
        Connection connection = DriverManager.getConnection(url, username, password);
        PreparedStatement Statement = connection.prepareStatement(sql);
        ResultSet resultSet = Statement.executeQuery();

        var list = new ArrayList<CustomerDto>();
        while (resultSet.next()) {
            int customerID = resultSet.getInt("CustomerID");
            String customerName = resultSet.getString("CustomerName");
            String contactName = resultSet.getString("ContactName");
            String address = resultSet.getString("Address");
            String city = resultSet.getString("City");
            String postalCode = resultSet.getString("PostalCode");
            String country = resultSet.getString("Country");

            CustomerDto dto = new CustomerDto();
            dto.setId(customerID);
            dto.setName(customerName);
            dto.setContactName(contactName);
            dto.setAddress(address);
            dto.setCity(city);
            dto.setPostalCode(postalCode);
            dto.setCountry(country);
            list.add(dto);

        }
        model.addAttribute("customerList", list);
        return "main13/sub12";
    }
    // 연습
    // dto, html, request handler method만들기
    // 모든 상품 조회, 출력
    // get/ main13/sub13
    // main13/sub13.html
    // productDto

    @GetMapping("sub13")
    public String sub13(Model model) throws Exception {
        String sql = """
                SELECT *
                FROM Products
                """;
        String url = "jdbc:mysql://localhost:3306/w3schools";
        String username = "root";
        String password = "1234";
        Connection connection = DriverManager.getConnection(url, username, password);
        PreparedStatement Statement = connection.prepareStatement(sql);
        ResultSet resultSet = Statement.executeQuery();

        var list = new ArrayList<ProductsDto>();
        while (resultSet.next()) {
            int productId = resultSet.getInt("ProductId");
            String productName = resultSet.getString("ProductName");
            int supplierID = resultSet.getInt("SupplierID");
            int categoryID = resultSet.getInt("CategoryID");
            String unit = resultSet.getString("Unit");
            double price = resultSet.getDouble("Price");

            ProductsDto dto = new ProductsDto();
            dto.setId(productId);
            dto.setName(productName);
            dto.setSupplier(supplierID);
            dto.setCategory(categoryID);
            dto.setUnit(unit);
            dto.setPrice(price);
            list.add(dto);
        }
        model.addAttribute("productList", list);
//        System.out.println("list = " + list);
        return "main13/sub13";
    }

    @GetMapping("sub14")
    public String sub14(Model model) throws Exception {
        // 변경 가능한 부분에 ? 로 작성
        String sql = """
                SELECT *
                FROM Products
                WHERE Price < ?
                """;
        // 연결시도
        String url = "jdbc:mysql://localhost:3306/w3schools";
        String username = "root";
        String password = "1234";
        Connection connection = DriverManager.getConnection(url, username, password);

        // 실행 준비
        // PreparedStatement를 넘겨 받는다.
        // sql을 받는것.
        // 값은 변하지 않고 그대로 온다.WHERE을 통해 값을 변경 하고 싶다면?
        PreparedStatement statement = connection.prepareStatement(sql);

        // PreparedStatement.execute .... ()
        // PreparedStatement.set... (index,value) : ?  채우는 메소드
        // ... 부분은 ?에 들어갈 타입
        statement.setDouble(1, 20.00);

        // 실행
        ResultSet resultSet = statement.executeQuery();

        // 결과 처리
        // 오전중에 한 얘기
        // 이제 실행 준비에 대한 얘기
        var list = new ArrayList<ProductsDto>();
        while (resultSet.next()) {

            ProductsDto dto = new ProductsDto();
            dto.setId(resultSet.getInt("ProductId"));
            dto.setName(resultSet.getString("ProductName"));
            dto.setSupplier(resultSet.getInt("SupplierID"));
            dto.setCategory(resultSet.getInt("CategoryID"));
            dto.setUnit(resultSet.getString("Unit"));
            dto.setPrice(resultSet.getDouble("Price"));
            list.add(dto);
        }
        model.addAttribute("productList", list);

        return "main13/sub13";
    }

    // /main13/sub15?price=10.00
    @GetMapping("sub15")
    public String sub15(Model model,
                        @RequestParam(defaultValue = "100.00")
                        Double price) throws Exception {
        // 변경 가능한 부분에 ? 로 작성
        String sql = """
                SELECT *
                FROM Products
                WHERE Price < ?
                """;
        // 연결시도
        String url = "jdbc:mysql://localhost:3306/w3schools";
        String username = "root";
        String password = "1234";
        Connection connection = DriverManager.getConnection(url, username, password);

        // 실행 준비
        // 프리페어런스 스테이먼트를 넘겨 받는다.
        // sql을 받는것.
        // 값은 변하지 않고 그대로 온다.WHERE을 통해 값을 변경 하고 싶다면?
        PreparedStatement statement = connection.prepareStatement(sql);

        // PreparedStatement.execute .... ()
        // PreparedStatement.set... (index,value) : ?  채우는 메소드
        // ... 부분은 ?에 들어갈 타입
        statement.setDouble(1, price);

        // 실행
        ResultSet resultSet = statement.executeQuery();

        // 결과 처리
        // 오전중에 한 얘기
        // 이제 실행 준비에 대한 얘기
        var list = new ArrayList<ProductsDto>();
        while (resultSet.next()) {

            ProductsDto dto = new ProductsDto();
            dto.setId(resultSet.getInt("ProductId"));
            dto.setName(resultSet.getString("ProductName"));
            dto.setSupplier(resultSet.getInt("SupplierID"));
            dto.setCategory(resultSet.getInt("CategoryID"));
            dto.setUnit(resultSet.getString("Unit"));
            dto.setPrice(resultSet.getDouble("Price"));
            list.add(dto);
        }
        model.addAttribute("productList", list);

        return "main13/sub15";
    }

    // 연습
    // 특정 카테고리 번호의 상품들 조회 후 출력
    // request handler method, html
    // get /main13/sub16
    // main13/sub16.
    @GetMapping("sub16")
    public String sub16(
            @RequestParam(defaultValue = "1")
            Integer categoryId,
            Model model) throws Exception {
        String sql = """
                SELECT *
                FROM Products
                WHERE CategoryId = ?
                """;
        String url = "jdbc:mysql://localhost:3306/w3schools";
        String username = "root";
        String password = "1234";
        Connection connection = DriverManager.getConnection(url, username, password);
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, categoryId);

        ResultSet resultSet = statement.executeQuery();
        var list = new ArrayList<ProductsDto>();
        while (resultSet.next()) {
            ProductsDto dto = new ProductsDto();
            dto.setId(resultSet.getInt("ProductId"));
            dto.setName(resultSet.getString("ProductName"));
            dto.setSupplier(resultSet.getInt("SupplierID"));
            dto.setCategory(resultSet.getInt("CategoryID"));
            dto.setUnit(resultSet.getString("Unit"));
            dto.setPrice(resultSet.getDouble("Price"));
            list.add(dto);
        }
        model.addAttribute("categoryList", list);

        return "main13/sub16";
    }

    @GetMapping("sub17")
    public String sub17(
            @RequestParam(defaultValue = "10.00")
            Double price,
            @RequestParam(defaultValue = "1")
            Integer categoryId,
            Model model
    ) throws Exception {
        String sql = """
                SELECT *
                FROM Products
                WHERE Price < ?
                AND CategoryID = ?
                """;
        String url = "jdbc:mysql://localhost:3306/w3schools";
        String username = "root";
        String password = "1234";
        Connection connection = DriverManager.getConnection(url, username, password);
        PreparedStatement statement = connection.prepareStatement(sql);

        statement.setDouble(1, price);
        statement.setInt(2, categoryId);
        ResultSet resultSet = statement.executeQuery();
        var list = new ArrayList<ProductsDto>();
        while (resultSet.next()) {
            ProductsDto dto = new ProductsDto();
            dto.setId(resultSet.getInt("ProductId"));
            dto.setName(resultSet.getString("ProductName"));
            dto.setSupplier(resultSet.getInt("SupplierID"));
            dto.setCategory(resultSet.getInt("CategoryID"));
            dto.setUnit(resultSet.getString("Unit"));
            dto.setPrice(resultSet.getDouble("Price"));
            list.add(dto);

        }
        model.addAttribute("productList", list);

        return "main13/sub17";
    }

    // 연습
    // 특정 가격 사이의 상품들 조회, 출력
    // 낮은 가격~ 높은 가격 최소 숫자 입력, 최대 숫자 입력, 조회 버튼
    // request handler, method, html(main13/sub18.html)
    // get 방식, /main13/sub18
    @GetMapping("sub18")
    public String sub18(
            @RequestParam(defaultValue = "0.00")
            Double min,
            @RequestParam(defaultValue = "10.00")
            Double max,
            Model model
    ) throws Exception {
        String sql = """
                SELECT *
                FROM Products
                WHERE Price BETWEEN ? AND ?
                ORDER BY price
                """;
        String url = "jdbc:mysql://localhost:3306/w3schools";
        String username = "root";
        String password = "1234";
        Connection connection = DriverManager.getConnection(url, username, password);
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setDouble(1, min);
        statement.setDouble(2, max);
        ResultSet resultSet = statement.executeQuery();

        var list = new ArrayList<ProductsDto>();
        while (resultSet.next()) {
            ProductsDto dto = new ProductsDto();
            dto.setId(resultSet.getInt("ProductId"));
            dto.setName(resultSet.getString("ProductName"));
            dto.setSupplier(resultSet.getInt("SupplierID"));
            dto.setCategory(resultSet.getInt("CategoryID"));
            dto.setUnit(resultSet.getString("Unit"));
            dto.setPrice(resultSet.getDouble("Price"));
            list.add(dto);

        }
        model.addAttribute("productList", list);
        return "main13/sub18";
    }

    @GetMapping("sub19")
    public String sub19(String country, Model model) throws Exception {
        String countrySql = """
                SELECT DISTINCT Country
                FROM Customers
                ORDER BY Country
                """;

        String sql = """
                SELECT *
                FROM Customers
                WHERE Country = ?
                ORDER BY City
                """;
        String url = "jdbc:mysql://localhost:3306/w3schools";
        String username = "root";
        String password = "1234";
        Connection connection = DriverManager.getConnection(url, username, password);

        // 국가 조회
        PreparedStatement statement1 = connection.prepareStatement(countrySql);
        ResultSet resultSet1 = statement1.executeQuery();
        var list1 = new ArrayList<String>();
        while (resultSet1.next()) {
            list1.add(resultSet1.getString("Country"));
        }
        model.addAttribute("countryList", list1);

        // 고객 조회
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, country);

        ResultSet resultSet = statement.executeQuery();
        var list = new ArrayList<CustomerDto>();

        while (resultSet.next()) {
            CustomerDto dto = new CustomerDto();
            dto.setId(resultSet.getInt("CustomerId"));
            dto.setName(resultSet.getString("CustomerName"));
            dto.setCity(resultSet.getString("City"));
            dto.setCountry(resultSet.getString("Country"));
            dto.setContactName(resultSet.getString("ContactName"));
            dto.setPostalCode(resultSet.getString("PostalCode"));
            dto.setAddress(resultSet.getString("Address"));
            list.add(dto);
        }
        model.addAttribute("customerList", list);
        return "main13/sub19";
    }

    // 연습
    // request handler method, supplierDto, html(main13/sub20.html)
    // 특정 국가에 있는 공급자들 조회
    // get /main13/sub20

    @GetMapping("sub20")
    public String sub20(String country, Model model) throws Exception {
        String countrySql = """
                 SELECT DISTINCT Country
                 FROM Suppliers
                   ORDER BY Country
                """;
        String sql = """
                 Select*
                 From Suppliers
                 Where Country = ?
                """;


        String url = "jdbc:mysql://localhost:3306/w3schools";
        String username = "root";
        String password = "1234";
        Connection connection = DriverManager.getConnection(url, username, password);
        PreparedStatement statement1 = connection.prepareStatement(countrySql);
        ResultSet resultSet1 = statement1.executeQuery();
        var list1 = new ArrayList<String>();
        while (resultSet1.next()) {
            list1.add(resultSet1.getString("Country"));

        }
        model.addAttribute("countryList", list1);

        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, country);
        ResultSet resultSet = statement.executeQuery();
        var list = new ArrayList<SupplierDto>();

        while (resultSet.next()) {
            SupplierDto dto = new SupplierDto();
            dto.setId(resultSet.getInt("SupplierID"));
            dto.setName(resultSet.getString("SupplierName"));
            dto.setContact(resultSet.getString("ContactName"));
            dto.setAddress(resultSet.getString("Address"));
            dto.setCity(resultSet.getString("City"));
            dto.setPostalCode(resultSet.getString("PostalCode"));
            dto.setCountry(resultSet.getString("Country"));
            dto.setPhone(resultSet.getString("Phone"));
            list.add(dto);
        }
        model.addAttribute("supplierList", list);

        return "main13/sub20";
    }
}
