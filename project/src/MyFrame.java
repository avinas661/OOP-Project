import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

class MyFrame extends JFrame {

    public MyFrame() {

        // Set up the main frame window
        setTitle("Registration Form");
        setResizable(false);    // Window cannot be resized
        setBounds(20,20,1200,800);  // Window position and size
        getContentPane().setLayout(null);   // Using no layout manager
        setDefaultCloseOperation(EXIT_ON_CLOSE);    // Close operation

        // Title Label for registration form
        JLabel formLable = new JLabel("Registration Form");
        jlablestyle(formLable,400,20,400,50,40);

        // Name Label and Text Field
        JLabel nameLable = new JLabel("Name");
        jlablestyle(nameLable,125,100,100,30,30);

        JTextField nameTextField = new JTextField();
        jtfeildstyle(nameTextField,250,100,275,25,15);

        // Display Area (to show output on Submit)
        JTextArea displayArea = new JTextArea();
        jtareastyle(displayArea,675,100,400,550,20);

        // Mobile Label and Text Field
        JLabel mobileLable = new JLabel("Mobile");
        jlablestyle(mobileLable,125,170,100,30,30);

        JTextField mobileTextField = new JTextField();
        jtfeildstyle(mobileTextField,250,170,200,25,15);

        // Gender Label and Radio Buttons
        JLabel genderLable = new JLabel("Gender");
        jlablestyle(genderLable,125,240,100,30,30);

        JRadioButton male = new JRadioButton("Male");
        male.setSelected(true);
        jrbuttonstyle(male,250,240,100,30,20);

        JRadioButton female = new JRadioButton("Female");
        jrbuttonstyle(female,350,240,100,30,20);

        // Grouping gender radio buttons
        ButtonGroup gender = new ButtonGroup();
        gender.add(male);
        gender.add(female);

        // Date of Birth Section: Day / Month / Year ComboBoxes
        JLabel dobLable = new JLabel("DOB");
        jlablestyle(dobLable,125,310,100,30,30);

        String[] days = {"1","2","3","4","5","6","7","8","9","10",
                "11","12","13","14","15","16","17","18","19","20",
                "21","22","23","24","25","26","27","28","29","30","31"};
        JComboBox<String> daycombo = new JComboBox<>(days);
        jcboxstyle(daycombo,250,310,50,30,20);


        String[] months = {"Jan","Feb","Mar","Apr","May","Jun","Jul","Aug","Sep","Oct","Nov","Dec",};
        JComboBox<String> monthcombo = new JComboBox<>(months);
        jcboxstyle(monthcombo,300,310,70,30,20);

        String[] years = {"1918","1995","1996","1997","1998","1999","2001",
                "2002","2003","2004","2005","2006","2007","2008","2009",
                "2010","2011","2012","2013","2014","2015","2016","2017","2018","2019"};
        JComboBox<String> yearcombo = new JComboBox<>(years);
        jcboxstyle(yearcombo,375,310,70,30,20);

        // Address Label and TextArea
        JLabel AddressLable = new JLabel("Address");
        jlablestyle(AddressLable,125,380,150,30,30);

        JTextArea addressArea = new JTextArea();
        jtareastyle(addressArea,250,380,250,100,20);

        // Checkbox for Terms and Conditions
        JCheckBox checkBox = new JCheckBox("Accept Terms And Conditions.");
        checkBox.setFont(new Font("Arial",Font.PLAIN,20));
        checkBox.setBounds(200,520,400,20);
        add(checkBox);

        // Submit and Reset Buttons
        JButton submitbutton = new JButton("Submit");
        jbuttonstyle(submitbutton,200,590,125,25,20);

        JButton resetbutton = new JButton("Reset");
        jbuttonstyle(resetbutton,350,590,125,25,20);

        // Label to show term and condtions clicked messages
        JLabel errorLable = new JLabel("");
        jlablestyle(errorLable,150,660,550,30,30);

        // Action listener for Submit button
        submitbutton.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {

                // Get all input values
                String name = nameTextField.getText();
                String mobile = mobileTextField.getText();
                String Gender = male.isSelected() ? "Male" : "Female";
                String day = (String) daycombo.getSelectedItem();
                String month = (String) monthcombo.getSelectedItem();
                String year = (String) yearcombo.getSelectedItem();
                String add = addressArea.getText();

                // If checkbox is selected, show the info
                if (checkBox.isSelected()){
                    errorLable.setText("Registration Successfully..");
                    displayArea.setText("Name : "+name+"\nMobile : "+mobile+
                            "\nGender : "+Gender+"\nDOB : "+day+"/"+month+"/"+year+"\nAddress : "+add);
                }
                else {
                    // Show error if terms not accepted
                    errorLable.setText("Please accept the terms & conditions..");
                }
            }
        });

        // Action listener for Reset button
        resetbutton.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Clear all fields and reset to default
                nameTextField.setText("");
                mobileTextField.setText("");
                male.setSelected(true);
                daycombo.setSelectedItem("1");
                monthcombo.setSelectedItem("Jan");
                yearcombo.setSelectedItem("1995");
                addressArea.setText("");
                checkBox.setSelected(false);
                errorLable.setVisible(false);
                displayArea.setText("");
            }
        });
    }

    // Styling Helper Methods

    // Style and place a JLabel
    void jlablestyle (JLabel label,int x, int y, int width, int height,int fsize){
        label.setFont(new Font("Arial",Font.PLAIN,fsize));
        label.setBounds(x,y,width,height);
        add(label);
    }
    // Style and place a JTextField
    void jtfeildstyle (JTextField feild,int x, int y, int width, int height,int fsize){
        feild.setFont(new Font("Arial",Font.PLAIN,fsize));
        feild.setBounds(x,y,width,height);
        add(feild);
    }
    // Style and place a JTextArea
    void jtareastyle (JTextArea area,int x, int y, int width, int height,int fsize){
        area.setFont(new Font("Arial",Font.PLAIN,fsize));
        area.setBounds(x,y,width,height);
        add(area);
    }
    // Style and place a JRadioButton
    void jrbuttonstyle (JRadioButton radio,int x, int y, int width, int height,int fsize){
        radio.setFont(new Font("Arial",Font.PLAIN,fsize));
        radio.setBounds(x,y,width,height);
        add(radio);
    }
    // Style and place a JComboBox
    void jcboxstyle (JComboBox box,int x, int y, int width, int height,int fsize){
        box.setFont(new Font("Arial",Font.PLAIN,fsize));
        box.setBounds(x,y,width,height);
        add(box);
    }
    // Style and place a JButton
    void jbuttonstyle (JButton button ,int x, int y, int width, int height,int fsize){
        button.setFont(new Font("Arial",Font.PLAIN,fsize));
        button.setBounds(x,y,width,height);
        add(button);
    }
}
