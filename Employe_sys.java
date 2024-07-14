import java.util.*;

//Employee payroll system 
//Calculating salaries for both Full Time and Part Time employees with abstract methods
//Managing employee records ,salary updates and removal using a payroll system

abstract class Employee{    //abstract class
private String name;
private int id;

public Employee(String name,int id){
this.name=name;
this.id=id;
}
public String getName(){ //getter   encapsulation(direct access not given to user)
return name;
}
public int getID(){      //getter
    return id;
}
//abstraction method
public abstract double cal_salary();

@Override //polymorphism
public String toString(){
    return "Employee [ name = " + name +",id = " + id + ",salary ="  + cal_salary() + "]";
}

}
//full time Employees
class FullTimeEmp extends Employee{
    private double mon_salary;

    public FullTimeEmp(String name,int id,double mon_salary){
        super(name,id);  //To get super class constructor
        this.mon_salary=mon_salary;
    }
    @Override
    public double cal_salary(){
        return mon_salary;
    }

}
//Part time employees
class Part_Time_Emp extends Employee{
    private int hours_work;
    private double hour_rate;

    public Part_Time_Emp(String name,int id,int hours_work,double hour_rate){
        super(name,id);
        this.hours_work=hours_work;
        this.hour_rate=hour_rate;
    }
    @Override
    public double cal_salary(){
        return hours_work*hour_rate;
    }
}
//Payroll system
class Payroll_sys{
    private static ArrayList<Employee> emp_list;  //Arraylist : name,id,salary of employee object

    public Payroll_sys(){
        emp_list = new ArrayList<>();
    }
    public static void add_employee(Employee emp){
        emp_list.add(emp);
    }

    public static void remove_employee(int id){//if any employee resigns 
        Employee emp_remove=null;
        for(Employee emp: emp_list){
            if(emp.getID()==id){
                emp_remove=emp;
                break;
            }
        }
        if(emp_remove!=null){
            emp_list.remove(emp_remove);
        }
    }

    //display employee
    public static void display_emp(){
        for(Employee e:emp_list){
            System.out.println(e);
        }
    }

}
public class Employe_sys {
    public static void main(String[] args) {
        Payroll_sys p=new Payroll_sys();

        //Full time employee
        FullTimeEmp r = new FullTimeEmp("Rajesh", 12, 50000);
        FullTimeEmp v = new FullTimeEmp("Vrijesh", 15, 30000);

        //Part time employee
        Part_Time_Emp s = new Part_Time_Emp("Saina", 13, 2, 1000);
        
        Payroll_sys.add_employee(r);
        Payroll_sys.add_employee(s);
        Payroll_sys.add_employee(v);
        System.out.println("Initial Employee Details : ");
        Payroll_sys.display_emp();
System.out.println();
        Payroll_sys.remove_employee(15);

        System.out.println("Employee Details : ");
        Payroll_sys.display_emp();


    }
}
