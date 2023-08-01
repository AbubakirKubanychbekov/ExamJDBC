package GroupA.model;

import GroupA.enums.Genre;

import java.util.Date;

public class Book {
private Long id;
private String title;
private String author;
private int publicationDate;
private Genre genre;

    public Book() {
    }

    public Book(String title, String author, int publicationDate, Genre genre) {
        this.title = title;
        this.author = author;
        this.publicationDate = publicationDate;
        this.genre = genre;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getPublicationDate() {
        return publicationDate;
    }

    public void setPublicationDate(int publicationDate) {
        this.publicationDate = publicationDate;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", publicationDate=" + publicationDate +
                ", genre=" + genre +
                '}';
    }
}
