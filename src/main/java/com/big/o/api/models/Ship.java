package com.big.o.api.models;


import com.google.common.util.concurrent.Uninterruptibles;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Ship {

    public String ship_id;
    public String ship_name;
    public String ship_type;
    public List<Mission> missions;

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.JSON_STYLE);
    }

    public class Mission {

        public String name;
        public Integer flight;

        public String getName() {
            Uninterruptibles.sleepUninterruptibly(50, TimeUnit.MILLISECONDS);
            return name;
        }

        @Override
        public String toString() {
            return ToStringBuilder.reflectionToString(this, ToStringStyle.JSON_STYLE);
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;

            if (o == null || getClass() != o.getClass()) return false;

            Mission mission = (Mission) o;
            Uninterruptibles.sleepUninterruptibly(50, TimeUnit.MILLISECONDS);
            return new EqualsBuilder().append(name, mission.name).append(flight, mission.flight).isEquals();
        }

        @Override
        public int hashCode() {
            return new HashCodeBuilder(17, 37).append(name).append(flight).toHashCode();
        }
    }
}
