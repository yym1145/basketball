package server.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import server.service.MatchService;


@RestController
@RequestMapping("/match")
@CrossOrigin
@Slf4j
@RequiredArgsConstructor
@Tag(name = "比赛")
@Validated
public class MatchController {

    private final MatchService matchService;


}
