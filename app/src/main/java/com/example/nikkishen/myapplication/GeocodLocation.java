package com.example.nikkishen.myapplication;

import java.util.List;

public class GeocodLocation {


    private List<ResultsBean> results;

    public List<ResultsBean> getResults() {
        return results;
    }

    public void setResults(List<ResultsBean> results) {
        this.results = results;
    }

    public static class ResultsBean {
        /**
         * address_components : {"number":"508","street":"H","suffix":"St","postdirectional":"NE","formatted_street":"H St NE","city":"Washington","county":"District of Columbia","state":"DC","zip":"20002","country":"US"}
         * formatted_address : 508 H St NE, Washington, DC 20002
         * location : {"lat":38.900432,"lng":-76.999031}
         * accuracy : 1
         * accuracy_type : rooftop
         * source : City of Washington
         * fields : {"congressional_districts":[{"name":"Delegate District (at Large)","district_number":98,"congress_number":"115th","congress_years":"2017-2019","proportion":1,"current_legislators":[{"type":"representative","bio":{"last_name":"Norton","first_name":"Eleanor","birthday":"1937-06-13","gender":"F","party":"Democrat"},"contact":{"url":"https://norton.house.gov","address":"2136 Rayburn House Office Building; Washington DC 20515-5101","phone":"202-225-8050","contact_form":null},"social":{"rss_url":"http://norton.house.gov/index.php?format=feed&amp;type=rss","twitter":"EleanorNorton","facebook":"CongresswomanNorton","youtube":"EleanorHNorton","youtube_id":"UChRrAXUGylfxJjbquC6aUjQ"},"references":{"bioguide_id":"N000147","thomas_id":"00868","opensecrets_id":"N00001692","lis_id":null,"cspan_id":"882","govtrack_id":"400295","votesmart_id":"775","ballotpedia_id":null,"washington_post_id":null,"icpsr_id":null,"wikipedia_id":"Eleanor Holmes Norton"},"source":"Legislator data is originally collected and aggregated by https://github.com/unitedstates/"}]}]}
         */

        private AddressComponentsBean address_components;
        private String formatted_address;
        private LocationBean location;
        private float accuracy;
        private String accuracy_type;
        private String source;
        private FieldsBean fields;

        public AddressComponentsBean getAddress_components() {
            return address_components;
        }

        public void setAddress_components(AddressComponentsBean address_components) {
            this.address_components = address_components;
        }

        public String getFormatted_address() {
            return formatted_address;
        }

        public void setFormatted_address(String formatted_address) {
            this.formatted_address = formatted_address;
        }

        public LocationBean getLocation() {
            return location;
        }

        public void setLocation(LocationBean location) {
            this.location = location;
        }

        public float getAccuracy() {
            return accuracy;
        }

        public void setAccuracy(float accuracy) {
            this.accuracy = accuracy;
        }

        public String getAccuracy_type() {
            return accuracy_type;
        }

        public void setAccuracy_type(String accuracy_type) {
            this.accuracy_type = accuracy_type;
        }

        public String getSource() {
            return source;
        }

        public void setSource(String source) {
            this.source = source;
        }

        public FieldsBean getFields() {
            return fields;
        }

        public void setFields(FieldsBean fields) {
            this.fields = fields;
        }

        public static class AddressComponentsBean {
            /**
             * number : 508
             * street : H
             * suffix : St
             * postdirectional : NE
             * formatted_street : H St NE
             * city : Washington
             * county : District of Columbia
             * state : DC
             * zip : 20002
             * country : US
             */

            private String number;
            private String street;
            private String suffix;
            private String postdirectional;
            private String formatted_street;
            private String city;
            private String county;
            private String state;
            private String zip;
            private String country;

            public String getNumber() {
                return number;
            }

            public void setNumber(String number) {
                this.number = number;
            }

            public String getStreet() {
                return street;
            }

            public void setStreet(String street) {
                this.street = street;
            }

            public String getSuffix() {
                return suffix;
            }

            public void setSuffix(String suffix) {
                this.suffix = suffix;
            }

            public String getPostdirectional() {
                return postdirectional;
            }

            public void setPostdirectional(String postdirectional) {
                this.postdirectional = postdirectional;
            }

            public String getFormatted_street() {
                return formatted_street;
            }

            public void setFormatted_street(String formatted_street) {
                this.formatted_street = formatted_street;
            }

            public String getCity() {
                return city;
            }

            public void setCity(String city) {
                this.city = city;
            }

            public String getCounty() {
                return county;
            }

            public void setCounty(String county) {
                this.county = county;
            }

            public String getState() {
                return state;
            }

            public void setState(String state) {
                this.state = state;
            }

            public String getZip() {
                return zip;
            }

            public void setZip(String zip) {
                this.zip = zip;
            }

            public String getCountry() {
                return country;
            }

            public void setCountry(String country) {
                this.country = country;
            }
        }

        public static class LocationBean {
            /**
             * lat : 38.900432
             * lng : -76.999031
             */

            private double lat;
            private double lng;

            public double getLat() {
                return lat;
            }

            public void setLat(double lat) {
                this.lat = lat;
            }

            public double getLng() {
                return lng;
            }

            public void setLng(double lng) {
                this.lng = lng;
            }
        }

        public static class FieldsBean {
            private List<CongressionalDistrictsBean> congressional_districts;

            public List<CongressionalDistrictsBean> getCongressional_districts() {
                return congressional_districts;
            }

            public void setCongressional_districts(List<CongressionalDistrictsBean> congressional_districts) {
                this.congressional_districts = congressional_districts;
            }

            public static class CongressionalDistrictsBean {
                /**
                 * name : Delegate District (at Large)
                 * district_number : 98
                 * congress_number : 115th
                 * congress_years : 2017-2019
                 * proportion : 1
                 * current_legislators : [{"type":"representative","bio":{"last_name":"Norton","first_name":"Eleanor","birthday":"1937-06-13","gender":"F","party":"Democrat"},"contact":{"url":"https://norton.house.gov","address":"2136 Rayburn House Office Building; Washington DC 20515-5101","phone":"202-225-8050","contact_form":null},"social":{"rss_url":"http://norton.house.gov/index.php?format=feed&amp;type=rss","twitter":"EleanorNorton","facebook":"CongresswomanNorton","youtube":"EleanorHNorton","youtube_id":"UChRrAXUGylfxJjbquC6aUjQ"},"references":{"bioguide_id":"N000147","thomas_id":"00868","opensecrets_id":"N00001692","lis_id":null,"cspan_id":"882","govtrack_id":"400295","votesmart_id":"775","ballotpedia_id":null,"washington_post_id":null,"icpsr_id":null,"wikipedia_id":"Eleanor Holmes Norton"},"source":"Legislator data is originally collected and aggregated by https://github.com/unitedstates/"}]
                 */

                private String name;
                private int district_number;
                private String congress_number;
                private String congress_years;
                private float proportion;
                private List<CurrentLegislatorsBean> current_legislators;

                public String getName() {
                    return name;
                }

                public void setName(String name) {
                    this.name = name;
                }

                public int getDistrict_number() {
                    return district_number;
                }

                public void setDistrict_number(int district_number) {
                    this.district_number = district_number;
                }

                public String getCongress_number() {
                    return congress_number;
                }

                public void setCongress_number(String congress_number) {
                    this.congress_number = congress_number;
                }

                public String getCongress_years() {
                    return congress_years;
                }

                public void setCongress_years(String congress_years) {
                    this.congress_years = congress_years;
                }

                public float getProportion() {
                    return proportion;
                }

                public void setProportion(float proportion) {
                    this.proportion = proportion;
                }

                public List<CurrentLegislatorsBean> getCurrent_legislators() {
                    return current_legislators;
                }

                public void setCurrent_legislators(List<CurrentLegislatorsBean> current_legislators) {
                    this.current_legislators = current_legislators;
                }


            }
        }
    }
}
