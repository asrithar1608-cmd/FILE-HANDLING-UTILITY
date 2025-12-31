 import java.io.*;
import java.util.Scanner;

public class A1 {

    // Write data to file
    static void writeFile(String fileName, String content) {
        try {
            FileWriter fw = new FileWriter(fileName);
            fw.write(content);
            fw.close();
            System.out.println("✔ Data written to file successfully.");
        } catch (IOException e) {
            System.out.println("❌ Error writing to file.");
        }
    }

    // Read data from file
    static void readFile(String fileName) {
        try {
            BufferedReader br = new BufferedReader(new FileReader(fileName));
            String line;

            System.out.println("\n📄 File Content:");
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
            br.close();
        } catch (IOException e) {
            System.out.println("❌ Error reading file.");
        }
    }

    // Modify (append) data to file
    static void modifyFile(String fileName, String content) {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(fileName, true));
            bw.newLine();
            bw.write(content);
            bw.close();
            System.out.println("✔ File modified successfully.");
        } catch (IOException e) {
            System.out.println("❌ Error modifying file.");
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String fileName = "codtech_file.txt";
        int choice;

        do {
            System.out.println("\n===== FILE HANDLING UTILITY =====");
            System.out.println("1. Write to File");
            System.out.println("2. Read File");
            System.out.println("3. Modify File");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine(); // clear buffer

            switch (choice) {
                case 1:
                    System.out.print("Enter content to write: ");
                    String writeData = sc.nextLine();
                    writeFile(fileName, writeData);
                    break;

                case 2:
                    readFile(fileName);
                    break;

                case 3:
                    System.out.print("Enter content to append: ");
                    String modifyData = sc.nextLine();
                    modifyFile(fileName, modifyData);
                    break;

                case 4:
                    System.out.println("👋 Exiting program.");
                    break;

                default:
                    System.out.println("❌ Invalid choice.");
            }
        } while (choice != 4);

        sc.close();
    }
}
