package task4;

import java.io.*;

public class Program {

    public static void main(String[] args) {
        Person Olga = new Person("Olga", "Ptuhova", "03.02.1956");
        AccountManagerImpl mailManager = new AccountManagerImpl();
        try {
            mailManager.registerNewAccount("olga56@mail.ru", "lkoi900", Olga);
        } catch (DuplicateAccountException e) {
            e.printStackTrace();
        }


    }
}

