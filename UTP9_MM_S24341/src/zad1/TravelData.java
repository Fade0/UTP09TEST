package zad1;

import java.io.*;
        import java.util.*;
        import java.text.*;

// klasa odpowiedzialna za wczytanie ofert z plików katalogu data
public class TravelData {
    private List<Offer> offers;  // lista ofert

    // konstruktor
    public TravelData(File dataDir) {
        offers = new ArrayList<>();
        // wczytanie plików z ofertami
        for (File offerFile : dataDir.listFiles()) {
            try (BufferedReader reader = new BufferedReader(new FileReader(offerFile))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    // podzielenie wiersza na poszczególne pola
                    String[] fields = line.split("\t");
                    // pobranie danych z poszczególnych pól
                    String location = fields[0];
                    String country = fields[1];
                    Date departureDate = new SimpleDateFormat("yyyy-MM-dd").parse(fields[2]);
                    Date returnDate = new SimpleDateFormat("yyyy-MM-dd").parse(fields[3]);
                    String place = fields[4];
                    double price = Double.parseDouble(fields[5]);
                    String currency = fields[6];
                    // utworzenie obiektu oferty i dodanie do listy
                    Offer offer = new Offer(location, country, departureDate, returnDate, place, price, currency);
                    offers.add(offer);
                }
            } catch (IOException | ParseException e) {
                e.printStackTrace();
            }
        }
    }

    // metoda zwracająca listę opisów ofert zgodnie z regułami i w języku lokalizacji loc i przy podanym formacie daty
    public List<String> getOffersDescriptionsList(String loc, String dateFormat) {
        List<String> descriptions = new ArrayList<>();
        // ustawienie lokalizacji i formatu daty
        Locale locale = new Locale.Builder().setLanguageTag(loc).build();
        DateFormat df = new SimpleDateFormat(dateFormat, locale);
        // przejście po wszystkich ofertach i utworzenie opisów
        for (Offer offer : offers) {
            StringBuilder sb = new StringBuilder();
            sb.append(offer.getCountry()).append(": ");
            sb.append(df.format(offer.getDepartureDate())).append(" - ").append(df.format(offer.getReturnDate())).append(", ");
            sb.append(offer.getPlace()).append(", ");
            sb.append(offer.getPrice()).append(" ").append(offer.getCurrency());
            descriptions.add(sb.toString());
        }
        return descriptions;
    }

    public List<Offer> getOffers() {
        return offers;
    }

}