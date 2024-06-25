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

import static com.example.demo.CodeExample.CodeExampleStructuralPattern.*;

public class StructuralPattern implements Initializable {
    @FXML
    private AnchorPane MainContainer;

    @FXML
    private Button btnAdapter;

    @FXML
    private Button btnBidge;

    @FXML
    private Button btnComposite;

    @FXML
    private Button btnDecorator;

    @FXML
    private Button btnFacade;

    @FXML
    private Button btnFlyweight;

    @FXML
    private Button btnProxy;

    private static final String[] BUTTON_STYLES = {
            "button1", "button2", "button3", "button4", "button5"
    };

    private int currentStyleIndex = 0;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        applyRandomStyles(btnAdapter);
        applyRandomStyles(btnBidge);
        applyRandomStyles(btnComposite);
        applyRandomStyles(btnDecorator);
        applyRandomStyles(btnFacade);
        applyRandomStyles(btnFlyweight);
        applyRandomStyles(btnProxy);
    }

    private void applyRandomStyles(Button button) {
        button.getStyleClass().add(BUTTON_STYLES[currentStyleIndex]);
        currentStyleIndex = (currentStyleIndex + 1) % BUTTON_STYLES.length;
    }

    @FXML
    public void btnAdapterOnAction(ActionEvent event) {
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
            String textCodePython = getCodeJavaFromNameStructuralPattern("Adapter");
            String textCodeJava = getCodePythonFromNameStructuralPattern("Adapter");
            String textCodeCPP = getCodeCPPFromNameStructuralPattern("Adapter");
            String textCodeCS = getCodeCSFromNameStructuralPattern("Adapter");
            String pathToImgIntent = "/Images/StructuralPatterns/Adapter/intent.png";
            String pathToImgStructure = "/Images/StructuralPatterns/Adapter/structure1.png";
            pattern.setData(labelPattern, labelIntent, labelImplement, labelProsNCons, textCodeJava, textCodePython, textCodeCPP, textCodeCS, pathToImgIntent, pathToImgStructure);
            MainContainer.getChildren().removeAll();
            MainContainer.getChildren().add(newContent3);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @FXML
    public void btnBridgeOnAction(ActionEvent event) {
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
            String textCodePython = getCodeJavaFromNameStructuralPattern("Bridge");
            String textCodeJava = getCodePythonFromNameStructuralPattern("Bridge");
            String textCodeCPP = getCodeCPPFromNameStructuralPattern("Bridge");
            String textCodeCS = getCodeCSFromNameStructuralPattern("Bridge");
            String pathToImgIntent = "/Images/StructuralPatterns/Bridge/intent.png";
            String pathToImgStructure = "/Images/StructuralPatterns/Bridge/structure.png";
            pattern.setData(labelPattern, labelIntent, labelImplement, labelProsNCons, textCodeJava, textCodePython, textCodeCPP, textCodeCS, pathToImgIntent, pathToImgStructure);
            MainContainer.getChildren().removeAll();
            MainContainer.getChildren().add(newContent3);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @FXML
    public void btnCompositeOnAction(ActionEvent event) {
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
            String textCodePython = getCodeJavaFromNameStructuralPattern("Composite");
            String textCodeJava = getCodePythonFromNameStructuralPattern("Composite");
            String textCodeCPP = getCodeCPPFromNameStructuralPattern("Composite");
            String textCodeCS = getCodeCSFromNameStructuralPattern("Composite");
            String pathToImgIntent = "/Images/StructuralPatterns/Composite/intent.png";
            String pathToImgStructure = "/Images/StructuralPatterns/Composite/structure.png";
            pattern.setData(labelPattern, labelIntent, labelImplement, labelProsNCons, textCodeJava, textCodePython, textCodeCPP, textCodeCS, pathToImgIntent, pathToImgStructure);
            MainContainer.getChildren().removeAll();
            MainContainer.getChildren().add(newContent3);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @FXML
    public void btnDecoratorOnAction(ActionEvent event) {
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
            String textCodePython = getCodeJavaFromNameStructuralPattern("Decorator");
            String textCodeJava = getCodePythonFromNameStructuralPattern("Decorator");
            String textCodeCPP = getCodeCPPFromNameStructuralPattern("Decorator");
            String textCodeCS = getCodeCSFromNameStructuralPattern("Decorator");
            String pathToImgIntent = "/Images/StructuralPatterns/Decorator/intent.png";
            String pathToImgStructure = "/Images/StructuralPatterns/Decorator/structure.png";
            pattern.setData(labelPattern, labelIntent, labelImplement, labelProsNCons, textCodeJava, textCodePython, textCodeCPP, textCodeCS, pathToImgIntent, pathToImgStructure);
            MainContainer.getChildren().removeAll();
            MainContainer.getChildren().add(newContent3);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @FXML
    public void btnFacadeOnAction(ActionEvent event) {
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
            String textCodePython = getCodeJavaFromNameStructuralPattern("Facade");
            String textCodeJava = getCodePythonFromNameStructuralPattern("Facade");
            String textCodeCPP = getCodeCPPFromNameStructuralPattern("Facade");
            String textCodeCS = getCodeCSFromNameStructuralPattern("Facade");
            String pathToImgIntent = "/Images/StructuralPatterns/Facade/intent.png";
            String pathToImgStructure = "/Images/StructuralPatterns/Facade/structure.png";
            pattern.setData(labelPattern, labelIntent, labelImplement, labelProsNCons, textCodeJava, textCodePython, textCodeCPP, textCodeCS, pathToImgIntent, pathToImgStructure);
            MainContainer.getChildren().removeAll();
            MainContainer.getChildren().add(newContent3);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @FXML
    public void btnFlyweightOnAction(ActionEvent event) {
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
            String textCodePython = getCodeJavaFromNameStructuralPattern("Flyweight");
            String textCodeJava = getCodePythonFromNameStructuralPattern("Flyweight");
            String textCodeCPP = getCodeCPPFromNameStructuralPattern("Flyweight");
            String textCodeCS = getCodeCSFromNameStructuralPattern("Flyweight");
            String pathToImgIntent = "/Images/StructuralPatterns/Flyweight/intent.png";
            String pathToImgStructure = "/Images/StructuralPatterns/Flyweight/structure.png";
            pattern.setData(labelPattern, labelIntent, labelImplement, labelProsNCons, textCodeJava, textCodePython, textCodeCPP, textCodeCS, pathToImgIntent, pathToImgStructure);
            MainContainer.getChildren().removeAll();
            MainContainer.getChildren().add(newContent3);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @FXML
    public void btnProxyOnAction(ActionEvent event) {
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
            String textCodePython = getCodeJavaFromNameStructuralPattern("Proxy");
            String textCodeJava = getCodePythonFromNameStructuralPattern("Proxy");
            String textCodeCPP = getCodeCPPFromNameStructuralPattern("Proxy");
            String textCodeCS = getCodeCSFromNameStructuralPattern("Proxy");
            String pathToImgIntent = "/Images/StructuralPatterns/Proxy/intent.png";
            String pathToImgStructure = "/Images/StructuralPatterns/Proxy/structure.png";
            pattern.setData(labelPattern, labelIntent, labelImplement, labelProsNCons, textCodeJava, textCodePython, textCodeCPP, textCodeCS, pathToImgIntent, pathToImgStructure);
            MainContainer.getChildren().removeAll();
            MainContainer.getChildren().add(newContent3);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
