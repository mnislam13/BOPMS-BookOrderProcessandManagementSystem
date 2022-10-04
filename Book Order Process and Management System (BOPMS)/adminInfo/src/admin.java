/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author user
 */
public class admin {
    private String id,name,mail,pass,addrss,phn;
  
    public admin(String id,String name,String mail,
            String pass,String addrss,String phn)
    {
        this.id = id;
        this.name = name;
        this.mail = mail;
        this.pass = pass;
        this.addrss = addrss;
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

    public String getpass() {
        return pass;
    }   
    
    public String getaddrss() {
        return addrss;
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
     
    public void setpass(String pass) {
        this.pass = pass;
    }
    
    public void setaddrss(String addrss) {
        this.addrss = addrss;
    }
    
    public void setphn(String phn) {
        this.phn = phn;
    }
}
