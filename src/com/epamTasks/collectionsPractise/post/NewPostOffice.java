package com.epamTasks.collectionsPractise.post;

import com.epamTasks.collectionsPractise.post.Box;

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class NewPostOffice {
    private final Collection<Box> listBox;
    private static final int COST_KILOGRAM = 5;
    private static final int COST_CUBIC_METER = 100;
    private static final double COEFFICIENT = 0.5;

    public NewPostOffice() {
        listBox = new ArrayList<>();
    }

    public Collection<Box> getListBox() {
        return (Collection<Box>) ((ArrayList<Box>) listBox).clone();
    }

    static BigDecimal calculateCostOfBox(double weight, double volume, int value) {
        BigDecimal costWeight = BigDecimal.valueOf(weight)
                .multiply(BigDecimal.valueOf(COST_KILOGRAM), MathContext.DECIMAL64);
        BigDecimal costVolume = BigDecimal.valueOf(volume)
                .multiply(BigDecimal.valueOf(COST_CUBIC_METER), MathContext.DECIMAL64);
        return costVolume.add(costWeight)
                .add(BigDecimal.valueOf(COEFFICIENT * value), MathContext.DECIMAL64);
    }

    // implements student
    public boolean addBox(String addresser, String recipient, double weight, double volume, int value) {
        if (addresser == null || recipient == null || addresser.isBlank() || recipient.isBlank()) {
            throw new IllegalArgumentException();
        }
        if (weight < 0.5 || weight > 20.0) {
            throw new IllegalArgumentException();
        }
        if (volume <= 0 || volume > 0.25) {
            throw new IllegalArgumentException();
        }
        if (value <= 0) {
            throw new IllegalArgumentException();
        }
        Box box = new Box(addresser, recipient, weight, volume);
        BigDecimal cost = calculateCostOfBox(weight, volume, value);
        box.setCost(cost);
        listBox.add(box);
        return true;
    }

    // implements student
    public Collection<Box> deliveryBoxToRecipient(String recipient) {
        Collection<Box> newBox = new ArrayList<>();
        Iterator<Box> boxIterator = listBox.iterator();
        while (boxIterator.hasNext()) {
            Box box = boxIterator.next();
            if (box.getRecipient().equals(recipient)) {
                newBox.add(box);
                boxIterator.remove();
            }
        }
        return newBox;
    }

    public void declineCostOfBox(double percent) {
        // BigDecimal тут используется бля более точного вычисления
        // double - кринжовый вариант для расчета денег, веса и т.д.
        for (Box box : listBox) {
            BigDecimal cost = box.getCost();
            BigDecimal rt = BigDecimal.valueOf(percent).divide(BigDecimal.valueOf(100));
            BigDecimal percentage = BigDecimal.valueOf(1).subtract(rt);
            BigDecimal newCost = cost.multiply(percentage, MathContext.DECIMAL64);
            box.setCost(newCost);
        }
    }
}
