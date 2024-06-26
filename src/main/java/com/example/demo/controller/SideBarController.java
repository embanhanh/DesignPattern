package com.example.demo.controller;

import com.example.demo.controller.ContentOfSection.CreationalPattern;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TitledPane;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Circle;
import javafx.util.Duration;

import java.io.IOException;
import java.util.Objects;

import static com.example.demo.CodeExample.CodeExampleBehavioralPattern.*;
import static com.example.demo.CodeExample.CodeExampleBehavioralPattern.getCodeCSByNameBehavioralPattern;
import static com.example.demo.CodeExample.CodeExampleCreationalPattern.*;
import static com.example.demo.CodeExample.CodeExampleCreationalPattern.getCodeCSFromNameCreationalPattern;
import static com.example.demo.CodeExample.CodeExampleStructuralPattern.*;
import static com.example.demo.CodeExample.CodeExampleStructuralPattern.getCodeCSFromNameStructuralPattern;
import static com.example.demo.Handle.SearchHandle.searchPattern;

public class SideBarController {
    @FXML
    private HBox MainContainer;

    @FXML
    private AnchorPane tabBehavioral;

    @FXML
    private AnchorPane tabCreational;

    @FXML
    private AnchorPane tabHome;

    @FXML
    private AnchorPane tabStructural;

    private AnchorPane selectedBtn;

    @FXML
    private void initialize() {

        selectedBtn = tabHome;
        tabStructural.getStyleClass().add("default-pane");
        tabBehavioral.getStyleClass().add("default-pane");
        tabCreational.getStyleClass().add("default-pane");
        tabHome.getStyleClass().add("selected-pane");
        try {
            AnchorPane additionalView = FXMLLoader.load(getClass().getResource("/UI/Home.fxml"));
            MainContainer.getChildren().add(additionalView);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private void setVisible(AnchorPane... panes) {
        for (AnchorPane pane : panes) {
            pane.setVisible(false);
            pane.setManaged(false);
        }
    }

    public void handleButtonClick(MouseEvent event) {
        System.out.println("Clicked");
        AnchorPane clickedButton = (AnchorPane) event.getSource();
        selectedBtn.getStyleClass().removeAll("selected-pane");
        selectedBtn.getStyleClass().add("default-pane");

        selectedBtn = clickedButton;
        selectedBtn.getStyleClass().removeAll("default-pane");
        selectedBtn.getStyleClass().add("selected-pane");
    }

    public void handleButtonClick_Home(MouseEvent event) {
        System.out.println("Clicked Home");
        AnchorPane clickedButton = (AnchorPane) event.getSource();
        selectedBtn.getStyleClass().removeAll("selected-pane");
        selectedBtn.getStyleClass().add("default-pane");
        try {
//            AnchorPane additionalView = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/UI/ContentOfSection/StructuralPattern.fxml")));
//            MainContainer.getChildren().removeLast();
//            MainContainer.getChildren().add(additionalView);
            Parent newContent = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/UI/Home.fxml")));
            MainContainer.getChildren().removeLast();
            MainContainer.getChildren().add(newContent);
        } catch (IOException e) {
            e.printStackTrace();
        }
        selectedBtn = clickedButton;
        selectedBtn.getStyleClass().removeAll("default-pane");
        selectedBtn.getStyleClass().add("selected-pane");
    }

    public void handleButtonClick_CreationalPattern(MouseEvent event) {
        System.out.println("Clicked creational pattern");
        AnchorPane clickedButton = (AnchorPane) event.getSource();
        selectedBtn.getStyleClass().removeAll("selected-pane");
        selectedBtn.getStyleClass().add("default-pane");
        try {
//            AnchorPane additionalView = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/UI/ContentOfSection/CreationalPattern.fxml")));
//            MainContainer.getChildren().removeLast();
//            MainContainer.getChildren().add(additionalView);
            Parent newContent = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/UI/ContentOfSection/CreationalPattern.fxml")));
            MainContainer.getChildren().removeLast();
            MainContainer.getChildren().add(newContent);
        } catch (IOException e) {
            e.printStackTrace();
        }
        selectedBtn = clickedButton;
        selectedBtn.getStyleClass().removeAll("default-pane");
        selectedBtn.getStyleClass().add("selected-pane");
    }

    public void handleButtonClick_StructuralPattern(MouseEvent event) {
        System.out.println("Clicked structural pattern");
        AnchorPane clickedButton = (AnchorPane) event.getSource();
        selectedBtn.getStyleClass().removeAll("selected-pane");
        selectedBtn.getStyleClass().add("default-pane");
        try {
//            AnchorPane additionalView = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/UI/ContentOfSection/StructuralPattern.fxml")));
//            MainContainer.getChildren().removeLast();
//            MainContainer.getChildren().add(additionalView);
            Parent newContent = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/UI/ContentOfSection/StructuralPattern.fxml")));
            MainContainer.getChildren().removeLast();
            MainContainer.getChildren().add(newContent);
        } catch (IOException e) {
            e.printStackTrace();
        }
        selectedBtn = clickedButton;
        selectedBtn.getStyleClass().removeAll("default-pane");
        selectedBtn.getStyleClass().add("selected-pane");
    }

    public void handleButtonClick_BehavioralPattern(MouseEvent event) {
        System.out.println("Clicked behavioral pattern");
        AnchorPane clickedButton = (AnchorPane) event.getSource();
        selectedBtn.getStyleClass().removeAll("selected-pane");
        selectedBtn.getStyleClass().add("default-pane");
        try {
//            AnchorPane additionalView = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/UI/ContentOfSection/BehavioralPattern.fxml")));
//            MainContainer.getChildren().removeLast();
//            MainContainer.getChildren().add(additionalView);
            Parent newContent = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/UI/ContentOfSection/BehavioralPattern.fxml")));
            MainContainer.getChildren().removeLast();
            MainContainer.getChildren().add(newContent);
        } catch (IOException e) {
            e.printStackTrace();
        }
        selectedBtn = clickedButton;
        selectedBtn.getStyleClass().removeAll("default-pane");
        selectedBtn.getStyleClass().add("selected-pane");
    }

    public void handleSearch() {
        String pattern = searchPattern("while providing a global access point to");
        System.out.println("Pattern: " + pattern);
        switch (pattern) {
            case "Factory Method" -> btnFactoryMethodOnAction();
            case "Abstract Factory" -> btnAbstractFactoryOnAction();
            case "Builder" -> btnBuilderOnAction();
            case "Prototype" -> btnPrototypeOnAction();
            case "Singleton" -> btnSingletonOnAction();
            case "Adapter" -> btnAdapterOnAction();
            case "Bridge" -> btnBridgeOnAction();
            case "Composite" -> btnCompositeOnAction();
            case "Decorator" -> btnDecoratorOnAction();
            case "Facade" -> btnFacadeOnAction();
            case "Flyweight" -> btnFlyweightOnAction();
            case "Proxy" -> btnProxyOnAction();
            case "Chain of Responsibility" -> btnChainOfResponsibilityOnAction();
            case "Command" -> btnCommandOnAction();
            case "Iterator" -> btnIteratorOnAction();
            case "Mediator" -> btnMediatorOnAction();
            case "Memento" -> btnMementoOnAction();
            case "Observer" -> btnObserverOnAction();
            case "State" -> btnStateOnAction();
            case "Strategy" -> btnStrategyOnAction();
            case "Template" -> btnTemplateMethodOnAction();
            case "Visitor" -> btnVisitorOnAction();
        }
    }

    public void btnAbstractFactoryOnAction() {
        try{
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/UI/DesignPattern/DesignPattern.fxml"));
            Parent newContent3 = loader.load();
            DesignPatternController pattern = loader.getController();
            String labelPattern = "Abstract Factory";
            String labelIntent = "Abstract Factory is a creational design pattern that lets you produce families of related objects without specifying their concrete classes.\n";
            String labelImplement = "1. Map out a matrix of distinct product types versus variants of these products.\n" +
                    "2. Declare abstract product interfaces for all product types. Then make all concrete product classes implement these interfaces.\n" +
                    "3. Declare the abstract factory interface with a set of creation methods for all abstract products.\n" +
                    "4. Implement a set of concrete factory classes, one for each product variant.\n" +
                    "5. Create factory initialization code somewhere in the app. It should instantiate one of the concrete factory classes, depending on the application configuration or the current environment. Pass this factory object to all classes that construct products.\n" +
                    "6. Scan through the code and find all direct calls to product constructors. Replace them with calls to the appropriate creation method on the factory object.\n";
            String labelProsNCons = "You can be sure that the products you’re getting from a factory are compatible with each other.\n" +
                    "You avoid tight coupling between concrete products and client code.\n" +
                    "Single Responsibility Principle. You can extract the product creation code into one place, making the code easier to support.\n" +
                    "Open/Closed Principle. You can introduce new variants of products without breaking existing client code.\n" +
                    "The code may become more complicated than it should be, since a lot of new interfaces and classes are introduced along with the pattern.\n";
            String textCodePython = getCodePythonFromNameCreationalPattern("Abstract Factory");
            String textCodeJava = getCodeJavaByNameCreationalPattern("Abstract Factory");
            String textCodeCPP = getCodeCPPFromNameCreationalPattern("Abstract Factory");
            String textCodeCS = getCodeCSFromNameCreationalPattern("Abstract Factory");
            pattern.setData(labelPattern, labelIntent, labelImplement, labelProsNCons, textCodeJava, textCodePython, textCodeCPP, textCodeCS, "/Images/CreationalPatterns/AbstractFactory/intent.png", "/Images/CreationalPatterns/AbstractFactory/structure.png");
            MainContainer.getChildren().removeLast();
            MainContainer.getChildren().add(newContent3);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void btnFactoryMethodOnAction() {
        try{
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/UI/DesignPattern/DesignPattern.fxml"));
            Parent newContent3 = loader.load();
            DesignPatternController pattern = loader.getController();
            String labelPattern = "Factory Method";
            String labelIntent = "Factory Method is a creational design pattern that provides an interface for creating objects in a superclass, but allows subclasses to alter the type of objects that will be created.";
            String labelImplement = "1. Make all products follow the same interface. This interface should declare methods that make sense in every product.\n" +
                    "2. Add an empty factory method inside the creator class. The return type of the method should match the common product interface.\n" +
                    "3. In the creator’s code find all references to product constructors. One by one, replace them with calls to the factory method, while extracting the product creation code into the factory method.\n" +
                    "   You might need to add a temporary parameter to the factory method to control the type of returned product.\n" +
                    "   At this point, the code of the factory method may look pretty ugly. It may have a large switch statement that picks which product class to instantiate. But don’t worry, we’ll fix it soon enough.\n" +
                    "4. Now, create a set of creator subclasses for each type of product listed in the factory method. Override the factory method in the subclasses and extract the appropriate bits of construction code from the base method.\n" +
                    "5. If there are too many product types and it doesn’t make sense to create subclasses for all of them, you can reuse the control parameter from the base class in subclasses.\n" +
                    "For instance, imagine that you have the following hierarchy of classes: the base Mail class with a couple of subclasses: AirMail and GroundMail; the Transport classes are Plane, Truck and Train. While the AirMail class only uses Plane objects, GroundMail may work with both Truck and Train objects. You can create a new subclass (say TrainMail) to handle both cases, but there’s another option. The client code can pass an argument to the factory method of the GroundMail class to control which product it wants to receive.\n" +
                    "6. If, after all of the extractions, the base factory method has become empty, you can make it abstract. If there’s something left, you can make it a default behavior of the method.\n";
            String labelProsNCons = "- You avoid tight coupling between the creator and the concrete products.\n" +
                    "- Single Responsibility Principle. You can move the product creation code into one place in the program, making the code easier to support.\n" +
                    "- Open/Closed Principle. You can introduce new types of products into the program without breaking existing client code.\n" +
                    "- The code may become more complicated since you need to introduce a lot of new subclasses to implement the pattern. The best case scenario is when you’re introducing the pattern into an existing hierarchy of creator classes.\n";
            String textCodePython = getCodePythonFromNameCreationalPattern("Factory Method");
            String textCodeJava = getCodeJavaByNameCreationalPattern("Factory Method");
            String textCodeCPP = getCodeCPPFromNameCreationalPattern("Factory Method");
            String textCodeCS = getCodeCSFromNameCreationalPattern("Factory Method");
            pattern.setData(labelPattern, labelIntent, labelImplement, labelProsNCons, textCodeJava, textCodePython, textCodeCPP, textCodeCS, "/Images/CreationalPatterns/FactoryMethod/intent.png", "/Images/CreationalPatterns/FactoryMethod/structure.png");
            MainContainer.getChildren().removeLast();
            MainContainer.getChildren().add(newContent3);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void btnSingletonOnAction() {
        try{
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/UI/DesignPattern/DesignPattern.fxml"));
            Parent newContent3 = loader.load();
            DesignPatternController pattern = loader.getController();
            String labelPattern = "Singleton";
            String labelIntent = "Singleton is a creational design pattern that lets you ensure that a class has only one instance, while providing a global access point to this instance.";
            String labelImplement = "1. Add a private static field to the class for storing the singleton instance.\n" +
                    "2. Declare a public static creation method for getting the singleton instance.\n" +
                    "3. Implement “lazy initialization” inside the static method. It should create a new object on its first call and put it into the static field. The method should always return that instance on all subsequent calls.\n" +
                    "4. Make the constructor of the class private. The static method of the class will still be able to call the constructor, but not the other objects.\n" +
                    "5. Go over the client code and replace all direct calls to the singleton’s constructor with calls to its static creation method.\n";
            String labelProsNCons = "- You can be sure that a class has only a single instance.\n" +
                    "- You gain a global access point to that instance.\n" +
                    "- The singleton object is initialized only when it’s requested for the first time.\n" +
                    "- Violates the Single Responsibility Principle. The pattern solves two problems at the time.\n" +
                    "- The Singleton pattern can mask bad design, for instance, when the components of the program know too much about each other.\n" +
                    "- The pattern requires special treatment in a multithreaded environment so that multiple threads won’t create a singleton object several times.\n" +
                    "- It may be difficult to unit test the client code of the Singleton because many test frameworks rely on inheritance when producing mock objects. Since the constructor of the singleton class is private and overriding static methods is impossible in most languages, you will need to think of a creative way to mock the singleton. Or just don’t write the tests. Or don’t use the Singleton pattern.\n";
            String textCodePython = getCodePythonFromNameCreationalPattern("Singleton");
            String textCodeJava = getCodeJavaByNameCreationalPattern("Singleton");
            String textCodeCPP = getCodeCPPFromNameCreationalPattern("Singleton");
            String textCodeCS = getCodeCSFromNameCreationalPattern("Singleton");
            pattern.setData(labelPattern, labelIntent, labelImplement, labelProsNCons, textCodeJava, textCodePython, textCodeCPP, textCodeCS, "/Images/CreationalPatterns/Singleton/intent.png", "/Images/CreationalPatterns/Singleton/structure.png");
            MainContainer.getChildren().removeLast();
            MainContainer.getChildren().add(newContent3);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void btnBuilderOnAction() {
        try{
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/UI/DesignPattern/DesignPattern.fxml"));
            Parent newContent3 = loader.load();
            DesignPatternController pattern = loader.getController();
            String labelPattern = "Builder";
            String labelIntent = "Builder is a creational design pattern that lets you construct complex objects step by step. The pattern allows you to produce different types and representations of an object using the same construction code.\n";
            String labelImplement = "1. Define Base Builder Interface: Declare common construction steps for all product representations. Avoid declaring a method for fetching the result in the base interface if products don't share a common interface.\n" +
                    "2. Create Concrete Builder Classes: Implement the construction steps for each product representation. Implement a method to fetch the construction result specific to the concrete builder.\n" +
                    "3. Create Director Class: Encapsulate various ways to construct a product using the builder object. The director can accept the builder through the constructor or a specific method.\n" +
                    "4. Client Code:Create both the builder and the director objects. Pass the builder to the director and start the construction. Fetch the result from the builder.\n";
            String labelProsNCons = "- You can construct objects step-by-step, defer construction steps or run steps recursively.\n" +
                    "- You can reuse the same construction code when building various representations of products.\n" +
                    "- Single Responsibility Principle. You can isolate complex construction code from the business logic of the product.\n" +
                    "- The overall complexity of the code increases since the pattern requires creating multiple new classes.\n";
            String textCodePython = getCodePythonFromNameCreationalPattern("Builder");
            String textCodeJava = getCodeJavaByNameCreationalPattern("Builder");
            String textCodeCPP = getCodeCPPFromNameCreationalPattern("Builder");
            String textCodeCS = getCodeCSFromNameCreationalPattern("Builder");
            pattern.setData(labelPattern, labelIntent, labelImplement, labelProsNCons, textCodeJava, textCodePython, textCodeCPP, textCodeCS, "/Images/CreationalPatterns/Builder/intent.png", "/Images/CreationalPatterns/Builder/structure.png");
            MainContainer.getChildren().removeLast();
            MainContainer.getChildren().add(newContent3);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void btnPrototypeOnAction() {
        try{
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/UI/DesignPattern/DesignPattern.fxml"));
            Parent newContent3 = loader.load();
            DesignPatternController pattern = loader.getController();
            String labelPattern = "Prototype";
            String labelIntent = "Prototype is a creational design pattern that lets you copy existing objects without making your code dependent on their classes.";
            String labelImplement = "1. Create the prototype interface and declare the clone method in it. Or just add the method to all classes of an existing class hierarchy, if you have one.\n" +
                    "2. A prototype class must define the alternative constructor that accepts an object of that class as an argument. The constructor must copy the values of all fields defined in the class from the passed object into the newly created instance. If you’re changing a subclass, you must call the parent constructor to let the superclass handle the cloning of its private fields.\n" +
                    "3. The cloning method usually consists of just one line: running a new operator with the prototypical version of the constructor. Note, that every class must explicitly override the cloning method and use its own class name along with the new operator. Otherwise, the cloning method may produce an object of a parent class.\n" +
                    "4. Optionally, create a centralized prototype registry to store a catalog of frequently used prototypes.\n";
            String labelProsNCons = "- You can clone objects without coupling to their concrete classes.\n" +
                    "- You can get rid of repeated initialization code in favor of cloning pre-built prototypes.\n" +
                    "- You can produce complex objects more conveniently.\n" +
                    "- You get an alternative to inheritance when dealing with configuration presets for complex objects.\n" +
                    "- Cloning complex objects that have circular references might be very tricky.\n";
            String textCodePython = getCodePythonFromNameCreationalPattern("Prototype");
            String textCodeJava = getCodeJavaByNameCreationalPattern("Prototype");
            String textCodeCPP = getCodeCPPFromNameCreationalPattern("Prototype");
            String textCodeCS = getCodeCSFromNameCreationalPattern("Prototype");
            pattern.setData(labelPattern, labelIntent, labelImplement, labelProsNCons, textCodeJava, textCodePython, textCodeCPP, textCodeCS, "/Images/CreationalPatterns/Prototype/intent.png", "/Images/CreationalPatterns/Prototype/structure1.png");
            MainContainer.getChildren().removeLast();
            MainContainer.getChildren().add(newContent3);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void btnAdapterOnAction() {
        try{
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/UI/DesignPattern/DesignPattern.fxml"));
            Parent newContent3 = loader.load();
            DesignPatternController pattern = loader.getController();
            String labelPattern = "Adapter";
            String labelIntent = "Adapter is a structural design pattern that allows objects with incompatible interfaces to collaborate.\n";
            String labelImplement = "1. Make sure that you have at least two classes with incompatible interfaces:\n" +
                    "   a. A useful service class, which you can’t change (often 3rd-party, legacy or with lots of existing dependencies).\n" +
                    "   b. One or several client classes that would benefit from using the service class.\n" +
                    "2. Declare the client interface and describe how clients communicate with the service.\n" +
                    "3. Create the adapter class and make it follow the client interface. Leave all the methods empty for now.\n" +
                    "4. Add a field to the adapter class to store a reference to the service object. The common practice is to initialize this field via the constructor, but sometimes it’s more convenient to pass it to the adapter when calling its methods.\n" +
                    "5. One by one, implement all methods of the client interface in the adapter class. The adapter should delegate most of the real work to the service object, handling only the interface or data format conversion.\n" +
                    "6. Clients should use the adapter via the client interface. This will let you change or extend the adapters without affecting the client code.\n";
            String labelProsNCons = "- Single Responsibility Principle. You can separate the interface or data conversion code from the primary business logic of the program.\n" +
                    "- Open/Closed Principle. You can introduce new types of adapters into the program without breaking the existing client code, as long as they work with the adapters through the client interface.\n" +
                    "- The overall complexity of the code increases because you need to introduce a set of new interfaces and classes. Sometimes it’s simpler just to change the service class so that it matches the rest of your code.\n";
            String textCodePython = getCodePythonFromNameStructuralPattern("Adapter");
            String textCodeJava = getCodeJavaFromNameStructuralPattern("Adapter");
            String textCodeCPP = getCodeCPPFromNameStructuralPattern("Adapter");
            String textCodeCS = getCodeCSFromNameStructuralPattern("Adapter");
            String pathToImgIntent = "/Images/StructuralPatterns/Adapter/intent.png";
            String pathToImgStructure = "/Images/StructuralPatterns/Adapter/structure1.png";
            pattern.setData(labelPattern, labelIntent, labelImplement, labelProsNCons, textCodeJava, textCodePython, textCodeCPP, textCodeCS, pathToImgIntent, pathToImgStructure);
            MainContainer.getChildren().removeLast();
            MainContainer.getChildren().add(newContent3);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void btnBridgeOnAction() {
        try{
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/UI/DesignPattern/DesignPattern.fxml"));
            Parent newContent3 = loader.load();
            DesignPatternController pattern = loader.getController();
            String labelPattern = "Bridge";
            String labelIntent = "Bridge is a structural design pattern that lets you split a large class or a set of closely related classes into two separate hierarchies—abstraction and implementation—which can be developed independently of each other.";
            String labelImplement = "1. Identify the orthogonal dimensions in your classes. These independent concepts could be: abstraction/platform, domain/infrastructure, front-end/back-end, or interface/implementation.\n" +
                    "2. See what operations the client needs and define them in the base abstraction class.\n" +
                    "3. Determine the operations available on all platforms. Declare the ones that the abstraction needs in the general implementation interface.\n" +
                    "4. For all platforms in your domain create concrete implementation classes, but make sure they all follow the implementation interface.\n" +
                    "5. Inside the abstraction class, add a reference field for the implementation type. The abstraction delegates most of the work to the implementation object that’s referenced in that field.\n" +
                    "6. If you have several variants of high-level logic, create refined abstractions for each variant by extending the base abstraction class.\n" +
                    "7. The client code should pass an implementation object to the abstraction’s constructor to associate one with the other. After that, the client can forget about the implementation and work only with the abstraction object.\n";
            String labelProsNCons = "- You can create platform-independent classes and apps.\n" +
                    "- The client code works with high-level abstractions. It isn’t exposed to the platform details.\n" +
                    "- Open/Closed Principle. You can introduce new abstractions and implementations independently from each other.\n" +
                    "- Single Responsibility Principle. You can focus on high-level logic in the abstraction and on platform details in the implementation.\n" +
                    "- You might make the code more complicated by applying the pattern to a highly cohesive class.\n";
            String textCodePython = getCodePythonFromNameStructuralPattern("Bridge");
            String textCodeJava = getCodeJavaFromNameStructuralPattern("Bridge");
            String textCodeCPP = getCodeCPPFromNameStructuralPattern("Bridge");
            String textCodeCS = getCodeCSFromNameStructuralPattern("Bridge");
            String pathToImgIntent = "/Images/StructuralPatterns/Bridge/intent.png";
            String pathToImgStructure = "/Images/StructuralPatterns/Bridge/structure.png";
            pattern.setData(labelPattern, labelIntent, labelImplement, labelProsNCons, textCodeJava, textCodePython, textCodeCPP, textCodeCS, pathToImgIntent, pathToImgStructure);
            MainContainer.getChildren().removeLast();
            MainContainer.getChildren().add(newContent3);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void btnCompositeOnAction() {
        try{
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/UI/DesignPattern/DesignPattern.fxml"));
            Parent newContent3 = loader.load();
            DesignPatternController pattern = loader.getController();
            String labelPattern = "Composite";
            String labelIntent = "Composite is a structural design pattern that lets you compose objects into tree structures and then work with these structures as if they were individual objects.\n";
            String labelImplement = "1. Make sure that the core model of your app can be represented as a tree structure. Try to break it down into simple elements and containers. Remember that containers must be able to contain both simple elements and other containers.\n" +
                    "2. Declare the component interface with a list of methods that make sense for both simple and complex components.\n" +
                    "3. Create a leaf class to represent simple elements. A program may have multiple different leaf classes.\n" +
                    "4. Create a container class to represent complex elements. In this class, provide an array field for storing references to sub-elements. The array must be able to store both leaves and containers, so make sure it’s declared with the component interface type.\n" +
                    "5. Finally, define the methods for adding and removal of child elements in the container.\n";
            String labelProsNCons = "- You can work with complex tree structures more conveniently: use polymorphism and recursion to your advantage.\n" +
                    "- Open/Closed Principle. You can introduce new element types into the app without breaking the existing code, which now works with the object tree.\n" +
                    "- It might be difficult to provide a common interface for classes whose functionality differs too much. In certain scenarios, you’d need to overgeneralize the component interface, making it harder to comprehend.\n";
            String textCodePython = getCodePythonFromNameStructuralPattern("Composite");
            String textCodeJava = getCodeJavaFromNameStructuralPattern("Composite");
            String textCodeCPP = getCodeCPPFromNameStructuralPattern("Composite");
            String textCodeCS = getCodeCSFromNameStructuralPattern("Composite");
            String pathToImgIntent = "/Images/StructuralPatterns/Composite/intent.png";
            String pathToImgStructure = "/Images/StructuralPatterns/Composite/structure.png";
            pattern.setData(labelPattern, labelIntent, labelImplement, labelProsNCons, textCodeJava, textCodePython, textCodeCPP, textCodeCS, pathToImgIntent, pathToImgStructure);
            MainContainer.getChildren().removeLast();
            MainContainer.getChildren().add(newContent3);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void btnDecoratorOnAction() {
        try{
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/UI/DesignPattern/DesignPattern.fxml"));
            Parent newContent3 = loader.load();
            DesignPatternController pattern = loader.getController();
            String labelPattern = "Decorator";
            String labelIntent = "Decorator is a structural design pattern that lets you attach new behaviors to objects by placing these objects inside special wrapper objects that contain the behaviors.\n";
            String labelImplement = "1. Make sure your business domain can be represented as a primary component with multiple optional layers over it.\n" +
                    "2. Figure out what methods are common to both the primary component and the optional layers. Create a component interface and declare those methods there.\n" +
                    "3. Create a concrete component class and define the base behavior in it.\n" +
                    "4. Create a base decorator class. It should have a field for storing a reference to a wrapped object. The field should be declared with the component interface type to allow linking to concrete components as well as decorators. The base decorator must delegate all work to the wrapped object.\n" +
                    "5. Make sure all classes implement the component interface.\n" +
                    "6. Create concrete decorators by extending them from the base decorator. A concrete decorator must execute its behavior before or after the call to the parent method (which always delegates to the wrapped object).\n" +
                    "7. The client code must be responsible for creating decorators and composing them in the way the client needs.\n";
            String labelProsNCons = "- You can extend an object’s behavior without making a new subclass.\n" +
                    "- You can add or remove responsibilities from an object at runtime.\n" +
                    "- You can combine several behaviors by wrapping an object into multiple decorators.\n" +
                    "- Single Responsibility Principle. You can divide a monolithic class that implements many possible variants of behavior into several smaller classes.\n" +
                    "- It’s hard to remove a specific wrapper from the wrappers stack.\n" +
                    "- It’s hard to implement a decorator in such a way that its behavior doesn’t depend on the order in the decorators stack.\n" +
                    "- The initial configuration code of layers might look pretty ugly.\n";
            String textCodePython = getCodePythonFromNameStructuralPattern("Decorator");
            String textCodeJava = getCodeJavaFromNameStructuralPattern("Decorator");
            String textCodeCPP = getCodeCPPFromNameStructuralPattern("Decorator");
            String textCodeCS = getCodeCSFromNameStructuralPattern("Decorator");
            String pathToImgIntent = "/Images/StructuralPatterns/Decorator/intent.png";
            String pathToImgStructure = "/Images/StructuralPatterns/Decorator/structure.png";
            pattern.setData(labelPattern, labelIntent, labelImplement, labelProsNCons, textCodeJava, textCodePython, textCodeCPP, textCodeCS, pathToImgIntent, pathToImgStructure);
            MainContainer.getChildren().removeLast();
            MainContainer.getChildren().add(newContent3);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void btnFacadeOnAction() {
        try{
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/UI/DesignPattern/DesignPattern.fxml"));
            Parent newContent3 = loader.load();
            DesignPatternController pattern = loader.getController();
            String labelPattern = "Facade";
            String labelIntent = "Facade is a structural design pattern that provides a simplified interface to a library, a framework, or any other complex set of classes.\n";
            String labelImplement = "1. Check whether it’s possible to provide a simpler interface than what an existing subsystem already provides. You’re on the right track if this interface makes the client code independent from many of the subsystem’s classes.\n" +
                    "2. Declare and implement this interface in a new facade class. The facade should redirect the calls from the client code to appropriate objects of the subsystem. The facade should be responsible for initializing the subsystem and managing its further life cycle unless the client code already does this.\n" +
                    "3. To get the full benefit from the pattern, make all the client code communicate with the subsystem only via the facade. Now the client code is protected from any changes in the subsystem code. For example, when a subsystem gets upgraded to a new version, you will only need to modify the code in the facade.\n" +
                    "4. If the facade becomes too big, consider extracting part of its behavior to a new, refined facade class.";
            String labelProsNCons = "- You can isolate your code from the complexity of a subsystem.\n" +
                    "- A facade can become a god object coupled to all classes of an app.";
            String textCodePython = getCodePythonFromNameStructuralPattern("Facade");
            String textCodeJava = getCodeJavaFromNameStructuralPattern("Facade");
            String textCodeCPP = getCodeCPPFromNameStructuralPattern("Facade");
            String textCodeCS = getCodeCSFromNameStructuralPattern("Facade");
            String pathToImgIntent = "/Images/StructuralPatterns/Facade/intent.png";
            String pathToImgStructure = "/Images/StructuralPatterns/Facade/structure.png";
            pattern.setData(labelPattern, labelIntent, labelImplement, labelProsNCons, textCodeJava, textCodePython, textCodeCPP, textCodeCS, pathToImgIntent, pathToImgStructure);
            MainContainer.getChildren().removeLast();
            MainContainer.getChildren().add(newContent3);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void btnFlyweightOnAction() {
        try{
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/UI/DesignPattern/DesignPattern.fxml"));
            Parent newContent3 = loader.load();
            DesignPatternController pattern = loader.getController();
            String labelPattern = "Flyweight";
            String labelIntent = "Flyweight is a structural design pattern that lets you fit more objects into the available amount of RAM by sharing common parts of state between multiple objects instead of keeping all of the data in each object.\n";
            String labelImplement = "1. Divide fields of a class that will become a flyweight into two parts:\n" +
                    "   a. the intrinsic state: the fields that contain unchanging data duplicated across many objects\n" +
                    "   b. the extrinsic state: the fields that contain contextual data unique to each object\n" +
                    "2. Leave the fields that represent the intrinsic state in the class, but make sure they’re immutable. They should take their initial values only inside the constructor.\n" +
                    "3. Go over methods that use fields of the extrinsic state. For each field used in the method, introduce a new parameter and use it instead of the field.\n" +
                    "4. Optionally, create a factory class to manage the pool of flyweights. It should check for an existing flyweight before creating a new one. Once the factory is in place, clients must only request flyweights through it. They should describe the desired flyweight by passing its intrinsic state to the factory.\n" +
                    "5. The client must store or calculate values of the extrinsic state (context) to be able to call methods of flyweight objects. For the sake of convenience, the extrinsic state along with the flyweight-referencing field may be moved to a separate context class.\n";
            String labelProsNCons = "- You can save lots of RAM, assuming your program has tons of similar objects.\n" +
                    "- You might be trading RAM over CPU cycles when some of the context data needs to be recalculated each time somebody calls a flyweight method.\n" +
                    "- The code becomes much more complicated. New team members will always be wondering why the state of an entity was separated in such a way.\n";
            String textCodePython = getCodePythonFromNameStructuralPattern("Flyweight");
            String textCodeJava = getCodeJavaFromNameStructuralPattern("Flyweight");
            String textCodeCPP = getCodeCPPFromNameStructuralPattern("Flyweight");
            String textCodeCS = getCodeCSFromNameStructuralPattern("Flyweight");
            String pathToImgIntent = "/Images/StructuralPatterns/Flyweight/intent.png";
            String pathToImgStructure = "/Images/StructuralPatterns/Flyweight/structure.png";
            pattern.setData(labelPattern, labelIntent, labelImplement, labelProsNCons, textCodeJava, textCodePython, textCodeCPP, textCodeCS, pathToImgIntent, pathToImgStructure);
            MainContainer.getChildren().removeLast();
            MainContainer.getChildren().add(newContent3);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void btnProxyOnAction() {
        try{
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/UI/DesignPattern/DesignPattern.fxml"));
            Parent newContent3 = loader.load();
            DesignPatternController pattern = loader.getController();
            String labelPattern = "Proxy";
            String labelIntent = "Proxy is a structural design pattern that lets you provide a substitute or placeholder for another object. A proxy controls access to the original object, allowing you to perform something either before or after the request gets through to the original object.\n";
            String labelImplement = "1. If there’s no pre-existing service interface, create one to make proxy and service objects interchangeable. Extracting the interface from the service class isn’t always possible, because you’d need to change all of the service’s clients to use that interface. Plan B is to make the proxy a subclass of the service class, and this way it’ll inherit the interface of the service.\n" +
                    "2. Create the proxy class. It should have a field for storing a reference to the service. Usually, proxies create and manage the whole life cycle of their services. On rare occasions, a service is passed to the proxy via a constructor by the client.\n" +
                    "3. Implement the proxy methods according to their purposes. In most cases, after doing some work, the proxy should delegate the work to the service object.\n" +
                    "4. Consider introducing a creation method that decides whether the client gets a proxy or a real service. This can be a simple static method in the proxy class or a full-blown factory method.\n" +
                    "5. Consider implementing lazy initialization for the service object.\n";
            String labelProsNCons = "- You can control the service object without clients knowing about it.\n" +
                    "- You can manage the lifecycle of the service object when clients don’t care about it.\n" +
                    "- The proxy works even if the service object isn’t ready or is not available.\n" +
                    "- Open/Closed Principle. You can introduce new proxies without changing the service or clients.\n" +
                    "- The code may become more complicated since you need to introduce a lot of new classes.\n" +
                    "- The response from the service might get delayed.\n";
            String textCodePython = getCodePythonFromNameStructuralPattern("Proxy");
            String textCodeJava = getCodeJavaFromNameStructuralPattern("Proxy");
            String textCodeCPP = getCodeCPPFromNameStructuralPattern("Proxy");
            String textCodeCS = getCodeCSFromNameStructuralPattern("Proxy");
            String pathToImgIntent = "/Images/StructuralPatterns/Proxy/intent.png";
            String pathToImgStructure = "/Images/StructuralPatterns/Proxy/structure.png";
            pattern.setData(labelPattern, labelIntent, labelImplement, labelProsNCons, textCodeJava, textCodePython, textCodeCPP, textCodeCS, pathToImgIntent, pathToImgStructure);
            MainContainer.getChildren().removeLast();
            MainContainer.getChildren().add(newContent3);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void btnChainOfResponsibilityOnAction() {
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
            MainContainer.getChildren().removeLast();
            MainContainer.getChildren().add(newContent3);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void btnCommandOnAction() {
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
            MainContainer.getChildren().removeLast();
            MainContainer.getChildren().add(newContent3);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void btnIteratorOnAction() {
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
            MainContainer.getChildren().removeLast();
            MainContainer.getChildren().add(newContent3);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void btnMediatorOnAction() {
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
            MainContainer.getChildren().removeLast();
            MainContainer.getChildren().add(newContent3);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void btnMementoOnAction() {
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
            MainContainer.getChildren().removeLast();
            MainContainer.getChildren().add(newContent3);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void btnObserverOnAction() {
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
            MainContainer.getChildren().removeLast();
            MainContainer.getChildren().add(newContent3);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void btnStateOnAction() {
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
            MainContainer.getChildren().removeLast();
            MainContainer.getChildren().add(newContent3);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void btnStrategyOnAction() {
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
            MainContainer.getChildren().removeLast();
            MainContainer.getChildren().add(newContent3);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void btnTemplateMethodOnAction() {
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
            MainContainer.getChildren().removeLast();
            MainContainer.getChildren().add(newContent3);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void btnVisitorOnAction() {
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
            MainContainer.getChildren().removeLast();
            MainContainer.getChildren().add(newContent3);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
