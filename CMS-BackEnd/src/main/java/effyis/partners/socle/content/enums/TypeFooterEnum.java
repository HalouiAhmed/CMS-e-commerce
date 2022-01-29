package effyis.partners.socle.content.enums;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author CHICHI Hamza
 */


public enum TypeFooterEnum {
    @JsonProperty("URL_IMAGE")
    URL_IMAGE,
    @JsonProperty("TEXT")
    TEXT,
    @JsonProperty("LIST")
    LIST,
    @JsonProperty("EMPTY_SECTION")
    EMPTY_SECTION
}
