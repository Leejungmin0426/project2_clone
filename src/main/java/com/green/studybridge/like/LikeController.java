package com.green.studybridge.like;

import com.green.studybridge.config.model.ResultResponse;
import com.green.studybridge.like.model.AcaDelLikeReq;
import com.green.studybridge.like.model.AcaLikeReq;
import com.green.studybridge.like.model.AcaLikeRes;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import lombok.RequiredArgsConstructor;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("like")
public class LikeController {
    private final LikeService service;


    /**
     * 학원 좋아요 등록
     * @param p AcaLikeReq 좋아요 등록 요청 (유저 ID, 학원 ID)
     * @return 좋아요 등록 결과 메시지와 유저 프로필 목록
     */
    @PostMapping
    @Operation(summary = "좋아요 등록", description = "특정 학원에 좋아요를 등록합니다.")
    public ResultResponse<AcaLikeRes> addLike(@ParameterObject @ModelAttribute AcaLikeReq p) {
        AcaLikeRes response = service.addLike(p);
        return ResultResponse.<AcaLikeRes>builder()
                .resultMessage("좋아요 등록 완료")
                .resultData(response)
                .build();
    }

    /**
     * 학원 좋아요 취소
     * @param p AcaDelLikeReq 좋아요 취소 요청 (유저 ID, 학원 ID)
     * @return 좋아요 취소 결과 메시지와 남은 유저 프로필 목록
     */
    @DeleteMapping
    @Operation(summary = "좋아요 취소", description = "특정 학원의 좋아요를 취소합니다.")
    public ResultResponse<AcaLikeRes> removeLike(@ParameterObject @ModelAttribute AcaDelLikeReq p) {
        AcaLikeRes response = service.removeLike(p);
        return ResultResponse.<AcaLikeRes>builder()
                .resultMessage("좋아요 취소 완료")
                .resultData(response)
                .build();
    }

    /**
     * 유저의 좋아요 목록 조회
     * @param userId 유저 ID
     * @return 유저가 좋아요한 학원의 ID 리스트
     */
    @GetMapping
    @Operation(summary = "좋아요 목록 조회", description = "특정 유저가 좋아요한 학원의 목록을 조회합니다.")
    public ResultResponse<List<Long>> getUserLikes(@Parameter(description = "유저 ID") @RequestParam long userId) {
        List<Long> likedAcademies = service.getUserLikes(userId);
        return ResultResponse.<List<Long>>builder()
                .resultMessage("좋아요 목록 조회 완료")
                .resultData(likedAcademies)
                .build();
    }
}