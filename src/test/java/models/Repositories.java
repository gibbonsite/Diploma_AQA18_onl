package models;



import com.google.gson.annotations.Expose;
import lombok.*;

@Getter
@Setter
@Builder
@EqualsAndHashCode
@ToString
public class Repositories {
    @Expose
    private String name;
    @Expose
    private String announcement;
    @Expose
    private boolean isPrivate;
    private String owner;
    private String repo;
}
