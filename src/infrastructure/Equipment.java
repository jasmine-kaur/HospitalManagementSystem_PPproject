/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package infrastructure;

/**
 *
 * @author Mansi Verma
 */
public class Equipment {
    
    private long equipmentId;
    private String equipmentName;
    private int quantity;
    
    private long getEquipmentId(){
        return equipmentId;
    }
    
    public String getEquipmentName(){
        return equipmentName;
    }
    
    public void setEquipmentName(String equipmentName){
        this.equipmentName=equipmentName;
    }
    
    public int getQuantity(){
        return quantity;
    }
    
    public void setQuantity(int quantity){
        this.quantity=quantity;
    }
}
