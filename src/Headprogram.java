import javax.swing.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Headprogram {

    public Headprogram() {
        ReadFromFile read = new ReadFromFile();
        List<Person> people = new ArrayList<>(read.getPeople());
        for (Person p : people) {
            LocalDate currentDate = LocalDate.now().minusYears(1);
            LocalDate lastPayedFee = p.getLastPayedFee();
            if(lastPayedFee.isBefore(currentDate)) {
                p.setStatus(MembershipStatus.Inactive);
            }else{
                p.setStatus(MembershipStatus.Active);
            }
            System.out.println(p);
        }
        String input = JOptionPane.showInputDialog(null, "Enter name or identification number");

        for (Person person : people) {
            if (person.getName().equalsIgnoreCase(input) || person.getPersonalIdentityNumber().equals(input)) {
                if (person.getStatus().equals(MembershipStatus.Active)) {
                    WriteToFile write = new WriteToFile();
                    write.addGymVisitor(person);
                    JOptionPane.showMessageDialog(null, "Welcome to the gym");
                    break;
                } else if (person.getStatus().equals(MembershipStatus.Inactive)) {
                    JOptionPane.showMessageDialog(null, "Your membership is not active");
                    System.out.println("Your membership is not active");
                    break;
                }
            }
        }

    }
    public static void main(String[] args) {
        Headprogram hp = new Headprogram();
    }
}
