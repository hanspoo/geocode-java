
package geo.nomi;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Place {

    @SerializedName("place_id")
    @Expose
    public Integer placeId;

    @SerializedName("licence")
    @Expose
    public String licence;
    
    @SerializedName("osm_type")
    @Expose
    public String osmType;
    
    @SerializedName("osm_id")
    @Expose
    public Integer osmId;
    
    @SerializedName("boundingbox")
    @Expose
    public List<String> boundingbox = null;
    
    @SerializedName("polygonpoints")
    @Expose
    public List<List<String>> polygonpoints = null;
    
    @SerializedName("lat")
    @Expose
    public Double lat;
    
    @SerializedName("lon")
    @Expose
    public Double lon;
    
    @SerializedName("display_name")
    @Expose
    public String displayName;
    
    @SerializedName("class")
    @Expose
    public String _class;
    @SerializedName("type")
    @Expose
    public String type;
    @SerializedName("importance")
    @Expose
    public Double importance;
    @SerializedName("address")
    @Expose
    public Address address;

}
