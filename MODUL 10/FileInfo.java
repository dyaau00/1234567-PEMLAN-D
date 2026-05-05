import java.io.File;
import java.util.Date;
public class FileInfo {
public static void main(String[] args) {
var file = new File(".");
System.out.println("Apakah sebuah direktori? " + file.isDirectory());
    if (file.isDirectory()) {
    System.out.println("\nDaftar file di dalam direktori ini:");    
    String[] daftarFile = file.list();

    if (daftarFile != null) {
        for (String namaFile : daftarFile) {
        System.out.println("- " + namaFile);
        }
    }
    } else {
    System.out.println("Ini bukan direktori, tidak bisa list file.");
    }
    
// System.out.println("File ada? " + file.exists());
// System.out.printf("Path: %s\n",
// file.getAbsolutePath());

// System.out.println("Last modified: " + new
// Date(file.lastModified()));

// System.out.printf("Ukuran file: %d KB\n",
// file.length() / 1024);

// System.out.println("File bisa dibaca? " +
// file.canRead());

// System.out.println("File bisa ditulis? " +
// file.canWrite());

// System.out.println("Apakah sebuah direktori? " +
// file.isDirectory());

// System.out.println("Apakah sebuah file? " +
// file.isFile());

// System.out.println("Apakah hidden? " +
// file.isHidden());
    }
}