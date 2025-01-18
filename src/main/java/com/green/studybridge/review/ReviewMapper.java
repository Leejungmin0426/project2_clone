package com.green.studybridge.review;

import com.green.studybridge.review.dto.ReviewDto;
import com.green.studybridge.review.model.ReviewDelReq;
import com.green.studybridge.review.model.ReviewPostReq;
import com.green.studybridge.review.model.ReviewUpdateReq;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface ReviewMapper {


    // 수업 참여 여부 확인
    int checkUserParticipation(long userId, long classId);

    // 유저의 Role ID 조회
    @Select("SELECT role_id FROM user WHERE user_id = #{userId}")
    Integer getUserRoleId(long userId);

    // 리뷰 등록
    int insertReview(ReviewPostReq req);

    // 리뷰 수정
    int updateReview(ReviewUpdateReq req);

    //특정 유저가 학원 관계자인지 확인
    int isAcademyAdmin(long userId);

    // 리뷰 삭제
    // int deleteReview(ReviewDelReq req);
    @Delete("DELETE FROM review WHERE join_class_id = #{joinClassId}")
    int deleteReview(ReviewDelReq req);

    // 학원 관계자가 본인 학원의 리뷰 목록 조회
    List<ReviewDto> getAcademyReviews(long acaId);

    // 학원 상세 페이지에서 학원의 리뷰 목록 조회
    List<ReviewDto> getAcademyReviewsForPublic(long acaId);
}