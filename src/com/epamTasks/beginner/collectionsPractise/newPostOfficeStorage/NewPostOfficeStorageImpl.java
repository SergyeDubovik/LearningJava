package com.epamTasks.beginner.collectionsPractise.newPostOfficeStorage;

import java.math.BigDecimal;
import java.util.*;
import java.util.function.Predicate;

public class NewPostOfficeStorageImpl implements NewPostOfficeStorage {
    private List<Box> parcels;

    /**
     * Creates internal storage for becoming parcels
     */
    public NewPostOfficeStorageImpl() {
        parcels = new LinkedList<>();
    }

    /**
     * Creates own storage and appends all parcels into own storage.
     * It must add either all the parcels or nothing, if an exception occurs.
     *
     * @param boxes a collection of parcels.
     * @throws NullPointerException if the parameter is {@code null}
     *                              or contains {@code null} values.
     */
    public NewPostOfficeStorageImpl(Collection<Box> boxes) {
        if (boxes == null) {
            throw new NullPointerException();
        }
        for (Box box : boxes) {
            if (box == null) {
                throw new NullPointerException();
            }
        }
        this.parcels = new LinkedList<>();
        parcels.addAll(boxes);
    }

    @Override
    public boolean acceptBox(Box box) {
        if (box == null) {
            throw new NullPointerException();
        }
        parcels.add(box);
        return true;
    }

    @Override
    public boolean acceptAllBoxes(Collection<Box> boxes) {
        if (boxes == null) {
            throw new NullPointerException();
        }
        for (Box box : boxes) {
            if (box == null) {
                throw new NullPointerException();
            }
        }
        parcels.addAll(boxes);
        return true;
    }

    @Override
    public boolean carryOutBoxes(Collection<Box> boxes) {
        if (boxes == null) {
            throw new NullPointerException();
        }
        for (Box box : boxes) {
            if (box == null) {
                throw new NullPointerException();
            }
        }
        Iterator<Box> iterator = parcels.iterator();
        boolean removed = false;
        while (iterator.hasNext()) {
            Box currentBox = iterator.next();
            boolean found = false;
            for (Box box : boxes) {
                if (currentBox.equals(box)) {
                    found = true;
                    break;
                }
            }
            if (found) {
                iterator.remove();
                removed = true;
            }
        }
        return removed;
    }

    @Override
    public List<Box> carryOutBoxes(Predicate<Box> predicate) {
        if (predicate == null) {
            throw new NullPointerException();
        }
        List<Box> result = new ArrayList<>();
        Iterator<Box> iterator = parcels.iterator();
        while (iterator.hasNext()) {
            Box currentBox = iterator.next();
            if (predicate.test(currentBox)) {
                result.add(currentBox);
                iterator.remove();
            }
        }
        return result;
    }

    @Override
    public List<Box> getAllWeightLessThan(double weight) {
        if (weight <= 0) {
            throw new IllegalArgumentException();
        }
        return searchBoxes(new Predicate<Box>() {
            @Override
            public boolean test(Box box) {
                return box.getWeight() < weight;
            }
        });
//        ArrayList<Box> result = new ArrayList<>();
//        for (Box box : parcels) {
//            if (box.getWeight() < weight) {
//                result.add(box);
//            }
//        }
//        return result;
    }

    @Override
    public List<Box> getAllCostGreaterThan(BigDecimal cost) {
        if (cost == null) {
            throw new NullPointerException();
        }
        if (cost.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException();
        }
        return searchBoxes(new Predicate<Box>() {
            @Override
            public boolean test(Box box) {
                return box.getCost().compareTo(cost) > 0;
            }
        });
//        ArrayList<Box> result = new ArrayList<>();
//        for (Box box : parcels) {
//            if (box.getCost().compareTo(cost) > 0) {
//                result.add(box);
//            }
//        }
//        return result;
    }

    @Override
    public List<Box> getAllVolumeGreaterOrEqual(double volume) {
        if (volume < 0) {
            throw new IllegalArgumentException();
        }
        return searchBoxes(new Predicate<Box>() {
            @Override
            public boolean test(Box box) {
                return box.getVolume() >= volume;
            }
        });
//        ArrayList<Box> result = new ArrayList<>();
//        for (Box box : parcels) {
//            if (box.getVolume() >= volume) {
//                result.add(box);
//            }
//        }
//          return result;
    }

    @Override
    public List<Box> searchBoxes(Predicate<Box> predicate) {
        if (predicate == null) {
            throw new NullPointerException();
        }
        ArrayList<Box> res = new ArrayList<>();
        for (Box box : parcels) {
            if (predicate.test(box)) {
                res.add(box);
            }
        }
        return res;
    }

    @Override
    public void updateOfficeNumber(Predicate<Box> predicate, int newOfficeNumber) {
        if (predicate == null) {
            throw new NullPointerException();
        }
        for (Box box : parcels) {
            if (predicate.test(box)) {
                box.setOfficeNumber(newOfficeNumber);
            }
        }
    }
}
