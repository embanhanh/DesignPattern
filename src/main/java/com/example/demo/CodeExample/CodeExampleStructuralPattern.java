package com.example.demo.CodeExample;

public class CodeExampleStructuralPattern {


    // STRUCTURAL PATTERN
    public static String getCodeJavaFromNameStructuralPattern(String pattern) {
        return switch (pattern) {
            case "Adapter" -> "// The Target interface which the client expects to use\n" +
                    "interface Target {\n" +
                    "    void request();\n" +
                    "}\n" +
                    "\n" +
                    "// The Adaptee class with an existing interface that needs adapting\n" +
                    "class Adaptee {\n" +
                    "    void specificRequest() {\n" +
                    "        System.out.println(\"Specific request from Adaptee\");\n" +
                    "    }\n" +
                    "}\n" +
                    "\n" +
                    "// The Adapter class that implements the Target interface and adapts the Adaptee\n" +
                    "class Adapter implements Target {\n" +
                    "    private Adaptee adaptee;\n" +
                    "\n" +
                    "    public Adapter(Adaptee adaptee) {\n" +
                    "        this.adaptee = adaptee;\n" +
                    "    }\n" +
                    "\n" +
                    "    @Override\n" +
                    "    public void request() {\n" +
                    "        // Translate the request to a method that Adaptee understands\n" +
                    "        adaptee.specificRequest();\n" +
                    "    }\n" +
                    "}\n" +
                    "\n" +
                    "// Client code\n" +
                    "public class AdapterPattern {\n" +
                    "    public static void main(String[] args) {\n" +
                    "        Adaptee adaptee = new Adaptee();\n" +
                    "        Target target = new Adapter(adaptee);\n" +
                    "        target.request();  // Output: Specific request from Adaptee\n" +
                    "    }\n" +
                    "}\n";
            case "Bridge" -> "// Implementor interface with method to be implemented by concrete implementors\n" +
                    "interface Implementor {\n" +
                    "    void operationImpl();\n" +
                    "}\n" +
                    "\n" +
                    "// Concrete Implementors implementing the Implementor interface\n" +
                    "class ConcreteImplementorA implements Implementor {\n" +
                    "    @Override\n" +
                    "    public void operationImpl() {\n" +
                    "        System.out.println(\"ConcreteImplementorA operation\");\n" +
                    "    }\n" +
                    "}\n" +
                    "\n" +
                    "class ConcreteImplementorB implements Implementor {\n" +
                    "    @Override\n" +
                    "    public void operationImpl() {\n" +
                    "        System.out.println(\"ConcreteImplementorB operation\");\n" +
                    "    }\n" +
                    "}\n" +
                    "\n" +
                    "// Abstraction class with a reference to an Implementor\n" +
                    "abstract class Abstraction {\n" +
                    "    protected Implementor implementor;\n" +
                    "\n" +
                    "    protected Abstraction(Implementor implementor) {\n" +
                    "        this.implementor = implementor;\n" +
                    "    }\n" +
                    "\n" +
                    "    public abstract void operation();\n" +
                    "}\n" +
                    "\n" +
                    "// RefinedAbstraction class extending Abstraction\n" +
                    "class RefinedAbstraction extends Abstraction {\n" +
                    "    protected RefinedAbstraction(Implementor implementor) {\n" +
                    "        super(implementor);\n" +
                    "    }\n" +
                    "\n" +
                    "    @Override\n" +
                    "    public void operation() {\n" +
                    "        System.out.print(\"RefinedAbstraction operation with \");\n" +
                    "        implementor.operationImpl();\n" +
                    "    }\n" +
                    "}\n" +
                    "\n" +
                    "// Client code\n" +
                    "public class BridgePattern {\n" +
                    "    public static void main(String[] args) {\n" +
                    "        Implementor implementorA = new ConcreteImplementorA();\n" +
                    "        Abstraction abstractionA = new RefinedAbstraction(implementorA);\n" +
                    "        abstractionA.operation();  // Output: RefinedAbstraction operation with ConcreteImplementorA operation\n" +
                    "\n" +
                    "        Implementor implementorB = new ConcreteImplementorB();\n" +
                    "        Abstraction abstractionB = new RefinedAbstraction(implementorB);\n" +
                    "        abstractionB.operation();  // Output: RefinedAbstraction operation with ConcreteImplementorB operation\n" +
                    "    }\n" +
                    "}\n";
            case "Composite" -> "import java.util.ArrayList;\n" +
                    "import java.util.List;\n" +
                    "\n" +
                    "// Component interface\n" +
                    "interface Component {\n" +
                    "    void operation();\n" +
                    "}\n" +
                    "\n" +
                    "// Leaf class implementing Component interface\n" +
                    "class Leaf implements Component {\n" +
                    "    private String name;\n" +
                    "\n" +
                    "    public Leaf(String name) {\n" +
                    "        this.name = name;\n" +
                    "    }\n" +
                    "\n" +
                    "    @Override\n" +
                    "    public void operation() {\n" +
                    "        System.out.println(\"Leaf \" + name + \" operation\");\n" +
                    "    }\n" +
                    "}\n" +
                    "\n" +
                    "// Composite class implementing Component interface and containing children\n" +
                    "class Composite implements Component {\n" +
                    "    private List<Component> children = new ArrayList<>();\n" +
                    "\n" +
                    "    public void add(Component component) {\n" +
                    "        children.add(component);\n" +
                    "    }\n" +
                    "\n" +
                    "    public void remove(Component component) {\n" +
                    "        children.remove(component);\n" +
                    "    }\n" +
                    "\n" +
                    "    public List<Component> getChildren() {\n" +
                    "        return children;\n" +
                    "    }\n" +
                    "\n" +
                    "    @Override\n" +
                    "    public void operation() {\n" +
                    "        System.out.println(\"Composite operation\");\n" +
                    "        for (Component child : children) {\n" +
                    "            child.operation();\n" +
                    "        }\n" +
                    "    }\n" +
                    "}\n" +
                    "\n" +
                    "// Client code\n" +
                    "public class CompositePattern {\n" +
                    "    public static void main(String[] args) {\n" +
                    "        Leaf leaf1 = new Leaf(\"1\");\n" +
                    "        Leaf leaf2 = new Leaf(\"2\");\n" +
                    "        Composite composite = new Composite();\n" +
                    "        composite.add(leaf1);\n" +
                    "        composite.add(leaf2);\n" +
                    "\n" +
                    "        composite.operation();\n" +
                    "        // Output:\n" +
                    "        // Composite operation\n" +
                    "        // Leaf 1 operation\n" +
                    "        // Leaf 2 operation\n" +
                    "    }\n" +
                    "}\n";
            case "Decorator" -> "// Component interface\n" +
                    "interface Component {\n" +
                    "    void operation();\n" +
                    "}\n" +
                    "\n" +
                    "// ConcreteComponent implementing Component interface\n" +
                    "class ConcreteComponent implements Component {\n" +
                    "    @Override\n" +
                    "    public void operation() {\n" +
                    "        System.out.println(\"ConcreteComponent operation\");\n" +
                    "    }\n" +
                    "}\n" +
                    "\n" +
                    "// Decorator abstract class implementing Component and containing a reference to a Component\n" +
                    "abstract class Decorator implements Component {\n" +
                    "    protected Component component;\n" +
                    "\n" +
                    "    public Decorator(Component component) {\n" +
                    "        this.component = component;\n" +
                    "    }\n" +
                    "\n" +
                    "    @Override\n" +
                    "    public void operation() {\n" +
                    "        component.operation();\n" +
                    "    }\n" +
                    "}\n" +
                    "\n" +
                    "// ConcreteDecoratorA extending Decorator\n" +
                    "class ConcreteDecoratorA extends Decorator {\n" +
                    "    public ConcreteDecoratorA(Component component) {\n" +
                    "        super(component);\n" +
                    "    }\n" +
                    "\n" +
                    "    @Override\n" +
                    "    public void operation() {\n" +
                    "        super.operation();\n" +
                    "        addedBehavior();\n" +
                    "    }\n" +
                    "\n" +
                    "    private void addedBehavior() {\n" +
                    "        System.out.println(\"ConcreteDecoratorA added behavior\");\n" +
                    "    }\n" +
                    "}\n" +
                    "\n" +
                    "// ConcreteDecoratorB extending Decorator\n" +
                    "class ConcreteDecoratorB extends Decorator {\n" +
                    "    public ConcreteDecoratorB(Component component) {\n" +
                    "        super(component);\n" +
                    "    }\n" +
                    "\n" +
                    "    @Override\n" +
                    "    public void operation() {\n" +
                    "        super.operation();\n" +
                    "        addedBehavior();\n" +
                    "    }\n" +
                    "\n" +
                    "    private void addedBehavior() {\n" +
                    "        System.out.println(\"ConcreteDecoratorB added behavior\");\n" +
                    "    }\n" +
                    "}\n" +
                    "\n" +
                    "// Client code\n" +
                    "public class DecoratorPattern {\n" +
                    "    public static void main(String[] args) {\n" +
                    "        Component component = new ConcreteComponent();\n" +
                    "        Component decoratorA = new ConcreteDecoratorA(component);\n" +
                    "        Component decoratorB = new ConcreteDecoratorB(decoratorA);\n" +
                    "        \n" +
                    "        decoratorB.operation();\n" +
                    "        // Output:\n" +
                    "        // ConcreteComponent operation\n" +
                    "        // ConcreteDecoratorA added behavior\n" +
                    "        // ConcreteDecoratorB added behavior\n" +
                    "    }\n" +
                    "}\n";
            case "Facade"  -> "// Subsystem classes\n" +
                    "class Subsystem1 {\n" +
                    "    public void operation1() {\n" +
                    "        System.out.println(\"Subsystem1 operation\");\n" +
                    "    }\n" +
                    "}\n" +
                    "\n" +
                    "class Subsystem2 {\n" +
                    "    public void operation2() {\n" +
                    "        System.out.println(\"Subsystem2 operation\");\n" +
                    "    }\n" +
                    "}\n" +
                    "\n" +
                    "class Subsystem3 {\n" +
                    "    public void operation3() {\n" +
                    "        System.out.println(\"Subsystem3 operation\");\n" +
                    "    }\n" +
                    "}\n" +
                    "\n" +
                    "// Facade class\n" +
                    "class Facade {\n" +
                    "    private Subsystem1 subsystem1;\n" +
                    "    private Subsystem2 subsystem2;\n" +
                    "    private Subsystem3 subsystem3;\n" +
                    "\n" +
                    "    public Facade() {\n" +
                    "        this.subsystem1 = new Subsystem1();\n" +
                    "        this.subsystem2 = new Subsystem2();\n" +
                    "        this.subsystem3 = new Subsystem3();\n" +
                    "    }\n" +
                    "\n" +
                    "    public void operation() {\n" +
                    "        subsystem1.operation1();\n" +
                    "        subsystem2.operation2();\n" +
                    "        subsystem3.operation3();\n" +
                    "    }\n" +
                    "}\n" +
                    "\n" +
                    "// Client code\n" +
                    "public class FacadePattern {\n" +
                    "    public static void main(String[] args) {\n" +
                    "        Facade facade = new Facade();\n" +
                    "        facade.operation();\n" +
                    "        // Output:\n" +
                    "        // Subsystem1 operation\n" +
                    "        // Subsystem2 operation\n" +
                    "        // Subsystem3 operation\n" +
                    "    }\n" +
                    "}\n";
            case "Flyweight"  -> "import java.util.HashMap;\n" +
                    "import java.util.Map;\n" +
                    "\n" +
                    "// Flyweight interface\n" +
                    "interface Flyweight {\n" +
                    "    void operation(String extrinsicState);\n" +
                    "}\n" +
                    "\n" +
                    "// ConcreteFlyweight class implementing Flyweight\n" +
                    "class ConcreteFlyweight implements Flyweight {\n" +
                    "    private String intrinsicState;\n" +
                    "\n" +
                    "    public ConcreteFlyweight(String intrinsicState) {\n" +
                    "        this.intrinsicState = intrinsicState;\n" +
                    "    }\n" +
                    "\n" +
                    "    @Override\n" +
                    "    public void operation(String extrinsicState) {\n" +
                    "        System.out.println(\"Intrinsic State = \" + intrinsicState + \", Extrinsic State = \" + extrinsicState);\n" +
                    "    }\n" +
                    "}\n" +
                    "\n" +
                    "// FlyweightFactory class to manage Flyweight instances\n" +
                    "class FlyweightFactory {\n" +
                    "    private Map<String, Flyweight> flyweights = new HashMap<>();\n" +
                    "\n" +
                    "    public Flyweight getFlyweight(String key) {\n" +
                    "        if (!flyweights.containsKey(key)) {\n" +
                    "            flyweights.put(key, new ConcreteFlyweight(key));\n" +
                    "        }\n" +
                    "        return flyweights.get(key);\n" +
                    "    }\n" +
                    "\n" +
                    "    public int getFlyweightCount() {\n" +
                    "        return flyweights.size();\n" +
                    "    }\n" +
                    "}\n" +
                    "\n" +
                    "// Client code\n" +
                    "public class FlyweightPattern {\n" +
                    "    public static void main(String[] args) {\n" +
                    "        FlyweightFactory factory = new FlyweightFactory();\n" +
                    "\n" +
                    "        Flyweight flyweight1 = factory.getFlyweight(\"A\");\n" +
                    "        Flyweight flyweight2 = factory.getFlyweight(\"B\");\n" +
                    "        Flyweight flyweight3 = factory.getFlyweight(\"A\");\n" +
                    "\n" +
                    "        flyweight1.operation(\"X\");\n" +
                    "        flyweight2.operation(\"Y\");\n" +
                    "        flyweight3.operation(\"Z\");\n" +
                    "\n" +
                    "        System.out.println(\"Number of flyweights created: \" + factory.getFlyweightCount());\n" +
                    "        // Output:\n" +
                    "        // Intrinsic State = A, Extrinsic State = X\n" +
                    "        // Intrinsic State = B, Extrinsic State = Y\n" +
                    "        // Intrinsic State = A, Extrinsic State = Z\n" +
                    "        // Number of flyweights created: 2\n" +
                    "    }\n" +
                    "}\n";
            case "Proxy"  -> "// Subject interface\n" +
                    "interface Subject {\n" +
                    "    void request();\n" +
                    "}\n" +
                    "\n" +
                    "// RealSubject class implementing Subject\n" +
                    "class RealSubject implements Subject {\n" +
                    "    @Override\n" +
                    "    public void request() {\n" +
                    "        System.out.println(\"RealSubject request\");\n" +
                    "    }\n" +
                    "}\n" +
                    "\n" +
                    "// Proxy class implementing Subject and containing a reference to RealSubject\n" +
                    "class Proxy implements Subject {\n" +
                    "    private RealSubject realSubject;\n" +
                    "\n" +
                    "    @Override\n" +
                    "    public void request() {\n" +
                    "        if (realSubject == null) {\n" +
                    "            realSubject = new RealSubject();\n" +
                    "        }\n" +
                    "        realSubject.request();\n" +
                    "    }\n" +
                    "}\n" +
                    "\n" +
                    "// Client code\n" +
                    "public class ProxyPattern {\n" +
                    "    public static void main(String[] args) {\n" +
                    "        Subject proxy = new Proxy();\n" +
                    "        proxy.request();  // Output: RealSubject request\n" +
                    "    }\n" +
                    "}\n";
            // More cases...
            default -> "Error for load code";
        };
    }

    public static String getCodePythonFromNameStructuralPattern(String pattern) {
        return switch (pattern) {
            case "Adapter" -> "# The Target interface which the client expects to use\n" +
                    "class Target:\n" +
                    "    def request(self):\n" +
                    "        pass\n" +
                    "\n" +
                    "# The Adaptee class with an existing interface that needs adapting\n" +
                    "class Adaptee:\n" +
                    "    def specific_request(self):\n" +
                    "        print(\"Specific request from Adaptee\")\n" +
                    "\n" +
                    "# The Adapter class that implements the Target interface and adapts the Adaptee\n" +
                    "class Adapter(Target):\n" +
                    "    def __init__(self, adaptee):\n" +
                    "        self.adaptee = adaptee\n" +
                    "\n" +
                    "    def request(self):\n" +
                    "        # Translate the request to a method that Adaptee understands\n" +
                    "        self.adaptee.specific_request()\n" +
                    "\n" +
                    "# Client code\n" +
                    "if __name__ == \"__main__\":\n" +
                    "    adaptee = Adaptee()\n" +
                    "    target = Adapter(adaptee)\n" +
                    "    target.request()  # Output: Specific request from Adaptee\n";
            case "Bridge" -> "# Implementor interface with method to be implemented by concrete implementors\n" +
                    "class Implementor:\n" +
                    "    def operation_impl(self):\n" +
                    "        pass\n" +
                    "\n" +
                    "# Concrete Implementors implementing the Implementor interface\n" +
                    "class ConcreteImplementorA(Implementor):\n" +
                    "    def operation_impl(self):\n" +
                    "        print(\"ConcreteImplementorA operation\")\n" +
                    "\n" +
                    "class ConcreteImplementorB(Implementor):\n" +
                    "    def operation_impl(self):\n" +
                    "        print(\"ConcreteImplementorB operation\")\n" +
                    "\n" +
                    "# Abstraction class with a reference to an Implementor\n" +
                    "class Abstraction:\n" +
                    "    def __init__(self, implementor):\n" +
                    "        self.implementor = implementor\n" +
                    "\n" +
                    "    def operation(self):\n" +
                    "        pass\n" +
                    "\n" +
                    "# RefinedAbstraction class extending Abstraction\n" +
                    "class RefinedAbstraction(Abstraction):\n" +
                    "    def operation(self):\n" +
                    "        print(\"RefinedAbstraction operation with \", end=\"\")\n" +
                    "        self.implementor.operation_impl()\n" +
                    "\n" +
                    "# Client code\n" +
                    "if __name__ == \"__main__\":\n" +
                    "    implementor_a = ConcreteImplementorA()\n" +
                    "    abstraction_a = RefinedAbstraction(implementor_a)\n" +
                    "    abstraction_a.operation()  # Output: RefinedAbstraction operation with ConcreteImplementorA operation\n" +
                    "\n" +
                    "    implementor_b = ConcreteImplementorB()\n" +
                    "    abstraction_b = RefinedAbstraction(implementor_b)\n" +
                    "    abstraction_b.operation()  # Output: RefinedAbstraction operation with ConcreteImplementorB operation\n";
            case "Composite" -> "# Component interface\n" +
                    "class Component:\n" +
                    "    def operation(self):\n" +
                    "        pass\n" +
                    "\n" +
                    "# Leaf class implementing Component interface\n" +
                    "class Leaf(Component):\n" +
                    "    def __init__(self, name):\n" +
                    "        self.name = name\n" +
                    "\n" +
                    "    def operation(self):\n" +
                    "        print(f\"Leaf {self.name} operation\")\n" +
                    "\n" +
                    "# Composite class implementing Component interface and containing children\n" +
                    "class Composite(Component):\n" +
                    "    def __init__(self):\n" +
                    "        self.children = []\n" +
                    "\n" +
                    "    def add(self, component):\n" +
                    "        self.children.append(component)\n" +
                    "\n" +
                    "    def remove(self, component):\n" +
                    "        self.children.remove(component)\n" +
                    "\n" +
                    "    def get_children(self):\n" +
                    "        return self.children\n" +
                    "\n" +
                    "    def operation(self):\n" +
                    "        print(\"Composite operation\")\n" +
                    "        for child in self.children:\n" +
                    "            child.operation()\n" +
                    "\n" +
                    "# Client code\n" +
                    "if __name__ == \"__main__\":\n" +
                    "    leaf1 = Leaf(\"1\")\n" +
                    "    leaf2 = Leaf(\"2\")\n" +
                    "    composite = Composite()\n" +
                    "    composite.add(leaf1)\n" +
                    "    composite.add(leaf2)\n" +
                    "\n" +
                    "    composite.operation()\n" +
                    "    # Output:\n" +
                    "    # Composite operation\n" +
                    "    # Leaf 1 operation\n" +
                    "    # Leaf 2 operation\n";
            case "Decorator" -> "# Component interface\n" +
                    "class Component:\n" +
                    "    def operation(self):\n" +
                    "        pass\n" +
                    "\n" +
                    "# ConcreteComponent implementing Component interface\n" +
                    "class ConcreteComponent(Component):\n" +
                    "    def operation(self):\n" +
                    "        print(\"ConcreteComponent operation\")\n" +
                    "\n" +
                    "# Decorator abstract class implementing Component and containing a reference to a Component\n" +
                    "class Decorator(Component):\n" +
                    "    def __init__(self, component):\n" +
                    "        self.component = component\n" +
                    "\n" +
                    "    def operation(self):\n" +
                    "        self.component.operation()\n" +
                    "\n" +
                    "# ConcreteDecoratorA extending Decorator\n" +
                    "class ConcreteDecoratorA(Decorator):\n" +
                    "    def operation(self):\n" +
                    "        super().operation()\n" +
                    "        self.added_behavior()\n" +
                    "\n" +
                    "    def added_behavior(self):\n" +
                    "        print(\"ConcreteDecoratorA added behavior\")\n" +
                    "\n" +
                    "# ConcreteDecoratorB extending Decorator\n" +
                    "class ConcreteDecoratorB(Decorator):\n" +
                    "    def operation(self):\n" +
                    "        super().operation()\n" +
                    "        self.added_behavior()\n" +
                    "\n" +
                    "    def added_behavior(self):\n" +
                    "        print(\"ConcreteDecoratorB added behavior\")\n" +
                    "\n" +
                    "# Client code\n" +
                    "if __name__ == \"__main__\":\n" +
                    "    component = ConcreteComponent()\n" +
                    "    decorator_a = ConcreteDecoratorA(component)\n" +
                    "    decorator_b = ConcreteDecoratorB(decorator_a)\n" +
                    "\n" +
                    "    decorator_b.operation()\n" +
                    "    # Output:\n" +
                    "    # ConcreteComponent operation\n" +
                    "    # ConcreteDecoratorA added behavior\n" +
                    "    # ConcreteDecoratorB added behavior\n";
            case "Facade"  -> "# Subsystem classes\n" +
                    "class Subsystem1:\n" +
                    "    def operation1(self):\n" +
                    "        print(\"Subsystem1 operation\")\n" +
                    "\n" +
                    "class Subsystem2:\n" +
                    "    def operation2(self):\n" +
                    "        print(\"Subsystem2 operation\")\n" +
                    "\n" +
                    "class Subsystem3:\n" +
                    "    def operation3(self):\n" +
                    "        print(\"Subsystem3 operation\")\n" +
                    "\n" +
                    "# Facade class\n" +
                    "class Facade:\n" +
                    "    def __init__(self):\n" +
                    "        self.subsystem1 = Subsystem1()\n" +
                    "        self.subsystem2 = Subsystem2()\n" +
                    "        self.subsystem3 = Subsystem3()\n" +
                    "\n" +
                    "    def operation(self):\n" +
                    "        self.subsystem1.operation1()\n" +
                    "        self.subsystem2.operation2()\n" +
                    "        self.subsystem3.operation3()\n" +
                    "\n" +
                    "# Client code\n" +
                    "if __name__ == \"__main__\":\n" +
                    "    facade = Facade()\n" +
                    "    facade.operation()\n" +
                    "    # Output:\n" +
                    "    # Subsystem1 operation\n" +
                    "    # Subsystem2 operation\n" +
                    "    # Subsystem3 operation\n";
            case "Flyweight"  -> "# Flyweight interface\n" +
                    "class Flyweight:\n" +
                    "    def operation(self, extrinsic_state):\n" +
                    "        pass\n" +
                    "\n" +
                    "# ConcreteFlyweight class implementing Flyweight\n" +
                    "class ConcreteFlyweight(Flyweight):\n" +
                    "    def __init__(self, intrinsic_state):\n" +
                    "        self.intrinsic_state = intrinsic_state\n" +
                    "\n" +
                    "    def operation(self, extrinsic_state):\n" +
                    "        print(f\"Intrinsic State = {self.intrinsic_state}, Extrinsic State = {extrinsic_state}\")\n" +
                    "\n" +
                    "# FlyweightFactory class to manage Flyweight instances\n" +
                    "class FlyweightFactory:\n" +
                    "    def __init__(self):\n" +
                    "        self.flyweights = {}\n" +
                    "\n" +
                    "    def get_flyweight(self, key):\n" +
                    "        if key not in self.flyweights:\n" +
                    "            self.flyweights[key] = ConcreteFlyweight(key)\n" +
                    "        return self.flyweights[key]\n" +
                    "\n" +
                    "    def get_flyweight_count(self):\n" +
                    "        return len(self.flyweights)\n" +
                    "\n" +
                    "# Client code\n" +
                    "if __name__ == \"__main__\":\n" +
                    "    factory = FlyweightFactory()\n" +
                    "\n" +
                    "    flyweight1 = factory.get_flyweight(\"A\")\n" +
                    "    flyweight2 = factory.get_flyweight(\"B\")\n" +
                    "    flyweight3 = factory.get_flyweight(\"A\")\n" +
                    "\n" +
                    "    flyweight1.operation(\"X\")\n" +
                    "    flyweight2.operation(\"Y\")\n" +
                    "    flyweight3.operation(\"Z\")\n" +
                    "\n" +
                    "    print(f\"Number of flyweights created: {factory.get_flyweight_count()}\")\n" +
                    "    # Output:\n" +
                    "    # Intrinsic State = A, Extrinsic State = X\n" +
                    "    # Intrinsic State = B, Extrinsic State = Y\n" +
                    "    # Intrinsic State = A, Extrinsic State = Z\n" +
                    "    # Number of flyweights created: 2\n";
            case "Proxy"  -> "# Subject interface\n" +
                    "class Subject:\n" +
                    "    def request(self):\n" +
                    "        pass\n" +
                    "\n" +
                    "# RealSubject class implementing Subject\n" +
                    "class RealSubject(Subject):\n" +
                    "    def request(self):\n" +
                    "        print(\"RealSubject request\")\n" +
                    "\n" +
                    "# Proxy class implementing Subject and containing a reference to RealSubject\n" +
                    "class Proxy(Subject):\n" +
                    "    def __init__(self):\n" +
                    "        self.real_subject = None\n" +
                    "\n" +
                    "    def request(self):\n" +
                    "        if self.real_subject is None:\n" +
                    "            self.real_subject = RealSubject()\n" +
                    "        self.real_subject.request()\n" +
                    "\n" +
                    "# Client code\n" +
                    "if __name__ == \"__main__\":\n" +
                    "    proxy = Proxy()\n" +
                    "    proxy.request()  # Output: RealSubject request\n";
            // More cases...
            default -> "Error for load code";
        };
    }

    public static String getCodeCPPFromNameStructuralPattern(String pattern) {
        return switch (pattern) {
            case "Adapter" -> "#include <iostream>\n" +
                    "\n" +
                    "// The Target interface which the client expects to use\n" +
                    "class Target {\n" +
                    "public:\n" +
                    "    virtual void request() const = 0;\n" +
                    "    virtual ~Target() = default;\n" +
                    "};\n" +
                    "\n" +
                    "// The Adaptee class with an existing interface that needs adapting\n" +
                    "class Adaptee {\n" +
                    "public:\n" +
                    "    void specificRequest() const {\n" +
                    "        std::cout << \"Specific request from Adaptee\\n\";\n" +
                    "    }\n" +
                    "};\n" +
                    "\n" +
                    "// The Adapter class that implements the Target interface and adapts the Adaptee\n" +
                    "class Adapter : public Target {\n" +
                    "private:\n" +
                    "    Adaptee* adaptee;\n" +
                    "public:\n" +
                    "    Adapter(Adaptee* a) : adaptee(a) {}\n" +
                    "\n" +
                    "    void request() const override {\n" +
                    "        // Translate the request to a method that Adaptee understands\n" +
                    "        adaptee->specificRequest();\n" +
                    "    }\n" +
                    "};\n" +
                    "\n" +
                    "// Client code\n" +
                    "int main() {\n" +
                    "    Adaptee* adaptee = new Adaptee();\n" +
                    "    Target* target = new Adapter(adaptee);\n" +
                    "    target->request();  // Output: Specific request from Adaptee\n" +
                    "\n" +
                    "    delete adaptee;\n" +
                    "    delete target;\n" +
                    "    return 0;\n" +
                    "}\n";
            case "Bridge" -> "#include <iostream>\n" +
                    "\n" +
                    "// Implementor interface with method to be implemented by concrete implementors\n" +
                    "class Implementor {\n" +
                    "public:\n" +
                    "    virtual void operationImpl() const = 0;\n" +
                    "    virtual ~Implementor() = default;\n" +
                    "};\n" +
                    "\n" +
                    "// Concrete Implementors implementing the Implementor interface\n" +
                    "class ConcreteImplementorA : public Implementor {\n" +
                    "public:\n" +
                    "    void operationImpl() const override {\n" +
                    "        std::cout << \"ConcreteImplementorA operation\\n\";\n" +
                    "    }\n" +
                    "};\n" +
                    "\n" +
                    "class ConcreteImplementorB : public Implementor {\n" +
                    "public:\n" +
                    "    void operationImpl() const override {\n" +
                    "        std::cout << \"ConcreteImplementorB operation\\n\";\n" +
                    "    }\n" +
                    "};\n" +
                    "\n" +
                    "// Abstraction class with a reference to an Implementor\n" +
                    "class Abstraction {\n" +
                    "protected:\n" +
                    "    Implementor* implementor;\n" +
                    "public:\n" +
                    "    Abstraction(Implementor* imp) : implementor(imp) {}\n" +
                    "    virtual void operation() const = 0;\n" +
                    "    virtual ~Abstraction() = default;\n" +
                    "};\n" +
                    "\n" +
                    "// RefinedAbstraction class extending Abstraction\n" +
                    "class RefinedAbstraction : public Abstraction {\n" +
                    "public:\n" +
                    "    RefinedAbstraction(Implementor* imp) : Abstraction(imp) {}\n" +
                    "\n" +
                    "    void operation() const override {\n" +
                    "        std::cout << \"RefinedAbstraction operation with \";\n" +
                    "        implementor->operationImpl();\n" +
                    "    }\n" +
                    "};\n" +
                    "\n" +
                    "// Client code\n" +
                    "int main() {\n" +
                    "    Implementor* implementorA = new ConcreteImplementorA();\n" +
                    "    Abstraction* abstractionA = new RefinedAbstraction(implementorA);\n" +
                    "    abstractionA->operation();  // Output: RefinedAbstraction operation with ConcreteImplementorA operation\n" +
                    "\n" +
                    "    Implementor* implementorB = new ConcreteImplementorB();\n" +
                    "    Abstraction* abstractionB = new RefinedAbstraction(implementorB);\n" +
                    "    abstractionB->operation();  // Output: RefinedAbstraction operation with ConcreteImplementorB operation\n" +
                    "\n" +
                    "    delete abstractionA;\n" +
                    "    delete abstractionB;\n" +
                    "    delete implementorA;\n" +
                    "    delete implementorB;\n" +
                    "    return 0;\n" +
                    "}\n";
            case "Composite" -> "#include <iostream>\n" +
                    "#include <vector>\n" +
                    "\n" +
                    "// Component interface\n" +
                    "class Component {\n" +
                    "public:\n" +
                    "    virtual void operation() const = 0;\n" +
                    "    virtual ~Component() = default;\n" +
                    "};\n" +
                    "\n" +
                    "// Leaf class implementing Component interface\n" +
                    "class Leaf : public Component {\n" +
                    "private:\n" +
                    "    std::string name;\n" +
                    "public:\n" +
                    "    Leaf(const std::string& n) : name(n) {}\n" +
                    "\n" +
                    "    void operation() const override {\n" +
                    "        std::cout << \"Leaf \" << name << \" operation\\n\";\n" +
                    "    }\n" +
                    "};\n" +
                    "\n" +
                    "// Composite class implementing Component interface and containing children\n" +
                    "class Composite : public Component {\n" +
                    "private:\n" +
                    "    std::vector<Component*> children;\n" +
                    "public:\n" +
                    "    void add(Component* component) {\n" +
                    "        children.push_back(component);\n" +
                    "    }\n" +
                    "\n" +
                    "    void remove(Component* component) {\n" +
                    "        children.erase(std::remove(children.begin(), children.end(), component), children.end());\n" +
                    "    }\n" +
                    "\n" +
                    "    void operation() const override {\n" +
                    "        std::cout << \"Composite operation\\n\";\n" +
                    "        for (const auto& child : children) {\n" +
                    "            child->operation();\n" +
                    "        }\n" +
                    "    }\n" +
                    "\n" +
                    "    ~Composite() {\n" +
                    "        for (auto& child : children) {\n" +
                    "            delete child;\n" +
                    "        }\n" +
                    "    }\n" +
                    "};\n" +
                    "\n" +
                    "// Client code\n" +
                    "int main() {\n" +
                    "    Leaf* leaf1 = new Leaf(\"1\");\n" +
                    "    Leaf* leaf2 = new Leaf(\"2\");\n" +
                    "    Composite* composite = new Composite();\n" +
                    "    composite->add(leaf1);\n" +
                    "    composite->add(leaf2);\n" +
                    "\n" +
                    "    composite->operation();\n" +
                    "    // Output:\n" +
                    "    // Composite operation\n" +
                    "    // Leaf 1 operation\n" +
                    "    // Leaf 2 operation\n" +
                    "\n" +
                    "    delete composite;\n" +
                    "    return 0;\n" +
                    "}\n";
            case "Decorator" -> "#include <iostream>\n" +
                    "\n" +
                    "// Component interface\n" +
                    "class Component {\n" +
                    "public:\n" +
                    "    virtual void operation() const = 0;\n" +
                    "    virtual ~Component() = default;\n" +
                    "};\n" +
                    "\n" +
                    "// ConcreteComponent implementing Component interface\n" +
                    "class ConcreteComponent : public Component {\n" +
                    "public:\n" +
                    "    void operation() const override {\n" +
                    "        std::cout << \"ConcreteComponent operation\\n\";\n" +
                    "    }\n" +
                    "};\n" +
                    "\n" +
                    "// Decorator abstract class implementing Component and containing a reference to a Component\n" +
                    "class Decorator : public Component {\n" +
                    "protected:\n" +
                    "    Component* component;\n" +
                    "public:\n" +
                    "    Decorator(Component* c) : component(c) {}\n" +
                    "\n" +
                    "    void operation() const override {\n" +
                    "        component->operation();\n" +
                    "    }\n" +
                    "\n" +
                    "    virtual ~Decorator() {\n" +
                    "        delete component;\n" +
                    "    }\n" +
                    "};\n" +
                    "\n" +
                    "// ConcreteDecoratorA extending Decorator\n" +
                    "class ConcreteDecoratorA : public Decorator {\n" +
                    "public:\n" +
                    "    ConcreteDecoratorA(Component* c) : Decorator(c) {}\n" +
                    "\n" +
                    "    void operation() const override {\n" +
                    "        Decorator::operation();\n" +
                    "        addedBehavior();\n" +
                    "    }\n" +
                    "\n" +
                    "    void addedBehavior() const {\n" +
                    "        std::cout << \"ConcreteDecoratorA added behavior\\n\";\n" +
                    "    }\n" +
                    "};\n" +
                    "\n" +
                    "// ConcreteDecoratorB extending Decorator\n" +
                    "class ConcreteDecoratorB : public Decorator {\n" +
                    "public:\n" +
                    "    ConcreteDecoratorB(Component* c) : Decorator(c) {}\n" +
                    "\n" +
                    "    void operation() const override {\n" +
                    "        Decorator::operation();\n" +
                    "        addedBehavior();\n" +
                    "    }\n" +
                    "\n" +
                    "    void addedBehavior() const {\n" +
                    "        std::cout << \"ConcreteDecoratorB added behavior\\n\";\n" +
                    "    }\n" +
                    "};\n" +
                    "\n" +
                    "// Client code\n" +
                    "int main() {\n" +
                    "    Component* component = new ConcreteComponent();\n" +
                    "    Component* decoratorA = new ConcreteDecoratorA(component);\n" +
                    "    Component* decoratorB = new ConcreteDecoratorB(decoratorA);\n" +
                    "\n" +
                    "    decoratorB->operation();\n" +
                    "    // Output:\n" +
                    "    // ConcreteComponent operation\n" +
                    "    // ConcreteDecoratorA added behavior\n" +
                    "    // ConcreteDecoratorB added behavior\n" +
                    "\n" +
                    "    delete decoratorB;\n" +
                    "    return 0;\n" +
                    "}\n";
            case "Facade"  -> "#include <iostream>\n" +
                    "\n" +
                    "// Subsystem classes\n" +
                    "class Subsystem1 {\n" +
                    "public:\n" +
                    "    void operation1() const {\n" +
                    "        std::cout << \"Subsystem1 operation\\n\";\n" +
                    "    }\n" +
                    "};\n" +
                    "\n" +
                    "class Subsystem2 {\n" +
                    "public:\n" +
                    "    void operation2() const {\n" +
                    "        std::cout << \"Subsystem2 operation\\n\";\n" +
                    "    }\n" +
                    "};\n" +
                    "\n" +
                    "class Subsystem3 {\n" +
                    "public:\n" +
                    "    void operation3() const {\n" +
                    "        std::cout << \"Subsystem3 operation\\n\";\n" +
                    "    }\n" +
                    "};\n" +
                    "\n" +
                    "// Facade class\n" +
                    "class Facade {\n" +
                    "private:\n" +
                    "    Subsystem1* subsystem1;\n" +
                    "    Subsystem2* subsystem2;\n" +
                    "    Subsystem3* subsystem3;\n" +
                    "public:\n" +
                    "    Facade() {\n" +
                    "        subsystem1 = new Subsystem1();\n" +
                    "        subsystem2 = new Subsystem2();\n" +
                    "        subsystem3 = new Subsystem3();\n" +
                    "    }\n" +
                    "\n" +
                    "    void operation() const {\n" +
                    "        subsystem1->operation1();\n" +
                    "        subsystem2->operation2();\n" +
                    "        subsystem3->operation3();\n" +
                    "    }\n" +
                    "\n" +
                    "    ~Facade() {\n" +
                    "        delete subsystem1;\n" +
                    "        delete subsystem2;\n" +
                    "        delete subsystem3;\n" +
                    "    }\n" +
                    "};\n" +
                    "\n" +
                    "// Client code\n" +
                    "int main() {\n" +
                    "    Facade* facade = new Facade();\n" +
                    "    facade->operation();\n" +
                    "    // Output:\n" +
                    "    // Subsystem1 operation\n" +
                    "    // Subsystem2 operation\n" +
                    "    // Subsystem3 operation\n" +
                    "\n" +
                    "    delete facade;\n" +
                    "    return 0;\n" +
                    "}\n";
            case "Flyweight"  -> "#include <iostream>\n" +
                    "#include <unordered_map>\n" +
                    "#include <string>\n" +
                    "\n" +
                    "// Flyweight interface\n" +
                    "class Flyweight {\n" +
                    "public:\n" +
                    "    virtual void operation(const std::string& extrinsicState) const = 0;\n" +
                    "    virtual ~Flyweight() = default;\n" +
                    "};\n" +
                    "\n" +
                    "// ConcreteFlyweight class implementing Flyweight\n" +
                    "class ConcreteFlyweight : public Flyweight {\n" +
                    "private:\n" +
                    "    std::string intrinsicState;\n" +
                    "public:\n" +
                    "    ConcreteFlyweight(const std::string& state) : intrinsicState(state) {}\n" +
                    "\n" +
                    "    void operation(const std::string& extrinsicState) const override {\n" +
                    "        std::cout << \"Intrinsic State = \" << intrinsicState << \", Extrinsic State = \" << extrinsicState << '\\n';\n" +
                    "    }\n" +
                    "};\n" +
                    "\n" +
                    "// FlyweightFactory class to manage Flyweight instances\n" +
                    "class FlyweightFactory {\n" +
                    "private:\n" +
                    "    std::unordered_map<std::string, Flyweight*> flyweights;\n" +
                    "public:\n" +
                    "    Flyweight* getFlyweight(const std::string& key) {\n" +
                    "        if (flyweights.find(key) == flyweights.end()) {\n" +
                    "            flyweights[key] = new ConcreteFlyweight(key);\n" +
                    "        }\n" +
                    "        return flyweights[key];\n" +
                    "    }\n" +
                    "\n" +
                    "    int getFlyweightCount() const {\n" +
                    "        return flyweights.size();\n" +
                    "    }\n" +
                    "\n" +
                    "    ~FlyweightFactory() {\n" +
                    "        for (auto& pair : flyweights) {\n" +
                    "            delete pair.second;\n" +
                    "        }\n" +
                    "    }\n" +
                    "};\n" +
                    "\n" +
                    "// Client code\n" +
                    "int main() {\n" +
                    "    FlyweightFactory* factory = new FlyweightFactory();\n" +
                    "\n" +
                    "    Flyweight* flyweight1 = factory->getFlyweight(\"A\");\n" +
                    "    Flyweight* flyweight2 = factory->getFlyweight(\"B\");\n" +
                    "    Flyweight* flyweight3 = factory->getFlyweight(\"A\");\n" +
                    "\n" +
                    "    flyweight1->operation(\"X\");\n" +
                    "    flyweight2->operation(\"Y\");\n" +
                    "    flyweight3->operation(\"Z\");\n" +
                    "\n" +
                    "    std::cout << \"Number of flyweights created: \" << factory->getFlyweightCount() << '\\n';\n" +
                    "    // Output:\n" +
                    "    // Intrinsic State = A, Extrinsic State = X\n" +
                    "    // Intrinsic State = B, Extrinsic State = Y\n" +
                    "    // Intrinsic State = A, Extrinsic State = Z\n" +
                    "    // Number of flyweights created: 2\n" +
                    "\n" +
                    "    delete factory;\n" +
                    "    return 0;\n" +
                    "}\n";
            case "Proxy"  -> "#include <iostream>\n" +
                    "\n" +
                    "// Subject interface\n" +
                    "class Subject {\n" +
                    "public:\n" +
                    "    virtual void request() const = 0;\n" +
                    "    virtual ~Subject() = default;\n" +
                    "};\n" +
                    "\n" +
                    "// RealSubject class implementing Subject\n" +
                    "class RealSubject : public Subject {\n" +
                    "public:\n" +
                    "    void request() const override {\n" +
                    "        std::cout << \"RealSubject request\\n\";\n" +
                    "    }\n" +
                    "};\n" +
                    "\n" +
                    "// Proxy class implementing Subject and containing a reference to RealSubject\n" +
                    "class Proxy : public Subject {\n" +
                    "private:\n" +
                    "    RealSubject* realSubject;\n" +
                    "public:\n" +
                    "    Proxy() : realSubject(nullptr) {}\n" +
                    "\n" +
                    "    void request() const override {\n" +
                    "        if (realSubject == nullptr) {\n" +
                    "            realSubject = new RealSubject();\n" +
                    "        }\n" +
                    "        realSubject->request();\n" +
                    "    }\n" +
                    "\n" +
                    "    ~Proxy() {\n" +
                    "        delete realSubject;\n" +
                    "    }\n" +
                    "};\n" +
                    "\n" +
                    "// Client code\n" +
                    "int main() {\n" +
                    "    Subject* proxy = new Proxy();\n" +
                    "    proxy->request();  // Output: RealSubject request\n" +
                    "\n" +
                    "    delete proxy;\n" +
                    "    return 0;\n" +
                    "}\n";
            // More cases...
            default -> "Error for load code";
        };
    }

    public static String getCodeCSFromNameStructuralPattern(String pattern) {
        return switch (pattern) {
            case "Adapter" -> "using System;\n" +
                    "\n" +
                    "// The Target interface which the client expects to use\n" +
                    "public interface ITarget\n" +
                    "{\n" +
                    "    void Request();\n" +
                    "}\n" +
                    "\n" +
                    "// The Adaptee class with an existing interface that needs adapting\n" +
                    "public class Adaptee\n" +
                    "{\n" +
                    "    public void SpecificRequest()\n" +
                    "    {\n" +
                    "        Console.WriteLine(\"Specific request from Adaptee\");\n" +
                    "    }\n" +
                    "}\n" +
                    "\n" +
                    "// The Adapter class that implements the Target interface and adapts the Adaptee\n" +
                    "public class Adapter : ITarget\n" +
                    "{\n" +
                    "    private readonly Adaptee adaptee;\n" +
                    "\n" +
                    "    public Adapter(Adaptee adaptee)\n" +
                    "    {\n" +
                    "        this.adaptee = adaptee;\n" +
                    "    }\n" +
                    "\n" +
                    "    public void Request()\n" +
                    "    {\n" +
                    "        // Translate the request to a method that Adaptee understands\n" +
                    "        adaptee.SpecificRequest();\n" +
                    "    }\n" +
                    "}\n" +
                    "\n" +
                    "// Client code\n" +
                    "class Program\n" +
                    "{\n" +
                    "    static void Main(string[] args)\n" +
                    "    {\n" +
                    "        Adaptee adaptee = new Adaptee();\n" +
                    "        ITarget target = new Adapter(adaptee);\n" +
                    "        target.Request();  // Output: Specific request from Adaptee\n" +
                    "    }\n" +
                    "}\n";
            case "Bridge" -> "using System;\n" +
                    "\n" +
                    "// Implementor interface with method to be implemented by concrete implementors\n" +
                    "public interface IImplementor\n" +
                    "{\n" +
                    "    void OperationImpl();\n" +
                    "}\n" +
                    "\n" +
                    "// Concrete Implementors implementing the Implementor interface\n" +
                    "public class ConcreteImplementorA : IImplementor\n" +
                    "{\n" +
                    "    public void OperationImpl()\n" +
                    "    {\n" +
                    "        Console.WriteLine(\"ConcreteImplementorA operation\");\n" +
                    "    }\n" +
                    "}\n" +
                    "\n" +
                    "public class ConcreteImplementorB : IImplementor\n" +
                    "{\n" +
                    "    public void OperationImpl()\n" +
                    "    {\n" +
                    "        Console.WriteLine(\"ConcreteImplementorB operation\");\n" +
                    "    }\n" +
                    "}\n" +
                    "\n" +
                    "// Abstraction class with a reference to an Implementor\n" +
                    "public abstract class Abstraction\n" +
                    "{\n" +
                    "    protected readonly IImplementor implementor;\n" +
                    "\n" +
                    "    protected Abstraction(IImplementor implementor)\n" +
                    "    {\n" +
                    "        this.implementor = implementor;\n" +
                    "    }\n" +
                    "\n" +
                    "    public abstract void Operation();\n" +
                    "}\n" +
                    "\n" +
                    "// RefinedAbstraction class extending Abstraction\n" +
                    "public class RefinedAbstraction : Abstraction\n" +
                    "{\n" +
                    "    public RefinedAbstraction(IImplementor implementor) : base(implementor)\n" +
                    "    {\n" +
                    "    }\n" +
                    "\n" +
                    "    public override void Operation()\n" +
                    "    {\n" +
                    "        Console.Write(\"RefinedAbstraction operation with \");\n" +
                    "        implementor.OperationImpl();\n" +
                    "    }\n" +
                    "}\n" +
                    "\n" +
                    "// Client code\n" +
                    "class Program\n" +
                    "{\n" +
                    "    static void Main(string[] args)\n" +
                    "    {\n" +
                    "        IImplementor implementorA = new ConcreteImplementorA();\n" +
                    "        Abstraction abstractionA = new RefinedAbstraction(implementorA);\n" +
                    "        abstractionA.Operation();  // Output: RefinedAbstraction operation with ConcreteImplementorA operation\n" +
                    "\n" +
                    "        IImplementor implementorB = new ConcreteImplementorB();\n" +
                    "        Abstraction abstractionB = new RefinedAbstraction(implementorB);\n" +
                    "        abstractionB.Operation();  // Output: RefinedAbstraction operation with ConcreteImplementorB operation\n" +
                    "    }\n" +
                    "}\n";
            case "Composite" -> "using System;\n" +
                    "using System.Collections.Generic;\n" +
                    "\n" +
                    "// Component interface\n" +
                    "public interface IComponent\n" +
                    "{\n" +
                    "    void Operation();\n" +
                    "}\n" +
                    "\n" +
                    "// Leaf class implementing Component interface\n" +
                    "public class Leaf : IComponent\n" +
                    "{\n" +
                    "    private readonly string name;\n" +
                    "\n" +
                    "    public Leaf(string name)\n" +
                    "    {\n" +
                    "        this.name = name;\n" +
                    "    }\n" +
                    "\n" +
                    "    public void Operation()\n" +
                    "    {\n" +
                    "        Console.WriteLine($\"Leaf {name} operation\");\n" +
                    "    }\n" +
                    "}\n" +
                    "\n" +
                    "// Composite class implementing Component interface and containing children\n" +
                    "public class Composite : IComponent\n" +
                    "{\n" +
                    "    private readonly List<IComponent> children = new List<IComponent>();\n" +
                    "\n" +
                    "    public void Add(IComponent component)\n" +
                    "    {\n" +
                    "        children.Add(component);\n" +
                    "    }\n" +
                    "\n" +
                    "    public void Remove(IComponent component)\n" +
                    "    {\n" +
                    "        children.Remove(component);\n" +
                    "    }\n" +
                    "\n" +
                    "    public void Operation()\n" +
                    "    {\n" +
                    "        Console.WriteLine(\"Composite operation\");\n" +
                    "        foreach (var child in children)\n" +
                    "        {\n" +
                    "            child.Operation();\n" +
                    "        }\n" +
                    "    }\n" +
                    "}\n" +
                    "\n" +
                    "// Client code\n" +
                    "class Program\n" +
                    "{\n" +
                    "    static void Main(string[] args)\n" +
                    "    {\n" +
                    "        Leaf leaf1 = new Leaf(\"1\");\n" +
                    "        Leaf leaf2 = new Leaf(\"2\");\n" +
                    "        Composite composite = new Composite();\n" +
                    "        composite.Add(leaf1);\n" +
                    "        composite.Add(leaf2);\n" +
                    "\n" +
                    "        composite.Operation();\n" +
                    "        // Output:\n" +
                    "        // Composite operation\n" +
                    "        // Leaf 1 operation\n" +
                    "        // Leaf 2 operation\n" +
                    "    }\n" +
                    "}\n";
            case "Decorator" -> "using System;\n" +
                    "\n" +
                    "// Component interface\n" +
                    "public interface IComponent\n" +
                    "{\n" +
                    "    void Operation();\n" +
                    "}\n" +
                    "\n" +
                    "// ConcreteComponent implementing Component interface\n" +
                    "public class ConcreteComponent : IComponent\n" +
                    "{\n" +
                    "    public void Operation()\n" +
                    "    {\n" +
                    "        Console.WriteLine(\"ConcreteComponent operation\");\n" +
                    "    }\n" +
                    "}\n" +
                    "\n" +
                    "// Decorator abstract class implementing Component and containing a reference to a Component\n" +
                    "public abstract class Decorator : IComponent\n" +
                    "{\n" +
                    "    protected readonly IComponent component;\n" +
                    "\n" +
                    "    protected Decorator(IComponent component)\n" +
                    "    {\n" +
                    "        this.component = component;\n" +
                    "    }\n" +
                    "\n" +
                    "    public virtual void Operation()\n" +
                    "    {\n" +
                    "        component.Operation();\n" +
                    "    }\n" +
                    "}\n" +
                    "\n" +
                    "// ConcreteDecoratorA extending Decorator\n" +
                    "public class ConcreteDecoratorA : Decorator\n" +
                    "{\n" +
                    "    public ConcreteDecoratorA(IComponent component) : base(component)\n" +
                    "    {\n" +
                    "    }\n" +
                    "\n" +
                    "    public override void Operation()\n" +
                    "    {\n" +
                    "        base.Operation();\n" +
                    "        AddedBehavior();\n" +
                    "    }\n" +
                    "\n" +
                    "    private void AddedBehavior()\n" +
                    "    {\n" +
                    "        Console.WriteLine(\"ConcreteDecoratorA added behavior\");\n" +
                    "    }\n" +
                    "}\n" +
                    "\n" +
                    "// ConcreteDecoratorB extending Decorator\n" +
                    "public class ConcreteDecoratorB : Decorator\n" +
                    "{\n" +
                    "    public ConcreteDecoratorB(IComponent component) : base(component)\n" +
                    "    {\n" +
                    "    }\n" +
                    "\n" +
                    "    public override void Operation()\n" +
                    "    {\n" +
                    "        base.Operation();\n" +
                    "        AddedBehavior();\n" +
                    "    }\n" +
                    "\n" +
                    "    private void AddedBehavior()\n" +
                    "    {\n" +
                    "        Console.WriteLine(\"ConcreteDecoratorB added behavior\");\n" +
                    "    }\n" +
                    "}\n" +
                    "\n" +
                    "// Client code\n" +
                    "class Program\n" +
                    "{\n" +
                    "    static void Main(string[] args)\n" +
                    "    {\n" +
                    "        IComponent component = new ConcreteComponent();\n" +
                    "        IComponent decoratorA = new ConcreteDecoratorA(component);\n" +
                    "        IComponent decoratorB = new ConcreteDecoratorB(decoratorA);\n" +
                    "\n" +
                    "        decoratorB.Operation();\n" +
                    "        // Output:\n" +
                    "        // ConcreteComponent operation\n" +
                    "        // ConcreteDecoratorA added behavior\n" +
                    "        // ConcreteDecoratorB added behavior\n" +
                    "    }\n" +
                    "}\n";
            case "Facade"  -> "using System;\n" +
                    "\n" +
                    "// Subsystem classes\n" +
                    "public class Subsystem1\n" +
                    "{\n" +
                    "    public void Operation1()\n" +
                    "    {\n" +
                    "        Console.WriteLine(\"Subsystem1 operation\");\n" +
                    "    }\n" +
                    "}\n" +
                    "\n" +
                    "public class Subsystem2\n" +
                    "{\n" +
                    "    public void Operation2()\n" +
                    "    {\n" +
                    "        Console.WriteLine(\"Subsystem2 operation\");\n" +
                    "    }\n" +
                    "}\n" +
                    "\n" +
                    "public class Subsystem3\n" +
                    "{\n" +
                    "    public void Operation3()\n" +
                    "    {\n" +
                    "        Console.WriteLine(\"Subsystem3 operation\");\n" +
                    "    }\n" +
                    "}\n" +
                    "\n" +
                    "// Facade class\n" +
                    "public class Facade\n" +
                    "{\n" +
                    "    private readonly Subsystem1 subsystem1;\n" +
                    "    private readonly Subsystem2 subsystem2;\n" +
                    "    private readonly Subsystem3 subsystem3;\n" +
                    "\n" +
                    "    public Facade()\n" +
                    "    {\n" +
                    "        subsystem1 = new Subsystem1();\n" +
                    "        subsystem2 = new Subsystem2();\n" +
                    "        subsystem3 = new Subsystem3();\n" +
                    "    }\n" +
                    "\n" +
                    "    public void Operation()\n" +
                    "    {\n" +
                    "        subsystem1.Operation1();\n" +
                    "        subsystem2.Operation2();\n" +
                    "        subsystem3.Operation3();\n" +
                    "    }\n" +
                    "}\n" +
                    "\n" +
                    "// Client code\n" +
                    "class Program\n" +
                    "{\n" +
                    "    static void Main(string[] args)\n" +
                    "    {\n" +
                    "        Facade facade = new Facade();\n" +
                    "        facade.Operation();\n" +
                    "        // Output:\n" +
                    "        // Subsystem1 operation\n" +
                    "        // Subsystem2 operation\n" +
                    "        // Subsystem3 operation\n" +
                    "    }\n" +
                    "}\n";
            case "Flyweight"  -> "using System;\n" +
                    "using System.Collections.Generic;\n" +
                    "\n" +
                    "// Flyweight interface\n" +
                    "public interface IFlyweight\n" +
                    "{\n" +
                    "    void Operation(string extrinsicState);\n" +
                    "}\n" +
                    "\n" +
                    "// ConcreteFlyweight class implementing Flyweight\n" +
                    "public class ConcreteFlyweight : IFlyweight\n" +
                    "{\n" +
                    "    private readonly string intrinsicState;\n" +
                    "\n" +
                    "    public ConcreteFlyweight(string intrinsicState)\n" +
                    "    {\n" +
                    "        this.intrinsicState = intrinsicState;\n" +
                    "    }\n" +
                    "\n" +
                    "    public void Operation(string extrinsicState)\n" +
                    "    {\n" +
                    "        Console.WriteLine($\"Intrinsic State = {intrinsicState}, Extrinsic State = {extrinsicState}\");\n" +
                    "    }\n" +
                    "}\n" +
                    "\n" +
                    "// FlyweightFactory class to manage Flyweight instances\n" +
                    "public class FlyweightFactory\n" +
                    "{\n" +
                    "    private readonly Dictionary<string, IFlyweight> flyweights = new Dictionary<string, IFlyweight>();\n" +
                    "\n" +
                    "    public IFlyweight GetFlyweight(string key)\n" +
                    "    {\n" +
                    "        if (!flyweights.ContainsKey(key))\n" +
                    "        {\n" +
                    "            flyweights[key] = new ConcreteFlyweight(key);\n" +
                    "        }\n" +
                    "        return flyweights[key];\n" +
                    "    }\n" +
                    "\n" +
                    "    public int GetFlyweightCount()\n" +
                    "    {\n" +
                    "        return flyweights.Count;\n" +
                    "    }\n" +
                    "}\n" +
                    "\n" +
                    "// Client code\n" +
                    "class Program\n" +
                    "{\n" +
                    "    static void Main(string[] args)\n" +
                    "    {\n" +
                    "        FlyweightFactory factory = new FlyweightFactory();\n" +
                    "\n" +
                    "        IFlyweight flyweight1 = factory.GetFlyweight(\"A\");\n" +
                    "        IFlyweight flyweight2 = factory.GetFlyweight(\"B\");\n" +
                    "        IFlyweight flyweight3 = factory.GetFlyweight(\"A\");\n" +
                    "\n" +
                    "        flyweight1.Operation(\"X\");\n" +
                    "        flyweight2.Operation(\"Y\");\n" +
                    "        flyweight3.Operation(\"Z\");\n" +
                    "\n" +
                    "        Console.WriteLine($\"Number of flyweights created: {factory.GetFlyweightCount()}\");\n" +
                    "        // Output:\n" +
                    "        // Intrinsic State = A, Extrinsic State = X\n" +
                    "        // Intrinsic State = B, Extrinsic State = Y\n" +
                    "        // Intrinsic State = A, Extrinsic State = Z\n" +
                    "        // Number of flyweights created: 2\n" +
                    "    }\n" +
                    "}\n";
            case "Proxy"  -> "using System;\n" +
                    "\n" +
                    "// Subject interface\n" +
                    "public interface ISubject\n" +
                    "{\n" +
                    "    void Request();\n" +
                    "}\n" +
                    "\n" +
                    "// RealSubject class implementing Subject\n" +
                    "public class RealSubject : ISubject\n" +
                    "{\n" +
                    "    public void Request()\n" +
                    "    {\n" +
                    "        Console.WriteLine(\"RealSubject request\");\n" +
                    "    }\n" +
                    "}\n" +
                    "\n" +
                    "// Proxy class implementing Subject and containing a reference to RealSubject\n" +
                    "public class Proxy : ISubject\n" +
                    "{\n" +
                    "    private RealSubject realSubject;\n" +
                    "\n" +
                    "    public void Request()\n" +
                    "    {\n" +
                    "        if (realSubject == null)\n" +
                    "        {\n" +
                    "            realSubject = new RealSubject();\n" +
                    "        }\n" +
                    "        realSubject.Request();\n" +
                    "    }\n" +
                    "}\n" +
                    "\n" +
                    "// Client code\n" +
                    "class Program\n" +
                    "{\n" +
                    "    static void Main(string[] args)\n" +
                    "    {\n" +
                    "        ISubject proxy = new Proxy();\n" +
                    "        proxy.Request();  // Output: RealSubject request\n" +
                    "    }\n" +
                    "}\n";
            // More cases...
            default -> "Error for load code";
        };
    }


}
