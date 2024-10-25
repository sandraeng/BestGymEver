import javax.swing.*;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class WriteToFile {
    public void addGymVisitor(Person person) {

        try(BufferedWriter bw = new BufferedWriter(new FileWriter("src/Data/gymVisitors.txt", true)))
        {
            bw.write(person.toString());
            bw.newLine();
        }catch(
        IOException e){
            JOptionPane.showMessageDialog(null, e);
        }
    }
}
