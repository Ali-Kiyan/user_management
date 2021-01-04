package com.alikn.demo.user;

import java.time.LocalDate;
import java.util.UUID;

public class UserTopic {
    private final UUID userId;
    private final UUID topicId;
    private final LocalDate subscriptionDate;
    private final Integer rate;
    private final String name;
    private final String description;
    private final String category;

    public UserTopic(UUID userId, UUID topicId, LocalDate subscriptionDate, Integer rate, String name, String description, String category) {
        this.userId = userId;
        this.topicId = topicId;
        this.subscriptionDate = subscriptionDate;
        this.rate = rate;
        this.name = name;
        this.description = description;
        this.category = category;
    }

    public UUID getUserId() {
        return userId;
    }

    public UUID getTopicId() {
        return topicId;
    }

    public LocalDate getSubscriptionDate() {
        return subscriptionDate;
    }

    public Integer getRate() {
        return rate;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getCategory() {
        return category;
    }
}
