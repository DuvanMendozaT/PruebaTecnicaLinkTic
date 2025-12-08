package com.linktic.ms_inventory.inventory.infrastructure.rest.handler;

import com.linktic.ms_inventory.inventory.application.Constants;
import com.linktic.ms_inventory.inventory.application.dto.JsonApiData;
import com.linktic.ms_inventory.inventory.application.dto.JsonApiResponse;
import com.linktic.ms_inventory.inventory.domain.exeption.ExternalClientException;
import com.linktic.ms_inventory.inventory.domain.exeption.ExternalServerException;
import com.linktic.ms_inventory.inventory.domain.exeption.ExternalServiceException;
import com.linktic.ms_inventory.inventory.domain.exeption.InventpryNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ApiExceptionHandler {
    @ExceptionHandler(InventpryNotFoundException.class)
    public ResponseEntity<JsonApiResponse> handleProductNotFound(
            InventpryNotFoundException ex
    ) {
        JsonApiData body = JsonApiData.builder()
                .status(Constants.OPERATION_FAILED)
                .message(ex.getMessage())
                .build();

        JsonApiResponse response = JsonApiResponse.builder()
                .data(body)
                .build();

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
    }

    @ExceptionHandler(ExternalClientException.class)
    public ResponseEntity<JsonApiResponse> handleExternalClientException(
            ExternalClientException ex
    ) {
        JsonApiData body = JsonApiData.builder()
                .status(Constants.OPERATION_FAILED)
                .message(ex.getMessage())
                .build();
        JsonApiResponse response = JsonApiResponse.builder()
                .data(body)
                .build();

        return ResponseEntity.badRequest().body(response);
    }

    @ExceptionHandler(ExternalServerException.class)
    public ResponseEntity<JsonApiResponse> handleExternalError(
            ExternalServiceException ex
    ) {
        JsonApiData body = JsonApiData.builder()
                .status(Constants.OPERATION_FAILED)
                .message(ex.getMessage())
                .build();
        JsonApiResponse response = JsonApiResponse.builder()
                .data(body)
                .build();

        return ResponseEntity.status(HttpStatus.BAD_GATEWAY).body(response);
    }


    @ExceptionHandler(Exception.class)
    public ResponseEntity<JsonApiResponse> handleGenericException(
            Exception ex
    ) {
        JsonApiData body = JsonApiData.builder()
                .status(Constants.OPERATION_FAILED)
                .message(ex.getMessage())
                .build();
        JsonApiResponse response = JsonApiResponse.builder()
                .data(body)
                .build();

        return ResponseEntity.status(HttpStatus.BAD_GATEWAY).body(response);
    }
}
