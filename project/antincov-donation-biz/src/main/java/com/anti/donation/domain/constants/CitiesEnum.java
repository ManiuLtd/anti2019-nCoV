package com.anti.donation.domain.constants;

public enum CitiesEnum {
    WUHAN(420100L,"武汉"),
    XIANGYANG(420600L,"襄阳"),
    XIAOGAN(420900L,"孝感"),
    HUANGGANG(421100L,"黄冈"),
    EZHOU(420700L,"鄂州"),
    HUANGSHI(420200L,"黄石"),
    SHIYAN(420300L,"十堰"),
    YICHANG(420500L,"宜昌"),
    JINGMEN(420800L,"荆门"),
    JINGZHOU(421000L,"荆州"),
    SUIZHOU(421300L,"随州"),
    XIANNING(421200L,"咸宁"),
    ENSHI(422800L,"恩施"),
    TIANMEN(429006L,"天门"),
    XIANTAO(429004L,"仙桃");
    private Long id;
    private String name;

    CitiesEnum(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
