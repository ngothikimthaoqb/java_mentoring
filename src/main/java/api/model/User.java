package api.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import javax.annotation.Generated;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "id",
        "name",
        "username",
        "email",
        "address",
        "phone",
        "website",
        "company",
})
@Generated("jsonschema2pojo")

public class User {
    @JsonProperty("id")
    private String id;
    @JsonProperty("name")
    private String name;
    @JsonProperty("username")
    private String username;
    @JsonProperty("email")
    private String email;
    @JsonProperty("address")
    private Address address;
    @JsonProperty("phone")
    private String phone;
    @JsonProperty("website")
    private String website;
    @JsonProperty("company")
    private Company company;

    @JsonProperty("id")
    public String getid() {
        return id;
    }

    @JsonProperty("id")
    public void setid(String id) {
        this.id = id;
    }

    @JsonProperty("name")
    public String getname() {
        return name;
    }

    @JsonProperty("name")
    public void setname(String name) {
        this.name = name;
    }

    @JsonProperty("username")
    public String getusername() {
        return username;
    }

    @JsonProperty("username")
    public void setusername(String username) {
        this.username = username;
    }

    @JsonProperty("email")
    public String getemail() {
        return email;
    }

    @JsonProperty("email")
    public void setemail(String email) {
        this.email = email;
    }

    @JsonProperty("address")
    public Address getaddress() {
        return address;
    }

    @JsonProperty("address")
    public void setaddress(Address address) {
        this.address = address;
    }

    @JsonProperty("company")
    public Company getCompany() {
        return company;
    }

    @JsonProperty("company")
    public void setCompany(Company company) {
        this.company = company;
    }

    @JsonProperty("phone")
    public String getPhone() {
        return phone;
    }

    @JsonProperty("phone")
    public void setphone(String phone) {
        this.phone = phone;
    }

    @JsonProperty("website")
    public String getwebsite() {
        return website;
    }

    @JsonProperty("website")
    public void setwebsite(String website) {
        this.website = website;
    }
}