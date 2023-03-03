package models;


import com.google.gson.annotations.SerializedName;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;


@Builder
@Data
@ToString
@EqualsAndHashCode
public class Repositories {
    @EqualsAndHashCode.Exclude
    private int id;
    private String name;
    private String announcement;
    private String description;
    @SerializedName(value = "private")
    private boolean IsPrivate;
}
