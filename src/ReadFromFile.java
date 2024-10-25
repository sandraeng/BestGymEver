import javax.swing.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ReadFromFile {


    public List<Person> getPeople() {
        try(BufferedReader br = new BufferedReader(new FileReader("src/Data/data.txt"))) {
            List<Person> people = new ArrayList<>();
            List<String> allLines = new ArrayList<>();

            String line;
            while ((line = br.readLine()) != null) {
                allLines.add(line);

            }
            for (int i = 0; i < allLines.size(); i++) {
                Person person = new Person();
                if(allLines.get(i).contains(",")){
                    person.setPersonalIdentityNumber(allLines.get(i).substring(0,allLines.get(i).indexOf(",")));
                    person.setName(allLines.get(i).substring(allLines.get(i).indexOf(" ")+1));
                }
                i++;
                if(allLines.get(i).contains("-")){

                    person.setLastPayedFee(LocalDate.parse(allLines.get(i)));
                }
                people.add(person);
            }
            return people;
        }
        catch(IOException e){
            JOptionPane.showMessageDialog(null, e);
        }
        return null;
    }
}
