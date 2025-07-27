Here's a **Core Java + Java 8+ Features Cheat Sheet** with concise explanations, organized for quick revision:

---

## ✅ **Core Java Concepts**

### 1. **OOP Principles**
- **Encapsulation**: Hiding internal details, exposing only required parts via getters/setters.
```java
public class Person {
    private String name;
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
}
```
- **Abstraction**: Hiding implementation via interfaces or abstract classes.
```java
abstract class Animal {
    abstract void makeSound();
}
```
- **Inheritance**: One class inherits properties of another (`extends`, `implements`).
```java
class Dog extends Animal {
    void makeSound() { System.out.println("Bark"); }
}
```
- **Polymorphism**: Many forms — method overloading & overriding.
```java
class Calc {
    int add(int a, int b) { return a + b; } // overloading
    double add(double a, double b) { return a + b; }
}
```

### 2. **Data Types**
- **Primitive**: `int`, `float`, `char`, `boolean`, etc.
```java
int age = 30;
char grade = 'A';
```
- **Non-primitive**: Arrays, Strings, Classes, Interfaces.
```java
String name = "Java";
int[] numbers = {1, 2, 3};
```

### 3. **Control Statements**

#### `if-else`
```java
int a = 10, b = 20;
if (a > b) {
    System.out.println("A is greater");
} else {
    System.out.println("B is greater");
}
```

#### `switch-case`
```java
int day = 2;
switch (day) {
    case 1: System.out.println("Monday"); break;
    case 2: System.out.println("Tuesday"); break;
    default: System.out.println("Other day");
}
```

#### `for loop`
```java
for (int i = 0; i < 5; i++) {
    System.out.println(i);
}
```

#### `while loop`
```java
int i = 0;
while (i < 5) {
    System.out.println(i);
    i++;
}
```

#### `do-while`
```java
int j = 0;
do {
    System.out.println(j);
    j++;
} while (j < 5);
```

#### `break` and `continue`
```java
for (int k = 0; k < 5; k++) {
    if (k == 3) continue;
    if (k == 4) break;
    System.out.println(k);
}
```

### 4. **Exception Handling**
```java
try {
  int x = 5 / 0;
} catch (ArithmeticException e) {
  System.out.println("Cannot divide by zero");
} finally {
  System.out.println("Cleanup");
}
```

### 5. **Collections Framework**

#### List (Ordered, allows duplicates)
```java
List<String> list = new ArrayList<>();
list.add("Apple");
list.add("Banana");
list.add("Apple"); // duplicate allowed
System.out.println(list);
System.out.println("Size: " + list.size());
System.out.println("Element at index 1: " + list.get(1));
list.remove("Apple"); // removes first occurrence
System.out.println("Contains Banana? " + list.contains("Banana"));
```

#### Set (Unordered, no duplicates)
```java
Set<Integer> set = new HashSet<>();
set.add(10);
set.add(20);
set.add(10); // duplicate ignored
System.out.println(set);
System.out.println("Contains 20? " + set.contains(20));
set.remove(10);
System.out.println("Size: " + set.size());
```

#### Map (Key-Value pairs)
```java
Map<String, Integer> map = new HashMap<>();
map.put("Math", 90);
map.put("Science", 95);
map.put("Math", 85); // overrides value
System.out.println(map);
System.out.println("Value for Math: " + map.get("Math"));
System.out.println("Contains key Science? " + map.containsKey("Science"));
map.remove("Science");
System.out.println("Size: " + map.size());
```

#### Queue (FIFO)
```java
Queue<String> queue = new LinkedList<>();
queue.offer("A");
queue.offer("B");
System.out.println(queue.poll()); // outputs A
System.out.println(queue);
System.out.println("Peek: " + queue.peek());
System.out.println("Is Empty? " + queue.isEmpty());
```

### 6. **Threads & Concurrency**
```java
Thread t = new Thread(() -> System.out.println("Running in thread"));
t.start();
```

---

## 🚀 **Java 8+ Features (Highlights)**

### 1. **Lambda Expressions**
Concise way to represent functional interfaces.
```java
(int x, int y) -> x + y
```

### 2. **Functional Interfaces**
Interfaces with a single abstract method.
```java
@FunctionalInterface
interface MyFunc {
    int operate(int x, int y);
}
```

### 3. **Streams API**
Process collections in a functional style (map/filter/reduce).
```java
List<Integer> list = Arrays.asList(5, 10, 15);
List<Integer> doubled = list.stream()
    .filter(x -> x > 10)
    .map(x -> x * 2)
    .collect(Collectors.toList());
```

### 4. **Method References**
Shorthand for lambda calling existing method:
```java
list.forEach(System.out::println);
```

### 5. **Default & Static Methods in Interfaces**
```java
interface MyInterface {
    default void show() {
        System.out.println("Default method");
    }
    static void utility() {
        System.out.println("Static method");
    }
}
```

### 6. **Optional Class**
Avoid `null` checks, prevent `NullPointerException`.
```java
Optional<String> name = Optional.ofNullable("Java");
name.ifPresent(System.out::println);
String val = name.orElse("default");
```

### 7. **Date and Time API (java.time)**
Immutable and thread-safe:
```java
LocalDate today = LocalDate.now();
LocalDate future = today.plusDays(10);
LocalDateTime now = LocalDateTime.now();
```

### 8. **Nashorn JavaScript Engine** (Deprecated in Java 15)
```java
ScriptEngine engine = new ScriptEngineManager().getEngineByName("nashorn");
engine.eval("print('Hello from JS')");
```

### 9. **Streams Parallelization**
Use `.parallelStream()` for multicore parallel operations:
```java
list.parallelStream().forEach(System.out::println);
```

---

## 🔧 Bonus Java 9+ Features (Just a Glimpse)
| Version | Feature |
|--------|---------|
| Java 9 | JShell (REPL), Module System |
| Java 10 | `var` keyword |
| Java 11 | String methods (`isBlank()`, `lines()`), HTTP Client |
| Java 14 | `record` (Data class) |
| Java 17 | Sealed classes |

---

Let me know if you'd like **PDF/Flashcards** of this or detailed examples on any part.