
interface Iterator<T> {
    boolean hasNext();

    T next();
}

interface Aggregate<T> {
    Iterator<T> createIterator();
}

class Book {
    private String title;

    public Book(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
}

class BookIterator implements Iterator<Book> {
    private Book[] books;
    private int position;

    public BookIterator(Book[] books) {
        this.books = books;
        this.position = 0;
    }

    @Override
    public boolean hasNext() {
        return position < books.length;
    }

    @Override
    public Book next() {
        if (hasNext()) {
            return books[position++];
        }
        return null;
    }
}

class Library implements Aggregate<Book> {
    private Book[] books;

    public Library(Book[] books) {
        this.books = books;
    }

    @Override
    public Iterator<Book> createIterator() {
        return new BookIterator(books);
    }
}

public class IteratorPattern {
    public static void main(String[] args) {
        Book[] books = { new Book("Book 1"), new Book("Book 2"), new Book("Book 3") };
        Library library = new Library(books);
        Iterator<Book> iterator = library.createIterator();
        while (iterator.hasNext()) {
            Book book = iterator.next();
            System.out.println("Title: " + book.getTitle());
        }
    }
}
