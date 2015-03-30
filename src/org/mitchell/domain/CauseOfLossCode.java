

package org.mitchell.domain;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;

@XmlType(name = "CauseOfLossCode")
@XmlEnum
public enum CauseOfLossCode {

    @XmlEnumValue("Collision")
    COLLISION("Collision"),
    @XmlEnumValue("Explosion")
    EXPLOSION("Explosion"),
    @XmlEnumValue("Fire")
    FIRE("Fire"),
    @XmlEnumValue("Hail")
    HAIL("Hail"),
    @XmlEnumValue("Mechanical Breakdown")
    MECHANICAL_BREAKDOWN("Mechanical Breakdown"),
    @XmlEnumValue("Other")
    OTHER("Other");
    private final String value;

    CauseOfLossCode(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static CauseOfLossCode fromValue(String v) {
        for (CauseOfLossCode c: CauseOfLossCode.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
