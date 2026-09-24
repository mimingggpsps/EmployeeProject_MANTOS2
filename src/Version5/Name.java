package Version5;

import java.util.Objects;

public class Name implements Cloneable {

    private String firstName;
    private String middleName;
    private String lastName;
    private String suffix;

    public Name() {
        this.firstName = "N/A";
        this.middleName = "N/A";
        this.lastName = "N/A";
        this.suffix = "";
    }

    public Name(String firstName, String lastName) {
        this.firstName = firstName;
        this.middleName = "N/A";
        this.lastName = lastName;
        this.suffix = "";
    }

    public Name(String firstName, String middleName, String lastName) {
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.suffix = "";
    }

    public Name(String firstName, String middleName, String lastName, String suffix) {
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.suffix = suffix;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getSuffix() {
        return suffix;
    }

    public void setFirstName(String firstName) {
        if (firstName == null) {
            this.firstName = "N/A";
        } else {
            this.firstName = firstName;
        }
    }

    public void setMiddleName(String middleName) {
        if (middleName == null) {
            this.middleName = "N/A";
        } else {
            this.middleName = middleName;
        }
    }

    public void setLastName(String lastName) {
        if (lastName == null) {
            this.lastName = "N/A";
        } else {
            this.lastName = lastName;
        }
    }

    public void setSuffix(String suffix) {
        if (suffix == null) {
            this.suffix = "";
        } else {
            this.suffix = suffix;
        }
    }

    public void displayName() {

        String mi = "";

        if (!middleName.equals("N/A") && middleName.length() > 0) {
            mi = middleName.charAt(0) + ". ";
        }

        if (suffix.length() > 0) {
            System.out.println(
                    lastName + ", " + firstName + " " + mi + suffix
            );
        } else {
            System.out.println(
                    lastName + ", " + firstName + " " + mi
            );
        }
    }

    @Override
    public String toString() {

        String mi = "";

        if (!middleName.equals("N/A") && middleName.length() > 0) {
            mi = middleName.charAt(0) + ". ";
        }

        if (suffix.length() > 0) {
            return lastName + ", " + firstName + " " + mi + suffix;
        } else {
            return lastName + ", " + firstName + " " + mi;
        }
    }

    @Override
    public boolean equals(Object obj) {

        if (this == obj) {
            return true;
        }

        if (!(obj instanceof Name)) {
            return false;
        }

        Name other = (Name) obj;

        return firstName.equalsIgnoreCase(other.firstName)
                && middleName.equalsIgnoreCase(other.middleName)
                && lastName.equalsIgnoreCase(other.lastName)
                && suffix.equalsIgnoreCase(other.suffix);
    }

    @Override
    public int hashCode() {

        return Objects.hash(
                firstName.toLowerCase(),
                middleName.toLowerCase(),
                lastName.toLowerCase(),
                suffix.toLowerCase()
        );
    }

    @Override
    public Name clone() {

        try {
            return (Name) super.clone();

        } catch (CloneNotSupportedException e) {
            throw new AssertionError(e);
        }
    }
}