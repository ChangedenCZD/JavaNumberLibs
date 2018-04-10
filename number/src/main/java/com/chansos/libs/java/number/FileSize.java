package com.chansos.libs.java.number;

public class FileSize {
    private long length;
    private Information information;

    public FileSize(long length) {
        this.length = length;
        this.information = new Information(length, "B");
    }

    public static class Information {
        private double length;
        private String unit;

        public Information(long length, String unit) {
            this.length = length;
            this.unit = unit;
        }

        public double getLength() {
            return length;
        }

        public void setLength(double length) {
            this.length = length;
        }

        public String getUnit() {
            return unit;
        }

        public void setUnit(String unit) {
            this.unit = unit;
        }

        @Override
        public String toString() {
            return length + unit;
        }
    }

    public long getLength() {
        return length;
    }

    public void setLength(long length) {
        this.length = length;
    }

    public Information getInformation() {
        return information;
    }

    public void setInformation(Information information) {
        this.information = information;
    }

    @Override
    public String toString() {
        return String.format("Origin Length:%s;File Size Information:%s", length, information);
    }
}
