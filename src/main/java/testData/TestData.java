package testData;

import com.github.javafaker.Faker;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class TestData {
    static Faker faker = new Faker();

    //Генерация рандомной строки
    public static String generateRandomName() {
        return faker.name().fullName();
    }

    //Генерация рандомного email
    public static String generateRandomEmail() {
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        int length = 10;
        StringBuilder username = new StringBuilder();
        Random random = new Random();

        for (int i = 0; i < length; i++) {
            int index = random.nextInt(characters.length());
            username.append(characters.charAt(index));
        }

        String domain = "@example.com";

        return username.toString() + domain;
    }

    //Генерация рандомного password
    public static String generateRandomPassword(int length) {
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        StringBuilder username = new StringBuilder();
        Random random = new Random();

        for (int i = 0; i < length; i++) {
            int index = random.nextInt(characters.length());
            username.append(characters.charAt(index));
        }
        return username.toString();
    }
    //Список существующих ингредиентов
    public static List<String> makeIngredientList() {
        List<String> hash;
        hash = new ArrayList<>();
        hash.add("61c0c5a71d1f82001bdaaa6d");
        hash.add("61c0c5a71d1f82001bdaaa70");
        hash.add("61c0c5a71d1f82001bdaaa72");
        hash.add("61c0c5a71d1f82001bdaaa6e");
        return hash;
    }
    //Список несуществующих ингредиентов
    public static List<String> makeIngredientListNeg() {
        List<String> hash;
        hash = new ArrayList<>();
        hash.add("d41d8cd98f00b204e9800998ecf8427e");
        hash.add("61c0c5a71d1f82001bdaaa709999");
        hash.add("61c0c5a71d1f82001bdaaa729999");
        hash.add("61c0c5a71d1f82001bdaaa6e7777");
        return hash;
    }
    public static List<String> makeIngredientListNegNoHash() {
        List<String> hash;
        hash = new ArrayList<>();
        return hash;
    }
}
