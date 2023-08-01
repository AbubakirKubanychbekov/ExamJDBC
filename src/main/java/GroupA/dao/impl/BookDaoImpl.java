package GroupA.dao.impl;

import GroupA.config.JDBCConfig;
import GroupA.dao.BookDao;
import GroupA.enums.Genre;
import GroupA.model.Book;

import java.sql.*;
import java.util.List;

public class BookDaoImpl implements BookDao {

    private final Connection connection = JDBCConfig.getConnection();
    @Override
    public void createTable(String tableName, List<String> columns) {
        StringBuilder stringBuilder =
                new StringBuilder(String.format("create table %s (",tableName));
        try {
            Statement statement = connection.createStatement();
            for (int i = 0; i < columns.size(); i++) {
                stringBuilder.append(columns.get(i));
                if (i < columns.size() - 1){
                    stringBuilder.append(", ");
                }
            }
            stringBuilder.append(")");
            statement.executeUpdate(stringBuilder.toString());
            statement.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void save(Book book) {
        try(PreparedStatement preparedStatement = connection.prepareStatement("""
                    insert into books (title, author, publication_date,genre)
                    values (?, ?, ?, ?)
                    """)){

            preparedStatement.setString(1, book.getTitle());
            preparedStatement.setString(2, book.getAuthor());
            preparedStatement.setInt(3, book.getPublicationDate());
            preparedStatement.setString(4,book.getGenre().name());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Book getBooksByGenre(Genre genre) {
        Book book = new Book();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("""
                    select * from books where genre = ?
                    """);
            preparedStatement.setString(1, genre.name());
            ResultSet resultSet = preparedStatement.executeQuery();

            if (!(resultSet.next())){
                System.err.println("Movie with id:  "+genre+ "not found!!!");
            }
            else {
                book.setId(resultSet.getLong("id"));
                book.setTitle(resultSet.getString("title"));
                book.setAuthor(resultSet.getString("author"));
                book.setPublicationDate(resultSet.getInt("publication_date"));

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


        return book;
    }
}

