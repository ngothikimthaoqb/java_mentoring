package api.model;

import com.fasterxml.jackson.annotation.*;

import javax.annotation.Generated;
import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "street",
        "suite",
        "city",
        "zipcode",
        "geo"
})
@Generated("jsonschema2pojo")
public class Address {
    @JsonProperty("street")
    private String street;
    @JsonProperty("suite")
    private String suite;
    @JsonProperty("city")
    private String city;
    @JsonProperty("zipcode")
    private String zipcode;
    @JsonProperty("geo")
    private Geo geo;

    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("street")
    public String getstreet() {
        return street;
    }

    @JsonProperty("street")
    public void setstreet(String street) {
        this.street = street;
    }

    @JsonProperty("suite")
    public String getsuite() {
        return suite;
    }

    @JsonProperty("suite")
    public void setsuite(String suite) {
        this.suite = suite;
    }

    @JsonProperty("city")
    public String getcity() {
        return city;
    }

    @JsonProperty("city")
    public void setcity(String city) {
        this.city = city;
    }

    @JsonProperty("zipcode")
    public String getzipcode() {
        return zipcode;
    }

    @JsonProperty("zipcode")
    public void setzipcode(String zipcode) {
        this.zipcode = zipcode;
    }
    
    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonProperty("geo")
    public Geo getgeo() {
        return geo;
    }

    @JsonProperty("geo")
    public void setgeo(Geo geo) {
        this.geo = geo;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }
}
