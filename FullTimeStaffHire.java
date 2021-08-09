
/**
 * The class FullTimeStaffHire is creates object that accepts vacancy number, Designation, Job type, Salary and Working Hour.
 * This class hires a Full time staff with the help of hireFullTimeStaff() method. 
 * A display() method is also made inside this class which display valuable information when called.
 * @author (Dikshyanta Mulmi)
 * @version (0.2)
 */
public class FullTimeStaffHire extends StaffHire//FullTimeStaffHire is a Sub Class of Super Class StaffHire 
{  //Declaring Instance Varaible with Access Modifier as Private
    private int salary;
    private int workingHour;
    private String staffName;
    private String joiningDate;
    private String qualification;
    private String appointedBy;
    private boolean joined;
    public FullTimeStaffHire(int vacancyNumber,String designation,String jobType,int salary,int workingHour)//Parameterized Constructor that passes Five arguments, three arguments from Super class
    {
        super(vacancyNumber,designation,jobType);//super keyword is used to invoke constructors of super class StaffHire
        this.salary=salary;//this keyword is used to pass argument in Constructor call
        this.workingHour=workingHour;
        staffName="";
        joiningDate="";
        qualification="";
        appointedBy="";
        joined=false;
    }
    //Accessor Method of Salary
    //Getter Method 
    public int getSalary(){
        return salary;//returns value of Private Instance Variable salary
    }
    //Setter Method 
    public void setSalary(int newSalary){
        if(!getJoined()){
            if(newSalary!=salary){
                System.out.println("The salary for the post of "+getDesignation()+" has been changed from Rs "+salary+" to Rs "+newSalary+".");
                this.salary=newSalary;//this keyword is used to pass argument in Method call
            }
            else{
                System.out.println("The new salary for the post of "+getDesignation()+" is Rs "+salary+" , same as the salary assigned previously.");  
            }
        }
        else{
            System.out.println("Sorry,the salary for the post of "+getDesignation()+" cannot be changed from Rs "+getSalary()+" to Rs "+newSalary+" , as staff named "+this.staffName+" has already been hired for this post for salary of Rs "+this.salary+".");
        }
    }
    //Accessor Method of workingHour
    //Getter Method
    public int getWorkingHour(){
        return workingHour;
    }
    //Setter Method
    public void setWorkingHour(int newWorkingHour){
        if(newWorkingHour!=workingHour){
            System.out.println("The working hour for the post of "+getDesignation()+" has been changed from "+getWorkingHour()+" hour(s) to "+newWorkingHour+" hour(s).");
            this.workingHour=newWorkingHour;
        }
        else{
            System.out.println("The new working hour for the post of "+getDesignation()+" is "+workingHour+" hour(s), same as the working hour(s) assigned previously."); 
        }
    }
    //Getter Methods
    //Getter Method of staffName
    public String getStaffName(){
        return staffName;
    }
    //Getter Method of joiningDate
    public String getJoiningDate(){
        return joiningDate;
    }
    //Getter Method of qualification
    public String getQualification(){
        return qualification;
    }
    //Getter Method of appointedBy
    public String getAppointedBy(){
        return appointedBy;
    }
    //Getter Method of joined
    public boolean getJoined(){
        return joined;
    }
    //Method to Hire a person for the post
    public void hireFullTimeStaff(String staffName,String joiningDate,String qualification,String appointedBy){
        if(joined){
            System.out.println("Sorry, "+staffName+" cannot be hired as staff named "+getStaffName()+" has already been hired for the post of "+getDesignation()+" on "+getJoiningDate()+" by "+getAppointedBy()+".");
        }
        else{
            this.staffName=staffName;//this keyword is used to pass argument in Method call
            this.joiningDate=joiningDate;
            this.qualification=qualification;
            this.appointedBy=appointedBy;
            joined=true;
            System.out.println(staffName+" has successfully been hired for the post of "+getDesignation()+" on "+joiningDate+" by "+appointedBy+".");
        }
    }

    public void display(){//method to display Staff name, Salary, Working Hour,Joining Date, Qualification, and Appointed By with display() method from super class StaffHire
        super.display();//calling display() method of Super class StaffHire
        if(getJoined()){
            System.out.println("-----------------------------------------------------------------------");    
            System.out.println("Staff Name : "+staffName);
            System.out.println("Salary : Rs "+salary);
            System.out.println("Working Hour : "+workingHour+" hour(s)");
            System.out.println("Joining Date : "+joiningDate);
            System.out.println("Qualification : "+qualification);
            System.out.println("Appointed By : "+appointedBy);
            System.out.println("************************************************************************");
            System.out.println();
        }else
        {
            System.out.println("No Fulltime Staff has been hired for the above post of "+getDesignation()+" yet.");
            System.out.println("************************************************************************");
            System.out.println();
        }
    }
}
