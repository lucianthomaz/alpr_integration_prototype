package com.lucianthomaz.alpr.alprintegration.controller.alert.create;

import com.lucianthomaz.alpr.alprintegration.controller.user.create.UserCreationViewModel;

import java.time.LocalDateTime;
import java.util.List;

public record AlertCreationViewModel(int id,
                                     int locationId,
                                     String licensePlate,
                                     int alertTypeId,
                                     LocalDateTime dateTime,
                                     String details,
                                     String pictureUrl,
                                     List<UserCreationViewModel> usersNotified) {
}
