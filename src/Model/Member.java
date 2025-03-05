package Model;

import java.util.Date;

public class Member extends User {

    private String email;
    private String contactNo;
    private MembershipCard membershipCard;
    private boolean active; // Field to track active status

    // Constructor with all fields
    public Member(String userId, String name, String email, String contactNo, MembershipCard membershipCard, boolean active) {
        super(userId, name, null); // Passing null for password
        this.email = email;
        this.contactNo = contactNo;
        this.membershipCard = membershipCard;
        this.active = active; // Initialize active
    }

    // Constructor without active (default is true)
    public Member(String userId, String name, String email, String contactNo, MembershipCard membershipCard) {
        super(userId, name, null);
        this.email = email;
        this.contactNo = contactNo;
        this.membershipCard = membershipCard;
        this.active = true; 
    }

    public Member(String userId, String name, String contactNo, String email, String membershipCardNo) {
        super(userId, name, null);  // Call the parent constructor (assumes a superclass 'User')
        this.contactNo = contactNo;
        this.email = email;
        java.util.Date utilDate = new java.util.Date();
        java.sql.Date expiryDate = new java.sql.Date(utilDate.getTime()); // Default expiry date to current date.

        this.membershipCard = new MembershipCard(membershipCardNo, expiryDate);  // Create the MembershipCard with the given number and expiry date.
    }

    public Member(String userId, String name, String contactNo, String email, MembershipCard membershipCard, java.sql.Date expiryDate) {
        super(userId, name, null); // Passing null for password in the parent constructor
        this.contactNo = contactNo;
        this.email = email;

        // Initialize MembershipCard with the provided expiry date
        this.membershipCard = membershipCard;
        this.membershipCard.setExpiryDate(expiryDate); // Set expiry date in MembershipCard
        this.active = true; // Default to active
    }

    public Member(String userId, String name, String contactNo, String email, MembershipCard membershipCard, Date expiryDate) {
        super(userId, name, null); // Call the superclass constructor (User class)
        this.contactNo = contactNo;
        this.email = email;
        this.membershipCard = membershipCard;

        // Set expiry date within MembershipCard
        if (this.membershipCard != null) {
            this.membershipCard.setExpiryDate((java.sql.Date) expiryDate);
        }
        this.active = true; // Default active status to true
    }

    public Member(String userid,String name, String email, String contactNo, String cardNumber, java.sql.Date expiryDate, boolean active) {

        super(userid, name, null);
        this.email = email;
        this.contactNo = contactNo;
        this.membershipCard = new MembershipCard(cardNumber, expiryDate);
        this.active = active;
    }

    public java.sql.Date getExpiryDate() {
        return membershipCard != null ? membershipCard.getExpiryDate() : null;
    }

    public void setExpiryDate(java.sql.Date expiryDate) {
        if (membershipCard != null) {
            membershipCard.setExpiryDate(expiryDate);
        } else {
            throw new RuntimeException("MembershipCard is not initialized.");
        }
    }

    
    public String getEmail() {
        return email;
    }

    
    public void setEmail(String email) {
        this.email = email;
    }

   
    public String getContactNo() {
        return contactNo;
    }

    
    public void setContactNo(String contactNo) {
        this.contactNo = contactNo;
    }

    
    public MembershipCard getMembershipCard() {
        return membershipCard;
    }

    
    public void setMembershipCard(MembershipCard membershipCard) {
        this.membershipCard = membershipCard;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

  
    @Override
    public String toString() {
        return "Member{"
                + "userId='" + getUserId() + '\''
                + ", name='" + getName() + '\''
                + ", email='" + email + '\''
                + ", contactNo='" + contactNo + '\''
                + ", membershipCard=" + membershipCard
                + ", active=" + active
                + '}';
    }
}
