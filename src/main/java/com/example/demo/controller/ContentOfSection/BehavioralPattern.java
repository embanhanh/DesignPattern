package com.example.demo.controller.ContentOfSection;

import com.example.demo.controller.DesignPatternController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.util.ResourceBundle;

import static com.example.demo.CodeExample.CodeExampleBehavioralPattern.*;

public class BehavioralPattern implements Initializable {
    @FXML
    private AnchorPane MainContainer;

    @FXML
    private Button btnChainOfResponsibility;

    @FXML
    private Button btnCommand;

    @FXML
    private Button btnIterator;

    @FXML
    private Button btnMediator;

    @FXML
    private Button btnMemento;

    @FXML
    private Button btnObserver;

    @FXML
    private Button btnState;

    @FXML
    private Button btnStrategy;

    @FXML
    private Button btnTemplateMethod;

    @FXML
    private Button btnVisitor;

    private static final String[] BUTTON_STYLES = {
            "button1", "button2", "button3", "button4", "button5"
    };

    private int currentStyleIndex = 0;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        applyRandomStyles(btnChainOfResponsibility);
        applyRandomStyles(btnCommand);
        applyRandomStyles(btnIterator);
        applyRandomStyles(btnMediator);
        applyRandomStyles(btnMemento);
        applyRandomStyles(btnObserver);
        applyRandomStyles(btnState);
        applyRandomStyles(btnStrategy);
        applyRandomStyles(btnTemplateMethod);
        applyRandomStyles(btnVisitor);
    }

    private void applyRandomStyles(Button button) {
        button.getStyleClass().add(BUTTON_STYLES[currentStyleIndex]);
        currentStyleIndex = (currentStyleIndex + 1) % BUTTON_STYLES.length;
    }

    @FXML
    public void btnChainOfResponsibilityOnAction(ActionEvent event) {
        try{
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/UI/DesignPattern/DesignPattern.fxml"));
            Parent newContent3 = loader.load();
            DesignPatternController pattern = loader.getController();
            String labelPattern = "Chain of Responsibility";
            String labelIntent = "Chain of Responsibility is a behavioral design pattern that lets you pass requests along a chain of handlers. Upon receiving a request, each handler decides either to process the request or to pass it to the next handler in the chain.\n";
            String labelImplement = "1. Declare the handler interface and describe the signature of a method for handling requests.\n" +
                    "2. To eliminate duplicate boilerplate code in concrete handlers, it might be worth creating an abstract base handler class, derived from the handler interface.\n" +
                    "3. One by one create concrete handler subclasses and implement their handling methods. Each handler should make two decisions when receiving a request:\n" +
                    "   a. Whether it’ll process the request.\n" +
                    "   b. Whether it’ll pass the request along the chain.\n" +
                    "4. The client may either assemble chains on its own or receive pre-built chains from other objects. In the latter case, you must implement some factory classes to build chains according to the configuration or environment settings.\n" +
                    "5. The client may trigger any handler in the chain, not just the first one. The request will be passed along the chain until some handler refuses to pass it further or until it reaches the end of the chain.\n" +
                    "6. Due to the dynamic nature of the chain, the client should be ready to handle the following scenarios:\n" +
                    "   a. The chain may consist of a single link.\n" +
                    "   b. Some requests may not reach the end of the chain.\n" +
                    "   c. Others may reach the end of the chain unhandled.\n";
            String labelProsNCons = "- You can control the order of request handling.\n" +
                    "- Single Responsibility Principle. You can decouple classes that invoke operations from classes that perform operations.\n" +
                    "- Open/Closed Principle. You can introduce new handlers into the app without breaking the existing client code.\n" +
                    "- Some requests may end up unhandled.\n";
            String textCodePython = getCodePythonByNameBehavioralPattern("Chain of Responsibility");
            String textCodeJava = getCodeJavaByNameBehavioralPattern("Chain of Responsibility");
            String textCodeCPP = getCodeCPPByNameBehavioralPattern("Chain of Responsibility");
            String textCodeCS = getCodeCSByNameBehavioralPattern("Chain of Responsibility");
            String pathToImgIntent = "/Images/BehavioralPatterns/ChainOfResponsibility/intent.png";
            String pathToImgStructure = "/Images/BehavioralPatterns/ChainOfResponsibility/structure.png";
            pattern.setData(labelPattern, labelIntent, labelImplement, labelProsNCons, textCodeJava, textCodePython, textCodeCPP, textCodeCS, pathToImgIntent, pathToImgStructure);
            MainContainer.getChildren().removeAll();
            MainContainer.getChildren().add(newContent3);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @FXML
    public void btnCommandOnAction(ActionEvent event) {
        try{
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/UI/DesignPattern/DesignPattern.fxml"));
            Parent newContent3 = loader.load();
            DesignPatternController pattern = loader.getController();
            String labelPattern = "Command";
            String labelIntent = "Command is a behavioral design pattern that turns a request into a stand-alone object that contains all information about the request. This transformation lets you pass requests as a method arguments, delay or queue a request’s execution, and support undoable operations.\n";
            String labelImplement = "1. Declare the command interface with a single execution method.\n" +
                    "2. Start extracting requests into concrete command classes that implement the command interface. Each class must have a set of fields for storing the request arguments along with a reference to the actual receiver object. All these values must be initialized via the command’s constructor.\n" +
                    "3. Identify classes that will act as senders. Add the fields for storing commands into these classes. Senders should communicate with their commands only via the command interface. Senders usually don’t create command objects on their own, but rather get them from the client code.\n" +
                    "4. Change the senders so they execute the command instead of sending a request to the receiver directly.\n" +
                    "5. The client should initialize objects in the following order:\n" +
                    "   a. Create receivers.\n" +
                    "   b. Create commands, and associate them with receivers if needed.\n" +
                    "   c. Create senders, and associate them with specific commands.\n";
            String labelProsNCons = "- Single Responsibility Principle. You can decouple classes that invoke operations from classes that perform these operations.\n" +
                    "- Open/Closed Principle. You can introduce new commands into the app without breaking existing client code.\n" +
                    "- You can implement undo/redo.\n" +
                    "- You can implement deferred execution of operations.\n" +
                    "- You can assemble a set of simple commands into a complex one.\n" +
                    "- The code may become more complicated since you’re introducing a whole new layer between senders and receivers.\n";
            String textCodePython = getCodePythonByNameBehavioralPattern("Command");
            String textCodeJava = getCodeJavaByNameBehavioralPattern("Command");
            String textCodeCPP = getCodeCPPByNameBehavioralPattern("Command");
            String textCodeCS = getCodeCSByNameBehavioralPattern("Command");
            String pathToImgIntent = "/Images/BehavioralPatterns/Command/intent.png";
            String pathToImgStructure = "/Images/BehavioralPatterns/Command/structure.png";
            pattern.setData(labelPattern, labelIntent, labelImplement, labelProsNCons, textCodeJava, textCodePython, textCodeCPP, textCodeCS, pathToImgIntent, pathToImgStructure);
            MainContainer.getChildren().removeAll();
            MainContainer.getChildren().add(newContent3);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @FXML
    public void btnIteratorOnAction(ActionEvent event) {
        try{
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/UI/DesignPattern/DesignPattern.fxml"));
            Parent newContent3 = loader.load();
            DesignPatternController pattern = loader.getController();
            String labelPattern = "Iterator";
            String labelIntent = "Iterator is a behavioral design pattern that lets you traverse elements of a collection without exposing its underlying representation (list, stack, tree, etc.).";
            String labelImplement = "1. Declare the iterator interface. At the very least, it must have a method for fetching the next element from a collection. But for the sake of convenience you can add a couple of other methods, such as fetching the previous element, tracking the current position, and checking the end of the iteration.\n" +
                    "2. Declare the collection interface and describe a method for fetching iterators. The return type should be equal to that of the iterator interface. You may declare similar methods if you plan to have several distinct groups of iterators.\n" +
                    "3. Implement concrete iterator classes for the collections that you want to be traversable with iterators. An iterator object must be linked with a single collection instance. Usually, this link is established via the iterator’s constructor.\n" +
                    "4. Implement the collection interface in your collection classes. The main idea is to provide the client with a shortcut for creating iterators, tailored for a particular collection class. The collection object must pass itself to the iterator’s constructor to establish a link between them.\n" +
                    "5. Go over the client code to replace all of the collection traversal code with the use of iterators. The client fetches a new iterator object each time it needs to iterate over the collection elements.\n";
            String labelProsNCons = "- Single Responsibility Principle. You can clean up the client code and the collections by extracting bulky traversal algorithms into separate classes.\n" +
                    "- Open/Closed Principle. You can implement new types of collections and iterators and pass them to existing code without breaking anything.\n" +
                    "- You can iterate over the same collection in parallel because each iterator object contains its own iteration state.\n" +
                    "- For the same reason, you can delay an iteration and continue it when needed.\n" +
                    "- Applying the pattern can be an overkill if your app only works with simple collections.\n" +
                    "- Using an iterator may be less efficient than going through elements of some specialized collections directly.\n";
            String textCodePython = getCodePythonByNameBehavioralPattern("Iterator");
            String textCodeJava = getCodeJavaByNameBehavioralPattern("Iterator");
            String textCodeCPP = getCodeCPPByNameBehavioralPattern("Iterator");
            String textCodeCS = getCodeCSByNameBehavioralPattern("Iterator");
            String pathToImgIntent = "/Images/BehavioralPatterns/Interator/intent.png";
            String pathToImgStructure = "/Images/BehavioralPatterns/Interator/structure.png";
            pattern.setData(labelPattern, labelIntent, labelImplement, labelProsNCons, textCodeJava, textCodePython, textCodeCPP, textCodeCS, pathToImgIntent, pathToImgStructure);
            MainContainer.getChildren().removeAll();
            MainContainer.getChildren().add(newContent3);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @FXML
    public void btnMediatorOnAction(ActionEvent event) {
        try{
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/UI/DesignPattern/DesignPattern.fxml"));
            Parent newContent3 = loader.load();
            DesignPatternController pattern = loader.getController();
            String labelPattern = "Mediator";
            String labelIntent = "Mediator is a behavioral design pattern that lets you reduce chaotic dependencies between objects. The pattern restricts direct communications between the objects and forces them to collaborate only via a mediator object.\n";
            String labelImplement = "1. Identify a group of tightly coupled classes which would benefit from being more independent (e.g., for easier maintenance or simpler reuse of these classes).\n" +
                    "2. Declare the mediator interface and describe the desired communication protocol between mediators and various components. In most cases, a single method for receiving notifications from components is sufficient.\n" +
                    "   This interface is crucial when you want to reuse component classes in different contexts. As long as the component works with its mediator via the generic interface, you can link the component with a different implementation of the mediator.\n" +
                    "3. Implement the concrete mediator class. Consider storing references to all components inside the mediator. This way, you could call any component from the mediator’s methods.\n" +
                    "4. You can go even further and make the mediator responsible for the creation and destruction of component objects. After this, the mediator may resemble a factory or a facade.\n" +
                    "5. Components should store a reference to the mediator object. The connection is usually established in the component’s constructor, where a mediator object is passed as an argument.\n" +
                    "6. Change the components’ code so that they call the mediator’s notification method instead of methods on other components. Extract the code that involves calling other components into the mediator class. Execute this code whenever the mediator receives notifications from that component.\n";
            String labelProsNCons = "- Single Responsibility Principle. You can extract the communications between various components into a single place, making it easier to comprehend and maintain.\n" +
                    "- Open/Closed Principle. You can introduce new mediators without having to change the actual components.\n" +
                    "- You can reduce coupling between various components of a program.\n" +
                    "- You can reuse individual components more easily.\n" +
                    "- Over time a mediator can evolve into a God Object.";
            String textCodePython = getCodePythonByNameBehavioralPattern("Mediator");
            String textCodeJava = getCodeJavaByNameBehavioralPattern("Mediator");
            String textCodeCPP = getCodeCPPByNameBehavioralPattern("Mediator");
            String textCodeCS = getCodeCSByNameBehavioralPattern("Mediator");
            String pathToImgIntent = "/Images/BehavioralPatterns/Mediator/intent.png";
            String pathToImgStructure = "/Images/BehavioralPatterns/Mediator/structure.png";
            pattern.setData(labelPattern, labelIntent, labelImplement, labelProsNCons, textCodeJava, textCodePython, textCodeCPP, textCodeCS, pathToImgIntent, pathToImgStructure);
            MainContainer.getChildren().removeAll();
            MainContainer.getChildren().add(newContent3);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @FXML
    public void btnMementoOnAction(ActionEvent event) {
        try{
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/UI/DesignPattern/DesignPattern.fxml"));
            Parent newContent3 = loader.load();
            DesignPatternController pattern = loader.getController();
            String labelPattern = "Memento";
            String labelIntent = "Memento is a behavioral design pattern that lets you save and restore the previous state of an object without revealing the details of its implementation.";
            String labelImplement = "1. Determine what class will play the role of the originator. It’s important to know whether the program uses one central object of this type or multiple smaller ones.\n" +
                    "2. Create the memento class. One by one, declare a set of fields that mirror the fields declared inside the originator class.\n" +
                    "3. Make the memento class immutable. A memento should accept the data just once, via the constructor. The class should have no setters.\n" +
                    "4. If your programming language supports nested classes, nest the memento inside the originator. If not, extract a blank interface from the memento class and make all other objects use it to refer to the memento. You may add some metadata operations to the interface, but nothing that exposes the originator’s state.\n" +
                    "5. Add a method for producing mementos to the originator class. The originator should pass its state to the memento via one or multiple arguments of the memento’s constructor.\n" +
                    "   The return type of the method should be of the interface you extracted in the previous step (assuming that you extracted it at all). Under the hood, the memento-producing method should work directly with the memento class.\n" +
                    "6. Add a method for restoring the originator’s state to its class. It should accept a memento object as an argument. If you extracted an interface in the previous step, make it the type of the parameter. In this case, you need to typecast the incoming object to the memento class, since the originator needs full access to that object.\n" +
                    "7. The caretaker, whether it represents a command object, a history, or something entirely different, should know when to request new mementos from the originator, how to store them and when to restore the originator with a particular memento.\n" +
                    "8. The link between caretakers and originators may be moved into the memento class. In this case, each memento must be connected to the originator that had created it. The restoration method would also move to the memento class. However, this would all make sense only if the memento class is nested into originator or the originator class provides sufficient setters for overriding its state.\n";
            String labelProsNCons = "- You can produce snapshots of the object’s state without violating its encapsulation.\n" +
                    "- You can simplify the originator’s code by letting the caretaker maintain the history of the originator’s state.\n" +
                    "- The app might consume lots of RAM if clients create mementos too often.\n" +
                    "- Caretakers should track the originator’s lifecycle to be able to destroy obsolete mementos.\n" +
                    "- Most dynamic programming languages, such as PHP, Python and JavaScript, can’t guarantee that the state within the memento stays untouched.\n";
            String textCodePython = getCodePythonByNameBehavioralPattern("Memento");
            String textCodeJava = getCodeJavaByNameBehavioralPattern("Memento");
            String textCodeCPP = getCodeCPPByNameBehavioralPattern("Memento");
            String textCodeCS = getCodeCSByNameBehavioralPattern("Memento");
            String pathToImgIntent = "/Images/BehavioralPatterns/Observer/intent.png";
            String pathToImgStructure = "/Images/BehavioralPatterns/Observer/structure.png";
            pattern.setData(labelPattern, labelIntent, labelImplement, labelProsNCons, textCodeJava, textCodePython, textCodeCPP, textCodeCS, pathToImgIntent, pathToImgStructure);
            MainContainer.getChildren().removeAll();
            MainContainer.getChildren().add(newContent3);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @FXML
    public void btnObserverOnAction(ActionEvent event) {
        try{
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/UI/DesignPattern/DesignPattern.fxml"));
            Parent newContent3 = loader.load();
            DesignPatternController pattern = loader.getController();
            String labelPattern = "Observer";
            String labelIntent = "Observer is a behavioral design pattern that lets you define a subscription mechanism to notify multiple objects about any events that happen to the object they’re observing.\n";
            String labelImplement = "1. Look over your business logic and try to break it down into two parts: the core functionality, independent from other code, will act as the publisher; the rest will turn into a set of subscriber classes.\n" +
                    "2. Declare the subscriber interface. At a bare minimum, it should declare a single update method.\n" +
                    "3. Declare the publisher interface and describe a pair of methods for adding a subscriber object to and removing it from the list. Remember that publishers must work with subscribers only via the subscriber interface.\n" +
                    "4. Decide where to put the actual subscription list and the implementation of subscription methods. Usually, this code looks the same for all types of publishers, so the obvious place to put it is in an abstract class derived directly from the publisher interface. Concrete publishers extend that class, inheriting the subscription behavior.\n" +
                    "5. Create concrete publisher classes. Each time something important happens inside a publisher, it must notify all its subscribers.\n" +
                    "6. Implement the update notification methods in concrete subscriber classes. Most subscribers would need some context data about the event. It can be passed as an argument of the notification method.\n" +
                    "7. The client must create all necessary subscribers and register them with proper publishers.\n";
            String labelProsNCons = "- Open/Closed Principle. You can introduce new subscriber classes without having to change the publisher’s code (and vice versa if there’s a publisher interface).\n" +
                    "- You can establish relations between objects at runtime.\n" +
                    "- Subscribers are notified in random order.\n";
            String textCodePython = getCodePythonByNameBehavioralPattern("Observer");
            String textCodeJava = getCodeJavaByNameBehavioralPattern("Observer");
            String textCodeCPP = getCodeCPPByNameBehavioralPattern("Observer");
            String textCodeCS = getCodeCSByNameBehavioralPattern("Observer");
            String pathToImgIntent = "/Images/BehavioralPatterns/Observer/intent.png";
            String pathToImgStructure = "/Images/BehavioralPatterns/Observer/structure.png";
            pattern.setData(labelPattern, labelIntent, labelImplement, labelProsNCons, textCodeJava, textCodePython, textCodeCPP, textCodeCS, pathToImgIntent, pathToImgStructure);
            MainContainer.getChildren().removeAll();
            MainContainer.getChildren().add(newContent3);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @FXML
    public void btnStateOnAction(ActionEvent event) {
        try{
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/UI/DesignPattern/DesignPattern.fxml"));
            Parent newContent3 = loader.load();
            DesignPatternController pattern = loader.getController();
            String labelPattern = "State";
            String labelIntent = "State is a behavioral design pattern that lets an object alter its behavior when its internal state changes. It appears as if the object changed its class.\n";
            String labelImplement = "1. Decide what class will act as the context. It could be an existing class which already has the state-dependent code; or a new class, if the state-specific code is distributed across multiple classes.\n" +
                    "2. Declare the state interface. Although it may mirror all the methods declared in the context, aim only for those that may contain state-specific behavior.\n" +
                    "3. For every actual state, create a class that derives from the state interface. Then go over the methods of the context and extract all code related to that state into your newly created class.\n" +
                    "   While moving the code to the state class, you might discover that it depends on private members of the context. There are several workarounds:\n" +
                    "   a. Make these fields or methods public.\n" +
                    "   b. Turn the behavior you’re extracting into a public method in the context and call it from the state class. This way is ugly but quick, and you can always fix it later.\n" +
                    "   c. Nest the state classes into the context class, but only if your programming language supports nesting classes.\n" +
                    "4. In the context class, add a reference field of the state interface type and a public setter that allows overriding the value of that field.\n" +
                    "5. Go over the method of the context again and replace empty state conditionals with calls to corresponding methods of the state object.\n" +
                    "6. To switch the state of the context, create an instance of one of the state classes and pass it to the context. You can do this within the context itself, or in various states, or in the client. Wherever this is done, the class becomes dependent on the concrete state class that it instantiates.\n";
            String labelProsNCons = "- Single Responsibility Principle. Organize the code related to particular states into separate classes.\n" +
                    "- Open/Closed Principle. Introduce new states without changing existing state classes or the context.\n" +
                    "- Simplify the code of the context by eliminating bulky state machine conditionals.\n" +
                    "- Applying the pattern can be overkill if a state machine has only a few states or rarely changes.\n";
            String textCodePython = getCodePythonByNameBehavioralPattern("State");
            String textCodeJava = getCodeJavaByNameBehavioralPattern("State");
            String textCodeCPP = getCodeCPPByNameBehavioralPattern("State");
            String textCodeCS = getCodeCSByNameBehavioralPattern("State");
            String pathToImgIntent = "/Images/BehavioralPatterns/State/intent.png";
            String pathToImgStructure = "/Images/BehavioralPatterns/State/structure.png";
            pattern.setData(labelPattern, labelIntent, labelImplement, labelProsNCons, textCodeJava, textCodePython, textCodeCPP, textCodeCS, pathToImgIntent, pathToImgStructure);
            MainContainer.getChildren().removeAll();
            MainContainer.getChildren().add(newContent3);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @FXML
    public void btnStrategyOnAction(ActionEvent event) {
        try{
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/UI/DesignPattern/DesignPattern.fxml"));
            Parent newContent3 = loader.load();
            DesignPatternController pattern = loader.getController();
            String labelPattern = "Strategy";
            String labelIntent = "Strategy is a behavioral design pattern that lets you define a family of algorithms, put each of them into a separate class, and make their objects interchangeable.\n";
            String labelImplement = "1. In the context class, identify an algorithm that’s prone to frequent changes. It may also be a massive conditional that selects and executes a variant of the same algorithm at runtime.\n" +
                    "2. Declare the strategy interface common to all variants of the algorithm.\n" +
                    "3. One by one, extract all algorithms into their own classes. They should all implement the strategy interface.\n" +
                    "4. In the context class, add a field for storing a reference to a strategy object. Provide a setter for replacing values of that field. The context should work with the strategy object only via the strategy interface. The context may define an interface which lets the strategy access its data.\n" +
                    "5. Clients of the context must associate it with a suitable strategy that matches the way they expect the context to perform its primary job.\n";
            String labelProsNCons = "- You can swap algorithms used inside an object at runtime.\n" +
                    "- You can isolate the implementation details of an algorithm from the code that uses it.\n" +
                    "- You can replace inheritance with composition.\n" +
                    "- Open/Closed Principle. You can introduce new strategies without having to change the context.\n" +
                    "- If you only have a couple of algorithms and they rarely change, there’s no real reason to overcomplicate the program with new classes and interfaces that come along with the pattern.\n" +
                    "- Clients must be aware of the differences between strategies to be able to select a proper one.\n" +
                    "- A lot of modern programming languages have functional type support that lets you implement different versions of an algorithm inside a set of anonymous functions. Then you could use these functions exactly as you’d have used the strategy objects, but without bloating your code with extra classes and interfaces.\n";
            String textCodePython = getCodePythonByNameBehavioralPattern("Strategy");
            String textCodeJava = getCodeJavaByNameBehavioralPattern("Strategy");
            String textCodeCPP = getCodeCPPByNameBehavioralPattern("Strategy");
            String textCodeCS = getCodeCSByNameBehavioralPattern("Strategy");
            String pathToImgIntent = "/Images/BehavioralPatterns/Strategy/intent.png";
            String pathToImgStructure = "/Images/BehavioralPatterns/Strategy/structure.png";
            pattern.setData(labelPattern, labelIntent, labelImplement, labelProsNCons, textCodeJava, textCodePython, textCodeCPP, textCodeCS, pathToImgIntent, pathToImgStructure);
            MainContainer.getChildren().removeAll();
            MainContainer.getChildren().add(newContent3);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @FXML
    public void btnTemplateMethodOnAction(ActionEvent event) {
        try{
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/UI/DesignPattern/DesignPattern.fxml"));
            Parent newContent3 = loader.load();
            DesignPatternController pattern = loader.getController();
            String labelPattern = "Template Method";
            String labelIntent = "Template Method is a behavioral design pattern that defines the skeleton of an algorithm in the superclass but lets subclasses override specific steps of the algorithm without changing its structure.\n";
            String labelImplement = "1. Analyze the target algorithm to see whether you can break it into steps. Consider which steps are common to all subclasses and which ones will always be unique.\n" +
                    "2. Create the abstract base class and declare the template method and a set of abstract methods representing the algorithm’s steps. Outline the algorithm’s structure in the template method by executing corresponding steps. Consider making the template method final to prevent subclasses from overriding it.\n" +
                    "3. It’s okay if all the steps end up being abstract. However, some steps might benefit from having a default implementation. Subclasses don’t have to implement those methods.\n" +
                    "4. Think of adding hooks between the crucial steps of the algorithm.\n" +
                    "5. For each variation of the algorithm, create a new concrete subclass. It must implement all of the abstract steps, but may also override some of the optional ones.";
            String labelProsNCons = "- You can let clients override only certain parts of a large algorithm, making them less affected by changes that happen to other parts of the algorithm.\n" +
                    "- You can pull the duplicate code into a superclass.\n" +
                    "- Some clients may be limited by the provided skeleton of an algorithm.\n" +
                    "- You might violate the Liskov Substitution Principle by suppressing a default step implementation via a subclass.\n" +
                    "- Template methods tend to be harder to maintain the more steps they have.\n";
            String textCodePython = getCodePythonByNameBehavioralPattern("Template Method");
            String textCodeJava = getCodeJavaByNameBehavioralPattern("Template Method");
            String textCodeCPP = getCodeCPPByNameBehavioralPattern("Template Method");
            String textCodeCS = getCodeCSByNameBehavioralPattern("Template Method");
            String pathToImgIntent = "/Images/BehavioralPatterns/TemplateMethod/intent.png";
            String pathToImgStructure = "/Images/BehavioralPatterns/TemplateMethod/structure.png";
            pattern.setData(labelPattern, labelIntent, labelImplement, labelProsNCons, textCodeJava, textCodePython, textCodeCPP, textCodeCS, pathToImgIntent, pathToImgStructure);
            MainContainer.getChildren().removeAll();
            MainContainer.getChildren().add(newContent3);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @FXML
    public void btnVisitorOnAction(ActionEvent event) {
        try{
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/UI/DesignPattern/DesignPattern.fxml"));
            Parent newContent3 = loader.load();
            DesignPatternController pattern = loader.getController();
            String labelPattern = "Visitor";
            String labelIntent = "Visitor is a behavioral design pattern that lets you separate algorithms from the objects on which they operate.\n";
            String labelImplement = "1. Declare the visitor interface with a set of “visiting” methods, one per each concrete element class that exists in the program.\n" +
                    "2. Declare the element interface. If you’re working with an existing element class hierarchy, add the abstract “acceptance” method to the base class of the hierarchy. This method should accept a visitor object as an argument.\n" +
                    "3. Implement the acceptance methods in all concrete element classes. These methods must simply redirect the call to a visiting method on the incoming visitor object which matches the class of the current element.\n" +
                    "4. The element classes should only work with visitors via the visitor interface. Visitors, however, must be aware of all concrete element classes, referenced as parameter types of the visiting methods.\n" +
                    "5. For each behavior that can’t be implemented inside the element hierarchy, create a new concrete visitor class and implement all of the visiting methods.\n" +
                    "6. The client must create visitor objects and pass them into elements via “acceptance” methods.\n";
            String labelProsNCons = "- Open/Closed Principle. You can introduce a new behavior that can work with objects of different classes without changing these classes.\n" +
                    "- Single Responsibility Principle. You can move multiple versions of the same behavior into the same class.\n" +
                    "- A visitor object can accumulate some useful information while working with various objects. This might be handy when you want to traverse some complex object structure, such as an object tree, and apply the visitor to each object of this structure.\n" +
                    "- You need to update all visitors each time a class gets added to or removed from the element hierarchy.\n" +
                    "- Visitors might lack the necessary access to the private fields and methods of the elements that they’re supposed to work with.\n";
            String textCodePython = getCodePythonByNameBehavioralPattern("Visitor");
            String textCodeJava = getCodeJavaByNameBehavioralPattern("Visitor");
            String textCodeCPP = getCodeCPPByNameBehavioralPattern("Visitor");
            String textCodeCS = getCodeCSByNameBehavioralPattern("Visitor");
            String pathToImgIntent = "/Images/BehavioralPatterns/Visitor/intent.png";
            String pathToImgStructure = "/Images/BehavioralPatterns/Visitor/structure.png";
            pattern.setData(labelPattern, labelIntent, labelImplement, labelProsNCons, textCodeJava, textCodePython, textCodeCPP, textCodeCS, pathToImgIntent, pathToImgStructure);
            MainContainer.getChildren().removeAll();
            MainContainer.getChildren().add(newContent3);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
