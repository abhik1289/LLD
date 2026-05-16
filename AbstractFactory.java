
import java.util.*;

interface Button {
    void paint();
}

interface Checkbox {
    void paint();
}

class WindowsButton implements Button {
    public void paint() {
        System.out.println("Rendering a button in Windows style.");
    }
}

class WindowsCheckbox implements Checkbox {
    public void paint() {
        System.out.println("Rendering a checkbox in Windows style.");
    }
}

class MacButton implements Button {
    public void paint() {
        System.out.println("Mac Button");
    }
}

class MacCheckbox implements Checkbox {
    public void paint() {
        System.out.println("Mac Checkbox");
    }
}

interface GUIFactory {
    Button createButton();

    Checkbox createCheckbox();
}

class WindowsFactory implements GUIFactory {

    public Button createButton() {
        return new WindowsButton();
    }

    public Checkbox createCheckbox() {
        return new WindowsCheckbox();
    }
}

class MacFactory implements GUIFactory {

    public Button createButton() {
        return new MacButton();
    }

    public Checkbox createCheckbox() {
        return new MacCheckbox();
    }
}

public class AbstractFactory {
    public static void main(String[] args) {
        GUIFactory guifactory;

        String os = System.getProperty("os.name").toLowerCase();
        if (os.contains("win")) {
            guifactory = new WindowsFactory();
        } else {
            guifactory = new MacFactory();
        }
        Button button = guifactory.createButton();
        Checkbox checkbox = guifactory.createCheckbox();
        button.paint();
        checkbox.paint();
    }
}