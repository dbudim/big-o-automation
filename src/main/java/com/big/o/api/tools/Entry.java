package com.big.o.api.tools;

import java.util.List;

public class Entry {

    public String id;
    public String name;
    public String description;
    public Boolean is_completed;
    public long completed_on;
    public int suite_id;
    public List<Entry> entries;
    public List<Entry> runs;

    public long getCompletedOn() {
        return completed_on;
    }
}
