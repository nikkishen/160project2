package com.example.nikkishen.myapplication;

public class CurrentLegislatorsBean {
    /**
     * type : representative
     * bio : {"last_name":"Norton","first_name":"Eleanor","birthday":"1937-06-13","gender":"F","party":"Democrat"}
     * contact : {"url":"https://norton.house.gov","address":"2136 Rayburn House Office Building; Washington DC 20515-5101","phone":"202-225-8050","contact_form":null}
     * social : {"rss_url":"http://norton.house.gov/index.php?format=feed&amp;type=rss","twitter":"EleanorNorton","facebook":"CongresswomanNorton","youtube":"EleanorHNorton","youtube_id":"UChRrAXUGylfxJjbquC6aUjQ"}
     * references : {"bioguide_id":"N000147","thomas_id":"00868","opensecrets_id":"N00001692","lis_id":null,"cspan_id":"882","govtrack_id":"400295","votesmart_id":"775","ballotpedia_id":null,"washington_post_id":null,"icpsr_id":null,"wikipedia_id":"Eleanor Holmes Norton"}
     * source : Legislator data is originally collected and aggregated by https://github.com/unitedstates/
     */

    private String type;
    private BioBean bio;
    private ContactBean contact;
    private SocialBean social;
    private ReferencesBean references;
    private String source;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public BioBean getBio() {
        return bio;
    }

    public void setBio(BioBean bio) {
        this.bio = bio;
    }

    public ContactBean getContact() {
        return contact;
    }

    public void setContact(ContactBean contact) {
        this.contact = contact;
    }

    public SocialBean getSocial() {
        return social;
    }

    public void setSocial(SocialBean social) {
        this.social = social;
    }

    public ReferencesBean getReferences() {
        return references;
    }

    public void setReferences(ReferencesBean references) {
        this.references = references;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public static class BioBean {
        /**
         * last_name : Norton
         * first_name : Eleanor
         * birthday : 1937-06-13
         * gender : F
         * party : Democrat
         */

        private String last_name;
        private String first_name;
        private String birthday;
        private String gender;
        private String party;

        public String getLast_name() {
            return last_name;
        }

        public void setLast_name(String last_name) {
            this.last_name = last_name;
        }

        public String getFirst_name() {
            return first_name;
        }

        public void setFirst_name(String first_name) {
            this.first_name = first_name;
        }

        public String getBirthday() {
            return birthday;
        }

        public void setBirthday(String birthday) {
            this.birthday = birthday;
        }

        public String getGender() {
            return gender;
        }

        public void setGender(String gender) {
            this.gender = gender;
        }

        public String getParty() {
            return party;
        }

        public void setParty(String party) {
            this.party = party;
        }
    }

    public static class ContactBean {
        /**
         * url : https://norton.house.gov
         * address : 2136 Rayburn House Office Building; Washington DC 20515-5101
         * phone : 202-225-8050
         * contact_form : null
         */

        private String url;
        private String address;
        private String phone;
        private Object contact_form;

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public String getPhone() {
            return phone;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }

        public Object getContact_form() {
            return contact_form;
        }

        public void setContact_form(Object contact_form) {
            this.contact_form = contact_form;
        }
    }

    public static class SocialBean {
        /**
         * rss_url : http://norton.house.gov/index.php?format=feed&amp;type=rss
         * twitter : EleanorNorton
         * facebook : CongresswomanNorton
         * youtube : EleanorHNorton
         * youtube_id : UChRrAXUGylfxJjbquC6aUjQ
         */

        private String rss_url;
        private String twitter;
        private String facebook;
        private String youtube;
        private String youtube_id;

        public String getRss_url() {
            return rss_url;
        }

        public void setRss_url(String rss_url) {
            this.rss_url = rss_url;
        }

        public String getTwitter() {
            return twitter;
        }

        public void setTwitter(String twitter) {
            this.twitter = twitter;
        }

        public String getFacebook() {
            return facebook;
        }

        public void setFacebook(String facebook) {
            this.facebook = facebook;
        }

        public String getYoutube() {
            return youtube;
        }

        public void setYoutube(String youtube) {
            this.youtube = youtube;
        }

        public String getYoutube_id() {
            return youtube_id;
        }

        public void setYoutube_id(String youtube_id) {
            this.youtube_id = youtube_id;
        }
    }

    public static class ReferencesBean {
        /**
         * bioguide_id : N000147
         * thomas_id : 00868
         * opensecrets_id : N00001692
         * lis_id : null
         * cspan_id : 882
         * govtrack_id : 400295
         * votesmart_id : 775
         * ballotpedia_id : null
         * washington_post_id : null
         * icpsr_id : null
         * wikipedia_id : Eleanor Holmes Norton
         */

        private String bioguide_id;
        private String thomas_id;
        private String opensecrets_id;
        private Object lis_id;
        private String cspan_id;
        private String govtrack_id;
        private String votesmart_id;
        private Object ballotpedia_id;
        private Object washington_post_id;
        private Object icpsr_id;
        private String wikipedia_id;

        public String getBioguide_id() {
            return bioguide_id;
        }

        public void setBioguide_id(String bioguide_id) {
            this.bioguide_id = bioguide_id;
        }

        public String getThomas_id() {
            return thomas_id;
        }

        public void setThomas_id(String thomas_id) {
            this.thomas_id = thomas_id;
        }

        public String getOpensecrets_id() {
            return opensecrets_id;
        }

        public void setOpensecrets_id(String opensecrets_id) {
            this.opensecrets_id = opensecrets_id;
        }

        public Object getLis_id() {
            return lis_id;
        }

        public void setLis_id(Object lis_id) {
            this.lis_id = lis_id;
        }

        public String getCspan_id() {
            return cspan_id;
        }

        public void setCspan_id(String cspan_id) {
            this.cspan_id = cspan_id;
        }

        public String getGovtrack_id() {
            return govtrack_id;
        }

        public void setGovtrack_id(String govtrack_id) {
            this.govtrack_id = govtrack_id;
        }

        public String getVotesmart_id() {
            return votesmart_id;
        }

        public void setVotesmart_id(String votesmart_id) {
            this.votesmart_id = votesmart_id;
        }

        public Object getBallotpedia_id() {
            return ballotpedia_id;
        }

        public void setBallotpedia_id(Object ballotpedia_id) {
            this.ballotpedia_id = ballotpedia_id;
        }

        public Object getWashington_post_id() {
            return washington_post_id;
        }

        public void setWashington_post_id(Object washington_post_id) {
            this.washington_post_id = washington_post_id;
        }

        public Object getIcpsr_id() {
            return icpsr_id;
        }

        public void setIcpsr_id(Object icpsr_id) {
            this.icpsr_id = icpsr_id;
        }

        public String getWikipedia_id() {
            return wikipedia_id;
        }

        public void setWikipedia_id(String wikipedia_id) {
            this.wikipedia_id = wikipedia_id;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CurrentLegislatorsBean that = (CurrentLegislatorsBean) o;
        return that.references.bioguide_id.equals(references.bioguide_id);
    }

}