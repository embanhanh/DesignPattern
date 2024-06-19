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
import java.util.ResourceBundle;

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

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

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
            pattern.setData(labelPattern, labelIntent, labelImplement, labelProsNCons, textCodeJava, textCodePython, textCodeCPP, textCodeCS, "/Images/CreationalPatterns/FactoryMethod/intent.png", "/Images/CreationalPatterns/FactoryMethod/structure.png");
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


    private String getCodeJavaByNameCreationalPattern(String pattern) {
        return switch (pattern) {
            case "Factory Method" -> "// Product interface\n" +
                    "interface Product {\n" +
                    "    void use();\n" +
                    "}\n" +
                    "\n" +
                    "// Concrete Products\n" +
                    "class ConcreteProductA implements Product {\n" +
                    "    public void use() {\n" +
                    "        System.out.println(\"Using Product A\");\n" +
                    "    }\n" +
                    "}\n" +
                    "\n" +
                    "class ConcreteProductB implements Product {\n" +
                    "    public void use() {\n" +
                    "        System.out.println(\"Using Product B\");\n" +
                    "    }\n" +
                    "}\n" +
                    "\n" +
                    "// Creator\n" +
                    "abstract class Creator {\n" +
                    "    public abstract Product factoryMethod();\n" +
                    "\n" +
                    "    public void anOperation() {\n" +
                    "        Product product = factoryMethod();\n" +
                    "        product.use();\n" +
                    "    }\n" +
                    "}\n" +
                    "\n" +
                    "// Concrete Creators\n" +
                    "class ConcreteCreatorA extends Creator {\n" +
                    "    public Product factoryMethod() {\n" +
                    "        return new ConcreteProductA();\n" +
                    "    }\n" +
                    "}\n" +
                    "\n" +
                    "class ConcreteCreatorB extends Creator {\n" +
                    "    public Product factoryMethod() {\n" +
                    "        return new ConcreteProductB();\n" +
                    "    }\n" +
                    "}\n" +
                    "\n" +
                    "public class FactoryMethodPattern {\n" +
                    "    public static void main(String[] args) {\n" +
                    "        Creator creatorA = new ConcreteCreatorA();\n" +
                    "        creatorA.anOperation();\n" +
                    "\n" +
                    "        Creator creatorB = new ConcreteCreatorB();\n" +
                    "        creatorB.anOperation();\n" +
                    "    }\n" +
                    "}\n";
            case "Singleton" -> "public class Singleton {\n" +
                    "    // Private static instance of the same class\n" +
                    "    private static Singleton instance;\n" +
                    "\n" +
                    "    // Private constructor to prevent instantiation\n" +
                    "    private Singleton() {}\n" +
                    "\n" +
                    "    // Public method to provide access to the instance\n" +
                    "    public static Singleton getInstance() {\n" +
                    "        if (instance == null) {\n" +
                    "            instance = new Singleton();\n" +
                    "        }\n" +
                    "        return instance;\n" +
                    "    }\n" +
                    "\n" +
                    "    // Example method\n" +
                    "    public void showMessage() {\n" +
                    "        System.out.println(\"Hello from Singleton!\");\n" +
                    "    }\n" +
                    "\n" +
                    "    public static void main(String[] args) {\n" +
                    "        Singleton singleton = Singleton.getInstance();\n" +
                    "        singleton.showMessage();\n" +
                    "    }\n" +
                    "}\n";
            case "Abstract Factory" -> "// Abstract product interfaces\n" +
                    "interface AbstractProductA {\n" +
                    "    void use();\n" +
                    "}\n" +
                    "\n" +
                    "interface AbstractProductB {\n" +
                    "    void eat();\n" +
                    "}\n" +
                    "\n" +
                    "// Concrete products\n" +
                    "class ProductA1 implements AbstractProductA {\n" +
                    "    public void use() {\n" +
                    "        System.out.println(\"Using Product A1\");\n" +
                    "    }\n" +
                    "}\n" +
                    "\n" +
                    "class ProductA2 implements AbstractProductA {\n" +
                    "    public void use() {\n" +
                    "        System.out.println(\"Using Product A2\");\n" +
                    "    }\n" +
                    "}\n" +
                    "\n" +
                    "class ProductB1 implements AbstractProductB {\n" +
                    "    public void eat() {\n" +
                    "        System.out.println(\"Eating Product B1\");\n" +
                    "    }\n" +
                    "}\n" +
                    "\n" +
                    "class ProductB2 implements AbstractProductB {\n" +
                    "    public void eat() {\n" +
                    "        System.out.println(\"Eating Product B2\");\n" +
                    "    }\n" +
                    "}\n" +
                    "\n" +
                    "// Abstract factory\n" +
                    "interface AbstractFactory {\n" +
                    "    AbstractProductA createProductA();\n" +
                    "    AbstractProductB createProductB();\n" +
                    "}\n" +
                    "\n" +
                    "// Concrete factories\n" +
                    "class ConcreteFactory1 implements AbstractFactory {\n" +
                    "    public AbstractProductA createProductA() {\n" +
                    "        return new ProductA1();\n" +
                    "    }\n" +
                    "\n" +
                    "    public AbstractProductB createProductB() {\n" +
                    "        return new ProductB1();\n" +
                    "    }\n" +
                    "}\n" +
                    "\n" +
                    "class ConcreteFactory2 implements AbstractFactory {\n" +
                    "    public AbstractProductA createProductA() {\n" +
                    "        return new ProductA2();\n" +
                    "    }\n" +
                    "\n" +
                    "    public AbstractProductB createProductB() {\n" +
                    "        return new ProductB2();\n" +
                    "    }\n" +
                    "}\n" +
                    "\n" +
                    "public class AbstractFactoryPattern {\n" +
                    "    public static void main(String[] args) {\n" +
                    "        AbstractFactory factory1 = new ConcreteFactory1();\n" +
                    "        AbstractProductA productA1 = factory1.createProductA();\n" +
                    "        AbstractProductB productB1 = factory1.createProductB();\n" +
                    "        productA1.use();\n" +
                    "        productB1.eat();\n" +
                    "\n" +
                    "        AbstractFactory factory2 = new ConcreteFactory2();\n" +
                    "        AbstractProductA productA2 = factory2.createProductA();\n" +
                    "        AbstractProductB productB2 = factory2.createProductB();\n" +
                    "        productA2.use();\n" +
                    "        productB2.eat();\n" +
                    "    }\n" +
                    "}\n";
            case "Prototype"  -> "// Prototype interface\n" +
                    "interface Prototype {\n" +
                    "    Prototype clone();\n" +
                    "}\n" +
                    "\n" +
                    "// Concrete prototype\n" +
                    "class ConcretePrototype implements Prototype {\n" +
                    "    private String field;\n" +
                    "\n" +
                    "    public ConcretePrototype(String field) {\n" +
                    "        this.field = field;\n" +
                    "    }\n" +
                    "\n" +
                    "    // Copy constructor for cloning\n" +
                    "    public ConcretePrototype(ConcretePrototype prototype) {\n" +
                    "        this.field = prototype.field;\n" +
                    "    }\n" +
                    "\n" +
                    "    public Prototype clone() {\n" +
                    "        return new ConcretePrototype(this);\n" +
                    "    }\n" +
                    "\n" +
                    "    @Override\n" +
                    "    public String toString() {\n" +
                    "        return \"ConcretePrototype [field=\" + field + \"]\";\n" +
                    "    }\n" +
                    "}\n" +
                    "\n" +
                    "public class PrototypePattern {\n" +
                    "    public static void main(String[] args) {\n" +
                    "        ConcretePrototype prototype1 = new ConcretePrototype(\"Prototype 1\");\n" +
                    "        ConcretePrototype clone1 = (ConcretePrototype) prototype1.clone();\n" +
                    "        System.out.println(prototype1);\n" +
                    "        System.out.println(clone1);\n" +
                    "\n" +
                    "        ConcretePrototype prototype2 = new ConcretePrototype(\"Prototype 2\");\n" +
                    "        ConcretePrototype clone2 = (ConcretePrototype) prototype2.clone();\n" +
                    "        System.out.println(prototype2);\n" +
                    "        System.out.println(clone2);\n" +
                    "    }\n" +
                    "}\n";
            case "Builder" -> "// Product class\n" +
                    "class Product {\n" +
                    "    private String partA;\n" +
                    "    private String partB;\n" +
                    "    private String partC;\n" +
                    "\n" +
                    "    public void setPartA(String partA) {\n" +
                    "        this.partA = partA;\n" +
                    "    }\n" +
                    "\n" +
                    "    public void setPartB(String partB) {\n" +
                    "        this.partB = partB;\n" +
                    "    }\n" +
                    "\n" +
                    "    public void setPartC(String partC) {\n" +
                    "        this.partC = partC;\n" +
                    "    }\n" +
                    "\n" +
                    "    @Override\n" +
                    "    public String toString() {\n" +
                    "        return \"Product [partA=\" + partA + \", partB=\" + partB + \", partC=\" + partC + \"]\";\n" +
                    "    }\n" +
                    "}\n" +
                    "\n" +
                    "// Builder interface\n" +
                    "interface Builder {\n" +
                    "    void buildPartA();\n" +
                    "    void buildPartB();\n" +
                    "    void buildPartC();\n" +
                    "    Product getResult();\n" +
                    "}\n" +
                    "\n" +
                    "// Concrete Builder\n" +
                    "class ConcreteBuilder implements Builder {\n" +
                    "    private Product product = new Product();\n" +
                    "\n" +
                    "    public void buildPartA() {\n" +
                    "        product.setPartA(\"Part A\");\n" +
                    "    }\n" +
                    "\n" +
                    "    public void buildPartB() {\n" +
                    "        product.setPartB(\"Part B\");\n" +
                    "    }\n" +
                    "\n" +
                    "    public void buildPartC() {\n" +
                    "        product.setPartC(\"Part C\");\n" +
                    "    }\n" +
                    "\n" +
                    "    public Product getResult() {\n" +
                    "        return product;\n" +
                    "    }\n" +
                    "}\n" +
                    "\n" +
                    "// Director\n" +
                    "class Director {\n" +
                    "    private Builder builder;\n" +
                    "\n" +
                    "    public Director(Builder builder) {\n" +
                    "        this.builder = builder;\n" +
                    "    }\n" +
                    "\n" +
                    "    public void construct() {\n" +
                    "        builder.buildPartA();\n" +
                    "        builder.buildPartB();\n" +
                    "        builder.buildPartC();\n" +
                    "    }\n" +
                    "}\n" +
                    "\n" +
                    "public class BuilderPattern {\n" +
                    "    public static void main(String[] args) {\n" +
                    "        Builder builder = new ConcreteBuilder();\n" +
                    "        Director director = new Director(builder);\n" +
                    "        director.construct();\n" +
                    "        Product product = builder.getResult();\n" +
                    "        System.out.println(product);\n" +
                    "    }\n" +
                    "}\n";
            // More cases...
            default -> "Error for load code";
        };
    }
    private String getCodePythonFromNameCreationalPattern(String pattern) {
        return switch (pattern) {
            case "Factory Method" -> "from abc import ABC, abstractmethod\n" +
                    "\n" +
                    "# Product interface\n" +
                    "class Product(ABC):\n" +
                    "    @abstractmethod\n" +
                    "    def use(self):\n" +
                    "        pass\n" +
                    "\n" +
                    "# Concrete Products\n" +
                    "class ConcreteProductA(Product):\n" +
                    "    def use(self):\n" +
                    "        print(\"Using Product A\")\n" +
                    "\n" +
                    "class ConcreteProductB(Product):\n" +
                    "    def use(self):\n" +
                    "        print(\"Using Product B\")\n" +
                    "\n" +
                    "# Creator\n" +
                    "class Creator(ABC):\n" +
                    "    @abstractmethod\n" +
                    "    def factory_method(self):\n" +
                    "        pass\n" +
                    "\n" +
                    "    def an_operation(self):\n" +
                    "        product = self.factory_method()\n" +
                    "        product.use()\n" +
                    "\n" +
                    "# Concrete Creators\n" +
                    "class ConcreteCreatorA(Creator):\n" +
                    "    def factory_method(self):\n" +
                    "        return ConcreteProductA()\n" +
                    "\n" +
                    "class ConcreteCreatorB(Creator):\n" +
                    "    def factory_method(self):\n" +
                    "        return ConcreteProductB()\n" +
                    "\n" +
                    "if __name__ == \"__main__\":\n" +
                    "    creator_a = ConcreteCreatorA()\n" +
                    "    creator_a.an_operation()\n" +
                    "\n" +
                    "    creator_b = ConcreteCreatorB()\n" +
                    "    creator_b.an_operation()\n";
            case "Singleton" -> "class Singleton:\n" +
                    "    _instance = None\n" +
                    "\n" +
                    "    def __new__(cls):\n" +
                    "        if cls._instance is None:\n" +
                    "            cls._instance = super(Singleton, cls).__new__(cls)\n" +
                    "        return cls._instance\n" +
                    "\n" +
                    "    def show_message(self):\n" +
                    "        print(\"Hello from Singleton!\")\n" +
                    "\n" +
                    "if __name__ == \"__main__\":\n" +
                    "    singleton = Singleton()\n" +
                    "    singleton.show_message()\n";
            case "Abstract Factory" -> "from abc import ABC, abstractmethod\n" +
                    "\n" +
                    "# Abstract product interfaces\n" +
                    "class AbstractProductA(ABC):\n" +
                    "    @abstractmethod\n" +
                    "    def use(self):\n" +
                    "        pass\n" +
                    "\n" +
                    "class AbstractProductB(ABC):\n" +
                    "    @abstractmethod\n" +
                    "    def eat(self):\n" +
                    "        pass\n" +
                    "\n" +
                    "# Concrete products\n" +
                    "class ProductA1(AbstractProductA):\n" +
                    "    def use(self):\n" +
                    "        print(\"Using Product A1\")\n" +
                    "\n" +
                    "class ProductA2(AbstractProductA):\n" +
                    "    def use(self):\n" +
                    "        print(\"Using Product A2\")\n" +
                    "\n" +
                    "class ProductB1(AbstractProductB):\n" +
                    "    def eat(self):\n" +
                    "        print(\"Eating Product B1\")\n" +
                    "\n" +
                    "class ProductB2(AbstractProductB):\n" +
                    "    def eat(self):\n" +
                    "        print(\"Eating Product B2\")\n" +
                    "\n" +
                    "# Abstract factory\n" +
                    "class AbstractFactory(ABC):\n" +
                    "    @abstractmethod\n" +
                    "    def create_product_a(self):\n" +
                    "        pass\n" +
                    "\n" +
                    "    @abstractmethod\n" +
                    "    def create_product_b(self):\n" +
                    "        pass\n" +
                    "\n" +
                    "# Concrete factories\n" +
                    "class ConcreteFactory1(AbstractFactory):\n" +
                    "    def create_product_a(self):\n" +
                    "        return ProductA1()\n" +
                    "\n" +
                    "    def create_product_b(self):\n" +
                    "        return ProductB1()\n" +
                    "\n" +
                    "class ConcreteFactory2(AbstractFactory):\n" +
                    "    def create_product_a(self):\n" +
                    "        return ProductA2()\n" +
                    "\n" +
                    "    def create_product_b(self):\n" +
                    "        return ProductB2()\n" +
                    "\n" +
                    "if __name__ == \"__main__\":\n" +
                    "    factory1 = ConcreteFactory1()\n" +
                    "    product_a1 = factory1.create_product_a()\n" +
                    "    product_b1 = factory1.create_product_b()\n" +
                    "    product_a1.use()\n" +
                    "    product_b1.eat()\n" +
                    "\n" +
                    "    factory2 = ConcreteFactory2()\n" +
                    "    product_a2 = factory2.create_product_a()\n" +
                    "    product_b2 = factory2.create_product_b()\n" +
                    "    product_a2.use()\n" +
                    "    product_b2.eat()\n";
            case "Prototype"  -> "import copy\n" +
                    "\n" +
                    "# Prototype interface\n" +
                    "class Prototype:\n" +
                    "    def clone(self):\n" +
                    "        pass\n" +
                    "\n" +
                    "# Concrete prototype\n" +
                    "class ConcretePrototype(Prototype):\n" +
                    "    def __init__(self, field):\n" +
                    "        self.field = field\n" +
                    "\n" +
                    "    def clone(self):\n" +
                    "        return copy.deepcopy(self)\n" +
                    "\n" +
                    "    def __str__(self):\n" +
                    "        return f\"ConcretePrototype [field={self.field}]\"\n" +
                    "\n" +
                    "if __name__ == \"__main__\":\n" +
                    "    prototype1 = ConcretePrototype(\"Prototype 1\")\n" +
                    "    clone1 = prototype1.clone()\n" +
                    "    print(prototype1)\n" +
                    "    print(clone1)\n" +
                    "\n" +
                    "    prototype2 = ConcretePrototype(\"Prototype 2\")\n" +
                    "    clone2 = prototype2.clone()\n" +
                    "    print(prototype2)\n" +
                    "    print(clone2)\n";
            case "Builder" -> "# Product class\n" +
                    "class Product:\n" +
                    "    def __init__(self):\n" +
                    "        self.parts = []\n" +
                    "\n" +
                    "    def add(self, part):\n" +
                    "        self.parts.append(part)\n" +
                    "\n" +
                    "    def __str__(self):\n" +
                    "        return \"Product parts: \" + \", \".join(self.parts)\n" +
                    "\n" +
                    "# Builder interface\n" +
                    "class Builder:\n" +
                    "    def build_part_a(self):\n" +
                    "        pass\n" +
                    "\n" +
                    "    def build_part_b(self):\n" +
                    "        pass\n" +
                    "\n" +
                    "    def build_part_c(self):\n" +
                    "        pass\n" +
                    "\n" +
                    "    def get_result(self):\n" +
                    "        pass\n" +
                    "\n" +
                    "# Concrete Builder\n" +
                    "class ConcreteBuilder(Builder):\n" +
                    "    def __init__(self):\n" +
                    "        self.product = Product()\n" +
                    "\n" +
                    "    def build_part_a(self):\n" +
                    "        self.product.add(\"Part A\")\n" +
                    "\n" +
                    "    def build_part_b(self):\n" +
                    "        self.product.add(\"Part B\")\n" +
                    "\n" +
                    "    def build_part_c(self):\n" +
                    "        self.product.add(\"Part C\")\n" +
                    "\n" +
                    "    def get_result(self):\n" +
                    "        return self.product\n" +
                    "\n" +
                    "# Director\n" +
                    "class Director:\n" +
                    "    def __init__(self, builder):\n" +
                    "        self.builder = builder\n" +
                    "\n" +
                    "    def construct(self):\n" +
                    "        self.builder.build_part_a()\n" +
                    "        self.builder.build_part_b()\n" +
                    "        self.builder.build_part_c()\n" +
                    "\n" +
                    "if __name__ == \"__main__\":\n" +
                    "    builder = ConcreteBuilder()\n" +
                    "    director = Director(builder)\n" +
                    "    director.construct()\n" +
                    "    product = builder.get_result()\n" +
                    "    print(product)\n";
            // More cases...
            default -> "Error for load code";
        };
    }

    private String getCodeCPPFromNameCreationalPattern(String pattern) {
        return switch (pattern) {
            case "Singleton" -> "#include <iostream>\n" +
                    "\n" +
                    "// Singleton class\n" +
                    "class Singleton {\n" +
                    "private:\n" +
                    "    // Private static instance of the class\n" +
                    "    static Singleton* instance;\n" +
                    "\n" +
                    "    // Private constructor to prevent instantiation\n" +
                    "    Singleton() {}\n" +
                    "\n" +
                    "public:\n" +
                    "    // Public static method to provide access to the instance\n" +
                    "    static Singleton* getInstance() {\n" +
                    "        if (instance == nullptr) {\n" +
                    "            instance = new Singleton();\n" +
                    "        }\n" +
                    "        return instance;\n" +
                    "    }\n" +
                    "\n" +
                    "    // Example method\n" +
                    "    void showMessage() {\n" +
                    "        std::cout << \"Hello from Singleton!\" << std::endl;\n" +
                    "    }\n" +
                    "};\n" +
                    "\n" +
                    "// Initialize the static member\n" +
                    "Singleton* Singleton::instance = nullptr;\n" +
                    "\n" +
                    "int main() {\n" +
                    "    // Access the singleton instance and call its method\n" +
                    "    Singleton* singleton = Singleton::getInstance();\n" +
                    "    singleton->showMessage();\n" +
                    "\n" +
                    "    return 0;\n" +
                    "}\n";
            case "Factory Method" -> "#include <iostream>\n" +
                    "#include <memory>\n" +
                    "\n" +
                    "// Product interface\n" +
                    "class Product {\n" +
                    "public:\n" +
                    "    virtual void use() = 0;\n" +
                    "    virtual ~Product() {}\n" +
                    "};\n" +
                    "\n" +
                    "// Concrete Products\n" +
                    "class ConcreteProductA : public Product {\n" +
                    "public:\n" +
                    "    void use() override {\n" +
                    "        std::cout << \"Using Product A\" << std::endl;\n" +
                    "    }\n" +
                    "};\n" +
                    "\n" +
                    "class ConcreteProductB : public Product {\n" +
                    "public:\n" +
                    "    void use() override {\n" +
                    "        std::cout << \"Using Product B\" << std::endl;\n" +
                    "    }\n" +
                    "};\n" +
                    "\n" +
                    "// Creator\n" +
                    "class Creator {\n" +
                    "public:\n" +
                    "    virtual std::unique_ptr<Product> factoryMethod() = 0;\n" +
                    "\n" +
                    "    void anOperation() {\n" +
                    "        std::unique_ptr<Product> product = factoryMethod();\n" +
                    "        product->use();\n" +
                    "    }\n" +
                    "\n" +
                    "    virtual ~Creator() {}\n" +
                    "};\n" +
                    "\n" +
                    "// Concrete Creators\n" +
                    "class ConcreteCreatorA : public Creator {\n" +
                    "public:\n" +
                    "    std::unique_ptr<Product> factoryMethod() override {\n" +
                    "        return std::make_unique<ConcreteProductA>();\n" +
                    "    }\n" +
                    "};\n" +
                    "\n" +
                    "class ConcreteCreatorB : public Creator {\n" +
                    "public:\n" +
                    "    std::unique_ptr<Product> factoryMethod() override {\n" +
                    "        return std::make_unique<ConcreteProductB>();\n" +
                    "    }\n" +
                    "};\n" +
                    "\n" +
                    "int main() {\n" +
                    "    std::unique_ptr<Creator> creatorA = std::make_unique<ConcreteCreatorA>();\n" +
                    "    creatorA->anOperation();\n" +
                    "\n" +
                    "    std::unique_ptr<Creator> creatorB = std::make_unique<ConcreteCreatorB>();\n" +
                    "    creatorB->anOperation();\n" +
                    "\n" +
                    "    return 0;\n" +
                    "}\n";
            case "Abstract Factory" -> "#include <iostream>\n" +
                    "#include <memory>\n" +
                    "\n" +
                    "// Abstract product interfaces\n" +
                    "class AbstractProductA {\n" +
                    "public:\n" +
                    "    virtual void use() = 0;\n" +
                    "    virtual ~AbstractProductA() {}\n" +
                    "};\n" +
                    "\n" +
                    "class AbstractProductB {\n" +
                    "public:\n" +
                    "    virtual void eat() = 0;\n" +
                    "    virtual ~AbstractProductB() {}\n" +
                    "};\n" +
                    "\n" +
                    "// Concrete products\n" +
                    "class ProductA1 : public AbstractProductA {\n" +
                    "public:\n" +
                    "    void use() override {\n" +
                    "        std::cout << \"Using Product A1\" << std::endl;\n" +
                    "    }\n" +
                    "};\n" +
                    "\n" +
                    "class ProductA2 : public AbstractProductA {\n" +
                    "public:\n" +
                    "    void use() override {\n" +
                    "        std::cout << \"Using Product A2\" << std::endl;\n" +
                    "    }\n" +
                    "};\n" +
                    "\n" +
                    "class ProductB1 : public AbstractProductB {\n" +
                    "public:\n" +
                    "    void eat() override {\n" +
                    "        std::cout << \"Eating Product B1\" << std::endl;\n" +
                    "    }\n" +
                    "};\n" +
                    "\n" +
                    "class ProductB2 : public AbstractProductB {\n" +
                    "public:\n" +
                    "    void eat() override {\n" +
                    "        std::cout << \"Eating Product B2\" << std::endl;\n" +
                    "    }\n" +
                    "};\n" +
                    "\n" +
                    "// Abstract factory\n" +
                    "class AbstractFactory {\n" +
                    "public:\n" +
                    "    virtual std::unique_ptr<AbstractProductA> createProductA() = 0;\n" +
                    "    virtual std::unique_ptr<AbstractProductB> createProductB() = 0;\n" +
                    "    virtual ~AbstractFactory() {}\n" +
                    "};\n" +
                    "\n" +
                    "// Concrete factories\n" +
                    "class ConcreteFactory1 : public AbstractFactory {\n" +
                    "public:\n" +
                    "    std::unique_ptr<AbstractProductA> createProductA() override {\n" +
                    "        return std::make_unique<ProductA1>();\n" +
                    "    }\n" +
                    "\n" +
                    "    std::unique_ptr<AbstractProductB> createProductB() override {\n" +
                    "        return std::make_unique<ProductB1>();\n" +
                    "    }\n" +
                    "};\n" +
                    "\n" +
                    "class ConcreteFactory2 : public AbstractFactory {\n" +
                    "public:\n" +
                    "    std::unique_ptr<AbstractProductA> createProductA() override {\n" +
                    "        return std::make_unique<ProductA2>();\n" +
                    "    }\n" +
                    "\n" +
                    "    std::unique_ptr<AbstractProductB> createProductB() override {\n" +
                    "        return std::make_unique<ProductB2>();\n" +
                    "    }\n" +
                    "};\n" +
                    "\n" +
                    "int main() {\n" +
                    "    std::unique_ptr<AbstractFactory> factory1 = std::make_unique<ConcreteFactory1>();\n" +
                    "    std::unique_ptr<AbstractProductA> productA1 = factory1->createProductA();\n" +
                    "    std::unique_ptr<AbstractProductB> productB1 = factory1->createProductB();\n" +
                    "    productA1->use();\n" +
                    "    productB1->eat();\n" +
                    "\n" +
                    "    std::unique_ptr<AbstractFactory> factory2 = std::make_unique<ConcreteFactory2>();\n" +
                    "    std::unique_ptr<AbstractProductA> productA2 = factory2->createProductA();\n" +
                    "    std::unique_ptr<AbstractProductB> productB2 = factory2->createProductB();\n" +
                    "    productA2->use();\n" +
                    "    productB2->eat();\n" +
                    "\n" +
                    "    return 0;\n" +
                    "}\n";
            case "Builder" -> "#include <iostream>\n" +
                    "#include <memory>\n" +
                    "#include <vector>\n" +
                    "#include <string>\n" +
                    "\n" +
                    "// Product class\n" +
                    "class Product {\n" +
                    "public:\n" +
                    "    void add(const std::string& part) {\n" +
                    "        parts.push_back(part);\n" +
                    "    }\n" +
                    "\n" +
                    "    void show() {\n" +
                    "        std::cout << \"Product parts: \";\n" +
                    "        for (const auto& part : parts) {\n" +
                    "            std::cout << part << \" \";\n" +
                    "        }\n" +
                    "        std::cout << std::endl;\n" +
                    "    }\n" +
                    "\n" +
                    "private:\n" +
                    "    std::vector<std::string> parts;\n" +
                    "};\n" +
                    "\n" +
                    "// Builder interface\n" +
                    "class Builder {\n" +
                    "public:\n" +
                    "    virtual void buildPartA() = 0;\n" +
                    "    virtual void buildPartB() = 0;\n" +
                    "    virtual void buildPartC() = 0;\n" +
                    "    virtual std::unique_ptr<Product> getResult() = 0;\n" +
                    "    virtual ~Builder() {}\n" +
                    "};\n" +
                    "\n" +
                    "// Concrete Builder\n" +
                    "class ConcreteBuilder : public Builder {\n" +
                    "public:\n" +
                    "    ConcreteBuilder() : product(std::make_unique<Product>()) {}\n" +
                    "\n" +
                    "    void buildPartA() override {\n" +
                    "        product->add(\"Part A\");\n" +
                    "    }\n" +
                    "\n" +
                    "    void buildPartB() override {\n" +
                    "        product->add(\"Part B\");\n" +
                    "    }\n" +
                    "\n" +
                    "    void buildPartC() override {\n" +
                    "        product->add(\"Part C\");\n" +
                    "    }\n" +
                    "\n" +
                    "    std::unique_ptr<Product> getResult() override {\n" +
                    "        return std::move(product);\n" +
                    "    }\n" +
                    "\n" +
                    "private:\n" +
                    "    std::unique_ptr<Product> product;\n" +
                    "};\n" +
                    "\n" +
                    "// Director\n" +
                    "class Director {\n" +
                    "public:\n" +
                    "    Director(Builder* builder) : builder(builder) {}\n" +
                    "\n" +
                    "    void construct() {\n" +
                    "        builder->buildPartA();\n" +
                    "        builder->buildPartB();\n" +
                    "        builder->buildPartC();\n" +
                    "    }\n" +
                    "\n" +
                    "private:\n" +
                    "    Builder* builder;\n" +
                    "};\n" +
                    "\n" +
                    "int main() {\n" +
                    "    ConcreteBuilder builder;\n" +
                    "    Director director(&builder);\n" +
                    "    director.construct();\n" +
                    "    std::unique_ptr<Product> product = builder.getResult();\n" +
                    "    product->show();\n" +
                    "\n" +
                    "    return 0;\n" +
                    "}\n";
            case "Prototype"  -> "#include <iostream>\n" +
                    "#include <memory>\n" +
                    "\n" +
                    "// Prototype interface\n" +
                    "class Prototype {\n" +
                    "public:\n" +
                    "    virtual std::unique_ptr<Prototype> clone() = 0;\n" +
                    "    virtual void show() = 0;\n" +
                    "    virtual ~Prototype() {}\n" +
                    "};\n" +
                    "\n" +
                    "// Concrete prototype\n" +
                    "class ConcretePrototype : public Prototype {\n" +
                    "public:\n" +
                    "    ConcretePrototype(const std::string& field) : field(field) {}\n" +
                    "\n" +
                    "    // Clone method to return a copy of the object\n" +
                    "    std::unique_ptr<Prototype> clone() override {\n" +
                    "        return std::make_unique<ConcretePrototype>(*this);\n" +
                    "    }\n" +
                    "\n" +
                    "    void show() override {\n" +
                    "        std::cout << \"ConcretePrototype [field=\" << field << \"]\" << std::endl;\n" +
                    "    }\n" +
                    "\n" +
                    "private:\n" +
                    "    std::string field;\n" +
                    "};\n" +
                    "\n" +
                    "int main() {\n" +
                    "    // Create an original object\n" +
                    "    std::unique_ptr<ConcretePrototype> prototype1 = std::make_unique<ConcretePrototype>(\"Prototype 1\");\n" +
                    "\n" +
                    "    // Clone the object\n" +
                    "    std::unique_ptr<Prototype> clone1 = prototype1->clone();\n" +
                    "\n" +
                    "    // Show the original and the clone\n" +
                    "    prototype1->show();\n" +
                    "    clone1->show();\n" +
                    "\n" +
                    "    // Create another original object\n" +
                    "    std::unique_ptr<ConcretePrototype> prototype2 = std::make_unique<ConcretePrototype>(\"Prototype 2\");\n" +
                    "\n" +
                    "    // Clone the object\n" +
                    "    std::unique_ptr<Prototype> clone2 = prototype2->clone();\n" +
                    "\n" +
                    "    // Show the original and the clone\n" +
                    "    prototype2->show();\n" +
                    "    clone2->show();\n" +
                    "\n" +
                    "    return 0;\n" +
                    "}\n";
            // More cases...
            default -> "Error for load code";
        };
    }
    private String getCodeCSFromNameCreationalPattern(String pattern) {
        return switch (pattern) {
            case "Singleton" -> "using System;\n" +
                    "\n" +
                    "public class Singleton\n" +
                    "{\n" +
                    "    // Private static instance of the class\n" +
                    "    private static Singleton instance;\n" +
                    "\n" +
                    "    // Private constructor to prevent instantiation\n" +
                    "    private Singleton() { }\n" +
                    "\n" +
                    "    // Public static method to provide access to the instance\n" +
                    "    public static Singleton Instance\n" +
                    "    {\n" +
                    "        get\n" +
                    "        {\n" +
                    "            if (instance == null)\n" +
                    "            {\n" +
                    "                instance = new Singleton();\n" +
                    "            }\n" +
                    "            return instance;\n" +
                    "        }\n" +
                    "    }\n" +
                    "\n" +
                    "    // Example method\n" +
                    "    public void ShowMessage()\n" +
                    "    {\n" +
                    "        Console.WriteLine(\"Hello from Singleton!\");\n" +
                    "    }\n" +
                    "\n" +
                    "    public static void Main(string[] args)\n" +
                    "    {\n" +
                    "        // Access the singleton instance and call its method\n" +
                    "        Singleton singleton = Singleton.Instance;\n" +
                    "        singleton.ShowMessage();\n" +
                    "    }\n" +
                    "}\n";
            case "Factory Method" -> "using System;\n" +
                    "\n" +
                    "// Product interface\n" +
                    "public interface IProduct\n" +
                    "{\n" +
                    "    void Use();\n" +
                    "}\n" +
                    "\n" +
                    "// Concrete Products\n" +
                    "public class ConcreteProductA : IProduct\n" +
                    "{\n" +
                    "    public void Use()\n" +
                    "    {\n" +
                    "        Console.WriteLine(\"Using Product A\");\n" +
                    "    }\n" +
                    "}\n" +
                    "\n" +
                    "public class ConcreteProductB : IProduct\n" +
                    "{\n" +
                    "    public void Use()\n" +
                    "    {\n" +
                    "        Console.WriteLine(\"Using Product B\");\n" +
                    "    }\n" +
                    "}\n" +
                    "\n" +
                    "// Creator\n" +
                    "public abstract class Creator\n" +
                    "{\n" +
                    "    // Factory method\n" +
                    "    public abstract IProduct FactoryMethod();\n" +
                    "\n" +
                    "    // An operation that uses the product\n" +
                    "    public void AnOperation()\n" +
                    "    {\n" +
                    "        IProduct product = FactoryMethod();\n" +
                    "        product.Use();\n" +
                    "    }\n" +
                    "}\n" +
                    "\n" +
                    "// Concrete Creators\n" +
                    "public class ConcreteCreatorA : Creator\n" +
                    "{\n" +
                    "    public override IProduct FactoryMethod()\n" +
                    "    {\n" +
                    "        return new ConcreteProductA();\n" +
                    "    }\n" +
                    "}\n" +
                    "\n" +
                    "public class ConcreteCreatorB : Creator\n" +
                    "{\n" +
                    "    public override IProduct FactoryMethod()\n" +
                    "    {\n" +
                    "        return new ConcreteProductB();\n" +
                    "    }\n" +
                    "}\n" +
                    "\n" +
                    "public class FactoryMethodPattern\n" +
                    "{\n" +
                    "    public static void Main(string[] args)\n" +
                    "    {\n" +
                    "        Creator creatorA = new ConcreteCreatorA();\n" +
                    "        creatorA.AnOperation();\n" +
                    "\n" +
                    "        Creator creatorB = new ConcreteCreatorB();\n" +
                    "        creatorB.AnOperation();\n" +
                    "    }\n" +
                    "}\n";
            case "Abstract Factory" -> "using System;\n" +
                    "\n" +
                    "// Abstract product interfaces\n" +
                    "public interface IAbstractProductA\n" +
                    "{\n" +
                    "    void Use();\n" +
                    "}\n" +
                    "\n" +
                    "public interface IAbstractProductB\n" +
                    "{\n" +
                    "    void Eat();\n" +
                    "}\n" +
                    "\n" +
                    "// Concrete products\n" +
                    "public class ProductA1 : IAbstractProductA\n" +
                    "{\n" +
                    "    public void Use()\n" +
                    "    {\n" +
                    "        Console.WriteLine(\"Using Product A1\");\n" +
                    "    }\n" +
                    "}\n" +
                    "\n" +
                    "public class ProductA2 : IAbstractProductA\n" +
                    "{\n" +
                    "    public void Use()\n" +
                    "    {\n" +
                    "        Console.WriteLine(\"Using Product A2\");\n" +
                    "    }\n" +
                    "}\n" +
                    "\n" +
                    "public class ProductB1 : IAbstractProductB\n" +
                    "{\n" +
                    "    public void Eat()\n" +
                    "    {\n" +
                    "        Console.WriteLine(\"Eating Product B1\");\n" +
                    "    }\n" +
                    "}\n" +
                    "\n" +
                    "public class ProductB2 : IAbstractProductB\n" +
                    "{\n" +
                    "    public void Eat()\n" +
                    "    {\n" +
                    "        Console.WriteLine(\"Eating Product B2\");\n" +
                    "    }\n" +
                    "}\n" +
                    "\n" +
                    "// Abstract factory\n" +
                    "public interface IAbstractFactory\n" +
                    "{\n" +
                    "    IAbstractProductA CreateProductA();\n" +
                    "    IAbstractProductB CreateProductB();\n" +
                    "}\n" +
                    "\n" +
                    "// Concrete factories\n" +
                    "public class ConcreteFactory1 : IAbstractFactory\n" +
                    "{\n" +
                    "    public IAbstractProductA CreateProductA()\n" +
                    "    {\n" +
                    "        return new ProductA1();\n" +
                    "    }\n" +
                    "\n" +
                    "    public IAbstractProductB CreateProductB()\n" +
                    "    {\n" +
                    "        return new ProductB1();\n" +
                    "    }\n" +
                    "}\n" +
                    "\n" +
                    "public class ConcreteFactory2 : IAbstractFactory\n" +
                    "{\n" +
                    "    public IAbstractProductA CreateProductA()\n" +
                    "    {\n" +
                    "        return new ProductA2();\n" +
                    "    }\n" +
                    "\n" +
                    "    public IAbstractProductB CreateProductB()\n" +
                    "    {\n" +
                    "        return new ProductB2();\n" +
                    "    }\n" +
                    "}\n" +
                    "\n" +
                    "public class AbstractFactoryPattern\n" +
                    "{\n" +
                    "    public static void Main(string[] args)\n" +
                    "    {\n" +
                    "        IAbstractFactory factory1 = new ConcreteFactory1();\n" +
                    "        IAbstractProductA productA1 = factory1.CreateProductA();\n" +
                    "        IAbstractProductB productB1 = factory1.CreateProductB();\n" +
                    "        productA1.Use();\n" +
                    "        productB1.Eat();\n" +
                    "\n" +
                    "        IAbstractFactory factory2 = new ConcreteFactory2();\n" +
                    "        IAbstractProductA productA2 = factory2.CreateProductA();\n" +
                    "        IAbstractProductB productB2 = factory2.CreateProductB();\n" +
                    "        productA2.Use();\n" +
                    "        productB2.Eat();\n" +
                    "    }\n" +
                    "}\n";
            case "Builder" -> "using System;\n" +
                    "using System.Collections.Generic;\n" +
                    "\n" +
                    "// Product class\n" +
                    "public class Product\n" +
                    "{\n" +
                    "    private List<string> parts = new List<string>();\n" +
                    "\n" +
                    "    public void Add(string part)\n" +
                    "    {\n" +
                    "        parts.Add(part);\n" +
                    "    }\n" +
                    "\n" +
                    "    public void Show()\n" +
                    "    {\n" +
                    "        Console.WriteLine(\"Product parts: \" + string.Join(\", \", parts));\n" +
                    "    }\n" +
                    "}\n" +
                    "\n" +
                    "// Builder interface\n" +
                    "public interface IBuilder\n" +
                    "{\n" +
                    "    void BuildPartA();\n" +
                    "    void BuildPartB();\n" +
                    "    void BuildPartC();\n" +
                    "    Product GetResult();\n" +
                    "}\n" +
                    "\n" +
                    "// Concrete Builder\n" +
                    "public class ConcreteBuilder : IBuilder\n" +
                    "{\n" +
                    "    private Product product = new Product();\n" +
                    "\n" +
                    "    public void BuildPartA()\n" +
                    "    {\n" +
                    "        product.Add(\"Part A\");\n" +
                    "    }\n" +
                    "\n" +
                    "    public void BuildPartB()\n" +
                    "    {\n" +
                    "        product.Add(\"Part B\");\n" +
                    "    }\n" +
                    "\n" +
                    "    public void BuildPartC()\n" +
                    "    {\n" +
                    "        product.Add(\"Part C\");\n" +
                    "    }\n" +
                    "\n" +
                    "    public Product GetResult()\n" +
                    "    {\n" +
                    "        return product;\n" +
                    "    }\n" +
                    "}\n" +
                    "\n" +
                    "// Director\n" +
                    "public class Director\n" +
                    "{\n" +
                    "    private IBuilder builder;\n" +
                    "\n" +
                    "    public Director(IBuilder builder)\n" +
                    "    {\n" +
                    "        this.builder = builder;\n" +
                    "    }\n" +
                    "\n" +
                    "    public void Construct()\n" +
                    "    {\n" +
                    "        builder.BuildPartA();\n" +
                    "        builder.BuildPartB();\n" +
                    "        builder.BuildPartC();\n" +
                    "    }\n" +
                    "}\n" +
                    "\n" +
                    "public class BuilderPattern\n" +
                    "{\n" +
                    "    public static void Main(string[] args)\n" +
                    "    {\n" +
                    "        IBuilder builder = new ConcreteBuilder();\n" +
                    "        Director director = new Director(builder);\n" +
                    "        director.Construct();\n" +
                    "        Product product = builder.GetResult();\n" +
                    "        product.Show();\n" +
                    "    }\n" +
                    "}\n";
            case "Prototype"  -> "using System;\n" +
                    "\n" +
                    "// Prototype interface\n" +
                    "public interface IPrototype\n" +
                    "{\n" +
                    "    IPrototype Clone();\n" +
                    "    void Show();\n" +
                    "}\n" +
                    "\n" +
                    "// Concrete prototype\n" +
                    "public class ConcretePrototype : IPrototype\n" +
                    "{\n" +
                    "    public string Field { get; set; }\n" +
                    "\n" +
                    "    public ConcretePrototype(string field)\n" +
                    "    {\n" +
                    "        Field = field;\n" +
                    "    }\n" +
                    "\n" +
                    "    // Clone method to return a copy of the object\n" +
                    "    public IPrototype Clone()\n" +
                    "    {\n" +
                    "        return new ConcretePrototype(this.Field);\n" +
                    "    }\n" +
                    "\n" +
                    "    public void Show()\n" +
                    "    {\n" +
                    "        Console.WriteLine($\"ConcretePrototype [Field={Field}]\");\n" +
                    "    }\n" +
                    "}\n" +
                    "\n" +
                    "public class PrototypePattern\n" +
                    "{\n" +
                    "    public static void Main(string[] args)\n" +
                    "    {\n" +
                    "        // Create an original object\n" +
                    "        ConcretePrototype prototype1 = new ConcretePrototype(\"Prototype 1\");\n" +
                    "\n" +
                    "        // Clone the object\n" +
                    "        IPrototype clone1 = prototype1.Clone();\n" +
                    "\n" +
                    "        // Show the original and the clone\n" +
                    "        prototype1.Show();\n" +
                    "        clone1.Show();\n" +
                    "\n" +
                    "        // Create another original object\n" +
                    "        ConcretePrototype prototype2 = new ConcretePrototype(\"Prototype 2\");\n" +
                    "\n" +
                    "        // Clone the object\n" +
                    "        IPrototype clone2 = prototype2.Clone();\n" +
                    "\n" +
                    "        // Show the original and the clone\n" +
                    "        prototype2.Show();\n" +
                    "        clone2.Show();\n" +
                    "    }\n" +
                    "}\n";
            // More cases...
            default -> "Error for load code";
        };
    }
}
