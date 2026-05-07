public class HashMapDriver {
    public static void main(String[] args) {

        SeparateChainingMap<Integer, String> map = new SeparateChainingMap<>();

        System.out.println("put(5, A): " + map.put(5, "A"));
        System.out.println("put(7, B): " + map.put(7, "B"));
        System.out.println("put(2, C): " + map.put(2, "C"));
        System.out.println("put(2, E): " + map.put(2, "E")); // replaces value for key 2

        System.out.println("get(7): " + map.get(7));         // retrieve value for key 7
        System.out.println("remove(5): " + map.remove(5));  // remove key 5
    }
}