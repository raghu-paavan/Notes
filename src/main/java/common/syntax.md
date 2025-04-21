**Java Cheat Sheet**

---

## 1. Primitive Constants

- **Integer.MAX_VALUE**: `2147483647`
- **Integer.MIN_VALUE**: `-2147483648`
- **Double.MAX_VALUE**: `1.7976931348623157E308`
- **Double.MIN_VALUE**: `4.9E-324`

---

## 2. String Cleaning

Remove all whitespace from a string:
```java
String cleanedExpression = expression.replaceAll("\\s+", "");
```

---

## 3. Pair Syntax

JavaFX's immutable `Pair`:
```java
Pair<Integer, Integer> p = new Pair<>(1, 2);
int key   = p.getKey();   // 1
int value = p.getValue(); // 2
```

---

## 4. Arrays

### Declaration & Length
```java
int[] ans = new int[k];
int len = ans.length;
```

### Fill
```java
Arrays.fill(ans, 0);
```

### Sorting
```java
// Sort intervals by end, then start descending
Arrays.sort(intervals, new Comparator<int[]>() {
    public int compare(int[] x, int[] y) {
        if (x[1] == y[1]) {
            return Integer.compare(y[0], x[0]);
        }
        return Integer.compare(x[1], y[1]);
    }
});

// Reverse-order for an array of Comparables
Arrays.sort(arr, Comparator.reverseOrder());

// Lambda sort by start
Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
```

### Binary Search
```java
int idx = Arrays.binarySearch(y, intervals[i][0]);
// returns index if found, else -(insertionPoint) - 1
```

---

## 5. ArrayList

```java
ArrayList<Integer> temp = new ArrayList<>();
int size = temp.size();
temp.add(value);
temp.set(1, 42);
int x = temp.get(index);

// Convert Set<List<Integer>> to ArrayList<List<Integer>>
Set<List<Integer>> res = new HashSet<>();
List<List<Integer>> list = new ArrayList<>(res);
```

### 2D List Initialization
```java
List<List<Integer>> ans = new ArrayList<>();
// or
List<ArrayList<Integer>> x = new ArrayList<>();
```

---

## 6. Set Operations

```java
Set<List<Integer>> res = new HashSet<>();
res.add(temp);
boolean has = res.contains(temp);
res.remove(temp);
```

---

## 7. HashMap

```java
HashMap<Integer, Integer> map = new HashMap<>();
map.put(nums[0], 1);
int count = map.get(nums[i]);
map.remove(nums[i]);
boolean exists = map.containsKey(key);
Set<Integer> keys = map.keySet();
Collection<Integer> vals = map.values();
Set<Map.Entry<Integer, Integer>> entries = map.entrySet();

// Iterate
for (Map.Entry<String, Integer> entry : hashMap.entrySet()) {
    System.out.println(entry.getKey() + " = " + entry.getValue());
}

// Build frequency map
HashMap<Integer, Integer> freq = new HashMap<>();
for (int num : nums) {
    freq.put(num, freq.getOrDefault(num, 0) + 1);
}
// Sort entries by value descending
List<Map.Entry<Integer, Integer>> list = new LinkedList<>(freq.entrySet());
Collections.sort(list, (o1, o2) -> o2.getValue().compareTo(o1.getValue()));
```

---

## 8. TreeSet & NavigableSet

```java
TreeSet<Integer> set = new TreeSet<>();
set.addAll(Arrays.asList(10, 20, 30, 40, 50));

// Elements > x (exclusive)
SortedSet<Integer> greater = set.tailSet(x, false);

// Elements < x (exclusive)
SortedSet<Integer> less = set.headSet(x, false);
int countLess = less.size();
```

---

## 9. TreeMap

```java
TreeMap<Integer, Integer> map = new TreeMap<>();
map.put(k, v);
Map.Entry<Integer, Integer> floor = map.floorEntry(k);
```

---

## 10. LinkedList

```java
LinkedList<Integer> list = new LinkedList<>();
int size = list.size();
list.addFirst(val);
list.addLast(val);
list.getFirst();
list.getLast();
list.get(index);
list.remove();
list.removeFirst();
list.removeLast();
```

> **Tip:** If you hold a reference `List<Integer> x = new LinkedList<>()`, you can only call methods in the `List` interface (no `addFirst`).

---

## 11. String Operations

```java
String s = "Raghu";
char c = s.charAt(0);
bool eq = s.equals(p);
int cmp = s.compareTo(p);

String sub = s.substring(start, end);
String[] parts = s.split(" ");
String[] esc = s.split("\\."); // split on dot

StringBuilder sb = new StringBuilder();
sb.append('-');
String str = sb.toString();
```

### Regex Lookahead Split
Split before `+` or `-` without consuming:
```java
String[] parts = expr.split("(?=\\+)|(?=-)");
// e.g., "10+20-30+40" → ["10", "+20", "-30", "+40"]
```

---

## 12. Stack

```java
Stack<Integer> stack = new Stack<>();
stack.push(val);
int top = stack.peek();
int popped = stack.pop();
boolean empty = stack.isEmpty();
int sz = stack.size();
```

---

## 13. Random

```java
private Random rand = new Random();
int r = rand.nextInt();
```

---

## 14. PriorityQueue

```java
PriorityQueue<Integer> pq = new PriorityQueue<>();
pq.add(val);
int head = pq.peek();
int polled = pq.poll();
pq.clear();

// Max-heap
PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
// Pair PQ
PriorityQueue<Pair<Integer, Double>> pq2 = new PriorityQueue<>(
    (a, b) -> Double.compare(b.getValue(), a.getValue())
);
```

---

## 15. 2D Point as Map Key
```java
class Point {
    int x, y;
    Point(int x, int y) { this.x = x; this.y = y; }
    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Point)) return false;
        Point p = (Point) o;
        return x == p.x && y == p.y;
    }
    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}
```

> **Note:** `HashSet`/`HashMap` use `equals()` & `hashCode()`, not object reference.

---

## 16. Binary Search Bounds
```java
public int lowerBound(int[] nums, int start, int end, int x) {
    while (start < end) {
        int mid = (start + end) / 2;
        if (nums[mid] >= x) end = mid;
        else start = mid + 1;
    }
    return start;
}

public int upperBound(int[] nums, int start, int end, int x) {
    while (start < end) {
        int mid = (start + end) / 2;
        if (nums[mid] <= x) start = mid + 1;
        else end = mid;
    }
    return start;
}

int idx = lowerBound(nums, 0, nums.length, target);
```

---

## 17. Conversions: `String`, `int`, `char`

| From → To | Syntax                                              |
|-----------|-----------------------------------------------------|
| String → int  | `int num = Integer.parseInt(str);`               |
| String → char | `char c = str.charAt(0);`                        |
| char → int    | `int num = ch - '0'; // or (int) ch for ASCII`  |
| char → String | `String s = String.valueOf(ch);`                 |
| int → char    | `char c = (char)(num + '0'); // or (char) code`  |
| int → String  | `String s = String.valueOf(num);`                |

---

## 18. LRU Cache
```java
class LRUCache {
    private final int capacity;
    private final LinkedHashMap<Integer,Integer> mp;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.mp = new LinkedHashMap<>(capacity, 0.75f, true) {
            @Override
            protected boolean removeEldestEntry(Map.Entry<Integer,Integer> eldest) {
                return size() > LRUCache.this.capacity;
            }
        };
    }

    public int get(int key) {
        return mp.getOrDefault(key, -1);
    }

    public void put(int key, int value) {
        mp.put(key, value);
    }
}
```

---

## 19. TreeMap Example & Common Methods
Refer to [JavaDoc for `NavigableMap`](https://docs.oracle.com/javase/8/docs/api/java/util/NavigableMap.html)

```java
TreeMap<String,Integer> map = new TreeMap<>();
map.put("apple", 10);
map.put("banana",20);
map.put("cherry",30);

String lo = map.firstKey();    // "apple"
String hi = map.lastKey();     // "cherry"

Map.Entry<String,Integer> ceil = map.ceilingEntry("blue");
Map.Entry<String,Integer> floor = map.floorEntry("blue");
String higher = map.higherKey("banana");
String lower  = map.lowerKey("banana");

SortedMap<String,Integer> head   = map.headMap("cherry");
SortedMap<String,Integer> tail   = map.tailMap("banana");
NavigableMap<String,Integer> sub = map.subMap("banana", true, "date", false);

for (Map.Entry<String,Integer> ent : map.entrySet()) {
    System.out.println(ent.getKey() + ": " + ent.getValue());
}
```

| Method                                 | Description                                                        |
|----------------------------------------|--------------------------------------------------------------------|
| `put(K key, V value)`                  | Insert or replace the mapping for `key`.                           |
| `get(Object key)`                      | Retrieve value, or `null` if absent.                               |
| `remove(Object key)`                   | Remove entry, returning old value or `null`.                       |
| `containsKey(Object key)`              | `true` if map has mapping for `key`.                               |
| `firstKey()` / `lastKey()`             | Lowest / highest key.                                              |
| `ceilingKey(K key)` / `ceilingEntry()` | Least key ≥ `key`.                                                 |
| `floorKey(K key)` / `floorEntry()`     | Greatest key ≤ `key`.                                              |
| `higherKey(K key)` / `higherEntry()`   | Least key > `key`.                                                 |
| `lowerKey(K key)` / `lowerEntry()`     | Greatest key < `key`.                                              |
| `headMap(K toKey)`                     | Keys < `toKey`.                                                    |
| `headMap(K toKey, boolean inclusive)`  | Keys < or ≤ `toKey`.                                               |
| `tailMap(K fromKey)`                   | Keys ≥ `fromKey`.                                                  |
| `tailMap(K fromKey, boolean inclusive)`| Keys ≥ or > `fromKey`.                                             |
| `subMap(K from, boolean, K to, boolean)` | Keys in range [from…to], with inclusive flags.                    |
| `navigableKeySet()`                    | View of keys in ascending order.                                   |
| `descendingKeySet()`                   | Keys in descending order.                                          |

---
