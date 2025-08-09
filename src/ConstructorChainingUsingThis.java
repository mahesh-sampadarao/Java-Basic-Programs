//Constructor Chaining is calling one constructor from another constructor using this()
//this(); is special type available only for constructor chaining
// Here in below code lpaStudent1 reference calls 3 parameters/variables consturctor using this(); using 2 arguments

public class ConstructorChainingUsingThis {
    public static void main(String[] args) {

        LPAStudent lpaStudent = new LPAStudent(1002, "Uma", "Mahesh");
        System.out.println(lpaStudent);
        System.out.println(lpaStudent.getId() + " : " + lpaStudent.getFirstName() + " : " + lpaStudent.getLastName());
        System.out.println("-".repeat(20));

        LPAStudent lpaStudent1 = new LPAStudent("Abhi", "Ram");
        System.out.println(lpaStudent1);
        System.out.println(lpaStudent1.getId() + " : " + lpaStudent1.getFirstName() + " : " + lpaStudent1.getLastName());
        System.out.println("-".repeat(20));
    }
}

class LPAStudent {
    private int id;
    private String firstName;
    private String lastName;

    public LPAStudent(int id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        System.out.println("The constructor with 3 parameters has been called");
    }

    public LPAStudent(String firstName, String lastName) {
        this(1001, firstName, lastName);

//        this.lastName = lastName;
//        this.firstName = firstName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return "LPAStudent{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}
