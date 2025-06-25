package com.epamTasks.collectionsPractise.maternityHospitalJournal;

import java.util.*;

public class BirthJournalManagementImpl implements BirthJournalManagement {
    private Map<WeekDay, List<Baby>> journal = new EnumMap<>(WeekDay.class);
    private boolean isCommitted = false;

    @Override
    public boolean addEntryOfBaby(WeekDay day, Baby baby) {
        if (isCommitted) {
            return false;
        }
        List<Baby> babies = journal.get(day);
        if (babies == null) {
            babies = new ArrayList<>();
            journal.put(day, babies);
        }
        babies.add(baby);
        return true;
    }

    @Override
    public void commit() {
        isCommitted = true;
    }

    @Override
    public int amountBabies() {
        int count = 0;
        for (List<Baby> babies : journal.values()) {
            count = count + babies.size();
        }
        return count;
    }

    @Override
    public List<Baby> findBabyWithHighestWeight(String gender) {
        List<Baby> result = new ArrayList<>();
        double weight = -1;
        for (List<Baby> babies : journal.values()) {
            for (Baby baby : babies) {
                if (baby.getGender().equals(gender)) {
                    if (baby.getWeight() > weight) {
                        result.clear();
                        result.add(baby);
                        weight = baby.getWeight();
                    } else if (baby.getWeight() == weight) {
                        result.add(baby);
                    }
                }
            }
        }
        Collections.sort(result, new Comparator<Baby>() {
            @Override
            public int compare(Baby o1, Baby o2) {
                return o1.getName().compareTo(o2.getName());
            }
        });
        return Collections.unmodifiableList(result);
    }

    @Override
    public List<Baby> findBabyWithSmallestHeight(String gender) {
        List<Baby> result = new ArrayList<>();
        int height = Integer.MAX_VALUE;
        for (List<Baby> babies : journal.values()) {
            for (Baby baby : babies) {
                if (baby.getGender().equals(gender)) {
                    if (baby.getHeight() < height) {
                        result.clear();
                        result.add(baby);
                        height = baby.getHeight();
                    } else if (baby.getHeight() == height) {
                        result.add(baby);
                    }
                }
            }
        }
        Collections.sort(result, new Comparator<Baby>() {
            @Override
            public int compare(Baby o1, Baby o2) {
                return Double.compare(o1.getWeight(), o2.getWeight());
            }
        });
        return Collections.unmodifiableList(result);
    }

    @Override
    public Set<Baby> findBabiesByBirthTime(String from, String to) {
        Set<Baby> result = new HashSet<>();
        String normalizedFrom = normalizeTime(from);
        String normalizedTo = normalizeTime(to);
        for (List<Baby> babies : journal.values()) {
            for (Baby baby : babies) {
                String bornTime = baby.getTime();
                String normalizedBornTime = normalizeTime(bornTime);
                if (normalizedBornTime.compareTo(normalizedFrom) >= 0 &&
                        normalizedBornTime.compareTo(normalizedTo) <= 0) {
                    result.add(baby);
                }
            }
        }
        return Collections.unmodifiableSet(result);
    }
    private String normalizeTime(String time) {
        String[] parts = time.split(":");
        String hour = parts[0];
        String minute = parts[1];

        if (hour.length() == 1) {
            hour = "0" + hour;
        }
        if (minute.length() == 1) {
            minute = "0" + minute;
        }
        return hour + ":" + minute;
    }

}
