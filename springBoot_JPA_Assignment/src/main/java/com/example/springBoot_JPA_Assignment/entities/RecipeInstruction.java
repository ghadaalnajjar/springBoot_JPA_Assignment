package com.example.springBoot_JPA_Assignment.entities;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class RecipeInstruction {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "com.example.springBoot_JPA_Assignment.entities.RecipeInstruction.UUIDGenerator")
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "recipe_id")
    private String instructionId;
    private String instructions;

    public RecipeInstruction() {
    }

    public RecipeInstruction(String instructions) {
        this.instructions = instructions;
    }

    public RecipeInstruction(String instructionId, String instructions) {
        this.instructionId = instructionId;
        this.instructions = instructions;
    }

    public String getInstructionId() {
        return instructionId;
    }

    public void setInstructionId(String instructionId) {
        this.instructionId = instructionId;
    }

    public String getInstructions() {
        return instructions;
    }

    public void setInstructions(String instructions) {
        instructions = instructions;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof RecipeInstruction)) return false;
        RecipeInstruction that = (RecipeInstruction) o;
        return Objects.equals(instructionId, that.instructionId) &&
                Objects.equals(instructions, that.instructions);
    }

    @Override
    public int hashCode() {
        return Objects.hash(instructionId, instructions);
    }

    @Override
    public String toString() {
        return "RecipeInstruction{" +
                "instructionId='" + instructionId + '\'' +
                ", Instructions='" + instructions + '\'' +
                '}';
    }
}
