package model;

public record ContactData(String id, String first_name, String last_name, String home_address, String home_phone,
                          String mobile_phone, String work_phone, String mail1, String mail2, String mail3) {

    public ContactData() {
        this("", "", "", "", "", "", "", "", "", "");
    }

    public ContactData withId(String id) {
        return  new ContactData(id, this.first_name, this.last_name, this.home_address, this.home_phone, this.mobile_phone, this.work_phone, this.mail1, this.mail2, this.mail3);
    }

    public ContactData withFirstName(String first_name) {
        return  new ContactData(this.id, first_name, this.last_name, this.home_address, this.home_phone, this.mobile_phone, this.work_phone, this.mail1, this.mail2, this.mail3);
    }

    public ContactData withLasttName(String last_name) {
        return  new ContactData(this.id, this.first_name, last_name, this.home_address, this.home_phone, this.mobile_phone, this.work_phone, this.mail1, this.mail2, this.mail3);
    }

    public ContactData withHomeAddress(String home_address) {
        return  new ContactData(this.id, this.first_name, this.last_name, home_address, this.home_phone, this.mobile_phone, this.work_phone, this.mail1, this.mail2, this.mail3);
    }

    public ContactData withHomePhone(String home_phone) {
        return  new ContactData(this.id, this.first_name, this.last_name, this.home_address, home_phone, this.mobile_phone, this.work_phone, this.mail1, this.mail2, this.mail3);
    }

    public ContactData withMobilePhone(String mobile_phone) {
        return  new ContactData(this.id, this.first_name, this.last_name, this.home_address, this.home_phone, mobile_phone, this.work_phone, this.mail1, this.mail2, this.mail3);
    }
    public ContactData withWorkPhone(String work_phone) {
        return  new ContactData(this.id, this.first_name, this.last_name, this.home_address, this.home_phone, this.mobile_phone, work_phone, this.mail1, this.mail2, this.mail3);
    }

    public ContactData withMail1(String mail1) {
        return  new ContactData(this.id, this.first_name, this.last_name, this.home_address, this.home_phone, this.mobile_phone, this.work_phone, mail1, this.mail2, this.mail3);
    }

    public ContactData withMail2(String mail2) {
        return  new ContactData(this.id, this.first_name, this.last_name, this.home_address, this.home_phone, this.mobile_phone, this.work_phone, this.mail1, mail2, this.mail3);
    }

    public ContactData withMail3(String mail2) {
        return  new ContactData(this.id, this.first_name, this.last_name, this.home_address, this.home_phone, this.mobile_phone, this.work_phone, this.mail1, this.mail2, mail3);
    }
}