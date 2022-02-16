/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WinkelWeb_POJO;

/**
 *
 * @author sanda
 */
public class UserCredentialsPOJO {
     private String firstname;
    private String lastname;
    private String mob;       
    private String dob;
    private String email;       
    private String password;       
    private String address;
    private String user_type;
    private String user_dp;

    @Override
    public String toString() {
        return "UserCredentialsPOJO{" + "firstname=" + firstname + ", lastname=" + lastname + ", mob=" + mob + ", dob=" + dob + ", email=" + email + ", password=" + password + ", address=" + address + ", user_type=" + user_type + ", user_dp=" + user_dp + '}';
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getMob() {
        return mob;
    }

    public void setMob(String mob) {
        this.mob = mob;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getUser_type() {
        return user_type;
    }

    public void setUser_type(String user_type) {
        this.user_type = user_type;
    }

    public String getUser_dp() {
        return user_dp;
    }

    public void setUser_dp(String user_dp) {
        this.user_dp = user_dp;
    }

    public UserCredentialsPOJO(String firstname, String lastname, String mob, String dob, String email, String password, String address, String user_type) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.mob = mob;
        this.dob = dob;
        this.email = email;
        this.password = password;
        this.address = address;
        this.user_type = user_type;
    }
}
