package com.mentorat_virtuel.projet_mentorat_virtuel.Service;

import com.mentorat_virtuel.projet_mentorat_virtuel.Entities.FeedBack;

import com.mentorat_virtuel.projet_mentorat_virtuel.Repository.FeedBackRepo;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class FeedBackServiceImp implements FeedBackService {
    public final FeedBackRepo feedBackRepo;

    public FeedBackServiceImp(FeedBackRepo feedBackRepo) {
        this.feedBackRepo = feedBackRepo;
    }


    @Override
    public FeedBack addFeedBack(FeedBack feedBack) {

        return this.feedBackRepo.save(feedBack);
    }

    @Override
    public List<FeedBack> getFeedBack() {
        return this.feedBackRepo.findAll();
    }

    @Override
    public FeedBack getFeedBackById(Integer feedBackId) {
        return this.feedBackRepo.findById(feedBackId).get();
    }

    @Override
    public FeedBack updatedFeedBack(FeedBack feedBack, Integer feedBackId) {
       FeedBack feedBackToEdit= this.feedBackRepo.findById(feedBackId).get();
        feedBackToEdit.setCommentaire(feedBack.getCommentaire());
        feedBackToEdit.setNote(feedBack.getNote());
        feedBackToEdit.setRdv(feedBack.getRdv());
        return this.feedBackRepo.saveAndFlush(feedBackToEdit);
    }

    @Override
    public void deleteFeedBack(Integer feedBackId) {

    }
}
