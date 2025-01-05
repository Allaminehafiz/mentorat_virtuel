package com.mentorat_virtuel.projet_mentorat_virtuel.Controller;

import com.mentorat_virtuel.projet_mentorat_virtuel.Entities.FeedBack;
import com.mentorat_virtuel.projet_mentorat_virtuel.Service.FeedBackService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class FeedBackController {
    private FeedBackService feedBackService;

    public FeedBackController(FeedBackService feedBackService) {
        this.feedBackService = feedBackService;
    }

    @PostMapping("feedBack/add")
    public ResponseEntity<FeedBack> addFeedBack(@Valid @RequestBody FeedBack feedBack) {
        FeedBack feedBack1 = this.feedBackService.addFeedBack(feedBack);
        return ResponseEntity
                .status(201)
                .body(feedBack1);

    }

    @GetMapping(path = "feedBackById/get_By_Id/{id}")
    public ResponseEntity<FeedBack> getFeedBackById(Integer feedBackId){
            return ResponseEntity
                    .status(200)
                    .

    body(this.feedBackService.getFeedBackById(feedBackId));
}
    @GetMapping(path = "feedBack/get-all")
    public ResponseEntity<List<FeedBack>> getFeedBack(){
        return ResponseEntity
                .status(200)
                .body(this.feedBackService.getFeedBack());

    }
    @PatchMapping(path = "feedBack/update-by-id/{FeedBackId}")
    public ResponseEntity<FeedBack> updateFeedBackById(@PathVariable Integer FeedBackId,@RequestBody FeedBack feedBack ){
        return  ResponseEntity
                .status(202)
                .body(this.feedBackService.updatedFeedBackById(feedBack, FeedBackId));
    }
    @DeleteMapping(path = "feedBack/delete_by_id/{feedBackId}")
    public ResponseEntity<String> deleteFeedBackById(@PathVariable Integer feedBackId){
        this.feedBackService.deleteFeedBack(feedBackId);
        return ResponseEntity
                .status(202)
                .body("Deleted successfully !");
    }
}
