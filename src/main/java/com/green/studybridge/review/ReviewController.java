package com.green.studybridge.review;

import com.green.studybridge.config.model.ResultResponse;
import com.green.studybridge.review.dto.ReviewDto;
import com.green.studybridge.review.model.ReviewDelReq;
import com.green.studybridge.review.model.ReviewPostReq;
import com.green.studybridge.review.model.ReviewUpdateReq;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/review")
public class ReviewController {
    private final ReviewService service;

    // 학생 유저 리뷰 등록
    @PostMapping
    @Operation(summary = "리뷰 등록", description = "학생 유저가 리뷰를 등록합니다.")
    public ResultResponse<Boolean> addReview(@RequestBody ReviewPostReq req) {
        boolean success = service.addReview(req);
        return ResultResponse.<Boolean>builder()
                .resultMessage("리뷰 등록 완료")
                .resultData(success)
                .build();
    }

    // 학생 유저 리뷰 수정
    @PutMapping
    @Operation(summary = "리뷰 수정", description = "학생 유저가 자신의 리뷰를 수정합니다.")
    public ResultResponse<Boolean> updateReview(@RequestBody ReviewUpdateReq req) {
        boolean success = service.updateReview(req);
        return ResultResponse.<Boolean>builder()
                .resultMessage("리뷰 수정 완료")
                .resultData(success)
                .build();
    }

    // 학원 관계자 리뷰 삭제
    @DeleteMapping
    @Operation(summary = "리뷰 삭제", description = "리뷰를 삭제합니다.")
    public ResultResponse<Boolean> deleteReview(@RequestBody ReviewDelReq req) {
        boolean success = service.deleteReview(req);
        return ResultResponse.<Boolean>builder()
                .resultMessage("리뷰 삭제 완료")
                .resultData(success)
                .build();
    }


    // 학원 관계자 본인 학원의 리뷰 조회
    @GetMapping("/academy")
    @Operation(summary = "학원 리뷰 조회", description = "학원 관계자가 본 학원의 리뷰를 조회합니다.")
    public ResultResponse<List<ReviewDto>> getAcademyReviews(@RequestParam long acaId, @RequestParam long userId) {
        List<ReviewDto> reviews = service.getAcademyReviews(acaId, userId);
        return ResultResponse.<List<ReviewDto>>builder()
                .resultMessage("학원 리뷰 조회 완료")
                .resultData(reviews)
                .build();
    }

    // 학원 상세페이지에서 리뷰 조회
    @GetMapping("/public")
    @Operation(summary = "학원 상세페이지 리뷰 조회", description = "학원 상세페이지에서 리뷰를 조회합니다.")
    public ResultResponse<List<ReviewDto>> getAcademyReviewsForPublic(@RequestParam long acaId) {
        List<ReviewDto> reviews = service.getAcademyReviewsForPublic(acaId);
        return ResultResponse.<List<ReviewDto>>builder()
                .resultMessage("학원 상세페이지 리뷰 조회 완료")
                .resultData(reviews)
                .build();
    }
}