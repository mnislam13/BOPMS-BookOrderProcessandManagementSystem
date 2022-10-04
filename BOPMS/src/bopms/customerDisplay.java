/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbdummy;

/**
 *
 * @author user
 */
public class customerDisplay {
    private String id,name,mail,addrss,phn,typ;
    private float income;
    
    
    public customerDisplay(String id,String name,String mail,
            String addrss,String phn,String typ,float income)
    {
        this.id = id;
        this.name = name;
        this.mail = mail;
        this.addrss = addrss;
        this.phn = phn;
        this.typ = typ;
        this.income = income;
      
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

    public String getaddrss() {
        return addrss;
    }   
    
    public String getphn() {
        return phn;
    }
    
    public String gettyp() {
        return typ;
    }
    
    public float getincome() {
        return income;
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
     
    public void setaddrss(String addrss) {
        this.addrss = addrss;
    }
    
    public void setphn(String phn) {
        this.phn = phn;
    }
    
    public void settyp(String typ) {
        this.typ = typ;
    }
    public void setincome(float income) {
        this.income = income;
    }
    

}
