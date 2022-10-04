package dbdummy;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author user
 */
public class supplierDisplay {
    private String id,name,mail,phn;
   
    
    public supplierDisplay(String id,String name,String mail,String phn)
    {
        this.id = id;
        this.name = name;
        this.mail = mail;
        this.phn = phn;
    }
    
    public String getid() {
        return id;
    }
    public String getname() {
        return name;
    }
    public String getmail() {
        return mail;
    }
    public String getphn() {
        return phn;
    }
    
    
    public void setid(String id) {
        this.id = id;
    }
    
    public void setname(String name) {
        this.name = name;
    }
    public void setmail(String mail) {
        this.mail = mail;
    }
    public void setphn(String phn) {
        this.phn = phn;
    }
    
}
