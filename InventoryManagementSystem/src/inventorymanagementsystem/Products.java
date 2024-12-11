package inventorymanagementsystem;

import java.awt.*;
import java.sql.*;
import java.util.*;
import javax.swing.*;

public class Products {
    //Attributes:
    private String name;
    private float price;
    private int qty;
    private int lowStock;
    
    //Default Constructor:
    Products(){}
    
    //Parameterized:
     public Products(String name, float price, int qty) {
        this.name = name;
        this.price = price;
        this.qty = qty;
        this.lowStock = 0;
     }
    
    //Getters & Setters:
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public float getPrice() {
        return price;
    }
    public void setPrice(float price) {
        this.price = price;
    }
    public int getQty() {
        return qty;
    }
    public void setQty(int qty) {
        this.qty = qty;
    }
    public int getLowStock() {
        return lowStock;
    }
    public void setLowStock(int lowStock) {
        this.lowStock = lowStock;
    }
    
    //Methods:
    public static void addProducts(String name, double price, int quantity){
        
        //Statement    stm =   Connection.createStatement();
        
        
        
//        Scanner input = new Scanner(System.in);
//        
//        if(counter == products.length - 1){ // Warehouse Full
//            System.out.println("Maximum Inventory Reached, No space left.");
//        }
//        // Product Name
//        while(true){    //Product Name:
//            System.out.print("Enter Product Name : ");
//            String name = input.nextLine();
//            if(counter != -1){ //Cheking for duplication
//                for(int i = 0; i <= counter; i++){
//                    if(products[i].getName().equalsIgnoreCase(name)){
//                        System.out.println("\nThis Product is already Added ---------> \"" 
//                                + products[i].getName() + "\".");
//                        System.out.println("Quantity can be Updated from Main Menu.");
//                        return false;
//                    }
//                }
//            }
//            if(name.length() >= 3 && name.length() <= 30){
//                if(name.charAt(0) >= 'A' && name.charAt(0)<= 'Z'){
//                    byte flag = 0;
//                    for(int i = 1; i < (name.length()-1); i++){
//                        if(name.charAt(i) == ' ' && name.charAt(i+1) == ' '){ 
//                            flag = 1;
//                            break;
//                        }
//                    }
//                    if (name.charAt(name.length()-1) == ' '){
//                            flag = 2;
//                    }
//                    if(flag == 1){
//                        System.out.println("Invalid!, Product Name can't have Two Consecutive Spaces.");
//                    }
//                    else if(flag == 2){
//                        System.out.println("Invalid!, Product Name can't end with Spaces.");
//                    }
//                    else {
//                        
//                        products[counter + 1] = new Products();
//                        products[counter + 1].setName(name);
//                        counter ++;
//                        break;  //breaks while-Loop
//                    }
//                }
//                else{
//                    System.out.println("Invalid!, The Product Name Must start with a Upercase Alphabet.");
//                }
//            }
//            else{
//                System.out.println("Invalid!, Product name length must be greater than 3 & less than 30 characters.");
//            }
//        }
//        
//        //Product Price:
//        while(true){ //Product Price:
//            System.out.print("Enter Product Price: ");
//            float price = input.nextFloat();
//            if(price <= 0.0f){
//                System.out.println("Invalid!, Product Price must be Greater than zero.");
//            }
//            else{
//                products[counter].setPrice(price);
//                break; // breaks while
//            }
//        }
//        
//        //Product Quantity:
//        while(true){ // Product Qty
//            System.out.print("Enter Product Quantity: ");
//            int qty = input.nextInt();
//            if(qty <= 0){
//                System.out.print("Invalid!, Quantity Must be greater than Zero");
//            }
//            else{
//                products[counter].setQty(qty);
//                break; // breaks while
//            }
//        }
//        //Low Stock Limit
//        while(true){ //Low Stock Limit
//            System.out.print("Do you want to Implement a Low-Stock feature for this Product [Y/N]: ");
//            char c = input.next().charAt(0);
//            if(c == 'Y' || c == 'y'){
//                System.out.print("Enter Your Low-Stock Limit: ");
//                int lowStock = input.nextInt();
//                if(!(lowStock <= products[counter].getQty())){  //Negation Logic
//                    System.out.print("Stock Limit cant be implemented Less than Current Quantity.");
//                }
//                else{
//                    products[counter].setLowStock(lowStock);
//                    System.out.print("Low-Stock Indicator Added...");
//                    return true;
//                }
//            }
//            else if(c == 'N' || c == 'n'){
//                return true;
//            }
//        }
    }
    
    public static void updateQuantity(Products[] products, int counter){
        Scanner input = new Scanner(System.in);
        
        if(counter ==  -1){ // If Inventory is Empty
            System.out.print("No Products! to Update Quantity.");
            return;
        }
        while(true){ // Update Qty
            System.out.print("Enter Product Name: ");
            String name = input.nextLine();
            for(int i = 0; i <= counter; i++){
                if(products[i].getName().equalsIgnoreCase(name)){
                    System.out.print("Product Found: -> " + products[i].getName() + " <-\n ~>Do you wish to Proceed to Update Quantity (Y/N): ");
                    char c = input.next().charAt(0);
                    if(c == 'y' || c == 'Y'){
                        System.out.print("Enter the Updated Quantity for ---> \""
                                    + products[i].getName() + "\" : ");
                        int qty = input.nextInt();
                        products[i].setQty(qty);
                        System.out.println("Quantity Updated...");
                        return;
                    }
                    else if (c == 'n' || c == 'N'){
                        return;
                    }
                }
                
            }
                System.out.println("No Product Found.\n");
        }
    }

    public static void display(Products[] products, int counter){
        if(counter ==  -1){ // If Inventory is Empty
            System.out.print("No Products to Display.");
            System.out.println();
            return;
        }
        System.out.println("\n--------------->>>>>>>>>>>>PRODUCT LIST<<<<<<<<<<<<---------------\n");
        System.out.println("(Sr#). \"Name\" | Price($) | x(Quantity)  |------> [Total Price($)]");
        System.out.println("-----------------------------------------------------------------");
        for(int i = 0; i <= counter; i++){
            
            System.out.print("(" + (i+1) +"). \"" + products[i].getName()
                    + "\" | $" + products[i].getPrice() + " | x" + products[i].getQty() + "  |------> [$" 
                    + products[i].priceXquantity(products[i].getPrice(), products[i].getQty()) + "]");
            if(products[i].getLowStock() > 0){
                if(products[i].getQty() < (products[i].getLowStock() / 2) && products[i].getQty() != 0){  // if stock is less than half stock limit
                    System.out.print(" ~> Very Low Stocks");
                }
                else if(products[i].getQty()<= products[i].getLowStock() && products[i].getQty() != 0){
                    System.out.print(" ~> Low Stocks");
                }
                else if(products[i].getQty() == 0){
                    System.out.print(" ~> Stock Finished");
                }
                
            }
            System.out.println();
        }
        System.out.println();
    }
    
    public static void total(Products[] products, int counter){
        if(counter ==  -1){ // If Inventory is Empty
            System.out.println("No Products!");
            return;
        }
        System.out.print("\nThe Total Worth of Inventory is ----> $");
        double totalPrice = 0.0d;
        int totalQty = 0;
        for(int i = 0; i <= counter; i++){
            totalPrice += products[i].priceXquantity(products[i].getPrice(), products[i].getQty());
            totalQty += products[i].getQty();
        }
        System.out.println(totalPrice);
        System.out.println();
        System.out.println("Total Number of Items: " + (counter + 1));
        System.out.println("Total Quantity of Items: " + totalQty);
        System.out.println("Average Cost per Item: $ " + totalPrice/totalQty);
    }
    
    public static void sortProducts(Products[] products, int counter){
        Scanner input = new Scanner(System.in);
        if(counter ==  -1){ // If Inventory is Empty
            System.out.println("No Products to Sort");
            System.out.println();
            return;
        }
        System.out.println("1. Sort by Price"
                        + "\n2. Sort by Name");
        int choice = choice(2);
        Products temp = new Products();
        switch(choice){
            case 1:
                for(int j = 0; j < counter - 1; j++){
                    for(int i = 0; i < counter; i++){
                            if(products[i].getPrice() < products[i+1].getPrice()){
                                temp = products[i];
                                products[i] = products[i+1];
                                products[i+1] = temp;
                        }
                    }
                }
                System.out.println("Done Ascending Sorting based on Price....");
                break;
            case 2:
                for(int j = 0; j < counter - 1; j++){
                    for(int i = 0; i < counter; i++){
                            if(products[i].getName().charAt(0) > products[i+1].getName().charAt(0)){
                                temp = products[i];
                                products[i] = products[i+1];
                                products[i+1] = temp;
                        }
                    }
                }
                System.out.println("Done Alphabetical Sorting based on Name....");
                break;
            default:
                System.out.println("Invalid!, Choice");
                break;
                
            
        }
        
    }   
    
    //Secondary Methods:
    public static int choice(int last){  //String --> Int length(1) ~> Green
        Scanner input = new Scanner(System.in);
        while(true){
            System.out.print("Enter Choice: ");
            String userInput = input.nextLine();    //String ~> Green
            if(userInput.length() ==  1){   //checks length = 1
                if(userInput.charAt(0) >= '0' && userInput.charAt(0) <= '9'){
                    int c = Integer.parseInt(userInput);
                    if(c <= last){
                        switch(c){
                            case 1:
                                return 1;
                                //break;
                            case 2:
                                return 2;
                                //break;
                            case 3:
                                return 3;
                                //break;
                            case 4:
                                return 4;
                                //break;
                            case 5:
                                return 5;
                                //break;
                            default:
                                System.out.print("Invalid! Option.\n Avalible Options: (1-" + last + ").");
                                break;
                        } 
                    }
                    else{
                        System.out.println("Invalid! Option.\n Avalible Options: (1-" + last + ").");
                    }
                }
                else{
                    System.out.println("Invalid! Option.\n Avalible Options: (1-" + last + ").");
                }
            }
            else if(userInput.equalsIgnoreCase("exit")){    //if user changes his mind
                System.out.println();
                return -1;
            }
            else{
                System.out.println("Invalid! Option.\n Avalible Options: (1-" + last + ").");
            }
        }   //While end
    }
    
    public float priceXquantity(float price, int qty){
        return price * qty;
    }
    
    // Method for total cost
public static double calculateTotalInventoryCost() {
    double totalCost = 0.0;
    String url = "jdbc:mysql://localhost:3306/myinventory";
    String username = "root";
    String password = "Abdullah100?";
    
    // SQL query to get price and quantity from the products table
    String query = "SELECT price, quantity FROM products";

    try (Connection conn = DriverManager.getConnection(url, username, password);
         Statement stmt = conn.createStatement();
         ResultSet rs = stmt.executeQuery(query)) {
        
        while (rs.next()) {
            double price = rs.getDouble("price");
            int quantity = rs.getInt("quantity");
            totalCost += price * quantity;
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }

    return totalCost;
}
    
    //DB Methids:
    
   public static void insertProductToDatabase(String name, double price, int quantity) {
       String url = "jdbc:mysql://localhost:3306/myinventory?zeroDateTimeBehavior=convertToNull";
       String username = "root";
       String password = "Abdullah100?";

       Connection connection = null;
       PreparedStatement statement = null;
       ResultSet resultSet = null;

       try {
           Class.forName("com.mysql.cj.jdbc.Driver");
           connection = DriverManager.getConnection(url, username, password);

           String checkQuery = "SELECT COUNT(*) FROM products WHERE name = ?";
           statement = connection.prepareStatement(checkQuery);
           statement.setString(1, name);
           resultSet = statement.executeQuery();

           if (resultSet.next()) {
               int count = resultSet.getInt(1);
               if (count > 0) {

                   JOptionPane.showMessageDialog(null, "Product with this name already exists!", "Error", JOptionPane.ERROR_MESSAGE);
                   return; 
               }
           }

           // SQL query 
           String sql = "INSERT INTO products (name, price, quantity) VALUES (?, ?, ?)";
           statement = connection.prepareStatement(sql);
           statement.setString(1, name);
           statement.setDouble(2, price);
           statement.setInt(3, quantity);

           int rowsInserted = statement.executeUpdate();

           if (rowsInserted > 0) {
               // message
               JOptionPane.showMessageDialog(null, "Product inserted successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
           }

       } catch (SQLException e) {
           e.printStackTrace(); 
           JOptionPane.showMessageDialog(null, "Error inserting product: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
       } catch (ClassNotFoundException e) {
           e.printStackTrace();
           JOptionPane.showMessageDialog(null, "Database driver not found: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
       } finally {
           try {
               if (resultSet != null) resultSet.close();
               if (statement != null) statement.close();
               if (connection != null) connection.close();
           } catch (SQLException e) {
               e.printStackTrace();
           }
       }
   }

   public static boolean removeProduct(String name) {
          String url = "jdbc:mysql://localhost:3306/myinventory?zeroDateTimeBehavior=convertToNull";
       String username = "root";
       String password = "Abdullah100?";


       String sql = "DELETE FROM products WHERE name = ?";

       try (Connection connection = DriverManager.getConnection(url, username, password);
            PreparedStatement statement = connection.prepareStatement(sql)) {

           statement.setString(1, name);

           int rowsAffected = statement.executeUpdate();

           if (rowsAffected > 0) {
               return true; 
           } else {
               return false; 
           }

       } catch (SQLException e) {
           e.printStackTrace();
           return false; 
       }
   }

   public static void updateProductQuantity(String name, int quantity) {
       Connection connection = null;
       PreparedStatement statement = null;

       try {
           // Establish connection to the database
           String url = "jdbc:mysql://localhost:3306/myinventory?zeroDateTimeBehavior=convertToNull";
           String username = "root";
           String password = "Abdullah100?";  // Replace with your actual password
           connection = DriverManager.getConnection(url, username, password);

           String sql = "UPDATE products SET quantity = ? WHERE name = ?";
           statement = connection.prepareStatement(sql);

           // Set the values for the placeholders in the query
           statement.setInt(1, quantity);  
           statement.setString(2, name); 

           int rowsUpdated = statement.executeUpdate();

           if (rowsUpdated > 0) {
               JOptionPane.showMessageDialog(null, "Product quantity updated successfully!");
           } else {
               JOptionPane.showMessageDialog(null, "Product not found!", "Update Failed", JOptionPane.ERROR_MESSAGE);
           }

       } catch (SQLException e) {
           e.printStackTrace();
           JOptionPane.showMessageDialog(null, "Error updating product quantity: " + e.getMessage(), "Database Error", JOptionPane.ERROR_MESSAGE);
       } finally {
           try {
               if (statement != null) statement.close();
               if (connection != null) connection.close();
           } catch (SQLException e) {
               e.printStackTrace();
           }
       }
   }
   

    public static void displaySortedProducts(String sortBy, String order, JTextArea productArea) {
    String url = "jdbc:mysql://localhost:3306/myinventory";
    String username = "root";
    String password = "Abdullah100?"; 

    productArea.setText("");
    
    // sql query to fetch sorted products-> sortBy and order (ASC/DESC)
    String query = "";
    switch (sortBy) {
        case "Name":
            query = "SELECT * FROM products ORDER BY name " + order;
            break;
        case "Price":
            query = "SELECT * FROM products ORDER BY price " + order;
            break;
        case "Quantity":
            query = "SELECT * FROM products ORDER BY quantity " + order;
            break;
    }

    System.out.println("Executing query: " + query);

    try {
        Class.forName("com.mysql.cj.jdbc.Driver");
        
        // Establish the connection
        try (Connection conn = DriverManager.getConnection(url, username, password);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                String name = rs.getString("name");
                double price = rs.getDouble("price");
                int quantity = rs.getInt("quantity");
                productArea.append("Name: " + name + ", Price: " + price + ", Quantity: " + quantity + "\n");
            }
        }
    } catch (ClassNotFoundException e) {
        e.printStackTrace(); 
    } catch (SQLException e) {
        e.printStackTrace(); 
    }
}

   public static void displayAllProducts(JTextArea productArea) {

        String url = "jdbc:mysql://localhost:3306/myinventory";
        String username = "root";
        String password = "Abdullah100?";

        String query = "SELECT * FROM products";

        try (Connection conn = DriverManager.getConnection(url, username, password);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            productArea.setText(""); 
            while (rs.next()) {
                String name = rs.getString("name");
                double price = rs.getDouble("price");
                int quantity = rs.getInt("quantity");

                productArea.append("Name: " + name + ", Price: " + price + ", Quantity: " + quantity + "\n");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            productArea.setText("Error fetching product data.");
        }
    }
}






        
//        try {
//            // Save customer details
//            String insertCustomerSQL = "INSERT INTO customers (name, price, quantity) VALUES (?, ?, ?)";
//            PreparedStatement stm1 = conn.prepareStatement(insertCustomerSQL, Statement.RETURN_GENERATED_KEYS);
//            stm1.setString(1, name);
//            stm1.setString(2, price);
//            stm1.setInt(3, quantity);
//         
//            stm1.executeUpdate();
//
//            ResultSet rs = stm1.getGeneratedKeys();
//            int customerIdInserted = -1;
//            if (rs.next()) {
//                customerIdInserted = rs.getInt(1);
//            }
//
//            // Save order details
//            for (int i = 0; i < orderListModel.size(); i++) {
//                String orderDetails = orderListModel.getElementAt(i);
//                String itemName = orderDetails.split(" x ")[0];
//                int quantity = Integer.parseInt(orderDetails.split(" x ")[1].split(" = ")[0].trim());
//                int price = Integer.parseInt(orderDetails.split(" = PKR ")[1]);
//
//                String insertOrderSQL = "INSERT INTO orders (customer_id, item_name, quantity, price) VALUES (?, ?, ?, ?)";
//                PreparedStatement orderStatement = conn.prepareStatement(insertOrderSQL);
//                orderStatement.setInt(1, customerIdInserted);
//                orderStatement.setString(2, itemName);
//                orderStatement.setInt(3, quantity);
//                orderStatement.setInt(4, price);
//                orderStatement.executeUpdate();
//            }
//        } catch (SQLException e) {
//            JOptionPane.showMessageDialog(this, "Error saving data to the database: " + e.getMessage(), "Database Error", JOptionPane.ERROR_MESSAGE);
//        }
    

    
    

    

