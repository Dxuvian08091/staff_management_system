
/**
 * The class StaffHire is creates object that accepts vacancy number, Designation and Job type.
 * This class also has getter and setter method for Private Instance Variables vacancyNumber,designation and jobType. 
 * A display() method is also made inside this class which displays Vacancy Number,Designation and Job Type when called.
 * @author (Dikshyanta Mulmi)
 * @version (0.22)
 */
public class StaffHire
{
    //Declaring a Instance Variable with Protected as Access Modifier
    protected int vacancyNumber;
    protected String designation;
    protected String jobType;

    public StaffHire(int vacancyNumber,String designation,String jobType)//Parameterized Constructor that passes three Arguments
    {
        this.vacancyNumber=vacancyNumber;//this keyword is used to pass argument in Constructor call
        this.designation=designation;
        this.jobType=jobType;
    }

    //Accessor Method of vacancyNumber
    //Getter Method
    public int getVacancyNumber(){
        return vacancyNumber;//returns value of Protected Instance vacancyNumber
    }
    //Setter Method
    public void setVacancyNumber(int vacancyNumber){
        this.vacancyNumber=vacancyNumber;//this keyword is used to pass argument in Method call
    }
    //Accessor Method of designation
    //Getter Method
    public String getDesignation(){
        return designation;
    }
    //Setter Method
    public void setDesignation(String designation){
        this.designation=designation;
    }
    //Accessor Method of jobType
    //Getter Method
    public String getJobType(){
        return jobType;
    }
    //Setter Method
    public void setJobType(String jobType){
        this.jobType=jobType;
    }

    //method to display Vacancy Number, Designation And Job Type
    public void display(){
        System.out.println();
        System.out.println("***********************************************************************");
        System.out.println("Vacancy Number : "+getVacancyNumber());
        System.out.println("Designation : "+getDesignation());
        System.out.println("Job Type : "+getJobType());
        System.out.println("-----------------------------------------------------------------------");
    }
}
