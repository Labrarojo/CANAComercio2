
package com.example.canacomercio.retrofit.response.employee;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Links__1 {

    @SerializedName("self")
    @Expose
    private String self;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Links__1() {
    }

    /**
     * 
     * @param self
     */
    public Links__1(String self) {
        super();
        this.self = self;
    }

    public String getSelf() {
        return self;
    }

    public void setSelf(String self) {
        this.self = self;
    }

}
