public enum MembershipStatus {
    Active("Active membership"),
    Inactive("Inactive membership");

    public final String membershipStatus;

    MembershipStatus(String membershipStatus) {
        this.membershipStatus = membershipStatus;
    }
}
