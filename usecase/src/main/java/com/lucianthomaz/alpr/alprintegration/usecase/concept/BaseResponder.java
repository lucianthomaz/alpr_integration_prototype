package com.lucianthomaz.alpr.alprintegration.usecase.concept;

public interface BaseResponder <S>{
    void onAccept(S var1);

    void onInternalServerError();

    void onNotFound();

    void onBadRequest();
}
