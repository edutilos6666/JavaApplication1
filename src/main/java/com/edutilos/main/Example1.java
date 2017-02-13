package com.edutilos.main;


import java.util.List;
import java.util.Scanner;

public class Example1 {
    private static final Scanner scanner = new Scanner(System.in);
   private static PersonDAO dao ;

    public static void main(String[] args) {
         String nl = "\r\n",
                 menu = "1 -> add person "+ nl +
                         "2 -> update person "+ nl +
                         "3 -> delete person "+ nl +
                         "4 -> find person by id "+ nl +
                         "5 -> find all people"+nl +
                         "6 -> break ";


        dao = new PersonDAOMysql();

        while(true) {
            System.out.println(menu);
             int choice = scanner.nextInt();
            scanner.nextLine();
            switch(choice) {
                case 1: addPerson(); break;
                case 2: updatePerson(); break;
                case 3: removePerson(); break;
                case 4: findById(); break;
                case 5: findAll(); break;
                case 6: System.exit(1);
            }
        }

    }


    private static void addPerson() {
        long id ;
        String name;
        int age ;
        double wage;
        System.out.println("Insert id, name , age , wage (seperated by comma): ");
        String input = scanner.nextLine();
        String [] split = input.split("\\s*,\\s*");
       // System.out.println("split size = "+ split.length);
        if(split.length != 4) {
            System.out.println("False input");
        } else {
            id = Long.parseLong(split[0]);
            name = split[1];
            age = Integer.parseInt(split[2]);
            wage = Double.parseDouble(split[3]);
            Person p = new Person(id, name, age, wage);
            dao.save(p);
        }
    }

    private static void updatePerson() {
      long id;
        String name;
        int age;
        double wage;
        System.out.println("Insert id of old person , and new name, age, wage properties(sep by comma): ");
        String str = scanner.nextLine();
        String[] split = str.split("\\s*,\\s*");
        if(split.length != 4) {
            System.out.println("false input");
        } else {
            id = Long.parseLong(split[0]);
            name = split[1];
            age = Integer.parseInt(split[2]);
            wage = Double.parseDouble(split[3]);
            Person p = new Person(id, name, age, wage);
            dao.update(id, p);
        }
    }

    private static void removePerson() {
        long id;
        System.out.println("Insert id of person to be removed: ");
        id = scanner.nextLong();
        dao.delete(id);
    }

    private static void findById() {
       long id;
        System.out.println("Insert id of person to be found: ");
        id = scanner.nextLong();
        Person p = dao.findById(id);
        System.out.println(p);
    }

    private static void findAll() {
        List<Person> personList = dao.findAll();
        for(Person p: personList)
            System.out.println(p);
    }
}
