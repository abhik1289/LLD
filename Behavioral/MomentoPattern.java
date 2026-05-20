
class Momento {
    private String state;

    public Momento(String state) {
        this.state = state;
    }

    public String getState() {
        return state;
    }
}

class TextEditor {
    private String content;

    public void setContent(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    public Momento save() {
        return new Momento(content);
    }

    public void restore(Momento momento) {
        this.content = momento.getState();
    }
}

class History {
    private Momento momentos;

    public void saveState(Momento momento) {
        this.momentos = momento;
    }

    public Momento getState(int index) {
        return momentos;
    }

}

public class MomentoPattern {
    public static void main(String[] args) {
        TextEditor editor = new TextEditor();
        History history = new History();
        editor.setContent("Hello, World!");
        history.saveState(editor.save());
        editor.setContent("Hello, Momento Pattern!");
        System.out.println("Current Content: " + editor.getContent());
        editor.restore(history.getState(0));
        System.out.println("Restored Content: " + editor.getContent());
    }
}
