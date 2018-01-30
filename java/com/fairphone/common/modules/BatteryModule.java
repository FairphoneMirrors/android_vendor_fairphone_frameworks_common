/*
 * Copyright 2018 Fairphone B.V.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.fairphone.common.modules;

import android.annotation.NonNull;
import android.annotation.Nullable;
import android.content.Context;
import android.util.Log;

import com.android.internal.os.PowerProfile;

/**
 * A Fairphone 2 battery (module).
 */
public class BatteryModule extends Module {

    private enum Battery {

        BAT01("FP2-BAT01", 2420),
        BAT02("FP2-BAT02", 2440);

        /** Battery pack version identifier. */
        @NonNull
        final String versionId;

        /** Battery pack design capacity in milliampere-hour. */
        final int capacity;

        Battery(@NonNull String versionId, int capacity) {
            this.versionId = versionId;
            this.capacity = capacity;
        }
    }

    private static final String TAG = "BatteryModule";

    /** Installed battery design capacity in milliampere-hour. */
    private final int mDesignCapacity;

    /**
     * @return A fresh instance holding the installed battery module information, or {@code null}
     * if the battery was not recognised.
     */
    @Nullable
    public static BatteryModule getModule(@NonNull Context context) {
        Battery battery = null;

        final int capacity = (int) new PowerProfile(context).getBatteryCapacity();

        for (Battery temp : Battery.values()) {
            if (capacity == temp.capacity) {
                battery = temp;
                break;
            }
        }

        if (battery == null) {
            Log.e(TAG, "Unknown battery capacity: " + capacity);
            return null;
        } else {
            return new BatteryModule(battery);
        }
    }

    /**
     * Create a new instance holding the installed battery module information.
     */
    private BatteryModule(@NonNull Battery battery) {
        super(battery.versionId);

        mDesignCapacity = battery.capacity;
    }

    /**
     * @return The installed battery design capacity in milliampere-hour.
     */
    public int getDesignCapacity() {
        return mDesignCapacity;
    }

}
