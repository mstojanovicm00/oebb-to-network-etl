package rs.raf.mstojanovic5623m.agpp.network.oebb.oebb.model;

public class Agency {

    public static final Agency INVALID
            = new Agency("invalid",
            "", "", "", "", "");

    private final String agencyId;
    private final String agencyName;
    private final String agencyUrl;
    private final String agencyTimeZone;
    private final String agencyLanguage;
    private final String agencyPhone;

    public Agency(String agencyId, String agencyName, String agencyUrl, String agencyTimeZone, String agencyLanguage, String agencyPhone) {
        this.agencyId = agencyId;
        this.agencyName = agencyName;
        this.agencyUrl = agencyUrl;
        this.agencyTimeZone = agencyTimeZone;
        this.agencyLanguage = agencyLanguage;
        this.agencyPhone = agencyPhone;
    }

    @Override
    public String toString() {
        return "Agency{" +
                "agencyId='" + agencyId + '\'' +
                ", agencyName='" + agencyName + '\'' +
                ", agencyUrl='" + agencyUrl + '\'' +
                ", agencyTimeZone='" + agencyTimeZone + '\'' +
                ", agencyLanguage='" + agencyLanguage + '\'' +
                ", agencyPhone='" + agencyPhone + '\'' +
                '}';
    }

    public String getAgencyId() {
        return agencyId;
    }

    public String getAgencyName() {
        return agencyName;
    }

    public String getAgencyUrl() {
        return agencyUrl;
    }

    public String getAgencyTimeZone() {
        return agencyTimeZone;
    }

    public String getAgencyLanguage() {
        return agencyLanguage;
    }

    public String getAgencyPhone() {
        return agencyPhone;
    }
}
