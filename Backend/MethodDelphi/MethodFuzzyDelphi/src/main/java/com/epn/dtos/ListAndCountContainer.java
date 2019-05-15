package com.epn.dtos;



import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;



/**
 * ListAndCountContainer
 * 
 */
public class ListAndCountContainer {

    @JsonProperty
    private Long count;

    @JsonProperty
    private List results;

    public ListAndCountContainer(Long count, List results) {
        this.count = count;
        this.results = results;
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }

    public List getResults() {
        return results;
    }

    public void setResults(List results) {
        this.results = results;
    }

}