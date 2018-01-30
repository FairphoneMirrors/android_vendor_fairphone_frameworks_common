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

/**
 * A Fairphone 2 module.
 */
public abstract class Module {

    /** The installed, non-translatable module version identifier. */
    @NonNull
    private final String mVersionId;

    Module(@NonNull String versionId) {
        mVersionId = versionId;
    }

    /**
     * @return The installed, non-translatable module version identifier or {@code null}.
     */
    @NonNull
    public final String getVersionId() {
        return mVersionId;
    }

}
