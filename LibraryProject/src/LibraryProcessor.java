import org.w3c.dom.*;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;

public class LibraryProcessor {
    public static void main(String[] args) throws Exception {
        File xmlFile = new File("library.xml");
        Document doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(xmlFile);
        doc.getDocumentElement().normalize();

        NodeList books = doc.getElementsByTagName("book");
        double totalPrice = 0;

        System.out.println("Список книг:");
        for (int i = 0; i < books.getLength(); i++) {
            Element book = (Element) books.item(i);
            String title = book.getElementsByTagName("title").item(0).getTextContent();
            String author = book.getElementsByTagName("author").item(0).getTextContent();
            int year = Integer.parseInt(book.getElementsByTagName("year").item(0).getTextContent());
            String genre = book.getElementsByTagName("genre").item(0).getTextContent();
            double price = Double.parseDouble(book.getElementsByTagName("price").item(0).getTextContent());
            totalPrice += price;

            System.out.printf("%s, %s, %d, %s, %.2f%n", title, author, year, genre, price);
        }

        System.out.printf("Средняя цена: %.2f%n", totalPrice / books.getLength());

        // Фильтрация по жанру:
        String filterGenre = "Роман";
        System.out.printf("Книги жанра '%s':%n", filterGenre);
        for (int i = 0; i < books.getLength(); i++) {
            Element book = (Element) books.item(i);
            String genre = book.getElementsByTagName("genre").item(0).getTextContent();
            if (genre.equalsIgnoreCase(filterGenre)) {
                String title = book.getElementsByTagName("title").item(0).getTextContent();
                System.out.println(title);
            }
        }
    }
}
