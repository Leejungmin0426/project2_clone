package com.green.studybridge.like;

import com.green.studybridge.like.model.AcaDelLikeReq;
import com.green.studybridge.like.model.AcaLikeReq;
import com.green.studybridge.like.model.AcaLikeRes;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LikeService {

    private final LikeMapper mapper;

    // 좋아요 등록
    public AcaLikeRes addLike(AcaLikeReq req) {
        mapper.insertLike(req);

        List<String> pics = mapper.getLikedUserPics(req.getAcaId());
        return new AcaLikeRes(pics, true);
    }

    // 좋아요 삭제
    public AcaLikeRes removeLike(AcaDelLikeReq req) {
        mapper.deleteLike(req);

        List<String> pics = mapper.getLikedUserPics(req.getAcaId());
        return new AcaLikeRes(pics, false);
    }

    // 유저의 좋아요 목록 가져오기
    public List<Long> getUserLikes(long userId) {
        return mapper.getUserLikedAcademies(userId);
    }
}
