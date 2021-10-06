package com.company.oop.books;

import java.util.Comparator;

public class BookComparators {
    public static final Comparator<Book> BY_TITLE = Comparator.comparing(Book::getTitle);
    public static final Comparator<Book> BY_AUTHOR = Comparator.comparing(Book::getAuthor);
    public static final Comparator<Book> BY_PRICE = Comparator.comparingInt(Book::getPrice);
    public static final Comparator<Book> BY_EDITION = Comparator.comparing(Book::getEdition);
    public static final Comparator<Book> BY_ISBN = Comparator.comparingInt(Book::getIsbn);

    public static final Comparator<ProgrammerBook> BY_LANGUAGE = Comparator.comparing(ProgrammerBook::getLanguage);
    public static final Comparator<ProgrammerBook> BY_LEVEL = Comparator.comparingInt(ProgrammerBook::getLevel);
}
