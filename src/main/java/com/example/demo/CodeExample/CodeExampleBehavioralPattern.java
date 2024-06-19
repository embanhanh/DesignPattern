package com.example.demo.CodeExample;

public class CodeExampleBehavioralPattern {
    public static String getCodeJavaByNameBehavioralPattern(String pattern) {
        return switch (pattern) {
            case "Chain of Responsibility" -> "// Handler interface\n" +
                    "interface Handler {\n" +
                    "    void setNext(Handler handler);\n" +
                    "    void handleRequest(String request);\n" +
                    "}\n" +
                    "\n" +
                    "// Concrete Handlers\n" +
                    "class ConcreteHandler1 implements Handler {\n" +
                    "    private Handler next;\n" +
                    "\n" +
                    "    @Override\n" +
                    "    public void setNext(Handler handler) {\n" +
                    "        this.next = handler;\n" +
                    "    }\n" +
                    "\n" +
                    "    @Override\n" +
                    "    public void handleRequest(String request) {\n" +
                    "        if (request.equals(\"Handler1\")) {\n" +
                    "            System.out.println(\"Handled by Handler1\");\n" +
                    "        } else if (next != null) {\n" +
                    "            next.handleRequest(request);\n" +
                    "        }\n" +
                    "    }\n" +
                    "}\n" +
                    "\n" +
                    "class ConcreteHandler2 implements Handler {\n" +
                    "    private Handler next;\n" +
                    "\n" +
                    "    @Override\n" +
                    "    public void setNext(Handler handler) {\n" +
                    "        this.next = handler;\n" +
                    "    }\n" +
                    "\n" +
                    "    @Override\n" +
                    "    public void handleRequest(String request) {\n" +
                    "        if (request.equals(\"Handler2\")) {\n" +
                    "            System.out.println(\"Handled by Handler2\");\n" +
                    "        } else if (next != null) {\n" +
                    "            next.handleRequest(request);\n" +
                    "        }\n" +
                    "    }\n" +
                    "}\n" +
                    "\n" +
                    "// Client\n" +
                    "public class ChainOfResponsibilityDemo {\n" +
                    "    public static void main(String[] args) {\n" +
                    "        Handler handler1 = new ConcreteHandler1();\n" +
                    "        Handler handler2 = new ConcreteHandler2();\n" +
                    "\n" +
                    "        handler1.setNext(handler2);\n" +
                    "\n" +
                    "        handler1.handleRequest(\"Handler1\");\n" +
                    "        handler1.handleRequest(\"Handler2\");\n" +
                    "    }\n" +
                    "}\n";
            case "Command" -> "// Command interface\n" +
                    "interface Command {\n" +
                    "    void execute();\n" +
                    "}\n" +
                    "\n" +
                    "// Concrete Commands\n" +
                    "class LightOnCommand implements Command {\n" +
                    "    private Light light;\n" +
                    "\n" +
                    "    public LightOnCommand(Light light) {\n" +
                    "        this.light = light;\n" +
                    "    }\n" +
                    "\n" +
                    "    @Override\n" +
                    "    public void execute() {\n" +
                    "        light.on();\n" +
                    "    }\n" +
                    "}\n" +
                    "\n" +
                    "class LightOffCommand implements Command {\n" +
                    "    private Light light;\n" +
                    "\n" +
                    "    public LightOffCommand(Light light) {\n" +
                    "        this.light = light;\n" +
                    "    }\n" +
                    "\n" +
                    "    @Override\n" +
                    "    public void execute() {\n" +
                    "        light.off();\n" +
                    "    }\n" +
                    "}\n" +
                    "\n" +
                    "// Receiver\n" +
                    "class Light {\n" +
                    "    public void on() {\n" +
                    "        System.out.println(\"Light is ON\");\n" +
                    "    }\n" +
                    "\n" +
                    "    public void off() {\n" +
                    "        System.out.println(\"Light is OFF\");\n" +
                    "    }\n" +
                    "}\n" +
                    "\n" +
                    "// Invoker\n" +
                    "class RemoteControl {\n" +
                    "    private Command command;\n" +
                    "\n" +
                    "    public void setCommand(Command command) {\n" +
                    "        this.command = command;\n" +
                    "    }\n" +
                    "\n" +
                    "    public void pressButton() {\n" +
                    "        command.execute();\n" +
                    "    }\n" +
                    "}\n" +
                    "\n" +
                    "// Client\n" +
                    "public class CommandDemo {\n" +
                    "    public static void main(String[] args) {\n" +
                    "        Light light = new Light();\n" +
                    "        Command lightOn = new LightOnCommand(light);\n" +
                    "        Command lightOff = new LightOffCommand(light);\n" +
                    "\n" +
                    "        RemoteControl remote = new RemoteControl();\n" +
                    "        remote.setCommand(lightOn);\n" +
                    "        remote.pressButton();\n" +
                    "\n" +
                    "        remote.setCommand(lightOff);\n" +
                    "        remote.pressButton();\n" +
                    "    }\n" +
                    "}\n";
            case "Iterator" -> "// Iterator interface\n" +
                    "interface Iterator {\n" +
                    "    boolean hasNext();\n" +
                    "    Object next();\n" +
                    "}\n" +
                    "\n" +
                    "// Collection interface\n" +
                    "interface Collection {\n" +
                    "    Iterator createIterator();\n" +
                    "}\n" +
                    "\n" +
                    "// Concrete Collection\n" +
                    "class NameCollection implements Collection {\n" +
                    "    public String names[] = {\"John\", \"Jane\", \"Doe\"};\n" +
                    "\n" +
                    "    @Override\n" +
                    "    public Iterator createIterator() {\n" +
                    "        return new NameIterator();\n" +
                    "    }\n" +
                    "\n" +
                    "    // Concrete Iterator\n" +
                    "    private class NameIterator implements Iterator {\n" +
                    "        int index;\n" +
                    "\n" +
                    "        @Override\n" +
                    "        public boolean hasNext() {\n" +
                    "            return index < names.length;\n" +
                    "        }\n" +
                    "\n" +
                    "        @Override\n" +
                    "        public Object next() {\n" +
                    "            if (this.hasNext()) {\n" +
                    "                return names[index++];\n" +
                    "            }\n" +
                    "            return null;\n" +
                    "        }\n" +
                    "    }\n" +
                    "}\n" +
                    "\n" +
                    "// Client\n" +
                    "public class IteratorDemo {\n" +
                    "    public static void main(String[] args) {\n" +
                    "        NameCollection nameCollection = new NameCollection();\n" +
                    "\n" +
                    "        for (Iterator iter = nameCollection.createIterator(); iter.hasNext();) {\n" +
                    "            String name = (String) iter.next();\n" +
                    "            System.out.println(\"Name: \" + name);\n" +
                    "        }\n" +
                    "    }\n" +
                    "}\n";
            case "Mediator"  -> "// Mediator interface\n" +
                    "interface Mediator {\n" +
                    "    void sendMessage(String message, Colleague colleague);\n" +
                    "}\n" +
                    "\n" +
                    "// Concrete Mediator\n" +
                    "class ConcreteMediator implements Mediator {\n" +
                    "    private Colleague1 colleague1;\n" +
                    "    private Colleague2 colleague2;\n" +
                    "\n" +
                    "    public void setColleague1(Colleague1 colleague1) {\n" +
                    "        this.colleague1 = colleague1;\n" +
                    "    }\n" +
                    "\n" +
                    "    public void setColleague2(Colleague2 colleague2) {\n" +
                    "        this.colleague2 = colleague2;\n" +
                    "    }\n" +
                    "\n" +
                    "    @Override\n" +
                    "    public void sendMessage(String message, Colleague colleague) {\n" +
                    "        if (colleague == colleague1) {\n" +
                    "            colleague2.notify(message);\n" +
                    "        } else {\n" +
                    "            colleague1.notify(message);\n" +
                    "        }\n" +
                    "    }\n" +
                    "}\n" +
                    "\n" +
                    "// Colleague abstract class\n" +
                    "abstract class Colleague {\n" +
                    "    protected Mediator mediator;\n" +
                    "\n" +
                    "    public Colleague(Mediator mediator) {\n" +
                    "        this.mediator = mediator;\n" +
                    "    }\n" +
                    "}\n" +
                    "\n" +
                    "// Concrete Colleagues\n" +
                    "class Colleague1 extends Colleague {\n" +
                    "    public Colleague1(Mediator mediator) {\n" +
                    "        super(mediator);\n" +
                    "    }\n" +
                    "\n" +
                    "    public void send(String message) {\n" +
                    "        mediator.sendMessage(message, this);\n" +
                    "    }\n" +
                    "\n" +
                    "    public void notify(String message) {\n" +
                    "        System.out.println(\"Colleague1 gets message: \" + message);\n" +
                    "    }\n" +
                    "}\n" +
                    "\n" +
                    "class Colleague2 extends Colleague {\n" +
                    "    public Colleague2(Mediator mediator) {\n" +
                    "        super(mediator);\n" +
                    "    }\n" +
                    "\n" +
                    "    public void send(String message) {\n" +
                    "        mediator.sendMessage(message, this);\n" +
                    "    }\n" +
                    "\n" +
                    "    public void notify(String message) {\n" +
                    "        System.out.println(\"Colleague2 gets message: \" + message);\n" +
                    "    }\n" +
                    "}\n" +
                    "\n" +
                    "// Client\n" +
                    "public class MediatorDemo {\n" +
                    "    public static void main(String[] args) {\n" +
                    "        ConcreteMediator mediator = new ConcreteMediator();\n" +
                    "        Colleague1 colleague1 = new Colleague1(mediator);\n" +
                    "        Colleague2 colleague2 = new Colleague2(mediator);\n" +
                    "\n" +
                    "        mediator.setColleague1(colleague1);\n" +
                    "        mediator.setColleague2(colleague2);\n" +
                    "\n" +
                    "        colleague1.send(\"Hello, Colleague2!\");\n" +
                    "        colleague2.send(\"Hi, Colleague1!\");\n" +
                    "    }\n" +
                    "}\n";
            case "Memento"  -> "// Memento class\n" +
                    "class Memento {\n" +
                    "    private String state;\n" +
                    "\n" +
                    "    public Memento(String state) {\n" +
                    "        this.state = state;\n" +
                    "    }\n" +
                    "\n" +
                    "    public String getState() {\n" +
                    "        return state;\n" +
                    "    }\n" +
                    "}\n" +
                    "\n" +
                    "// Originator class\n" +
                    "class Originator {\n" +
                    "    private String state;\n" +
                    "\n" +
                    "    public void setState(String state) {\n" +
                    "        this.state = state;\n" +
                    "    }\n" +
                    "\n" +
                    "    public String getState() {\n" +
                    "        return state;\n" +
                    "    }\n" +
                    "\n" +
                    "    public Memento saveStateToMemento() {\n" +
                    "        return new Memento(state);\n" +
                    "    }\n" +
                    "\n" +
                    "    public void getStateFromMemento(Memento memento) {\n" +
                    "        state = memento.getState();\n" +
                    "    }\n" +
                    "}\n" +
                    "\n" +
                    "// Caretaker class\n" +
                    "class Caretaker {\n" +
                    "    private List<Memento> mementoList = new ArrayList<>();\n" +
                    "\n" +
                    "    public void add(Memento state) {\n" +
                    "        mementoList.add(state);\n" +
                    "    }\n" +
                    "\n" +
                    "    public Memento get(int index) {\n" +
                    "        return mementoList.get(index);\n" +
                    "    }\n" +
                    "}\n" +
                    "\n" +
                    "// Client\n" +
                    "public class MementoDemo {\n" +
                    "    public static void main(String[] args) {\n" +
                    "        Originator originator = new Originator();\n" +
                    "        Caretaker caretaker = new Caretaker();\n" +
                    "\n" +
                    "        originator.setState(\"State #1\");\n" +
                    "        originator.setState(\"State #2\");\n" +
                    "        caretaker.add(originator.saveStateToMemento());\n" +
                    "\n" +
                    "        originator.setState(\"State #3\");\n" +
                    "        caretaker.add(originator.saveStateToMemento());\n" +
                    "\n" +
                    "        originator.setState(\"State #4\");\n" +
                    "        System.out.println(\"Current State: \" + originator.getState());\n" +
                    "\n" +
                    "        originator.getStateFromMemento(caretaker.get(0));\n" +
                    "        System.out.println(\"First saved State: \" + originator.getState());\n" +
                    "        originator.getStateFromMemento(caretaker.get(1));\n" +
                    "        System.out.println(\"Second saved State: \" + originator.getState());\n" +
                    "    }\n" +
                    "}\n";
            case "Observer"  -> "// Observer interface\n" +
                    "interface Observer {\n" +
                    "    void update(String message);\n" +
                    "}\n" +
                    "\n" +
                    "// Subject interface\n" +
                    "interface Subject {\n" +
                    "    void registerObserver(Observer observer);\n" +
                    "    void removeObserver(Observer observer);\n" +
                    "    void notifyObservers();\n" +
                    "}\n" +
                    "\n" +
                    "// Concrete Subject\n" +
                    "class ConcreteSubject implements Subject {\n" +
                    "    private List<Observer> observers = new ArrayList<>();\n" +
                    "    private String message;\n" +
                    "\n" +
                    "    @Override\n" +
                    "    public void registerObserver(Observer observer) {\n" +
                    "        observers.add(observer);\n" +
                    "    }\n" +
                    "\n" +
                    "    @Override\n" +
                    "    public void removeObserver(Observer observer) {\n" +
                    "        observers.remove(observer);\n" +
                    "    }\n" +
                    "\n" +
                    "    @Override\n" +
                    "    public void notifyObservers() {\n" +
                    "        for (Observer observer : observers) {\n" +
                    "            observer.update(message);\n" +
                    "        }\n" +
                    "    }\n" +
                    "\n" +
                    "    public void setMessage(String message) {\n" +
                    "        this.message = message;\n" +
                    "        notifyObservers();\n" +
                    "    }\n" +
                    "}\n" +
                    "\n" +
                    "// Concrete Observer\n" +
                    "class ConcreteObserver implements Observer {\n" +
                    "    private String name;\n" +
                    "\n" +
                    "    public ConcreteObserver(String name) {\n" +
                    "        this.name = name;\n" +
                    "    }\n" +
                    "\n" +
                    "    @Override\n" +
                    "    public void update(String message) {\n" +
                    "        System.out.println(name + \" received message: \" + message);\n" +
                    "    }\n" +
                    "}\n" +
                    "\n" +
                    "// Client\n" +
                    "public class ObserverDemo {\n" +
                    "    public static void main(String[] args) {\n" +
                    "        ConcreteSubject subject = new ConcreteSubject();\n" +
                    "\n" +
                    "        Observer observer1 = new ConcreteObserver(\"Observer1\");\n" +
                    "        Observer observer2 = new ConcreteObserver(\"Observer2\");\n" +
                    "\n" +
                    "        subject.registerObserver(observer1);\n" +
                    "        subject.registerObserver(observer2);\n" +
                    "\n" +
                    "        subject.setMessage(\"Hello Observers!\");\n" +
                    "\n" +
                    "        subject.removeObserver(observer1);\n" +
                    "\n" +
                    "        subject.setMessage(\"Observer1 removed\");\n" +
                    "    }\n" +
                    "}\n";
            case "State"  -> "// State interface\n" +
                    "interface State {\n" +
                    "    void doAction(Context context);\n" +
                    "}\n" +
                    "\n" +
                    "// Concrete States\n" +
                    "class StartState implements State {\n" +
                    "    @Override\n" +
                    "    public void doAction(Context context) {\n" +
                    "        System.out.println(\"Player is in start state\");\n" +
                    "        context.setState(this);\n" +
                    "    }\n" +
                    "\n" +
                    "    @Override\n" +
                    "    public String toString() {\n" +
                    "        return \"Start State\";\n" +
                    "    }\n" +
                    "}\n" +
                    "\n" +
                    "class StopState implements State {\n" +
                    "    @Override\n" +
                    "    public void doAction(Context context) {\n" +
                    "        System.out.println(\"Player is in stop state\");\n" +
                    "        context.setState(this);\n" +
                    "    }\n" +
                    "\n" +
                    "    @Override\n" +
                    "    public String toString() {\n" +
                    "        return \"Stop State\";\n" +
                    "    }\n" +
                    "}\n" +
                    "\n" +
                    "// Context class\n" +
                    "class Context {\n" +
                    "    private State state;\n" +
                    "\n" +
                    "    public Context() {\n" +
                    "        state = null;\n" +
                    "    }\n" +
                    "\n" +
                    "    public void setState(State state) {\n" +
                    "        this.state = state;\n" +
                    "    }\n" +
                    "\n" +
                    "    public State getState() {\n" +
                    "        return state;\n" +
                    "    }\n" +
                    "}\n" +
                    "\n" +
                    "// Client\n" +
                    "public class StateDemo {\n" +
                    "    public static void main(String[] args) {\n" +
                    "        Context context = new Context();\n" +
                    "\n" +
                    "        StartState startState = new StartState();\n" +
                    "        startState.doAction(context);\n" +
                    "\n" +
                    "        System.out.println(context.getState().toString());\n" +
                    "\n" +
                    "        StopState stopState = new StopState();\n" +
                    "        stopState.doAction(context);\n" +
                    "\n" +
                    "        System.out.println(context.getState().toString());\n" +
                    "    }\n" +
                    "}\n";
            case "Strategy"  -> "// Strategy interface\n" +
                    "interface Strategy {\n" +
                    "    int doOperation(int num1, int num2);\n" +
                    "}\n" +
                    "\n" +
                    "// Concrete Strategies\n" +
                    "class OperationAdd implements Strategy {\n" +
                    "    @Override\n" +
                    "    public int doOperation(int num1, int num2) {\n" +
                    "        return num1 + num2;\n" +
                    "    }\n" +
                    "}\n" +
                    "\n" +
                    "class OperationSubtract implements Strategy {\n" +
                    "    @Override\n" +
                    "    public int doOperation(int num1, int num2) {\n" +
                    "        return num1 - num2;\n" +
                    "    }\n" +
                    "}\n" +
                    "\n" +
                    "class OperationMultiply implements Strategy {\n" +
                    "    @Override\n" +
                    "    public int doOperation(int num1, int num2) {\n" +
                    "        return num1 * num2;\n" +
                    "    }\n" +
                    "}\n" +
                    "\n" +
                    "// Context class\n" +
                    "class Context {\n" +
                    "    private Strategy strategy;\n" +
                    "\n" +
                    "    public Context(Strategy strategy) {\n" +
                    "        this.strategy = strategy;\n" +
                    "    }\n" +
                    "\n" +
                    "    public int executeStrategy(int num1, int num2) {\n" +
                    "        return strategy.doOperation(num1, num2);\n" +
                    "    }\n" +
                    "}\n" +
                    "\n" +
                    "// Client\n" +
                    "public class StrategyDemo {\n" +
                    "    public static void main(String[] args) {\n" +
                    "        Context context = new Context(new OperationAdd());\n" +
                    "        System.out.println(\"10 + 5 = \" + context.executeStrategy(10, 5));\n" +
                    "\n" +
                    "        context = new Context(new OperationSubtract());\n" +
                    "        System.out.println(\"10 - 5 = \" + context.executeStrategy(10, 5));\n" +
                    "\n" +
                    "        context = new Context(new OperationMultiply());\n" +
                    "        System.out.println(\"10 * 5 = \" + context.executeStrategy(10, 5));\n" +
                    "    }\n" +
                    "}\n";
            case "Template Method"  -> "// Abstract class\n" +
                    "abstract class Game {\n" +
                    "    abstract void initialize();\n" +
                    "    abstract void startPlay();\n" +
                    "    abstract void endPlay();\n" +
                    "\n" +
                    "    // Template method\n" +
                    "    public final void play() {\n" +
                    "        initialize();\n" +
                    "        startPlay();\n" +
                    "        endPlay();\n" +
                    "    }\n" +
                    "}\n" +
                    "\n" +
                    "// Concrete classes\n" +
                    "class Cricket extends Game {\n" +
                    "    @Override\n" +
                    "    void initialize() {\n" +
                    "        System.out.println(\"Cricket Game Initialized! Start playing.\");\n" +
                    "    }\n" +
                    "\n" +
                    "    @Override\n" +
                    "    void startPlay() {\n" +
                    "        System.out.println(\"Cricket Game Started. Enjoy the game!\");\n" +
                    "    }\n" +
                    "\n" +
                    "    @Override\n" +
                    "    void endPlay() {\n" +
                    "        System.out.println(\"Cricket Game Finished!\");\n" +
                    "    }\n" +
                    "}\n" +
                    "\n" +
                    "class Football extends Game {\n" +
                    "    @Override\n" +
                    "    void initialize() {\n" +
                    "        System.out.println(\"Football Game Initialized! Start playing.\");\n" +
                    "    }\n" +
                    "\n" +
                    "    @Override\n" +
                    "    void startPlay() {\n" +
                    "        System.out.println(\"Football Game Started. Enjoy the game!\");\n" +
                    "    }\n" +
                    "\n" +
                    "    @Override\n" +
                    "    void endPlay() {\n" +
                    "        System.out.println(\"Football Game Finished!\");\n" +
                    "    }\n" +
                    "}\n" +
                    "\n" +
                    "// Client\n" +
                    "public class TemplateMethodDemo {\n" +
                    "    public static void main(String[] args) {\n" +
                    "        Game game = new Cricket();\n" +
                    "        game.play();\n" +
                    "\n" +
                    "        game = new Football();\n" +
                    "        game.play();\n" +
                    "    }\n" +
                    "}\n";
            case "Visitor" -> "// Visitor interface\n" +
                    "interface ComputerPartVisitor {\n" +
                    "    void visit(Computer computer);\n" +
                    "    void visit(Mouse mouse);\n" +
                    "    void visit(Keyboard keyboard);\n" +
                    "    void visit(Monitor monitor);\n" +
                    "}\n" +
                    "\n" +
                    "// ComputerPart interface\n" +
                    "interface ComputerPart {\n" +
                    "    void accept(ComputerPartVisitor computerPartVisitor);\n" +
                    "}\n" +
                    "\n" +
                    "// Concrete ComputerParts\n" +
                    "class Keyboard implements ComputerPart {\n" +
                    "    @Override\n" +
                    "    public void accept(ComputerPartVisitor computerPartVisitor) {\n" +
                    "        computerPartVisitor.visit(this);\n" +
                    "    }\n" +
                    "}\n" +
                    "\n" +
                    "class Monitor implements ComputerPart {\n" +
                    "    @Override\n" +
                    "    public void accept(ComputerPartVisitor computerPartVisitor) {\n" +
                    "        computerPartVisitor.visit(this);\n" +
                    "    }\n" +
                    "}\n" +
                    "\n" +
                    "class Mouse implements ComputerPart {\n" +
                    "    @Override\n" +
                    "    public void accept(ComputerPartVisitor computerPartVisitor) {\n" +
                    "        computerPartVisitor.visit(this);\n" +
                    "    }\n" +
                    "}\n" +
                    "\n" +
                    "class Computer implements ComputerPart {\n" +
                    "    ComputerPart[] parts;\n" +
                    "\n" +
                    "    public Computer() {\n" +
                    "        parts = new ComputerPart[] {new Mouse(), new Keyboard(), new Monitor()};\n" +
                    "    }\n" +
                    "\n" +
                    "    @Override\n" +
                    "    public void accept(ComputerPartVisitor computerPartVisitor) {\n" +
                    "        for (int i = 0; i < parts.length; i++) {\n" +
                    "            parts[i].accept(computerPartVisitor);\n" +
                    "        }\n" +
                    "        computerPartVisitor.visit(this);\n" +
                    "    }\n" +
                    "}\n" +
                    "\n" +
                    "// Concrete Visitor\n" +
                    "class ComputerPartDisplayVisitor implements ComputerPartVisitor {\n" +
                    "    @Override\n" +
                    "    public void visit(Computer computer) {\n" +
                    "        System.out.println(\"Displaying Computer.\");\n" +
                    "    }\n" +
                    "\n" +
                    "    @Override\n" +
                    "    public void visit(Mouse mouse) {\n" +
                    "        System.out.println(\"Displaying Mouse.\");\n" +
                    "    }\n" +
                    "\n" +
                    "    @Override\n" +
                    "    public void visit(Keyboard keyboard) {\n" +
                    "        System.out.println(\"Displaying Keyboard.\");\n" +
                    "    }\n" +
                    "\n" +
                    "    @Override\n" +
                    "    public void visit(Monitor monitor) {\n" +
                    "        System.out.println(\"Displaying Monitor.\");\n" +
                    "    }\n" +
                    "}\n" +
                    "\n" +
                    "// Client\n" +
                    "public class VisitorDemo {\n" +
                    "    public static void main(String[] args) {\n" +
                    "        ComputerPart computer = new Computer();\n" +
                    "        computer.accept(new ComputerPartDisplayVisitor());\n" +
                    "    }\n" +
                    "}\n";
            // More cases...
            default -> "Error for load code";
        };
    }
    public static String getCodePythonByNameBehavioralPattern(String pattern) {
        return switch (pattern) {
            case "Chain of Responsibility" -> "# Handler interface\n" +
                    "class Handler:\n" +
                    "    def set_next(self, handler):\n" +
                    "        pass\n" +
                    "\n" +
                    "    def handle(self, request):\n" +
                    "        pass\n" +
                    "\n" +
                    "# Concrete Handlers\n" +
                    "class ConcreteHandler1(Handler):\n" +
                    "    def __init__(self):\n" +
                    "        self.next_handler = None\n" +
                    "\n" +
                    "    def set_next(self, handler):\n" +
                    "        self.next_handler = handler\n" +
                    "\n" +
                    "    def handle(self, request):\n" +
                    "        if request == \"Handler1\":\n" +
                    "            print(\"Handled by Handler1\")\n" +
                    "        elif self.next_handler:\n" +
                    "            self.next_handler.handle(request)\n" +
                    "\n" +
                    "class ConcreteHandler2(Handler):\n" +
                    "    def __init__(self):\n" +
                    "        self.next_handler = None\n" +
                    "\n" +
                    "    def set_next(self, handler):\n" +
                    "        self.next_handler = handler\n" +
                    "\n" +
                    "    def handle(self, request):\n" +
                    "        if request == \"Handler2\":\n" +
                    "            print(\"Handled by Handler2\")\n" +
                    "        elif self.next_handler:\n" +
                    "            self.next_handler.handle(request)\n" +
                    "\n" +
                    "# Client\n" +
                    "if __name__ == \"__main__\":\n" +
                    "    handler1 = ConcreteHandler1()\n" +
                    "    handler2 = ConcreteHandler2()\n" +
                    "\n" +
                    "    handler1.set_next(handler2)\n" +
                    "\n" +
                    "    handler1.handle(\"Handler1\")\n" +
                    "    handler1.handle(\"Handler2\")\n";
            case "Command" -> "# Command interface\n" +
                    "class Command:\n" +
                    "    def execute(self):\n" +
                    "        pass\n" +
                    "\n" +
                    "# Concrete Commands\n" +
                    "class LightOnCommand(Command):\n" +
                    "    def __init__(self, light):\n" +
                    "        self.light = light\n" +
                    "\n" +
                    "    def execute(self):\n" +
                    "        self.light.on()\n" +
                    "\n" +
                    "class LightOffCommand(Command):\n" +
                    "    def __init__(self, light):\n" +
                    "        self.light = light\n" +
                    "\n" +
                    "    def execute(self):\n" +
                    "        self.light.off()\n" +
                    "\n" +
                    "# Receiver\n" +
                    "class Light:\n" +
                    "    def on(self):\n" +
                    "        print(\"Light is ON\")\n" +
                    "\n" +
                    "    def off(self):\n" +
                    "        print(\"Light is OFF\")\n" +
                    "\n" +
                    "# Invoker\n" +
                    "class RemoteControl:\n" +
                    "    def __init__(self):\n" +
                    "        self.command = None\n" +
                    "\n" +
                    "    def set_command(self, command):\n" +
                    "        self.command = command\n" +
                    "\n" +
                    "    def press_button(self):\n" +
                    "        self.command.execute()\n" +
                    "\n" +
                    "# Client\n" +
                    "if __name__ == \"__main__\":\n" +
                    "    light = Light()\n" +
                    "    light_on = LightOnCommand(light)\n" +
                    "    light_off = LightOffCommand(light)\n" +
                    "\n" +
                    "    remote = RemoteControl()\n" +
                    "    remote.set_command(light_on)\n" +
                    "    remote.press_button()\n" +
                    "\n" +
                    "    remote.set_command(light_off)\n" +
                    "    remote.press_button()\n";
            case "Iterator" -> "# Iterator interface\n" +
                    "class Iterator:\n" +
                    "    def has_next(self):\n" +
                    "        pass\n" +
                    "\n" +
                    "    def next(self):\n" +
                    "        pass\n" +
                    "\n" +
                    "# Collection interface\n" +
                    "class Collection:\n" +
                    "    def create_iterator(self):\n" +
                    "        pass\n" +
                    "\n" +
                    "# Concrete Collection\n" +
                    "class NameCollection(Collection):\n" +
                    "    def __init__(self):\n" +
                    "        self.names = [\"John\", \"Jane\", \"Doe\"]\n" +
                    "\n" +
                    "    def create_iterator(self):\n" +
                    "        return NameIterator(self.names)\n" +
                    "\n" +
                    "# Concrete Iterator\n" +
                    "class NameIterator(Iterator):\n" +
                    "    def __init__(self, names):\n" +
                    "        self.names = names\n" +
                    "        self.index = 0\n" +
                    "\n" +
                    "    def has_next(self):\n" +
                    "        return self.index < len(self.names)\n" +
                    "\n" +
                    "    def next(self):\n" +
                    "        if self.has_next():\n" +
                    "            name = self.names[self.index]\n" +
                    "            self.index += 1\n" +
                    "            return name\n" +
                    "        return None\n" +
                    "\n" +
                    "# Client\n" +
                    "if __name__ == \"__main__\":\n" +
                    "    name_collection = NameCollection()\n" +
                    "    iterator = name_collection.create_iterator()\n" +
                    "\n" +
                    "    while iterator.has_next():\n" +
                    "        print(f\"Name: {iterator.next()}\")\n";
            case "Mediator"  -> "# Mediator interface\n" +
                    "class Mediator:\n" +
                    "    def send_message(self, message, colleague):\n" +
                    "        pass\n" +
                    "\n" +
                    "# Concrete Mediator\n" +
                    "class ConcreteMediator(Mediator):\n" +
                    "    def __init__(self):\n" +
                    "        self.colleague1 = None\n" +
                    "        self.colleague2 = None\n" +
                    "\n" +
                    "    def set_colleague1(self, colleague):\n" +
                    "        self.colleague1 = colleague\n" +
                    "\n" +
                    "    def set_colleague2(self, colleague):\n" +
                    "        self.colleague2 = colleague\n" +
                    "\n" +
                    "    def send_message(self, message, colleague):\n" +
                    "        if colleague == self.colleague1:\n" +
                    "            self.colleague2.notify(message)\n" +
                    "        else:\n" +
                    "            self.colleague1.notify(message)\n" +
                    "\n" +
                    "# Colleague abstract class\n" +
                    "class Colleague:\n" +
                    "    def __init__(self, mediator):\n" +
                    "        self.mediator = mediator\n" +
                    "\n" +
                    "# Concrete Colleagues\n" +
                    "class Colleague1(Colleague):\n" +
                    "    def send(self, message):\n" +
                    "        self.mediator.send_message(message, self)\n" +
                    "\n" +
                    "    def notify(self, message):\n" +
                    "        print(f\"Colleague1 gets message: {message}\")\n" +
                    "\n" +
                    "class Colleague2(Colleague):\n" +
                    "    def send(self, message):\n" +
                    "        self.mediator.send_message(message, self)\n" +
                    "\n" +
                    "    def notify(self, message):\n" +
                    "        print(f\"Colleague2 gets message: {message}\")\n" +
                    "\n" +
                    "# Client\n" +
                    "if __name__ == \"__main__\":\n" +
                    "    mediator = ConcreteMediator()\n" +
                    "    colleague1 = Colleague1(mediator)\n" +
                    "    colleague2 = Colleague2(mediator)\n" +
                    "\n" +
                    "    mediator.set_colleague1(colleague1)\n" +
                    "    mediator.set_colleague2(colleague2)\n" +
                    "\n" +
                    "    colleague1.send(\"Hello, Colleague2!\")\n" +
                    "    colleague2.send(\"Hi, Colleague1!\")\n";
            case "Memento"  -> "# Memento class\n" +
                    "class Memento:\n" +
                    "    def __init__(self, state):\n" +
                    "        self.state = state\n" +
                    "\n" +
                    "    def get_state(self):\n" +
                    "        return self.state\n" +
                    "\n" +
                    "# Originator class\n" +
                    "class Originator:\n" +
                    "    def __init__(self):\n" +
                    "        self.state = None\n" +
                    "\n" +
                    "    def set_state(self, state):\n" +
                    "        self.state = state\n" +
                    "\n" +
                    "    def get_state(self):\n" +
                    "        return self.state\n" +
                    "\n" +
                    "    def save_state_to_memento(self):\n" +
                    "        return Memento(self.state)\n" +
                    "\n" +
                    "    def get_state_from_memento(self, memento):\n" +
                    "        self.state = memento.get_state()\n" +
                    "\n" +
                    "# Caretaker class\n" +
                    "class Caretaker:\n" +
                    "    def __init__(self):\n" +
                    "        self.memento_list = []\n" +
                    "\n" +
                    "    def add(self, state):\n" +
                    "        self.memento_list.append(state)\n" +
                    "\n" +
                    "    def get(self, index):\n" +
                    "        return self.memento_list[index]\n" +
                    "\n" +
                    "# Client\n" +
                    "if __name__ == \"__main__\":\n" +
                    "    originator = Originator()\n" +
                    "    caretaker = Caretaker()\n" +
                    "\n" +
                    "    originator.set_state(\"State #1\")\n" +
                    "    originator.set_state(\"State #2\")\n" +
                    "    caretaker.add(originator.save_state_to_memento())\n" +
                    "\n" +
                    "    originator.set_state(\"State #3\")\n" +
                    "    caretaker.add(originator.save_state_to_memento())\n" +
                    "\n" +
                    "    originator.set_state(\"State #4\")\n" +
                    "    print(f\"Current State: {originator.get_state()}\")\n" +
                    "\n" +
                    "    originator.get_state_from_memento(caretaker.get(0))\n" +
                    "    print(f\"First saved State: {originator.get_state()}\")\n" +
                    "    originator.get_state_from_memento(caretaker.get(1))\n" +
                    "    print(f\"Second saved State: {originator.get_state()}\")\n";
            case "Observer"  -> "# Observer interface\n" +
                    "class Observer:\n" +
                    "    def update(self, message):\n" +
                    "        pass\n" +
                    "\n" +
                    "# Subject interface\n" +
                    "class Subject:\n" +
                    "    def register_observer(self, observer):\n" +
                    "        pass\n" +
                    "\n" +
                    "    def remove_observer(self, observer):\n" +
                    "        pass\n" +
                    "\n" +
                    "    def notify_observers(self):\n" +
                    "        pass\n" +
                    "\n" +
                    "# Concrete Subject\n" +
                    "class ConcreteSubject(Subject):\n" +
                    "    def __init__(self):\n" +
                    "        self.observers = []\n" +
                    "        self.message = None\n" +
                    "\n" +
                    "    def register_observer(self, observer):\n" +
                    "        self.observers.append(observer)\n" +
                    "\n" +
                    "    def remove_observer(self, observer):\n" +
                    "        self.observers.remove(observer)\n" +
                    "\n" +
                    "    def notify_observers(self):\n" +
                    "        for observer in self.observers:\n" +
                    "            observer.update(self.message)\n" +
                    "\n" +
                    "    def set_message(self, message):\n" +
                    "        self.message = message\n" +
                    "        self.notify_observers()\n" +
                    "\n" +
                    "# Concrete Observer\n" +
                    "class ConcreteObserver(Observer):\n" +
                    "    def __init__(self, name):\n" +
                    "        self.name = name\n" +
                    "\n" +
                    "    def update(self, message):\n" +
                    "        print(f\"{self.name} received message: {message}\")\n" +
                    "\n" +
                    "# Client\n" +
                    "if __name__ == \"__main__\":\n" +
                    "    subject = ConcreteSubject()\n" +
                    "\n" +
                    "    observer1 = ConcreteObserver(\"Observer1\")\n" +
                    "    observer2 = ConcreteObserver(\"Observer2\")\n" +
                    "\n" +
                    "    subject.register_observer(observer1)\n" +
                    "    subject.register_observer(observer2)\n" +
                    "\n" +
                    "    subject.set_message(\"Hello Observers!\")\n" +
                    "\n" +
                    "    subject.remove_observer(observer1)\n" +
                    "\n" +
                    "    subject.set_message(\"Observer1 removed\")\n";
            case "State"  -> "# State interface\n" +
                    "class State:\n" +
                    "    def do_action(self, context):\n" +
                    "        pass\n" +
                    "\n" +
                    "# Concrete States\n" +
                    "class StartState(State):\n" +
                    "    def do_action(self, context):\n" +
                    "        print(\"Player is in start state\")\n" +
                    "        context.set_state(self)\n" +
                    "\n" +
                    "    def __str__(self):\n" +
                    "        return \"Start State\"\n" +
                    "\n" +
                    "class StopState(State):\n" +
                    "    def do_action(self, context):\n" +
                    "        print(\"Player is in stop state\")\n" +
                    "        context.set_state(self)\n" +
                    "\n" +
                    "    def __str__(self):\n" +
                    "        return \"Stop State\"\n" +
                    "\n" +
                    "# Context class\n" +
                    "class Context:\n" +
                    "    def __init__(self):\n" +
                    "        self.state = None\n" +
                    "\n" +
                    "    def set_state(self, state):\n" +
                    "        self.state = state\n" +
                    "\n" +
                    "    def get_state(self):\n" +
                    "        return self.state\n" +
                    "\n" +
                    "# Client\n" +
                    "if __name__ == \"__main__\":\n" +
                    "    context = Context()\n" +
                    "\n" +
                    "    start_state = StartState()\n" +
                    "    start_state.do_action(context)\n" +
                    "    print(context.get_state())\n" +
                    "\n" +
                    "    stop_state = StopState()\n" +
                    "    stop_state.do_action(context)\n" +
                    "    print(context.get_state())\n";
            case "Strategy"  -> "# Strategy interface\n" +
                    "class Strategy:\n" +
                    "    def do_operation(self, num1, num2):\n" +
                    "        pass\n" +
                    "\n" +
                    "# Concrete Strategies\n" +
                    "class OperationAdd(Strategy):\n" +
                    "    def do_operation(self, num1, num2):\n" +
                    "        return num1 + num2\n" +
                    "\n" +
                    "class OperationSubtract(Strategy):\n" +
                    "    def do_operation(self, num1, num2):\n" +
                    "        return num1 - num2\n" +
                    "\n" +
                    "class OperationMultiply(Strategy):\n" +
                    "    def do_operation(self, num1, num2):\n" +
                    "        return num1 * num2\n" +
                    "\n" +
                    "# Context class\n" +
                    "class Context:\n" +
                    "    def __init__(self, strategy):\n" +
                    "        self.strategy = strategy\n" +
                    "\n" +
                    "    def execute_strategy(self, num1, num2):\n" +
                    "        return self.strategy.do_operation(num1, num2)\n" +
                    "\n" +
                    "# Client\n" +
                    "if __name__ == \"__main__\":\n" +
                    "    context = Context(OperationAdd())\n" +
                    "    print(f\"10 + 5 = {context.execute_strategy(10, 5)}\")\n" +
                    "\n" +
                    "    context = Context(OperationSubtract())\n" +
                    "    print(f\"10 - 5 = {context.execute_strategy(10, 5)}\")\n" +
                    "\n" +
                    "    context = Context(OperationMultiply())\n" +
                    "    print(f\"10 * 5 = {context.execute_strategy(10, 5)}\")\n";
            case "Template Method"  -> "# Abstract class\n" +
                    "class Game:\n" +
                    "    def initialize(self):\n" +
                    "        pass\n" +
                    "\n" +
                    "    def start_play(self):\n" +
                    "        pass\n" +
                    "\n" +
                    "    def end_play(self):\n" +
                    "        pass\n" +
                    "\n" +
                    "    # Template method\n" +
                    "    def play(self):\n" +
                    "        self.initialize()\n" +
                    "        self.start_play()\n" +
                    "        self.end_play()\n" +
                    "\n" +
                    "# Concrete classes\n" +
                    "class Cricket(Game):\n" +
                    "    def initialize(self):\n" +
                    "        print(\"Cricket Game Initialized! Start playing.\")\n" +
                    "\n" +
                    "    def start_play(self):\n" +
                    "        print(\"Cricket Game Started. Enjoy the game!\")\n" +
                    "\n" +
                    "    def end_play(self):\n" +
                    "        print(\"Cricket Game Finished!\")\n" +
                    "\n" +
                    "class Football(Game):\n" +
                    "    def initialize(self):\n" +
                    "        print(\"Football Game Initialized! Start playing.\")\n" +
                    "\n" +
                    "    def start_play(self):\n" +
                    "        print(\"Football Game Started. Enjoy the game!\")\n" +
                    "\n" +
                    "    def end_play(self):\n" +
                    "        print(\"Football Game Finished!\")\n" +
                    "\n" +
                    "# Client\n" +
                    "if __name__ == \"__main__\":\n" +
                    "    game = Cricket()\n" +
                    "    game.play()\n" +
                    "\n" +
                    "    game = Football()\n" +
                    "    game.play()\n";
            case "Visitor" -> "# Visitor interface\n" +
                    "class ComputerPartVisitor:\n" +
                    "    def visit(self, part):\n" +
                    "        pass\n" +
                    "\n" +
                    "# ComputerPart interface\n" +
                    "class ComputerPart:\n" +
                    "    def accept(self, visitor):\n" +
                    "        pass\n" +
                    "\n" +
                    "# Concrete ComputerParts\n" +
                    "class Keyboard(ComputerPart):\n" +
                    "    def accept(self, visitor):\n" +
                    "        visitor.visit(self)\n" +
                    "\n" +
                    "class Monitor(ComputerPart):\n" +
                    "    def accept(self, visitor):\n" +
                    "        visitor.visit(self)\n" +
                    "\n" +
                    "class Mouse(ComputerPart):\n" +
                    "    def accept(self, visitor):\n" +
                    "        visitor.visit(self)\n" +
                    "\n" +
                    "class Computer(ComputerPart):\n" +
                    "    def __init__(self):\n" +
                    "        self.parts = [Mouse(), Keyboard(), Monitor()]\n" +
                    "\n" +
                    "    def accept(self, visitor):\n" +
                    "        for part in self.parts:\n" +
                    "            part.accept(visitor)\n" +
                    "        visitor.visit(self)\n" +
                    "\n" +
                    "# Concrete Visitor\n" +
                    "class ComputerPartDisplayVisitor(ComputerPartVisitor):\n" +
                    "    def visit(self, part):\n" +
                    "        if isinstance(part, Computer):\n" +
                    "            print(\"Displaying Computer.\")\n" +
                    "        elif isinstance(part, Mouse):\n" +
                    "            print(\"Displaying Mouse.\")\n" +
                    "        elif isinstance(part, Keyboard):\n" +
                    "            print(\"Displaying Keyboard.\")\n" +
                    "        elif isinstance(part, Monitor):\n" +
                    "            print(\"Displaying Monitor.\")\n" +
                    "\n" +
                    "# Client\n" +
                    "if __name__ == \"__main__\":\n" +
                    "    computer = Computer()\n" +
                    "    computer.accept(ComputerPartDisplayVisitor())\n";
            // More cases...
            default -> "Error for load code";
        };
    }

    public static String getCodeCPPByNameBehavioralPattern(String pattern) {
        return switch (pattern) {
            case "Chain of Responsibility" -> "#include <iostream>\n" +
                    "#include <string>\n" +
                    "\n" +
                    "// Handler interface\n" +
                    "class Handler {\n" +
                    "public:\n" +
                    "    virtual void setNext(Handler* handler) = 0;\n" +
                    "    virtual void handle(const std::string& request) = 0;\n" +
                    "};\n" +
                    "\n" +
                    "// Concrete Handlers\n" +
                    "class ConcreteHandler1 : public Handler {\n" +
                    "private:\n" +
                    "    Handler* nextHandler;\n" +
                    "public:\n" +
                    "    ConcreteHandler1() : nextHandler(nullptr) {}\n" +
                    "\n" +
                    "    void setNext(Handler* handler) override {\n" +
                    "        nextHandler = handler;\n" +
                    "    }\n" +
                    "\n" +
                    "    void handle(const std::string& request) override {\n" +
                    "        if (request == \"Handler1\") {\n" +
                    "            std::cout << \"Handled by Handler1\\n\";\n" +
                    "        } else if (nextHandler) {\n" +
                    "            nextHandler->handle(request);\n" +
                    "        }\n" +
                    "    }\n" +
                    "};\n" +
                    "\n" +
                    "class ConcreteHandler2 : public Handler {\n" +
                    "private:\n" +
                    "    Handler* nextHandler;\n" +
                    "public:\n" +
                    "    ConcreteHandler2() : nextHandler(nullptr) {}\n" +
                    "\n" +
                    "    void setNext(Handler* handler) override {\n" +
                    "        nextHandler = handler;\n" +
                    "    }\n" +
                    "\n" +
                    "    void handle(const std::string& request) override {\n" +
                    "        if (request == \"Handler2\") {\n" +
                    "            std::cout << \"Handled by Handler2\\n\";\n" +
                    "        } else if (nextHandler) {\n" +
                    "            nextHandler->handle(request);\n" +
                    "        }\n" +
                    "    }\n" +
                    "};\n" +
                    "\n" +
                    "// Client\n" +
                    "int main() {\n" +
                    "    ConcreteHandler1* handler1 = new ConcreteHandler1();\n" +
                    "    ConcreteHandler2* handler2 = new ConcreteHandler2();\n" +
                    "\n" +
                    "    handler1->setNext(handler2);\n" +
                    "\n" +
                    "    handler1->handle(\"Handler1\");\n" +
                    "    handler1->handle(\"Handler2\");\n" +
                    "\n" +
                    "    delete handler1;\n" +
                    "    delete handler2;\n" +
                    "    return 0;\n" +
                    "}\n";
            case "Command" -> "#include <iostream>\n" +
                    "\n" +
                    "// Command interface\n" +
                    "class Command {\n" +
                    "public:\n" +
                    "    virtual void execute() = 0;\n" +
                    "};\n" +
                    "\n" +
                    "// Receiver\n" +
                    "class Light {\n" +
                    "public:\n" +
                    "    void on() {\n" +
                    "        std::cout << \"Light is ON\\n\";\n" +
                    "    }\n" +
                    "\n" +
                    "    void off() {\n" +
                    "        std::cout << \"Light is OFF\\n\";\n" +
                    "    }\n" +
                    "};\n" +
                    "\n" +
                    "// Concrete Commands\n" +
                    "class LightOnCommand : public Command {\n" +
                    "private:\n" +
                    "    Light* light;\n" +
                    "public:\n" +
                    "    LightOnCommand(Light* light) : light(light) {}\n" +
                    "\n" +
                    "    void execute() override {\n" +
                    "        light->on();\n" +
                    "    }\n" +
                    "};\n" +
                    "\n" +
                    "class LightOffCommand : public Command {\n" +
                    "private:\n" +
                    "    Light* light;\n" +
                    "public:\n" +
                    "    LightOffCommand(Light* light) : light(light) {}\n" +
                    "\n" +
                    "    void execute() override {\n" +
                    "        light->off();\n" +
                    "    }\n" +
                    "};\n" +
                    "\n" +
                    "// Invoker\n" +
                    "class RemoteControl {\n" +
                    "private:\n" +
                    "    Command* command;\n" +
                    "public:\n" +
                    "    void setCommand(Command* command) {\n" +
                    "        this->command = command;\n" +
                    "    }\n" +
                    "\n" +
                    "    void pressButton() {\n" +
                    "        command->execute();\n" +
                    "    }\n" +
                    "};\n" +
                    "\n" +
                    "// Client\n" +
                    "int main() {\n" +
                    "    Light* light = new Light();\n" +
                    "    LightOnCommand* lightOn = new LightOnCommand(light);\n" +
                    "    LightOffCommand* lightOff = new LightOffCommand(light);\n" +
                    "\n" +
                    "    RemoteControl* remote = new RemoteControl();\n" +
                    "    remote->setCommand(lightOn);\n" +
                    "    remote->pressButton();\n" +
                    "\n" +
                    "    remote->setCommand(lightOff);\n" +
                    "    remote->pressButton();\n" +
                    "\n" +
                    "    delete light;\n" +
                    "    delete lightOn;\n" +
                    "    delete lightOff;\n" +
                    "    delete remote;\n" +
                    "\n" +
                    "    return 0;\n" +
                    "}\n";
            case "Iterator" -> "#include <iostream>\n" +
                    "#include <vector>\n" +
                    "#include <string>\n" +
                    "\n" +
                    "// Iterator interface\n" +
                    "class Iterator {\n" +
                    "public:\n" +
                    "    virtual bool hasNext() = 0;\n" +
                    "    virtual std::string next() = 0;\n" +
                    "};\n" +
                    "\n" +
                    "// Collection interface\n" +
                    "class Collection {\n" +
                    "public:\n" +
                    "    virtual Iterator* createIterator() = 0;\n" +
                    "};\n" +
                    "\n" +
                    "// Concrete Collection\n" +
                    "class NameCollection : public Collection {\n" +
                    "private:\n" +
                    "    std::vector<std::string> names;\n" +
                    "public:\n" +
                    "    NameCollection() {\n" +
                    "        names.push_back(\"John\");\n" +
                    "        names.push_back(\"Jane\");\n" +
                    "        names.push_back(\"Doe\");\n" +
                    "    }\n" +
                    "\n" +
                    "    std::vector<std::string> getNames() {\n" +
                    "        return names;\n" +
                    "    }\n" +
                    "\n" +
                    "    Iterator* createIterator() override;\n" +
                    "};\n" +
                    "\n" +
                    "// Concrete Iterator\n" +
                    "class NameIterator : public Iterator {\n" +
                    "private:\n" +
                    "    std::vector<std::string> names;\n" +
                    "    size_t index;\n" +
                    "public:\n" +
                    "    NameIterator(std::vector<std::string> names) : names(names), index(0) {}\n" +
                    "\n" +
                    "    bool hasNext() override {\n" +
                    "        return index < names.size();\n" +
                    "    }\n" +
                    "\n" +
                    "    std::string next() override {\n" +
                    "        if (hasNext()) {\n" +
                    "            return names[index++];\n" +
                    "        }\n" +
                    "        return \"\";\n" +
                    "    }\n" +
                    "};\n" +
                    "\n" +
                    "Iterator* NameCollection::createIterator() {\n" +
                    "    return new NameIterator(names);\n" +
                    "}\n" +
                    "\n" +
                    "// Client\n" +
                    "int main() {\n" +
                    "    NameCollection* nameCollection = new NameCollection();\n" +
                    "    Iterator* iterator = nameCollection->createIterator();\n" +
                    "\n" +
                    "    while (iterator->hasNext()) {\n" +
                    "        std::cout << \"Name: \" << iterator->next() << std::endl;\n" +
                    "    }\n" +
                    "\n" +
                    "    delete iterator;\n" +
                    "    delete nameCollection;\n" +
                    "\n" +
                    "    return 0;\n" +
                    "}\n";
            case "Mediator"  -> "#include <iostream>\n" +
                    "#include <string>\n" +
                    "\n" +
                    "// Forward declarations\n" +
                    "class Colleague1;\n" +
                    "class Colleague2;\n" +
                    "\n" +
                    "// Mediator interface\n" +
                    "class Mediator {\n" +
                    "public:\n" +
                    "    virtual void sendMessage(const std::string& message, Colleague1* colleague) = 0;\n" +
                    "    virtual void sendMessage(const std::string& message, Colleague2* colleague) = 0;\n" +
                    "};\n" +
                    "\n" +
                    "// Colleague abstract class\n" +
                    "class Colleague {\n" +
                    "protected:\n" +
                    "    Mediator* mediator;\n" +
                    "public:\n" +
                    "    Colleague(Mediator* mediator) : mediator(mediator) {}\n" +
                    "};\n" +
                    "\n" +
                    "// Concrete Colleague1\n" +
                    "class Colleague1 : public Colleague {\n" +
                    "public:\n" +
                    "    Colleague1(Mediator* mediator) : Colleague(mediator) {}\n" +
                    "\n" +
                    "    void send(const std::string& message) {\n" +
                    "        mediator->sendMessage(message, this);\n" +
                    "    }\n" +
                    "\n" +
                    "    void notify(const std::string& message) {\n" +
                    "        std::cout << \"Colleague1 gets message: \" << message << std::endl;\n" +
                    "    }\n" +
                    "};\n" +
                    "\n" +
                    "// Concrete Colleague2\n" +
                    "class Colleague2 : public Colleague {\n" +
                    "public:\n" +
                    "    Colleague2(Mediator* mediator) : Colleague(mediator) {}\n" +
                    "\n" +
                    "    void send(const std::string& message) {\n" +
                    "        mediator->sendMessage(message, this);\n" +
                    "    }\n" +
                    "\n" +
                    "    void notify(const std::string& message) {\n" +
                    "        std::cout << \"Colleague2 gets message: \" << message << std::endl;\n" +
                    "    }\n" +
                    "};\n" +
                    "\n" +
                    "// Concrete Mediator\n" +
                    "class ConcreteMediator : public Mediator {\n" +
                    "private:\n" +
                    "    Colleague1* colleague1;\n" +
                    "    Colleague2* colleague2;\n" +
                    "public:\n" +
                    "    void setColleague1(Colleague1* colleague) {\n" +
                    "        colleague1 = colleague;\n" +
                    "    }\n" +
                    "\n" +
                    "    void setColleague2(Colleague2* colleague) {\n" +
                    "        colleague2 = colleague;\n" +
                    "    }\n" +
                    "\n" +
                    "    void sendMessage(const std::string& message, Colleague1* colleague) override {\n" +
                    "        colleague2->notify(message);\n" +
                    "    }\n" +
                    "\n" +
                    "    void sendMessage(const std::string& message, Colleague2* colleague) override {\n" +
                    "        colleague1->notify(message);\n" +
                    "    }\n" +
                    "};\n" +
                    "\n" +
                    "// Client\n" +
                    "int main() {\n" +
                    "    ConcreteMediator* mediator = new ConcreteMediator();\n" +
                    "    Colleague1* colleague1 = new Colleague1(mediator);\n" +
                    "    Colleague2* colleague2 = new Colleague2(mediator);\n" +
                    "\n" +
                    "    mediator->setColleague1(colleague1);\n" +
                    "    mediator->setColleague2(colleague2);\n" +
                    "\n" +
                    "    colleague1->send(\"Hello, Colleague2!\");\n" +
                    "    colleague2->send(\"Hi, Colleague1!\");\n" +
                    "\n" +
                    "    delete colleague1;\n" +
                    "    delete colleague2;\n" +
                    "    delete mediator;\n" +
                    "\n" +
                    "    return 0;\n" +
                    "}\n";
            case "Memento"  -> "#include <iostream>\n" +
                    "#include <vector>\n" +
                    "#include <string>\n" +
                    "\n" +
                    "// Memento class\n" +
                    "class Memento {\n" +
                    "private:\n" +
                    "    std::string state;\n" +
                    "public:\n" +
                    "    Memento(const std::string& state) : state(state) {}\n" +
                    "    std::string getState() const { return state; }\n" +
                    "};\n" +
                    "\n" +
                    "// Originator class\n" +
                    "class Originator {\n" +
                    "private:\n" +
                    "    std::string state;\n" +
                    "public:\n" +
                    "    void setState(const std::string& state) { this->state = state; }\n" +
                    "    std::string getState() const { return state; }\n" +
                    "    Memento* saveStateToMemento() { return new Memento(state); }\n" +
                    "    void getStateFromMemento(Memento* memento) { state = memento->getState(); }\n" +
                    "};\n" +
                    "\n" +
                    "// Caretaker class\n" +
                    "class Caretaker {\n" +
                    "private:\n" +
                    "    std::vector<Memento*> mementoList;\n" +
                    "public:\n" +
                    "    void add(Memento* state) { mementoList.push_back(state); }\n" +
                    "    Memento* get(int index) { return mementoList.at(index); }\n" +
                    "};\n" +
                    "\n" +
                    "// Client\n" +
                    "int main() {\n" +
                    "    Originator* originator = new Originator();\n" +
                    "    Caretaker* caretaker = new Caretaker();\n" +
                    "\n" +
                    "    originator->setState(\"State #1\");\n" +
                    "    originator->setState(\"State #2\");\n" +
                    "    caretaker->add(originator->saveStateToMemento());\n" +
                    "\n" +
                    "    originator->setState(\"State #3\");\n" +
                    "    caretaker->add(originator->saveStateToMemento());\n" +
                    "\n" +
                    "    originator->setState(\"State #4\");\n" +
                    "    std::cout << \"Current State: \" << originator->getState() << std::endl;\n" +
                    "\n" +
                    "    originator->getStateFromMemento(caretaker->get(0));\n" +
                    "    std::cout << \"First saved State: \" << originator->getState() << std::endl;\n" +
                    "    originator->getStateFromMemento(caretaker->get(1));\n" +
                    "    std::cout << \"Second saved State: \" << originator->getState() << std::endl;\n" +
                    "\n" +
                    "    delete originator;\n" +
                    "    delete caretaker;\n" +
                    "\n" +
                    "    return 0;\n" +
                    "}\n";
            case "Observer"  -> "#include <iostream>\n" +
                    "#include <vector>\n" +
                    "#include <string>\n" +
                    "\n" +
                    "// Observer interface\n" +
                    "class Observer {\n" +
                    "public:\n" +
                    "    virtual void update(const std::string& message) = 0;\n" +
                    "};\n" +
                    "\n" +
                    "// Subject interface\n" +
                    "class Subject {\n" +
                    "public:\n" +
                    "    virtual void registerObserver(Observer* observer) = 0;\n" +
                    "    virtual void removeObserver(Observer* observer) = 0;\n" +
                    "    virtual void notifyObservers() = 0;\n" +
                    "};\n" +
                    "\n" +
                    "// Concrete Subject\n" +
                    "class ConcreteSubject : public Subject {\n" +
                    "private:\n" +
                    "    std::vector<Observer*> observers;\n" +
                    "    std::string message;\n" +
                    "public:\n" +
                    "    void registerObserver(Observer* observer) override {\n" +
                    "        observers.push_back(observer);\n" +
                    "    }\n" +
                    "\n" +
                    "    void removeObserver(Observer* observer) override {\n" +
                    "        observers.erase(std::remove(observers.begin(), observers.end(), observer), observers.end());\n" +
                    "    }\n" +
                    "\n" +
                    "    void notifyObservers() override {\n" +
                    "        for (Observer* observer : observers) {\n" +
                    "            observer->update(message);\n" +
                    "        }\n" +
                    "    }\n" +
                    "\n" +
                    "    void setMessage(const std::string& message) {\n" +
                    "        this->message = message;\n" +
                    "        notifyObservers();\n" +
                    "    }\n" +
                    "};\n" +
                    "\n" +
                    "// Concrete Observer\n" +
                    "class ConcreteObserver : public Observer {\n" +
                    "private:\n" +
                    "    std::string name;\n" +
                    "public:\n" +
                    "    ConcreteObserver(const std::string& name) : name(name) {}\n" +
                    "\n" +
                    "    void update(const std::string& message) override {\n" +
                    "        std::cout << name << \" received message: \" << message << std::endl;\n" +
                    "    }\n" +
                    "};\n" +
                    "\n" +
                    "// Client\n" +
                    "int main() {\n" +
                    "    ConcreteSubject* subject = new ConcreteSubject();\n" +
                    "\n" +
                    "    ConcreteObserver* observer1 = new ConcreteObserver(\"Observer1\");\n" +
                    "    ConcreteObserver* observer2 = new ConcreteObserver(\"Observer2\");\n" +
                    "\n" +
                    "    subject->registerObserver(observer1);\n" +
                    "    subject->registerObserver(observer2);\n" +
                    "\n" +
                    "    subject->setMessage(\"Hello Observers!\");\n" +
                    "\n" +
                    "    subject->removeObserver(observer1);\n" +
                    "\n" +
                    "    subject->setMessage(\"Observer1 removed\");\n" +
                    "\n" +
                    "    delete observer1;\n" +
                    "    delete observer2;\n" +
                    "    delete subject;\n" +
                    "\n" +
                    "    return 0;\n" +
                    "}\n";
            case "State"  -> "#include <iostream>\n" +
                    "#include <string>\n" +
                    "\n" +
                    "// Forward declaration\n" +
                    "class Context;\n" +
                    "\n" +
                    "// State interface\n" +
                    "class State {\n" +
                    "public:\n" +
                    "    virtual void doAction(Context* context) = 0;\n" +
                    "    virtual std::string toString() const = 0;\n" +
                    "};\n" +
                    "\n" +
                    "// Context class\n" +
                    "class Context {\n" +
                    "private:\n" +
                    "    State* state;\n" +
                    "public:\n" +
                    "    Context() : state(nullptr) {}\n" +
                    "\n" +
                    "    void setState(State* state) {\n" +
                    "        this->state = state;\n" +
                    "    }\n" +
                    "\n" +
                    "    State* getState() const {\n" +
                    "        return state;\n" +
                    "    }\n" +
                    "};\n" +
                    "\n" +
                    "// Concrete States\n" +
                    "class StartState : public State {\n" +
                    "public:\n" +
                    "    void doAction(Context* context) override {\n" +
                    "        std::cout << \"Player is in start state\\n\";\n" +
                    "        context->setState(this);\n" +
                    "    }\n" +
                    "\n" +
                    "    std::string toString() const override {\n" +
                    "        return \"Start State\";\n" +
                    "    }\n" +
                    "};\n" +
                    "\n" +
                    "class StopState : public State {\n" +
                    "public:\n" +
                    "    void doAction(Context* context) override {\n" +
                    "        std::cout << \"Player is in stop state\\n\";\n" +
                    "        context->setState(this);\n" +
                    "    }\n" +
                    "\n" +
                    "    std::string toString() const override {\n" +
                    "        return \"Stop State\";\n" +
                    "    }\n" +
                    "};\n" +
                    "\n" +
                    "// Client\n" +
                    "int main() {\n" +
                    "    Context* context = new Context();\n" +
                    "\n" +
                    "    StartState* startState = new StartState();\n" +
                    "    startState->doAction(context);\n" +
                    "\n" +
                    "    std::cout << context->getState()->toString() << std::endl;\n" +
                    "\n" +
                    "    StopState* stopState = new StopState();\n" +
                    "    stopState->doAction(context);\n" +
                    "\n" +
                    "    std::cout << context->getState()->toString() << std::endl;\n" +
                    "\n" +
                    "    delete startState;\n" +
                    "    delete stopState;\n" +
                    "    delete context;\n" +
                    "\n" +
                    "    return 0;\n" +
                    "}\n";
            case "Strategy"  -> "#include <iostream>\n" +
                    "\n" +
                    "// Strategy interface\n" +
                    "class Strategy {\n" +
                    "public:\n" +
                    "    virtual int doOperation(int num1, int num2) = 0;\n" +
                    "};\n" +
                    "\n" +
                    "// Concrete Strategies\n" +
                    "class OperationAdd : public Strategy {\n" +
                    "public:\n" +
                    "    int doOperation(int num1, int num2) override {\n" +
                    "        return num1 + num2;\n" +
                    "    }\n" +
                    "};\n" +
                    "\n" +
                    "class OperationSubtract : public Strategy {\n" +
                    "public:\n" +
                    "    int doOperation(int num1, int num2) override {\n" +
                    "        return num1 - num2;\n" +
                    "    }\n" +
                    "};\n" +
                    "\n" +
                    "class OperationMultiply : public Strategy {\n" +
                    "public:\n" +
                    "    int doOperation(int num1, int num2) override {\n" +
                    "        return num1 * num2;\n" +
                    "    }\n" +
                    "};\n" +
                    "\n" +
                    "// Context class\n" +
                    "class Context {\n" +
                    "private:\n" +
                    "    Strategy* strategy;\n" +
                    "public:\n" +
                    "    Context(Strategy* strategy) : strategy(strategy) {}\n" +
                    "\n" +
                    "    int executeStrategy(int num1, int num2) {\n" +
                    "        return strategy->doOperation(num1, num2);\n" +
                    "    }\n" +
                    "};\n" +
                    "\n" +
                    "// Client\n" +
                    "int main() {\n" +
                    "    Context* context = new Context(new OperationAdd());\n" +
                    "    std::cout << \"10 + 5 = \" << context->executeStrategy(10, 5) << std::endl;\n" +
                    "\n" +
                    "    context = new Context(new OperationSubtract());\n" +
                    "    std::cout << \"10 - 5 = \" << context->executeStrategy(10, 5) << std::endl;\n" +
                    "\n" +
                    "    context = new Context(new OperationMultiply());\n" +
                    "    std::cout << \"10 * 5 = \" << context->executeStrategy(10, 5) << std::endl;\n" +
                    "\n" +
                    "    delete context;\n" +
                    "\n" +
                    "    return 0;\n" +
                    "}\n";
            case "Template Method"  -> "#include <iostream>\n" +
                    "\n" +
                    "// Abstract class\n" +
                    "class Game {\n" +
                    "public:\n" +
                    "    virtual void initialize() = 0;\n" +
                    "    virtual void startPlay() = 0;\n" +
                    "    virtual void endPlay() = 0;\n" +
                    "\n" +
                    "    // Template method\n" +
                    "    void play() {\n" +
                    "        initialize();\n" +
                    "        startPlay();\n" +
                    "        endPlay();\n" +
                    "    }\n" +
                    "};\n" +
                    "\n" +
                    "// Concrete classes\n" +
                    "class Cricket : public Game {\n" +
                    "public:\n" +
                    "    void initialize() override {\n" +
                    "        std::cout << \"Cricket Game Initialized! Start playing.\\n\";\n" +
                    "    }\n" +
                    "\n" +
                    "    void startPlay() override {\n" +
                    "        std::cout << \"Cricket Game Started. Enjoy the game!\\n\";\n" +
                    "    }\n" +
                    "\n" +
                    "    void endPlay() override {\n" +
                    "        std::cout << \"Cricket Game Finished!\\n\";\n" +
                    "    }\n" +
                    "};\n" +
                    "\n" +
                    "class Football : public Game {\n" +
                    "public:\n" +
                    "    void initialize() override {\n" +
                    "        std::cout << \"Football Game Initialized! Start playing.\\n\";\n" +
                    "    }\n" +
                    "\n" +
                    "    void startPlay() override {\n" +
                    "        std::cout << \"Football Game Started. Enjoy the game!\\n\";\n" +
                    "    }\n" +
                    "\n" +
                    "    void endPlay() override {\n" +
                    "        std::cout << \"Football Game Finished!\\n\";\n" +
                    "    }\n" +
                    "};\n" +
                    "\n" +
                    "// Client\n" +
                    "int main() {\n" +
                    "    Game* game = new Cricket();\n" +
                    "    game->play();\n" +
                    "\n" +
                    "    delete game;\n" +
                    "\n" +
                    "    game = new Football();\n" +
                    "    game->play();\n" +
                    "\n" +
                    "    delete game;\n" +
                    "\n" +
                    "    return 0;\n" +
                    "}\n";
            case "Visitor" -> "#include <iostream>\n" +
                    "#include <vector>\n" +
                    "#include <string>\n" +
                    "\n" +
                    "// Forward declarations\n" +
                    "class Computer;\n" +
                    "class Mouse;\n" +
                    "class Keyboard;\n" +
                    "class Monitor;\n" +
                    "\n" +
                    "// Visitor interface\n" +
                    "class ComputerPartVisitor {\n" +
                    "public:\n" +
                    "    virtual void visit(Computer* computer) = 0;\n" +
                    "    virtual void visit(Mouse* mouse) = 0;\n" +
                    "    virtual void visit(Keyboard* keyboard) = 0;\n" +
                    "    virtual void visit(Monitor* monitor) = 0;\n" +
                    "};\n" +
                    "\n" +
                    "// ComputerPart interface\n" +
                    "class ComputerPart {\n" +
                    "public:\n" +
                    "    virtual void accept(ComputerPartVisitor* visitor) = 0;\n" +
                    "};\n" +
                    "\n" +
                    "// Concrete ComputerParts\n" +
                    "class Keyboard : public ComputerPart {\n" +
                    "public:\n" +
                    "    void accept(ComputerPartVisitor* visitor) override {\n" +
                    "        visitor->visit(this);\n" +
                    "    }\n" +
                    "};\n" +
                    "\n" +
                    "class Monitor : public ComputerPart {\n" +
                    "public:\n" +
                    "    void accept(ComputerPartVisitor* visitor) override {\n" +
                    "        visitor->visit(this);\n" +
                    "    }\n" +
                    "};\n" +
                    "\n" +
                    "class Mouse : public ComputerPart {\n" +
                    "public:\n" +
                    "    void accept(ComputerPartVisitor* visitor) override {\n" +
                    "        visitor->visit(this);\n" +
                    "    }\n" +
                    "};\n" +
                    "\n" +
                    "class Computer : public ComputerPart {\n" +
                    "private:\n" +
                    "    std::vector<ComputerPart*> parts;\n" +
                    "public:\n" +
                    "    Computer() {\n" +
                    "        parts.push_back(new Mouse());\n" +
                    "        parts.push_back(new Keyboard());\n" +
                    "        parts.push_back(new Monitor());\n" +
                    "    }\n" +
                    "\n" +
                    "    ~Computer() {\n" +
                    "        for (ComputerPart* part : parts) {\n" +
                    "            delete part;\n" +
                    "        }\n" +
                    "    }\n" +
                    "\n" +
                    "    void accept(ComputerPartVisitor* visitor) override {\n" +
                    "        for (ComputerPart* part : parts) {\n" +
                    "            part->accept(visitor);\n" +
                    "        }\n" +
                    "        visitor->visit(this);\n" +
                    "    }\n" +
                    "};\n" +
                    "\n" +
                    "// Concrete Visitor\n" +
                    "class ComputerPartDisplayVisitor : public ComputerPartVisitor {\n" +
                    "public:\n" +
                    "    void visit(Computer* computer) override {\n" +
                    "        std::cout << \"Displaying Computer.\\n\";\n" +
                    "    }\n" +
                    "\n" +
                    "    void visit(Mouse* mouse) override {\n" +
                    "        std::cout << \"Displaying Mouse.\\n\";\n" +
                    "    }\n" +
                    "\n" +
                    "    void visit(Keyboard* keyboard) override {\n" +
                    "        std::cout << \"Displaying Keyboard.\\n\";\n" +
                    "    }\n" +
                    "\n" +
                    "    void visit(Monitor* monitor) override {\n" +
                    "        std::cout << \"Displaying Monitor.\\n\";\n" +
                    "    }\n" +
                    "};\n" +
                    "\n" +
                    "// Client\n" +
                    "int main() {\n" +
                    "    Computer* computer = new Computer();\n" +
                    "    computer->accept(new ComputerPartDisplayVisitor());\n" +
                    "\n" +
                    "    delete computer;\n" +
                    "    return 0;\n" +
                    "}\n";
            // More cases...
            default -> "Error for load code";
        };
    }

    public static String getCodeCSByNameBehavioralPattern(String pattern) {
        return switch (pattern) {
            case "Chain of Responsibility" -> "using System;\n" +
                    "\n" +
                    "// Handler interface\n" +
                    "public abstract class Handler\n" +
                    "{\n" +
                    "    protected Handler nextHandler;\n" +
                    "\n" +
                    "    public void SetNext(Handler handler)\n" +
                    "    {\n" +
                    "        nextHandler = handler;\n" +
                    "    }\n" +
                    "\n" +
                    "    public abstract void Handle(string request);\n" +
                    "}\n" +
                    "\n" +
                    "// Concrete Handlers\n" +
                    "public class ConcreteHandler1 : Handler\n" +
                    "{\n" +
                    "    public override void Handle(string request)\n" +
                    "    {\n" +
                    "        if (request == \"Handler1\")\n" +
                    "        {\n" +
                    "            Console.WriteLine(\"Handled by Handler1\");\n" +
                    "        }\n" +
                    "        else if (nextHandler != null)\n" +
                    "        {\n" +
                    "            nextHandler.Handle(request);\n" +
                    "        }\n" +
                    "    }\n" +
                    "}\n" +
                    "\n" +
                    "public class ConcreteHandler2 : Handler\n" +
                    "{\n" +
                    "    public override void Handle(string request)\n" +
                    "    {\n" +
                    "        if (request == \"Handler2\")\n" +
                    "        {\n" +
                    "            Console.WriteLine(\"Handled by Handler2\");\n" +
                    "        }\n" +
                    "        else if (nextHandler != null)\n" +
                    "        {\n" +
                    "            nextHandler.Handle(request);\n" +
                    "        }\n" +
                    "    }\n" +
                    "}\n" +
                    "\n" +
                    "// Client\n" +
                    "class Program\n" +
                    "{\n" +
                    "    static void Main(string[] args)\n" +
                    "    {\n" +
                    "        var handler1 = new ConcreteHandler1();\n" +
                    "        var handler2 = new ConcreteHandler2();\n" +
                    "\n" +
                    "        handler1.SetNext(handler2);\n" +
                    "\n" +
                    "        handler1.Handle(\"Handler1\");\n" +
                    "        handler1.Handle(\"Handler2\");\n" +
                    "    }\n" +
                    "}\n";
            case "Command" -> "using System;\n" +
                    "\n" +
                    "// Command interface\n" +
                    "public interface ICommand\n" +
                    "{\n" +
                    "    void Execute();\n" +
                    "}\n" +
                    "\n" +
                    "// Receiver\n" +
                    "public class Light\n" +
                    "{\n" +
                    "    public void On()\n" +
                    "    {\n" +
                    "        Console.WriteLine(\"Light is ON\");\n" +
                    "    }\n" +
                    "\n" +
                    "    public void Off()\n" +
                    "    {\n" +
                    "        Console.WriteLine(\"Light is OFF\");\n" +
                    "    }\n" +
                    "}\n" +
                    "\n" +
                    "// Concrete Commands\n" +
                    "public class LightOnCommand : ICommand\n" +
                    "{\n" +
                    "    private Light _light;\n" +
                    "\n" +
                    "    public LightOnCommand(Light light)\n" +
                    "    {\n" +
                    "        _light = light;\n" +
                    "    }\n" +
                    "\n" +
                    "    public void Execute()\n" +
                    "    {\n" +
                    "        _light.On();\n" +
                    "    }\n" +
                    "}\n" +
                    "\n" +
                    "public class LightOffCommand : ICommand\n" +
                    "{\n" +
                    "    private Light _light;\n" +
                    "\n" +
                    "    public LightOffCommand(Light light)\n" +
                    "    {\n" +
                    "        _light = light;\n" +
                    "    }\n" +
                    "\n" +
                    "    public void Execute()\n" +
                    "    {\n" +
                    "        _light.Off();\n" +
                    "    }\n" +
                    "}\n" +
                    "\n" +
                    "// Invoker\n" +
                    "public class RemoteControl\n" +
                    "{\n" +
                    "    private ICommand _command;\n" +
                    "\n" +
                    "    public void SetCommand(ICommand command)\n" +
                    "    {\n" +
                    "        _command = command;\n" +
                    "    }\n" +
                    "\n" +
                    "    public void PressButton()\n" +
                    "    {\n" +
                    "        _command.Execute();\n" +
                    "    }\n" +
                    "}\n" +
                    "\n" +
                    "// Client\n" +
                    "class Program\n" +
                    "{\n" +
                    "    static void Main(string[] args)\n" +
                    "    {\n" +
                    "        Light light = new Light();\n" +
                    "        ICommand lightOn = new LightOnCommand(light);\n" +
                    "        ICommand lightOff = new LightOffCommand(light);\n" +
                    "\n" +
                    "        RemoteControl remote = new RemoteControl();\n" +
                    "        remote.SetCommand(lightOn);\n" +
                    "        remote.PressButton();\n" +
                    "\n" +
                    "        remote.SetCommand(lightOff);\n" +
                    "        remote.PressButton();\n" +
                    "    }\n" +
                    "}\n";
            case "Iterator" -> "using System;\n" +
                    "using System.Collections.Generic;\n" +
                    "\n" +
                    "// Iterator interface\n" +
                    "public interface IIterator\n" +
                    "{\n" +
                    "    bool HasNext();\n" +
                    "    string Next();\n" +
                    "}\n" +
                    "\n" +
                    "// Collection interface\n" +
                    "public interface IContainer\n" +
                    "{\n" +
                    "    IIterator CreateIterator();\n" +
                    "}\n" +
                    "\n" +
                    "// Concrete Collection\n" +
                    "public class NameRepository : IContainer\n" +
                    "{\n" +
                    "    private List<string> names = new List<string> { \"John\", \"Jane\", \"Doe\" };\n" +
                    "\n" +
                    "    public IIterator CreateIterator()\n" +
                    "    {\n" +
                    "        return new NameIterator(names);\n" +
                    "    }\n" +
                    "\n" +
                    "    private class NameIterator : IIterator\n" +
                    "    {\n" +
                    "        private int index = 0;\n" +
                    "        private List<string> _names;\n" +
                    "\n" +
                    "        public NameIterator(List<string> names)\n" +
                    "        {\n" +
                    "            _names = names;\n" +
                    "        }\n" +
                    "\n" +
                    "        public bool HasNext()\n" +
                    "        {\n" +
                    "            return index < _names.Count;\n" +
                    "        }\n" +
                    "\n" +
                    "        public string Next()\n" +
                    "        {\n" +
                    "            if (HasNext())\n" +
                    "            {\n" +
                    "                return _names[index++];\n" +
                    "            }\n" +
                    "            return null;\n" +
                    "        }\n" +
                    "    }\n" +
                    "}\n" +
                    "\n" +
                    "// Client\n" +
                    "class Program\n" +
                    "{\n" +
                    "    static void Main(string[] args)\n" +
                    "    {\n" +
                    "        NameRepository namesRepository = new NameRepository();\n" +
                    "\n" +
                    "        for (IIterator iter = namesRepository.CreateIterator(); iter.HasNext();)\n" +
                    "        {\n" +
                    "            string name = iter.Next();\n" +
                    "            Console.WriteLine(\"Name: \" + name);\n" +
                    "        }\n" +
                    "    }\n" +
                    "}\n";
            case "Mediator"  -> "using System;\n" +
                    "\n" +
                    "// Mediator interface\n" +
                    "public interface IMediator\n" +
                    "{\n" +
                    "    void SendMessage(string message, Colleague colleague);\n" +
                    "}\n" +
                    "\n" +
                    "// Colleague abstract class\n" +
                    "public abstract class Colleague\n" +
                    "{\n" +
                    "    protected IMediator mediator;\n" +
                    "\n" +
                    "    public Colleague(IMediator mediator)\n" +
                    "    {\n" +
                    "        this.mediator = mediator;\n" +
                    "    }\n" +
                    "}\n" +
                    "\n" +
                    "// Concrete Colleague1\n" +
                    "public class Colleague1 : Colleague\n" +
                    "{\n" +
                    "    public Colleague1(IMediator mediator) : base(mediator) { }\n" +
                    "\n" +
                    "    public void Send(string message)\n" +
                    "    {\n" +
                    "        mediator.SendMessage(message, this);\n" +
                    "    }\n" +
                    "\n" +
                    "    public void Notify(string message)\n" +
                    "    {\n" +
                    "        Console.WriteLine(\"Colleague1 gets message: \" + message);\n" +
                    "    }\n" +
                    "}\n" +
                    "\n" +
                    "// Concrete Colleague2\n" +
                    "public class Colleague2 : Colleague\n" +
                    "{\n" +
                    "    public Colleague2(IMediator mediator) : base(mediator) { }\n" +
                    "\n" +
                    "    public void Send(string message)\n" +
                    "    {\n" +
                    "        mediator.SendMessage(message, this);\n" +
                    "    }\n" +
                    "\n" +
                    "    public void Notify(string message)\n" +
                    "    {\n" +
                    "        Console.WriteLine(\"Colleague2 gets message: \" + message);\n" +
                    "    }\n" +
                    "}\n" +
                    "\n" +
                    "// Concrete Mediator\n" +
                    "public class ConcreteMediator : IMediator\n" +
                    "{\n" +
                    "    public Colleague1 Colleague1 { get; set; }\n" +
                    "    public Colleague2 Colleague2 { get; set; }\n" +
                    "\n" +
                    "    public void SendMessage(string message, Colleague colleague)\n" +
                    "    {\n" +
                    "        if (colleague == Colleague1)\n" +
                    "        {\n" +
                    "            Colleague2.Notify(message);\n" +
                    "        }\n" +
                    "        else\n" +
                    "        {\n" +
                    "            Colleague1.Notify(message);\n" +
                    "        }\n" +
                    "    }\n" +
                    "}\n" +
                    "\n" +
                    "// Client\n" +
                    "class Program\n" +
                    "{\n" +
                    "    static void Main(string[] args)\n" +
                    "    {\n" +
                    "        ConcreteMediator mediator = new ConcreteMediator();\n" +
                    "\n" +
                    "        Colleague1 colleague1 = new Colleague1(mediator);\n" +
                    "        Colleague2 colleague2 = new Colleague2(mediator);\n" +
                    "\n" +
                    "        mediator.Colleague1 = colleague1;\n" +
                    "        mediator.Colleague2 = colleague2;\n" +
                    "\n" +
                    "        colleague1.Send(\"Hello, Colleague2!\");\n" +
                    "        colleague2.Send(\"Hi, Colleague1!\");\n" +
                    "    }\n" +
                    "}\n";
            case "Memento"  -> "using System;\n" +
                    "using System.Collections.Generic;\n" +
                    "\n" +
                    "// Memento class\n" +
                    "public class Memento\n" +
                    "{\n" +
                    "    private string state;\n" +
                    "\n" +
                    "    public Memento(string state)\n" +
                    "    {\n" +
                    "        this.state = state;\n" +
                    "    }\n" +
                    "\n" +
                    "    public string GetState()\n" +
                    "    {\n" +
                    "        return state;\n" +
                    "    }\n" +
                    "}\n" +
                    "\n" +
                    "// Originator class\n" +
                    "public class Originator\n" +
                    "{\n" +
                    "    private string state;\n" +
                    "\n" +
                    "    public void SetState(string state)\n" +
                    "    {\n" +
                    "        this.state = state;\n" +
                    "    }\n" +
                    "\n" +
                    "    public string GetState()\n" +
                    "    {\n" +
                    "        return state;\n" +
                    "    }\n" +
                    "\n" +
                    "    public Memento SaveStateToMemento()\n" +
                    "    {\n" +
                    "        return new Memento(state);\n" +
                    "    }\n" +
                    "\n" +
                    "    public void GetStateFromMemento(Memento memento)\n" +
                    "    {\n" +
                    "        state = memento.GetState();\n" +
                    "    }\n" +
                    "}\n" +
                    "\n" +
                    "// Caretaker class\n" +
                    "public class Caretaker\n" +
                    "{\n" +
                    "    private List<Memento> mementoList = new List<Memento>();\n" +
                    "\n" +
                    "    public void Add(Memento state)\n" +
                    "    {\n" +
                    "        mementoList.Add(state);\n" +
                    "    }\n" +
                    "\n" +
                    "    public Memento Get(int index)\n" +
                    "    {\n" +
                    "        return mementoList[index];\n" +
                    "    }\n" +
                    "}\n" +
                    "\n" +
                    "// Client\n" +
                    "class Program\n" +
                    "{\n" +
                    "    static void Main(string[] args)\n" +
                    "    {\n" +
                    "        Originator originator = new Originator();\n" +
                    "        Caretaker caretaker = new Caretaker();\n" +
                    "\n" +
                    "        originator.SetState(\"State #1\");\n" +
                    "        originator.SetState(\"State #2\");\n" +
                    "        caretaker.Add(originator.SaveStateToMemento());\n" +
                    "\n" +
                    "        originator.SetState(\"State #3\");\n" +
                    "        caretaker.Add(originator.SaveStateToMemento());\n" +
                    "\n" +
                    "        originator.SetState(\"State #4\");\n" +
                    "        Console.WriteLine(\"Current State: \" + originator.GetState());\n" +
                    "\n" +
                    "        originator.GetStateFromMemento(caretaker.Get(0));\n" +
                    "        Console.WriteLine(\"First saved State: \" + originator.GetState());\n" +
                    "\n" +
                    "        originator.GetStateFromMemento(caretaker.Get(1));\n" +
                    "        Console.WriteLine(\"Second saved State: \" + originator.GetState());\n" +
                    "    }\n" +
                    "}\n";
            case "Observer"  -> "using System;\n" +
                    "using System.Collections.Generic;\n" +
                    "\n" +
                    "// Observer interface\n" +
                    "public interface IObserver\n" +
                    "{\n" +
                    "    void Update(string message);\n" +
                    "}\n" +
                    "\n" +
                    "// Subject interface\n" +
                    "public interface ISubject\n" +
                    "{\n" +
                    "    void RegisterObserver(IObserver observer);\n" +
                    "    void RemoveObserver(IObserver observer);\n" +
                    "    void NotifyObservers();\n" +
                    "}\n" +
                    "\n" +
                    "// Concrete Subject\n" +
                    "public class ConcreteSubject : ISubject\n" +
                    "{\n" +
                    "    private List<IObserver> observers = new List<IObserver>();\n" +
                    "    private string message;\n" +
                    "\n" +
                    "    public void RegisterObserver(IObserver observer)\n" +
                    "    {\n" +
                    "        observers.Add(observer);\n" +
                    "    }\n" +
                    "\n" +
                    "    public void RemoveObserver(IObserver observer)\n" +
                    "    {\n" +
                    "        observers.Remove(observer);\n" +
                    "    }\n" +
                    "\n" +
                    "    public void NotifyObservers()\n" +
                    "    {\n" +
                    "        foreach (IObserver observer in observers)\n" +
                    "        {\n" +
                    "            observer.Update(message);\n" +
                    "        }\n" +
                    "    }\n" +
                    "\n" +
                    "    public void SetMessage(string message)\n" +
                    "    {\n" +
                    "        this.message = message;\n" +
                    "        NotifyObservers();\n" +
                    "    }\n" +
                    "}\n" +
                    "\n" +
                    "// Concrete Observer\n" +
                    "public class ConcreteObserver : IObserver\n" +
                    "{\n" +
                    "    private string name;\n" +
                    "\n" +
                    "    public ConcreteObserver(string name)\n" +
                    "    {\n" +
                    "        this.name = name;\n" +
                    "    }\n" +
                    "\n" +
                    "    public void Update(string message)\n" +
                    "    {\n" +
                    "        Console.WriteLine($\"{name} received message: {message}\");\n" +
                    "    }\n" +
                    "}\n" +
                    "\n" +
                    "// Client\n" +
                    "class Program\n" +
                    "{\n" +
                    "    static void Main(string[] args)\n" +
                    "    {\n" +
                    "        ConcreteSubject subject = new ConcreteSubject();\n" +
                    "\n" +
                    "        ConcreteObserver observer1 = new ConcreteObserver(\"Observer1\");\n" +
                    "        ConcreteObserver observer2 = new ConcreteObserver(\"Observer2\");\n" +
                    "\n" +
                    "        subject.RegisterObserver(observer1);\n" +
                    "        subject.RegisterObserver(observer2);\n" +
                    "\n" +
                    "        subject.SetMessage(\"Hello Observers!\");\n" +
                    "\n" +
                    "        subject.RemoveObserver(observer1);\n" +
                    "\n" +
                    "        subject.SetMessage(\"Observer1 removed\");\n" +
                    "    }\n" +
                    "}\n";
            case "State"  -> "using System;\n" +
                    "\n" +
                    "// State interface\n" +
                    "public interface IState\n" +
                    "{\n" +
                    "    void DoAction(Context context);\n" +
                    "    string ToString();\n" +
                    "}\n" +
                    "\n" +
                    "// Context class\n" +
                    "public class Context\n" +
                    "{\n" +
                    "    private IState state;\n" +
                    "\n" +
                    "    public void SetState(IState state)\n" +
                    "    {\n" +
                    "        this.state = state;\n" +
                    "    }\n" +
                    "\n" +
                    "    public IState GetState()\n" +
                    "    {\n" +
                    "        return state;\n" +
                    "    }\n" +
                    "}\n" +
                    "\n" +
                    "// Concrete States\n" +
                    "public class StartState : IState\n" +
                    "{\n" +
                    "    public void DoAction(Context context)\n" +
                    "    {\n" +
                    "        Console.WriteLine(\"Player is in start state\");\n" +
                    "        context.SetState(this);\n" +
                    "    }\n" +
                    "\n" +
                    "    public override string ToString()\n" +
                    "    {\n" +
                    "        return \"Start State\";\n" +
                    "    }\n" +
                    "}\n" +
                    "\n" +
                    "public class StopState : IState\n" +
                    "{\n" +
                    "    public void DoAction(Context context)\n" +
                    "    {\n" +
                    "        Console.WriteLine(\"Player is in stop state\");\n" +
                    "        context.SetState(this);\n" +
                    "    }\n" +
                    "\n" +
                    "    public override string ToString()\n" +
                    "    {\n" +
                    "        return \"Stop State\";\n" +
                    "    }\n" +
                    "}\n" +
                    "\n" +
                    "// Client\n" +
                    "class Program\n" +
                    "{\n" +
                    "    static void Main(string[] args)\n" +
                    "    {\n" +
                    "        Context context = new Context();\n" +
                    "\n" +
                    "        StartState startState = new StartState();\n" +
                    "        startState.DoAction(context);\n" +
                    "\n" +
                    "        Console.WriteLine(context.GetState().ToString());\n" +
                    "\n" +
                    "        StopState stopState = new StopState();\n" +
                    "        stopState.DoAction(context);\n" +
                    "\n" +
                    "        Console.WriteLine(context.GetState().ToString());\n" +
                    "    }\n" +
                    "}\n";
            case "Strategy"  -> "using System;\n" +
                    "\n" +
                    "// Strategy interface\n" +
                    "public interface IStrategy\n" +
                    "{\n" +
                    "    int DoOperation(int num1, int num2);\n" +
                    "}\n" +
                    "\n" +
                    "// Concrete Strategies\n" +
                    "public class OperationAdd : IStrategy\n" +
                    "{\n" +
                    "    public int DoOperation(int num1, int num2)\n" +
                    "    {\n" +
                    "        return num1 + num2;\n" +
                    "    }\n" +
                    "}\n" +
                    "\n" +
                    "public class OperationSubtract : IStrategy\n" +
                    "{\n" +
                    "    public int DoOperation(int num1, int num2)\n" +
                    "    {\n" +
                    "        return num1 - num2;\n" +
                    "    }\n" +
                    "}\n" +
                    "\n" +
                    "public class OperationMultiply : IStrategy\n" +
                    "{\n" +
                    "    public int DoOperation(int num1, int num2)\n" +
                    "    {\n" +
                    "        return num1 * num2;\n" +
                    "    }\n" +
                    "}\n" +
                    "\n" +
                    "// Context class\n" +
                    "public class Context\n" +
                    "{\n" +
                    "    private IStrategy strategy;\n" +
                    "\n" +
                    "    public Context(IStrategy strategy)\n" +
                    "    {\n" +
                    "        this.strategy = strategy;\n" +
                    "    }\n" +
                    "\n" +
                    "    public int ExecuteStrategy(int num1, int num2)\n" +
                    "    {\n" +
                    "        return strategy.DoOperation(num1, num2);\n" +
                    "    }\n" +
                    "}\n" +
                    "\n" +
                    "// Client\n" +
                    "class Program\n" +
                    "{\n" +
                    "    static void Main(string[] args)\n" +
                    "    {\n" +
                    "        Context context = new Context(new OperationAdd());\n" +
                    "        Console.WriteLine(\"10 + 5 = \" + context.ExecuteStrategy(10, 5));\n" +
                    "\n" +
                    "        context = new Context(new OperationSubtract());\n" +
                    "        Console.WriteLine(\"10 - 5 = \" + context.ExecuteStrategy(10, 5));\n" +
                    "\n" +
                    "        context = new Context(new OperationMultiply());\n" +
                    "        Console.WriteLine(\"10 * 5 = \" + context.ExecuteStrategy(10, 5));\n" +
                    "    }\n" +
                    "}\n";
            case "Template Method"  -> "using System;\n" +
                    "\n" +
                    "// Abstract class\n" +
                    "public abstract class Game\n" +
                    "{\n" +
                    "    // Template method\n" +
                    "    public void Play()\n" +
                    "    {\n" +
                    "        Initialize();\n" +
                    "        StartPlay();\n" +
                    "        EndPlay();\n" +
                    "    }\n" +
                    "\n" +
                    "    protected abstract void Initialize();\n" +
                    "    protected abstract void StartPlay();\n" +
                    "    protected abstract void EndPlay();\n" +
                    "}\n" +
                    "\n" +
                    "// Concrete classes\n" +
                    "public class Cricket : Game\n" +
                    "{\n" +
                    "    protected override void Initialize()\n" +
                    "    {\n" +
                    "        Console.WriteLine(\"Cricket Game Initialized! Start playing.\");\n" +
                    "    }\n" +
                    "\n" +
                    "    protected override void StartPlay()\n" +
                    "    {\n" +
                    "        Console.WriteLine(\"Cricket Game Started. Enjoy the game!\");\n" +
                    "    }\n" +
                    "\n" +
                    "    protected override void EndPlay()\n" +
                    "    {\n" +
                    "        Console.WriteLine(\"Cricket Game Finished!\");\n" +
                    "    }\n" +
                    "}\n" +
                    "\n" +
                    "public class Football : Game\n" +
                    "{\n" +
                    "    protected override void Initialize()\n" +
                    "    {\n" +
                    "        Console.WriteLine(\"Football Game Initialized! Start playing.\");\n" +
                    "    }\n" +
                    "\n" +
                    "    protected override void StartPlay()\n" +
                    "    {\n" +
                    "        Console.WriteLine(\"Football Game Started. Enjoy the game!\");\n" +
                    "    }\n" +
                    "\n" +
                    "    protected override void EndPlay()\n" +
                    "    {\n" +
                    "        Console.WriteLine(\"Football Game Finished!\");\n" +
                    "    }\n" +
                    "}\n" +
                    "\n" +
                    "// Client\n" +
                    "class Program\n" +
                    "{\n" +
                    "    static void Main(string[] args)\n" +
                    "    {\n" +
                    "        Game game = new Cricket();\n" +
                    "        game.Play();\n" +
                    "\n" +
                    "        game = new Football();\n" +
                    "        game.Play();\n" +
                    "    }\n" +
                    "}\n";
            case "Visitor" -> "using System;\n" +
                    "using System.Collections.Generic;\n" +
                    "\n" +
                    "// Visitor interface\n" +
                    "public interface IComputerPartVisitor\n" +
                    "{\n" +
                    "    void Visit(Computer computer);\n" +
                    "    void Visit(Mouse mouse);\n" +
                    "    void Visit(Keyboard keyboard);\n" +
                    "    void Visit(Monitor monitor);\n" +
                    "}\n" +
                    "\n" +
                    "// ComputerPart interface\n" +
                    "public interface IComputerPart\n" +
                    "{\n" +
                    "    void Accept(IComputerPartVisitor visitor);\n" +
                    "}\n" +
                    "\n" +
                    "// Concrete ComputerParts\n" +
                    "public class Mouse : IComputerPart\n" +
                    "{\n" +
                    "    public void Accept(IComputerPartVisitor visitor)\n" +
                    "    {\n" +
                    "        visitor.Visit(this);\n" +
                    "    }\n" +
                    "}\n" +
                    "\n" +
                    "public class Keyboard : IComputerPart\n" +
                    "{\n" +
                    "    public void Accept(IComputerPartVisitor visitor)\n" +
                    "    {\n" +
                    "        visitor.Visit(this);\n" +
                    "    }\n" +
                    "}\n" +
                    "\n" +
                    "public class Monitor : IComputerPart\n" +
                    "{\n" +
                    "    public void Accept(IComputerPartVisitor visitor)\n" +
                    "    {\n" +
                    "        visitor.Visit(this);\n" +
                    "    }\n" +
                    "}\n" +
                    "\n" +
                    "public class Computer : IComputerPart\n" +
                    "{\n" +
                    "    IComputerPart[] parts;\n" +
                    "\n" +
                    "    public Computer()\n" +
                    "    {\n" +
                    "        parts = new IComputerPart[] { new Mouse(), new Keyboard(), new Monitor() };\n" +
                    "    }\n" +
                    "\n" +
                    "    public void Accept(IComputerPartVisitor visitor)\n" +
                    "    {\n" +
                    "        foreach (var part in parts)\n" +
                    "        {\n" +
                    "            part.Accept(visitor);\n" +
                    "        }\n" +
                    "        visitor.Visit(this);\n" +
                    "    }\n" +
                    "}\n" +
                    "\n" +
                    "// Concrete Visitor\n" +
                    "public class ComputerPartDisplayVisitor : IComputerPartVisitor\n" +
                    "{\n" +
                    "    public void Visit(Computer computer)\n" +
                    "    {\n" +
                    "        Console.WriteLine(\"Displaying Computer.\");\n" +
                    "    }\n" +
                    "\n" +
                    "    public void Visit(Mouse mouse)\n" +
                    "    {\n" +
                    "        Console.WriteLine(\"Displaying Mouse.\");\n" +
                    "    }\n" +
                    "\n" +
                    "    public void Visit(Keyboard keyboard)\n" +
                    "    {\n" +
                    "        Console.WriteLine(\"Displaying Keyboard.\");\n" +
                    "    }\n" +
                    "\n" +
                    "    public void Visit(Monitor monitor)\n" +
                    "    {\n" +
                    "        Console.WriteLine(\"Displaying Monitor.\");\n" +
                    "    }\n" +
                    "}\n" +
                    "\n" +
                    "// Client\n" +
                    "class Program\n" +
                    "{\n" +
                    "    static void Main(string[] args)\n" +
                    "    {\n" +
                    "        IComputerPart computer = new Computer();\n" +
                    "        computer.Accept(new ComputerPartDisplayVisitor());\n" +
                    "    }\n" +
                    "}\n";
            // More cases...
            default -> "Error for load code";
        };
    }

}
