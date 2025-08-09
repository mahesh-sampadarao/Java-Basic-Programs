import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

record Point(String name, double lat, double lon){}

public class UsingStreamAPIOnSpactialDataPoints {
    private static int count = 0;

    public static void main(String[] args) {
        List<Point> points = Arrays.asList(
                new Point("Statue of Liberty", 40.6892, -74.0445),
                new Point("Empire State", 40.7484, -73.9857),
                new Point("Central Park", 40.7851, -73.9683),
                new Point("Golden Gate", 37.8199, -122.4783)
        );

        double minLat = 40.6, maxLat = 40.8;
        double minLon = -74.05, maxLon = -73.95;

        List<Point> nycPoints = points.stream()
                .filter(p -> p.lat() >= minLat && p.lat() <= maxLat && p.lon() >= minLon && p.lon() <= maxLon)
                .toList();

        System.out.println("Points in NYC bounding box: " + nycPoints);
        System.out.println("-".repeat(20));
        double avgLat = points.stream().mapToDouble(p->p.lat()).average().orElse(0);
        double avgLon=points.stream().mapToDouble(Point::lon).average().orElse(0);
        System.out.println("The Centroid of the point is : ("+avgLat+","+avgLon+")");
        System.out.println("-".repeat(20));
        Map<Boolean, List<Point>> hemisphereSplit = points.stream().collect(Collectors.partitioningBy(p -> p.lat() >= 0));
        System.out.println(hemisphereSplit);
        System.out.println("-".repeat(20));
        Map<String, List<Point>> gridGroups = points.stream()
                .collect(Collectors.groupingBy(p ->
                        ((int) p.lat()) + "_" + ((int) p.lon())
                ));
        gridGroups.forEach((cell, pts) ->
                System.out.println("Grid " + cell + " : " + pts));
        System.out.println("-".repeat(20));
        Point target = new Point("Custom Point",10.0, 20.0);
        Point closestPoint = points.stream().min(Comparator.comparingDouble(p -> distance(p, target))).orElse(null);
        System.out.println(closestPoint);
        System.out.println("-".repeat(20));

        Set<String> seen = new HashSet<>();
        List<Point> deduplicated = points.stream()
                .filter(p -> seen.add(String.format("%.3f_%.3f", p.lat(), p.lon())))
                .toList();
        System.out.println(deduplicated);


        String names="A2B3C4";
        String namesChanged="4A2B3C";
        StringBuilder sb=new StringBuilder();

        IntStream.range(0,names.length()/2)
                .mapToObj(i->{
                    char ch=names.charAt(2*i);
                    int count= Character.getNumericValue(names.charAt(2 * i + 1));
                    return String.valueOf(ch).repeat(count);
                }).forEach(sb::append);

        System.out.println(sb);

        StringBuilder sb2=new StringBuilder();
        IntStream.range(0,namesChanged.length()/2)
                .mapToObj(i->{
                    int count= Character.getNumericValue(namesChanged.charAt(2 * i));
                    char ch=namesChanged.charAt(2*i+1);
                    return String.valueOf(ch).repeat(count);
                }).forEach(sb2::append);

        System.out.println(sb2);

        String characters="AAACCBBBB";
        char[] charactersArray=characters.toCharArray();
        StringBuilder sb3=new StringBuilder();

        IntStream.range(0,characters.length())
                .forEach(i->{
                    if(i==0 || charactersArray[i]!=charactersArray[i-1]){
                        if(i!=0){
                            sb3.append(count);
                        }
                        sb3.append(charactersArray[i]);
                        count=1;
                    }else{
                        count++;
                    }

                    if(i==characters.length()-1){
                        sb3.append(count);
                    }
                });

        System.out.println(sb3);

        String str="SillySpiders";

        Map<Character, List<Integer>> charPositions =
                IntStream.range(0, str.length())
                        .boxed()
                        .collect(Collectors.groupingBy(
                                str::charAt, //i -> str.charAt(i),
                                LinkedHashMap::new,
                                Collectors.toList()
                        ));

        System.out.println(charPositions);


        //Practice
        String characters2="AAACCBBBB";
        char[] charsArray=characters2.toCharArray();
        StringBuilder sb4=new StringBuilder();

        IntStream.range(0,characters2.length())
                .forEach(i->{
                    if(i==0 || charsArray[i]!=charsArray[i-1]){
                        if(i!=0){
                            sb4.append(count);
                        }
                        sb4.append(charsArray[i]);
                        count=1;
                    }else{
                        count++;
                    }

                    if(i==characters2.length()-1){
                        sb4.append(count);
                    }

                });

        System.out.println("The sb4 contains : "+sb4);
    }
    
    static double distance(Point p1, Point p2){
        return Math.sqrt(Math.pow(p1.lat()- p2.lat(),2)+Math.pow(p1.lon()-p2.lon(),2));
    }
}
