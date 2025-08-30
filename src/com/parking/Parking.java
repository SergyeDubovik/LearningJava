package com.parking;

import java.math.BigDecimal;

public interface Parking {
    boolean enter(String carNumber);
    BigDecimal exit(String carNumber);
}
