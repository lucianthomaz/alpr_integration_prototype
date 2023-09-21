package com.lucianthomaz.alpr.alprintegration.usecase.usecaseconcept;

public interface UseCase <I, O>{
    void execute(I request, O responder);
}
