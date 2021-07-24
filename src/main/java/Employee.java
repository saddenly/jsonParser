public class Employee {
    public long id;
    public String firstName;
    public String secondName;
    public String country;
    public int age;

    public Employee() {

    }

    public Employee(long id, String firstName, String secondName, String country, int age) {
        this.id = id;
        this.firstName = firstName;
        this.secondName = secondName;
        this.country = country;
        this.age = age;
    }

    public String toString() {
        return "Employee{id=" + id + ", firstName='" + firstName + "', secondName='" + secondName + "', country='"
                + country + "', age=" + age + "}";
    }
}