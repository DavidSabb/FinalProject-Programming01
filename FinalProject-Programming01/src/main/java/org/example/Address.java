package org.example;

public class Address {
    private int streetNo;
    private String street;
    private String city;
    private String province;
    private String postalCode;
    private String country;

    public Address(int streetNo, String street, String city, String province, String postalCode, String country) {
        if (isPostalCodeValid(postalCode)) {
            this.streetNo = streetNo;
            this.street = street;
            this.city = city;
            this.province = province;
            this.postalCode = postalCode.toUpperCase();
            this.country = country;
        } else {
            this.streetNo = 0;
            this.street = null;
            this.city = null;
            this.province = null;
            this.postalCode = null;
            this.country = null;
        }
    }

    public static boolean isPostalCodeValid(String postalCode) {
        if (postalCode == null) {
            return false;
        }
        if (postalCode.length() == 6) {
            for (int i = 0; i < postalCode.length(); i++) {
                if (i % 2 == 0) {
                    if (Character.isDigit(postalCode.charAt(i))) {
                        return false;
                    }
                }
                if (i % 2 == 1) {
                    if (Character.isLetter(postalCode.charAt(i))) {
                        return false;
                    }
                }
            }
        } else if (postalCode.length() == 7) {
            if (postalCode.charAt(3) != ' '){
                return false;
            }
            postalCode = postalCode.replaceAll("\\s+","");
            for (int i = 0; i < postalCode.length(); i++) {
                if (i % 2 == 0) {
                    if (Character.isDigit(postalCode.charAt(i))) {
                        return false;
                    }
                }
                if (i % 2 == 1) {
                    if (Character.isLetter(postalCode.charAt(i))) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public String toString() {
        return "Address: " +
                "streetNo: " + streetNo +
                " " + "street=" + street + " "+
                "city=" + city + " " +
                "province:" + province + " " +
                "postalCode: " + postalCode + " " +
                "country: " + country + " ";
    }

    public boolean equals(Address o) {
        if (streetNo == o.streetNo && street.equals(o.street) && city.equals(o.city) && province.equals(o.province)
         && postalCode.equals(o.postalCode) && country.equals(o.country)) {
            return true;
        } else {
            return false;
        }
    }
    public int getStreetNo() {
        return streetNo;
    }

    public void setStreetNo(int streetNo) {
        this.streetNo = streetNo;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        if (isPostalCodeValid(postalCode)) {
            this.postalCode = postalCode.toUpperCase();
        }
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
