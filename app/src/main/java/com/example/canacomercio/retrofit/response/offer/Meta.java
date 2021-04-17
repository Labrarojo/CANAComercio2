
package com.example.canacomercio.retrofit.response.offer;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Meta {

    @SerializedName("ofertas_count")
    @Expose
    private Integer ofertasCount;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Meta() {
    }

    /**
     * 
     * @param ofertasCount
     */
    public Meta(Integer ofertasCount) {
        super();
        this.ofertasCount = ofertasCount;
    }

    public Integer getOfertasCount() {
        return ofertasCount;
    }

    public void setOfertasCount(Integer ofertasCount) {
        this.ofertasCount = ofertasCount;
    }

}
