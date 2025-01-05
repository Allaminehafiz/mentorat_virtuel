package com.mentorat_virtuel.projet_mentorat_virtuel.Service;

import com.mentorat_virtuel.projet_mentorat_virtuel.Entities.FeedBack;

import java.util.List;

public interface FeedBackService {
    FeedBack addFeedBack(FeedBack feedBack);
    List<FeedBack> getFeedBack();
    FeedBack getFeedBackById(Integer feedBackId);
    FeedBack updatedFeedBackById(FeedBack feedBack, Integer feedBackId);
    void deleteFeedBack(Integer feedBackId);
}
