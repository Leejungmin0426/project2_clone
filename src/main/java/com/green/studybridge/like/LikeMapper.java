package com.green.studybridge.like;


import com.green.studybridge.like.model.AcaDelLikeReq;
import com.green.studybridge.like.model.AcaLikeReq;
import org.apache.ibatis.annotations.Mapper;


import java.util.List;


@Mapper
public interface LikeMapper {


    // 좋아요 등록
    int insertLike(AcaLikeReq req);

    // 좋아요 삭제
    int deleteLike(AcaDelLikeReq req);

    // 특정 학원의 좋아요를 누른 유저들의 프로필 사진 조회
    List<String> getLikedUserPics(long acaId);

    // 특정 유저가 좋아요한 학원 목록 조회
    List<Long> getUserLikedAcademies(long userId);

}
