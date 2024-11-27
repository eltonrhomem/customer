package org.acme.dto;

import lombok.*;
import lombok.extern.jackson.Jacksonized;

@Data
@Jacksonized
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CustomerDTO {
    private String name;
    private String phone;
    private String email;
    private String address;
    private Long age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Long getAge() {
        return age;
    }

    public void setAge(Long age) {
        this.age = age;
    }
}
