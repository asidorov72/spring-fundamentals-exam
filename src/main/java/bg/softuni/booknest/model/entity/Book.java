package bg.softuni.booknest.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "books")
public class Book extends BaseEntity {

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String author;

    @Column(columnDefinition = "TEXT")
    private String description;

    @Column(nullable = false)
    private String genre;

    @Column(nullable = false)
    private boolean available;

    @Column(nullable = false, name = "release_year")
    private int releaseYear;

    public String getTitle() {
        return title;
    }

    public Book setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getAuthor() {
        return author;
    }

    public Book setAuthor(String author) {
        this.author = author;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public Book setDescription(String description) {
        this.description = description;
        return this;
    }

    public String getGenre() {
        return genre;
    }

    public Book setGenre(String genre) {
        this.genre = genre;
        return this;
    }

    public boolean isAvailable() {
        return available;
    }

    public Book setAvailable(boolean available) {
        this.available = available;
        return this;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public Book setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
        return this;
    }
}