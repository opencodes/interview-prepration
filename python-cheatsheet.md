# 🐍 Python Cheatsheet

## 1. **Arrays / Lists**

```python
# Creation
arr = [1, 2, 3, 4]

# Basic operations
arr.append(5)       # Add element
arr.pop()           # Remove last
arr.insert(1, 10)   # Insert at index
arr.remove(3)       # Remove first occurrence
arr.index(10)       # Find index
arr.sort()          # Sort in-place
arr.reverse()       # Reverse in-place

# Slicing
sub = arr[1:4]      # Slice
arr[::-1]           # Reverse

# Iteration
for x in arr:
    print(x)

# List comprehension
squares = [x*x for x in arr if x % 2 == 0]
```

---

## 2. **Strings**

```python
s = "hello world"

# Access
s[0], s[-1]         # 'h', 'd'

# Slicing
s[0:5]              # 'hello'
s[::-1]             # 'dlrow olleh'

# Common methods
s.upper()           # HELLO WORLD
s.lower()           # hello world
s.title()           # Hello World
s.split()           # ['hello', 'world']
'-'.join(['a','b']) # 'a-b'
s.find("world")     # 6
s.replace("world","DSA") # 'hello DSA'

# Check
s.isdigit(), s.isalpha(), s.isalnum()
```

---

## 3. **HashMap / Dictionary**

```python
# Creation
mp = {"a":1, "b":2}

# Access
mp["a"]            # 1
mp.get("c", 0)     # 0 if not present

# Insert / Update
mp["c"] = 3

# Delete
del mp["a"]

# Iteration
for k,v in mp.items():
    print(k, v)

# Check key existence
if "b" in mp:
    print("found")

# Counter (frequency map)
from collections import Counter
freq = Counter("mississippi")  # {'i':4, 's':4, 'p':2, 'm':1}
```

---

## 4. **Stack (LIFO)**

```python
stack = []
stack.append(1)   # Push
stack.append(2)
stack.pop()       # Pop -> 2
stack[-1]         # Peek -> 1
```

---

## 5. **Queue (FIFO)**

```python
from collections import deque

# Queue
q = deque()
q.append(1)       # Enqueue
q.append(2)
q.popleft()       # Dequeue -> 1
q[0]              # Peek front

# Priority Queue / Min Heap
import heapq
heap = []
heapq.heappush(heap, 3)
heapq.heappush(heap, 1)
heapq.heappush(heap, 2)
heapq.heappop(heap)   # 1 (smallest)
```

---

## 6. **Functions Basics**

```python
# Simple function
def add(a, b):
    return a + b

print(add(2, 3))   # 5

# Default arguments
def greet(name="User"):
    return f"Hello, {name}"

print(greet())        # Hello, User
print(greet("Raj"))   # Hello, Raj

# Keyword & positional arguments
def power(base, exp=2):
    return base ** exp

print(power(3))        # 9 (default exp=2)
print(power(3, 3))     # 27
print(power(exp=4, base=2)) # 16

# Variable arguments (*args, **kwargs)
def my_func(*args, **kwargs):
    print("args:", args)       # tuple
    print("kwargs:", kwargs)   # dict

my_func(1,2,3, x=10, y=20)
# args: (1, 2, 3)
# kwargs: {'x': 10, 'y': 20}

# Lambda (inline function)
square = lambda x: x * x
print(square(5))  # 25
```

---

## 7. **Classes Basics**

```python
# Define a class
class Person:
    # Constructor
    def __init__(self, name, age):
        self.name = name    # instance variable
        self.age = age
    
    # Instance method
    def greet(self):
        return f"Hi, I'm {self.name}, age {self.age}"

p1 = Person("Alice", 25)
print(p1.greet())  # Hi, I'm Alice, age 25
```

---

## 8. **Class vs Instance Variables**

```python
class Counter:
    count = 0   # class variable (shared by all instances)

    def __init__(self):
        Counter.count += 1

c1 = Counter()
c2 = Counter()
print(Counter.count)  # 2
```

---

## 9. **Static & Class Methods**

```python
class MathUtils:
    @staticmethod
    def add(a, b):
        return a + b
    
    @classmethod
    def description(cls):
        return f"This is {cls.__name__} class"

print(MathUtils.add(2,3))        # 5
print(MathUtils.description())   # This is MathUtils class
```

---

## 10. **Inheritance**

```python
class Animal:
    def speak(self):
        return "Some sound"

class Dog(Animal):
    def speak(self):
        return "Woof!"

d = Dog()
print(d.speak())  # Woof!
```

---

## 11. **Encapsulation & Private Variables**

```python
class BankAccount:
    def __init__(self, balance):
        self.__balance = balance   # private variable
    
    def deposit(self, amount):
        self.__balance += amount
    
    def get_balance(self):
        return self.__balance

acc = BankAccount(1000)
acc.deposit(500)
print(acc.get_balance())  # 1500
```

---

## 12. **Abstract Class & Interface (via `abc`)**

Python doesn’t have “interface” keyword, but **abstract base classes (ABC)** act like interfaces.

```python
from abc import ABC, abstractmethod

class Shape(ABC):             # Abstract class
    @abstractmethod
    def area(self): pass       # Must implement
    
    @abstractmethod
    def perimeter(self): pass

class Circle(Shape):           # Concrete class
    def __init__(self, r):
        self.r = r
    
    def area(self):
        return 3.14 * self.r * self.r
    
    def perimeter(self):
        return 2 * 3.14 * self.r

c = Circle(5)
print(c.area())      # 78.5
```

✅ **Use Case in DSA**:

* Interfaces for **Strategy pattern** (e.g., different graph traversals).
* Enforcing structure in **Tree/Graph node classes**.

---

## 13. **Enum (enumerations)**

```python
from enum import Enum, auto

class Color(Enum):
    RED = auto()
    GREEN = auto()
    BLUE = auto()

print(Color.RED)        # Color.RED
print(Color.RED.name)   # RED
print(Color.RED.value)  # 1 (auto assigned)
```

✅ **Use Case in DSA**:

* Directions in matrix problems (`UP, DOWN, LEFT, RIGHT`)
* State machines (e.g., visited, processing, completed).

---

## 14. **Dataclass (cleaner class syntax)**

```python
from dataclasses import dataclass

@dataclass
class Point:
    x: int
    y: int

p1 = Point(1, 2)
print(p1)  # Point(x=1, y=2)
```

✅ **Use Case**:

* Cleaner code for nodes (Tree, Graph, Linked List).

---

## 15. **NamedTuple (immutable lightweight class)**

```python
from collections import namedtuple

Point = namedtuple("Point", ["x", "y"])
p = Point(3, 4)
print(p.x, p.y)  # 3 4
```

✅ **Use Case**:

* Efficient representation of nodes, coordinates, edges.

---

## 16. **Iterators & Generators**

```python
# Iterator
nums = iter([1, 2, 3])
print(next(nums))  # 1
print(next(nums))  # 2

# Generator (lazy evaluation)
def countdown(n):
    while n > 0:
        yield n
        n -= 1

for i in countdown(3):
    print(i)   # 3, 2, 1
```

✅ **Use Case**:

* Generating permutations/combinations lazily.
* Streaming BFS/DFS without storing all states.

---

## 17. **Context Managers (`with`)**

```python
# File handling
with open("data.txt", "w") as f:
    f.write("Hello")

# Custom context manager
class MyContext:
    def __enter__(self):
        print("Start")
        return self
    def __exit__(self, exc_type, exc_val, exc_tb):
        print("End")

with MyContext():
    print("Inside block")
```
 
 

## 18. **Object Serialization / Deserialization**

### Using `pickle` (Python objects → bytes)

```python
import pickle

# Serialize (object → bytes)
data = {"name": "Alice", "age": 25, "skills": ["Python", "DSA"]}
serialized = pickle.dumps(data)

# Deserialize (bytes → object)
restored = pickle.loads(serialized)
print(restored)  # {'name': 'Alice', 'age': 25, 'skills': ['Python', 'DSA']}

# Save to file
with open("data.pkl", "wb") as f:
    pickle.dump(data, f)

# Load from file
with open("data.pkl", "rb") as f:
    obj = pickle.load(f)
```

---

### Using `json` (for cross-language compatibility)

```python
import json

# Serialize (object → JSON string)
person = {"name": "Bob", "age": 30, "skills": ["Java", "DSA"]}
json_str = json.dumps(person)

# Deserialize (JSON string → object)
obj = json.loads(json_str)
print(obj)   # {'name': 'Bob', 'age': 30, 'skills': ['Java', 'DSA']}

# Save to file
with open("data.json", "w") as f:
    json.dump(person, f)

# Load from file
with open("data.json", "r") as f:
    obj = json.load(f)
```

 