package collection.set;

import collection.set.member.Member;

public class JavaHashCodeMain {
    public static void main(String[] args) {
        Object object1 = new Object();
        Object object2 = new Object();

        System.out.println("object1.hashCode() = " + object1.hashCode());
        System.out.println("object2.hashCode() = " + object2.hashCode());

        Integer i = 10;
        String strA = "A";
        String strAB = "AB";

        System.out.println("i.hashCode() = " + i.hashCode());
        System.out.println("strA.hashCode() = " + strA.hashCode());
        System.out.println("strAB.hashCode() = " + strAB.hashCode());

        System.out.println("Integer.valueOf(-1).hashCode() = " + Integer.valueOf(-1).hashCode());

        Member member1 = new Member("idA");
        Member member2 = new Member("idA");

        System.out.println(" == " + (member1 == member2));
        System.out.println(" equals " + (member1.equals(member2)));

    }
}
