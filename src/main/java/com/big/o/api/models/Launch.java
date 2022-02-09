package com.big.o.api.models;

import com.google.common.util.concurrent.Uninterruptibles;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static com.google.common.util.concurrent.Uninterruptibles.sleepUninterruptibly;

/**
 * Created by dbudim on 11.12.2021
 */

public class Launch {

    public Integer flight_number;
    public String mission_name;
    public List<String> mission_id;
    public Boolean upcoming;
    public Integer launch_year;
    public Long launch_date_unix;
    public String launch_date_utc;
    public String launch_date_local;
    public Boolean is_tentative;
    public String tentative_max_precision;
    public Boolean tbd;
    public Integer launch_window;

    public Launch() {
    }

    public Launch(Integer flight_number) {
        this.flight_number = flight_number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Launch launch = (Launch) o;
        sleepUninterruptibly(20, TimeUnit.MILLISECONDS);
        return flight_number.equals(launch.flight_number);
    }

    @Override
    public int hashCode() {
        return flight_number.hashCode();
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.JSON_STYLE);
    }

    public Integer getFlight_number() {
        Uninterruptibles.sleepUninterruptibly(50,TimeUnit.MILLISECONDS);
        return flight_number;
    }
}
