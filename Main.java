import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n--- Aplikasi Media Sosial ---");
            System.out.println("1. Tambah Pengguna");
            System.out.println("2. Lihat Semua Pengguna");
            System.out.println("3. Buat Postingan");
            System.out.println("4. Lihat Semua Postingan");
            System.out.println("5. Keluar");
            System.out.print("Masukkan pilihan: ");

            while (!scanner.hasNextInt()) {
                System.out.println("Input tidak valid! Masukkan angka.");
                scanner.next();
            }

            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Masukkan Username: ");
                    String username = scanner.nextLine();
                    System.out.print("Masukkan Email: ");
                    String email = scanner.nextLine();
                    System.out.print("Masukkan Password (hashed): ");
                    String passwordHash = scanner.nextLine();
                    System.out.print("Masukkan Nama Lengkap: ");
                    String fullName = scanner.nextLine();

                    UserOperations.addUser(username, email, passwordHash, fullName);
                    break;

                case 2:
                    UserOperations.viewUsers();
                    break;

                case 3:
                    System.out.print("Masukkan ID Pengguna: ");
                    int userId = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    System.out.print("Masukkan Konten Postingan: ");
                    String content = scanner.nextLine();

                    PostOperations.addPost(userId, content);
                    break;

                case 4:
                    PostOperations.viewPosts();
                    break;

                case 5:
                    System.out.println("Keluar dari aplikasi...");
                    break;

                default:
                    System.out.println("Pilihan tidak valid! Masukkan angka 1-5.");
            }
        } while (choice != 5);

        scanner.close();
    }
}