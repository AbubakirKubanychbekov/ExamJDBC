package GroupA;

import GroupA.enums.Genre;
import GroupA.model.Book;
import GroupA.service.BookService;
import GroupA.service.impl.BookServiceImpl;

import java.awt.image.AbstractMultiResolutionImage;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) {

        BookService bookService = new BookServiceImpl();
//        bookService.createTable(
//                "books",
//                List.of(
//                        "id serial primary key",
//                        "title varchar",
//                        "author varchar",
//                        "publication_date int",
//                        "genre Genre"
//                ));


        Scanner scannerForStr = new Scanner(System.in);
        Scanner scannerForNum = new Scanner(System.in);

        while (true) {
            System.out.println("1.Save" +
                    "\n2.FindByGenre");
            switch (new Scanner(System.in).nextLine()) {
                case "1" -> {
                    System.out.println("Write title: ");
                    String title = scannerForStr.nextLine();
                    System.out.println("Write author:");
                    String author = scannerForStr.nextLine();
                    System.out.println("Write publication date: ");
                    int publication = scannerForNum.nextInt();
                    System.out.println("Write genre: ");
                    String genre=scannerForStr.nextLine();
                    bookService.save(new Book(title, author, publication,Genre.valueOf(genre)));
                }case "2" -> {
                    System.out.println("write genre by find: ");
                    String genre=scannerForStr.nextLine();
                    System.out.println(bookService.getBooksByGenre(Genre.valueOf(genre)));
                }

            }
        }
    }
}