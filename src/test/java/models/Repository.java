package models;


import com.google.gson.annotations.SerializedName;
import lombok.Builder;
import lombok.Data;


@Builder
@Data
public class Repository {
    private int id;
    private String name;
    private String announcement;
    private String description;
    @SerializedName(value = "private")
    private boolean isPrivate;
}
