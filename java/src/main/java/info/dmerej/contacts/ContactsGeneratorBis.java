package info.dmerej.contacts;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ContactsGeneratorBis {
    private final Connection connection;

    public ContactsGeneratorBis(Connection connection) {
        this.connection = connection;
    }

    public void insertManyContacts(int numContacts, int batchSize) {
        System.out.format("Inserting %d contacts ...%n", numContacts);

        String query = "INSERT INTO contacts (id, name, email) VALUES (?, ?, ?)";

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            for (int i = 0; i < numContacts; i++) {
                int id = i + 1;
                String userName = "user-" + id;
                String email = "email-" + id + "@tld";

                // Set parameters
                statement.setInt(1, id);
                statement.setString(2, userName);
                statement.setString(3, email);

                // Add to batch
                statement.addBatch();

                // Execute batch periodically for efficiency
                if (i % batchSize == 0 && i > 0) {
                    statement.executeBatch();
                }
            }

            // Execute remaining batch
            statement.executeBatch();
            System.out.println("Insertion done!");
        } catch (SQLException e) {
            throw new RuntimeException("Failed to insert contacts into the database", e);
        }
    }

    public void insertContacts(int numContacts) {
        for (int i = 1 ; i < numContacts + 1 ; i++) {
            try {
                PreparedStatement statement = connection.prepareStatement("INSERT INTO contacts VALUES (" + i + " contacts, email-" + i + "@domain.tld);");

                statement.executeQuery();
            } catch (SQLException e) {
                throw new RuntimeException("Something failed when adding users to database");
            }
        }
    }
}