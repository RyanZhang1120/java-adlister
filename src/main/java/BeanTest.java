import java.util.ArrayList;

public class BeanTest {
    public static void main(String[] args) {
        Album album = new Album();
        album.setId(1);
        album.setArtist("Michael Jackson");
        album.setName("Thriller");
        album.setRelease_date(1982);
        album.setSales(110);
        album.setGenre("Pop");

        Author author = new Author();
        author.setId(1);
        author.setFirst_name("Ernest");
        author.setLast_name("Hemingway");

        ArrayList<Quote> quotes = new ArrayList<>();
        Quote quote1 = new Quote();
        quote1.setId(1);
        quote1.setAuthor_id(1);
        quote1.setContent("Perfectly balanced. As all things should be.");

        Quote quote2 = new Quote();
        quote2.setId(2);
        quote2.setAuthor_id(1);
        quote2.setContent("What is your deepest fear?");

        quotes.add(quote1);
        quotes.add(quote2);

        for (Quote quote : quotes) {
            System.out.println("Quote content: " + quote.getContent());
            System.out.println("Author name: " + author.getFirst_name() + " " + author.getLast_name());
        }
    }
}
