import java.io.File;  // Import the File class
import java.io.FileWriter;
import java.io.IOException;  // Import the IOException class to handle errors

class CreateAndWriteFile {
    public static void main() {
        try {
            File myObj = new File(java.time.Clock.systemUTC().instant() + "-emails.json");
            WriteFile(myObj);
            if (myObj.createNewFile()) {
                System.out.println("File created: " + myObj.getName());
            } else {
                System.out.println("File already exists.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public static void WriteFile(File args) {
        try {
            FileWriter myWriter = new FileWriter(args);
            myWriter.write("[ \n");
            for (int i = 0; i < 101; i++) {
                myWriter.write("    {\"emailAddress\":\"test-emails-"+ i + "-" + ReturnDate() +
                        "@emailreaction.org\"}");
                if (i!=100) {
                    myWriter.write(",\n");
                }
            }
            myWriter.write("\n]");
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
    static String ReturnDate(){
        String date = String.valueOf(java.time.Clock.systemUTC().instant());
        String newDate = date.replaceAll("[:\\-.]","");
        return newDate;
        }
    }
