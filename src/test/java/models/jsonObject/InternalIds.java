package models.jsonObject;

public class InternalIds {

    String domain;
    String domainId;

    public String getDomain() {
        return domain;
    }

    public InternalIds setDomain(String domain) {
        this.domain = domain;
        return this;
    }

    public String getDomainId() {
        return domainId;
    }

    public InternalIds setDomainId(String domainId) {
        this.domainId = domainId;
        return this;
    }

    @Override
    public String toString() {
        return "InternalIds{" +
                "domain='" + domain + '\'' +
                ", domainId='" + domainId + '\'' +
                '}';
    }
}
