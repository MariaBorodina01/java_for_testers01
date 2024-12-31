package model;

public record ContactData(String id, String first_name, String last_name, String home_address,
                          String mobile_phone, String mail, String photo) {

    public ContactData() {
        this("", "", "", "", "", "",   "");
    }

    public ContactData withId(String id) {
        return  new ContactData(id, this.first_name, this.last_name, this.home_address, this.mobile_phone, this.mail,  this.photo);
    }

    public ContactData withFirstName(String first_name) {
        return  new ContactData(this.id, first_name, this.last_name, this.home_address, this.mobile_phone, this.mail,  this.photo);
    }

    public ContactData withLasttName(String last_name) {
        return  new ContactData(this.id, this.first_name, last_name, this.home_address,  this.mobile_phone,  this.mail,  this.photo);
    }

    public ContactData withHomeAddress(String home_address) {
        return  new ContactData(this.id, this.first_name, this.last_name, home_address,  this.mobile_phone, this.mail, this.photo);
    }

    public ContactData withMobilePhone(String mobile_phone) {
        return  new ContactData(this.id, this.first_name, this.last_name, this.home_address,  mobile_phone, this.mail,  this.photo);
    }

    public ContactData withMail(String mail1) {
        return  new ContactData(this.id, this.first_name, this.last_name, this.home_address,  this.mobile_phone, mail1,  this.photo);
    }

    public ContactData withPhoto(String photo) {
        return  new ContactData(this.id, this.first_name, this.last_name, this.home_address,  this.mobile_phone, this.mail, photo);
    }
}