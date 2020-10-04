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
            FileWriter write = new FileWriter(dir, true);
            BufferedWriter writer = new BufferedWriter(write);
            writer.write("\n"+email+","+password+","+person.getName()+","+person.getSurname()+","+person.getData());
            read.close();
            writer.close();
        }
        catch(IOException ex){
            System.out.println(ex.getMessage());
        }

    }

    @Override
    public void removeAccount(String email, String password) throws WrongCredentialsException {
        try {
            File file = new File("C:\\Users\\User\\IdeaProjects\\task4\\src\\task4","data.txt");

            BufferedReader reader = new BufferedReader(new FileReader(file));
            String mainLine = "";

            String line;
            String[] subLine;
            boolean bool = false;

            while ((line =reader.readLine()) != null) {
                subLine = line.split(",");
                if (subLine[0].equals(email) && subLine[1].equals(password)) {
                    bool = true;
                }
                else {
                    mainLine += "\n";
                    mainLine += line;
                }
            }

            if (bool) {
                File rfile = new File("C:\\Users\\User\\IdeaProjects\\task4\\src\\task4","data.txt");
                BufferedWriter rwriter = new BufferedWriter(new FileWriter(rfile));
                rwriter.write(mainLine);


                rwriter.close();
                reader.close();


            }
            else {

                reader.close();
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
        BufferedReader reader = null;
        try {
            File file = new File("C:\\Users\\User\\IdeaProjects\\task4\\src\\task4","data.txt");
            reader = new BufferedReader(new FileReader(file));

            String line;
            String[] subLine;

            while ((line =reader.readLine()) != null) {
                subLine = line.split(",");
                if (subLine[0].equals(email) && subLine[1].equals(password)) {
                    Person pers = new Person(subLine[2], subLine[3], subLine[4]);
                    return pers;
                }
            }

            AttemptCounter counter = AttemptCounter.getInstance();

            if (counter.getCount() > 5) {
                throw new TooManyLoginAttemptsException();
            }
            else {
                throw new WrongCredentialsException();
            }
        }

        catch(IOException ex){
            System.out.println(ex.getMessage());
        } finally {

            try {
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    @Override
    public int numOfAccounts() throws IOException {
        File file = new File("C:\\Users\\User\\IdeaProjects\\task4\\src\\task4","data.txt");
        BufferedReader reader = new BufferedReader(new FileReader(file));
        int lines = 0;
        while (reader.readLine() != null) lines++;
        reader.close();
        return lines;
    }
}
