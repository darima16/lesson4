package task4;

import java.io.*;

public class Program {

    public static void main(String[] args) {
        Person Olga = new Person("Olga", "Ptuhova", "03.02.1956");
        AccountManagerImpl mailManager = new AccountManagerImpl();

        // зарегистрируем нового пользователя
        try {
            mailManager.registerNewAccount("olga56@mail.ru", "lkoi900", Olga);
        } catch (DuplicateAccountException e) {
            e.printStackTrace();
        }

        // зарегистрируем уже существующего пользователя
        try {
            mailManager.registerNewAccount("olga56@mail.ru", "lkoi900", Olga);
        } catch (DuplicateAccountException e) {
            e.printStackTrace();
        }
        // удалим несуществующий аккаунт
        try {
            mailManager.removeAccount("ввв@mail.ru","lk]i900");
        } catch (WrongCredentialsException e) {
            e.printStackTrace();
        }

        // удалим существующий аккаунт
        try {
            mailManager.removeAccount("olga56@mail.ru","lkoi900");
        } catch (WrongCredentialsException e) {
            e.printStackTrace();
        }

        // проверим, существует ли аккаунт
        System.out.println(mailManager.hasAccount("f.himnovs@mail.ru"));

        // количество аккаунтов
        try {
            System.out.println(mailManager.numOfAccounts());
        } catch (IOException e) {
            e.printStackTrace();
        }

        //
        try {
            System.out.println(mailManager.getPerson("f.himnovs@mail.ru", "qwerty12"));
        } catch (TooManyLoginAttemptsException e) {
        e.printStackTrace();
        } catch (WrongCredentialsException e) {
        e.printStackTrace();
        }
        try {
            System.out.println(mailManager.getPerson("f.himnovs@mail.ru", "qwerty12"));
        } catch (TooManyLoginAttemptsException e) {
            e.printStackTrace();
        } catch (WrongCredentialsException e) {
            e.printStackTrace();
        }try {
            System.out.println(mailManager.getPerson("f.himnovs@mail.ru", "qwerty12"));
        } catch (TooManyLoginAttemptsException e) {
            e.printStackTrace();
        } catch (WrongCredentialsException e) {
            e.printStackTrace();
        }try {
            System.out.println(mailManager.getPerson("f.himnovs@mail.ru", "qwerty12"));
        } catch (TooManyLoginAttemptsException e) {
            e.printStackTrace();
        } catch (WrongCredentialsException e) {
            e.printStackTrace();
        }try {
            System.out.println(mailManager.getPerson("f.himnovs@mail.ru", "qwerty12"));
        } catch (TooManyLoginAttemptsException e) {
            e.printStackTrace();
        } catch (WrongCredentialsException e) {
            e.printStackTrace();
        }try {
            System.out.println(mailManager.getPerson("f.himnovs@mail.ru", "qwerty12"));
        } catch (TooManyLoginAttemptsException e) {
            e.printStackTrace();
        } catch (WrongCredentialsException e) {
            e.printStackTrace();
        }
    }
}

