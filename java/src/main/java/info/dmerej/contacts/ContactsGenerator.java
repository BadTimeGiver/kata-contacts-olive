package info.dmerej.contacts;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ContactsGenerator {
    private final Connection connection;

    public ContactsGenerator(Connection connection) {
        this.connection = connection;
    }

    public void insertManyContacts(int numContacts, int batchSize) {
        System.out.format("Inserting %d contacts ...%n", numContacts);

        String query = "INSERT INTO contacts (name, email) VALUES (?, ?)";

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            connection.setAutoCommit(false);
            for (int i = 0; i < numContacts; i++) {
                int id = i + 1;
                String userName = "user-" + id;
                String email = "email-" + id + "@tld";

                // Set parameters
                statement.setString(1, userName);
                statement.setString(2, email);

                // Add to batch
                statement.addBatch();

                // Execute batch periodically for efficiency
                if (i % batchSize == 0 && i > 0) {
                    statement.executeBatch();
                }
            }

            // Execute remaining batch
            statement.executeBatch();
        } catch (SQLException e) {
            throw new RuntimeException("Failed to insert contacts into the database", e);
        }
    }
}
