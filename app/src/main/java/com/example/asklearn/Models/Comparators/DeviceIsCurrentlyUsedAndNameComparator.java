package com.example.asklearn.Models.Comparators;

import com.example.asklearn.Models.Device;

import java.util.Comparator;

public class DeviceIsCurrentlyUsedAndNameComparator implements Comparator<Device> {
    @Override
    public int compare(Device device, Device otherDevice) {
        int compareResult = Boolean.compare(device.isCurrentlyUsed(), otherDevice.isCurrentlyUsed());
        if (compareResult == 0) {
            compareResult = device.getName().compareToIgnoreCase(otherDevice.getName());
        }
        return compareResult;
    }
}
