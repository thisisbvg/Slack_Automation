
package POJO;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "type",
    "id",
    "message",
    "country",
    "sunrise",
    "sunset"
})
public class Sys {

    @JsonProperty("type")
    private Integer type;
    @JsonProperty("id")
    private Integer id;
    @JsonProperty("message")
    private Double message;
    @JsonProperty("country")
    private String country;
    @JsonProperty("sunrise")
    private Integer sunrise;
    @JsonProperty("sunset")
    private Integer sunset;

    @JsonProperty("type")
    public Integer getType() {
        return type;
    }

    @JsonProperty("type")
    public void setType(Integer type) {
        this.type = type;
    }

    @JsonProperty("id")
    public Integer getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(Integer id) {
        this.id = id;
    }

    @JsonProperty("message")
    public Double getMessage() {
        return message;
    }

    @JsonProperty("message")
    public void setMessage(Double message) {
        this.message = message;
    }

    @JsonProperty("country")
    public String getCountry() {
        return country;
    }

    @JsonProperty("country")
    public void setCountry(String country) {
        this.country = country;
    }

    @JsonProperty("sunrise")
    public Integer getSunrise() {
        return sunrise;
    }

    @JsonProperty("sunrise")
    public void setSunrise(Integer sunrise) {
        this.sunrise = sunrise;
    }

    @JsonProperty("sunset")
    public Integer getSunset() {
        return sunset;
    }

    @JsonProperty("sunset")
    public void setSunset(Integer sunset) {
        this.sunset = sunset;
    }

}
