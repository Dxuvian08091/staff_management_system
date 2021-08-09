
/**
 * The class FullTimeStaffHire is creates object that accepts vacancy number, Designation, Job type, Working Hour, Wages Per Hour and Shift.
 * This class hires a Part time staff with the help of hireFullTimeStaff() method. 
 * A display() method is also made inside this class which display valuable information when called.
 * @author (Dikshyanta Mulmi)
 * @version (0.2)
 */
public class PartTimeStaffHire extends StaffHire//PartTimeStaffHire is a SubClass of Super Class StaffHire
{
    //Declaring Instance Variable with Private as Access Modifier
    private int workingHour;
    private int wagesPerHour;
    private String staffName;
    private String joiningDate;
    private String qualification;
    private String appointedBy;
    private String shifts;
    private boolean joined;
    private boolean terminated;
    public PartTimeStaffHire(int vacancyNumber,String designation,String jobType,int workingHour,int wagesPerHour,String shifts)//Parameterized Constructor that passes Six Arguments, Three from Super Class StaffHire
    {
        super(vacancyNumber,designation,jobType);//super keyword is used to invoke constructors of super class StaffHire
        this.workingHour=workingHour;//this keyword is used to pass argument in Constructor call
        this.wagesPerHour=wagesPerHour;
        this.shifts=shifts;
        staffName="";
        joiningDate="";
        qualification="";
        appointedBy="";
        joined=false;
        terminated=false;
    }
    //Accessor Method of shifts
    //Getter Method
    public String getShifts(){
        return shifts;
    }
    //Setter Method
    public void setShifts(String newShifts){
        if(!joined){
            if((newShifts.toUpperCase()).equals(shifts.toUpperCase())){
                System.out.println("The new Shift for the post of "+getDesignation()+" is "+shifts+" , same as the shift assigned previously.");
            }
            else{
                System.out.println("The shift for the post of "+getDesignation()+" has been changed from "+getShifts()+" to "+newShifts+".");
                this.shifts=newShifts;
            }
        }
        else{
            System.out.println("Sorry, the shift for the post of "+getDesignation()+" cannot be changed from "+getShifts()+" to "+newShifts+" , as staff named "+this.staffName+" has already been hired for this post on "+this.shifts+" shift.");
        }
    }
    //Accessor Method of Terminated 
    //Getter Methods of Terminated
    public boolean getTerminated(){
        return terminated;
    }
    //Setter Methods of Terminated
    public void terminateStaff(){
        if(!terminated && joined){
            this.joiningDate="";
            this.qualification="";
            this.appointedBy="";
            joined=false;
            terminated=true;
            System.out.println("The staff named "+getStaffName()+" has successfully been terminated. Now, the post for "+getDesignation()+" is vacant.");
            this.staffName="";
        }
        else{
            if(terminated && !joined){
                System.out.println("The post for "+getDesignation()+" is vacant as the former staff has already been terminated.");
            }
            else{
                System.out.println("No staff has been hired for the post of "+getDesignation()+" since the vacancy announcement.");
            }
        }
    }
    //Getter Methods
    //Getter Method for workingHour
    public int getWorkingHour(){
        return workingHour;
    }
    //Getter Method for wagesPerHour
    public int getWagesPerHour(){
        return wagesPerHour;
    }
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
    //Method to hire a Part Time Staff
    public void hirePartTimeStaff(String staffName,String joiningDate,String qualification,String appointedBy){
        if(getJoined()){
            System.out.println("Sorry, "+staffName+" cannot be hired as staff named "+getStaffName()+" has already been hired for the post of "+getDesignation()+" on "+getJoiningDate()+" by "+getAppointedBy()+".");
        }
        else{
            this.staffName=staffName;
            this.joiningDate=joiningDate;
            this.qualification=qualification;
            this.appointedBy=appointedBy;
            joined=true;
            terminated=false;
            System.out.println(staffName+" has successfully been hired for the post of "+getDesignation()+" on "+joiningDate+" by "+appointedBy+".");
        }
    }
    //method to display Staff name, WagesPerHour, Working Hour,Joining Date, Qualification, Appointed By and Income Per day with display() method from super class StaffHire 
    public void display(){
        super.display();//calling display() method of Super class StaffHire
        if(joined){
            System.out.println("-----------------------------------------------------------------------");
            System.out.println("Staff Name : "+staffName);
            System.out.println("WagesPerHour : "+wagesPerHour+" Rs/hour");
            System.out.println("Working Hour : "+workingHour+" hour(s)");
            System.out.println("Joining Date : "+joiningDate);
            System.out.println("Qualifiaction : "+qualification);
            System.out.println("Appointed By : "+appointedBy);
            System.out.println("Income Per Day : Rs "+(wagesPerHour*workingHour));
            System.out.println("************************************************************************");
            System.out.println();
        }else
        {
            System.out.println("No Parttime Staff has been hired for the above post of "+getDesignation()+" yet.");
            System.out.println("************************************************************************");
            System.out.println();
        }
    }
}
