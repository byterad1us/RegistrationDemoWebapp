/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package form.beans;

import java.util.Map;

/**
 *
 * @author ouvre
 */
public class UserData {
    
    private String firstName;
    private String lastName;
    private String address1;
    private String address2;
    private String city;
    private String state;
    private String zip;
    private String country;

    public UserData() {
    }

    public UserData(final Map<String,String[]> formData) {
        if(formData.get("first_name") != null && formData.get("first_name").length > 0)
            this.firstName = formData.get("first_name")[0];
       if(formData.get("last_name") != null && formData.get("last_name").length > 0)
            this.lastName = formData.get("last_name")[0];
         if(formData.get("address1") != null && formData.get("address1").length > 0)
            this.address1 = formData.get("address1")[0];
       
         if(formData.get("address2") != null && formData.get("address2").length > 0)
            this.address2 = formData.get("address2")[0];
       
         if(formData.get("city") != null && formData.get("city").length > 0)
            this.city = formData.get("city")[0];
       
        if(formData.get("state") != null && formData.get("state").length > 0)
            this.state = formData.get("state")[0];
       
        if(formData.get("zip") != null && formData.get("zip").length > 0)
            this.zip = formData.get("zip")[0];
       
        if(formData.get("country") != null && formData.get("country").length > 0)
            this.country = formData.get("country")[0];
       
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

    public String getAddress1() {
        return address1;
    }

    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    public String getAddress2() {
        return address2;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
    
    
    
}
