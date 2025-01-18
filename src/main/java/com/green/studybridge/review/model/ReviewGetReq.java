package com.green.studybridge.review.model;

import lombok.Getter;
import lombok.Setter;

import io.swagger.v3.oas.annotations.media.Schema;


@Getter
@Setter
@Schema(description = "리뷰 조회 요청")
public class ReviewGetReq {
    @Schema(title = "학원 ID", description = "학원의 리뷰를 조회하기 위한 학원 ID", example = "101")
    private long acaId;

    @Schema(title = "유저 ID", description = "특정 유저가 작성한 리뷰를 조회하기 위한 유저 ID", example = "2020")
    private long userId;
}