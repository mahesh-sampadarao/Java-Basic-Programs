import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.util.concurrent.CompletableFuture;
import java.util.function.Function;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

record Employee(int empId, String empName, String empGender, double empSalary, int empAge, String empDepartment) {
}

public class UsingStreamAPIOnEmployeeObjects {
    private static int count = 0;

    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();

        employees.add(new Employee(111, "Uma", "Male", 10500.00, 25, "IT"));
        employees.add(new Employee(111, "Adam", "Male", 12500.00, 35, "Sales"));
        employees.add(new Employee(222, "Adam", "Male", 14500.00, 24, "IT"));
        employees.add(new Employee(121, "Brian", "Male", 18500.00, 45, "Bank"));
        employees.add(new Employee(311, "Cathy", "Female", 20500.00, 50, "IT"));
        employees.add(new Employee(114, "Donald", "Male", 23500.00, 45, "Sales"));
        employees.add(new Employee(151, "Elsa", "Female", 40500.00, 38, "Finance"));
        employees.add(new Employee(611, "Freddy", "Male", 43500.00, 22, "IT"));
        employees.add(new Employee(1011, "Gracy", "Female", 56500.00, 58, "Sales"));
        employees.add(new Employee(172, "Hanna", "Female", 70500.00, 60, "Bank"));
        employees.add(new Employee(114, "Illiot", "Male", 50500.00, 43, "Finance"));
        employees.add(new Employee(511, "John", "Male", 12333.00, 21, "IT"));
        employees.add(new Employee(616, "Katrina", "Female", 15500.00, 18, "IT"));

        //employees.forEach(System.out::println);
        Stream<Employee> sortedStream = employees.stream().sorted(Comparator.comparingDouble(Employee::empSalary).reversed());
        //sortedStream.forEach(System.out::println);

        Map<Boolean, List<Employee>> separationByGender = sortedStream.collect(Collectors.partitioningBy(e -> e.empGender().equalsIgnoreCase("Male")));
        //System.out.println(separationByGender);

        Map<Boolean, Long> male = employees.stream()
                .sorted(Comparator.comparingDouble(Employee::empSalary).reversed())
                .collect(Collectors.partitioningBy(e -> e.empGender().equalsIgnoreCase("Female"), Collectors.counting()));
        System.out.println(male);

        Map<String, List<Employee>> mapByEmployeeName = employees.stream().collect(Collectors.groupingBy(Employee::empName));
        //System.out.println(mapByEmployeeName.get("Adam"));

        Map<Character, List<Employee>> mapByEmployeeFirstChar = employees.stream().collect(Collectors.groupingBy(e -> e.empName().charAt(0)));
        System.out.println(mapByEmployeeFirstChar);

        Employee secondHighestSalariedEmployee = employees.stream()
                .sorted(Comparator.comparingDouble(Employee::empSalary).reversed())
                .skip(1).findFirst().orElseThrow();
        //System.out.println(secondHighestSalariedEmployee);

        //EPAM Questions
        double v = employees.stream().mapToDouble(Employee::empSalary).average().orElse(0.0);

        //System.out.println(v);

        List<Employee> employees1 = employees.stream().filter(e -> e.empSalary() > v).sorted(Comparator.comparing(Employee::empSalary)).toList();

        //System.out.println(employees1);

        Map<Integer, String> collect = employees.stream().collect(Collectors.toMap(Employee::empId, Employee::empName, (empName1, empName2) -> empName1 + " and " + empName2 + " have same id"));
        System.out.println("The employees database : "+collect);

        Map<Integer, Employee> collect23 = employees
                .stream()
                .collect(Collectors.toMap(Employee::empId, Function.identity(), (empName1, empName2) -> empName2));
        System.out.println("The employees storing entirely as value : "+collect23);

        Employee it = employees.stream().filter(e -> Objects.equals(e.empDepartment(), "Finance"))
                .max(Comparator.comparing(Employee::empSalary)).orElse(null);

        //System.out.println(it);

        String names = "Sillyspiders";

        Map<Character, Long> collect1 = names.chars()
                .mapToObj(c -> (char) c)
                .map(Character::toUpperCase)
                .sorted(Comparator.naturalOrder())
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        System.out.println(collect1);

        String string = "abcdabbcdddc";

        Map<Character, Long> charMap = string
                .chars()
                .mapToObj(c -> (char) c)
                .map(Character::toLowerCase)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        System.out.println(charMap);

        Map.Entry<Character, Long> characterLongEntry = charMap
                .entrySet()
                .stream()
                .max(Map.Entry.comparingByValue())
                .orElse(null);
        System.out.println(characterLongEntry);

        String namesTest = "6a5b3c4d2f1g";
        StringBuilder sb = new StringBuilder();

        IntStream.range(0, namesTest.length() / 2)
                .mapToObj(i -> {
                    int count = Character.getNumericValue(namesTest.charAt(2 * i));
                    char ch = namesTest.charAt(2 * i + 1);
                    return String.valueOf(ch).repeat(count);
                })
                .forEach(sb::append);

        System.out.println(sb);

        String namesTest2 = "12a24b36c";
        String collectResult = Pattern.compile("(\\d+)([a-zA-Z])")
                .matcher(namesTest2)
                .results()
                .map(m -> m.group(2).repeat(Integer.parseInt(m.group(1))))
                .collect(Collectors.joining());

        System.out.println(collectResult);

        CompletableFuture<Object> future = CompletableFuture.supplyAsync(() -> 4 + 5); //Asynchronous Calls
        future.thenAccept(System.out::println);

        List<Integer> myList = Arrays.asList(10, 15, 8, 49, 25, 98, 32);
        List<Integer> list = myList.stream().map(String::valueOf)
                .filter(s -> s.startsWith("1")).map(Integer::valueOf).toList();

        System.out.println(list);

        List<Integer> myListVar = Arrays.asList(10, 15, 8, 49, 25, 98, 98, 32, 15);
        Set<Integer> set = new HashSet<>();
        Integer[] array = myListVar.stream().filter(s -> !set.add(s)).toArray(Integer[]::new);
        System.out.println(Arrays.toString(array));

        Stream<Long> fibonacci = Stream.iterate(
                        new long[]{0, 1}, f -> new long[]{f[1], f[0] + f[1]})
                .map(f -> f[0]);
// Print first 10 Fibonacci numbers
        fibonacci.limit(10).forEach(s -> System.out.print(s + " "));
        System.out.println();

        List<String> strings = Arrays.asList("flower", "flow", "flight");
        String longestCommonPrefix = strings.stream()
                .reduce((s1, s2) -> {
                    int length = Math.min(s1.length(), s2.length());
                    int i = 0;
                    while (i < length && s1.charAt(i) == s2.charAt(i)) {
                        i++;
                    }
                    return s1.substring(0, i);
                })
                .orElse("");
        System.out.println("Longest common prefix: " + longestCommonPrefix);

        int[] arrayLast = {1, 2, 3, 4, 5};
        int first = Arrays.stream(arrayLast).skip(arrayLast.length - 1).findFirst().orElse(0);
        System.out.println(first);

        List<Integer> listOfIntegers = Arrays.asList(45, 12, 56, 15, 24, 75, 31, 89);

        double max = listOfIntegers.stream().max(Comparator.naturalOrder()).get();
        System.out.println(max);

        int[] a = new int[]{4, 2, 7, 1};
        int[] b = new int[]{8, 3, 9, 5};
        int[] c = IntStream.concat(Arrays.stream(a), Arrays.stream(b)).sorted().toArray();

        int number = 15623;
        String[] arrString=String.valueOf(number).split("");
        System.out.println(Arrays.toString(arrString));

        //Using Strings only.
        String sumString=Arrays.stream(arrString).reduce("0",(n1,n2)-> String.valueOf(Integer.parseInt(n1)+Integer.parseInt(n2)));
        System.out.println("The sum is : "+sumString);

        Long collect2 = Stream.of(String.valueOf(number).split("")).collect(Collectors.summarizingInt(Integer::parseInt)).getSum();
        System.out.println(collect2);

        LocalDate birthDay = LocalDate.of(1995, 8, 28);
        LocalDate today = LocalDate.now();

        System.out.println(ChronoUnit.YEARS.between(birthDay, today));

        String s = "1s2u3m4a";
        List<String> list1 = Pattern.compile("(\\d+)").splitAsStream(s).toList();
        System.out.println(list1);

        int[] arr12 = {3, 4, 4, 2, 1, 2, 3, 4};
        Integer i22 = Arrays.stream(arr12)
                .boxed()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet()
                .stream()
                .filter(n -> n.getValue() == 1)
                .map(Map.Entry::getKey)
                .findFirst()
                .orElse(0);

        List<Integer> li3 = Arrays.stream(arr12).boxed().toList();
        List<Integer> list2 = li3.stream().filter(n -> Collections.frequency(li3, n) >= 3).distinct().toList();

        System.out.println(list2);

        //Duck Creek
        TreeSet<String> set2 = new TreeSet<>(Comparator.comparingInt(String::length));
        set2.addAll(List.of("AB", "CD", "XY", "LONG"));
        System.out.println("The set 2 data is :" + set2);

        List<String> list4 = new ArrayList<>(List.of("A", "B", "C"));
        for (String st : list4) {
            if (st.equals("B"))
                list4.remove(st);
            //list.remove(s);
        }
        System.out.println(list4);

        //Apexon
        String userNames = "Uma Maheshwar Rao Sampadarao";

        Map<Character, Long> charNamesMap = userNames.toLowerCase().chars()
                .mapToObj(t -> (char) t)
                .collect(
                        Collectors.toMap(Function.identity()
                                , count -> 1L, Long::sum, LinkedHashMap::new));
        System.out.println(charNamesMap);

        String s1 = "AABBBCCCCDA";

        Map<Character, Long> Map22 = s1.chars()
                .mapToObj(d -> (char) d)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println(Map22);

        Compress(s1);

        //String str="AABBBCCCCAAA";
        StringBuilder sb3=new StringBuilder();

        List<Character> output=s1.chars()
                .mapToObj(ch->(char)ch)
                .toList();

        int count = 1;
        for (int i = 1; i < output.size(); i++) {
            if (output.get(i).equals(output.get(i - 1))) {
                count++;
            } else {
                sb3.append(output.get(i - 1)).append(count);
                count = 1;
            }
        }

        sb3.append(output.get(output.size() - 1)).append(count);

        System.out.println("Compressed using list : "+sb3);


    }

    static void Compress(String str) {
        int n = str.length();
        char[] chars = str.toCharArray();
        StringBuilder sb2 = new StringBuilder();

        IntStream.range(0, n )
                .forEach(i -> {
                    if (i == 0 || chars[i] != chars[i - 1]) {
                        if (i != 0) {
                            sb2.append(count);
                        }
                        sb2.append(chars[i]);
                        count = 1;
                    } else {
                        count++;
                    }

                    if (i == n - 1) {
                        sb2.append(count);
                    }
                });
        System.out.println(sb2);
    }
}
