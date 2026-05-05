import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;
//import.java.nio.file.StandardOpenOption; // kalo mau nambahin doang, ga replace
public class TulisFile2 {
    public static void main(String[] args) {
    var keyboard = new Scanner(System.in);
    var path = Paths.get("test.txt"); //bikin file baru dengan nama test.txt
    System.out.print("Masukkan teks yang akan disimpan: ");
    var text = keyboard.nextLine();

    try {
        Files.writeString(path, text); //menulis string ke file, kalau file belum ada, maka akan dibuat baru, kalau sudah ada, maka akan di replace
    } catch (IOException e) {
        System.err.println("Gagal menulis ke file");
    }
  }
}