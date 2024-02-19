package ru.voronina.gb.repositories;

import lombok.AllArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import ru.voronina.gb.config.DbConfig;
import ru.voronina.gb.model.Book;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
@AllArgsConstructor

public class BookRepository {

    private final JdbcTemplate jdbcTemplate;
    private final DbConfig dbConfig;

    public List<Book> findAll() {
        return jdbcTemplate.query(dbConfig.getFindAllBooks(), new BookMapper());
    }

    public Book save(Book book) {
        jdbcTemplate.update(dbConfig.getSaveBook(), book.getName(), book.getAuthor(), book.getYearOfWriting());
        return book;
    }

    public Book getBookById(int id) {
        return jdbcTemplate.queryForObject(dbConfig.getGetBookById(), new Object[]{id}, new BookMapper());
    }

    public void update(int id, Book updateBook) {
        jdbcTemplate.update(dbConfig.getUpdateBook(),
                updateBook.getName(),
                updateBook.getAuthor(),
                updateBook.getYearOfWriting(),
                id);
    }

    public void delete(int id) {
        jdbcTemplate.update(dbConfig.getDeleteBook(), id);
    }

     class BookMapper implements RowMapper<Book> {
         @Override
         public Book mapRow(ResultSet resultSet, int i) throws SQLException {
             Book book = new Book();

             book.setId(resultSet.getInt("bookId"));
             book.setName(resultSet.getString("name"));
             book.setAuthor(resultSet.getString("author"));
             book.setYearOfWriting(resultSet.getInt("yearOfWriting"));

             return book;
         }

     }
}
