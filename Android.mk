#
# Copyright 2018 Fairphone B.V.
#
# Licensed under the Apache License, Version 2.0 (the "License");
# you may not use this file except in compliance with the License.
# You may obtain a copy of the License at
#
#      http://www.apache.org/licenses/LICENSE-2.0
#
# Unless required by applicable law or agreed to in writing, software
# distributed under the License is distributed on an "AS IS" BASIS,
# WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
# See the License for the specific language governing permissions and
# limitations under the License.
#

ifneq ($(TARGET_BUILD_JAVA_SUPPORT_LEVEL),)

LOCAL_PATH := $(call my-dir)

# The library
# ============================================================
include $(CLEAR_VARS)

LOCAL_SRC_FILES := \
        $(call all-subdir-java-files)

LOCAL_MODULE_TAGS := optional

LOCAL_MODULE := com.fairphone.common

include $(BUILD_JAVA_LIBRARY)

# The documentation
# ============================================================
include $(CLEAR_VARS)

LOCAL_SRC_FILES := $(call all-subdir-java-files) $(call all-subdir-html-files)

LOCAL_MODULE := fairphone-common
LOCAL_DROIDDOC_OPTIONS :=
LOCAL_MODULE_CLASS := JAVA_LIBRARIES
LOCAL_DROIDDOC_USE_STANDARD_DOCLET := true

include $(BUILD_DROIDDOC)

endif # JAVA_SUPPORT
