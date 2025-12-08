package com.linktic.ms_inventory.inventory.application.dto;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class JsonApiData<T> {
    String status;
    String message;
    T attributes;
}
