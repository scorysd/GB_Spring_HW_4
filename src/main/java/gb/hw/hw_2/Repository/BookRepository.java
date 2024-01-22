package gb.hw.hw_2.Repository;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;
import gb.hw.hw_2.Models.Book;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Repository
public class BookRepository {

  private final List<Book> books;

  public BookRepository() {
    this.books = new ArrayList<>();
  }

  @PostConstruct
  public void generateData() {
    books.addAll(List.of(
      new Book("война и мир", "Толстой"),
      new Book("метрвые души", "Гоголь"),
      new Book("чистый код", "Мартин")
    ));
  }

  public Book getBookById(long id) {
    return books.stream().filter(it -> Objects.equals(it.getId(), id))
      .findFirst()
      .orElse(null);
  }

  public List<Book> getAllBooks(){
    return List.copyOf(books);
  }
  public void createBook(String name, String author){
    books.add(new Book(name, author));
  }

  public List<Book> deleteBook(long id) {
      Book exist = getBookById(id);
      if (exist == null) {
        System.out.println("Do not exist Book!");
      } else {
        books.remove(exist);
      }
      return books;
    }
}
