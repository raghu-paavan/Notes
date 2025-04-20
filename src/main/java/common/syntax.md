Integer.MAX_VALUE: 2147483647
Integer.MIN_VALUE: -2147483648
Double.MAX_VALUE: 1.7976931348623157E308
Double.MIN_VALUE: 4.9E-324


Remove spaces from a string 
String cleanedExpression = expression.replaceAll("\\s+", "");


*********Pair syntax*********
Pair<Integer, Integer> p = new Pair<Integer, Integer>(1,2);
pair is immutable, so you cannot edit them. 
p.getKey();
p.getValue();


*********Arrays syntax*********
int [] ans = new int[k];
ans.length
Arrays.fill(ans,0);

int[][] intervals;
Arrays.sort(intervals, new Comparator<int[]>(){
    public int compare(int[] x , int [] y)
    {
        if(x[1]==y[1])
        {
            if(x[0]>y[0])return -1;
            else return 1;
        }
        else if(x[1]<y[1])
            return -1;
        else
            return 1;
    }
});

Arrays.sort(arr, Comparator.reverseOrder());
 Arrays.sort(intervals, (a, b) -> a[0] - b[0]); sorting intervals based on their starting position using lambda expression

Arrays.binarySearch(y, intervals[i][0]);
return i if the key is found
returns -i-1 if key is not found



*********Arraylist syntax*********
ArrayList<Integer> temp = new ArrayList<Integer>();
temp.size()
temp.add(value)
temp.set(1, "grapefruit")
temp.get(index)
Convert a set to arraylist

Set<List<Integer>> res = new HashSet<List<Integer>>();
new ArrayList<>(res)


way to initiate a 2d array is
List<List<Integer>> ans = new ArrayList<>();
or
List<ArrayList<Integer>> x = new ArrayList<ArrayList<Integer>>();
Collections.sort(intervals, new Comparator<int[]>(){
    public int compare(int[] x , int [] y)
    {
        if(x[1]==y[1])
        {
            if(x[0]>y[0])return -1;
            else return 1;
        }
        else if(x[1]<y[1])
            return -1;
        else
            return 1;
    }
});

ans.toArray(new int[ans.size()][])


*********Set operations*********
Set<List<Integer>> res = new HashSet<List<Integer>>();
res.add(temp)
res.contains(temp)
res.remove(temp)


*********HashMap operations*********
HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
map.put(nums[0],1);
map.get(nums[i]);
map.remove(nums[i])
map.containsKey(key)
map.keySet()
map.values()
map.entrySet()
Map.Entry<String, Integer> entry  - ietrator
entry.getKey()
entry.getValue()

for (String key : hashMap.keySet()) {
    Integer value = hashMap.get(key);
    System.out.println(key + " = " + value);
}

for (Map.Entry<String, Integer> entry : hashMap.entrySet()) {
    String key = entry.getKey();
    Integer value = entry.getValue();
    System.out.println(key + " = " + value);
}

converting the list of values into arraylist
ArrayList<Integer> arrayList = new ArrayList<>(hashMap.values());

HashMap<Integer, Integer> mp = new HashMap<Integer, Integer>();
for(int i: nums)
{
    mp.put(i, mp.getOrDefault(i,0)+1);
}
List<Entry<Integer, Integer>> list = new LinkedList<Entry<Integer, Integer>>(mp.entrySet());

Collections.sort(list, new Comparator<Entry<Integer, Integer>>()
 {
    public int compare(Entry<Integer, Integer> o1, Entry<Integer, Integer> o2)
    {
        return (o2.getValue()).compareTo(o1.getValue());
    }
 }
);

TreeSet<Integer> set = new TreeSet<>();
SortedSet<Integer> greaterThanX = set.tailSet(x, false);
tailSet(x, false) returns a view of the portion of the set with elements strictly greater than x.
false means exclude x. Use true to include x.


TreeSet<Integer> set = new TreeSet<>();
set.addAll(Arrays.asList(10, 20, 30, 40, 50));

int x = 35;

// Get all elements strictly less than x
SortedSet<Integer> lessThanX = set.headSet(x, false);

int count = lessThanX.size();

System.out.println("Count < " + x + " = " + count);



*********TreeMap operations*********
TreeMap<Integer,Integer> map = new TreeMap<Integer,Integer>();
map.floorEntry(k); return the Map.Entry<> where k<=available keys


*********LinkedList operations*********
LinkedList<Integer> ans = new LinkedList<Integer>();
ans.size()
ans.addFirst(value)
ans.addLast(value)
ans.clear()
ans.getFirst()
ans.getLast()
ans.get(index)
ans.remove()
ans.removeFirst()
ans.removeLast()

List<Integer> x = new LinkedList<Integer>();
x.addFirst() will throw error saying cannot find symbol addFirst() because
x has reference of List with LinkedList object. since there is no method like addFirst in the List class, it will throw a error.


*********String operations*********
String s = "Raghu"
s.charAt(0)

s.equals(p);
s.compareTo(p);

s.substring(startIndex, endIndex_exclusive)
String [] x = s.split(" ");

if we want to split based on. '.' then the syntax is
s.split("\\.");

StringBuilder sb = new StringBuilder();
sb.append('-');
sb.toString()


lr[0].split("(?=\\+)|(?=-)")
This is the key part. It splits the string using a regex with lookaheads.

✅ Regex Explained:

(?=\\+): Positive lookahead for +
Matches a position just before a +
\\+ is how you escape + in a Java string (regex requires \+, but Java strings require \\+)
(?=-): Positive lookahead for -
|: Logical OR
So this will split the string before every + or -, but won’t remove the operator.

String[] lr = {"10+20-30+40"};
String[] parts = lr[0].split("(?=\\+)|(?=-)");
System.out.println(Arrays.toString(parts));

[10, +20, -30, +40]






*********Stack operations*********
Stack<Integer> stack = new Stack<Integer>();
stack.push(value)
stack.pop()
stack.isEmpty()
stack.size()
stack.peek()


*********Random operations*********
private Random rand;
rand = Rnadom()




*********PriorityQueue operations*********
PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
pq.add(value)
pq.poll() removes the root
pq.peek() returns the root value
pq.size()
pq.clear()
PriorityQueue<Integer> pq = new PriorityQueue<Integer>(Comparator.reverseOrder());
PriorityQueue<Pair<Integer, Double>> pq = new PriorityQueue<>(
    (a, b) -> Double.compare(b.getValue(), a.getValue()) // Correct comparator
);


*********** Map of 2d point***************
    class Point {
        int x;
        int y;
        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
        @Override
        public boolean equals(Object o) {
            if (o == null)
                return false;
            Point point = (Point) o;
            return x == point.x && y == point.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }




In Java, HashSet uses equals() and hashCode() to determine if an object is already present in the set, not the memory reference of the object
    List<Integer> x = new ArrayList<>(List.of(1,2,3));
    List<Integer> y = List.of(1,2,3);
    Set<List<Integer>> s = new HashSet<>();
    s.add(x);
    if(s.contains(y))
        System.out.println("hello");
    else
        System.out.println("world");

    output:
        hello


but the same doesn't work for, because equals() compare the memory reference in case of arrays.
		int[] x1 = {1,2,3};
		int[] y1 = {1,2,3};
		Set<int[]> s1 = new HashSet<>();
		s1.add(x1);
		if(s1.contains(y1))
		    System.out.println("hello");
		else
		    System.out.println("world");

		output:
		    world


Upper and lower bound implementation
**end is exclusive
public int lowerBound(int [] nums, int start, int end, int x)
{
    while(start<end)
    {
        int mid = (start+end)/2;
        if(nums[mid]>=x) end = mid;
        else start = mid+1;
    }
    return start;
}
public int upperBound(int [] nums, int start, int end, int x)
{
    while(start<end)
    {
        int mid = (start+end)/2;
        if(nums[mid]<=x) start = mid+1;
        else end = mid;
    }
    return start;
}
ans[0] = lowerBound(nums, 0, nums.length, target);


---

### 🔁 Java Conversions: `String`, `int`, `char`

---

### ✅ **String → int**
```java
String str = "123";
int num = Integer.parseInt(str);
```

---

### ✅ **String → char**
(assuming you're extracting just one character)
```java
String str = "abc";
char ch = str.charAt(0);  // gets 'a'
```

---

### ✅ **char → int**
```java
char ch = '7';
int num = ch - '0';  // If ch is a digit
```
Or to get ASCII/Unicode value:
```java
int code = (int) ch;  // e.g. 'A' -> 65
```

---

### ✅ **char → String**
```java
char ch = 'z';
String str = String.valueOf(ch);
// or
String str2 = Character.toString(ch);
```

---

### ✅ **int → char**
```java
int num = 5;
char ch = (char) (num + '0');  // If num is 0–9
```
Or to convert ASCII code:
```java
int code = 65;
char ch = (char) code;  // 'A'
```

---

### ✅ **int → String**
```java
int num = 789;
String str = String.valueOf(num);
// or
String str2 = Integer.toString(num);
```

---

LRU Cache
class LRUCache {
    int capacity; 
    LinkedHashMap<Integer,Integer> mp ;
    public LRUCache(int capacity) {
        this.capacity = capacity; 
        mp = new LinkedHashMap<Integer, Integer>(capacity, 0.75f, true){
            @Override
            public boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest)
            {
                return size() > LRUCache.this.capacity;
            }
        };
    }
    
    public int get(int key) {
        return mp.getOrDefault(key,-1);
    }
    
    public void put(int key, int value) {
        mp.put(key,value);
    }
}

Here’s a quick primer on using Java’s `TreeMap<K,V>` (which implements `NavigableMap<K,V>`):

```java
import java.util.*;

public class TreeMapExample {
    public static void main(String[] args) {
        // 1) Declare & instantiate
        TreeMap<String, Integer> map = new TreeMap<>();

        // 2) Basic mutators/accessors
        map.put("apple",  10);    // insert or overwrite
        map.put("banana", 20);
        map.put("cherry", 30);

        Integer v = map.get("banana");   // 20
        boolean has = map.containsKey("date"); 
        Integer old = map.remove("apple");  // removes "apple" → 10

        int size = map.size();   // 2
        boolean empty = map.isEmpty();

        // 3) NavigableMap methods
        String lo = map.firstKey();    // lowest key
        String hi = map.lastKey();     // highest key

        Map.Entry<String,Integer> e1 = map.ceilingEntry("blue");  
        // → first entry with key ≥ "blue"

        String k2 = map.floorKey("blue");     
        // → largest key ≤ "blue"

        String higher = map.higherKey("banana"); 
        // → next key > "banana"

        String lower  = map.lowerKey("banana");  
        // → next key < "banana"

        // 4) Range views
        SortedMap<String,Integer> head = map.headMap("cherry"); 
        // keys < "cherry"

        SortedMap<String,Integer> tail = map.tailMap("banana"); 
        // keys ≥ "banana"

        NavigableMap<String,Integer> sub = map.subMap("banana", true, "date", false);
        // keys in [ "banana" … "date" )

        // 5) Iteration
        for (String key : map.keySet()) {
            System.out.println(key + " → " + map.get(key));
        }
        for (Map.Entry<String,Integer> ent : map.entrySet()) {
            System.out.println(ent.getKey() + ":" + ent.getValue());
        }

        // 6) Bulk operations
        map.clear();
        map.putAll(Map.of("x",1, "y",2, "z",3));
    }
}
```

---

### Common `TreeMap<K,V>` methods

| Method Signature                                        | What it does                                                    |
|---------------------------------------------------------|-----------------------------------------------------------------|
| `V put(K key, V value)`                                 | Insert or replace the mapping for `key`.                       |
| `V get(Object key)`                                     | Retrieve value for `key`, or `null` if absent.                 |
| `V remove(Object key)`                                  | Remove entry for `key`, returning its old value (or `null`).   |
| `boolean containsKey(Object key)`                       | `true` if map has a mapping for `key`.                         |
| `int size()`, `boolean isEmpty()`                       | Query number of entries or emptiness.                          |
|                                                         |                                                                 |
| `K firstKey()`, `K lastKey()`                           | Lowest and highest keys, respectively.                         |
| `Map.Entry<K,V> firstEntry()`, `lastEntry()`            | Entry for lowest/highest key.                                  |
| `K ceilingKey(K key)`, `Map.Entry<K,V> ceilingEntry(K)` | Least key ≥ `key` (and its entry).                             |
| `K floorKey(K key)`, `Map.Entry<K,V> floorEntry(K)`     | Greatest key ≤ `key` (and its entry).                          |
| `K higherKey(K key)`, `Map.Entry<K,V> higherEntry(K)`   | Least key > `key`.                                             |
| `K lowerKey(K key)`, `Map.Entry<K,V> lowerEntry(K)`     | Greatest key < `key`.                                          |
| `NavigableSet<K> navigableKeySet()`                     | View of keys in ascending order.                               |
| `NavigableSet<K> descendingKeySet()`                    | Keys in descending order.                                      |
|                                                         |                                                                 |
| `SortedMap<K,V> headMap(K toKey)`, `headMap(K,boolean)` | View of keys `< toKey` (optionally inclusive).                 |
| `SortedMap<K,V> tailMap(K fromKey)`, `tailMap(K,boolean)` | View of keys `≥ fromKey` (optionally inclusive).             |
| `NavigableMap<K,V> subMap(K fromKey, boolean, K toKey, boolean)` | View of keys in a [fromKey…toKey] range, with inclusive flags. |

These give you all the tools for both ordinary map lookup and “order‑aware” operations (floor/ceiling/higher/lower), as well as fast range queries via the various **view** methods.
