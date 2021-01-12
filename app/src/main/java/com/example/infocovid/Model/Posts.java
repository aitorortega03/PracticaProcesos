package com.example.infocovid.Model;

import java.util.List;

public class Posts {
    private String objectIdFieldName;
    private Object uniqueIdField;
    private String globalIdFieldName;
    private Object geometryProperties;
    private String geometryType;
    private Object spatialReference;
    private List<Object> fields;
    private boolean exceededTransferLimit;
    private List<Features> features;

    public String getObjectIdFieldName() {
        return objectIdFieldName;
    }

    public void setObjectIdFieldName(String objectIdFieldName) {
        this.objectIdFieldName = objectIdFieldName;
    }

    public Object getUniqueIdField() {
        return uniqueIdField;
    }

    public void setUniqueIdField(Object uniqueIdField) {
        this.uniqueIdField = uniqueIdField;
    }

    public String getGlobalIdFieldName() {
        return globalIdFieldName;
    }

    public void setGlobalIdFieldName(String globalIdFieldName) {
        this.globalIdFieldName = globalIdFieldName;
    }

    public Object getGeometryProperties() {
        return geometryProperties;
    }

    public void setGeometryProperties(Object geometryProperties) {
        this.geometryProperties = geometryProperties;
    }

    public String getGeometryType() {
        return geometryType;
    }

    public void setGeometryType(String geometryType) {
        this.geometryType = geometryType;
    }

    public Object getSpatialReference() {
        return spatialReference;
    }

    public void setSpatialReference(Object spatialReference) {
        this.spatialReference = spatialReference;
    }

    public List<Object> getFields() {
        return fields;
    }

    public void setFields(List<Object> fields) {
        this.fields = fields;
    }

    public boolean isExceededTransferLimit() {
        return exceededTransferLimit;
    }

    public void setExceededTransferLimit(boolean exceededTransferLimit) {
        this.exceededTransferLimit = exceededTransferLimit;
    }

    public List<Features> getFeatures() {
        return features;
    }

    public void setFeatures(List<Features> features) {
        this.features = features;
    }
}
