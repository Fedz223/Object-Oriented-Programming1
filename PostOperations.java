import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PostOperations {
    public static void addPost(int userId, String content) {
        String query = "INSERT INTO posts (user_id, content) VALUES (?, ?)";

        try (Connection conn = DatabaseConnection.connect();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, userId);
            stmt.setString(2, content);

            int rowsInserted = stmt.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("Postingan berhasil dibuat!");
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public static void viewPosts() {
        String query = "SELECT posts.id, users.username, posts.content, posts.created_at " +
                       "FROM posts JOIN users ON posts.user_id = users.id ORDER BY posts.created_at DESC";

        try (Connection conn = DatabaseConnection.connect();
             PreparedStatement stmt = conn.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                System.out.println("Post ID: " + rs.getInt("id") +
                        ", Username: " + rs.getString("username") +
                        ", Content: " + rs.getString("content") +
                        ", Created At: " + rs.getTimestamp("created_at"));
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}