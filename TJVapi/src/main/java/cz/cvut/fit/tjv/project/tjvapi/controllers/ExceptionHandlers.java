package cz.cvut.fit.tjv.project.tjvapi.controllers;

import cz.cvut.fit.tjv.project.tjvapi.services.exceptions.EntityCannotBeCreatedException;
import cz.cvut.fit.tjv.project.tjvapi.services.exceptions.EntityDoesNotExistException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ExceptionHandlers {
    @ExceptionHandler(EntityDoesNotExistException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public void handleNotFound() {
    }

    @ExceptionHandler(EntityCannotBeCreatedException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    public void handleCannotBeCreated() {
    }
}
