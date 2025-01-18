package com.green.studybridge.review.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Schema(description = "리뷰 등록 요청")
public class ReviewPostReq {
    @Schema(title = "유저 ID", description = "리뷰를 작성하는 유저의 ID", example = "2020")
    private long userId;

    @Schema(title = "수업 ID", description = "리뷰를 등록할 수업의 ID", example = "1")
    private long classId;

    @Schema(title = "리뷰 내용", description = "작성할 리뷰 내용", example = "수업이 매우 유익했습니다!")
    private String comment;

    @Schema(title = "별점", description = "리뷰 별점", example = "5")
    private int star;
}