package com.lucianthomaz.alpr.alprintegration.controller;

import com.lucianthomaz.alpr.alprintegration.usecase.concept.BaseResponder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public abstract class BasePresenter<T, S> implements BaseResponder<S> {
    protected ResponseEntity<T> entity;

    public BasePresenter() {
    }

    public void onAccept(S interactorResponse) {
        this.entity = ResponseEntity.ok().build();
    }

    public void onNotFound() {
        this.entity = ResponseEntity.notFound().build();
    }

    public void onBadRequest() {
        this.entity = ResponseEntity.badRequest().build();
    }

    public void onInternalServerError() {
        this.entity = ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }

    public ResponseEntity<T> responseEntity() {
        return this.entity;
    }
}
