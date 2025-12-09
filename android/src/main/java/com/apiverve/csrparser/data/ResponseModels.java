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
//     CSRParserData data = Converter.fromJsonString(jsonString);

package com.apiverve.csrparser.data;

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

    public static CSRParserData fromJsonString(String json) throws IOException {
        return getObjectReader().readValue(json);
    }

    public static String toJsonString(CSRParserData obj) throws JsonProcessingException {
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
        reader = mapper.readerFor(CSRParserData.class);
        writer = mapper.writerFor(CSRParserData.class);
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

// CSRParserData.java

package com.apiverve.csrparser.data;

import com.fasterxml.jackson.annotation.*;

public class CSRParserData {
    private String version;
    private Subject subject;
    private PublicKey publicKey;
    private String signatureAlgorithm;
    private Object[] extensions;
    private Fingerprints fingerprints;
    private String pem;
    private long sizeBytes;
    private String format;
    private boolean isValid;

    @JsonProperty("version")
    public String getVersion() { return version; }
    @JsonProperty("version")
    public void setVersion(String value) { this.version = value; }

    @JsonProperty("subject")
    public Subject getSubject() { return subject; }
    @JsonProperty("subject")
    public void setSubject(Subject value) { this.subject = value; }

    @JsonProperty("public_key")
    public PublicKey getPublicKey() { return publicKey; }
    @JsonProperty("public_key")
    public void setPublicKey(PublicKey value) { this.publicKey = value; }

    @JsonProperty("signature_algorithm")
    public String getSignatureAlgorithm() { return signatureAlgorithm; }
    @JsonProperty("signature_algorithm")
    public void setSignatureAlgorithm(String value) { this.signatureAlgorithm = value; }

    @JsonProperty("extensions")
    public Object[] getExtensions() { return extensions; }
    @JsonProperty("extensions")
    public void setExtensions(Object[] value) { this.extensions = value; }

    @JsonProperty("fingerprints")
    public Fingerprints getFingerprints() { return fingerprints; }
    @JsonProperty("fingerprints")
    public void setFingerprints(Fingerprints value) { this.fingerprints = value; }

    @JsonProperty("pem")
    public String getPem() { return pem; }
    @JsonProperty("pem")
    public void setPem(String value) { this.pem = value; }

    @JsonProperty("size_bytes")
    public long getSizeBytes() { return sizeBytes; }
    @JsonProperty("size_bytes")
    public void setSizeBytes(long value) { this.sizeBytes = value; }

    @JsonProperty("format")
    public String getFormat() { return format; }
    @JsonProperty("format")
    public void setFormat(String value) { this.format = value; }

    @JsonProperty("is_valid")
    public boolean getIsValid() { return isValid; }
    @JsonProperty("is_valid")
    public void setIsValid(boolean value) { this.isValid = value; }
}

// Fingerprints.java

package com.apiverve.csrparser.data;

import com.fasterxml.jackson.annotation.*;

public class Fingerprints {
    private String sha1;
    private String sha256;
    private String md5;

    @JsonProperty("sha1")
    public String getSha1() { return sha1; }
    @JsonProperty("sha1")
    public void setSha1(String value) { this.sha1 = value; }

    @JsonProperty("sha256")
    public String getSha256() { return sha256; }
    @JsonProperty("sha256")
    public void setSha256(String value) { this.sha256 = value; }

    @JsonProperty("md5")
    public String getMd5() { return md5; }
    @JsonProperty("md5")
    public void setMd5(String value) { this.md5 = value; }
}

// PublicKey.java

package com.apiverve.csrparser.data;

import com.fasterxml.jackson.annotation.*;

public class PublicKey {
    private String algorithm;
    private long sizeBits;
    private long exponent;

    @JsonProperty("algorithm")
    public String getAlgorithm() { return algorithm; }
    @JsonProperty("algorithm")
    public void setAlgorithm(String value) { this.algorithm = value; }

    @JsonProperty("size_bits")
    public long getSizeBits() { return sizeBits; }
    @JsonProperty("size_bits")
    public void setSizeBits(long value) { this.sizeBits = value; }

    @JsonProperty("exponent")
    public long getExponent() { return exponent; }
    @JsonProperty("exponent")
    public void setExponent(long value) { this.exponent = value; }
}

// Subject.java

package com.apiverve.csrparser.data;

import com.fasterxml.jackson.annotation.*;

public class Subject {
    private Object commonName;
    private Object organization;
    private Object organizationalUnit;
    private Object locality;
    private Object state;
    private Object country;
    private Object email;

    @JsonProperty("common_name")
    public Object getCommonName() { return commonName; }
    @JsonProperty("common_name")
    public void setCommonName(Object value) { this.commonName = value; }

    @JsonProperty("organization")
    public Object getOrganization() { return organization; }
    @JsonProperty("organization")
    public void setOrganization(Object value) { this.organization = value; }

    @JsonProperty("organizational_unit")
    public Object getOrganizationalUnit() { return organizationalUnit; }
    @JsonProperty("organizational_unit")
    public void setOrganizationalUnit(Object value) { this.organizationalUnit = value; }

    @JsonProperty("locality")
    public Object getLocality() { return locality; }
    @JsonProperty("locality")
    public void setLocality(Object value) { this.locality = value; }

    @JsonProperty("state")
    public Object getState() { return state; }
    @JsonProperty("state")
    public void setState(Object value) { this.state = value; }

    @JsonProperty("country")
    public Object getCountry() { return country; }
    @JsonProperty("country")
    public void setCountry(Object value) { this.country = value; }

    @JsonProperty("email")
    public Object getEmail() { return email; }
    @JsonProperty("email")
    public void setEmail(Object value) { this.email = value; }
}