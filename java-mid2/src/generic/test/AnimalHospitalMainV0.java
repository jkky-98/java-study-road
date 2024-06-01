package generic.test;

import generic.animal.Cat;
import generic.animal.Dog;

public class AnimalHospitalMainV0 {
    public static void main(String[] args) {
        DogHospital dogHospital = new DogHospital();
        CatHospital catHospital = new CatHospital();

        Dog dog = new Dog("멈멍이12", 100);
        Cat cat = new Cat("야옹이1", 300);

        // 개 병원
        dogHospital.set(dog);
        dogHospital.checkup();

        // 고양이 병원
        catHospital.set(cat);
        catHospital.checkup();

        // 문제1: 개 병원
        // dogHospital.set(cat); // type안정성 만족 -> 컴파일 오류

        // 문제2 : 개 타입 반환
        dogHospital.set(dog);
        Dog biggerDog = dogHospital.bigger(new Dog("하운드", 200));
        System.out.println("biggerDog = " + biggerDog);

    }
}
