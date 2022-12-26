package zad1;

import java.util.*;

// klasa reprezentująca ofertę wyjazdu
public class Offer {
    private String location;  // lokalizacja kontrahenta
    private String country;  // kraj
    private Date departureDate;  // data wyjazdu
    private Date returnDate;  // data powrotu
    private String place;  // miejsce (morze, jezioro, góry)
    private double price;  // cena
    private String currency;  // symbol waluty
    private ArrayList<Offer> a;
    // konstruktor
    public Offer(String location, String country, Date departureDate, Date returnDate, String place, double price, String currency) {
        this.location = location;
        this.country = country;
        this.departureDate = departureDate;
        this.returnDate = returnDate;
        this.place = place;
        this.price = price;
        this.currency = currency;
    }

    // metody dostępowe
    public String getLocation() { return location; }
    public String getCountry() { return country; }
    public Date getDepartureDate() { return departureDate; }
    public Date getReturnDate() { return returnDate; }
    public String getPlace() { return place; }
    public double getPrice() { return price; }
    public String getCurrency() { return currency; }

}