package Model;

import java.util.Date;

public class MembershipCard {

    private String cardNumber;
    private java.sql.Date expiryDate;

    public MembershipCard(String cardNumber, java.sql.Date expiryDate) {
    this.cardNumber = cardNumber;  // Assign the card number to the instance variable
    this.expiryDate = expiryDate; // Assign the expiry date to the instance variable
}


    // Getter for expiryDate
    public java.sql.Date getExpiryDate() {
        return expiryDate;
    }

    // Setter for expiryDate
    public void setExpiryDate(java.sql.Date expiryDate) {
        this.expiryDate = expiryDate;
    }

    // Getter for cardNumber
    public String getCardNumber() {
        return cardNumber;
    }

    // Setter for cardNumber
    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }


    @Override
    public String toString() {
        return "MembershipCard{" +
                "cardNumber='" + cardNumber + '\'' +
                ", expiryDate=" + expiryDate +
                '}';
    }

}
