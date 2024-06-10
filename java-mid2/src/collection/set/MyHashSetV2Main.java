package collection.set;

public class MyHashSetV2Main {
    public static void main(String[] args) {
        MyHashSetV2 set = new MyHashSetV2(10);
        set.add(1);
        set.add(2);
        set.add("A");
        set.add("SET");
        set.add("B");
        set.add(99);
        set.add(9);
        System.out.println(set);

        //검색
        int searchValue = 9;
        boolean result = set.contains(searchValue);
        System.out.println("set.contains(" + searchValue + ") = " + result);

        String searchValueStr = "SET";
        boolean resultStr = set.contains(searchValueStr);
        System.out.println("set.contains(" + searchValueStr + ") = " + resultStr);

        //삭제
        boolean removeResult = set.remove(searchValue);
        System.out.println("removeResult = " + removeResult);
        System.out.println(set);

        //삭제
        boolean removeResultStr = set.remove(searchValueStr);
        System.out.println("removeResultStr = " + removeResultStr);
        System.out.println(set);
    }
}
