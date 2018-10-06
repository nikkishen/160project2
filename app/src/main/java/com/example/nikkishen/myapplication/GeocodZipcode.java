package com.example.nikkishen.myapplication;

import java.util.List;

public class GeocodZipcode {


    /**
     * input : {"address_components":{"zip":"12201","country":"US"},"formatted_address":"12201"}
     * results : [{"address_components":{"city":"Albany","county":"Albany County","state":"NY","zip":"12201","country":"US"},"formatted_address":"Albany, NY 12201","location":{"lat":42.614852,"lng":-73.970812},"accuracy":1,"accuracy_type":"place","source":"TIGER/Line® dataset from the US Census Bureau","fields":{"congressional_districts":[{"name":"Congressional District 20","district_number":20,"congress_number":"115th","congress_years":"2017-2019","proportion":1,"current_legislators":[{"type":"representative","bio":{"last_name":"Tonko","first_name":"Paul","birthday":"1949-06-18","gender":"M","party":"Democrat"},"contact":{"url":"https://tonko.house.gov","address":"2463 Rayburn House Office Building; Washington DC 20515-3220","phone":"202-225-5076","contact_form":null},"social":{"rss_url":"http://tonko.house.gov/rss/press-releases.xml","twitter":"RepPaulTonko","facebook":"reppaultonko","youtube":"reppaultonko","youtube_id":"UC3P2SGFmmuCYRsjeso0hOQQ"},"references":{"bioguide_id":"T000469","thomas_id":"01942","opensecrets_id":"N00030196","lis_id":null,"cspan_id":"1031353","govtrack_id":"412319","votesmart_id":"4403","ballotpedia_id":null,"washington_post_id":null,"icpsr_id":"20934","wikipedia_id":"Paul Tonko"},"source":"Legislator data is originally collected and aggregated by https://github.com/unitedstates/"},{"type":"senator","bio":{"last_name":"Gillibrand","first_name":"Kirsten","birthday":"1966-12-09","gender":"F","party":"Democrat"},"contact":{"url":"https://www.gillibrand.senate.gov","address":"478 Russell Senate Office Building Washington DC 20510","phone":"202-224-4451","contact_form":"https://www.gillibrand.senate.gov/contact/email-me"},"social":{"rss_url":"http://www.gillibrand.senate.gov/rss/","twitter":"SenGillibrand","facebook":"SenKirstenGillibrand","youtube":"KirstenEGillibrand","youtube_id":"UCVEloQogVsmnkd5vxJInmYg"},"references":{"bioguide_id":"G000555","thomas_id":"01866","opensecrets_id":"N00027658","lis_id":"S331","cspan_id":"1022862","govtrack_id":"412223","votesmart_id":"65147","ballotpedia_id":"Kirsten Gillibrand","washington_post_id":null,"icpsr_id":"20735","wikipedia_id":"Kirsten Gillibrand"},"source":"Legislator data is originally collected and aggregated by https://github.com/unitedstates/"},{"type":"senator","bio":{"last_name":"Schumer","first_name":"Charles","birthday":"1950-11-23","gender":"M","party":"Democrat"},"contact":{"url":"https://www.schumer.senate.gov","address":"322 Hart Senate Office Building Washington DC 20510","phone":"202-224-6542","contact_form":"https://www.schumer.senate.gov/contact/email-chuck"},"social":{"rss_url":null,"twitter":"SenSchumer","facebook":"senschumer","youtube":"SenatorSchumer","youtube_id":"UC-ABttxh8uQv_10qmwGaidw"},"references":{"bioguide_id":"S000148","thomas_id":"01036","opensecrets_id":"N00001093","lis_id":"S270","cspan_id":"5929","govtrack_id":"300087","votesmart_id":"26976","ballotpedia_id":"Chuck Schumer","washington_post_id":null,"icpsr_id":"14858","wikipedia_id":"Chuck Schumer"},"source":"Legislator data is originally collected and aggregated by https://github.com/unitedstates/"}]}]}}]
     */

    private InputBean input;
    private List<ResultsBean> results;

    public InputBean getInput() {
        return input;
    }

    public void setInput(InputBean input) {
        this.input = input;
    }

    public List<ResultsBean> getResults() {
        return results;
    }

    public void setResults(List<ResultsBean> results) {
        this.results = results;
    }

    public static class InputBean {
        /**
         * address_components : {"zip":"12201","country":"US"}
         * formatted_address : 12201
         */

        private AddressComponentsBean address_components;
        private String formatted_address;

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

        public static class AddressComponentsBean {
            /**
             * zip : 12201
             * country : US
             */

            private String zip;
            private String country;

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
    }

    public static class ResultsBean {
        /**
         * address_components : {"city":"Albany","county":"Albany County","state":"NY","zip":"12201","country":"US"}
         * formatted_address : Albany, NY 12201
         * location : {"lat":42.614852,"lng":-73.970812}
         * accuracy : 1
         * accuracy_type : place
         * source : TIGER/Line® dataset from the US Census Bureau
         * fields : {"congressional_districts":[{"name":"Congressional District 20","district_number":20,"congress_number":"115th","congress_years":"2017-2019","proportion":1,"current_legislators":[{"type":"representative","bio":{"last_name":"Tonko","first_name":"Paul","birthday":"1949-06-18","gender":"M","party":"Democrat"},"contact":{"url":"https://tonko.house.gov","address":"2463 Rayburn House Office Building; Washington DC 20515-3220","phone":"202-225-5076","contact_form":null},"social":{"rss_url":"http://tonko.house.gov/rss/press-releases.xml","twitter":"RepPaulTonko","facebook":"reppaultonko","youtube":"reppaultonko","youtube_id":"UC3P2SGFmmuCYRsjeso0hOQQ"},"references":{"bioguide_id":"T000469","thomas_id":"01942","opensecrets_id":"N00030196","lis_id":null,"cspan_id":"1031353","govtrack_id":"412319","votesmart_id":"4403","ballotpedia_id":null,"washington_post_id":null,"icpsr_id":"20934","wikipedia_id":"Paul Tonko"},"source":"Legislator data is originally collected and aggregated by https://github.com/unitedstates/"},{"type":"senator","bio":{"last_name":"Gillibrand","first_name":"Kirsten","birthday":"1966-12-09","gender":"F","party":"Democrat"},"contact":{"url":"https://www.gillibrand.senate.gov","address":"478 Russell Senate Office Building Washington DC 20510","phone":"202-224-4451","contact_form":"https://www.gillibrand.senate.gov/contact/email-me"},"social":{"rss_url":"http://www.gillibrand.senate.gov/rss/","twitter":"SenGillibrand","facebook":"SenKirstenGillibrand","youtube":"KirstenEGillibrand","youtube_id":"UCVEloQogVsmnkd5vxJInmYg"},"references":{"bioguide_id":"G000555","thomas_id":"01866","opensecrets_id":"N00027658","lis_id":"S331","cspan_id":"1022862","govtrack_id":"412223","votesmart_id":"65147","ballotpedia_id":"Kirsten Gillibrand","washington_post_id":null,"icpsr_id":"20735","wikipedia_id":"Kirsten Gillibrand"},"source":"Legislator data is originally collected and aggregated by https://github.com/unitedstates/"},{"type":"senator","bio":{"last_name":"Schumer","first_name":"Charles","birthday":"1950-11-23","gender":"M","party":"Democrat"},"contact":{"url":"https://www.schumer.senate.gov","address":"322 Hart Senate Office Building Washington DC 20510","phone":"202-224-6542","contact_form":"https://www.schumer.senate.gov/contact/email-chuck"},"social":{"rss_url":null,"twitter":"SenSchumer","facebook":"senschumer","youtube":"SenatorSchumer","youtube_id":"UC-ABttxh8uQv_10qmwGaidw"},"references":{"bioguide_id":"S000148","thomas_id":"01036","opensecrets_id":"N00001093","lis_id":"S270","cspan_id":"5929","govtrack_id":"300087","votesmart_id":"26976","ballotpedia_id":"Chuck Schumer","washington_post_id":null,"icpsr_id":"14858","wikipedia_id":"Chuck Schumer"},"source":"Legislator data is originally collected and aggregated by https://github.com/unitedstates/"}]}]}
         */

        private AddressComponentsBeanX address_components;
        private String formatted_address;
        private LocationBean location;
        private float accuracy;
        private String accuracy_type;
        private String source;
        private FieldsBean fields;

        public AddressComponentsBeanX getAddress_components() {
            return address_components;
        }

        public void setAddress_components(AddressComponentsBeanX address_components) {
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

        public static class AddressComponentsBeanX {
            /**
             * city : Albany
             * county : Albany County
             * state : NY
             * zip : 12201
             * country : US
             */

            private String city;
            private String county;
            private String state;
            private String zip;
            private String country;

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
             * lat : 42.614852
             * lng : -73.970812
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
                 * name : Congressional District 20
                 * district_number : 20
                 * congress_number : 115th
                 * congress_years : 2017-2019
                 * proportion : 1
                 * current_legislators : [{"type":"representative","bio":{"last_name":"Tonko","first_name":"Paul","birthday":"1949-06-18","gender":"M","party":"Democrat"},"contact":{"url":"https://tonko.house.gov","address":"2463 Rayburn House Office Building; Washington DC 20515-3220","phone":"202-225-5076","contact_form":null},"social":{"rss_url":"http://tonko.house.gov/rss/press-releases.xml","twitter":"RepPaulTonko","facebook":"reppaultonko","youtube":"reppaultonko","youtube_id":"UC3P2SGFmmuCYRsjeso0hOQQ"},"references":{"bioguide_id":"T000469","thomas_id":"01942","opensecrets_id":"N00030196","lis_id":null,"cspan_id":"1031353","govtrack_id":"412319","votesmart_id":"4403","ballotpedia_id":null,"washington_post_id":null,"icpsr_id":"20934","wikipedia_id":"Paul Tonko"},"source":"Legislator data is originally collected and aggregated by https://github.com/unitedstates/"},{"type":"senator","bio":{"last_name":"Gillibrand","first_name":"Kirsten","birthday":"1966-12-09","gender":"F","party":"Democrat"},"contact":{"url":"https://www.gillibrand.senate.gov","address":"478 Russell Senate Office Building Washington DC 20510","phone":"202-224-4451","contact_form":"https://www.gillibrand.senate.gov/contact/email-me"},"social":{"rss_url":"http://www.gillibrand.senate.gov/rss/","twitter":"SenGillibrand","facebook":"SenKirstenGillibrand","youtube":"KirstenEGillibrand","youtube_id":"UCVEloQogVsmnkd5vxJInmYg"},"references":{"bioguide_id":"G000555","thomas_id":"01866","opensecrets_id":"N00027658","lis_id":"S331","cspan_id":"1022862","govtrack_id":"412223","votesmart_id":"65147","ballotpedia_id":"Kirsten Gillibrand","washington_post_id":null,"icpsr_id":"20735","wikipedia_id":"Kirsten Gillibrand"},"source":"Legislator data is originally collected and aggregated by https://github.com/unitedstates/"},{"type":"senator","bio":{"last_name":"Schumer","first_name":"Charles","birthday":"1950-11-23","gender":"M","party":"Democrat"},"contact":{"url":"https://www.schumer.senate.gov","address":"322 Hart Senate Office Building Washington DC 20510","phone":"202-224-6542","contact_form":"https://www.schumer.senate.gov/contact/email-chuck"},"social":{"rss_url":null,"twitter":"SenSchumer","facebook":"senschumer","youtube":"SenatorSchumer","youtube_id":"UC-ABttxh8uQv_10qmwGaidw"},"references":{"bioguide_id":"S000148","thomas_id":"01036","opensecrets_id":"N00001093","lis_id":"S270","cspan_id":"5929","govtrack_id":"300087","votesmart_id":"26976","ballotpedia_id":"Chuck Schumer","washington_post_id":null,"icpsr_id":"14858","wikipedia_id":"Chuck Schumer"},"source":"Legislator data is originally collected and aggregated by https://github.com/unitedstates/"}]
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
