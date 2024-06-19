package com.example.demo.CodeExample;

public class CodeExampleCreationalPattern {

    public static String getCodeJavaByNameCreationalPattern(String pattern) {
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
    public static String getCodePythonFromNameCreationalPattern(String pattern) {
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

    public static String getCodeCPPFromNameCreationalPattern(String pattern) {
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
    public static String getCodeCSFromNameCreationalPattern(String pattern) {
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
