package com.MiCartera.msgoals.goal.domain;

import lombok.*;
import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "goals")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Goal {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private Long userId;
  private String name;
  private BigDecimal targetAmount;
  private BigDecimal currentAmount;
  private LocalDate targetDate;
  private String status;
}