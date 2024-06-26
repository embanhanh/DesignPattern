package com.example.demo.Handle;

import java.util.*;

public class SearchHandle {

    public static String searchPattern(String text) {
        setData();
        int maxx = -1;
        String res = "";
        for(Map.Entry<String, String> entry : mapIntent.entrySet()) {
            int cnt = countMatchingWords(text.toLowerCase(), entry.getValue().toLowerCase());
            if(cnt > maxx) {
                maxx = cnt;
                res = entry.getKey();
            }
        }
        return res;
    }

    public static int countMatchingWords(String s1, String s2) {
        // Tách các từ trong s1 và s2
        String[] words1 = s1.split("\\s+");
        String[] words2 = s2.split("\\s+");

        // Sử dụng một Set để lưu các từ trong s2
        Set<String> wordsSet2 = new HashSet<>(Arrays.asList(words2));

        // Đếm số lượng từ trong s1 xuất hiện trong s2
        int count = 0;
        for (String word : words1) {
            if (wordsSet2.contains(word)) {
                count++;
            }
        }

        return count;
    }

    public static void setData() {
        if(!mapIntent.isEmpty()) return;
        mapIntent.put("Factory Method", "Factory Method is a creational design pattern that provides an interface for creating objects in a superclass, but allows subclasses to alter the type of objects that will be created");
        mapIntent.put("Abstract Factory", "Abstract Factory is a creational design pattern that lets you produce families of related objects without specifying their concrete classes");
        mapIntent.put("Builder", "Builder is a creational design pattern that lets you construct complex objects step by step. The pattern allows you to produce different types and representations of an object using the same construction code");
        mapIntent.put("Prototype", "Prototype is a creational design pattern that lets you copy existing objects without making your code dependent on their classes");
        mapIntent.put("Singleton", "Singleton is a creational design pattern that lets you ensure that a class has only one instance, while providing a global access point to this instance");
        mapIntent.put("Adapter", "Adapter is a structural design pattern that allows objects with incompatible interfaces to collaborate");
        mapIntent.put("Bridge", "Bridge is a structural design pattern that lets you split a large class or a set of closely related classes into two separate hierarchies—abstraction and implementation—which can be developed independently of each other");
        mapIntent.put("Composite", "Composite is a structural design pattern that lets you compose objects into tree structures and then work with these structures as if they were individual objects");
        mapIntent.put("Decorator", "Decorator is a structural design pattern that lets you attach new behaviors to objects by placing these objects inside special wrapper objects that contain the behaviors");
        mapIntent.put("Facade", "Facade is a structural design pattern that provides a simplified interface to a library, a framework, or any other complex set of classes");
        mapIntent.put("Flyweight", "Flyweight is a structural design pattern that lets you fit more objects into the available amount of RAM by sharing common parts of state between multiple objects instead of keeping all of the data in each object");
        mapIntent.put("Proxy", "Proxy is a structural design pattern that lets you provide a substitute or placeholder for another object. A proxy controls access to the original object, allowing you to perform something either before or after the request gets through to the original object");
        mapIntent.put("Chain of Responsibility", "Chain of Responsibility is a behavioral design pattern that lets you pass requests along a chain of handlers. Upon receiving a request, each handler decides either to process the request or to pass it to the next handler in the chain");
        mapIntent.put("Command", "Command is a behavioral design pattern that turns a request into a stand-alone object that contains all information about the request. This transformation lets you pass requests as a method arguments, delay or queue a request’s execution, and support undoable operations");
        mapIntent.put("Iterator", "Iterator is a behavioral design pattern that lets you traverse elements of a collection without exposing its underlying representation (list, stack, tree, etc.)");
        mapIntent.put("Mediator", "Mediator is a behavioral design pattern that lets you reduce chaotic dependencies between objects. The pattern restricts direct communications between the objects and forces them to collaborate only via a mediator object");
        mapIntent.put("Memento", "Memento is a behavioral design pattern that lets you save and restore the previous state of an object without revealing the details of its implementation");
        mapIntent.put("Observer", "Observer is a behavioral design pattern that lets you define a subscription mechanism to notify multiple objects about any events that happen to the object they’re observing");
        mapIntent.put("State", "State is a behavioral design pattern that lets an object alter its behavior when its internal state changes. It appears as if the object changed its class");
        mapIntent.put("Strategy", "Strategy is a behavioral design pattern that lets you define a family of algorithms, put each of them into a separate class, and make their objects interchangeable");
        mapIntent.put("Template", "Template Method is a behavioral design pattern that defines the skeleton of an algorithm in the superclass but lets subclasses override specific steps of the algorithm without changing its structure");
        mapIntent.put("Visitor", "Visitor is a behavioral design pattern that lets you separate algorithms from the objects on which they operate");
    }

    public static Map<String, String> mapIntent = new HashMap<>();

}
