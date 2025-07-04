package com.epamTasks.lambdaExpressions.percentageFormatter;

import java.util.Locale;
import java.util.function.DoubleFunction;

public interface PercentageFormatter {
    DoubleFunction<String> INSTANCE = d -> {
        double val = Math.round(d * 1000) / 10.0;
        return val % 1 == 0 ? String.format(Locale.US, "%.0f %%", val) :
                String.format(Locale.US, "%.1f %%", val);
    };
}
