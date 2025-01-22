package info.dmerej.contacts;


import java.io.File;

public class App {

    private final Database database;
    private final ContactsGenerator contactsGenerator;

    public App() {
        File file = new File("contacts.sqlite3");
        if (!file.exists()) {
            database = new Database(file);
            database.migrate();
        } else {
            database = new Database(file);
        }
        contactsGenerator = new ContactsGenerator(database.getConnection());
    }

    public static void main(String[] args) {
        int batchSize = 500;
        if (args.length == 0) {
            System.err.println("Not enough args");
            System.exit(2);
        } else if (args.length > 2 ){
            System.err.println("Too much args");
            System.exit(2);
        } else if (args.length == 2) {
            batchSize = Integer.parseInt(args[1]);
        }

        int count = Integer.parseInt(args[0]);

        App app = null;
        try {
            app = new App();
            long start = System.currentTimeMillis();
            app.contactsGenerator.insertManyContacts(count, batchSize);
            long end = System.currentTimeMillis();
            long elapsed = end - start;
            System.out.format("Creation Query took %d ms\n", elapsed);
            app.lookupContact(count);
        } finally {
            if (app != null) {
                app.close();
            }
        }
    }

    private void lookupContact(int count) {
        String email = String.format("email-%d@tld", count);
        long start = System.currentTimeMillis();
        var contact = database.findContactByEmail(email);
        long end = System.currentTimeMillis();
        long elapsed = end - start;
        System.out.format("Search Query took %d ms\n", elapsed);
        if (contact.isEmpty()) {
            throw new RuntimeException("Contact not found");
        }
    }

    public void close() {
        database.close();
    }

}

