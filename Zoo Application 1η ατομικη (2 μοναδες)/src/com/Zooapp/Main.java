package com.Zooapp;

import com.Zooanimals.Animals; //Προσβαση στο εξωτερικο πακετο οπου βρισκεται η Animals

import java.io.*;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        //εκτελεση της παρακατω συναρτησης
        ZooApp();
    }

        public static void ZooApp () {
 /*Ο παρακατω κωδικας που βρισκεται σε σχολια εχει εκτελεστει μια φορα για να προσθεσει τα πρωτα ζωα στο αρχειο.Δεν εκτελειται ξανα
για να μην αντικαταστησει τυχων αλλαγες.

            //Αντικειμενα της ταξης Animals

            Animals snake = new Animals();
            Animals hippo = new Animals();
            Animals crocodile = new Animals();
            Animals parrot = new Animals();
            Animals dolphin = new Animals();
            Animals monkey = new Animals();
            Animals frog = new Animals();



            //Χαρακτηριστικα καθε αντικειμενου

            snake.species = "reptilian";
            snake.animalname = "Snake";
            snake.setCode("A1");
            snake.setMaxage(25);
            snake.setWeight(6);

            hippo.species = "Mammals";
            hippo.animalname = "Hippopotamus";
            hippo.setCode("A2");
            hippo.setMaxage(50);
            hippo.setWeight(1500);

            crocodile.species = "reptilian";
            crocodile.animalname = "Crocodile";
            crocodile.setCode("A3");
            crocodile.setMaxage(100);
            crocodile.setWeight(500);

            parrot.species = "Bird";
            parrot.animalname = "Parrot";
            parrot.setCode("A4");
            parrot.setMaxage(95);
            parrot.setWeight(2);

            dolphin.species = "Mammals";
            dolphin.animalname = "Dolphin";
            dolphin.setCode("A5");
            dolphin.setMaxage(55);
            dolphin.setWeight(150);

            monkey.species = "Mammals";
            monkey.animalname = "Monkey";
            monkey.setCode("A6");
            monkey.setMaxage(30);
            monkey.setWeight(10);

            frog.species = "amphibian";
            frog.animalname = "Frog";
            frog.setCode("A7");
            frog.setMaxage(12);
            frog.setWeight(0.3);


            //προσθηκη των πρωτων ζωων σε λιστα

            List<Animals> animalList = new ArrayList<>();

            animalList.add(snake);
            animalList.add(hippo);
            animalList.add(dolphin);
            animalList.add(monkey);
            animalList.add(frog);
            animalList.add(parrot);
            animalList.add(crocodile);

            //Εγγραφη της λιστας των ζωων στο αρχειο

                try {
                FileOutputStream fileOutputStream = new FileOutputStream("ZooList1.ser");
                ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);//ανοιγμα αρχειου

                objectOutputStream.writeObject(animalList); // Καταγραφη της λιστας στο αρχειο

                fileOutputStream.close();
                objectOutputStream.close(); //κλεισιμο αρχειου

            }
             catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } */

            List<Animals> animalList = new ArrayList<>(); //δημιουργια της λιστας animallist

            try {
                FileInputStream fileInputStream = new FileInputStream("ZooList1.ser");
                ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);//ανοιγμα αρχειου

                animalList = (List<Animals>) objectInputStream.readObject(); //Διαβασμα της λιστας απο το αρχειο και αποθηκευση αυτης στην animallist

                fileInputStream.close();
                objectInputStream.close(); //Μετα το διαβασμα, το αρχειο κλεινει

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }



            //Εκκινηση εφαρμογης

            System.out.println("\n\nΚΑΛΟΣΗΡΘΑΤΕ ΣΤΗΝ ΕΦΑΡΜΟΓΗ ZOO.ΠΑΡΑΚΑΛΩ ΕΙΣΑΓΕΤΕ ΤΟΝ ΑΡΙΘΜΟ ΤΗΣ ΛΕΙΤΟΥΡΓΙΑΣ ΠΟΥ ΘΕΛΕΤΕ " +
                    "ΝΑ ΠΡΑΓΜΑΤΟΠΟΙΗΣΕΤΕ.\nΟΙ ΛΕΙΤΟΥΡΓΙΕΣ ΕΙΝΑΙ ΟΙ ΠΑΡΑΚΑΤΩ:");

            System.out.println("1. Προβολή όλων των διαθέσιμων ζώων του ζωολογικού κήπου\n" +
                    "2. Προσθήκη νέου ζώου\n" +
                    "3. Αναζήτηση ζώου βάσει ονόματος\n" +
                    "4. Αναζήτηση ζώου βάσει κωδικού\n" +
                    "5. Επεξεργασία ζώου βάσει κωδικού\n" +
                    "6. Διαγραφή ζώου βάσει κωδικού\n" +
                    "7. Έξοδος από την εφαρμογή");

            Scanner getinput = new Scanner(System.in);

            boolean allowexit = false; // Για την κληση της συναρτησης ZooApp μετα απο καθε λειτουργια
            try {
                int input = getinput.nextInt();
                //ζητειται αριθμος απο τον χρηστη

                if (1 > input || input > 7) {
                    System.out.println("ΠΑΡΑΚΑΛΩ ΕΙΣΑΓΕΤΕ ΕΝΑΝ ΑΡΙΘΜΟ ΑΠΟ ΤΟ 1-7\n\n\n");
                    ZooApp(); //αν δωσει λαθος αριθμο η διαδικασια επαναλαμβανεται
                }

                //πρωτη επιλογη: προβολή όλων των διαθέσιμων ζώων του ζωολογικού κήπου

                if (input == 1) {
                    for (int i = 0; i < animalList.size(); i++) {
                        System.out.println("ΖΩΟ: " + animalList.get(i).animalname + "\nΚΩΔΙΚΟΣ: " + animalList.get(i).getCode() +
                                "\nΒΑΡΟΣ: " + animalList.get(i).getWeight() + "\nΜΕΓΙΣΤΗ ΗΛΙΚΑ: " + animalList.get(i).getMaxage() +
                                "\nΟΜΟΤΑΞΙΑ: " + animalList.get(i).species + "\n\n");
                    } //εμφανιζει ολα τα στοιχεια της λιστας. Δηλαδη ολες τις μεταβλητες για καθε object της
                }

                // δευτερη επιλογη: Προσθήκη νέου ζώου

                if (input == 2) {


                    Animals newanimal = new Animals(); //φτιαχνει ενα καινουριο object της κλασης Animals για να του προσθεσει
                    //τα νεα στοιχεια που θα εισαγει ο χρηστης και μετα να το αποθηκευσει
                    // στη λιστα

                    //Ονομα νεου ζωου

                    boolean bool2 = true;
                    while (bool2) {
                        System.out.println("ΕΙΣΑΓΕΤΕ ΟΝΟΜΑ ΝΕΟΥ ΖΩΟΥ: "); //bool2 = true για να ξεκινησει η επαναληψη
                        Scanner getinput2 = new Scanner(System.in);
                        String input2 = getinput2.nextLine();
                        int lock2 = 0;

                        for (Animals a : animalList) { //Ψαχνει ολα τα object της λιστας για να ελεγξει αν υπαρχεια καποιο
                            // με το ιδιο ονομα που εδωσε ο χρηστης

                            if (a.animalname.equals(input2)) {
                                System.out.println("ΥΠΑΡΧΕΙ ΕΙΔΗ ΖΩΟ ΜΕ ΑΥΤΟ ΤΟ ΟΝΟΜΑ"); //αν υπαρχει εμφανιζει αυτο το μηνημα
                                lock2 = 1; // θετει lock2 = 1 για να μην εκτελεστει η παρακατω if και αποθηκευτει το λαθος ονομα
                            }
                        }
                        if ((lock2 == 0) && (input2 != null) && (!input2.equals("")) && (input2.matches(
                                "^[a-zA-ZΑ-Ωα-ωάίήύέόΆΉΌΊΎΈ]*$"))) { //Αν lock2 = 0,το ονομα δεν ειναι κενο και περιεχει
                            //τους χαρακτηρες στις []

                            newanimal.animalname = input2; //θετει το ονομα του newanimal ισο με το ονομα που εδωσε ο χρηστης
                            bool2 = false; //θετει bool2 = false για να σταματησει η επαναληψη

                        } else {
                            System.out.println("ΠΑΡΑΚΑΛΩ ΕΙΣΑΓΕΤΕ ΕΓΚΥΡΟ ΟΝΟΜΑ"); //εμφανιζει το μηνημα για lock2 = 1
                        }
                        //Συνεχιζεται η επαναληψη μεχρι ο χρηστης να δωσει σωστο ονομα
                    }

                    //Κωδικος νεου ζωου

                    boolean bool3 = true; //Παρομοιας λογικης με τα παραπανω
                    while (bool3) {
                        System.out.println("ΕΙΣΑΓΕΤΕ ΚΩΔΙΚΟ ΝΕΟΥ ΖΩΟΥ: ");
                        Scanner getinput3 = new Scanner(System.in);
                        String input3 = getinput3.nextLine();
                        int lock3 = 0;
                        for (Animals a : animalList) {
                            if (a.getCode().equals(input3)) {
                                System.out.println("ΥΠΑΡΧΕΙ ΕΙΔΗ ΖΩΟ ΜΕ ΑΥΤΟ ΤΟΝ ΚΩΔΙΚΟ");
                                lock3 = 1;
                            }
                        }
                        if ((lock3 == 0)) {
                            newanimal.setCode(input3); //Εδω  θετουμε τον κωδικο του ζωου με αυτον του χρηστη
                            bool3 = false;
                        } else {
                            System.out.println("ΠΑΡΑΚΑΛΩ ΕΙΣΑΓΕΤΕ ΕΓΚΥΡΟ ΚΩΔΙΚΟ");
                        }
                    }

                    //Βαρος νεου ζωου

                    boolean bool4 = true;
                    while (bool4) {
                        System.out.println("ΕΙΣΑΓΕΤΕ ΒΑΡΟΣ ΝΕΟΥ ΖΩΟΥ: ");
                        Scanner getinput4 = new Scanner(System.in);
                        try {
                            double input4 = getinput4.nextDouble();
                            newanimal.setWeight(input4);
                            bool4 = false;
                        } catch (InputMismatchException e) {
                            System.out.println("ΠΑΡΑΚΑΛΩ ΕΙΣΑΓΕΤΕ ΕΓΚΥΡΟ ΒΑΡΟΣ"); //Αν η μεταβλητη του χρηστη δεν ειναι
                            //τυπου double τοτε η εξαιρεση εμφανιζει το μηνημα και η επαναληψη συνεχιζεται
                        }


                    }

                    //Μεγιστη ηλικια νεου ζωου

                    boolean bool5 = true;
                    while (bool5) {
                        System.out.println("ΕΙΣΑΓΕΤΕ ΜΕΓΙΣΤΗ ΗΛΙΚΙΑ ΝΕΟΥ ΖΩΟΥ: ");
                        Scanner getinput5 = new Scanner(System.in);
                        try {
                            int input5 = getinput5.nextInt();
                            newanimal.setMaxage(input5);
                            bool5 = false;
                        } catch (InputMismatchException e) {
                            System.out.println("ΠΑΡΑΚΑΛΩ ΕΙΣΑΓΕΤΕ ΕΓΚΥΡΗ ΜΕΓΙΣΤΗ ΗΛΙΚΑ"); //Αν η μεταβλητη του χρηστη δεν ειναι
                            //τυπου int τοτε η εξαιρεση εμφανιζει το μηνημα και η επαναληψη συνεχιζεται
                        }
                    }

                    //Ομοταξια νεου ζωου

                    boolean bool6 = true; //Ομοια με τον κωδικο νεου ζωου
                    while (bool6) {
                        System.out.println("ΕΙΣΑΓΕΤΕ ΟΜΟΤΑΞΙΑ ΝΕΟΥ ΖΩΟΥ: ");
                        Scanner getinput6 = new Scanner(System.in);
                        String input6 = getinput6.nextLine();
                        if ((input6 != null) && (!input6.equals("")) && (input6.matches("^[a-zA-ZΑ-Ωα-ωάίήύέόΆΉΌΊΎΈ]*$"))){
                            newanimal.species = input6;
                            bool6 = false;}
                        else {
                            System.out.println("ΠΑΡΑΚΑΛΩ ΕΙΣΑΓΕΤΕ ΕΓΚΥΡΗ ΟΜΟΤΑΞΙΑ");
                        }

                    }

                    System.out.println("\nΤΟ NEO ΖΩΟ ΑΠΟΘΗΚΕΥΤΗΚΕ ΜΕ ΕΠΙΤΥΧΙΑ"); //Αν ολα συμπληρωθουν εμφανιζεται το μηνημα

                    animalList.add(newanimal); //Προσθετει το newanimal object (που περιεχει τα στοιχεια που εδωσε ο
                    // χρηστης) στη λιστα

                }

                //Τριτη επιλογη: Αναζήτηση ζώου βάσει ονόματος

                if (input == 3) {
                    boolean booli = true;
                    while (booli) {
                        System.out.println("ΕΙΣΑΓΕΤΕ ΤΟ ΟΝΟΜΑ ΤΟΥ ΖΩΟΥ ΠΟΥ ΘΕΛΕΤΕ ΝΑ ΑΝΑΖΗΤΗΣΕΤΕ: ");
                        Scanner getinput7 = new Scanner(System.in);
                        String input7 = getinput7.nextLine();
                        int locki = 0;
                        for (Animals a : animalList) {
                            if (a.animalname.equals(input7)) { //Αν υπαρχει το ζωο που δινει ο χρηστης εμφανιζει
                                // ολα τα στοιχεια του

                                System.out.println("ΤΟ ΖΩΟ ΠΟΥ ΑΝΑΖΗΤΗΣΑΤΕ ΥΠΑΡΧΕΙ:\nΟΝΟΜΑ: " + a.animalname +
                                        "\nΚΩΔΙΚΟΣ: " + a.getCode() + "\nΒΑΡΟΣ: " + a.getWeight() +
                                        "\nΜΕΓΙΣΤΗ ΗΛΙΚΑ: " + a.getMaxage() + "\nΟΜΟΤΑΞΙΑ: " + a.species);
                                locki = 1;
                                booli = false;
                            }
                        }
                        if (locki == 0) {
                            System.out.println("ΤΟ ΖΩΟ ΠΟΥ ΑΝΑΖΗΤΗΣΑΤΕ ΔΕΝ ΥΠΑΡΧΕΙ"); //Αν δεν υπαρχει εμφανισε αυτο
                        }
                    }
                }


                //Τεταρτη επιλογη: Αναζήτηση ζώου βάσει κωδικού

                if (input == 4) {
                    boolean boolii = true;
                    while (boolii) {
                        System.out.println("ΕΙΣΑΓΕΤΕ ΤΟΝ ΚΩΔΙΚΟ ΤΟΥ ΖΩΟΥ ΠΟΥ ΘΕΛΕΤΕ ΝΑ ΑΝΑΖΗΤΗΣΕΤΕ: ");
                        Scanner getinput8 = new Scanner(System.in);
                        String input8 = getinput8.nextLine();
                        int lockii = 0;
                        for (Animals a : animalList) {
                            if (a.getCode().equals(input8)) { //Αν υπαρχει ζωο με κωδικο που δινει ο χρηστης εμφανιζει
                                // ολα τα στοιχεια του

                                System.out.println("ΤΟ ΖΩΟ ΠΟΥ ΑΝΑΖΗΤΗΣΑΤΕ ΥΠΑΡΧΕΙ ΚΑΙ ΕΧΕΙ ΟΝΟΜΑ: " + a.animalname +
                                        "\nΚΩΔΙΚΟ: " + a.getCode() + "\nΒΑΡΟΣ: " + a.getWeight() +
                                        "\nΜΕΓΙΣΤΗ ΗΛΙΚΑ: " + a.getMaxage() + "\nΟΜΟΤΑΞΙΑ: " + a.species);
                                lockii = 1;
                                boolii = false;
                            }
                        }
                        if (lockii == 0) {
                            System.out.println("ΤΟ ΖΩΟ ΠΟΥ ΑΝΑΖΗΤΗΣΑΤΕ ΔΕΝ ΥΠΑΡΧΕΙ"); //Αν δεν υπαρχει εμφανισε αυτο
                        }

                    }
                }

                //Πεμπτη επιλογη: Επεξεργασία ζώου βάσει κωδικού

                if (input == 5) {

                    boolean booliii = true;
                    while (booliii) {
                        System.out.println("ΕΙΣΑΓΕΤΕ ΤΟΝ ΚΩΔΙΚΟ ΤΟΥ ΖΩΟΥ ΠΟΥ ΘΕΛΕΤΕ ΝΑ ΕΠΕΞΕΡΓΑΣΤΕΙΤΕ: ");
                        Scanner getinput9 = new Scanner(System.in);
                        String input9 = getinput9.nextLine();
                        int lockiii = 0;
                        for (Animals a : animalList) {
                            if (a.getCode().equals(input9)) { //Αν υπαρχει το ζωο με κωδικο που εδωσε ο χρηστης
                                //εμφανιζει τα στοιχεια του και ξεκινα η επεξεργασια (Η εφαρμογη ζητα στον χρηστη να
                                //αλλαξει ολα τα στοιχεια)

                                System.out.println("ΤΟ ΖΩΟ ΠΟΥ ΑΝΑΖΗΤΗΣΑΤΕ ΥΠΑΡΧΕΙ ΚΑΙ ΕΧΕΙ ΟΝΟΜΑ: " + a.animalname +
                                        "\nΚΩΔΙΚΟ: " + a.getCode() + "\nΒΑΡΟΣ: " + a.getWeight() +
                                        "\nΜΕΓΙΣΤΗ ΗΛΙΚΑ: " + a.getMaxage() + "\nΟΜΟΤΑΞΙΑ: " + a.species);

                                //Νεο ονομα

                                boolean booliv = true;
                                while (booliv) {
                                    System.out.println("ΕΙΣΑΓΕΤΕ ΝΕΟ ΟΝΟΜΑ ΖΩΟΥ: ");
                                    Scanner getinput10 = new Scanner(System.in);
                                    String input10 = getinput10.nextLine();
                                    int lock10 = 0;
                                    for (Animals a2 : animalList) {
                                        if (a2.animalname.equals(input10)) { //Αν υπαρχει ηδη ζωο με το ονομα που θελει
                                            //να δωσει ο χρηστης

                                            System.out.println("ΥΠΑΡΧΕΙ ΕΙΔΗ ΖΩΟ ΜΕ ΑΥΤΟ ΤΟ ΟΝΟΜΑ");
                                            lock10 = 1;
                                        }
                                    }
                                    if ((lock10 == 0) && (input10 != null) && (!input10.equals("")) && (input10.matches(
                                            "^[a-zA-ZΑ-Ωα-ωάίήύέόΆΉΌΊΎΈ]*$"))) { //Αν δεν υπαρχει ηδη ζωο με το ονομα
                                        // που θελει να δωσει ο χρηστης και το ονομα ειναι σωστο

                                        a.animalname =  input10;
                                        booliv = false;
                                    } else {
                                        System.out.println("ΠΑΡΑΚΑΛΩ ΕΙΣΑΓΕΤΕ ΕΓΚΥΡΟ ΝΕΟ ΟΝΟΜΑ"); //Αν υπαρχει ηδη ζωο με
                                        // το ονομα που θελει να δωσει ο χρηστης ή αν το ονομα που εδωσε ηταν λαθος εμφανισε
                                        //αυτο
                                    }
                                }



                                //Νεος Κωδικος

                                boolean boolv = true;
                                while (boolv) {
                                    System.out.println("ΕΙΣΑΓΕΤΕ ΝΕΟ ΚΩΔΙΚΟ ΖΩΟΥ: ");
                                    Scanner getinput11 = new Scanner(System.in);
                                    String input11 = getinput11.nextLine();
                                    int lock11 = 0;
                                    for (Animals a2 : animalList) {
                                        if (a2.getCode().equals(input11)) {  //Αν υπαρχει ηδη ζωο με τον κωδικο που θελει
                                            //να δωσει ο χρηστης
                                            System.out.println("ΥΠΑΡΧΕΙ ΕΙΔΗ ΖΩΟ ΜΕ ΑΥΤΟ ΤΟΝ ΚΩΔΙΚΟ");
                                            lock11 = 1;
                                        }
                                    }
                                    if ((lock11 == 0)) { //Αν δεν υπαρχει ηδη ζωο με το κωδικο
                                        // που θελει να δωσει ο χρηστης
                                        a.setCode(input11);
                                        boolv = false;
                                    } else {
                                        System.out.println("ΠΑΡΑΚΑΛΩ ΕΙΣΑΓΕΤΕ ΕΓΚΥΡΟ ΝΕΟ ΚΩΔΙΚΟ"); //Αν υπαρχει ηδη ζωο με
                                        // το κωδικο που θελει να δωσει ο χρηστης εμφανισε αυτο
                                    }
                                }


                                //Νεο Βαρος

                                boolean boolvi = true;
                                while (boolvi) {
                                    System.out.println("ΕΙΣΑΓΕΤΕ ΝΕΟ ΒΑΡΟΣ ΖΩΟΥ: ");
                                    Scanner getinput12 = new Scanner(System.in);
                                    try {
                                        double input12 = getinput12.nextDouble();
                                        a.setWeight(input12);
                                        boolvi = false;
                                    } catch (InputMismatchException e) {
                                        System.out.println("ΠΑΡΑΚΑΛΩ ΕΙΣΑΓΕΤΕ ΕΓΚΥΡΟ ΝΕΟ ΒΑΡΟΣ"); //Αν ο χρηστης δεν
                                        //δωσει μεταβλητη τυπου double για το βαρος εμφανισε αυτο στην εξαιρεση
                                    }
                                }

                                //Νεα μεγιστη ηλικια

                                boolean boolvii = true;
                                while (boolvii) {
                                    System.out.println("ΕΙΣΑΓΕΤΕ ΝΕΑ ΜΕΓΙΣΤΗ ΗΛΙΚΙΑ ΖΩΟΥ: ");
                                    Scanner getinput13 = new Scanner(System.in);
                                    try {
                                        int input13 = getinput13.nextInt();
                                        a.setMaxage(input13);
                                        boolvii = false;
                                    } catch (InputMismatchException e) {
                                        System.out.println("ΠΑΡΑΚΑΛΩ ΕΙΣΑΓΕΤΕ ΕΓΚΥΡΗ ΝΕΑ ΜΕΓΙΣΤΗ ΗΛΙΚΑ");//Αν ο χρηστης δεν
                                        //δωσει μεταβλητη τυπου int για την μεγιστη ηλικα εμφανισε αυτο στην εξαιρεση
                                    }
                                }



                                //Νεα Ομοταξια

                                boolean boolviii = true;
                                while (boolviii) {
                                    System.out.println("ΕΙΣΑΓΕΤΕ NEA ΟΜΟΤΑΞΙΑ ΖΩΟΥ: ");
                                    Scanner getinput14 = new Scanner(System.in);
                                    String input14 = getinput14.nextLine();
                                    if ((input14 != null) && (!input14.equals("")) && (input14.matches(
                                            "^[a-zA-ZΑ-Ωα-ωάίήύέόΆΉΌΊΎΈ]*$"))){ //Αν ο χρηστης δωσει εγκηρη ομοταξια
                                        a.species = input14;
                                        boolviii = false;}
                                    else {
                                        System.out.println("ΠΑΡΑΚΑΛΩ ΕΙΣΑΓΕΤΕ ΕΓΚΥΡΗ ΝΕΑ ΟΜΟΤΑΞΙΑ"); //Αν ο χρηστης δωσει
                                        //μη εγκηρη ομοταξια
                                    }

                                }

                                lockiii = 1;
                                booliii = false;
                            }
                        }
                        if (lockiii == 0) {
                            System.out.println("ΤΟ ΖΩΟ ΠΟΥ ΑΝΑΖΗΤΗΣΑΤΕ ΔΕΝ ΥΠΑΡΧΕΙ"); //Αν ο κωδικος του ζωου που αναζητησε
                            // ο χρηστης δεν υπαρχει εμφανισε αυτο
                        }

                    }
                    System.out.println("Η ΕΠΕΞΕΡΓΑΣΙΑ ΤΟΥ ΖΩΟΥ ΣΑΣ ΕΓΙΝΕ ΜΕ ΕΠΙΤΥΧΙΑ");//Οταν ο χρηστης συμπληρωσει
                    //ολα τα καινουρια στοιχεια του ζωου εμφανισε αυτο
                }

                //Εκτη επιλογη: Διαγραφή ζώου βάσει κωδικού

                if (input == 6) {
                //Εδω, δημιουργουμε μια νεα λιστα η οποια θα περιεχει το object-ζωο που θελουμε να διαγραψουμε.
                    //Διαβαζουμε το object-ζωο απο τη νεα λιστα και διαγραφουμε το αντιστοιχο object-ζωο της αρχικης


                    boolean boolix = true;
                    List<Animals> Deleteanimalslist = new ArrayList<>(); //δημιουργια νεας λιστας
                    while (boolix) {
                        System.out.println("ΕΙΣΑΓΕΤΕ ΤΟΝ ΚΩΔΙΚΟ ΤΟΥ ΖΩΟΥ ΠΟΥ ΘΕΛΕΤΕ ΝΑ ΔΙΑΓΡΑΨΕΤΕ: ");
                        Scanner getinput15 = new Scanner(System.in);
                        String input15 = getinput15.nextLine();
                        int lockix = 0;
                        for (Animals a : animalList) {
                            if (a.getCode().equals(input15)) {
                                Deleteanimalslist.add(a); //Αν ο κωδικος ζωου που δινει ο χρηστης υπαρχει προσθεσε το
                                //object-ζωο που εχει αυτον τον κωδικο απο την παλια λιστα στη νεα λιστα

                                System.out.println("ΤΟ ΖΩΟ ΠΟΥ ΑΝΑΖΗΤΗΣΑΤΕ ΜΕ ΤΑ ΑΚΟΛΟΥΘΑ ΣΤΟΙΧΕΙΑ ΔΙΑΓΡΑΦΤΗΚΕ ΕΠΙΤΥΧΩΣ:\n" +
                                        "ΟΝΟΜΑ ΖΩΟΥ: "+a.animalname + "\nΚΩΔΙΚΟ: " + a.getCode() + "\nΒΑΡΟΣ: " + a.getWeight() +
                                        "\nΜΕΓΙΣΤΗ ΗΛΙΚΑ: " + a.getMaxage() + "\nΟΜΟΤΑΞΙΑ: " + a.species);
                                lockix = 1;
                                boolix = false;
                            }
                        }
                        if (lockix == 0) {
                            System.out.println("ΤΟ ΖΩΟ ΠΟΥ ΑΝΑΖΗΤΗΣΑΤΕ ΔΕΝ ΥΠΑΡΧΕΙ"); //Αν ο κωδικος ζωου που δινει
                            // ο χρηστης δεν υπαρχει

                        } else { for (Animals da : Deleteanimalslist){
                            animalList.remove(da);} //Σβησε το στοιχειο που περιεχει η νεα λιστα απο την παλια αν ο
                            //χρηστης εχει δωσει σωστο κωδικο
                        }

                    }

                }

                //Εβδομη επιλογη: Έξοδος από την εφαρμογή

                if (input == 7) {
                    System.out.println("ΓΙΝΕΤΑΙ ΕΞΟΔΟΣ...");
                    allowexit = true; //Για να εμφανιστει το μηνημα της αποθηκευσης αλλαγων και να
                    //αποκλειστει η κληση τις συναρτησης ZooApp ξανα.
                }


            } catch(InputMismatchException e){
                System.out.println("ΠΑΡΑΚΑΛΩ ΕΙΣΑΓΕΤΕ ΕΝΑΝ ΑΡΙΘΜΟ ΑΠΟ ΤΟ 1-7\n\n\n");
                ZooApp(); //αν δεν δωσει αριθμο ο χρηστης κατα την επιλογη λειτουργιων η διαδικασια επαναλαμβανεται
            }



           try {
                FileOutputStream fileOutputStream = new FileOutputStream("ZooList1.ser");
                ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);//ανοιγμα αρχειου


               objectOutputStream.writeObject(animalList); //εγγραφη της λιστας στο αρχειο


                objectOutputStream.close();
                fileOutputStream.close(); //κλεισιμο αρχειου

                if (allowexit==true){
                    System.out.println("ΟΙ ΑΛΛΑΓΕΣ ΑΠΟΘΗΚΕΥΤΗΚΑΝ");} //Εμφανιση μονο κατα την λειτουργια 7 οπου τιθεται allowexit = true

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }



           if (allowexit == false){ //Κληση της συναρτησης ΖooApp μετα απο το τελος των λειτουργιων 1-6 οπου ειναι
                //allowexit = false
                ZooApp();
            }
        }
            }