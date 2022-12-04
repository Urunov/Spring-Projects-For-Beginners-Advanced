package com.example.moneysecureauthflux.exception;

import lombok.Builder;
import org.springframework.beans.PropertyEditorRegistry;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;

import java.beans.PropertyEditor;
import java.util.List;
import java.util.Map;

import static java.lang.String.format;
import static org.springframework.util.Assert.notNull;

public interface HasDomainErrors extends BindingResult {
    //
    @Override
    default Object getTarget() {
        return getBindingResult().getTarget();
    }

    @Override
    default Map<String, Object> getModel() {
        return getBindingResult().getModel();
    }

    @Override
    default Object getRawFieldValue(String field) {
        return getBindingResult().getRawFieldValue(field);
    }

    @Override
    default PropertyEditor findEditor(String field, Class<?> valueType) {
        return getBindingResult().findEditor(field, valueType);
    }

    @Override
    default PropertyEditorRegistry getPropertyEditorRegistry() {
        return getBindingResult().getPropertyEditorRegistry();
    }

    @Override
    default String[] resolveMessageCodes(String errorCode) {
        return getBindingResult().resolveMessageCodes(errorCode);
    }

    @Override
    default String[] resolveMessageCodes(String errorCode, String field) {
        return getBindingResult().resolveMessageCodes(errorCode, field);
    }

    @Override
    default void addError(org.springframework.validation.ObjectError error) {
        getBindingResult().addError(error);
    }

    @Override
    default void recordFieldValue(String field, Class<?> type, Object value) {
        getBindingResult().recordFieldValue(field, type, value);
    }

    @Override
    default void recordSuppressedField(String field) {
        getBindingResult().recordSuppressedField(field);
    }

    @Override
    default String[] getSuppressedFields() {
        return getBindingResult().getSuppressedFields();
    }

    @Override
    default String getObjectName() {
        return getBindingResult().getObjectName();
    }

    @Override
    default void setNestedPath(String nestedPath) {
        getBindingResult().setNestedPath(nestedPath);
    }

    @Override
    default String getNestedPath() {
        return getBindingResult().getNestedPath();
    }

    @Override
    default void pushNestedPath(String subPath) {
        getBindingResult().pushNestedPath(subPath);
    }

    @Override
    default void popNestedPath() throws IllegalStateException {
        getBindingResult().popNestedPath();
    }

    @Override
    default void reject(String errorCode) {
        getBindingResult().reject(errorCode);
    }

    @Override
    default void reject(String errorCode, String defaultMessage) {
        getBindingResult().reject(errorCode, defaultMessage);
    }

    @Override
    default void reject(String errorCode, Object[] errorArgs, String defaultMessage) {
        getBindingResult().reject(errorCode, errorArgs, defaultMessage);
    }

    @Override
    default void rejectValue(String field, String errorCode) {
        getBindingResult().rejectValue(field, errorCode);
    }

    @Override
    default void rejectValue(String field, String errorCode, String defaultMessage) {
        getBindingResult().rejectValue(field, errorCode, defaultMessage);
    }

    @Override
    default void rejectValue(String field, String errorCode, Object[] errorArgs, String defaultMessage) {
        getBindingResult().rejectValue(field, errorCode, errorArgs, defaultMessage);
    }

    @Override
    default void addAllErrors(Errors errors) {
        getBindingResult().addAllErrors(errors);
    }

    @Override
    default boolean hasErrors() {
        return getBindingResult().hasErrors();
    }

    @Override
    default int getErrorCount() {
        return getBindingResult().getErrorCount();
    }

    @Override
    default List<ObjectError> getAllErrors() {
        return getBindingResult().getAllErrors();
    }

    @Override
    default boolean hasGlobalErrors() {
        return getBindingResult().hasGlobalErrors();
    }

    @Override
    default int getGlobalErrorCount() {
        return getBindingResult().getGlobalErrorCount();
    }

    @Override
    default List<org.springframework.validation.ObjectError> getGlobalErrors() {
        return getBindingResult().getGlobalErrors();
    }

    @Override
    default org.springframework.validation.ObjectError getGlobalError() {
        return getBindingResult().getGlobalError();
    }

    @Override
    default boolean hasFieldErrors() {
        return getBindingResult().hasFieldErrors();
    }

    @Override
    default int getFieldErrorCount() {
        return getBindingResult().getFieldErrorCount();
    }

    @Override
    default List<org.springframework.validation.FieldError> getFieldErrors() {
        return getBindingResult().getFieldErrors();
    }

    @Override
    default org.springframework.validation.FieldError getFieldError() {
        return getBindingResult().getFieldError();
    }

    @Override
    default boolean hasFieldErrors(String field) {
        return getBindingResult().hasFieldErrors(field);
    }

    @Override
    default int getFieldErrorCount(String field) {
        return getBindingResult().getFieldErrorCount(field);
    }

    @Override
    default List<org.springframework.validation.FieldError> getFieldErrors(String field) {
        return getBindingResult().getFieldErrors(field);
    }

    @Override
    default org.springframework.validation.FieldError getFieldError(String field) {
        return getBindingResult().getFieldError(field);
    }

    @Override
    default Object getFieldValue(String field) {
        return getBindingResult().getFieldValue(field);
    }

    @Override
    default Class<?> getFieldType(String field) {
        return getBindingResult().getFieldType(field);
    }

    default void addDomainError(DomainError error) {
        if (error instanceof DomainObjectError) {
            addDomainError((DomainObjectError) error);
        } else if (error instanceof DomainFieldError) {
            addDomainError((DomainFieldError) error);
        } else {
            throw new RuntimeException(format("Unknown error: %s", error));
        }
    }

    private void addDomainError(DomainObjectError error) {
        notNull(getObjectName(), "'objectName' mustn't be null!");
        addError(new org.springframework.validation.ObjectError(
                getObjectName(),
                new String[]{error.code},
                error.arguments,
                error.message
        ));
    }

    private void addDomainError(DomainFieldError error) {
        notNull(getObjectName(), "'objectName' mustn't be null!");
        addError(new org.springframework.validation.FieldError(
                getObjectName(),
                error.field,
                error.rejectedValue,
                false,
                new String[]{error.code},
                error.arguments,
                error.message)
        );
    }

    BindingResult getBindingResult();

    interface DomainError {
    }

    @Builder(builderMethodName = "error")
    class DomainObjectError implements DomainError {
        String code;
        String[] arguments;
        String message;
    }

    @Builder(builderMethodName = "error")
    class DomainFieldError implements DomainError {
        String field;
        Object rejectedValue;
        String code;
        String[] arguments;
        String message;
    }

}
