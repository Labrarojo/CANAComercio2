
package com.example.canacomercio.retrofit.response.offer;


import com.example.canacomercio.retrofit.response.offer.Attributes;
import com.example.canacomercio.retrofit.response.offer.Links;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Datum {

    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("comercio")
    @Expose
    private String comercio;
    @SerializedName("attributes")
    @Expose
    private Attributes attributes;
    @SerializedName("links")
    @Expose
    private Links links;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Datum() {
    }

    /**
     * 
     * @param comercio
     * @param attributes
     * @param links
     * @param id
     * @param type
     */
    public Datum(String type, String id, String comercio, Attributes attributes, Links links) {
        super();
        this.type = type;
        this.id = id;
        this.comercio = comercio;
        this.attributes = attributes;
        this.links = links;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getComercio() {
        return comercio;
    }

    public void setComercio(String comercio) {
        this.comercio = comercio;
    }

    public Attributes getAttributes() {
        return attributes;
    }

    public void setAttributes(Attributes attributes) {
        this.attributes = attributes;
    }

    public Links getLinks() {
        return links;
    }

    public void setLinks(Links links) {
        this.links = links;
    }

}
