package zad1;

import java.text.DateFormat;
import java.text.FieldPosition;
import java.text.ParsePosition;
import java.util.*;
import javax.swing.*;

// klasa odpowiedzialna za utworzenie bazy danych i otwarcie GUI z tabelą z ofertami
public class Database {
    private TravelData travelData;  // obiekt z danymi o ofertach
    private String url;
    // konstruktor
    public Database(String url, TravelData travelData) {
        this.travelData = travelData;
        this.url = url;
    }

    // metoda utworzenia bazy danych i wpisania do niej ofert
    public void createDb() {
        // tutaj należy napisać kod tworzący bazę danych i wpisujący do niej oferty
    }

    // metoda otwierająca GUI z tabelą z ofertami
    public void openGui() {
        // pobranie listy opisów ofert w wybranym języku i z ustawieniami regionalnymi
        String[] columnNames = {"Kraj", "Data wyjazdu", "Data powrotu", "Miejsce", "Cena", "Waluta"};
        String[][] data = new String[travelData.getOffers().size()][6];
        int i = 0;
        for (Offer offer : travelData.getOffers()) {
            DateFormat df = new DateFormat() {
                @Override
                public StringBuffer format(Date date, StringBuffer toAppendTo, FieldPosition fieldPosition) {
                    return null;
                }

                @Override
                public Date parse(String source, ParsePosition pos) {
                    return null;
                }
            };
            data[i][0] = offer.getCountry();
            data[i][1] = df.format(offer.getDepartureDate());
            data[i][2] = df.format(offer.getReturnDate());
            data[i][3] = offer.getPlace();
            data[i][4] = offer.getPrice() + " " + offer.getCurrency();
            data[i][5] = offer.getCurrency();
            i++;
        }
        // utworzenie tabeli i dodanie do okna
        JTable table = new JTable(data, columnNames);
        JScrollPane scrollPane = new JScrollPane(table);
        JFrame frame = new JFrame("Oferta");
        frame.add(scrollPane);
        frame.pack();
        frame.setVisible(true);
    }
}