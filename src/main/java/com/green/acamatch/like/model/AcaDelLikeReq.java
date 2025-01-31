package com.green.acamatch.like.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Setter
@Getter
@EqualsAndHashCode
public class AcaDelLikeReq implements Serializable {
    @Schema(title = "유저 PK", example = "2119", requiredMode = Schema.RequiredMode.REQUIRED)
    private long userId;
    @Schema(title = "학원 PK", example = "1", requiredMode = Schema.RequiredMode.REQUIRED)
    private long acaId;
}