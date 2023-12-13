package models;
public class Airport {
    
    public String abreviation;
    public String description;

    public Airport(String abreviation, String description) {
        this.abreviation = abreviation;
        this.description = description;
    }

    public String toString() {
        return  this.description + "(" + this.abreviation + ") ";
    }
}
