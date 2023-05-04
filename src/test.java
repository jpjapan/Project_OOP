
import java.io.File;

public class test {

    public static void main(String[] args) {
        String folderName = "myFolder";
        File folder = new File(folderName);

        // Create the folder if it does not exist
        if (!folder.exists()) {
            boolean created = folder.mkdir();
            if (created) {
                System.out.println("Folder " + folderName + " created successfully!");
            } else {
                System.err.println("Failed to create folder " + folderName);
            }
        } else {
            System.out.println("Folder " + folderName + " already exists");
        }
    }
}
