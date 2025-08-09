//singleton class using enum this the best approach

/*
There are mainly 6 ways to create a singleton class. They are
1. Eager Initialized Singleton
2. Lazy Initialized Singleton
3. Thread Safe Singleton
4. Double Checked Locking Singleton
5. Bill Pugh Singleton
6. Enum Singleton
*/

public enum SingletonEnumClass {
    INSTANCE;

    public void doSomething(){
        System.out.println("Doing something");
    }

    public static void main(String[] args) {
        SingletonEnumClass singleton=SingletonEnumClass.INSTANCE;
        singleton.doSomething();
    }
}
