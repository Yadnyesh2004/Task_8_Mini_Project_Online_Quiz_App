# Java Interview Questions - Quick Revision Guide

## 1. What are Java loops?

**Definition:** Loops are control structures that execute a block of code repeatedly until a condition is met.

**Types of Loops:**

**a) for loop:**
```java
for (int i = 0; i < 5; i++) {
    System.out.println(i);
}
```
- Used when number of iterations is known
- Has initialization, condition, and increment/decrement

**b) while loop:**
```java
int i = 0;
while (i < 5) {
    System.out.println(i);
    i++;
}
```
- Checks condition before execution
- Used when iterations are unknown

**c) do-while loop:**
```java
int i = 0;
do {
    System.out.println(i);
    i++;
} while (i < 5);
```
- Executes at least once (condition checked after)
- Guarantees minimum one execution

---

## 2. What is enhanced for-loop?

**Definition:** Also called "for-each loop" - simplified way to iterate through arrays and collections.

**Syntax:**
```java
for (dataType element : array/collection) {
    // use element
}
```

**Example:**
```java
String[] names = {"John", "Alice", "Bob"};
for (String name : names) {
    System.out.println(name);
}
```

**Benefits:**
- More readable and concise
- No need for index variable
- Reduces errors (no ArrayIndexOutOfBounds)

**Limitation:**
- Cannot modify array elements
- Cannot access index during iteration
- Only forward iteration

---

## 3. How do you handle multiple user inputs?

**Method 1: Using Scanner with Loop**
```java
Scanner scanner = new Scanner(System.in);
String[] inputs = new String[5];

for (int i = 0; i < 5; i++) {
    System.out.print("Enter input " + (i+1) + ": ");
    inputs[i] = scanner.nextLine();
}
```

**Method 2: Continuous Input Until Condition**
```java
Scanner scanner = new Scanner(System.in);
List<String> inputs = new ArrayList<>();

while (true) {
    System.out.print("Enter input (or 'quit' to stop): ");
    String input = scanner.nextLine();
    if (input.equals("quit")) break;
    inputs.add(input);
}
```

**Method 3: Different Data Types**
```java
Scanner scanner = new Scanner(System.in);

System.out.print("Enter name: ");
String name = scanner.nextLine();

System.out.print("Enter age: ");
int age = scanner.nextInt();

System.out.print("Enter salary: ");
double salary = scanner.nextDouble();
```

**Key Points:**
- Use `scanner.nextLine()` for strings
- Use `scanner.nextInt()` for integers
- Use `scanner.nextDouble()` for decimals
- Always handle `InputMismatchException`

---

## 4. How is switch-case different from if-else?

**switch-case:**
```java
int day = 3;
switch (day) {
    case 1:
        System.out.println("Monday");
        break;
    case 2:
        System.out.println("Tuesday");
        break;
    case 3:
        System.out.println("Wednesday");
        break;
    default:
        System.out.println("Invalid day");
}
```

**if-else:**
```java
int day = 3;
if (day == 1) {
    System.out.println("Monday");
} else if (day == 2) {
    System.out.println("Tuesday");
} else if (day == 3) {
    System.out.println("Wednesday");
} else {
    System.out.println("Invalid day");
}
```

**Key Differences:**

| Feature | switch-case | if-else |
|---------|-------------|---------|
| **Comparison** | Only equality (==) | Any condition (>, <, !=, etc.) |
| **Data Types** | byte, short, int, char, String, enum | Any boolean expression |
| **Readability** | More readable for multiple equality checks | Better for complex conditions |
| **Performance** | Faster (jump table) | Slower (sequential checking) |
| **Multiple Conditions** | No | Yes (&&, \|\|) |
| **Range Checking** | Not possible | Possible |
| **Break Required** | Yes (prevents fall-through) | No |

**When to Use:**
- **switch-case**: Multiple equality checks on same variable
- **if-else**: Complex conditions, ranges, multiple variables

---

## 5. What are collections in Java?

**Definition:** Collections are frameworks that provide classes and interfaces to store and manipulate groups of objects.

**Collection Hierarchy:**
```
Collection (Interface)
├── List (Interface)
│   ├── ArrayList
│   ├── LinkedList
│   └── Vector
├── Set (Interface)
│   ├── HashSet
│   ├── LinkedHashSet
│   └── TreeSet
└── Queue (Interface)
    ├── PriorityQueue
    └── LinkedList

Map (Interface) - Separate hierarchy
├── HashMap
├── LinkedHashMap
├── TreeMap
└── Hashtable
```

**Main Interfaces:**

**1. List** - Ordered, allows duplicates
```java
List<String> list = new ArrayList<>();
list.add("Apple");
list.add("Banana");
list.add("Apple"); // duplicates allowed
```

**2. Set** - Unordered, no duplicates
```java
Set<String> set = new HashSet<>();
set.add("Apple");
set.add("Banana");
set.add("Apple"); // duplicate ignored
```

**3. Queue** - FIFO (First In First Out)
```java
Queue<String> queue = new LinkedList<>();
queue.offer("First");
queue.offer("Second");
queue.poll(); // removes "First"
```

**4. Map** - Key-value pairs
```java
Map<String, Integer> map = new HashMap<>();
map.put("Apple", 10);
map.put("Banana", 20);
```

**Benefits:**
- Dynamic sizing
- Built-in methods for manipulation
- Type-safe (with generics)
- Better performance algorithms

---

## 6. What is ArrayList?

**Definition:** ArrayList is a resizable array implementation of the List interface.

**Declaration:**
```java
ArrayList<DataType> list = new ArrayList<>();
```

**Common Operations:**

**1. Adding Elements:**
```java
ArrayList<String> fruits = new ArrayList<>();
fruits.add("Apple");           // Add at end
fruits.add(0, "Mango");       // Add at specific index
```

**2. Accessing Elements:**
```java
String fruit = fruits.get(0);  // Get by index
```

**3. Removing Elements:**
```java
fruits.remove(0);              // Remove by index
fruits.remove("Apple");        // Remove by value
```

**4. Size and Check:**
```java
int size = fruits.size();      // Get size
boolean empty = fruits.isEmpty();
boolean contains = fruits.contains("Apple");
```

**5. Updating Elements:**
```java
fruits.set(0, "Orange");       // Update at index
```

**Key Features:**
- Dynamic size (grows automatically)
- Fast random access (index-based)
- Allows duplicates and null values
- Not synchronized (not thread-safe)
- Slower insertion/deletion in middle

**ArrayList vs Array:**

| Feature | ArrayList | Array |
|---------|-----------|-------|
| **Size** | Dynamic | Fixed |
| **Type** | Objects only | Primitives + Objects |
| **Methods** | Many built-in | Limited |
| **Syntax** | `list.get(0)` | `arr[0]` |
| **Performance** | Slightly slower | Faster |

---

## 7. How to iterate using iterators?

**Definition:** Iterator is an interface that provides methods to traverse through collections.

**Using Iterator:**

**1. Basic Iteration:**
```java
ArrayList<String> list = new ArrayList<>();
list.add("Apple");
list.add("Banana");
list.add("Cherry");

Iterator<String> iterator = list.iterator();
while (iterator.hasNext()) {
    String element = iterator.next();
    System.out.println(element);
}
```

**2. Removing Elements During Iteration:**
```java
Iterator<String> iterator = list.iterator();
while (iterator.hasNext()) {
    String element = iterator.next();
    if (element.equals("Banana")) {
        iterator.remove();  // Safe removal
    }
}
```

**Iterator Methods:**
- `hasNext()` - Returns true if more elements exist
- `next()` - Returns next element and moves cursor
- `remove()` - Removes last returned element

**ListIterator (for Lists only):**
```java
ListIterator<String> listIterator = list.listIterator();
while (listIterator.hasNext()) {
    String element = listIterator.next();
    System.out.println(element);
}
// Can go backwards
while (listIterator.hasPrevious()) {
    String element = listIterator.previous();
    System.out.println(element);
}
```

**Comparison with Enhanced for-loop:**

| Feature | Iterator | Enhanced for-loop |
|---------|----------|-------------------|
| **Remove elements** | Yes | No |
| **Modify collection** | Yes | No |
| **Syntax** | More code | Simpler |
| **Control** | More control | Limited |

---

## 8. What is a Map?

**Definition:** Map is an interface that stores data in key-value pairs. Each key is unique.

**Declaration:**
```java
Map<KeyType, ValueType> map = new HashMap<>();
```

**Common Operations:**

**1. Adding Elements:**
```java
Map<String, Integer> scores = new HashMap<>();
scores.put("Alice", 95);
scores.put("Bob", 87);
scores.put("Charlie", 92);
```

**2. Accessing Elements:**
```java
int score = scores.get("Alice");        // Returns 95
int defaultScore = scores.getOrDefault("David", 0); // Returns 0
```

**3. Checking Existence:**
```java
boolean hasAlice = scores.containsKey("Alice");
boolean has95 = scores.containsValue(95);
```

**4. Removing Elements:**
```java
scores.remove("Bob");                   // Remove by key
```

**5. Updating Elements:**
```java
scores.put("Alice", 98);                // Updates value
scores.replace("Alice", 98);            // Alternative
```

**6. Iterating Through Map:**

**Method 1: Using entrySet()**
```java
for (Map.Entry<String, Integer> entry : scores.entrySet()) {
    System.out.println(entry.getKey() + ": " + entry.getValue());
}
```

**Method 2: Using keySet()**
```java
for (String key : scores.keySet()) {
    System.out.println(key + ": " + scores.get(key));
}
```

**Method 3: Using values()**
```java
for (Integer value : scores.values()) {
    System.out.println(value);
}
```

**Types of Maps:**

**1. HashMap** - Fast, unordered, allows one null key
```java
Map<String, Integer> hashMap = new HashMap<>();
```

**2. LinkedHashMap** - Maintains insertion order
```java
Map<String, Integer> linkedMap = new LinkedHashMap<>();
```

**3. TreeMap** - Sorted by keys (natural order)
```java
Map<String, Integer> treeMap = new TreeMap<>();
```

**Key Features:**
- Keys must be unique
- Values can be duplicate
- One null key allowed (HashMap)
- Fast lookup by key

---

## 9. How to sort a list?

**Method 1: Using Collections.sort()**

**a) Natural Ordering (Ascending):**
```java
ArrayList<Integer> numbers = new ArrayList<>();
numbers.add(5);
numbers.add(2);
numbers.add(8);
numbers.add(1);

Collections.sort(numbers);
System.out.println(numbers);  // [1, 2, 5, 8]
```

**b) Reverse Order (Descending):**
```java
Collections.sort(numbers, Collections.reverseOrder());
System.out.println(numbers);  // [8, 5, 2, 1]
```

**c) Sorting Strings:**
```java
ArrayList<String> names = new ArrayList<>();
names.add("Charlie");
names.add("Alice");
names.add("Bob");

Collections.sort(names);
System.out.println(names);  // [Alice, Bob, Charlie]
```

**Method 2: Using Comparator (Custom Sorting)**

**a) Lambda Expression:**
```java
// Sort by length
Collections.sort(names, (a, b) -> a.length() - b.length());
```

**b) Comparator Interface:**
```java
Collections.sort(names, new Comparator<String>() {
    public int compare(String a, String b) {
        return a.length() - b.length();
    }
});
```

**Method 3: Using Stream API (Java 8+)**
```java
List<Integer> sorted = numbers.stream()
                              .sorted()
                              .collect(Collectors.toList());
```

**Method 4: Using List.sort() (Java 8+)**
```java
numbers.sort(Comparator.naturalOrder());
numbers.sort(Comparator.reverseOrder());
```

**Sorting Objects:**
```java
class Student {
    String name;
    int marks;
    
    Student(String name, int marks) {
        this.name = name;
        this.marks = marks;
    }
}

ArrayList<Student> students = new ArrayList<>();
students.add(new Student("Alice", 85));
students.add(new Student("Bob", 92));

// Sort by marks
Collections.sort(students, (s1, s2) -> s1.marks - s2.marks);
```

---

## 10. How to shuffle elements?

**Definition:** Shuffling randomly rearranges elements in a list.

**Method 1: Using Collections.shuffle()**
```java
ArrayList<Integer> numbers = new ArrayList<>();
numbers.add(1);
numbers.add(2);
numbers.add(3);
numbers.add(4);
numbers.add(5);

Collections.shuffle(numbers);
System.out.println(numbers);  // Random order e.g., [3, 1, 5, 2, 4]
```

**Method 2: Using Random with shuffle()**
```java
Random random = new Random();
Collections.shuffle(numbers, random);
```

**Method 3: Manual Shuffling Algorithm**
```java
Random random = new Random();
for (int i = numbers.size() - 1; i > 0; i--) {
    int j = random.nextInt(i + 1);
    // Swap numbers[i] and numbers[j]
    int temp = numbers.get(i);
    numbers.set(i, numbers.get(j));
    numbers.set(j, temp);
}
```

**Shuffling Strings:**
```java
ArrayList<String> cards = new ArrayList<>();
cards.add("Ace");
cards.add("King");
cards.add("Queen");
cards.add("Jack");

Collections.shuffle(cards);
System.out.println(cards);
```

**Use Cases:**
- Randomizing quiz questions
- Shuffling deck of cards
- Randomizing playlist
- Creating random samples

**Key Points:**
- Original list is modified (in-place)
- Each element has equal probability
- Uses Fisher-Yates algorithm internally
- Works with any List implementation

---

