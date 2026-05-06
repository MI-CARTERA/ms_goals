package com.MiCartera.msgoals.goal.application;

import com.MiCartera.msgoals.goal.domain.Goal;
import com.MiCartera.msgoals.goal.infrastructure.GoalRepository;
import com.MiCartera.msgoals.goal.api.dto.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;


import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class GoalService {

  private final GoalRepository repository;

  public GoalResponse create(GoalCreateRequest req) {
    Goal entity = Goal.builder()
      .userId(req.getUserId())
      .name(req.getName())
      .targetAmount(req.getTargetAmount())
      .currentAmount(req.getCurrentAmount())
      .targetDate(req.getTargetDate())
      .status(req.getStatus())
      .build();

    Goal saved = repository.save(entity);
    return toResponse(saved);
  }

  @Transactional(readOnly = true)
  public List<GoalResponse> list() {
    return repository.findAll().stream().map(this::toResponse).toList();
  }

  @Transactional(readOnly = true)
  public GoalResponse get(Long id) {
    Goal e = repository.findById(id)
      .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Goal no encontrado: " + id));
    return toResponse(e);
  }

  public GoalResponse update(Long id, GoalUpdateRequest req) {
    Goal e = repository.findById(id)
      .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Goal no encontrado: " + id));

    e.setUserId(req.getUserId());
    e.setName(req.getName());
    e.setTargetAmount(req.getTargetAmount());
    e.setCurrentAmount(req.getCurrentAmount());
    e.setTargetDate(req.getTargetDate());
    e.setStatus(req.getStatus());

    Goal saved = repository.save(e);
    return toResponse(saved);
  }

  public void delete(Long id) {
    if (!repository.existsById(id)) {
      throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Goal no encontrado: " + id);
    }
    repository.deleteById(id);
  }

  private GoalResponse toResponse(Goal e) {
    return GoalResponse.builder()
      .id(e.getId())
      .userId(e.getUserId())
      .name(e.getName())
      .targetAmount(e.getTargetAmount())
      .currentAmount(e.getCurrentAmount())
      .targetDate(e.getTargetDate())
      .status(e.getStatus())
      .build();
  }
}