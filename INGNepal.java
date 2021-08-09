
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import java.awt.Font;
import java.util.ArrayList;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.KeyEvent;
//import java.awt.event.KeyListener;

/**
 * Description of class INGNepal.
 * This class creates a User interative GUI to add Vacancy and  Appoint Staff  for both 
 * Full time and Part time Staff and 
 * also to Terminate PartTime Staff
 * @author (Dikshyanta Mulmi)
 * @version (3/15/2020)
 */

public class INGNepal implements ActionListener//,KeyListener
{
    // Declaring private Instance Variable
    private JFrame frame;
    private JLabel lblMain;
    private JButton btnAddVacFullTime;
    private JButton btnAddVacPartTime;
    private JButton btnTerminate;

    private JLabel lblVacancyNumber;
    private JTextField txtVacancyNumber;
    private JLabel lblDesignation;
    private JTextField txtDesignation;
    private JLabel lblJobType;
    private JTextField txtJobType;
    private JLabel lblSalary;
    private JTextField txtSalary;
    private JLabel lblWorkingHours;
    private JTextField txtWorkingHours;
    private JButton btnAddFullStaff;
    private JButton btnAddPost;

    private JLabel lblAptVacancyNumber;
    private JComboBox<String> availability;
    //these array list are created just to extend the items in the JComboBox by converting them to array
    private static ArrayList<String> availableFull = new ArrayList<String>();
    private static ArrayList<String> availablePart = new ArrayList<String>();  

    private JLabel lblStaffName;
    private JTextField txtStaffName;

    private JLabel lblJoiningDate;
    private JComboBox<String> dateDay;
    private String[] day = {"","1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31","32"};
    private JComboBox<String> dateMonth;
    private String[] month = {"","January","February","March","April","May","June","July","August","September","October","November","December"};
    private JComboBox<String> dateYear;
    private String[] year = {"","2017","2018","2019","2020","2021","2022","2023","2024","2025"};

    private JLabel lblQualification;
    private JTextField txtQualification;
    private JLabel lblAppointedBy;
    private JTextField txtAppointedBy;
    private JButton btnDisplay;
    private JButton btnAppoint;
    private JButton btnClear;

    private JLabel lblWagesPerHour;
    private JTextField txtWagesPerHour;    
    private JLabel lblShift;
    private JTextField txtShift;

    private JLabel lblTermVacancyNumber;
    private JButton btnTermination;

    private JComboBox<String> availableTermination;
    private static ArrayList<String> availableTerm = new ArrayList<String>();  

    private StaffHire obj;

    private FullTimeStaffHire fullTimeStaffHire;
    private PartTimeStaffHire partTimeStaffHire;

    private static ArrayList<StaffHire> storeStaffHire = new ArrayList<StaffHire>();

    private JMenuBar menuBar;
    private JMenu menuFile;
    private JMenu menuView;

    private JMenuItem menuItmAdd;
    private JMenuItem menuItmAppoint;
    private JMenuItem menuItmClear;
    private JMenuItem menuItmClose;
    private JMenuItem menuItmAbout;
    private JMenuItem menuItmDetails;

    private JButton btnRecordPartTime;
    private JButton btnRecordFullTime;
    private JButton btnAllRecords;

    //getter method which returns String from JTextField txtVacancyNumber
    public String getTxtVacancyNumber(){
        return txtVacancyNumber.getText();
    }

    //getter method which returns String from JTextField txtDesignation
    public String getTxtDesignation(){
        return txtDesignation.getText();
    }

    //getter method which returns String from JTextField txtJobType
    public String getTxtJobType(){
        return txtJobType.getText();
    }

    //getter method which returns String from JTextField txtSalary
    public String getTxtSalary(){
        return txtSalary.getText();
    }

    //getter method which returns String from JTextField txtWorkingHours
    public String getTxtWorkingHours(){
        return txtWorkingHours.getText();
    }

    //getter method which returns String from JTextField txtStaffName
    public String getTxtStaffName(){
        return txtStaffName.getText();
    }

    //getter method which returns String from JTextField txtQualification
    public String getTxtQualification(){
        return txtQualification.getText();
    }

    //getter method which returns String from JTextField txtAppointedBy
    public String getTxtAppointedBy(){
        return txtAppointedBy.getText();
    }

    //getter method which returns String from JTextField txtWagesPerHour
    public String getTxtWagesPerHour(){
        return txtWagesPerHour.getText();
    }

    //getter method which returns String from JTextField txt
    public String getTxtShift(){
        return txtShift.getText();
    }

    //Constructor of Class INGNepal
    public INGNepal() {
        frame = new JFrame("Home");
        addComponents();
        frame.setResizable(false);
        frame.setSize(910, 530);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        frame.setVisible(true);

    }

    //Method to add JComponent to the Main JFrame
    public void addComponents() {

        lblMain = new JLabel("Options");
        lblMain.setBounds(0,0,890,60);
        lblMain.setFont(new Font("SansSerif",Font.BOLD,30));
        lblMain.setHorizontalAlignment(JLabel.CENTER);
        frame.add(lblMain);

        addNavigation();

    }

    //Method to add Navigation JButton in the Main JFrame
    public void addNavigation() {

        btnAddVacFullTime = new JButton("Add Vacancy for Full Time Staff / Appoint Full Time Staff");
        btnAddVacFullTime.setBounds(40,80,810,80);
        btnAddVacFullTime.setFont(new Font("SansSerif",Font.BOLD,20));
        btnAddVacFullTime.addActionListener(this);
        frame.add(btnAddVacFullTime);

        btnAddVacPartTime = new JButton("Add Vacancy for Part Time Staff / Appoint Part Time Staff");
        btnAddVacPartTime.setBounds(40,180,810,80);
        btnAddVacPartTime.setFont(new Font("SansSerif",Font.BOLD,20));
        btnAddVacPartTime.addActionListener(this);
        frame.add(btnAddVacPartTime);

        btnRecordFullTime = new JButton("Records of Full Time Staff");
        btnRecordFullTime.setBounds(40,280,400,80);
        btnRecordFullTime.setFont(new Font("SansSerif",Font.BOLD,20));
        btnRecordFullTime.addActionListener(this);
        frame.add(btnRecordFullTime);

        btnRecordPartTime = new JButton("Records of Part Time Staff");
        btnRecordPartTime.setBounds(450,280,400,80);
        btnRecordPartTime.setFont(new Font("SansSerif",Font.BOLD,20));
        btnRecordPartTime.addActionListener(this);
        frame.add(btnRecordPartTime);

        btnTerminate = new JButton("Terminate Part Time Staff");
        btnTerminate.setBounds(40,380,400,80);
        btnTerminate.setFont(new Font("SansSerif",Font.BOLD,20));
        btnTerminate.addActionListener(this);
        frame.add(btnTerminate);

        btnAllRecords = new JButton("Display(All Records)");
        btnAllRecords.setBounds(450,380,400,80);
        btnAllRecords.setFont(new Font("SansSerif",Font.BOLD,20));
        btnAllRecords.addActionListener(this);
        frame.add(btnAllRecords);

    }

    // Main Method of Class INGNepal
    public static void main(String args[]){

        //creating Object of Class INGNepal by calling its Constructor
        new INGNepal();

        availableFull.add("");
        availablePart.add("");
        availableTerm.add("");

    }

    // Creating JMenuBar 
    public void addMenuBar(){
        menuBar = new JMenuBar();

        menuFile = new JMenu("File");
        menuView = new JMenu("View");

        menuItmAdd = new JMenuItem("Add");
        menuItmAdd.addActionListener(this);
        menuItmAppoint = new JMenuItem("Appoint");
        menuItmAppoint.addActionListener(this);
        menuItmClear = new JMenuItem("Clear");
        menuItmClear.addActionListener(this);
        menuItmClose = new JMenuItem("Close");
        menuItmClose.addActionListener(this);

        menuItmAbout = new JMenuItem("About");
        menuItmAbout.addActionListener(this);
        menuItmDetails = new JMenuItem("Details");
        menuItmDetails.addActionListener(this);

        menuFile.add(menuItmAdd);
        menuFile.add(menuItmAppoint);
        menuFile.add(menuItmClear);
        menuFile.add(menuItmClose);

        menuView.add(menuItmAbout);
        menuView.add(menuItmDetails);

        menuBar.add(menuFile);
        menuBar.add(menuView);

        frame.setJMenuBar(menuBar);
    }

    // Creating a JFrame to Add or Appoint Fulltime Staff
    public void addFullTimeStaff() {
        frame = new JFrame("Add Full Time Staff");
        lblMain = new JLabel("Add Vacancy for Full Time Staff");
        lblMain.setBounds(0,0,800,60);
        lblMain.setFont(new Font("SansSerif",Font.BOLD,20));
        lblMain.setHorizontalAlignment(JLabel.CENTER);
        frame.add(lblMain);

        addMenuBar();
        addInputFields();

        lblSalary = new JLabel("Salary:");
        lblSalary.setBounds(490,80,60,30);
        frame.add(lblSalary);

        txtSalary = new JTextField();
        txtSalary.setBounds(540,80,230,25);
        // txtSalary.addKeyListener(this);
        frame.add(txtSalary);

        btnAddPost = new JButton("Add");
        btnAddPost.setBounds(600,170,170,40);
        btnAddPost.addActionListener(this);
        frame.add(btnAddPost);

        frame.setResizable(false);
        frame.setSize(800, 530);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setLayout(null);
        frame.setVisible(true);

    }

    //Creating Method to Appoint a Staff
    public void appointStaff() {

        lblAptVacancyNumber = new JLabel("Vacancy Number:");
        lblAptVacancyNumber.setBounds(30,250,120,30);
        frame.add(lblAptVacancyNumber);

        if(isTitle("Full")) availability = new JComboBox<String>(getStringArray(availableFull));
        else if(isTitle("Part")) availability = new JComboBox<String>(getStringArray(availablePart));
        availability.setBounds(140,250,230,25);
        frame.add(availability);

        lblStaffName = new JLabel("Staff Name:");
        lblStaffName.setBounds(465,250,100,30);
        frame.add(lblStaffName);

        txtStaffName = new JTextField();
        txtStaffName.setBounds(540,250,230,25);
        frame.add(txtStaffName);

        lblJoiningDate = new JLabel("Joining Date:");
        lblJoiningDate.setBounds(55,290,120,30);
        frame.add(lblJoiningDate);

        dateDay = new JComboBox<String>(day);
        dateDay.setBounds(140,290,55,25);
        frame.add(dateDay);

        dateMonth = new JComboBox<String>(month);
        dateMonth.setBounds(200,290,95,25);
        frame.add(dateMonth);

        dateYear = new JComboBox<String>(year);
        dateYear.setBounds(300,290,70,25);
        frame.add(dateYear);

        lblQualification = new JLabel("Qualification:");
        lblQualification.setBounds(455,290,150,30);
        frame.add(lblQualification);

        txtQualification = new JTextField();
        txtQualification.setBounds(540,290,230,25);
        frame.add(txtQualification);

        lblAppointedBy = new JLabel("Appointed By:");
        lblAppointedBy.setBounds(50,330,120,30);
        frame.add(lblAppointedBy);

        txtAppointedBy = new JTextField();
        txtAppointedBy.setBounds(140,330,230,25);
        frame.add(txtAppointedBy);

        btnAppoint = new JButton("Appoint");
        btnAppoint.setBounds(600,330,170,40);
        btnAppoint.addActionListener(this);
        frame.add(btnAppoint);

        btnDisplay = new JButton("Display");
        btnDisplay.setBounds(30,380,170,40);
        btnDisplay.addActionListener(this);
        frame.add(btnDisplay);

        btnClear = new JButton("Clear");
        btnClear.setBounds(600,400,170,40);
        btnClear.addActionListener(this);
        frame.add(btnClear);

    }

    //Creating common InputFields to add to the JFrame
    public void addInputFields(){

        lblVacancyNumber = new JLabel("Vacancy Number:");
        lblVacancyNumber.setBounds(30,80,120,30);
        frame.add(lblVacancyNumber);

        txtVacancyNumber = new JTextField();
        txtVacancyNumber.setBounds(140,80,230,25);
        // txtVacancyNumber.addKeyListener(this);
        frame.add(txtVacancyNumber);

        lblDesignation = new JLabel("Designation:");
        lblDesignation.setBounds(60,120,80,30);
        frame.add(lblDesignation);

        txtDesignation = new JTextField();
        txtDesignation.setBounds(140,120,230,25);
        frame.add(txtDesignation);

        lblJobType = new JLabel("Job Type:");
        lblJobType.setBounds(75,160,60,30);
        frame.add(lblJobType);

        if(isTitle("Full")) txtJobType = new JTextField("Full Time");
        else if(isTitle("Part")) txtJobType = new JTextField("Part Time");
        txtJobType.setBounds(140,160,230,25);
        txtJobType.setEditable(false);
        frame.add(txtJobType);

        lblWorkingHours = new JLabel("Working Hours:");
        lblWorkingHours.setBounds(445,120,150,30);
        frame.add(lblWorkingHours);

        txtWorkingHours = new JTextField();
        txtWorkingHours.setBounds(540,120,230,25);
        // txtWorkingHours.addKeyListener(this);
        frame.add(txtWorkingHours);  

    }

    //Creating JFrame to add or appoint PartTime Staff
    public void addPartTimeStaff() {

        frame = new JFrame("Add Part Time Staff");

        lblMain = new JLabel("Add Vacancy for Part Time Staff");
        lblMain.setBounds(0,0,800,60);
        lblMain.setFont(new Font("SansSerif",Font.BOLD,20));
        lblMain.setHorizontalAlignment(JLabel.CENTER);
        frame.add(lblMain);

        addMenuBar();
        addInputFields();

        lblWagesPerHour = new JLabel("Wages Per Hour:");
        lblWagesPerHour.setBounds(435,80,140,30);
        frame.add(lblWagesPerHour);

        txtWagesPerHour = new JTextField();
        txtWagesPerHour.setBounds(540,80,230,25);
        // txtWagesPerHour.addKeyListener(this);
        frame.add(txtWagesPerHour);

        lblShift = new JLabel("Shift:");
        lblShift.setBounds(505,160,50,30);
        frame.add(lblShift);

        txtShift = new JTextField();
        txtShift.setBounds(540,160,230,25);
        frame.add(txtShift);

        btnAddPost = new JButton("Add");
        btnAddPost.setBounds(600,195,170,40);
        btnAddPost.addActionListener(this);
        frame.add(btnAddPost);

        frame.setResizable(false);
        frame.setSize(800, 530);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setLayout(null);
        frame.setVisible(true);

    }

    // Method to retrieve day, month and year appointed and concatenate them together
    public String dateManipulator(){
        if(isNullOrEmpty(dateDay.getSelectedItem().toString()) || isNullOrEmpty(dateMonth.getSelectedItem().toString()) || isNullOrEmpty(dateYear.getSelectedItem().toString())){
            return null;
        }
        return dateDay.getSelectedItem().toString()+" "+dateMonth.getSelectedItem().toString()+" "+dateYear.getSelectedItem().toString();
    }

    //Method to Terminate PartTime Staff
    public void addTerminator() {

        frame = new JFrame("Terminator");

        lblMain = new JLabel("Terminate Part Time Staff");
        lblMain.setBounds(0,0,450,60);
        lblMain.setFont(new Font("SansSerif",Font.BOLD,20));
        lblMain.setHorizontalAlignment(JLabel.CENTER);
        frame.add(lblMain);

        lblTermVacancyNumber = new JLabel("Vacancy Number:");
        lblTermVacancyNumber.setBounds(100,120,120,30);
        frame.add(lblTermVacancyNumber);

        availableTermination = new JComboBox<String>(getStringArray(availableTerm));
        availableTermination.setBounds(220,120,100,25);
        frame.add(availableTermination);

        btnTermination = new JButton("Terminate");
        btnTermination.setBounds(130,200,170,40);
        btnTermination.addActionListener(this);
        frame.add(btnTermination);

        frame.setResizable(false);
        frame.setSize(450, 300);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setLayout(null);
        frame.setVisible(true);

    }

    //Method to Clear all the JTextFields and reset JComboBox to default value
    public void clearInputFields(){

        txtVacancyNumber.setText("");
        txtWorkingHours.setText("");
        txtDesignation.setText("");

        availability.setSelectedIndex(0);
        txtStaffName.setText("");
        dateDay.setSelectedIndex(0);
        dateMonth.setSelectedIndex(0);
        dateYear.setSelectedItem(year[0]);
        txtQualification.setText("");
        txtAppointedBy.setText("");

    }

    //Method to check the title of the JFrame
    public boolean isTitle(String content){

        return frame.getTitle().contains(content);

    }

    //Method to Check the JobType
    public boolean isJobType(StaffHire obj,String jobType){

        return obj.getJobType().toUpperCase().contains(jobType.toUpperCase());

    }

    //OverLoading isJobType method to check the JobType
    public boolean isJobType(JTextField txtJobtype,String jobType){

        return getTxtJobType().toUpperCase().contains(jobType.toUpperCase());

    }

    //Method to check if the Vacancy Number is valid to be appointed
    public boolean isMatched(StaffHire obj,String jobType,JComboBox<String> availability){

        jobType = jobType.toUpperCase();
        if(obj.getJobType().toUpperCase().contains(jobType) && obj.getVacancyNumber()==Integer.valueOf(availability.getSelectedItem().toString())) return true;

        return false;
    }

    //Method to return the object of PartTimeStaffHire from the object of StaffHire
    public PartTimeStaffHire getPartObject(StaffHire obj){

        partTimeStaffHire = (PartTimeStaffHire) obj;
        return partTimeStaffHire;

    }

    //Method to return the object of FullTimeStaffHire from the object of StaffHire
    public FullTimeStaffHire getFullObject(StaffHire obj){

        fullTimeStaffHire = (FullTimeStaffHire) obj;
        return fullTimeStaffHire;

    }

    //Mwthod to Check whether the String is empty or Null
    public boolean isNullOrEmpty(String str) {
        if(str != null && !str.isEmpty())
            return false;
        return true;
    }

    //Method to get value in JTextField txtVacancyNumber and Validate it as well
    public int getVacNumber(){
        try{
            Integer.valueOf(getTxtVacancyNumber());
            if(Integer.valueOf(getTxtVacancyNumber()) <= 0){
                return 0;
            }else{
                return Integer.valueOf(getTxtVacancyNumber());
            }
        }catch(NumberFormatException x){
            JOptionPane.showMessageDialog(frame,"Invalid Vacancy Number (Enter a valid Number)","Verification Error",JOptionPane.ERROR_MESSAGE);
            return 0;
        }
    }

    //Method to get value in JTextField txtWorkingHours and Validate it as well
    public int getWorkHours(){
        try{
            Integer.valueOf(getTxtWorkingHours());
            if(Integer.valueOf(getTxtWorkingHours()) <= 0){
                return 0;
            }else{
                return Integer.valueOf(getTxtWorkingHours());
            }
        }catch(NumberFormatException x){
            JOptionPane.showMessageDialog(frame,"Invalid Working Hours (Enter a valid Number)","Verification Error",JOptionPane.ERROR_MESSAGE);
            return 0;
        }
    }

    //Method to get value in JTextField txtSalary and Validate it as well
    public int getSal(){
        try{
            Integer.valueOf(getTxtSalary());
            if(Integer.valueOf(getTxtSalary()) <= 0){
                return 0;
            }else{
                return Integer.valueOf(getTxtSalary());
            }
        }catch(NumberFormatException x){
            JOptionPane.showMessageDialog(frame,"Invalid Salary (Enter a valid Number)","Verification Error",JOptionPane.ERROR_MESSAGE);
            return 0;
        }
    }

    //Method to get value in JTextField txtWagesPerHour and Validate it as well
    public int getWagesPerHr(){
        try{
            Integer.valueOf(getTxtWagesPerHour());
            if(Integer.valueOf(getTxtWagesPerHour()) <= 0){
                return 0;
            }else{
                return Integer.valueOf(getTxtWagesPerHour());
            }
        }catch(NumberFormatException x){
            JOptionPane.showMessageDialog(frame,"Invalid Wages Per Hour (Enter a valid Number)","Verification Error",JOptionPane.ERROR_MESSAGE);
            return 0;
        }      
    }

    //Method to get selected Item form JComboBox Available Vacancy Number and Validate it as well
    public int getAvailability(){
        try{
            return Integer.valueOf(availability.getSelectedItem().toString());
        }catch(NumberFormatException x){
            return 0;
        }
    }

    //Method to get the value selected in JComboBox availableTermination and Validate it as well
    public int getTermAvailable(){
        try{
            return Integer.valueOf(availableTermination.getSelectedItem().toString());
        }catch(NumberFormatException x){
            return 0;
        }
    }

    //Method to add Vacancy Post
    public void addPost(){
        if(isTitle("Full")){

            if(isJobType(txtJobType,"Full")){
                obj = new FullTimeStaffHire(getVacNumber(),getTxtDesignation(),getTxtJobType(),getSal(),getWorkHours());
            }

            if(obj instanceof FullTimeStaffHire) storeStaffHire.add(getFullObject(obj));

            availableFull.add(getTxtVacancyNumber());
            availability.addItem(getTxtVacancyNumber());
        }else if(isTitle("Part")){

            if(isJobType(txtJobType,"Part")){
                obj = new PartTimeStaffHire(getVacNumber(),getTxtDesignation(),getTxtJobType(),getWorkHours(),getWagesPerHr(),getTxtShift());
            }

            if(obj instanceof PartTimeStaffHire) storeStaffHire.add(getPartObject(obj));
            availablePart.add(getTxtVacancyNumber());
            availability.addItem(getTxtVacancyNumber());
        }
        JOptionPane.showMessageDialog(frame,"Vacancy for the post of "+getTxtDesignation()+" has been successfully added!","Vacancy Added",JOptionPane.INFORMATION_MESSAGE);
    }

    //Method to Validate all the Important data to add Post Vacancy
    public void validateVacDetails(){
        try{
            if(getVacNumber() == 0 || getWorkHours() == 0){
                throw new NumberFormatException();
            }else if(isTitle("Full")){
                if(getSal() == 0){
                    throw new NumberFormatException();
                }else{
                    for(StaffHire obj : storeStaffHire){
                        if(obj.getVacancyNumber() == getVacNumber()){
                            throw new NullPointerException(); 
                        }
                    }
                    addPost();
                }
            }else if(isTitle("Part")){
                if(getWagesPerHr() == 0){
                    throw new NumberFormatException();
                }else{
                    for(StaffHire obj : storeStaffHire){
                        if(obj.getVacancyNumber() == getVacNumber()){
                            throw new NullPointerException(); 
                        }
                    }
                    addPost();
                }
            }
        }catch(NumberFormatException x){
            JOptionPane.showMessageDialog(frame,"Invalid Data Entry","Input Error",JOptionPane.ERROR_MESSAGE);
        }catch(NullPointerException c){
            JOptionPane.showMessageDialog(frame,"Please try a different Vacancy Number to Add!","Input Error",JOptionPane.ERROR_MESSAGE);
        }
    }

    //Method Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource()==btnAddVacFullTime) {

            addFullTimeStaff();
            appointStaff();

        }else if(e.getSource()==btnAddVacPartTime) {

            addPartTimeStaff();
            appointStaff();

        }else if(e.getSource()==btnAddPost || e.getSource() == menuItmAdd) {

            if(!isNullOrEmpty(getTxtVacancyNumber()) && !isNullOrEmpty(getTxtDesignation()) && !isNullOrEmpty(getTxtWorkingHours())){
                if(isTitle("Full")){
                    if(!isNullOrEmpty(getTxtSalary())){
                        validateVacDetails();

                    }else{
                        JOptionPane.showMessageDialog(frame,"Fill Salary properly!","Important Data Missing or Invalid",JOptionPane.ERROR_MESSAGE);
                    }
                }else if(isTitle("Part")){
                    if(!isNullOrEmpty(getTxtWagesPerHour()) && !isNullOrEmpty(getTxtShift())){
                        validateVacDetails();

                    }else{
                        JOptionPane.showMessageDialog(frame,"Important Data Mising(WagesPerHour or Shift)!","Important Data Missing or Invalid",JOptionPane.ERROR_MESSAGE);
                    }
                } 
            }else{
                JOptionPane.showMessageDialog(frame,"Fill the Form Properly!","Important Data Missing or Invalid",JOptionPane.ERROR_MESSAGE);
            }

        }else if(e.getSource() == btnAppoint || e.getSource() == menuItmAppoint){

            if(!isNullOrEmpty(availability.getSelectedItem().toString()) && !isNullOrEmpty(getTxtStaffName()) && !isNullOrEmpty(dateManipulator()) && !isNullOrEmpty(getTxtQualification()) && !isNullOrEmpty(getTxtAppointedBy())){
                try{
                    if(getAvailability() == 0){
                        throw new NumberFormatException();
                    }else{
                        if(isTitle("Full")){
                            for(StaffHire obj : storeStaffHire){
                                if(isMatched(obj,"Full",availability)){
                                    getFullObject(obj).hireFullTimeStaff(getTxtStaffName(),dateManipulator(),getTxtQualification(),getTxtAppointedBy());

                                    String remove = availability.getSelectedItem().toString();
                                    availability.setSelectedIndex(0);
                                    availability.removeItem(remove);
                                    availableFull.remove(remove);
                                    break;

                                }

                            }

                        }else if(isTitle("Part")){

                            for(StaffHire obj : storeStaffHire){

                                if(isMatched(obj,"Part",availability)){
                                    getPartObject(obj).hirePartTimeStaff(getTxtStaffName(),dateManipulator(),getTxtQualification(),getTxtAppointedBy());

                                    String remove = availability.getSelectedItem().toString();
                                    availability.setSelectedIndex(0);
                                    availability.removeItem(remove);
                                    availablePart.remove(remove);
                                    availableTerm.add(remove);
                                    break;

                                }

                            }

                        }
                        JOptionPane.showMessageDialog(frame,"Congratulation! "+getTxtStaffName()+" has successfully been appointed.","Staff Successfully Appointed",JOptionPane.INFORMATION_MESSAGE);
                    }
                }catch(NumberFormatException x){
                    JOptionPane.showMessageDialog(frame,"Invalid Vacancy Number","Input Error",JOptionPane.ERROR_MESSAGE);
                }
            }else{
                JOptionPane.showMessageDialog(frame,"Fill the Form Properly!","Important Data Missing or Invalid",JOptionPane.ERROR_MESSAGE);
            }

        }
        else if(e.getSource()==btnClear || e.getSource() == menuItmClear) {

            clearInputFields();

            if(isTitle("Full")) txtSalary.setText("");

            else if(isTitle("Part")){

                txtWagesPerHour.setText("");
                txtShift.setText("");

            }

        }
        else if(e.getSource()==btnTerminate ) {

            addTerminator();

        }
        else if(e.getSource()==btnTermination) {

            if(!isNullOrEmpty(availableTermination.getSelectedItem().toString())){
                try{
                    if(getTermAvailable() == 0){
                        throw new NumberFormatException();
                    }else{

                        for(StaffHire obj:storeStaffHire){

                            if(isMatched(obj,"Part",availableTermination)){

                                if(obj instanceof PartTimeStaffHire) getPartObject(obj).terminateStaff();    
                                String terminated = availableTermination.getSelectedItem().toString();
                                availableTermination.setSelectedIndex(0);
                                availableTermination.removeItem(terminated);
                                availableTerm.remove(terminated);
                                availablePart.add(terminated);
                                JOptionPane.showMessageDialog(frame,"Staff has successfully been terminated!","Termination Successful",JOptionPane.INFORMATION_MESSAGE);
                                break;

                            }
                            if(storeStaffHire.indexOf(obj)==(storeStaffHire.size()-1)){
                                JOptionPane.showMessageDialog(frame,"Record Not Found to Terminate!","Termination Failed",JOptionPane.ERROR_MESSAGE);
                            }

                        }
                        if(storeStaffHire.size()==0){
                            JOptionPane.showMessageDialog(frame,"No Staff has ever been Hired to Terminate!","Termination Failed",JOptionPane.ERROR_MESSAGE);
                        }
                    }
                }catch(NumberFormatException x){
                    JOptionPane.showMessageDialog(frame,"Invalid Vacancy Number in frame","Input Error",JOptionPane.ERROR_MESSAGE);
                }
            }else{
                JOptionPane.showMessageDialog(frame,"Empty Vacancy Number!","Input Error",JOptionPane.ERROR_MESSAGE);
            }

        }else if(e.getSource()==btnDisplay || e.getSource() == menuItmDetails){
            if(isTitle("Full")){
                for(StaffHire obj : storeStaffHire){
                    if(isJobType(obj,"Full")) getFullObject(obj).display();
                }
            }else if(isTitle("Part")){
                for(StaffHire obj : storeStaffHire){
                    if(isJobType(obj,"Part")) getPartObject(obj).display();
                }
            }
        }
        else if(e.getSource() == btnAllRecords || e.getSource() == btnRecordPartTime || e.getSource() == btnRecordFullTime){
            if(e.getSource() == btnAllRecords || e.getSource() == btnRecordFullTime){
                for(StaffHire obj : storeStaffHire){
                    if(isJobType(obj,"Full")) getFullObject(obj).display();
                }
            }
            if(e.getSource() == btnAllRecords || e.getSource() == btnRecordPartTime){
                for(StaffHire obj : storeStaffHire){
                    if(isJobType(obj,"Part")) getPartObject(obj).display();
                }
            }
        }
        else if(e.getSource() == menuItmClose){
            frame.dispose();
        }
        else if(e.getSource() == menuItmAbout){
            JOptionPane.showMessageDialog(frame,"The credit for this project goes to Dikshyanta Mulmi.","About",JOptionPane.INFORMATION_MESSAGE);
        }
    }

    //Method to convert ArrayList<String> to String Array
    public static String[] getStringArray(ArrayList<String> arr){
        String[] str = new String[arr.size()];

        for(int j=0;j<arr.size();j++){
            str[j] = arr.get(j);
        }
        return str;
    }
}
