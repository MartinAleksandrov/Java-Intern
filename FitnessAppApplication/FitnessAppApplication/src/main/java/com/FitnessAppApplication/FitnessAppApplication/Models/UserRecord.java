package com.FitnessAppApplication.FitnessAppApplication.Models;

import org.springframework.stereotype.Component;

public record UserRecord(Long id,String name, int age, Goal goal) { }