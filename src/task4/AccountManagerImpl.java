package task4;

import java.io.*;

public class AccountManagerImpl implements AttemptManager {
    @Override
    public void registerNewAccount(String email, String password, Person person) throws DuplicateAccountException {
        try {
            File dir = new File("C:\\Users\\User\\IdeaProjects\\task4\\src\\task4","data.txt");
            FileReader read = new FileReader(dir);
            BufferedReader reader = new BufferedReader(read);

            String line;
            String[] subLine;
            while ((line =reader.readLine()) != null) {
                subLine = line.split(",");
                if (subLine[0].equals(email)) {
                    throw new DuplicateAccountException();
                }
            }
            read.close();
            FileWriter write = new FileWriter(dir, true);
            BufferedWriter writer = new BufferedWriter(write);
            writer.write(email+","+password+","+person.getName()+","+person.getSurname()+"\n");

        }
        catch(IOException ex){
            System.out.println(ex.getMessage());
        }

    }

    @Override
    public void removeAccount(String email, String password) throws WrongCredentialsException {
        try {
            File file = new File("C:\\Users\\User\\IdeaProjects\\task4\\src\\task4","data.txt");
            File newFile = new File("data2.txt");

            BufferedReader reader = new BufferedReader(new FileReader(file));
            BufferedWriter writer = new BufferedWriter(new FileWriter(newFile));

            String line;
            String[] subLine;
            boolean bool = false;

            while ((line =reader.readLine()) != null) {
                subLine = line.split(",");
                if (subLine[0].equals(email) && subLine[1].equals(password)) {
                    bool = true;
                }
                else {
                    writer.write(line);
                    writer.newLine();
                }
            }

            if (bool) {
                reader.close();
                writer.close();
                file.delete();
                newFile.renameTo(file);
            }
            else {
                reader.close();
                writer.close();
                newFile.delete();
                throw new WrongCredentialsException();
            }
        }

        catch(IOException ex){
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public boolean hasAccount(String email) {
        try {
            File file = new File("C:\\Users\\User\\IdeaProjects\\task4\\src\\task4","data.txt");
            BufferedReader reader = new BufferedReader(new FileReader(file));

            String line;
            String[] subLine;
            boolean bool = false;

            while ((line =reader.readLine()) != null) {
                subLine = line.split(",");
                if (subLine[0].equals(email)) {
                    return true;
                }
            }
        }

        catch(IOException ex){
            System.out.println(ex.getMessage());
        }
        return false;
    }

    @Override
    public Person getPerson(String email, String password) throws TooManyLoginAttemptsException, WrongCredentialsException {
        try {
            File file = new File("C:\\Users\\User\\IdeaProjects\\task4\\src\\task4","data.txt");
            BufferedReader reader = new BufferedReader(new FileReader(file));

            String line;
            String[] subLine;
            boolean bool = false;

            while ((line =reader.readLine()) != null) {
                subLine = line.split(",");
                if (subLine[0].equals(email) && subLine[1].equals(password)) {
                    Person person = new Person(subLine[2], subLine[3], subLine[4]);
                    return person;
                }
            }
            reader.close();
            AttemptCounter counter = new AttemptCounter();
            if (counter.count > 5) {
                throw new TooManyLoginAttemptsException();
            }
            else {
                throw new WrongCredentialsException();
            }
        }

        catch(IOException ex){
            System.out.println(ex.getMessage());
        }
        return null;
    }

    @Override
    public int numOfAccounts() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("data.txt"));
        int lines = 0;
        while (reader.readLine() != null) lines++;
        reader.close();
        return lines;
    }
}
