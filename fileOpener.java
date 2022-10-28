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
            File myObj = new File(filename);
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
                String[] list = str.split(",",4);
                String toWrite = "";
                for(int i = 0; i<2; i++){
                  toWrite += list[i] + ",";
                }
                toWrite += list[2] + "\n";

                myWriter.write(toWrite);
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

    public LinkedList<String> getStr_list() {
        return str_list;
    }


}

