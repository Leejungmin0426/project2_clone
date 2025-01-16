package com.green.studybridge.like.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;


@Data
@AllArgsConstructor
public class AcaLikeRes {

    private List<String> pics;
    private boolean isLiked;
}
