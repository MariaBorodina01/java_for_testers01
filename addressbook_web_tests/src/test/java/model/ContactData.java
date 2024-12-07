package model;

public record ContactCreate(String first_name, String last_name, String home_address, String home_phone,
                            String mobile_phone, String work_phone, String mail1, String mail2, String mail3) {
}