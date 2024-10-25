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
        for (Person p : people) {
            if (p.getName().equals(input) || p.getPersonalIdentityNumber().equals(input)) {
                if(p.getStatus().equals(MembershipStatus.Active)) {
                    WriteToFile write = new WriteToFile();
                    write.addGymVisitor(p);
                    JOptionPane.showMessageDialog(null, "Welcome to the gym");
                }else if (p.getStatus().equals(MembershipStatus.Inactive)) {
                    JOptionPane.showMessageDialog(null, "Your membership is not active");
                    System.out.println("Your membership is not active");
                }

            }else{
                JOptionPane.showMessageDialog(null, "You have never been a member in this gym");
                break;
            }
        }

    }
    public static void main(String[] args) {
        Headprogram hp = new Headprogram();
    }
}
