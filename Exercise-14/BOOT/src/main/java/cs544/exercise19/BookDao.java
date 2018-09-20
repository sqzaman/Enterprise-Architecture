package cs544.exercise19;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import cs544.sample.NoSuchResourceException;
@Repository
public class BookDao implements IBookDao {
	private static int idCount = 1;
	private Map<Integer, Book> books = new HashMap<>();
	
	public BookDao() {		
		add(new Book("Intro to Algo", "987847", "T H Coreman", 50.00));
		add(new Book("Algorithm Design Manual", "748956", "S Skeina", 40.00));
		add(new Book("Competetive Programming", "7414789", "Steven Halim", 30.00));
	}
	
	@Override
	public List<Book> getAll() {
		return new ArrayList<Book>(books.values());
	}
	
	@Override
	public void add(Book book) {
		book.setId(idCount);
		books.put(idCount, book);
		idCount++;
	}
	
	@Override
	public Book get(int id) {
		Book result = books.get(id);
		
		if (result == null) {
			throw new NoSuchResourceException("Book", id);
		}
		
		return result;
	}
	
	@Override
	public void update(int bookId, Book book) {
		books.put(bookId, book);
	}
	
	@Override
	public void delete(int bookId) {
		Book removed = books.remove(bookId);
		if (removed == null) {
			throw new NoSuchResourceException("Book", bookId);
		}
	}
}
