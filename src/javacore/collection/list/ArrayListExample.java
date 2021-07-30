package javacore.collection.list;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.*;
import java.util.stream.Collectors;

/**
 *=Java ArrayList
 * https://www.javatpoint.com/java-arraylist
 *
 * - Java ArrayList class uses a dynamic array for storing the elements.
 *   It is like an array, but there is no size limit.
 *   We can add or remove elements anytime.
 *   So, it is much more flexible than the traditional array.
 *   It is found in the java.util package;
 * - The ArrayList in Java can have the duplicate elements also.
 *   It implements the List interface so we can use all the methods of List interface here.
 *   The ArrayList maintains the insertion order internally;
 * - It inherits the AbstractList class and implements List interface;
 *
 * - The important points about Java ArrayList class are:
 *   1. Java ArrayList class can contain duplicate elements.
 *   2. Java ArrayList class maintains insertion order.
 *   3. Java ArrayList class is non synchronized.
 *   4. Java ArrayList allows random access because array works at the index basis.
 *   5. In ArrayList, manipulation is little bit slower than the LinkedList in Java
 *      because a lot of shifting needs to occur if any element is removed from the array list.
 *
 */

public class ArrayListExample {

    public static class Animal {

        private final String animalClass;
        private final String animalName;

        public Animal(String animalClass, String animalName) {
            this.animalClass = animalClass;
            this.animalName = animalName;
        }

        public String getAnimalClass() {
            return animalClass;
        }

        public String getAnimalName() {
            return animalName;
        }

        //--outFormat: Animal {animalClass='Cat', animalName='Jessica'}
        /*
        @Override
        public String toString() {
            return "Animal{" +
                    "animalClass='" + animalClass + '\'' +
                    ", animalName='" + animalName + '\'' +
                    '}';
        }
        */

        //--outFormat: Animal{Cat,Jessica}
        @Override
        public String toString() {
            return "Animal{" +
                        animalName + ","  +
                        animalClass +
                    '}';
        }

    }

    public static void main(String[] args) {
        //--test
        System.out.println("=Java Collection.List.ArrayList EXAMPLES:\n\n");


        //--CREATE A NON-GENERIC ArrayList--
        System.out.println("1 -- NON-GENERIC ArrayList:\n");

        ArrayList list1 = new ArrayList();      //-- Constructs an empty list with an initial capacity of ten
        list1.add(0, "Dog");
        list1.add(1, "Cat");
        list1.add("Racoon");
        list1.add("Parrot");

        System.out.println(list1);                                          //--calls toString() Method to print ArrayList Object
        System.out.println(list1.size() +" elements");                      //--get number of elements
        System.out.println(list1.get(0));                                   //--get [0] element value
        System.out.println(list1.get(1));                                   //--get [1] element value
        System.out.println("Racoon id is "+ list1.indexOf("Racoon"));       //--get "Racoon" index
        System.out.println();
        //
        /*=
            [Dog, Cat, Racoon, Parrot]
            4 elements
            Dog
            Cat
            Racoon id is 2
        */

        //--replace [3] element value
        list1.set(3, "Monkey");
        System.out.println(list1);
        System.out.println();

        //--create fake animals
        list1.add("fakeAnimal1");
        list1.add("fakeAnimal2");
        list1.add(77);                          //-- non-Generic Arrays allows add an elements with various types

        //--remove element by value
        System.out.println(list1);              //= [Dog, Cat, Racoon, Monkey, fakeAnimal1, fakeAnimal2, 77]

        list1.remove("fakeAnimal1");
        //list1.remove(4);                      //! removes element by index, but we need remove element by value
        System.out.println(list1);              //= [Dog, Cat, Racoon, Monkey, fakeAnimal2, 77]
        System.out.println();

        //--remove element by index
        list1.remove(list1.indexOf(77));                //-- remove 77 value by index
        list1.remove(list1.indexOf("fakeAnimal2"));     //-- remove "fakeAnimal2" value by index

        System.out.println(list1);                      //= [Dog, Cat, Racoon, Monkey]
        System.out.println("\n");


        //--CREATE ArrayList of Strings (Generics Style)--
        System.out.println("2 -- GENERIC ArrayList (List of AnimalObjects):\n");

        Animal animal1 = new Animal("Cat", "Jessica");
        Animal animal2 = new Animal("Dog", "Mila");
        Animal animal3 = new Animal("Racoon", "Bob");
        Animal animal4 = new Animal("Parrot", "Jake");

        //System.out.println(animal1.animalClass +" "+ animal1.animalName);
        //System.out.println(animal1);        //= Animal{Jessica,Cat}
        //System.out.println(animal2);        //= Animal{Mila,Dog}
        //System.out.println(animal3);        //= Animal{Bob,Racoon}
        //System.out.println(animal4);        //= Animal{Jake,Parrot}

        //--create Generic ArrayList of Animal Objects
        ArrayList<Animal> myPets = new ArrayList<Animal>();
        //myPets.add("fakeAnimal");                                  //-- only Animal objects is allowed for add
        myPets.add(animal1);
        myPets.add(animal2);
        myPets.add(animal3);
        myPets.add(animal4);

        System.out.println(myPets);
        System.out.println("\n");
        /*=
         *   [Animal{Jessica,Cat}, Animal{Mila,Dog}, Animal{Bob,Racoon}, Animal{Jake,Parrot}]
        */


        //--ITERATE OVER ArrayList--
        System.out.println("3 -- ITERATE over ArrayList:\n");

        //--Iterate over Array with foreach loop -- get pets Names from ArrayList of Animal Objects
        System.out.println("..Iterate over ArrayList using forEach loop:");

        for (Animal pet : myPets)
            System.out.println(pet.animalName);
        System.out.println();
        /*=
         *  Jessica
         *  Mila
         *  Bob
         *  Jake
         */

        //--Iterate over Array with foreach loop and Lambda -- get pets Names from ArrayList of Animal Objects
        System.out.println("..Iterate over ArrayList using forEach loop & Lambda Expression:");

        myPets.forEach(pet -> { System.out.println(pet.getAnimalName()); });
        System.out.println();
        /*=
         *  Jessica
         *  Mila
         *  Bob
         *  Jake
         */

        //--Iterate over Array with Iterator -- get pets Class from ArrayList of Animal Objects
        System.out.println("..Iterate over ArrayList using Iterator:");

        //(!) Raw use of parameterized class 'Iterator' (см.ниже)
        Iterator itr = myPets.iterator();                       //-- get Iterator from ArrayList
        //(!) 'while' loop replaceable with enhanced 'for'
        while (itr.hasNext()) {
            //--call toString Method of each Object;
            //System.out.println(itr.next());

            //--
            //Animal pet = itr.next();                          //=ERR: Required type: Animal, Provided: Object
            Animal pet = (Animal) itr.next();
            System.out.println(pet.getAnimalClass());
        }
        System.out.println();

        //--Iterate over Array with Iterator and Lambda -- get pets Class from ArrayList of Animal Objects
        System.out.println("..Iterate over ArrayList using Iterator & Lambda Expression:");

        Iterator<Animal> itr2 = myPets.iterator();
        itr2.forEachRemaining(pet -> System.out.println(pet.getAnimalClass()));

        System.out.println("\n");


        //--SORTING--
        System.out.println("4 -- SORTING -- Get Pet Names List from Animal ArrayList an SORT:\n");

        //--get List of Names from ArrayList of Animal Objects
        //Collections.sort(myPets);                             //=ERR:  Required type: List, Provided: ArrayList<Animal>

        //--create List of Pet Names with lambda expression
        List<String> petNames = myPets.stream().map(Animal::getAnimalName).collect(Collectors.toList());

        System.out.println("..Before Sorting:");
        System.out.println(petNames);                   //= [Jessica, Mila, Bob, Jake]
        System.out.println();

        //--sort
        Collections.sort(petNames);

        //--after sorting
        System.out.println("..After Sorting:");         //= [Bob, Jake, Jessica, Mila]
        System.out.println(petNames);
        System.out.println();


        //--SERIALIZATION / DESERIALIZATION--
        System.out.println("5 -- SERIALIZATION / DESERIALIZATION -- Save ArrayList Animal Data to file:\n");

        //--we need ArrayList of Strings for serialization
        ArrayList<String> testArrayList = new ArrayList<String>();
        testArrayList.add("Black");
        testArrayList.add("Withe");
        testArrayList.add("Yellow");
        testArrayList.add("Green");

        System.out.println("..process test data");
        try {
            //--Serialization (Test Data) -- SAVE
            FileOutputStream test_fos = new FileOutputStream("_serialized/test.data");
            ObjectOutputStream test_oos = new ObjectOutputStream(test_fos);
            //-write ArrayList of Strings to file
            test_oos.writeObject(testArrayList);
            //-close streams
            test_fos.close();;
            test_oos.close();

            //--DeSerialization (Test Data) -- LOAD
            FileInputStream test_fis = new FileInputStream("_serialized/test.data");
            ObjectInputStream test_ois = new ObjectInputStream(test_fis);
            //-load data into ArrayList
            //*ArrayList loadedData = ois.readObject();        //=ERR: Required type: ArrayList, Provided: Object
            ArrayList loadedData = (ArrayList) test_ois.readObject();

            //-print test data
            for (Object data: loadedData) {
                System.out.println(data);
            }

        } catch (Exception e) {
            //--something goes wrong
            System.out.println(e);

            //=ERRORS:
            // 1. java.io.NotSerializableException: javacore.collection.list.ArrayListExample$Animal
            //    - input data MUST be ArrayList of Strings
            //
        }
        System.out.println();

        //--
        System.out.println("..process Animal Names data");

        //--extract myPets
        ArrayList<String> petNames2 = new ArrayList<String>();
        for (Animal pet:myPets) {
            petNames2.add(pet.getAnimalName());
        }
        //System.out.println(petNames2);            //= [Jessica, Mila, Bob, Jake]

        try {
            //--Serialization (AnimalNames Data) -- SAVE
            FileOutputStream fos = new FileOutputStream("_serialized/petNames.data");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            //-write ArrayList of Strings to file
            oos.writeObject(petNames2);
            //-close streams
            fos.close();;
            oos.close();

            //--DeSerialization (AnimalNames Data) -- LOAD
            FileInputStream fis = new FileInputStream("_serialized/petNames.data");
            ObjectInputStream ois = new ObjectInputStream(fis);
            //-load data into ArrayList
            ArrayList petNames2Data = (ArrayList) ois.readObject();

            //-print petName data (Lambda Expression)
            petNames2Data.forEach(petName -> { System.out.println(petName); });


        } catch (Exception e) {
            //--something goes wrong
            System.out.println(e);
        }

    }

}
