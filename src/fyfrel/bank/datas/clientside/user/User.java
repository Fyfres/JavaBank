package fyfrel.bank.datas.clientside.user;

import java.io.Serializable;

/**
 * Basic User class that can contain multiple Bank Account
 */
public abstract class User implements Serializable {
    private static Integer lastId = 0;
    private Integer id;
    private String firstName;
    private String lastname;
    private String password;

    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getLastname() {
        return lastname;
    }
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * Constructor that add the new instance to the list of user in Class Bank
     * @param firstName String
     * @param lastname String
     * @param password String
     */
    public User(String firstName, String lastname, String password) {
        this.firstName = firstName;
        this.lastname = lastname;
        this.password = password;
        lastId++;
        this.id = lastId;
    }

    /**
     * Test if the User is a Customer
     * @return a Boolean
     */
    public Boolean isCustomer() {
        return this instanceof Customer;
    }

    /**
     * Test if the User is an Advisor
     * @return a Boolean
     */
    public Boolean isAdvisor() {
        return this instanceof Advisor;
    }



    public String getClassName(){
        return "User";
    }
}
