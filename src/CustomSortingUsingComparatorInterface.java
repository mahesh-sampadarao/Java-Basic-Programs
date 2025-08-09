/*
We can sort a Collection using either Comparator or Comparable.

Difference between Comparator and Comparable are as follows:

Comparator-It is a functional interface and has method compare(T o1,T o2).
Collections.sort/Arrays.sort are used to implement custom sorting.
It is in java.util package.

Comparable-It is an interface which needs to be implemented.
It has a method compareTo(T o) and we need to override this method with our custom logic for natural sorting.
It is in java.lang package.
*/

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class TuitionStudent implements Comparable<TuitionStudent> {
    int age;
    String name;

    public TuitionStudent(int age, String name) {
        this.age = age;
        this.name = name;
    }

    @Override
    public String toString() {
        return "TuitionStudent{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public int compareTo(TuitionStudent that) {
        if (this.age > that.age)
            return 1;
        else
            return -1;
    }
}

public class CustomSortingUsingComparatorInterface {
    public static void main(String[] args) {
        //Custom Sorting using Units Place of a number
        Comparator<Integer> com = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if (o1 % 10 > o2 % 10)
                    return 1;
                else
                    return -1;
            }
        };

        List<Integer> nums = new ArrayList<>();
        nums.add(43);
        nums.add(31);
        nums.add(72);
        nums.add(29);

        Collections.sort(nums, com); //Collections is a class and has method for sorting List
        System.out.println(nums);

        //Custom Sorting using Age of a TuitionStudent
       // Comparator<TuitionStudent> com = (o1, o2) -> (o1.age > o2.age) ? 1 : -1;

        List<TuitionStudent> studs = new ArrayList<>();
        studs.add(new TuitionStudent(21, "Uma"));
        studs.add(new TuitionStudent(12, "Mahesh"));
        studs.add(new TuitionStudent(35, "Rao"));
        studs.add(new TuitionStudent(48, "SampadaRao"));

        Collections.sort(studs);

        for (TuitionStudent s : studs)
            System.out.println(s);
    }
}
