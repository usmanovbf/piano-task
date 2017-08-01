
package com.github.usmanovbf.piano.domain.json;

import com.fasterxml.jackson.annotation.*;
import com.sun.org.apache.xpath.internal.operations.Bool;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "items"
})
public class SearchResponse {

    @JsonProperty("items")
    private List<Item> items = null;
    @JsonProperty("has_more")
    private Boolean hasMore;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("items")
    public List<Item> getItems() {
        return items;
    }

    @JsonProperty("items")
    public void setItems(List<Item> items) {
        this.items = items;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    public Boolean getHasMore() {
        return hasMore;
    }

    public void setHasMore( Boolean hasMore ) {
        this.hasMore = hasMore;
    }
}
