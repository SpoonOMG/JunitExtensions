package framework.qa.models.omniresponseitem;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Specific {

    public LoadEntries getLoadEntries() {
        return loadEntries;
    }

    public String getMaxFoundRecords() {
        return maxFoundRecords;
    }


    @JsonProperty("url")
    private String url;

    @JsonProperty("maxFoundRecords")
    private String maxFoundRecords;

    public String getFileName() {
        return fileName;
    }

    @JsonProperty("fileName")
    private String fileName;

    @JsonProperty("loadEntries")
    private LoadEntries loadEntries;

    @JsonProperty("dictionaryEntries")
    private List<DictionaryEntriesItem> dictionaryEntries;

    @JsonProperty("pattern")
    private String pattern;

    public String getScreenLoadId() {
        return screenLoadId;
    }

    @JsonProperty("screenLoadId")
    private String screenLoadId;


    public Boolean getStrict() {
        return strict;
    }

    @JsonProperty("strict")
    private Boolean strict;

    public Boolean getSearchable() {
        return searchable;
    }

    @JsonProperty("searchable")
    private Boolean searchable;

    public List<String> getElementIds() {
        return elementIds;
    }

    @JsonProperty("elementIds")
    private List<String> elementIds;

    public int getSchedule() {
        return schedule;
    }

    @JsonProperty("schedule")
    private int schedule;

    public String getMaskValue() {
        return maskValue;
    }

    @JsonProperty("maskValue")
    private String maskValue;

    public String getMaskSym() {
        return maskSym;
    }

    @JsonProperty("displayMaskSym")
    private String displayMaskSym;

    public String getDisplayMaskSym() {
        return displayMaskSym;
    }

    @JsonProperty("maskSym")
    private String maskSym;

	@JsonProperty("body")
	private Body body;

    public List<DictionaryEntriesItem> getDictionaryEntries() {
        return dictionaryEntries;
    }

    public String getPattern() {
        return pattern;
    }
}