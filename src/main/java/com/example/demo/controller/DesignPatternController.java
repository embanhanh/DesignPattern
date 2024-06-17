package com.example.demo.controller;

import javafx.fxml.FXML;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;

public class DesignPatternController {
    @FXML
    private TextFlow TextFlowStructure;

    @FXML
    private TextFlow TextFlowImplement;

    @FXML
    private TextFlow TextFlowProsandCons;

    @FXML
    private void initialize() {
        Text text = new Text("1.The Product declares the interface, which is common to all objects that can be produced by the creator and its subclasses.\n" +
                "2. Concrete Products are different implementations of the product interface.\n" +
                "3. The Creator class declares the factory method that returns new product objects. It’s important that the return type of this method matches the product interface.\n" +
                "You can declare the factory method as abstract to force all subclasses to implement their own versions of the method. As an alternative, the base factory method can return some default product type.\n" +
                "Note, despite its name, product creation is not the primary responsibility of the creator. Usually, the creator class already has some core business logic related to products. The factory method helps to decouple this logic from the concrete product classes. Here is an analogy: a large software development company can have a training department for programmers. However, the primary function of the company as a whole is still writing code, not producing programmers.\n" +
                "4. Concrete Creators override the base factory method so it returns a different type of product.\n" +
                "Note that the factory method doesn’t have to create new instances all the time. It can also return existing objects from a cache, an object pool, or another source.");
        TextFlowStructure.getChildren().add(text);

        Text text2 = new Text("1.Define a Common Interface for All Products:\n" +
                "Ensure that all products implement a common interface with methods that are applicable to every product.\n" +
                "2. Add a Factory Method in the Creator Class:\n" +
                "Introduce an empty factory method in the creator class. The return type should match the common product interface.\n" +
                "3. Refactor Product Construction:\n" +
                "Replace direct product constructor calls with calls to the factory method within the creator’s code.\n" +
                "Extract the product creation logic into the factory method.\n" +
                "Use a temporary parameter in the factory method to determine the type of product to be created.\n" +
                "4. Simplify the Factory Method:\n" +
                "If the factory method contains a large switch statement for product instantiation, prepare to refactor it.\n" +
                "5. Create Subclasses for Each Product Type:\n" +
                "For each product type listed in the factory method, create a corresponding subclass of the creator.\n" +
                "Override the factory method in each subclass, moving the relevant construction code from the base class to these subclasses.\n" +
                "6. Handle Multiple Product Types Efficiently:\n" +
                "If there are too many product types, consider using a control parameter in the factory method of a subclass to handle different products instead of creating a subclass for each type.\n" +
                "7. Finalize the Base Factory Method:\n" +
                "If the base factory method is empty after refactoring, make it abstract.\n" +
                "If there’s any remaining code, consider it as the default behavior.");
        TextFlowImplement.getChildren().add(text2);

        Text text3 = new Text(" You avoid tight coupling between the creator and the concrete products.\n" +
                " Single Responsibility Principle. You can move the product creation code into one place in the program, making the code easier to support.\n" +
                " Open/Closed Principle. You can introduce new types of products into the program without breaking existing client code.\n" +
                " The code may become more complicated since you need to introduce a lot of new subclasses to implement the pattern. The best case scenario is when you’re introducing the pattern into an existing hierarchy of creator classes.");

        TextFlowProsandCons.getChildren().add(text3);
    }
}
