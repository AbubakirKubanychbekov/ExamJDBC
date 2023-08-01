package GroupA.service.impl;

import GroupA.dao.BookDao;
import GroupA.dao.impl.BookDaoImpl;
import GroupA.enums.Genre;
import GroupA.model.Book;
import GroupA.service.BookService;

import java.util.List;

public class BookServiceImpl implements BookService {

    BookDao bookDao=new BookDaoImpl();
    @Override
    public void createTable(String tableName, List<String> columns) {
        bookDao.createTable(tableName, columns);
    }

    @Override
    public void save(Book book) {
        bookDao.save(book);
    }

    @Override
    public Book getBooksByGenre(Genre genre) {
        return bookDao.getBooksByGenre(genre);
    }
}
