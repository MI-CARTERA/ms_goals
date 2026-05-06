package com.MiCartera.msgoals.goal.api.dto;

import lombok.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GoalResponse {
  private Long id;
  private Long userId;
  private String name;
  private BigDecimal targetAmount;
  private BigDecimal currentAmount;
  private LocalDate targetDate;
  private String status;
}