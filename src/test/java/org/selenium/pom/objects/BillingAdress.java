package org.selenium.pom.objects;

public class BillingAdress {
    private String firstnames;
    private String lastnames;
    private String companys;
    private String addres01s;
    private String addres02s;
    private String citys;
    private String postcodes;
    private String phones;
    private String emails;
    private String commentss;

    public BillingAdress(String firstnames, String lastnames, String companys,
                         String addres01s, String addres02s, String citys, String postcodes,
                         String phones, String emails, String commentss){
        this.firstnames = firstnames;
        this.lastnames = lastnames;
        this.companys = companys;
        this.addres01s = addres01s;
        this.addres02s = addres02s;
        this.citys = citys;
        this.postcodes = postcodes;
        this.phones = phones;
        this.emails = emails;
        this.commentss = commentss;
    }

    public String getFirstnames() {
        return firstnames;
    }

    public BillingAdress setFirstnames(String firstnames) {
        this.firstnames = firstnames;
        return this;
    }

    public String getLastnames() {
        return lastnames;
    }

    public BillingAdress setLastnames(String lastnames) {
        this.lastnames = lastnames;
        return this;
    }

    public String getCompanys() {
        return companys;
    }

    public BillingAdress setCompanys(String companys) {
        this.companys = companys;
        return this;
    }

    public String getAddres01s() {
        return addres01s;
    }

    public BillingAdress setAddres01s(String addres01s) {
        this.addres01s = addres01s;
        return this;
    }

    public String getAddres02s() {
        return addres02s;
    }

    public BillingAdress setAddres02s(String addres02s) {
        this.addres02s = addres02s;
        return this;
    }

    public String getCitys() {
        return citys;
    }

    public BillingAdress setCitys(String citys) {
        this.citys = citys;
        return this;
    }

    public String getPostcodes() {
        return postcodes;
    }

    public BillingAdress setPostcodes(String postcodes) {
        this.postcodes = postcodes;
        return this;
    }

    public String getPhones() {
        return phones;
    }

    public BillingAdress setPhones(String phones) {
        this.phones = phones;
        return this;
    }

    public String getEmails() {
        return emails;
    }

    public BillingAdress setEmails(String emails) {
        this.emails = emails;
        return this;
    }

    public String getCommentss() {
        return commentss;
    }

    public BillingAdress setCommentss(String commentss) {
        this.commentss = commentss;
        return this;
    }

}
