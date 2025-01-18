package com.green.studybridge.review;

import com.green.studybridge.config.exception.ErrorCode;
import com.green.studybridge.review.dto.ReviewDto;
import com.green.studybridge.review.model.ReviewDelReq;
import com.green.studybridge.review.model.ReviewPostReq;
import com.green.studybridge.review.model.ReviewUpdateReq;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ReviewService {

    private final ReviewMapper mapper;


    // 리뷰 등록
    public boolean addReview(ReviewPostReq req) {
        // 사용자가 해당 수업에 참여했는지 확인
        int participationCount = mapper.checkUserParticipation(req.getUserId(), req.getClassId());
        if (participationCount == 0) {
            throw new IllegalArgumentException("해당 수업에 참여한 학생만 리뷰를 작성할 수 있습니다.");
        }

        return mapper.insertReview(req) > 0;
    }


    // 리뷰 수정
    public boolean updateReview(ReviewUpdateReq req) {
        return mapper.updateReview(req) > 0;
    }

    // 학원 상세페이지에서 리뷰 조회
    public List<ReviewDto> getAcademyReviewsForPublic(long acaId) {
        return mapper.getAcademyReviewsForPublic(acaId);
    }

    // 학원 관계자가 본인 학원의 리뷰 조회
    public List<ReviewDto> getAcademyReviews(long acaId, long userId) {
        // 유저 Role 검증
        Integer roleId = mapper.getUserRoleId(userId);
        if (roleId == null || roleId != 3) { // Role ID 3: 학원 관계자
            throw new IllegalArgumentException("학원 관계자만 본 학원의 리뷰를 조회할 수 있습니다.");
        }

        // 학원의 리뷰 조회
        return mapper.getAcademyReviews(acaId);
    }

    // 리뷰 삭제
    public boolean deleteReview(ReviewDelReq req) {
        // 유저 Role 검증
        Integer roleId = mapper.getUserRoleId(req.getUserId());
        if (roleId == null || roleId != 3) { // Role ID 3: 학원 관계자
            throw new IllegalArgumentException("해당 유저는 학원 관계자가 아닙니다.");
        }

        // 리뷰 삭제 실행
        return mapper.deleteReview(req) > 0;
    }
}