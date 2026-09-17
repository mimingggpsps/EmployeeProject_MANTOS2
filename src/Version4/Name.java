package Version4;

public class Name implements Cloneable {
    private String firstName;
    private String middleName;
    private String lastName;
    private String suffix;

        public Name() {
            firstName = "N/A";
            middleName = "N/A";
            lastName = "N/A";
            suffix = "";
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
            this.firstName = firstName;
        }

        public void setMiddleName(String middleName) {
            this.middleName = middleName;
        }

        public void setLastName(String lastName) {
            this.lastName = lastName;
        }

        public void setSuffix(String suffix) {
            this.suffix = suffix;
        }

    public String displayName() {
        String result = lastName + ", " + firstName;

        if (!middleName.equals("")) {
            result = result + " " + middleName.charAt(0) + ".";
        }

        if (!suffix.equals("")) {
            result = result + " " + suffix;
        }

        return result;
    }

    @Override
    public String toString() {
        return displayName();
    }

    @Override
    public boolean equals(Object obj) {

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
        return java.util.Objects.hash(firstName, middleName, lastName, suffix);
    }

    @Override
    public Name clone() {
        try {
            return (Name) super.clone();
        } catch (CloneNotSupportedException e) {
            return null;
        }
    }
}