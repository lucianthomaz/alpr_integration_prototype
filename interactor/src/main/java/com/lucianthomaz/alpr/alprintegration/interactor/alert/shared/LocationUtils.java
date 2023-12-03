package com.lucianthomaz.alpr.alprintegration.interactor.alert.shared;

import com.lucianthomaz.alpr.alprintegration.domain.Location;

import java.util.List;

public class LocationUtils {

    public static UserLocation findClosestLocation(Location reference, List<UserLocation> userLocations) {
        UserLocation closestLocation = null;
        double minDistance = Double.MAX_VALUE;

        for (UserLocation location : userLocations) {
            double distance = distance(reference.getLatitude(), reference.getLongitude(), location.latitude(), location.longitude());
            if (distance < minDistance) {
                minDistance = distance;
                closestLocation = location;
            }
        }

        return closestLocation;
    }

    // Haversine formula to calculate distance between two points
    private static double distance(double lat1, double lon1, double lat2, double lon2) {
        final int R = 6371; // Radius of the earth in kilometers

        double latDistance = Math.toRadians(lat2 - lat1);
        double lonDistance = Math.toRadians(lon2 - lon1);
        double a = Math.sin(latDistance / 2) * Math.sin(latDistance / 2)
                + Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2))
                * Math.sin(lonDistance / 2) * Math.sin(lonDistance / 2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
        return R * c; // Distance in kilometers
    }
}

