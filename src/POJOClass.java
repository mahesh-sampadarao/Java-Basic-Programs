//POJO has only instance fields, getters and setters.
//POJO is also called as Entity, bean, JavaBean and DTO(Data Transfer Object) in various context
//with some additional rules to make them restrictive.

//Java has a feature called RECORD which is replacement of POJO with more restrictions.

public class POJOClass {
    private int id;
    private String firstName;
    private String lastName;
    private String surName;

    public POJOClass(int id, String firstName, String lastName, String surName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.surName = surName;
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

    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }
}
