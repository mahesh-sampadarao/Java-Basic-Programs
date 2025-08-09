/*
Two Variables Having Same HashCode leads to Hash Collisions Scenario.

HashMap Internal Working
a HashMap uses an array of buckets or bins.
Each bucket is a linked list of type Node, which is used to represent the key-value pair of the HashMap.

The Node class has the following fields: (Refer below example)
hash: Refers to the hashCode of the key.          (hashCode=2236)
key: Refers to the key of the key-value pair.     (key=FB)
value: Refers to the value associated with the key(value=abc)
next: Acts as a reference to the next node.Generally if hash collision
doesn't occur then this reference will be null. but in this case (next=holds the address reference of Ea key)

1. Create a hashmap in class
2. Use put(Key,Value) method
3. put method calls putVal(Key) by passing Key
4. putVal(Key) calls hash(Key)
5. hash(Key) calls hashCode(Key)
6. hashCode generates hashCode for key and value
7. Using the hashCode generated and (n-1) using bit-wise AND operation, Index is calculated and key value is stored in Array Of Bucket.

Refer: https://www.geeksforgeeks.org/internal-working-of-hashmap-java/
*/

import java.util.HashMap;

public class TwoVariablesHavingSameHashCodeInHashMapExample {
    public static void main(String[] args) {
        String s1="FB";
        String s2="Ea";
        System.out.println(s1.hashCode());
        System.out.println(s2.hashCode());

        HashMap<String,String> map=new HashMap<>();
        map.put("FB","abc");
        map.put("Ea","def");

    }
}
