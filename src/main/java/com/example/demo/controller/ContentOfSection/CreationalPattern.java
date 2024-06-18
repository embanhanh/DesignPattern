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
            String textCodePython = "from __future__ import annotations\n" +
                    "from abc import ABC, abstractmethod\n" +
                    "\n" +
                    "\n" +
                    "class Creator(ABC):\n" +
                    "    \"\"\"\n" +
                    "    The Creator class declares the factory method that is supposed to return an\n" +
                    "    object of a Product class. The Creator's subclasses usually provide the\n" +
                    "    implementation of this method.\n" +
                    "    \"\"\"\n" +
                    "\n" +
                    "    @abstractmethod\n" +
                    "    def factory_method(self):\n" +
                    "        \"\"\"\n" +
                    "        Note that the Creator may also provide some default implementation of\n" +
                    "        the factory method.\n" +
                    "        \"\"\"\n" +
                    "        pass\n" +
                    "\n" +
                    "    def some_operation(self) -> str:\n" +
                    "        \"\"\"\n" +
                    "        Also note that, despite its name, the Creator's primary responsibility\n" +
                    "        is not creating products. Usually, it contains some core business logic\n" +
                    "        that relies on Product objects, returned by the factory method.\n" +
                    "        Subclasses can indirectly change that business logic by overriding the\n" +
                    "        factory method and returning a different type of product from it.\n" +
                    "        \"\"\"\n" +
                    "\n" +
                    "        # Call the factory method to create a Product object.\n" +
                    "        product = self.factory_method()\n" +
                    "\n" +
                    "        # Now, use the product.\n" +
                    "        result = f\"Creator: The same creator's code has just worked with {product.operation()}\"\n" +
                    "\n" +
                    "        return result\n" +
                    "\n" +
                    "\n" +
                    "\"\"\"\n" +
                    "Concrete Creators override the factory method in order to change the resulting\n" +
                    "product's type.\n" +
                    "\"\"\"\n" +
                    "\n" +
                    "\n" +
                    "class ConcreteCreator1(Creator):\n" +
                    "    \"\"\"\n" +
                    "    Note that the signature of the method still uses the abstract product type,\n" +
                    "    even though the concrete product is actually returned from the method. This\n" +
                    "    way the Creator can stay independent of concrete product classes.\n" +
                    "    \"\"\"\n" +
                    "\n" +
                    "    def factory_method(self) -> Product:\n" +
                    "        return ConcreteProduct1()\n" +
                    "\n" +
                    "\n" +
                    "class ConcreteCreator2(Creator):\n" +
                    "    def factory_method(self) -> Product:\n" +
                    "        return ConcreteProduct2()\n" +
                    "\n" +
                    "\n" +
                    "class Product(ABC):\n" +
                    "    \"\"\"\n" +
                    "    The Product interface declares the operations that all concrete products\n" +
                    "    must implement.\n" +
                    "    \"\"\"\n" +
                    "\n" +
                    "    @abstractmethod\n" +
                    "    def operation(self) -> str:\n" +
                    "        pass\n" +
                    "\n" +
                    "\n" +
                    "\"\"\"\n" +
                    "Concrete Products provide various implementations of the Product interface.\n" +
                    "\"\"\"\n" +
                    "\n" +
                    "\n" +
                    "class ConcreteProduct1(Product):\n" +
                    "    def operation(self) -> str:\n" +
                    "        return \"{Result of the ConcreteProduct1}\"\n" +
                    "\n" +
                    "\n" +
                    "class ConcreteProduct2(Product):\n" +
                    "    def operation(self) -> str:\n" +
                    "        return \"{Result of the ConcreteProduct2}\"\n" +
                    "\n" +
                    "\n" +
                    "def client_code(creator: Creator) -> None:\n" +
                    "    \"\"\"\n" +
                    "    The client code works with an instance of a concrete creator, albeit through\n" +
                    "    its base interface. As long as the client keeps working with the creator via\n" +
                    "    the base interface, you can pass it any creator's subclass.\n" +
                    "    \"\"\"\n" +
                    "\n" +
                    "    print(f\"Client: I'm not aware of the creator's class, but it still works.\\n\"\n" +
                    "          f\"{creator.some_operation()}\", end=\"\")\n" +
                    "\n" +
                    "\n" +
                    "if __name__ == \"__main__\":\n" +
                    "    print(\"App: Launched with the ConcreteCreator1.\")\n" +
                    "    client_code(ConcreteCreator1())\n" +
                    "    print(\"\\n\")\n" +
                    "\n" +
                    "    print(\"App: Launched with the ConcreteCreator2.\")\n" +
                    "    client_code(ConcreteCreator2())\n";
            String textCodeJava = "// Abstract Factory Interface\n" +
                    "interface GUIFactory {\n" +
                    "    Button createButton();\n" +
                    "    Checkbox createCheckbox();\n" +
                    "}\n" +
                    "\n" +
                    "// Concrete Factory 1: MacOS Factory\n" +
                    "class MacOSFactory implements GUIFactory {\n" +
                    "    @Override\n" +
                    "    public Button createButton() {\n" +
                    "        return new MacOSButton();\n" +
                    "    }\n" +
                    "\n" +
                    "    @Override\n" +
                    "    public Checkbox createCheckbox() {\n" +
                    "        return new MacOSCheckbox();\n" +
                    "    }\n" +
                    "}\n" +
                    "\n" +
                    "// Concrete Factory 2: Windows Factory\n" +
                    "class WindowsFactory implements GUIFactory {\n" +
                    "    @Override\n" +
                    "    public Button createButton() {\n" +
                    "        return new WindowsButton();\n" +
                    "    }\n" +
                    "\n" +
                    "    @Override\n" +
                    "    public Checkbox createCheckbox() {\n" +
                    "        return new WindowsCheckbox();\n" +
                    "    }\n" +
                    "}\n" +
                    "\n" +
                    "// Abstract Product: Button\n" +
                    "interface Button {\n" +
                    "    void paint();\n" +
                    "}\n" +
                    "\n" +
                    "// Concrete Product: MacOS Button\n" +
                    "class MacOSButton implements Button {\n" +
                    "    @Override\n" +
                    "    public void paint() {\n" +
                    "        System.out.println(\"Render a MacOS style button.\");\n" +
                    "    }\n" +
                    "}\n" +
                    "\n" +
                    "// Concrete Product: Windows Button\n" +
                    "class WindowsButton implements Button {\n" +
                    "    @Override\n" +
                    "    public void paint() {\n" +
                    "        System.out.println(\"Render a Windows style button.\");\n" +
                    "    }\n" +
                    "}\n" +
                    "\n" +
                    "// Abstract Product: Checkbox\n" +
                    "interface Checkbox {\n" +
                    "    void paint();\n" +
                    "}\n" +
                    "\n" +
                    "// Concrete Product: MacOS Checkbox\n" +
                    "class MacOSCheckbox implements Checkbox {\n" +
                    "    @Override\n" +
                    "    public void paint() {\n" +
                    "        System.out.println(\"Render a MacOS style checkbox.\");\n" +
                    "    }\n" +
                    "}\n" +
                    "\n" +
                    "// Concrete Product: Windows Checkbox\n" +
                    "class WindowsCheckbox implements Checkbox {\n" +
                    "    @Override\n" +
                    "    public void paint() {\n" +
                    "        System.out.println(\"Render a Windows style checkbox.\");\n" +
                    "    }\n" +
                    "}\n" +
                    "\n" +
                    "// Client class that uses factories to create GUI components\n" +
                    "public class Application {\n" +
                    "    private GUIFactory factory;\n" +
                    "\n" +
                    "    public Application(GUIFactory factory) {\n" +
                    "        this.factory = factory;\n" +
                    "    }\n" +
                    "\n" +
                    "    public void createUI() {\n" +
                    "        Button button = factory.createButton();\n" +
                    "        Checkbox checkbox = factory.createCheckbox();\n" +
                    "\n" +
                    "        button.paint();\n" +
                    "        checkbox.paint();\n" +
                    "    }\n" +
                    "\n" +
                    "    public static void main(String[] args) {\n" +
                    "        // Create MacOS application\n" +
                    "        Application app = new Application(new MacOSFactory());\n" +
                    "        app.createUI();\n" +
                    "\n" +
                    "        // Create Windows application\n" +
                    "        Application app2 = new Application(new WindowsFactory());\n" +
                    "        app2.createUI();\n" +
                    "    }\n" +
                    "}\n";
            pattern.setData(labelPattern, labelIntent, labelImplement, labelProsNCons, textCodeJava, textCodePython);
            MainContainer.getChildren().removeAll();
            MainContainer.getChildren().add(newContent3);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
