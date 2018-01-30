# Vendor path
VENDOR_PATH := vendor/fairphone

PRODUCT_COPY_FILES += \
    $(VENDOR_PATH)/frameworks/common/com.fairphone.common.xml:/system/etc/permissions/com.fairphone.common.xml \

PRODUCT_PACKAGES += \
    com.fairphone.common \
