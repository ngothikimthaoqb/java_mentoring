package api.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import javax.annotation.Generated;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "name",
        "catchPhrase",
        "bs",
})
@Generated("jsonschema2pojo")
public class Company {
    @JsonProperty("name")
    private String name;
    @JsonProperty("catchPhrase")
    private String catchPhrase;
    @JsonProperty("bs")
    private String bs;

    @JsonProperty("name")
    public String getname() {
        return this.name;
    }

    @JsonProperty("name")
    public void setname(String name) {
        this.name = name;
    }

    @JsonProperty("catchPhrase")
    public String getcatchPhrase() {
        return catchPhrase;
    }

    @JsonProperty("catchPhrase")
    public void setcatchPhrase(String catchPhrase) {
        this.catchPhrase = catchPhrase;
    }

    @JsonProperty("bs")
    public String getbs() {
        return bs;
    }

    @JsonProperty("bs")
    public void setbs(String bs) {
        this.bs = bs;
    }
}
