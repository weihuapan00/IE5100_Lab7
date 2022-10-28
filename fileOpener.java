import java.io.*;
import java.util.*;
public class fileOpener {
    private String filename;// filename location
    private LinkedList<String> str_list = new LinkedList<>();
    
    //constructor
    public fileOpener(String filename){
       setFilename(filename); 
    }

    // read file from filename
    public void readFile(){
        try {
            File myObj = new File("Annual.csv");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
              String data = myReader.nextLine();
              str_list.add(data);
            }
            myReader.close();
          } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
          }
    }

    // write file to filename
    public void writeFile(String filename){
        setFilename(filename);
        try {
            FileWriter myWriter = new FileWriter(filename);
            for (String str : str_list){
                myWriter.write(str);
            }
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
          } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
          }
    }

    public String getFilename() {
        return filename;
    }
    public void setFilename(String filename) {
        this.filename = filename;
    }

    

}

