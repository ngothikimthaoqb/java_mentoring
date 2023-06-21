package api.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import javax.annotation.Generated;


@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "lat",
        "lng"
})
@Generated("jsonschema2pojo")
public class Geo {
    @JsonProperty("lat")
    private String lat;
    @JsonProperty("lng")
    private String lng;

    @JsonProperty("latlat")
    public String getlat() {
        return lat;
    }
    @JsonProperty("lat")
    public void setuserName(String lat) {
        this.lat = lat;
    }

    @JsonProperty("lng")
    public String getlng() {
        return lng;
    }

    @JsonProperty("lng")
    public void setlng(String lng) {
        this.lng = lng;
    }

}
