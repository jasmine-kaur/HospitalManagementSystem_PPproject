/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BasicDetails;

/**
 *
 * @author Mansi Verma
 */
public class Address {
    private int houseNumber;
    private String street;
    private String city;
    private String state;
    private Long postalCode;
    
    
    public Address(int houseNumber, String street,String city, String state){
        this.houseNumber=houseNumber;
        this.street=street;
        this.city= city;
        this.state= state;
    }
    
    public int getHouseNumber(){
        return this.houseNumber;
    }
    public String getStreet(){
        return this.street;
    }
    public String getCity(){
        return this.city;
    }
    public String getState(){
        return this.state;
    }
    public Long getPostalCode(){
        return this.postalCode;
    }
    
    public void setHouseNumber(int houseNumber){
        this.houseNumber=houseNumber;
    }
    public void setStreet(String street){
        this.street=street;
    }
    public void setCity(String city){
        this.city=city;
    }
    public void setState(String state){
        this.state=state;
    }
    public void setPostalCode(Long postalCode){
        this.postalCode=postalCode;
    }
    
    @Override
    public String toString(){
        return this.houseNumber+","+this.street+","+this.city+","+this.state;
    }
}
