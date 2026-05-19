// import java.util.*;

enum Priority {
    LOW, MEDIUM, HIGH
}

class Reqest {
    private Priority priority;

    public Reqest(Priority priority) {
        this.priority = priority;
    }

    public Priority getPriority() {
        return priority;
    }
}

interface SupportHandler {
    void handleRequest(Reqest request);

    void setNextHandler(SupportHandler handler);
}

abstract class AbstractSupportHandler implements SupportHandler {
    protected SupportHandler nextHandler;

    @Override
    public void setNextHandler(SupportHandler handler) {
        this.nextHandler = handler;
    }
}

class LevelOneSupportHandler extends AbstractSupportHandler {
    @Override
    public void handleRequest(Reqest request) {
        if (request.getPriority() == Priority.LOW) {
            System.out.println("Level One Support handled the request.");
        } else if (nextHandler != null) {
            nextHandler.handleRequest(request);
        }
    }
}

class LevelTwoSupportHandler extends AbstractSupportHandler {
    @Override
    public void handleRequest(Reqest request) {
        if (request.getPriority() == Priority.MEDIUM) {
            System.out.println("Level Two Support handled the request.");
        } else if (nextHandler != null) {
            nextHandler.handleRequest(request);
        }
    }
}

class LevelThreeSupportHandler extends AbstractSupportHandler {
    @Override
    public void handleRequest(Reqest request) {
        if (request.getPriority() == Priority.HIGH) {
            System.out.println("Level Three Support handled the request.");
        } else if (nextHandler != null) {
            nextHandler.handleRequest(request);
        }
    }
}

public class ChainOfResponblity {
    public static void main(String[] args) {
        SupportHandler levelOne = new LevelOneSupportHandler();
        SupportHandler levelTwo = new LevelTwoSupportHandler();
        SupportHandler levelThree = new LevelThreeSupportHandler();

        levelOne.setNextHandler(levelTwo);
        levelTwo.setNextHandler(levelThree);

        Reqest lowPriorityRequest = new Reqest(Priority.LOW);
        // Reqest mediumPriorityRequest = new Reqest(Priority.MEDIUM);
        Reqest highPriorityRequest = new Reqest(Priority.HIGH);

        levelOne.handleRequest(lowPriorityRequest);
        // levelOne.handleRequest(mediumPriorityRequest);
        levelOne.handleRequest(highPriorityRequest);
    }
}