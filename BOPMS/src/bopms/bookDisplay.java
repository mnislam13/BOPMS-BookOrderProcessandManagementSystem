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
class bookDisplay {
    private String isbn,name,author,publisher,category;
    private float cost,sell;
    private int stocks;
    
    public bookDisplay(String isbn,String name,String author,
            String publisher,String category,
            float cost, float sell, int stocks)
    {
        this.isbn = isbn;
        this.name = name;
        this.author = author;
        this.publisher = publisher;
        this.category = category;
        this.cost = cost;
        this.sell = sell;
        this.stocks = stocks;
    }
    
     public String getisbn() {
        return isbn;
    }
     
    public String getname() {
        return name;
    }
          
     public String getauthor() {
        return author;
    }

    public String getpublisher() {
        return publisher;
    }   
    
    public String getcategory() {
        return category;
    }
    
    public float getcost() {
        return cost;
    }
    
     public float getsell() {
        return sell;
    }
     
    public int getstocks() {
        return stocks;
    }
    
     public void setisbn(String isbn) {
        this.isbn = isbn;
    }
     
    public void setname(String name) {
        this.name = name;
    }
    
    public void setauthor(String author) {
        this.author = author;
    }
     
    public void setpublisher(String publisher) {
        this.publisher = publisher;
    }
    
    public void setcategory(String category) {
        this.category = category;
    }
    
    public void setcost(float cost) {
        this.cost = cost;
    }
    
    public void setsell(float sell) {
        this.sell = sell;
    }
    
    public void setstocks(int stocks) {
        this.stocks = stocks;
    }
    
}
