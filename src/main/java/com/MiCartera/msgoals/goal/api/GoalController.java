package com.MiCartera.msgoals.goal.api;

import com.MiCartera.msgoals.goal.application.GoalService;
import com.MiCartera.msgoals.goal.api.dto.*;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/goals")
@RequiredArgsConstructor
public class GoalController {

  private final GoalService service;

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public GoalResponse create(@RequestBody @Valid GoalCreateRequest req) {
    return service.create(req);
  }

  @GetMapping
  public List<GoalResponse> list() {
    return service.list();
  }

  @GetMapping("/{id}")
  public GoalResponse get(@PathVariable Long id) {
    return service.get(id);
  }

  @PutMapping("/{id}")
  public GoalResponse update(@PathVariable Long id, @RequestBody @Valid GoalUpdateRequest req) {
    return service.update(id, req);
  }

  @DeleteMapping("/{id}")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void delete(@PathVariable Long id) {
    service.delete(id);
  }
}