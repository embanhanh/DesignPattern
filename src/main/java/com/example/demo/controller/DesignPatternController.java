package com.example.demo.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.Clipboard;
import javafx.scene.input.ClipboardContent;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import javafx.stage.DirectoryChooser;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;

import java.io.File;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.Objects;

public class DesignPatternController {
    @FXML
    private TextFlow TextFlowImplement;

    @FXML
    private TextFlow TextFlowProsandCons;

    @FXML
    private TextFlow TextFlowStructure;

    @FXML
    private TextArea codeCPP;

    @FXML
    private TextArea codeCS;

    @FXML
    private TextArea codeJava;

    @FXML
    private TextArea codePython;

    @FXML
    private ImageView imgIntent;

    @FXML
    private ImageView imgStructure;

    @FXML
    private Text labelIntent;

    @FXML
    private Label labelPattern;

    @FXML
    private Button btnCopy;

    @FXML
    private Tab tabCPP;

    @FXML
    private Tab tabCS;

    @FXML
    private Tab tabJava;

    @FXML
    private Tab tabPython;

    private String tabCode = "Java";


    @FXML
    private void initialize() {
        tabJava.setOnSelectionChanged(event -> {
            if (tabJava.isSelected()) {
                System.out.println("Tab java được chọn");
                tabCode = "Java";
                // Xử lý sự kiện cho Tab 1
            }
        });
        tabPython.setOnSelectionChanged(event -> {
            if (tabPython.isSelected()) {
                System.out.println("tabPython được chọn");
                tabCode = "Python";
                // Xử lý sự kiện cho Tab 1
            }
        });
        tabCPP.setOnSelectionChanged(event -> {
            if (tabCPP.isSelected()) {
                System.out.println("Tab C++ được chọn");
                tabCode = "CPP";
                // Xử lý sự kiện cho Tab 1
            }
        });
        tabCS.setOnSelectionChanged(event -> {
            if (tabCS.isSelected()) {
                System.out.println("Tab C# được chọn");
                tabCode = "CS";
                // Xử lý sự kiện cho Tab 1
            }
        });
    }

    public void setData(String label, String intent, String implement, String ProsNCons, String _codeJava, String _codePython, String _codeCPP, String _codeCS, String _imgIntent, String _imgStructure) {
        labelPattern.setText(label);
        labelIntent.setText(intent);
        Text text1 = new Text(ProsNCons);
        TextFlowProsandCons.getChildren().add(text1);
        Text text2 = new Text(implement);
        TextFlowImplement.getChildren().add(text2);
        codeJava.setText(_codeJava);
        codePython.setText(_codePython);
        codeCPP.setText(_codeCPP);
        codeCS.setText(_codeCS);
        setImage(imgIntent, _imgIntent);
        setImage(imgStructure, _imgStructure);
    }

    private void setImage(ImageView imageView, String imagePath) {
        Image image = new Image(Objects.requireNonNull(getClass().getResourceAsStream(imagePath)));
        imageView.setImage(image);
    }

    @FXML
    private void copy() {
        String textToCopy = tabCode.equals("Java") ? codeJava.getText(): tabCode.equals("Python") ? codePython.getText() : tabCode.equals("CPP") ? codeCPP.getText() : codeCS.getText();

        ClipboardContent content = new ClipboardContent();
        content.putString(textToCopy);

        Clipboard clipboard = Clipboard.getSystemClipboard();
        clipboard.setContent(content);

        System.out.println("Text copied to clipboard!");
    }

    @FXML
    private void btnDownloadDemo() {
        String userHome = System.getProperty("user.home");
        File downloadsDirectory = new File(userHome, "Downloads");
        String path = tabCode.equals("Java") ? getNameJavaDemo(labelPattern.getText()) : getNamePythonDemo(labelPattern.getText());

        if (downloadsDirectory.exists()) {
            File sourceDirectory = new File(Objects.requireNonNull(getClass().getResource("/Demo/" + tabCode + "/" + path)).getFile());
            File destinationDirectory = new File(downloadsDirectory, sourceDirectory.getName());

            // Thêm số đếm vào tên thư mục nếu nó đã tồn tại
            destinationDirectory = resolveDestinationDirectory(destinationDirectory);

            try {
                copyDirectory(sourceDirectory.toPath(), destinationDirectory.toPath());
                System.out.println("Thư mục đã được tải về: " + destinationDirectory.getAbsolutePath());
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Thư mục Downloads không tồn tại.");
        }
    }

    private File resolveDestinationDirectory(File destinationDirectory) {
        int count = 1;
        File newDestinationDirectory = destinationDirectory;

        while (newDestinationDirectory.exists()) {
            String newName = count == 1 ? destinationDirectory.getName() : destinationDirectory.getName() + " (" + count + ")";
            newDestinationDirectory = new File(destinationDirectory.getParent(), newName);
            count++;
        }

        return newDestinationDirectory;
    }



    private void copyDirectory(Path source, Path target) throws IOException {
        Files.walkFileTree(source, new SimpleFileVisitor<>() {
            @Override
            public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
                Path targetDir = target.resolve(source.relativize(dir));
                try {
                    Files.copy(dir, targetDir, StandardCopyOption.REPLACE_EXISTING);
                } catch (FileAlreadyExistsException e) {
                    if (!Files.isDirectory(targetDir)) {
                        throw e;
                    }
                }
                return FileVisitResult.CONTINUE;
            }

            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                Files.copy(file, target.resolve(source.relativize(file)), StandardCopyOption.REPLACE_EXISTING);
                return FileVisitResult.CONTINUE;
            }
        });
    }

    private String getNameJavaDemo(String pattern) {
        return switch (pattern) {
            case "Factory Method" -> "Creational/factory_method";
            case "Abstract Factory" -> "Creational/abstract_factory";
            case "Builder" -> "Creational/builder";
            case "Prototype" -> "Creational/prototype";
            case "Singleton" -> "Creational/singleton";
            case "Adapter" -> "Structural/adapter";
            case "Bridge" -> "Structural/bridge";
            case "Composite" -> "Structural/composite";
            case "Decorator" -> "Structural/decorator";
            case "Facade" -> "Structural/facade";
            case "Flyweight" -> "Structural/flyweight";
            case "Proxy" -> "Structural/proxy";
            case "Chain of Responsibility" -> "Behavioral/chain_of_responsibility";
            case "Command" -> "Behavioral/command";
            case "Iterator" -> "Behavioral/iterator";
            case "Mediator" -> "Behavioral/mediator";
            case "Memento" -> "Behavioral/memento";
            case "Observer" -> "Behavioral/observer";
            case "State" -> "Behavioral/state";
            case "Strategy" -> "Behavioral/strategy";
            case "Template" -> "Behavioral/template";
            case "Visitor" -> "Behavioral/visitor";
            default -> "";
        };
    }
    private String getNamePythonDemo(String pattern) {
        return switch (pattern) {
            case "Factory Method" -> "Creational/FactoryMethod";
            case "Abstract Factory" -> "Creational/AbstractFactory";
            case "Builder" -> "Creational/Builder";
            case "Prototype" -> "Creational/Prototype";
            case "Singleton" -> "Creational/Singleton";
            case "Adapter" -> "Structural/Adapter";
            case "Bridge" -> "Structural/Bridge";
            case "Composite" -> "Structural/Composite";
            case "Decorator" -> "Structural/Decorator";
            case "Facade" -> "Structural/Facade";
            case "Flyweight" -> "Structural/Flyweight";
            case "Proxy" -> "Structural/Proxy";
            case "Chain of Responsibility" -> "Behavioral/ChainOfResponsibility";
            case "Command" -> "Behavioral/Command";
            case "Iterator" -> "Behavioral/Iterator";
            case "Mediator" -> "Behavioral/Mediator";
            case "Memento" -> "Behavioral/Memento";
            case "Observer" -> "Behavioral/Observer";
            case "State" -> "Behavioral/State";
            case "Strategy" -> "Behavioral/Strategy";
            case "Template" -> "Behavioral/Template";
            case "Visitor" -> "Behavioral/Visitor";
            default -> "";
        };
    }
}
