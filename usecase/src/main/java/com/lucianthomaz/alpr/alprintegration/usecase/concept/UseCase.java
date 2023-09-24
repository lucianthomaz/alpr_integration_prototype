package com.lucianthomaz.alpr.alprintegration.usecase.concept;

public interface UseCase <I, O>{
    void execute(I request, O responder);
}
