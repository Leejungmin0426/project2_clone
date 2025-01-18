package com.green.studybridge.review.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Schema(description = "리뷰 삭제 요청")
public class ReviewDelReq {

    @Schema(title = "수업 참여 ID", description = "삭제할 리뷰의 수업 참여 ID", example = "1")
    private long joinClassId;

    @Schema(title = "유저 ID", description = "리뷰 삭제 요청을 한 유저의 ID", example = "2020")
    private long userId;
}