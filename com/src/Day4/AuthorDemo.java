package com.Day4;
class Author {
    private String name;
    private String email;
    private char gender;

    public Author(String n, String e, char g) {
        name = n;
        email = e;
        gender = g;
    }

    // Getters
    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public char getGender() {
        return gender;
    }

    // Setters
    public void setName(String n) {
        name = n;
    }

    public void setEmail(String e) {
        email = e;
    }

    public void setGender(char g) {
        gender = g;
    }


    public String toString() {
        return "Author Name: " + name + ", Email: " + email + ", Gender: " + gender;
    }
}


class Book {
    private String name;
    private Author author;
    private double price;
    private int qtyInStock;


    public Book(String n, Author a, double p, int q) {
        name = n;
        author = a;
        price = p;
        qtyInStock = q;
    }

    // Getters
    public String getName() {
        return name;
    }

    public Author getAuthor() {
        return author;
    }

    public double getPrice() {
        return price;
    }

    public int getQtyInStock() {
        return qtyInStock;
    }

    // Setters
    public void setName(String n) {
        name = n;
    }

    public void setAuthor(Author a) {
        author = a;
    }

    public void setPrice(double p) {
        price = p;
    }

    public void setQtyInStock(int q) {
        qtyInStock = q;
    }


    public void displayDetails() {
        System.out.println("Book Name: " + name);
        System.out.println(author.toString());
        System.out.println("Price: ₹"  + price);
        System.out.println("Quantity in Stock: " + qtyInStock);
    }
}


public class AuthorDemo {
    public static void main(String[] args) {
        Author author1 = new Author("R.K. Narayan", "rk.narayan@example.com", 'M');
        Book book1 = new Book("Malgudi Days", author1, 499.99, 20);
        book1.displayDetails();
    }
}


