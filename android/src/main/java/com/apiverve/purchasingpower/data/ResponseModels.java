// Converter.java

// To use this code, add the following Maven dependency to your project:
//
//
//     com.fasterxml.jackson.core     : jackson-databind          : 2.9.0
//     com.fasterxml.jackson.datatype : jackson-datatype-jsr310   : 2.9.0
//
// Import this package:
//
//     import com.apiverve.data.Converter;
//
// Then you can deserialize a JSON string with
//
//     PurchasingPowerData data = Converter.fromJsonString(jsonString);

package com.apiverve.purchasingpower.data;

import java.io.IOException;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import java.util.*;
import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.time.OffsetTime;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.temporal.ChronoField;

public class Converter {
    // Date-time helpers

    private static final DateTimeFormatter DATE_TIME_FORMATTER = new DateTimeFormatterBuilder()
            .appendOptional(DateTimeFormatter.ISO_DATE_TIME)
            .appendOptional(DateTimeFormatter.ISO_OFFSET_DATE_TIME)
            .appendOptional(DateTimeFormatter.ISO_INSTANT)
            .appendOptional(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SX"))
            .appendOptional(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ssX"))
            .appendOptional(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"))
            .toFormatter()
            .withZone(ZoneOffset.UTC);

    public static OffsetDateTime parseDateTimeString(String str) {
        return ZonedDateTime.from(Converter.DATE_TIME_FORMATTER.parse(str)).toOffsetDateTime();
    }

    private static final DateTimeFormatter TIME_FORMATTER = new DateTimeFormatterBuilder()
            .appendOptional(DateTimeFormatter.ISO_TIME)
            .appendOptional(DateTimeFormatter.ISO_OFFSET_TIME)
            .parseDefaulting(ChronoField.YEAR, 2020)
            .parseDefaulting(ChronoField.MONTH_OF_YEAR, 1)
            .parseDefaulting(ChronoField.DAY_OF_MONTH, 1)
            .toFormatter()
            .withZone(ZoneOffset.UTC);

    public static OffsetTime parseTimeString(String str) {
        return ZonedDateTime.from(Converter.TIME_FORMATTER.parse(str)).toOffsetDateTime().toOffsetTime();
    }
    // Serialize/deserialize helpers

    public static PurchasingPowerData fromJsonString(String json) throws IOException {
        return getObjectReader().readValue(json);
    }

    public static String toJsonString(PurchasingPowerData obj) throws JsonProcessingException {
        return getObjectWriter().writeValueAsString(obj);
    }

    private static ObjectReader reader;
    private static ObjectWriter writer;

    private static void instantiateMapper() {
        ObjectMapper mapper = new ObjectMapper();
        mapper.findAndRegisterModules();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        mapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
        SimpleModule module = new SimpleModule();
        module.addDeserializer(OffsetDateTime.class, new JsonDeserializer<OffsetDateTime>() {
            @Override
            public OffsetDateTime deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
                String value = jsonParser.getText();
                return Converter.parseDateTimeString(value);
            }
        });
        mapper.registerModule(module);
        reader = mapper.readerFor(PurchasingPowerData.class);
        writer = mapper.writerFor(PurchasingPowerData.class);
    }

    private static ObjectReader getObjectReader() {
        if (reader == null) instantiateMapper();
        return reader;
    }

    private static ObjectWriter getObjectWriter() {
        if (writer == null) instantiateMapper();
        return writer;
    }
}

// PurchasingPowerData.java

package com.apiverve.purchasingpower.data;

import com.fasterxml.jackson.annotation.*;

public class PurchasingPowerData {
    private long originalAmount;
    private String originalPeriod;
    private double adjustedAmount;
    private String adjustedPeriod;
    private double cumulativeInflation;
    private double multiplier;
    private String explanation;
    private double fromCPI;
    private double toCPI;

    @JsonProperty("originalAmount")
    public long getOriginalAmount() { return originalAmount; }
    @JsonProperty("originalAmount")
    public void setOriginalAmount(long value) { this.originalAmount = value; }

    @JsonProperty("originalPeriod")
    public String getOriginalPeriod() { return originalPeriod; }
    @JsonProperty("originalPeriod")
    public void setOriginalPeriod(String value) { this.originalPeriod = value; }

    @JsonProperty("adjustedAmount")
    public double getAdjustedAmount() { return adjustedAmount; }
    @JsonProperty("adjustedAmount")
    public void setAdjustedAmount(double value) { this.adjustedAmount = value; }

    @JsonProperty("adjustedPeriod")
    public String getAdjustedPeriod() { return adjustedPeriod; }
    @JsonProperty("adjustedPeriod")
    public void setAdjustedPeriod(String value) { this.adjustedPeriod = value; }

    @JsonProperty("cumulativeInflation")
    public double getCumulativeInflation() { return cumulativeInflation; }
    @JsonProperty("cumulativeInflation")
    public void setCumulativeInflation(double value) { this.cumulativeInflation = value; }

    @JsonProperty("multiplier")
    public double getMultiplier() { return multiplier; }
    @JsonProperty("multiplier")
    public void setMultiplier(double value) { this.multiplier = value; }

    @JsonProperty("explanation")
    public String getExplanation() { return explanation; }
    @JsonProperty("explanation")
    public void setExplanation(String value) { this.explanation = value; }

    @JsonProperty("fromCPI")
    public double getFromCPI() { return fromCPI; }
    @JsonProperty("fromCPI")
    public void setFromCPI(double value) { this.fromCPI = value; }

    @JsonProperty("toCPI")
    public double getToCPI() { return toCPI; }
    @JsonProperty("toCPI")
    public void setToCPI(double value) { this.toCPI = value; }
}