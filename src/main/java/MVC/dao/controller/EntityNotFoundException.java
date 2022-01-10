package MVC.dao.controller;

import MVC.CoreException;

public class EntityNotFoundException extends CoreException {
    public EntityNotFoundException(String message) {
        super(message);
    }
}
