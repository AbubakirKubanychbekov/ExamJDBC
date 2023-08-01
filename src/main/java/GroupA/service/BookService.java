package GroupA.service;

import GroupA.enums.Genre;
import GroupA.model.Book;

import java.util.List;

public interface BookService {
    void createTable(String tableName, List<String> columns);
    void save(Book book);
    Book getBooksByGenre(Genre genre);
}
