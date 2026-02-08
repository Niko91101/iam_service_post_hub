package com.post_hub.iam_service.service.Impl;

import com.post_hub.iam_service.mapper.PostMapper;
import com.post_hub.iam_service.model.constants.ApiErrorMessage;
import com.post_hub.iam_service.model.dto.Post.PostDto;
import com.post_hub.iam_service.model.entity.Post;
import com.post_hub.iam_service.model.exception.NotFoundException;
import com.post_hub.iam_service.model.response.IamResponse;
import com.post_hub.iam_service.repositories.PostRepository;
import com.post_hub.iam_service.service.PostService;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PostServiceImpl implements PostService {

    private final PostRepository postRepository;
    private final PostMapper postMapper;

    @Override
    public IamResponse<PostDto> getById(@NotNull Integer postId) {
        Post post = postRepository.findById(postId)
                .orElseThrow(() -> new NotFoundException(ApiErrorMessage.POST_NOT_FOUND_BY_ID.getMessage(postId)));

        PostDto postDto = postMapper.toPostDto(post);

        return IamResponse.createSuccessful(postDto);
    }
}
