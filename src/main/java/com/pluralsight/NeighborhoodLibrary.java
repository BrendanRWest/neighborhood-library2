package com.pluralsight;
import java.util.Scanner;

        public class NeighborhoodLibrary {
            public static void main(String[] args) {
                Scanner scan = new Scanner(System.in);
                Book[] books = {
                        new Book(123, "978-0439139595", "Harry Potter and the Goblet of Fire by J.K. Rowling", false, ""),
                        new Book(124, "978-0307743664", "Carrie by Stephen King", false, ""),
                        new Book(125, "978-0441172719", "Dune by Paul Atreides", false, ""),
                        new Book(126, "978-0451524935", "1984 by George Orwell", false, ""),
                        new Book(127, "978-0061120084", "To Kill a Mockingbird by Harper Lee", false, ""),
                        new Book(128, "978-0743273565", "The Great Gatsby by F. Scott Fitzgerald", false, ""),
                        new Book(129, "978-0316769488", "The Catcher in the Rye by J.D. Salinger", false, ""),
                        new Book(130, "978-0547928227", "The Hobbit by J.R.R. Tolkien", false, ""),
                        new Book(131, "978-0618640157", "The Lord of the Rings by J.R.R. Tolkien", false, ""),
                        new Book(132, "978-0141439518", "Pride and Prejudice by Jane Austen", false, ""),
                        new Book(133, "978-0141439600", "Jane Eyre by Charlotte Bronte", false, ""),
                        new Book(134, "978-0141439556", "Wuthering Heights by Emily Bronte", false, ""),
                        new Book(135, "978-0060850524", "Brave New World by Aldous Huxley", false, ""),
                        new Book(136, "978-1451673319", "Fahrenheit 451 by Ray Bradbury", false, ""),
                        new Book(137, "978-0140283334", "Lord of the Flies by William Golding", false, ""),
                        new Book(138, "978-0142437247", "Moby Dick by Herman Melville", false, ""),
                        new Book(139, "978-0140449266", "The Count of Monte Cristo by Alexandre Dumas", false, ""),
                        new Book(140, "978-0140449136", "Crime and Punishment by Fyodor Dostoevsky", false, "")
                };

                System.out.println("Welcome to your neighborhood library!");

                boolean condition1 = false;
                boolean bigCondition = false;
                int choice = 0;
                int choice2;
                String choice3;
                String name;

                while(!bigCondition){
                    while (!condition1){
                        System.out.println("\n------- Home -------");
                        System.out.println();
                        System.out.println("1. Show Available Books");
                        System.out.println("2. Show Checked Out Books");
                        System.out.println("3. Exit\n");
                        System.out.print("Your choice: ");
                        choice = scan.nextInt();
                        scan.nextLine();

                        if(choice > 0 && choice <= 3){
                            condition1 = true;
                        } else {
                            System.out.println("Invalid choice, please try again.");
                        }
                    }
                    switch (choice) {
                        case 1:
                            System.out.println("------- Available Books -------\n");
                            for (int i = 0; i < books.length; i++) {
                                if (!books[i].isCheckedOut()){
                                    System.out.println(books[i]);
                                }
                            }

                            System.out.println("\n1.) Check out a book: ");
                            System.out.println("2.) Exit to home screen");

                            System.out.print("\nYour choice: ");

                            choice2 = scan.nextInt();
                            scan.nextLine();

                            if(choice2 == 1){

                                System.out.println("Please enter the ID of the book you'd like to check out.");
                                int idChoice =  scan.nextInt();
                                scan.nextLine();

                                System.out.print("Please enter your name: ");
                                name = scan.nextLine();

                                for (int i = 0; i < books.length; i++) {
                                    if (!books[i].isCheckedOut() && (books[i].getId() == idChoice)){
                                        books[i].checkOut(name);
                                        books[i].setCheckedOutTo(name);
                                        books[i].setCheckedOut(true);
                                    }
                                }
                            } else {
                                condition1 = false;
                            }
                            break;
                        case 2:
                            System.out.println("------- Checked Out Books -------\n");
                            for (int i = 0; i < books.length; i++) {
                                if (books[i].isCheckedOut()){
                                    System.out.println(books[i]);
                                }
                            }

                            System.out.println("(C:) Check in a book ");
                            System.out.println("(X:) Go back to home screen");
                            System.out.println("Please enter your selection (C or X) ");

                            choice3 = scan.nextLine();

                            if(choice3.equalsIgnoreCase("C")){
                                System.out.println("Enter the id of the book you're checking in: ");
                                System.out.println();
                                int idChoice2 = scan.nextInt();
                                scan.nextLine();

                                for (int i = 0; i < books.length; i++) {
                                    if (books[i].isCheckedOut() && (books[i].getId() == idChoice2)){
                                        books[i].checkIn();
                                        books[i].setCheckedOutTo("");
                                    }
                                }
                            } else {
                                condition1 = false;
                            }
                            break;
                        case 3:
                            bigCondition = true;
                            break;
                        default:
                            break;
                    }
                }
            }
        }

