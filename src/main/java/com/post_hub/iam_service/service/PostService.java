package com.post_hub.iam_service.service;

import com.post_hub.iam_service.model.dto.Post.PostDto;
import com.post_hub.iam_service.model.response.IamResponse;
import jakarta.validation.constraints.NotNull;

public interface PostService {

    IamResponse<PostDto> getById(@NotNull Integer postId);


}
