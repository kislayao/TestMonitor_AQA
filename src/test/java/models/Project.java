package models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.SerializedName;
import lombok.*;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
public class Project {

    @EqualsAndHashCode.Exclude
    @SerializedName(value = "id")
    private int projectId;

    private String name;
    private String description;

//    @EqualsAndHashCode.Exclude
//    @SerializedName(value = "symbol_id")
//    @JsonProperty("symbol_id")
//    private int symbolId;
}
