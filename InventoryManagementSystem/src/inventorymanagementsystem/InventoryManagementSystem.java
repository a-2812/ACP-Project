package inventorymanagementsystem;

import java.sql.*;
import java.util.Scanner;
import javax.swing.JOptionPane;



public class InventoryManagementSystem {
    public static int counter = -1;
    public static Products[] products = new Products[100]; // Objects not created yet only array
    //public static GUI gui= new GUI("null");
   // Connection co = null;
//    Statement st = null;
//    PreparedStatement pst;
//    ResultSet rs = null;
    Statement st = null;
    PreparedStatement pst;
    ResultSet rs = null;
    
    // Main method:
    public static void main(String[] args) {

        
        GUI mygui = new GUI("Inventory Management System");
        mygui.mainFrame(mygui);
        
//        Scanner input = new Scanner(System.in);
//        
//        System.out.println("Welcome To Our Inventory Mangement System");
//        System.out.println();
//        
//        System.out.println("1. Add Products\n" + ""
//                + "2. Update Quantity\n"
//                + "3. Display Products & Quantities\n"
//                + "4. Total Products Worth\n"
//                + "5. Sort Products\n");  
//        
//        int choice;
//        
//        while(true){ 
//            System.out.println();
//            choice = Products.choice(5);
//            
//            switch(choice){
//                case 1:
//                    boolean r;
//                 
//                          
//                  r = Products.addProducts(products, counter);
//                    if(r == true){
//                       counter++;
//                       System.out.println("Product is Added...");
//                    }
////                    Books.display(books, counter);
//                    break;
//                case 2:
//                    Products.updateQuantity(products, counter);
//                    break;
//                case 3:
//                    Products.display(products, counter);
//                    break;
//                case 4:
//                    Products.total(products, counter);
//                    break;
//                case 5:
//                    Products.sortProducts(products, counter);
//                    break;    
//                default:
//                    System.out.print("Error...");
//                    break;          
//            }
//        }
    }
    // Method to insert product into the database
    
}
    
//    public void saveCustomerAndOrderToDatabase(String name, double price, int quantity) {
//        
//        // 4. Connect to the database
//            Connection conn = DriverManager.getConnection(url, username, password);
//            
//            // 5. SQL Insert Query
//            String sql = "INSERT INTO Products (name, price, quantity) VALUES (?, ?, ?)";
//            PreparedStatement stmt = conn.prepareStatement(sql);
//            
//            // 6. Set the values
//            stmt.setString(1, name);
//            stmt.setDouble(2, price);
//            stmt.setInt(3, quantity);
//            
//            // 7. Execute the update
//            int rowsInserted = stmt.executeUpdate();
//            
//            if (rowsInserted > 0) {
//                JOptionPane.showMessageDialog(null, "Product added successfully!");
//            }
//            
//            // 8. Close the connection
//            stmt.close();
//            conn.close();
//    }
//}













//package inventorymanagementsystem;
//
//import java.io.*;
//import java.util.Scanner;
//
//public class InventoryManagementSystem {
//    public static int counter = -1;
//    public static Products[] products = new Products[100]; // Objects not created yet only array
//    public static final String FILE_PATH = "products.txt"; // File path for storing product info
//
//    // Main method:
//    public static void main(String[] args) {
//        Scanner input = new Scanner(System.in);
//        
//        // Load products from file at the start
//        loadProductsFromFile();
//
//        System.out.println("Welcome To Our Inventory Management System");
//        System.out.println();
//        
//        System.out.println("1. Add Products\n" +
//                "2. Update Quantity\n" +
//                "3. Display Products & Quantities\n" +
//                "4. Total Products Worth\n" +
//                "5. Sort Products\n");
//        
//        int choice;
//        
//        while (true) { 
//            System.out.println();
//            choice = Products.choice(5);
//            
//            switch (choice) {
//                case 1:
//                    boolean r;
//                    r = Products.addProducts(products, counter);
//                    if (r) {
//                        counter++;
//                        System.out.println("Product is Added...");
//                        // Save new product to the file
//                        saveProductsToFile();
//                    }
//                    break;
//                case 2:
//                    Products.updateQuantity(products, counter);
//                    saveProductsToFile();  // Update file after quantity change
//                    break;
//                case 3:
//                    Products.display(products, counter);
//                    break;
//                case 4:
//                    Products.total(products, counter);
//                    break;
//                case 5:
//                    Products.sortProducts(products, counter);
//                    saveProductsToFile();  // Save sorted products to the file
//                    break;
//                default:
//                    System.out.print("Error...");
//                    break;
//            }
//        }
//    }
//
//    // Method to save products to file
//    public static void saveProductsToFile() {
//        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH))) {
//            for (int i = 0; i <= counter; i++) {
//                Products product = products[i];
//                if (product != null) {
//                    writer.write(product.getName() + "," + product.getQty() + "," + product.getPrice());
//                    writer.newLine();
//                }
//            }
//        } catch (IOException e) {
//            System.out.println("Error writing to file: " + e.getMessage());
//        }
//    }
//
//    // Method to load products from file
//    public static void loadProductsFromFile() {
//        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
//            String line;
//            while ((line = reader.readLine()) != null) { 
//                String[] parts = line.split(",");
//                if (parts.length == 3) {
//                    String name = parts[0];
//                    int quantity = Integer.parseInt(parts[1]);
//                    float price = Float.parseFloat(parts[2]);
//                    
//                    counter++;
//                    products[counter] = new Products(name, price, quantity);
//                }
//            }
//        } catch (FileNotFoundException e) {
//            System.out.println("No previous product data found. Starting fresh.");
//        } catch (IOException e) {
//            System.out.println("Error reading from file: " + e.getMessage());
//        }
//    }
//}




//      // Set up the database connection
//        String url = "jdbc:mysql://localhost:3306/myinventory?zeroDateTimeBehavior=convertToNull";
//        String username = "root";
//        String password = "Abdullah100?";
//        
//        Connection connection = null;
//        PreparedStatement statement = null;
//        
//        try {
//            // Load MySQL driver and establish connection
//            Class.forName("com.mysql.cj.jdbc.Driver");
//            connection = DriverManager.getConnection(url, username, password);
//
//            // Prompt user for product details
//            System.out.println("Enter product name:");
//            String name = input.nextLine();
//            
//            System.out.println("Enter product price:");
//            double price = input.nextDouble();
//            
//            System.out.println("Enter product quantity:");
//            int quantity = input.nextInt();
//            
//            // SQL query to insert the product
//            String sql = "INSERT INTO products (name, price, quantity) VALUES (?, ?, ?)";
//            statement = connection.prepareStatement(sql);
//            
//            // Set the values for the placeholders in the SQL query
//            statement.setString(1, name);
//            statement.setDouble(2, price);
//            statement.setInt(3, quantity);
//            
//            // Execute the insert command
//            int rowsInserted = statement.executeUpdate();
//            
//            if (rowsInserted > 0) {
//                System.out.println("Product inserted successfully!");
//            }
//
//        } catch (Exception e) {
//            e.printStackTrace(); // Print the exception for debugging
//        } finally {
//            try {
//                if (statement != null) statement.close();
//                if (connection != null) connection.close();
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        }

//           try {
//            // Database connection
//            Class.forName("com.mysql.cj.jdbc.Driver");
//            Connection conn;// = DriverManager.getConnection(url,username, password);
//            String url = "jdbc:mysql://localhost:3306/mysql?zeroDateTimeBehavior=convertToNull";
//            String username = "root";
//            String password = "Abdullah100?";  // Replace with your password
//            conn = DriverManager.getConnection(url, username, password);
//            System.out.println(conn);
//            
////            st = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
////            rs = st.executeQuery("Select * From products");
//            
//        } catch (SQLException | ClassNotFoundException e) {
//            e.printStackTrace();
//            //JOptionPane.showMessageDialog(this, "Error connecting to database: " + e.getMessage(), "Database Error", JOptionPane.ERROR_MESSAGE);
//        }
//           pst =connection.prepareStatement();
//           Statement    pstmt         =   connection.prepareStatement();

    
//Driver