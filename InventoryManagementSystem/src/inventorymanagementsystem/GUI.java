package inventorymanagementsystem;

import java.sql.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.border.Border;

public class GUI extends JFrame implements ActionListener {
//      JFrame frame = new JFrame("Inventory Management System");
    
    JPanel panel1 = new JPanel();
    JPanel panel2 = new JPanel();
    JPanel panel3 = new JPanel();
    JPanel panel4 = new JPanel();
    JPanel panel5 = new JPanel();
    
    JLabel label1 = new JLabel(); //create a label
    
    ImageIcon icon1 = new ImageIcon("C:\\Users\\dell\\Desktop\\5th Semester\\Advance Computer Programming\\Project\\inventory1.png");
    
   //Icons
    ImageIcon btnIcon1 = new ImageIcon("C:\\Users\\dell\\Desktop\\5th Semester\\Advance Computer Programming\\Project\\addButton.png");
    ImageIcon btnIcon2 = new ImageIcon("C:\\Users\\dell\\Desktop\\5th Semester\\Advance Computer Programming\\Project\\removeButton.png");
    ImageIcon btnIcon3 = new ImageIcon("C:\\Users\\dell\\Desktop\\5th Semester\\Advance Computer Programming\\Project\\updateButton.png");
    ImageIcon btnIcon4 = new ImageIcon("C:\\Users\\dell\\Desktop\\5th Semester\\Advance Computer Programming\\Project\\sortButton.png");
    ImageIcon btnIcon5 = new ImageIcon("C:\\Users\\dell\\Desktop\\5th Semester\\Advance Computer Programming\\Project\\displayButton.png");
    ImageIcon btnIcon6 = new ImageIcon("C:\\Users\\dell\\Desktop\\5th Semester\\Advance Computer Programming\\Project\\totalButton.png");
    
    ImageIcon bgIcon = new ImageIcon("C:\\Users\\dell\\Desktop\\5th Semester\\Advance Computer Programming\\Project\\bg.png");
    
    JTextField nameTF, priceTF, quantityTF;
    
    Border border = BorderFactory.createLineBorder(Color.PINK,1);
    
   //JButton button
    JButton btn1, btn2, btn3, btn4, btn5, btn6,   btn7, btn8, btn9, btn10, btn11, btn12, btn13;
    
    GUI addProductsGUI, removeProductsGUI, updateProductsGUI, sortProductsGUI,  displayProductsGUI;
    
    JComboBox<String> sortByCB;  //Combo
    JCheckBox ascCheckBox, dscCheckBox;  // Check/tic box
    JTextArea productArea;             //output space
		
    //Constructor:
    public GUI(String title){
        this.setSize(530,550);
        this.setTitle(title);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        //Icon
        ImageIcon image = new ImageIcon("C:\\Users\\dell\\Desktop\\5th Semester\\Advance Computer Programming\\Project\\logo.png");
        this.setIconImage(image.getImage());

        //Color theme
        this.getContentPane().setBackground(new Color(10,33,192)); //Change Background Color
       // Border border = BorderFactory.createLineBorder(Color.yellow, 5);
        this.setVisible(true);
    }
    
    //METHODS:
    void mainFrame(GUI mainFrame){
//        JFrame mainFrame = new JFrame();
        mainFrame.setLayout(new BorderLayout(6,6));
        this.setVisible(true);
        
        label1.setIcon(icon1);
        label1.setText("INVENTORY MANAGEMENT MADE EASY  "); //set text of label
        label1.setBorder(border);
        label1.setForeground(new Color(44,46,58)); //set font color of text
	label1.setFont(new Font("Comic Sans",Font.BOLD,20)); //set font of text
        label1.setIconTextGap(15); //set gap of text to image
        label1.setBackground(Color.cyan); //set background color
	label1.setOpaque(true); //display background color
        
        panel1.add(label1);
        
        panel1.setBackground(new Color(5,10,68));
        
        panel2.setBackground(new Color(5,10,68));
        panel3.setBackground(new Color(5,10,68));
        panel4.setBackground(new Color(5,10,68));
        panel5.setBackground(new Color(10,33,192)); 
        panel1.setPreferredSize(new Dimension(10,100));
        panel2.setPreferredSize(new Dimension(70,10));
        panel3.setPreferredSize(new Dimension(70,10));
        panel4.setPreferredSize(new Dimension(70,10));        
        
        panel5.setLayout(new GridLayout(6,1,0,5));
        
        panel5.add(btn1 = new JButton("Add Item"));
        panel5.add(btn2 = new JButton("Remove Item"));
        panel5.add(btn3 = new JButton("Update Quantity"));
        panel5.add(btn4 = new JButton("Sort Items"));
        panel5.add(btn5 = new JButton("Display Items"));
        panel5.add(btn6 = new JButton("Calculate Total"));
        
       //BUTTON 1 --> Add Item
        //btn1.setBounds(0, 0, 50, 100);
        btn1.addActionListener(this);
        btn1.setFocusable(false);
        btn1.setIcon(btnIcon1);
        btn1.setFont(new Font("Comic Sans",Font.BOLD,20));
        btn1.setIconTextGap(3);
        btn1.setVisible(true);
        
       //BUTTON 2 --> Remove Item
        btn2.addActionListener(this);
        btn2.setFocusable(false);
        btn2.setIcon(btnIcon2);
        btn2.setFont(new Font("Comic Sans",Font.BOLD,20));
        btn2.setIconTextGap(-10);
        //btn2.setBorder(BorderFactory.createBevelBorder(12, Color.BLUE, Color.black));
        btn2.setVisible(true);
        
       //BUTTON 3 --> Update Item
        btn3.setBounds(0, 0, 50, 100);
        btn3.addActionListener(this);
        btn3.setFocusable(false);
        btn3.setIcon(btnIcon3);
        btn3.setFont(new Font("Comic Sans",Font.BOLD,20));
        btn3.setIconTextGap(-1);
        //btn3.setBorder(BorderFactory.createBevelBorder(12, Color.BLUE, Color.black));
        btn3.setVisible(true);
        
       //BUTTON 4 --> Sort Item
        btn4.setBounds(0, 0, 50, 100);
        btn4.addActionListener(this);
        btn4.setFocusable(false);
        btn4.setIcon(btnIcon4);
        btn4.setFont(new Font("Comic Sans",Font.BOLD,20));
        btn4.setIconTextGap(5);
      
        btn4.setVisible(true);
        
       //BUTTON 5 --> Display Items
        btn5.setBounds(0, 0, 50, 100);
        btn5.addActionListener(this);
        btn5.setFocusable(false);
        btn5.setIcon(btnIcon5);
        btn5.setFont(new Font("Comic Sans",Font.BOLD,20));
        btn5.setIconTextGap(-10);
        btn5.setVisible(true);
        
       //BUTTON 6 --> Calculate Total
        btn6.setBounds(0, 0, 50, 100);
        btn6.addActionListener(this);  //acion listner
        btn6.setFocusable(false);
        btn6.setIcon(btnIcon6);
        btn6.setFont(new Font("Comic Sans",Font.BOLD,20));
        btn6.setIconTextGap(5);
        btn6.setVisible(true);
        
        panel5.setVisible(true);

        mainFrame.add(panel1,BorderLayout.NORTH);
        mainFrame.add(panel2,BorderLayout.WEST);
        mainFrame.add(panel3,BorderLayout.EAST);
        mainFrame.add(panel4,BorderLayout.SOUTH);
        mainFrame.add(panel5,BorderLayout.CENTER);
        //mainFrame.pack();
    }
    
    void newWindowAdd(GUI addFrame){
       // addFrame.setLayout(new FlowLayout(FlowLayout.LEADING,10,10));
        
        JLabel bg = new JLabel(); 
        bg.setLayout(new FlowLayout(FlowLayout.LEADING,10,10));
        bg.setIcon(bgIcon);
        
        addFrame.add(bg);
        
        JPanel addPanel = new JPanel();
        addPanel.setLayout(new GridLayout(3,1,-180,0));
        
       //Product Name: Label
        JLabel itemName = new JLabel("Product Name: ");
        itemName.setHorizontalTextPosition(JLabel.LEFT); 
        itemName.setForeground(new Color(0x00FF00)); //set font color of text
        itemName.setFont(new Font("MV Boli",Font.BOLD,20)); //set font of text
        itemName.setHorizontalAlignment(JLabel.LEFT);
        itemName.setBackground(Color.cyan); 
	itemName.setOpaque(false); 
       //Product Name: TF
        nameTF = new JTextField();
        nameTF.setPreferredSize(new Dimension(390,25));
        nameTF.setFont(new Font("Consolas",Font.PLAIN,20));
        nameTF.setForeground(new Color(179,180,189));
        nameTF.setBackground(Color.black);
        nameTF.setCaretColor(Color.white);
        nameTF.setBorder(border);
        nameTF.setText("Name");
        //nameTF.setVisible(true);
       //Add Components to Frame
        addPanel.add(itemName);
        addPanel.add(nameTF);
        //addPanel.setVisible(true);
        
       //Product Price: Label
        JLabel itemPrice = new JLabel("Product Price: ");
        itemPrice.setHorizontalTextPosition(JLabel.LEFT); //set text LEFT,CENTER, RIGHT of imageicon
        itemPrice.setForeground(new Color(0x00FF00)); //set font color of text
        itemPrice.setFont(new Font("MV Boli",Font.BOLD,20)); //set font of text
        itemPrice.setHorizontalAlignment(JLabel.LEFT);
        itemPrice.setBackground(Color.black); //set background color
	itemPrice.setOpaque(false); //display background color
       //Product Price: TF
        priceTF = new JTextField();
        priceTF.setPreferredSize(new Dimension(330,25));
        priceTF.setFont(new Font("Consolas",Font.PLAIN,20));
        priceTF.setForeground(new Color(179,180,189));
        priceTF.setBackground(Color.black);
        priceTF.setCaretColor(Color.white);
        priceTF.setBorder(border);
        priceTF.setText("Price");
       //Add Components to Frame
        addPanel.add(itemPrice);
        addPanel.add(priceTF);
        
       //Product QTY: Label
        JLabel itemQuantity = new JLabel("Product Quantity: ");
        itemQuantity.setHorizontalTextPosition(JLabel.LEFT); 
        itemQuantity.setForeground(new Color(0x00FF00)); 
        itemQuantity.setFont(new Font("MV Boli",Font.BOLD,20)); 
        itemQuantity.setHorizontalAlignment(JLabel.LEFT);
        itemQuantity.setBackground(Color.black); 
	itemQuantity.setOpaque(false); 
       //Product QTY: TF
        quantityTF = new JTextField();
        quantityTF.setPreferredSize(new Dimension(310,25));
        quantityTF.setFont(new Font("Consolas",Font.PLAIN,20));
        quantityTF.setForeground(new Color(179,180,189));
        quantityTF.setBackground(Color.black);
        quantityTF.setCaretColor(Color.white);
        quantityTF.setBorder(border);
        quantityTF.setText("Quantity");
       //Add Components to Frame
        addPanel.add(itemQuantity);
        addPanel.add(quantityTF);
       
       //Buttons:
        btn7 = new JButton("Back");
        generateButton(btn7);
        btn7.setVerticalTextPosition(JButton.BOTTOM);
        
        btn8 = new JButton("Submit");
        generateButton(btn8);
        btn8.setVerticalTextPosition(JButton.BOTTOM);
        
        
        bg.add(addPanel);
        bg.add(btn7);
        bg.add(btn8);
        
        
       // addFrame.pack();
    }
    
    void newWindowRemove(GUI removeFrame){
           JLabel bg = new JLabel(); 
        bg.setLayout(new FlowLayout(FlowLayout.LEADING,10,10));
        bg.setIcon(bgIcon);
        
        removeFrame.add(bg);
        
        JPanel addPanel = new JPanel();
        addPanel.setLayout(new GridLayout(3,1,-180,0));
        
       //Product Name: Label
        JLabel itemName = new JLabel("Product Name: ");
        itemName.setHorizontalTextPosition(JLabel.LEFT); //set text LEFT,CENTER, RIGHT of imageicon
        itemName.setForeground(new Color(0x00FF00)); //set font color of text
        itemName.setFont(new Font("MV Boli",Font.BOLD,20)); //set font of text
        itemName.setHorizontalAlignment(JLabel.LEFT);
        itemName.setBackground(Color.cyan); //set background color
	itemName.setOpaque(false); //display background color
       //Product Name: TF
        nameTF = new JTextField();
        nameTF.setPreferredSize(new Dimension(390,25));
        nameTF.setFont(new Font("Consolas",Font.PLAIN,20));
        nameTF.setForeground(new Color(179,180,189));
        nameTF.setBackground(Color.black);
        nameTF.setCaretColor(Color.white);
        nameTF.setBorder(border);
        nameTF.setText("Name");
        //nameTF.setVisible(true);
       //Add Components to Frame
        addPanel.add(itemName);
        addPanel.add(nameTF);
        //addPanel.setVisible(true);
        
       
       
       //Buttons:
        btn7 = new JButton("Back");
        generateButton(btn7);
        btn7.setVerticalTextPosition(JButton.BOTTOM);
        
        btn9 = new JButton("Remove");
        generateButton(btn9);
        btn9.setVerticalTextPosition(JButton.BOTTOM);
        
        
        bg.add(addPanel);
        
        bg.add(btn9);
        bg.add(btn7);
    }
    
    void newWindowUpdate(GUI updateFrame){
       // addFrame.setLayout(new FlowLayout(FlowLayout.LEADING,10,10));
        
        JLabel bg = new JLabel(); 
        bg.setLayout(new FlowLayout(FlowLayout.LEADING,10,10));
        bg.setIcon(bgIcon);
        
        updateFrame.add(bg);
        
        JPanel addPanel = new JPanel();
        addPanel.setLayout(new GridLayout(3,1,-180,0));
        
       //Product Name: Label
        JLabel itemName = new JLabel("Product Name: ");
        itemName.setHorizontalTextPosition(JLabel.LEFT); //set text LEFT,CENTER, RIGHT of imageicon
        itemName.setForeground(new Color(0x00FF00)); //set font color of text
        itemName.setFont(new Font("Comic Sans",Font.BOLD,20)); //set font of text
        itemName.setHorizontalAlignment(JLabel.LEFT);
        itemName.setBackground(Color.cyan); //set background color
	itemName.setOpaque(false); //display background color
       //Product Name: TF
        nameTF = new JTextField();
        nameTF.setPreferredSize(new Dimension(390,25));
        nameTF.setFont(new Font("Consolas",Font.PLAIN,20));
        nameTF.setForeground(new Color(179,180,189));
        nameTF.setBackground(Color.black);
        nameTF.setCaretColor(Color.white);
        nameTF.setBorder(border);
        nameTF.setText("Name");
        //nameTF.setVisible(true);
       //Add Components to Frame
        addPanel.add(itemName);
        addPanel.add(nameTF);
        //addPanel.setVisible(true);
        
       //Product QTY: Label
        JLabel itemQuantity = new JLabel("Product Quantity: ");
        itemQuantity.setHorizontalTextPosition(JLabel.LEFT); //set text LEFT,CENTER, RIGHT of imageicon
        itemQuantity.setForeground(new Color(0x00FF00)); //set font color of text
        itemQuantity.setFont(new Font("Comic Sans",Font.BOLD,20)); //set font of text
        itemQuantity.setHorizontalAlignment(JLabel.LEFT);
        itemQuantity.setBackground(Color.black); //set background color
	itemQuantity.setOpaque(false); //display background color
       //Product QTY: TF
        quantityTF = new JTextField();
        quantityTF.setPreferredSize(new Dimension(310,25));
        quantityTF.setFont(new Font("Consolas",Font.PLAIN,20));
        quantityTF.setForeground(new Color(179,180,189));
        quantityTF.setBackground(Color.black);
        quantityTF.setCaretColor(Color.white);
        quantityTF.setBorder(border);
        quantityTF.setText("Quantity");
       //Add Components to Frame
        addPanel.add(itemQuantity);
        addPanel.add(quantityTF);
       
       //Buttons:
        btn7 = new JButton("Back");
        generateButton(btn7);
        btn7.setVerticalTextPosition(JButton.BOTTOM);
        
        btn10 = new JButton("Update");
        generateButton(btn10);
        btn10.setVerticalTextPosition(JButton.BOTTOM);
        
        
        bg.add(addPanel);
        bg.add(btn7);
        bg.add(btn10);
        
        
       // addFrame.pack();
    }
    
    void newWindowSort(GUI sortFrame) {
    
    JLabel bg = new JLabel();
    bg.setLayout(new BorderLayout());
    bg.setIcon(bgIcon); 
   
    sortFrame.getContentPane().setBackground(Color.WHITE);

    JPanel addPanel = new JPanel();
    addPanel.setLayout(new GridLayout(6, 1, 10, 10)); 

    // Sort by option - Label
    JLabel sortByLabel = new JLabel("Sort By: ");
    sortByLabel.setHorizontalTextPosition(JLabel.LEFT);
    sortByLabel.setForeground(new Color(0x00FF00)); 
    sortByLabel.setFont(new Font("Comic Sans", Font.BOLD, 20));
    sortByLabel.setHorizontalAlignment(JLabel.LEFT);
    sortByLabel.setBackground(Color.cyan);
    sortByLabel.setOpaque(true); 

    // Sort by options - ComboBox (Name, Price, Quantity)
    String[] sortOptions = {"Name", "Price", "Quantity"};
    sortByCB = new JComboBox<>(sortOptions);
    sortByCB.setFont(new Font("Consolas", Font.PLAIN, 20));
    sortByCB.setPreferredSize(new Dimension(200, 30));

    // Add Sort By components
    addPanel.add(sortByLabel);
    addPanel.add(sortByCB);

    // Sort order options - ascending / descending (Checkbox)
    JLabel orderLabel = new JLabel("Sort Order: ");
    orderLabel.setFont(new Font("Comic Sans", Font.BOLD, 20));
    orderLabel.setForeground(new Color(0x00FF00));

    ascCheckBox = new JCheckBox("Ascending", true);
    ascCheckBox.setFont(new Font("Consolas", Font.PLAIN, 20));
    ascCheckBox.setForeground(new Color(0x00FF00));

    dscCheckBox = new JCheckBox("Descending");
    dscCheckBox.setFont(new Font("Consolas", Font.PLAIN, 20));
    dscCheckBox.setForeground(new Color(0x00FF00));

    JPanel orderPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
    orderPanel.add(ascCheckBox);
    orderPanel.add(dscCheckBox);

    addPanel.add(orderLabel);
    addPanel.add(orderPanel);

    btn7 = new JButton("Back");
    generateButton(btn7); 
    btn7.setVerticalTextPosition(JButton.BOTTOM);

    btn11 = new JButton("Sort");
    generateButton(btn11);
    btn11.setVerticalTextPosition(JButton.BOTTOM);

    addPanel.add(btn7);
    addPanel.add(btn11);

    // Create JTextArea to display the sorted products
    productArea = new JTextArea();
    productArea.setFont(new Font("Consolas", Font.PLAIN, 16));
    productArea.setEditable(false);
    JScrollPane scrollPane = new JScrollPane(productArea);
    scrollPane.setPreferredSize(new Dimension(500, 300));

    // Create a panel to hold the scrollPane and add it to the background
    JPanel displayPanel = new JPanel();
    displayPanel.add(scrollPane);

    bg.add(addPanel, BorderLayout.NORTH);  
    bg.add(displayPanel, BorderLayout.CENTER); 
    sortFrame.setLayout(new BorderLayout());
    sortFrame.setSize(800, 600);

    bg.setBounds(0, 0, sortFrame.getWidth(), sortFrame.getHeight());
    sortFrame.add(bg);

    bg.setVisible(true);
    addPanel.setVisible(true);
    displayPanel.setVisible(true);
    sortFrame.setVisible(true);  

    // Handle sort button when clickEd
    btn11.addActionListener(e -> {
        String sortBy = (String) sortByCB.getSelectedItem();
        boolean ascending = ascCheckBox.isSelected();
        boolean descending = dscCheckBox.isSelected();
        
        if (descending) {
            ascending = false;  // If descending is selected, ascending -> disabled
        }

        Products.displaySortedProducts(sortBy, ascending ? "ASC" : "DESC", productArea);
    });

    // Back button action (close or navigate to previous screen)
    btn7.addActionListener(e -> {
        sortFrame.dispose();
    });
}
    
    void newWindowDisplay(GUI displayFrame) {
        displayFrame.setLayout(new BorderLayout());
        displayFrame.setSize(800, 600);
        displayFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        displayFrame.setVisible(true);

        // bg label
        JLabel bg = new JLabel();
        bg.setLayout(new BorderLayout());  
        displayFrame.add(bg);
        
        // textArea --> displaying products
        productArea = new JTextArea();
        productArea.setEditable(false);
        productArea.setFont(new Font("Consolas", Font.PLAIN, 16));

        JScrollPane scrollPane = new JScrollPane(productArea);
        displayFrame.add(scrollPane, BorderLayout.CENTER);

        Products.displayAllProducts(productArea); 
        displayFrame.setVisible(true);
    }


    void generateButton(JButton btn){

        btn.addActionListener(this);
        btn.setFocusable(false);
        //btn.setIcon(btnIcon1);
        btn.setFont(new Font("Comic Sans",Font.BOLD,20));
        btn.setIconTextGap(3);
        btn.setVisible(true);
        //btn.setBorder(BorderFactory.createBevelBorder(12, Color.BLUE, Color.black));
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource() == btn1){
            addProductsGUI = new GUI("Add Products");
            addProductsGUI.newWindowAdd(addProductsGUI);
            System.out.println("item added");
        }
        else if(ae.getSource() == btn2){
            removeProductsGUI = new GUI("Remove Products");
            removeProductsGUI.newWindowRemove(removeProductsGUI);
            System.out.println("item removed");
        }
        else if(ae.getSource() == btn3){
            updateProductsGUI = new GUI("Update Quantity");
            updateProductsGUI.newWindowUpdate(updateProductsGUI);
            System.out.println("item updated");
        }
        else if(ae.getSource() == btn4){
            sortProductsGUI = new GUI("Sort");
            sortProductsGUI.newWindowSort(sortProductsGUI);
            System.out.println("item sorted");
        }
        else if (ae.getSource() == btn5) {
        // Create a new display window
        displayProductsGUI = new GUI("Display");
        displayProductsGUI.newWindowDisplay(displayProductsGUI); 
        System.out.println("item displayed");
         }
        else if (ae.getSource() == btn6) {
            double totalCost = Products.calculateTotalInventoryCost();
            JOptionPane.showMessageDialog(null, "Total Inventory Cost: " + totalCost, "Total Cost", JOptionPane.INFORMATION_MESSAGE);
            System.out.println("Item total calculated");
        }
        else if (ae.getSource() == btn7) {
            dispose();
	}
        else if (ae.getSource() == btn8) {
            String name = nameTF.getText();
            //System.out.println("name:"+nameTF.getText());
            
       // Exception Handling for name
            exceptionHandling(name, 1);
       // Exception Handling for price     
            String price = priceTF.getText(); 
            exceptionHandling(price, 2);
            double pri = Double.parseDouble(price);
        // Exception Handling for qty    
            String quantity = quantityTF.getText();
            //System.out.println("quantity:"+quantityTF.getText());
            exceptionHandling(quantity, 3);
            int qty = Integer.parseInt(quantity);
            
            Products.insertProductToDatabase(name, pri, qty);
           // Products.addProducts(name, pri, qty);  //method call in products class
			
	}
        else if(ae.getSource() == btn9){
            String name = nameTF.getText();
            boolean result = Products.removeProduct(name);

            // Show a message :
            if (result) {
                JOptionPane.showMessageDialog(null, "Product '" + name + "' deleted successfully.");
            } else {
                JOptionPane.showMessageDialog(null, "No product found with the name '" + name + "'.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
        else if (ae.getSource() == btn10) {
            String name = nameTF.getText();
            exceptionHandling(name, 1);
            
            if (quantityTF.isEnabled()) {
                String quantity = quantityTF.getText();
                exceptionHandling(quantity, 3);

                int qty = Integer.parseInt(quantity);

                Products.updateProductQuantity(name, qty);
            }   
        }
        else if(ae.getSource() == btn11) {
            // Retrieve
            String sortBy = (String) sortByCB.getSelectedItem();  //Name, Price, Quantity

            boolean ascending = ascCheckBox.isSelected();  
            boolean descending = dscCheckBox.isSelected();  

            // If both checkboxes are selected -> desending will be done
            if (descending) {
                ascending = false;
            }
            System.out.println("Sort button clicked: Sorting by " + sortBy + " in " + (ascending ? "ascending" : "descending") + " order.");
            Products.displaySortedProducts(sortBy, ascending ? "ASC" : "DESC", productArea);
        }

       
    }
    
    void exceptionHandling(String name, int p){
            // Exception Handling: name
        if(p ==1){
            try {
            if (name == null) {
                throw new Exception("Error: Name is null.");
            } 
            if (name.equals("Name")) {
                throw new Exception("Error: Name cannot be 'Name'.");
            }
           if (name.charAt(0) == ' ' || name.charAt(name.length() - 1) == ' ') {
                throw new Exception("Error: Name should not start or end with a space.");
            } 
            if (name.length() < 3 || name.length() > 30) {
                throw new Exception("Error: Name should be between 3 and 30 characters.");
             } 
            if (!(name.charAt(0) >= 'A' && name.charAt(0) <= 'Z')) {
                throw new Exception("Error: The first letter should be an uppercase letter (A-Z).");
            } 
            for (int i = 0; i < name.length() - 1; i++) {
                if (name.charAt(i) == ' ' && name.charAt(i + 1) == ' ') {
                    throw new Exception("Error: Name should not contain consecutive spaces.");
                }
            }
            quantityTF.setEnabled(true);

            //JOptionPane.showMessageDialog(null, "Name: " + name + " is valid!");

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e.getMessage(), "Validation Error", JOptionPane.ERROR_MESSAGE);
                quantityTF.setEnabled(false);
            }
        }
        else if(p == 2){
            try {
                double price = Double.parseDouble(name);
                if (price <= 0) {
                    JOptionPane.showMessageDialog(null, "Error: Price must be greater than zero", 
                                                  "Invalid Price", JOptionPane.ERROR_MESSAGE);
                } else {
                    //JOptionPane.showMessageDialog(null, "Price entered: " + price);
                }
            } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Error: Enter only valid numbers (integers or floats)", 
                                          "Invalid Input", JOptionPane.ERROR_MESSAGE);
            }
        }
        else{
            try {
                if (name == null) {
                    throw new Exception("Error: Quantity is null.");
                }

                int quantity = Integer.parseInt(name);

                if (quantity <= 0) {
                    throw new Exception("Error: Quantity cannot be zero or negative.");
                }

                if (quantity > 1000000) {
                 throw new Exception("Error: Quantity cannot be greater than 1,000,000.");
                }

            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Error: Please enter a valid integer.", "Validation Error", JOptionPane.ERROR_MESSAGE);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e.getMessage(), "Validation Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    
}
