
interface Visitor {
    void visit(StoryBook book);

    void visit(Fruit fruit);
}

interface Item {
    void accept(Visitor visitor);
}

class StoryBook implements Item {
    public String title;
    public String author;

    public StoryBook(String title, String author) {
        this.title = title;
        this.author = author;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}

class Fruit implements Item {
    public String name;
    public String color;

    public Fruit(String name, String color) {
        this.name = name;
        this.color = color;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}

class BookVisitor implements Visitor {
    @Override
    public void visit(StoryBook book) {
        System.out.println("Visiting StoryBook: " + book.title + " by " + book.author);
    }

    @Override
    public void visit(Fruit fruit) {
        System.out.println("Visiting Fruit: " + fruit.name + " which is " + fruit.color);
    }
}

public class VisitorPattern {
    public static void main(String[] args) {
        Item[] items = {
                new StoryBook("The Great Gatsby", "F. Scott Fitzgerald"),
                new Fruit("Apple", "Red"),
                new Fruit("Banana", "Yellow")
        };
        Visitor visitor = new BookVisitor();
        for (Item item : items) {
            item.accept(visitor);
        }
    }
}
