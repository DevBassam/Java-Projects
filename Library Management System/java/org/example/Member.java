package org.example;

public class Member {
    private int id;
    private String name;
    private String phone;
    private String email;
    private String address;
    private String membershipYear;

    public Member(int id,String name, String address, String phone, String email, String membershipYear) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.address = address;
        this.membershipYear = membershipYear;
    }

    @Override
    public String toString() {
        return "Member{" +
                "ID=" + id +
                ", Name='" + name + '\'' +
                ", Phone='" + phone + '\'' +
                ", Email='" + email + '\'' +
                ", Address='" + address + '\'' +
                ", Membership date='" + membershipYear + '\'' +
                '}';
    }
}
