package OOP_review;

/**Write an Employee class that is a derived class of Person. An Employee has name, age, job title, and salary attributes.
 * There are also methods to calculate and update salary, as well as display all info on the Employee.
 *
 */
public class Employee extends Person {
    private String job;
    private int salary;
    public Employee(String name, int age, String job, int salary) {
        super(name, age);
        this.job = job;
        this.salary = salary;
    }
    public String getJob() {
        return job;
    }
    public int getSalary() {
        return salary;
    }
    public void setJob(String job) {
        this.job = job;
    }
    public void setSalary(int salary) {
        this.salary = salary;
    }
    public void displayInfo(){
        System.out.println("Name: " + this.getName());
        System.out.println("Age: " + this.getAge());
        System.out.println("Job: " + this.getJob());
        System.out.println("Salary: " + this.getSalary());
    }

}
