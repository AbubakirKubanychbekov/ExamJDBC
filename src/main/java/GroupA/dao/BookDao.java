package GroupA.dao;

import GroupA.enums.Genre;
import GroupA.model.Book;

import java.util.List;

public interface BookDao {
    void createTable(String tableName, List<String> columns);
    void save(Book book);
   Book getBooksByGenre(Genre genre);

   Book updateBook(Long id, Book newBook);
   Book deleteBook(Long id);
   void getBooksGroupedByAuthor();
   void getBooksSortedByPublicationDate(String ascOrDesc);

}
