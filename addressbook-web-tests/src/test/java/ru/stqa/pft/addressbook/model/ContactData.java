package ru.stqa.pft.addressbook.model;

public class ContactData {
    private int id;
    private String firstname;
    private String middlename;
    private String lastname;
    private String home;
    private String mobile;
    private String email;
    private String email2;
    private String byear;
    private String address2;
    private String phone2;

    public ContactData(String firstname, String middlename, String lastname, String home, String mobile, String email, String email2, String byear, String address2, String phone2) {
        this.id = Integer.MAX_VALUE;
        this.firstname = firstname;
        this.middlename = middlename;
        this.lastname = lastname;
        this.home = home;
        this.mobile = mobile;
        this.email = email;
        this.email2 = email2;
        this.byear = byear;
        this.address2 = address2;
        this.phone2 = phone2;
    }

    public ContactData(int id, String firstname, String middlename, String lastname, String home, String mobile, String email, String email2, String byear, String address2, String phone2) {
        this.id = id;
        this.firstname = firstname;
        this.middlename = middlename;
        this.lastname = lastname;
        this.home = home;
        this.mobile = mobile;
        this.email = email;
        this.email2 = email2;
        this.byear = byear;
        this.address2 = address2;
        this.phone2 = phone2;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getMiddlename() {
        return middlename;
    }

    public String getLastname() {
        return lastname;
    }

    public String getHome() {
        return home;
    }

    public String getMobile() {
        return mobile;
    }

    public String getEmail() {
        return email;
    }

    public String getEmail2() {
        return email2;
    }

    public String getByear() {
        return byear;
    }

    public String getAddress2() {
        return address2;
    }

    public String getPhone2() {
        return phone2;
    }

    @Override
    public String toString() {
        return "ContactData{" +
                "id=" + id +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ContactData that = (ContactData) o;

        if (id != that.id) return false;
        if (firstname != null ? !firstname.equals(that.firstname) : that.firstname != null) return false;
        return lastname != null ? lastname.equals(that.lastname) : that.lastname == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (firstname != null ? firstname.hashCode() : 0);
        result = 31 * result + (lastname != null ? lastname.hashCode() : 0);
        return result;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

}


