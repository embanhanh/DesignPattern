package com.example.demo.controller.ContentOfSection;

import com.example.demo.Content.DesignPattern;
import com.example.demo.controller.DesignPatternController;
import com.sun.tools.javac.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;

import static com.example.demo.CodeExample.CodeExampleCreationalPattern.*;

public class CreationalPattern implements Initializable {

    @FXML
    private AnchorPane MainContainer;

    @FXML
    private Button btnAbstractFactory;

    @FXML
    private Button btnBuilder;

    @FXML
    private Button btnFactoryMethod;

    @FXML
    private Button btnPrototype;

    @FXML
    private Button btnSingleton;

    private static final String[] BUTTON_STYLES = {
            "button1", "button2", "button3", "button4", "button5"
    };

    private int currentStyleIndex = 0;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        applyRandomStyles(btnFactoryMethod);
        applyRandomStyles(btnAbstractFactory);
        applyRandomStyles(btnBuilder);
        applyRandomStyles(btnPrototype);
        applyRandomStyles(btnSingleton);
    }

    private void applyRandomStyles(Button button) {
        button.getStyleClass().add(BUTTON_STYLES[currentStyleIndex]);
        currentStyleIndex = (currentStyleIndex + 1) % BUTTON_STYLES.length;
    }

    @FXML
    public void btnAbstractFactoryOnAction(ActionEvent event) {
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
            MainContainer.getChildren().removeAll();
            MainContainer.getChildren().add(newContent3);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @FXML
    public void btnFactoryMethodOnAction(ActionEvent event) {
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
            pattern.setData(labelPattern, labelIntent, labelImplement, labelProsNCons, textCodeJava, textCodePython, textCodeCPP, textCodeCS, "/Images/CreationalPatterns/FactoryMethod/intent.jpg", "/Images/CreationalPatterns/FactoryMethod/structure.png");
            MainContainer.getChildren().removeAll();
            MainContainer.getChildren().add(newContent3);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @FXML
    public void btnSingletonOnAction(ActionEvent event) {
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
            MainContainer.getChildren().removeAll();
            MainContainer.getChildren().add(newContent3);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @FXML
    public void btnBuilderOnAction(ActionEvent event) {
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
            MainContainer.getChildren().removeAll();
            MainContainer.getChildren().add(newContent3);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @FXML
    public void btnPrototypeOnAction(ActionEvent event) {
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
            MainContainer.getChildren().removeAll();
            MainContainer.getChildren().add(newContent3);
        }catch (Exception e){
            e.printStackTrace();
        }
    }


}
