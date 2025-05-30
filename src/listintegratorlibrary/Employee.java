/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package listintegratorlibrary;

/**
 * Employee class
 * 
 * @author Hardikkumar Bhakta
 */
public class Employee {
    
    private String firstName;
    private String lastName;
    
    /**
     * Employee constructor
     */
    public Employee() {
        this.firstName = "";
        this.lastName = "";
    }
    
    /**
     * Employee constructor with one parameter
     * @param firstName 
     */
    public Employee(String firstName) {
        this.firstName = firstName;
        this.lastName = "";
    }
    
    /**
     * Employee constructor with two parameters
     * @param firstName 
     */
    public Employee(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }
    
    /**
     * Gets employee's first name
     * @return firstName
     */
    public String getFirstName() {
        return firstName;
    }
    
    /**
     * Sets employee's first name
     * @param firstName 
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    
    /**
     * Gets employee's last name
     * @return lastName
     */
    public String getLastName() {
        return lastName;
    }
    
    /**
     * Sets employee's last 
     * @param lastName 
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    
    /**
     * toString() method
     * @return employee name
     */
    @Override
    public String toString() {
        return "Employee Name: " + firstName + " " + lastName;
    }
    
    
}
