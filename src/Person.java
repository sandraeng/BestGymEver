import java.time.LocalDate;

public class Person {
    private String name;
    private String personalIdentityNumber;
    private LocalDate lastPayedFee;
    private MembershipStatus status;

    @Override
    public String toString() {
        return this.name + " " + this.personalIdentityNumber + " " + this.lastPayedFee + " " + getStatus().membershipStatus;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPersonalIdentityNumber() {
        return personalIdentityNumber;
    }

    public void setPersonalIdentityNumber(String personalIdentityNumber) {
        this.personalIdentityNumber = personalIdentityNumber;
    }

    public LocalDate getLastPayedFee() {
        return lastPayedFee;
    }

    public void setLastPayedFee(LocalDate lastPayedFee) {
        this.lastPayedFee = lastPayedFee;
    }
    public MembershipStatus getStatus() {
        return status;
    }
    public void setStatus(MembershipStatus status) {
        this.status = status;
    }
}
