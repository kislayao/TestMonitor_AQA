package models;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.SerializedName;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Project {
    private String name;

    @SerializedName(value = "symbol_id")
    @JsonProperty("symbol_id")
    private int id;
}
