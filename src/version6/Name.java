package version6;

import java.util.Objects;

public final class Name implements Cloneable {

    private String firstName;
    private String middleName;
    private String lastName;
    private String suffix;

    public Name() {
        this("N/A", "", "N/A", "");
    }

    public Name(String firstName, String lastName) {
        this(firstName, "", lastName, "");
    }

    public Name(String firstName, String middleName, String lastName) {
        this(firstName, middleName, lastName, "");
    }

    public Name(String firstName, String middleName,
                String lastName, String suffix) {

        if (firstName == null || firstName.trim().isEmpty()
                || lastName == null || lastName.trim().isEmpty()) {

            throw new IllegalArgumentException(
                    "Name fields cannot be empty"
            );
        }

        this.firstName = firstName;
        this.middleName = middleName == null ? "" : middleName;
        this.lastName = lastName;
        this.suffix = suffix == null ? "" : suffix;
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

        if (firstName == null || firstName.trim().isEmpty()) {
            throw new IllegalArgumentException(
                    "Name fields cannot be empty"
            );
        }

        this.firstName = firstName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName == null ? "" : middleName;
    }

    public void setLastName(String lastName) {

        if (lastName == null || lastName.trim().isEmpty()) {
            throw new IllegalArgumentException(
                    "Name fields cannot be empty"
            );
        }

        this.lastName = lastName;
    }

    public void setSuffix(String suffix) {
        this.suffix = suffix == null ? "" : suffix;
    }

    public void displayName() {
        System.out.println(toString());
    }

    @Override
    public String toString() {

        String result = lastName + ", " + firstName;

        if (!middleName.trim().isEmpty()) {
            result += " " + middleName.charAt(0) + ".";
        }

        if (!suffix.trim().isEmpty()) {
            result += " " + suffix;
        }

        return result;
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